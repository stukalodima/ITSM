package com.itk.finance.web.screens.hotfixrequestfile;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.HotFixRequestFile;

@UiController("finance_HotFixRequestFile.edit")
@UiDescriptor("hot-fix-request-file-edit.xml")
@EditedEntityContainer("hotFixRequestFileDc")
@LoadDataBeforeShow
public class HotFixRequestFileEdit extends StandardEditor<HotFixRequestFile> {
}