package com.itk.finance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;

@Table(name = "FINANCE_CONSULTATION_REQUEST_FILE")
@Entity(name = "finance_ConsultationRequestFile")
@NamePattern("%s|document")
public class ConsultationRequestFile extends StandardEntity {
    private static final long serialVersionUID = -1738796512908750820L;

    @JoinColumn(name = "DOCUMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FileDescriptor document;

    @JoinColumn(name = "CONSULTATION_REQUEST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsultationRequest consultationRequest;

    @JoinColumn(name = "AUTHOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    public FileDescriptor getDocument() {
        return document;
    }

    public void setDocument(FileDescriptor document) {
        this.document = document;
    }

    public ConsultationRequest getConsultationRequest() {
        return consultationRequest;
    }

    public void setConsultationRequest(ConsultationRequest consultationRequest) {
        this.consultationRequest = consultationRequest;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}