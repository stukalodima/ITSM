package com.itk.finance.web.screens.consultationrequest;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.settings.Settings;
import com.itk.finance.entity.*;

import javax.inject.Inject;
import java.util.Objects;

@UiController("finance_ConsultationRequest.edit")
@UiDescriptor("consultation-request-edit.xml")
@EditedEntityContainer("consultationRequestDc")
@LoadDataBeforeShow
public class ConsultationRequestEdit extends StandardEditor<ConsultationRequest> {
    @Inject
    private CollectionLoader<Company> companiesDl;
    @Inject
    private LookupPickerField<Business> businessField;
    @Inject
    private CollectionLoader<Business> businessesDl;
    @Inject
    private LookupPickerField<Company> companyField;
    @Inject
    private EntityStates entityStates;
    @Inject
    private UniqueNumbersService uniqueNumbersService;
    @Inject
    private TextField<String> numberField;
    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        businessesDl.load();
        refreshForm();
        if (entityStates.isNew(getEditedEntity())){
        }
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (entityStates.isNew(getEditedEntity()) || Objects.isNull(numberField.getValue()) || numberField.getValue().isEmpty()) {
            long newNumber = uniqueNumbersService.getNextNumber(ConsultationRequest.class.getSimpleName());
            getEditedEntity().setNumber(Long.toString(newNumber));
            event.resume();
        }
    }

    private void refreshForm() {
        companiesDl.setParameter("business", businessField.getValue());
        companiesDl.load();
    }

    @Subscribe("businessField")
    public void onBusinessFieldValueChange(HasValue.ValueChangeEvent<Business> event) {
        if (event.isUserOriginated()) {
            if (!Objects.isNull(companyField.getValue()) && !Objects.equals(companyField.getValue().getBusiness(), event.getValue())) {
                companyField.setValue(companyField.getEmptyValue());
            }
            refreshForm();
        }
    }

    @Subscribe("companyField")
    public void onCompanyFieldFieldValueChange(HasValue.ValueChangeEvent<Company> event) {
        if (event.isUserOriginated()) {
            if (!Objects.isNull(companyField.getValue()) && !Objects.equals(businessField.getValue(), event.getValue().getBusiness())) {
                businessField.setValue(companyField.getValue().getBusiness());
            }
            refreshForm();
        }
    }

    public void addNewHotFixRequest() {
        TimeSource timeSource = AppBeans.get(TimeSource.class);

        Screen newIssuesScreen = screenBuilders.editor(HotFixRequest.class, this)
                .newEntity()
                .withInitializer(issue -> {
                    issue.setOnDate(timeSource.currentTimestamp());
                    issue.setBusiness(getEditedEntity().getBusiness());
                    issue.setCompany(getEditedEntity().getCompany());
                    issue.setDescription(getEditedEntity().getDetailedDescription());
                })
                //.withLaunchMode(OpenMode.DIALOG)
                .build();
        newIssuesScreen.show();
    }
}