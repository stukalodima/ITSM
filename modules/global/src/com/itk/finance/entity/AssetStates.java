package com.itk.finance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AssetStates implements EnumClass<String> {

    FORBIDDEN("FORBIDDEN"), PLANNED("PLANNED"), IN_OPERATION("IN_OPERATION"), REPAIRS("REPAIRS"), DECOMMISSIONING("DECOMMISSIONING");

    private String id;

    AssetStates(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AssetStates fromId(String id) {
        for (AssetStates at : AssetStates.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}