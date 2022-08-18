package com.itk.finance.web.screens.unitmeasure;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.UnitMeasure;

@UiController("finance_UnitMeasure.browse")
@UiDescriptor("unit-measure-browse.xml")
@LookupComponent("unitMeasuresTable")
@LoadDataBeforeShow
public class UnitMeasureBrowse extends StandardLookup<UnitMeasure> {
}