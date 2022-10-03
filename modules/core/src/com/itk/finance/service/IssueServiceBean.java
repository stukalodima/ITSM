package com.itk.finance.service;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.*;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.HotFixRequestFile;
import com.itk.finance.entity.Issue;
import com.itk.finance.entity.IssueFile;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(IssueService.NAME)
public class IssueServiceBean implements IssueService {
    @Inject
    private DataManager dataManager;
    @Inject
    private UserPropertyService userPropertyService;
    @Inject
    private Logger log;

    @Override
    public List<StandardEntity> createHotFixFromIssue(Issue issue) {
        List<StandardEntity> listToCommit = new ArrayList<>();
        HotFixRequest hotFixRequest = dataManager.create(HotFixRequest.class);
        listToCommit.add(hotFixRequest);
        hotFixRequest.setBusiness(userPropertyService.getDefaultBusiness());
        hotFixRequest.setCompany(userPropertyService.getDefaultCompany());
        hotFixRequest.setIssue(issue);
        hotFixRequest.setDescription(issue.getDescription());

        List<HotFixRequestFile> hotFixRequestFileList = new ArrayList<>();

        getIssueFileList(issue, getViewForDocument())
                .forEach(issueFile -> {
                    HotFixRequestFile hotFixRequestFile = addFileToList(hotFixRequest,issueFile);
                    hotFixRequestFileList.add(hotFixRequestFile);
                    listToCommit.add(hotFixRequestFile);
                }
                );

        hotFixRequest.setHotFixRequestFiles(hotFixRequestFileList);
        return listToCommit;
    }

    private View getViewForDocument() {
        View view = new View(IssueFile.class);
        view.addProperty("document",ViewBuilder.of(FileDescriptor.class).addView("_minimal").build());
        return view;
    }

    private List<IssueFile> getIssueFileList(Issue issue, View view) {
        return dataManager.load(IssueFile.class)
                .view(view)
                .query("select e from finance_IssueFile e where e.issue = :reqIssue")
                .parameter("reqIssue", issue).list();
    }

    private HotFixRequestFile addFileToList(HotFixRequest hotFixRequest, IssueFile issueFile) {
        HotFixRequestFile hotFixRequestFile = dataManager.create(HotFixRequestFile.class);
        hotFixRequestFile.setDocument(issueFile.getDocument());
        hotFixRequestFile.setHotFixRequest(hotFixRequest);
        return hotFixRequestFile;
    }
}
