package com.itk.finance.web.screens.asset;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Asset;

@UiController("finance_Asset.edit")
@UiDescriptor("asset-edit.xml")
@EditedEntityContainer("assetDc")
@LoadDataBeforeShow
public class AssetEdit extends StandardEditor<Asset> {
}