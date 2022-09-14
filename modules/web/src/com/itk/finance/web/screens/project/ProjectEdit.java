package com.itk.finance.web.screens.project;

import com.haulmont.cuba.gui.screen.*;
import com.itk.finance.entity.Project;

@UiController("finance_Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
@LoadDataBeforeShow
public class ProjectEdit extends StandardEditor<Project> {
}