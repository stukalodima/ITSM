package com.itk.finance.service;

import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.Issue;

public interface IssueService {
    String NAME = "finance_IssueService";

    HotFixRequest createHotFixFromIssue(Issue issue);

    ConsultationRequest createConsultationRequest(Issue issue);
}