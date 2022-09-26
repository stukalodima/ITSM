package com.itk.finance.web.screens.asset;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Asset;
import com.itk.finance.entity.Company;
import com.itk.finance.web.screens.company.CompanyBrowse;

import javax.inject.Inject;

@UiController("finance_Asset.browse")
@UiDescriptor("asset-browse.xml")
@LookupComponent("assetsTable")
@LoadDataBeforeShow
public class AssetBrowse extends StandardLookup<Asset> {

    private Company company;
    @Inject
    private CollectionLoader<Asset> assetsDl;

    public void setCompany (Company company){
        this.company = company;
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        assetsDl.setParameter("paramCompany", company);
        assetsDl.load();
    }
}