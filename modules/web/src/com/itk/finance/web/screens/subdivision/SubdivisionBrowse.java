package com.itk.finance.web.screens.subdivision;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Subdivision;

@UiController("finance_Subdivision.browse")
@UiDescriptor("subdivision-browse.xml")
@LookupComponent("subdivisionsTable")
@LoadDataBeforeShow
public class SubdivisionBrowse extends StandardLookup<Subdivision> {
}