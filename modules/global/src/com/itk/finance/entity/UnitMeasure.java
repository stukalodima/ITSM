package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "FINANCE_UNIT_MEASURE")
@Entity(name = "finance_UnitMeasure")
@NamePattern("%s|name")
public class UnitMeasure extends StandardEntity {
    private static final long serialVersionUID = -3007354385846245272L;

    @NotNull
    @Column(name = "NAME", length = 25, nullable = false)
    private String name;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}