package com.itk.finance.web.screens.hotfixrequest;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Business;
import com.itk.finance.entity.Company;
import com.itk.finance.entity.HotFixRequest;

import javax.inject.Inject;
import java.util.Objects;

@UiController("finance_HotFixRequest.edit")
@UiDescriptor("hot-fix-request-edit.xml")
@EditedEntityContainer("hotFixRequestDc")
@LoadDataBeforeShow
public class HotFixRequestEdit extends StandardEditor<HotFixRequest> {
    @Inject
    private CollectionLoader<Business> businessesDl;
    @Inject
    private CollectionLoader<Company> companiesDl;
    @Inject
    private LookupPickerField<Business> businessField;
    @Inject
    private EntityStates entityStates;

    @Inject
    private LookupPickerField<Company> companyField;
    @Inject
    private TextField<Long> numberField;
    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        businessesDl.load();
        refreshForm();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        refreshForm();
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

}
