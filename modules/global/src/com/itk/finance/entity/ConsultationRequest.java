package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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

    @JoinColumn(name = "EXECUTOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User executor;

    @Lob
    @Column(name = "DETAILED_DESCRIPTION")
    protected String detailedDescription;

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

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    @PostConstruct
    public void initEntity() {
        TimeSource timeSource = AppBeans.get(TimeSource.class);
        onDate = timeSource.currentTimestamp();
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
        author = userSessionSource.getUserSession().getUser();
    }
}