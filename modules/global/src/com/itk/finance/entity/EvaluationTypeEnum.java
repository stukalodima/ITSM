package com.itk.finance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EvaluationTypeEnum implements EnumClass<String> {

    IMPLEMENTATION("IMPLEMENTATION"),
    ADDITIONAL_STUDY("ADDITIONAL_STUDY"),
    BUSINESS_ANALYSIS("BUSINESS_ANALYSIS"),
    DEVELOPMENT("DEVELOPMENT"),
    TESTING("TESTING"),
    DOCUMENTATION("DOCUMENTATION");
    private String id;

    EvaluationTypeEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EvaluationTypeEnum fromId(String id) {
        for (EvaluationTypeEnum at : EvaluationTypeEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}