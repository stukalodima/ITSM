package com.itk.finance.listeners;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.app.events.EntityPersistingEvent;
import com.itk.finance.entity.ConsultationRequest;

import java.util.UUID;

import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;

@Component("finance_ConsultationRequestChangedListener")
public class ConsultationRequestChangedListener {

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    @EventListener
    public void onConsultationRequestBeforePersist(EntityPersistingEvent<ConsultationRequest> event) {
        event.getEntity().setNumber(Long.toString(uniqueNumbersAPI.getNextNumber(event.getEntity().getClass().getSimpleName())));
    }
}