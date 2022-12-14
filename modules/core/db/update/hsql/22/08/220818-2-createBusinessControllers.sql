alter table FINANCE_BUSINESS_CONTROLLERS add constraint FK_FINANCE_BUSINESS_CONTROLLERS_ON_USER foreign key (USER_ID) references SEC_USER(ID);
alter table FINANCE_BUSINESS_CONTROLLERS add constraint FK_FINANCE_BUSINESS_CONTROLLERS_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID);
create index IDX_FINANCE_BUSINESS_CONTROLLERS_ON_USER on FINANCE_BUSINESS_CONTROLLERS (USER_ID);
create index IDX_FINANCE_BUSINESS_CONTROLLERS_ON_BUSINESS on FINANCE_BUSINESS_CONTROLLERS (BUSINESS_ID);
