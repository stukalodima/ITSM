package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Issue;

@UiController("finance_Issue.edit")
@UiDescriptor("issue-edit.xml")
@EditedEntityContainer("issueDc")
@LoadDataBeforeShow
public class IssueEdit extends StandardEditor<Issue> {
}