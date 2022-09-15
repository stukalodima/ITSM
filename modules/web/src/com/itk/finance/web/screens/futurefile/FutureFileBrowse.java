package com.itk.finance.web.screens.futurefile;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.FutureFile;

@UiController("finance_FutureFile.browse")
@UiDescriptor("future-file-browse.xml")
@LookupComponent("futureFilesTable")
@LoadDataBeforeShow
public class FutureFileBrowse extends StandardLookup<FutureFile> {
}