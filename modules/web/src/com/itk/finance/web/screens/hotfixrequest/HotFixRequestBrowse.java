package com.itk.finance.web.screens.hotfixrequest;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.HotFixRequest;

@UiController("finance_HotFixRequest.browse")
@UiDescriptor("hot-fix-request-browse.xml")
@LookupComponent("hotFixRequestsTable")
@LoadDataBeforeShow
public class HotFixRequestBrowse extends StandardLookup<HotFixRequest> {
}