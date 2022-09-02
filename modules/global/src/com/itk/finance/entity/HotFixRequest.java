package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Table(name = "FINANCE_HOT_FIX_REQUEST")
@Entity(name = "finance_HotFixRequest")
@NamePattern("%s %s|number,date")

public class HotFixRequest extends StandardEntity {
    private static final long serialVersionUID = 8831658319149966013L;

    @NotNull
    @Column(name = "NUMBER")
    private String number;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;

//    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "APPEAL_ID")
//    private APPEAL appeal;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_ID")
    private Business business;

    @Lob
    @Column(name = "ADDITIONAL_DESCRIPTION")
    private String additionalDescription;


//    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "STATUS_ID")
//    private Statuses status;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTOR_ID")
    private User executor;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;


//    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "EXECUTION_STATE_ID")
//    private ExecutionState executionState;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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



    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }
}