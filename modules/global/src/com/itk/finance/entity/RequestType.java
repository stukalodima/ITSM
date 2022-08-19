package com.itk.finance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum RequestType implements EnumClass<String> {

    ERROR("ERROR"),
    CONSULTATION("CONSULTATION"),
    CHANGE_REQUEST("CHANGE_REQUEST"),
    INCIDENT("INCIDENT"),
    PROJECT_APPLICATION("PROJECT_APPLICATION"),
    REQUEST_CHANGE_DATA("REQUEST_CHANGE_DATA"),
    REQUEST_ACCESS_RIGHTS("REQUEST_ACCESS_RIGHTS")
    ;

    private final String id;

    RequestType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static RequestType fromId(String id) {
        for (RequestType at : RequestType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}