package com.itk.finance.web.screens.future;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Future;

@UiController("finance_Future.browse")
@UiDescriptor("future-browse.xml")
@LookupComponent("futuresTable")
@LoadDataBeforeShow
public class FutureBrowse extends StandardLookup<Future> {
}