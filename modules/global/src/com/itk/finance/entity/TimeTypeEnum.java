package com.itk.finance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TimeTypeEnum implements EnumClass<String> {

    PLANNED("PLANNED"),
    ACTUAL("ACTUAL");

    private final String id;

    TimeTypeEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TimeTypeEnum fromId(String id) {
        for (TimeTypeEnum at : TimeTypeEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}