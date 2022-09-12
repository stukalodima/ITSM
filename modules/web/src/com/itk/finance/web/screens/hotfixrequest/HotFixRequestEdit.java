package com.itk.finance.web.screens.hotfixrequest;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.itk.finance.entity.*;
import com.itk.finance.web.screens.hotfixrequest.HotFixRequestEdit;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@UiController("finance_HotFixRequest.edit")
@UiDescriptor("hot-fix-request-edit.xml")
@EditedEntityContainer("hotFixRequestDc")
@LoadDataBeforeShow
public class HotFixRequestEdit extends StandardEditor<HotFixRequest> {

    @Inject
    private CollectionLoader<Business> businessesDl;
    @Inject
    private CollectionLoader<Company> companiesDl;
    @Inject
    private LookupPickerField<Business> businessField;
    @Inject
    private EntityStates entityStates;

    @Inject
    private LookupPickerField<Company> companyField;
    @Inject
    private TextField<Long> numberField;
    @Inject
    private UniqueNumbersService uniqueNumbersService;
    @Inject
    private FileMultiUploadField fileUpload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataContext dataContext;
    @Inject
    private DataManager dataManager;
    @Inject
    private Messages messages;
    @Inject
    private CollectionPropertyContainer<HotFixRequestFile> hotFixRequestFilesDc;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        businessesDl.load();
        refreshForm();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        refreshForm();
    }

    private void refreshForm() {
        companiesDl.setParameter("business", businessField.getValue());
        companiesDl.load();
    }

    @Subscribe("businessField")
    public void onBusinessFieldValueChange(HasValue.ValueChangeEvent<Business> event) {
        if (event.isUserOriginated()) {
            if (!Objects.isNull(companyField.getValue()) && !Objects.equals(companyField.getValue().getBusiness(), event.getValue())) {
                companyField.setValue(companyField.getEmptyValue());
            }
            refreshForm();
        }
    }

    @Subscribe
    public void onInit(InitEvent event) {
        fileUpload.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {

            for (Map.Entry<UUID, String> entry : fileUpload.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                if( fd == null){
                    continue;
                }
                fd = dataContext.merge(fd);
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    throw new RuntimeException(messages.getMessage(HotFixRequestEdit.class, "hotFixRequestEdit.fileUpload.loadError"), e);
                }

                HotFixRequestFile hotFixRequestFile = dataManager.create(HotFixRequestFile.class);
                hotFixRequestFile = dataContext.merge(hotFixRequestFile);
                hotFixRequestFile.setHotFixRequest(getEditedEntity());
                hotFixRequestFile.setDocument(fd);
                List<HotFixRequestFile> hotFixRequestFileList = hotFixRequestFilesDc.getMutableItems();
                hotFixRequestFileList.add(hotFixRequestFile);
            }

            fileUpload.clearUploads();
        });

        fileUpload.addFileUploadErrorListener(queueFileUploadErrorEvent -> notifications.create()
                .withCaption("File upload error")
                .show());
    }


}
