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
@Table(name = "FINANCE_ISSUE")
@Entity(name = "finance_Issue")
@NamePattern("%s %s|onDate,number")
public class Issue extends StandardEntity {
    private static final long serialVersionUID = -2476676865281350898L;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "ON_DATE")
    private Date onDate;

    @NotNull
    @Column(name = "NUMBER")
    private String number;

    @Column(name = "TOPIC")
    @Lob
    private String topic;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @Composition
    @OneToMany(mappedBy = "issue")
    private List<IssueFile> issueFiles;

    public List<IssueFile> getIssueFiles() {
        return issueFiles;
    }

    public void setIssueFiles(List<IssueFile> issueFiles) {
        this.issueFiles = issueFiles;
    }

    public Date getOnDate() {
        return onDate;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @PostConstruct
    public void init() {
        this.onDate = AppBeans.get(TimeSource.class).currentTimestamp();
        this.author = AppBeans.get(UserSessionSource.class).getUserSession().getUser();
    }

}