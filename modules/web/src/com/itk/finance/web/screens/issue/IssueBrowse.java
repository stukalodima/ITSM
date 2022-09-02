package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Issue;

@UiController("finance_Issue.browse")
@UiDescriptor("issue-browse.xml")
@LookupComponent("issuesTable")
@LoadDataBeforeShow
public class IssueBrowse extends StandardLookup<Issue> {
}