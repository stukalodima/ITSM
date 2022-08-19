package com.itk.finance.web.screens.asset;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Asset;

@UiController("finance_Asset.browse")
@UiDescriptor("asset-browse.xml")
@LookupComponent("assetsTable")
@LoadDataBeforeShow
public class AssetBrowse extends StandardLookup<Asset> {
}