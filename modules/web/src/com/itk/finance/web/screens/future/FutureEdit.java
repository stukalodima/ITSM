package com.itk.finance.web.screens.future;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.itk.finance.entity.*;
import com.haulmont.cuba.security.entity.User;
import com.itk.finance.web.screens.asset.AssetBrowse;
import com.itk.finance.web.screens.company.CompanyBrowse;
import com.itk.finance.web.screens.issue.IssueEdit;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@UiController("finance_Future.edit")
@UiDescriptor("future-edit.xml")
@EditedEntityContainer("futureDc")
@LoadDataBeforeShow
public class FutureEdit extends StandardEditor<Future> {
    @Inject
    private DataManager dataManager;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<FutureFile> futureFileDc;

    private User currentAuthor;
    @Inject
    private Messages messages;
    @Inject
    private Table<FutureFile> futureFilesTable;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private FileMultiUploadField fileUpload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private LookupPickerField<Company> companyField;
    @Inject
    private LookupPickerField<Asset> assetField;

    @Subscribe("companyField.lookup")
    public void onCompanyFieldLookup(Action.ActionPerformedEvent event) {
        CompanyBrowse companyBrowse = screenBuilders.lookup(companyField)
                .withScreenClass(CompanyBrowse.class)
                .build();
        companyBrowse.setBusiness(getEditedEntity().getBusiness());
        companyBrowse.show();
    }

    @Subscribe("companyField")
    public void onCompanyFieldValueChange(HasValue.ValueChangeEvent<Company> event) {
        if(event.isUserOriginated()){
            getEditedEntity().setAsset(null);
            getEditedEntity().setProject(null);
        }
    }

    @Subscribe("businessField")
    public void onBusinessFieldValueChange(HasValue.ValueChangeEvent<Business> event) {
        if (event.isUserOriginated()) {
            getEditedEntity().setCompany(null);
            getEditedEntity().setAsset(null);
            getEditedEntity().setProject(null);
        }
    }

    @Subscribe("assetField.lookup")
    public void onAssetFieldLookup(Action.ActionPerformedEvent event) {
        AssetBrowse assetBrowse = screenBuilders.lookup(assetField)
                .withScreenClass(AssetBrowse.class)
                .build();
        assetBrowse.setCompany(getEditedEntity().getCompany());
        assetBrowse.show();
    }

    @Subscribe
    public void onInit(InitEvent event) {
        FileDownloadHelper.initGeneratedColumn(futureFilesTable, "document");

        currentAuthor = userSessionSource.getUserSession().getUser();

        fileUpload.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {
            for (Map.Entry<UUID, String> entry : fileUpload.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                if (fd == null) {
                    continue;
                }
                fd = dataContext.merge(fd);
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    throw new RuntimeException(messages.getMessage(IssueEdit.class, "futureEdit.fileUpload.loadError"), e);
                }

                FutureFile futureFile = dataManager.create(FutureFile.class);
                futureFile = dataContext.merge(futureFile);
                futureFile.setFuture(getEditedEntity());
                futureFile.setDocument(fd);
                futureFile.setAuthor(currentAuthor);
                List<FutureFile> futureFileList = futureFileDc.getMutableItems();
                futureFileList.add(futureFile);
            }
            fileUpload.clearUploads();
        });

        fileUpload.addFileUploadErrorListener(fileUploadErrorEvent -> notifications
                .create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(IssueEdit.class, "futureEdit.fileUpload.loadError")).show());
    }

    
}