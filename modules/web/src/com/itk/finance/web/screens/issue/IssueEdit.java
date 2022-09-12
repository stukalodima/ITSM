package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
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
                    throw new RuntimeException(messages.getMessage(IssueEdit.class, "issueEdit.fileUpload.loadError"), e);
                }

                IssueFile issueFile = dataManager.create(IssueFile.class);
                issueFile = dataContext.merge(issueFile);
                issueFile.setIssue(getEditedEntity());
                issueFile.setDocument(fd);
                List<IssueFile> issueFileList = issueFilesDc.getMutableItems();
                issueFileList.add(issueFile);
            }

            fileUpload.clearUploads();
        });

        fileUpload.addFileUploadErrorListener(queueFileUploadErrorEvent -> notifications.create()
                .withCaption("File upload error")
                .show());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
       //commitChanges()
    }
}