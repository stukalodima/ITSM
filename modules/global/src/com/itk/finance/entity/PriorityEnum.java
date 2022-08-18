package com.itk.finance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PriorityEnum implements EnumClass<String> {

    HIGH("HIGH"),
    MIDDLE("MIDDLE"),
    LOW("LOW");

    private String id;

    PriorityEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PriorityEnum fromId(String id) {
        for (PriorityEnum at : PriorityEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}