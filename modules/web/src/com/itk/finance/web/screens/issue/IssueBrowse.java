package com.itk.finance.web.screens.issue;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.Issue;
import com.itk.finance.service.IssueService;
import com.itk.finance.web.screens.hotfixrequest.HotFixRequestEdit;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
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
            showNotificationIfSetEmpty();
            return;
        }
        issueSet.forEach(issue -> {
            List<StandardEntity> list = issueService.createHotFixFromIssue(issue);
            HotFixRequestEdit screen = screenBuilders.editor(HotFixRequest.class, this)
                    .newEntity((HotFixRequest) Objects.requireNonNull(
                            list.stream().findFirst().filter(
                                    standardEntity -> standardEntity instanceof HotFixRequest).orElse(null)
                            )
                    )
                    .withScreenClass(HotFixRequestEdit.class)
                    .build();
            screen.setDataContext(list);
            screen.show();
        });

    }

    @Subscribe("createRequestPopup.createConsultationRequest")
    public void onCreateRequestPopupCreateConsultationRequest(Action.ActionPerformedEvent event) {
        Set<Issue> issueSet = issuesTable.getSelected();
        if(issueSet.isEmpty()){
            showNotificationIfSetEmpty();
            return;
        }
        issueSet.forEach(issue -> {
            ConsultationRequest consultationRequest = issueService.createConsultationRequest(issue);
            screenBuilders.editor(ConsultationRequest.class, this).editEntity(consultationRequest).build().show();
        });
    }

    private void showNotificationIfSetEmpty() {
        notifications.create().withCaption("???? ?????????????? ??????????????????").withDescription("?????????????? ??????????????????!").show();
    }

}