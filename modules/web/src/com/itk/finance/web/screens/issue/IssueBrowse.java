package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.Issue;
import com.itk.finance.service.IssueService;

import javax.inject.Inject;
import java.util.Set;

@UiController("finance_Issue.browse")
@UiDescriptor("issue-browse.xml")
@LookupComponent("issuesTable")
@LoadDataBeforeShow
public class IssueBrowse extends StandardLookup<Issue> {
    @Inject
    private GroupTable<Issue> issuesTable;
    @Inject
    private IssueService issueService;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Notifications notifications;

    @Subscribe("createRequestPopup.createHotFix")
    public void onCreateRequestPopupCreateHotFix(Action.ActionPerformedEvent event) {
        Set<Issue> issueSet = issuesTable.getSelected();
        if (issueSet.isEmpty()) {
            notifications.create().withCaption("Не выбрано обращение").withDescription("Выберите обращение!").show();
            return;
        }
        issueSet.forEach(issue -> {
            HotFixRequest hotFixRequest = issueService.createHotFixFromIssue(issue);
            screenBuilders.editor(HotFixRequest.class, this).editEntity(hotFixRequest).build().show();
        });

    }

}