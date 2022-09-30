package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "FINANCE_HOT_FIX_REQUEST_FILE")
@Entity(name = "finance_HotFixRequestFile")
@NamePattern("%s|document")
public class HotFixRequestFile extends StandardEntity {
    private static final long serialVersionUID = 7934114763270049975L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID")
    private FileDescriptor document;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOT_FIX_REQUEST_ID")
    private HotFixRequest hotFixRequest;

    public FileDescriptor getDocument() {
        return document;
    }

    public void setDocument(FileDescriptor document) {
        this.document = document;
    }

    public HotFixRequest getHotFixRequest() {
        return hotFixRequest;
    }

    public void setHotFixRequest(HotFixRequest hotFixRequest) {
        this.hotFixRequest = hotFixRequest;
    }
}