package com.itk.finance.web.screens.future;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.app.core.file.MultiUploader;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.util.OperationResult;
import com.itk.finance.entity.Future;
import com.itk.finance.entity.FutureFile;
import com.itk.finance.entity.IssueFile;
import com.haulmont.cuba.security.entity.User;
import com.itk.finance.web.screens.issue.IssueEdit;

import javax.inject.Inject;
import java.util.List;

@UiController("finance_Future.edit")
@UiDescriptor("future-edit.xml")
@EditedEntityContainer("futureDc")
@LoadDataBeforeShow
public class FutureEdit extends StandardEditor<Future> {
    @Inject
    private EntityStates entityStates;
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
    private Dialogs dialogs;
    @Inject
    private Messages messages;

        private void showUploadDialog() {
            MultiUploader dialog = (MultiUploader) screens.create("multiuploadDialog", OpenMode.DIALOG);
            dialog.addAfterCloseListener(e ->
            {
                if (((StandardCloseAction) e.getCloseAction()).getActionId().equals("commit")) {
                    dialog.getFiles().forEach(fd ->
                    {
                        FutureFile futureFile = dataManager.create(FutureFile.class);

                        futureFile = dataContext.merge(futureFile);

                        futureFile.setFuture(getEditedEntity());
                        futureFile.setDocument(fd);
                        futureFile.setAuthor(currentAutor);

                        List<FutureFile> futureFileList = futureFileDc.getMutableItems();
                        futureFileList.add(futureFile);
                    });

                }
            });
            screens.show(dialog);
        }
}