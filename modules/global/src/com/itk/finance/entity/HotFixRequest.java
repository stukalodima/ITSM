package com.itk.finance.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "FINANCE_HOT_FIX_REQUEST")
@Entity(name = "finance_HotFixRequest")
@NamePattern("%s %s|number,onDate")
@PublishEntityChangedEvents
public class HotFixRequest extends StandardEntity {
    private static final long serialVersionUID = 8831658319149966013L;
    @Column(name = "NUMBER")
    private String number;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date onDate;
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ISSUE_ID")
    private Issue issue;
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
    @Column(name = "DESCRIPTION")
    private String description;
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTOR_ID")
    private User executor;
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;
    @PostConstruct
    public void initEntity (Metadata metadata){
        TimeSource timeSource = AppBeans.get(TimeSource.class);
                onDate = timeSource.currentTimestamp();
   }
   @Composition
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotFixRequest")
   private List<HotFixRequestFile> hotFixRequestFiles;

    public List<HotFixRequestFile> getHotFixRequestFiles() {
        return hotFixRequestFiles;
    }

    public void setHotFixRequestFiles(List<HotFixRequestFile> hotFixRequestFiles) {
        this.hotFixRequestFiles = hotFixRequestFiles;
    }

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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}