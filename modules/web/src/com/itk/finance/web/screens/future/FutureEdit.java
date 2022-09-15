package com.itk.finance.web.screens.future;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Future;

@UiController("finance_Future.edit")
@UiDescriptor("future-edit.xml")
@EditedEntityContainer("futureDc")
@LoadDataBeforeShow
public class FutureEdit extends StandardEditor<Future> {
}