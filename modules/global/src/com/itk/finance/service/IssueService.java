package com.itk.finance.service;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.itk.finance.entity.HotFixRequest;
import com.itk.finance.entity.Issue;

import java.util.List;

public interface IssueService {
    String NAME = "finance_IssueService";

    List<StandardEntity> createHotFixFromIssue(Issue issue);
}