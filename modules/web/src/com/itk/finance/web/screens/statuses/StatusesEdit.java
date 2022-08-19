package com.itk.finance.web.screens.statuses;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Statuses;

@UiController("finance_Statuses.edit")
@UiDescriptor("statuses-edit.xml")
@EditedEntityContainer("statusesDc")
@LoadDataBeforeShow
public class StatusesEdit extends StandardEditor<Statuses> {
}