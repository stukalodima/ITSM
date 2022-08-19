package com.itk.finance.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "FINANCE_ASSET")
@Entity(name = "finance_Asset")
public class Asset extends StandardEntity {
    private static final long serialVersionUID = -5651140306752589601L;

    @NotNull
    @Column(name = "SHORT_NAME", nullable = false)
    private String shortName;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPONSIBLE_IT")
    private User responsible_it;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPONSIBLE_BUSINESS")
    private User responsible_business;

    @Column(name = "COMMISSIONING_DATE")
    private Date commissioning_date;

    @Column(name = "EXPIRY_DATE")
    private Date expiry_date;


    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "INITIAL_COST")
    private Float initial_cost;


    @Column(name = "RESIDUAL_COST")
    private Float residual_cost;

    @Column(name = "ASSET_STATES")
    private AssetStates assetStates;

    @Column(name = "COMMENT")
    private String comment;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getResponsible_it() {
        return responsible_it;
    }

    public void setResponsible_it(User responsible_it) {
        this.responsible_it = responsible_it;
    }

    public User getResponsible_business() {
        return responsible_business;
    }

    public void setResponsible_business(User responsible_business) {
        this.responsible_business = responsible_business;
    }

    public Date getCommissioning_date() {
        return commissioning_date;
    }

    public void setCommissioning_date(Date commissioning_date) {
        this.commissioning_date = commissioning_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Float getInitial_cost() {
        return initial_cost;
    }

    public void setInitial_cost(Float initial_cost) {
        this.initial_cost = initial_cost;
    }

    public Float getResidual_cost() {
        return residual_cost;
    }

    public void setResidual_cost(Float residual_cost) {
        this.residual_cost = residual_cost;
    }

    public AssetStates getAssetStates() {
        return assetStates;
    }

    public void setAssetStates(AssetStates assetStates) {
        this.assetStates = assetStates;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}