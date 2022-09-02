package com.itk.finance.web.screens.consultationrequest;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Business;
import com.itk.finance.entity.Company;
import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.PaymentClaim;

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
    private TextField<Long> numberField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        businessesDl.load();
        refreshForm();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        refreshForm();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (entityStates.isNew(getEditedEntity()) || Objects.isNull(numberField.getValue()) || numberField.getValue()==0) {
            getEditedEntity().setNumber(uniqueNumbersService.getNextNumber(ConsultationRequest.class.getSimpleName()));
            event.resume();
        }
    }

    private void refreshForm() {
        companiesDl.setParameter("business", businessField.getValue());
        companiesDl.load();
    }

    @Subscribe("businessField")
    public void onBusinessFieldValueChange(HasValue.ValueChangeEvent<Business> event) {
        if (!Objects.isNull(companyField.getValue()) && !Objects.equals(companyField.getValue().getBusiness(), event.getValue())) {
            companyField.setValue(companyField.getEmptyValue());
        }

        if (event.isUserOriginated()) {
            refreshForm();
        }
    }

    @Subscribe("companyField")
    public void onCompanyFieldFieldValueChange(HasValue.ValueChangeEvent<Company> event) {
    }
}