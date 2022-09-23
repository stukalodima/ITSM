package com.itk.finance.service;

import com.haulmont.cuba.core.global.DataManager;
import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.Issue;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(IssueService.NAME)
public class IssueServiceBean implements IssueService {
    @Inject
    private DataManager dataManager;
    @Inject
    private UserPropertyService userPropertyService;

    @Override
    public HotFixRequest createHotFixFromIssue(Issue issue) {
        HotFixRequest hotFixRequest = dataManager.create(HotFixRequest.class);
        hotFixRequest.setBusiness(userPropertyService.getDefaultBusiness());
        hotFixRequest.setCompany(userPropertyService.getDefaultCompany());
        hotFixRequest.setIssue(issue);
        hotFixRequest.setDescription(issue.getDescription());

        return hotFixRequest;
    }

    @Override
    public ConsultationRequest createConsultationRequest(Issue issue) {
        ConsultationRequest consultationRequest = dataManager.create(ConsultationRequest.class);
        consultationRequest.setBusiness(userPropertyService.getDefaultBusiness());
        consultationRequest.setCompany(userPropertyService.getDefaultCompany());
        consultationRequest.setIssue(issue);
        consultationRequest.setTopic(issue.getTopic());
        consultationRequest.setDescription(issue.getDescription());

        return consultationRequest;
    }
}