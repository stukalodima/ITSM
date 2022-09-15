package com.itk.finance.web.screens.issuefile;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.IssueFile;

@UiController("finance_IssueFile.edit")
@UiDescriptor("issue-file-edit.xml")
@EditedEntityContainer("issueFileDc")
@LoadDataBeforeShow
public class IssueFileEdit extends StandardEditor<IssueFile> {
}