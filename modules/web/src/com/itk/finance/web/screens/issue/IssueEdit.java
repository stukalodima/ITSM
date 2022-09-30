package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.security.entity.User;
import com.itk.finance.entity.Issue;
import com.itk.finance.entity.IssueFile;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@UiController("finance_Issue.edit")
@UiDescriptor("issue-edit.xml")
@EditedEntityContainer("issueDc")
@LoadDataBeforeShow
public class IssueEdit extends StandardEditor<Issue> {
    @Inject
    private FileMultiUploadField fileUpload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<IssueFile> issueFilesDc;

    private User currentAutor;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private Table<IssueFile> issueFilesTable;

    @Subscribe
    public void onInit(InitEvent event) {

        FileDownloadHelper.initGeneratedColumn(issueFilesTable, "document");

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
                    throw new RuntimeException(messages.getMessage(IssueEdit.class, "issueEdit.fileUpload.loadError"), e);
                }

                IssueFile issueFile = dataManager.create(IssueFile.class);
                issueFile = dataContext.merge(issueFile);
                issueFile.setIssue(getEditedEntity());
                issueFile.setDocument(fd);
                issueFile.setAuthor(currentAutor);
                List<IssueFile> issueFileList = issueFilesDc.getMutableItems();
                issueFileList.add(issueFile);
            }
            fileUpload.clearUploads();
        });

        fileUpload.addFileUploadErrorListener(fileUploadErrorEvent -> notifications
                .create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(IssueEdit.class, "issueEdit.fileUpload.loadError")).show());
    }
}