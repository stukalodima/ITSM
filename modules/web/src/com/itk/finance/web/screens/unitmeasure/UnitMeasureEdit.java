package com.itk.finance.web.screens.unitmeasure;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.UnitMeasure;

@UiController("finance_UnitMeasure.edit")
@UiDescriptor("unit-measure-edit.xml")
@EditedEntityContainer("unitMeasureDc")
@LoadDataBeforeShow
public class UnitMeasureEdit extends StandardEditor<UnitMeasure> {
}