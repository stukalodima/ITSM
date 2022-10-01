package com.itk.finance.service;

import com.haulmont.cuba.core.global.DataManager;
import com.itk.finance.entity.ConsultationRequest;
import com.itk.finance.entity.HotFixRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(ConsultationRequestService.NAME)
public class ConsultationRequestServiceBean implements ConsultationRequestService {

    @Inject
    private DataManager dataManager;

    @Override
    public HotFixRequest createHotFixRequestFromConsultationRequest(ConsultationRequest consultationRequest) {
        HotFixRequest hotFixRequest = dataManager.create(HotFixRequest.class);
        hotFixRequest.setBusiness(consultationRequest.getBusiness());
        hotFixRequest.setCompany(consultationRequest.getCompany());
        hotFixRequest.setDescription(consultationRequest.getDescription());

        return hotFixRequest;
    }
}