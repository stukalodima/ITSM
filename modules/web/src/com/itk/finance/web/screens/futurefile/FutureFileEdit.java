package com.itk.finance.web.screens.futurefile;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.FutureFile;

@UiController("finance_FutureFile.edit")
@UiDescriptor("future-file-edit.xml")
@EditedEntityContainer("futureFileDc")
@LoadDataBeforeShow
public class FutureFileEdit extends StandardEditor<FutureFile> {
}