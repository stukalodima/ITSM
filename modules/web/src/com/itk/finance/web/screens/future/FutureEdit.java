package com.itk.finance.web.screens.future;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.app.core.file.MultiUploader;
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
import groovyjarjarpicocli.CommandLine;
import sun.security.mscapi.CPublicKey;

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
    private Screens screens;
    @Inject
    private DataManager dataManager;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<FutureFile> futureFileDc;

    private User currentAutor;
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
    private LookupPickerField<Company> companyIDField;
    @Inject
    private LookupPickerField<Asset> assetIDField;

    @Subscribe("companyIDField.lookup")
    public void onCompanyIDFieldLookup(Action.ActionPerformedEvent event) {
        CompanyBrowse companyBrowse = screenBuilders.lookup(companyIDField)
                .withScreenClass(CompanyBrowse.class)
                .build();
        companyBrowse.setBusiness(getEditedEntity().getBusinessID());
        companyBrowse.show();
    }

    @Subscribe("businessIDField")
    public void onBusinessIDFieldValueChange(HasValue.ValueChangeEvent<Business> event) {
        if (event.isUserOriginated()) {
            getEditedEntity().setCompanyID(null);
            getEditedEntity().setAssetID(null);
            getEditedEntity().setProjectID(null);
        }
    }

    @Subscribe("companyIDField")
    public void onCompanyIDFieldValueChange(HasValue.ValueChangeEvent<Company> event) {
        if(event.isUserOriginated()){
            getEditedEntity().setAssetID(null);
            getEditedEntity().setProjectID(null);
        }
    }

    @Subscribe("assetIDField.lookup")
    public void onAssetIDFieldLookup(Action.ActionPerformedEvent event) {
        AssetBrowse assetBrowse = screenBuilders.lookup(assetIDField)
                .withScreenClass(AssetBrowse.class)
                .build();
        assetBrowse.setCompany(getEditedEntity().getCompanyID());
        assetBrowse.show();
    }

    @Subscribe
    public void onInit(InitEvent event) {
        FileDownloadHelper.initGeneratedColumn(futureFilesTable, "document");

        currentAutor = userSessionSource.getUserSession().getUser();

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
                futureFile.setAuthor(currentAutor);
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