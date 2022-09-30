package com.itk.finance.web.screens.consultationrequestfile;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.ConsultationRequestFile;

@UiController("finance_ConsultationRequestFile.edit")
@UiDescriptor("consultation-request-file-edit.xml")
@EditedEntityContainer("consultationRequestFileDc")
@LoadDataBeforeShow
public class ConsultationRequestFileEdit extends StandardEditor<ConsultationRequestFile> {
}