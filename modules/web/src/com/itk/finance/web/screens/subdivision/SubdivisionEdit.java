package com.itk.finance.web.screens.subdivision;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Subdivision;

@UiController("finance_Subdivision.edit")
@UiDescriptor("subdivision-edit.xml")
@EditedEntityContainer("subdivisionDc")
@LoadDataBeforeShow
public class SubdivisionEdit extends StandardEditor<Subdivision> {
}