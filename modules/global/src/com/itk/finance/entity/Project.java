package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "FINANCE_PROJECT")
@Entity(name = "finance_Project")
@NamePattern("%s|name")
public class Project extends StandardEntity {
    private static final long serialVersionUID = -5158221038190091896L;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "PARENT_ID")
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Project pid;

    @Column(name = "NOT_RELEVANT")
    private Boolean notRelevant;

    @Column(name = "SHUT")
    private Boolean shut;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    private User manager;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNotRelevant() {
        return notRelevant;
    }

    public void setNotRelevant(Boolean notRelevant) {
        this.notRelevant = notRelevant;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getPid() {
        return pid;
    }

    public void setPid(Project pid) {
        this.pid = pid;
    }

    public Boolean getShut() {
        return shut;
    }

    public void setShut(Boolean shut) {
        this.shut = shut;
    }
}