package com.itk.finance.web.screens.consultationrequest;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.security.entity.User;
import com.itk.finance.entity.*;
import com.itk.finance.web.screens.issue.IssueEdit;

import javax.inject.Inject;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@UiController("finance_ConsultationRequest.edit")
@UiDescriptor("consultation-request-edit.xml")
@EditedEntityContainer("consultationRequestDc")
@LoadDataBeforeShow
public class ConsultationRequestEdit extends StandardEditor<ConsultationRequest> {
    @Inject
    private CollectionLoader<Company> companiesDl;
    @Inject
    private LookupPickerField<Business> businessField;
    @Inject
    private CollectionLoader<Business> businessesDl;
    @Inject
    private LookupPickerField<Company> companyField;
    @Inject
    private EntityStates entityStates;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private FileMultiUploadField fileUploadBtn;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataContext dataContext;
    @Inject
    private Messages messages;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionPropertyContainer<ConsultationRequestFile> consultationRequestFilesDc;
    @Inject
    private Table<ConsultationRequestFile> consultationRequestFilesTable;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        businessesDl.load();
        refreshForm();
        if (entityStates.isNew(getEditedEntity())){
        }
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
//        if (entityStates.isNew(getEditedEntity()) || Objects.isNull(numberField.getValue()) || numberField.getValue().isEmpty()) {
//            long newNumber = uniqueNumbersService.getNextNumber(ConsultationRequest.class.getSimpleName());
//            getEditedEntity().setNumber(Long.toString(newNumber));
//            event.resume();
//        }
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

    @Subscribe("companyField")
    public void onCompanyFieldFieldValueChange(HasValue.ValueChangeEvent<Company> event) {
        if (event.isUserOriginated()) {
            if (!Objects.isNull(companyField.getValue()) && !Objects.equals(businessField.getValue(), companyField.getValue().getBusiness())) {
                businessField.setValue(companyField.getValue().getBusiness());
            }
            refreshForm();
        }
    }

    public void addNewHotFixRequest() {
        TimeSource timeSource = AppBeans.get(TimeSource.class);

        Screen newIssuesScreen = screenBuilders.editor(HotFixRequest.class, this)
                .newEntity()
                .withInitializer(issue -> {
                    issue.setOnDate(timeSource.currentTimestamp());
                    issue.setBusiness(getEditedEntity().getBusiness());
                    issue.setCompany(getEditedEntity().getCompany());
                    issue.setDescription(getEditedEntity().getDescription());
                })
                .withLaunchMode(OpenMode.DIALOG)
                .build();
        newIssuesScreen.show();
    }

    @Subscribe
    public void onInit(InitEvent event) {

        FileDownloadHelper.initGeneratedColumn(consultationRequestFilesTable, "document");

        User currentAuthor = userSessionSource.getUserSession().getUser();

        fileUploadBtn.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {
            for (Map.Entry<UUID, String> entry : fileUploadBtn.getUploadsMap().entrySet()) {
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
                    throw new RuntimeException(messages.getMessage(IssueEdit.class, "consultationRequestEdit.fileUploadBtn.loadError"), e);
                }

                ConsultationRequestFile consultationRequestFile = dataManager.create(ConsultationRequestFile.class);
                consultationRequestFile = dataContext.merge(consultationRequestFile);
                consultationRequestFile.setConsultationRequest(getEditedEntity());
                consultationRequestFile.setDocument(fd);
                consultationRequestFile.setAuthor(currentAuthor);
                consultationRequestFilesDc.getMutableItems().add(consultationRequestFile);
            }
            fileUploadBtn.clearUploads();
        });

        fileUploadBtn.addFileUploadErrorListener(fileUploadErrorEvent -> notifications
                .create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(IssueEdit.class, "issueEdit.fileUpload.loadError")).show());
    }
}