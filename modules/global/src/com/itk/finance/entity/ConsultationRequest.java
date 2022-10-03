package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "FINANCE_CONSULTATION_REQUEST")
@Entity(name = "finance_ConsultationRequest")
@NamePattern("%s %s |number,onDate")
public class ConsultationRequest extends StandardEntity {
    private static final long serialVersionUID = 2470526716149684613L;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "ON_DATE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date onDate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @JoinColumn(name = "BUSINESS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Business business;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Company company;

    @JoinColumn(name = "AUTHOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User author;

    @JoinColumn(name = "ASSIGNED_TO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User assignedTo;

    @Lob
    @Column(name = "TOPIC")
    private String topic;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @JoinColumn(name = "ISSUE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "PROJECT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Lookup(type = LookupType.DROPDOWN, actions = "lookup, open, clear")
    private Project project;

    @JoinColumn(name = "ASSET_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Lookup(type = LookupType.DROPDOWN, actions = "lookup, open, clear")
    private Asset asset;

    @Composition
    @OneToMany(mappedBy = "consultationRequest")
    private List<ConsultationRequestFile> consultationRequestFiles;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public List<ConsultationRequestFile> getConsultationRequestFiles() {
        return consultationRequestFiles;
    }

    public void setConsultationRequestFiles(List<ConsultationRequestFile> consultationRequestFiles) {
        this.consultationRequestFiles = consultationRequestFiles;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @PostConstruct
    public void initEntity() {
        TimeSource timeSource = AppBeans.get(TimeSource.class);
        onDate = timeSource.currentTimestamp();
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
        author = userSessionSource.getUserSession().getUser();
    }

}