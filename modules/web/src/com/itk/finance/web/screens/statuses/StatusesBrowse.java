package com.itk.finance.web.screens.statuses;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Statuses;

@UiController("finance_Statuses.browse")
@UiDescriptor("statuses-browse.xml")
@LookupComponent("statusesesTable")
@LoadDataBeforeShow
public class StatusesBrowse extends StandardLookup<Statuses> {
}