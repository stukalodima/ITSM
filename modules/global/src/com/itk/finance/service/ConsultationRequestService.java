package com.itk.finance.service;

import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.HotFixRequest;

public interface ConsultationRequestService {
    String NAME = "finance_ConsultationRequestService";

    HotFixRequest createHotFixRequestFromConsultationRequest(ConsultationRequest consultationRequest);
}