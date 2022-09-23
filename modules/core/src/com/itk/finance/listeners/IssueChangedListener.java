package com.itk.finance.listeners;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.itk.finance.entity.Issue;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.app.events.EntityPersistingEvent;
import org.springframework.context.event.EventListener;
import javax.inject.Inject;

@Component("finance_IssueChangedListener")
public class IssueChangedListener {

    @Inject
    private UniqueNumbersAPI uniqueNumbersAPI;

    @EventListener
    public void beforePersist(EntityPersistingEvent<Issue> event) {
        event.getEntity().setNumber(String.valueOf(uniqueNumbersAPI.getNextNumber(event.getEntity().getClass().getSimpleName())));
    }
}