package com.itk.finance.web.screens.project;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Project;

@UiController("finance_Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
@LoadDataBeforeShow
public class ProjectBrowse extends StandardLookup<Project> {
}