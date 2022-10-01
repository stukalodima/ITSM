package com.itk.finance.web.screens.consultationrequest;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.ConsultationRequest;

@UiController("finance_ConsultationRequest.browse")
@UiDescriptor("consultation-request-browse.xml")
@LookupComponent("consultationRequestsTable")
@LoadDataBeforeShow
public class ConsultationRequestBrowse extends StandardLookup<ConsultationRequest> {
}