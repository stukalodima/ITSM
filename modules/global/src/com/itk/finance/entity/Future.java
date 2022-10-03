package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@PublishEntityChangedEvents
@Table(name = "FINANCE_FUTURE")
@Entity(name = "finance_Future")
@NamePattern("#getCaption|onDate, number")
public class Future extends StandardEntity {
    private static final long serialVersionUID = 6135071481727526548L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ON_DATE")
    @NotNull
    private Date onDate;

    @NotNull
    @Column(name = "NUMBER")
    private String number;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID")
    private Issue issue;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_ID")
    private Business business;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "TIME_ESTIMATE")
    private Double timeEstimate;

    @Temporal(TemporalType.DATE)
    @Column(name = "PLAN_DATE")
    private Date planDate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private Statuses status;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMPLEMENTER_ID")
    private User implementer;

    @Composition
    @OneToMany(mappedBy = "future")
    private List<FutureFile> futureFileList;

    @Temporal(TemporalType.DATE)
    @Column(name = "EMPLOYMANT_DATE")
    private Date employmentDate;

    public Date getOnDate() {
        return onDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Double timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public User getImplementer() {
        return implementer;
    }

    public List<FutureFile> getFutureFileList() {
        return futureFileList;
    }

    public void setFutureFileList(List<FutureFile> futureFileList) {
        this.futureFileList = futureFileList;
    }

    public void setImplementer(User implementer) {
        this.implementer = implementer;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    @PostConstruct
    public void init(){
        this.onDate = AppBeans.get(TimeSource.class).currentTimestamp();
    }

    public String getCaption(){
        Messages messages = AppBeans.get(Messages.class);

        String messageName = messages.getMessage(Future.class, "Future.Name");
        String messageNumber = Objects.isNull(this.number) ? "" : this.number;

        DateFormat format = new SimpleDateFormat("dd.MM.yyy");
        String messageDate = Objects.isNull(this.onDate) ? "" : format.format(this.onDate);
        return messages.formatMessage(Future.class, "Future.PatternFutureName",
                messageName, messageNumber, messageDate);
    }
}