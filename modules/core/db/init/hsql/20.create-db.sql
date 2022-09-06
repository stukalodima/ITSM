-- begin FINANCE_PAYMENT_REGISTER
alter table FINANCE_PAYMENT_REGISTER add constraint FK_FINANCE_PAYMENT_REGISTER_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_PAYMENT_REGISTER add constraint FK_FINANCE_PAYMENT_REGISTER_ON_STATUS foreign key (STATUS_ID) references FINANCE_PROC_STATUS(ID)^
alter table FINANCE_PAYMENT_REGISTER add constraint FK_FINANCE_PAYMENT_REGISTER_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
alter table FINANCE_PAYMENT_REGISTER add constraint FK_FINANCE_PAYMENT_REGISTER_ON_REGISTER_TYPE foreign key (REGISTER_TYPE_ID) references FINANCE_REGISTER_TYPE(ID)^
alter table FINANCE_PAYMENT_REGISTER add constraint FK_FINANCE_PAYMENT_REGISTER_ON_PROC_INSTANCE foreign key (PROC_INSTANCE_ID) references BPM_PROC_INSTANCE(ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_ON_BUSINESS on FINANCE_PAYMENT_REGISTER (BUSINESS_ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_ON_STATUS on FINANCE_PAYMENT_REGISTER (STATUS_ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_ON_AUTHOR on FINANCE_PAYMENT_REGISTER (AUTHOR_ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_ON_REGISTER_TYPE on FINANCE_PAYMENT_REGISTER (REGISTER_TYPE_ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_ON_PROC_INSTANCE on FINANCE_PAYMENT_REGISTER (PROC_INSTANCE_ID)^
-- end FINANCE_PAYMENT_REGISTER
-- begin FINANCE_CASH_FLOW_ITEM_BUSINESS
alter table FINANCE_CASH_FLOW_ITEM_BUSINESS add constraint FK_FINANCE_CASH_FLOW_ITEM_BUSINESS_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_CASH_FLOW_ITEM_BUSINESS add constraint FK_FINANCE_CASH_FLOW_ITEM_BUSINESS_ON_CASH_FLOW_ITEM foreign key (CASH_FLOW_ITEM_ID) references FINANCE_CASH_FLOW_ITEM(ID)^
create index IDX_FINANCE_CASH_FLOW_ITEM_BUSINESS_ON_COMPANY on FINANCE_CASH_FLOW_ITEM_BUSINESS (COMPANY_ID)^
create index IDX_FINANCE_CASH_FLOW_ITEM_BUSINESS_ON_CASH_FLOW_ITEM on FINANCE_CASH_FLOW_ITEM_BUSINESS (CASH_FLOW_ITEM_ID)^
-- end FINANCE_CASH_FLOW_ITEM_BUSINESS
-- begin FINANCE_COMPANY
alter table FINANCE_COMPANY add constraint FK_FINANCE_COMPANY_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
create index IDX_FINANCE_COMPANY_ON_BUSINESS on FINANCE_COMPANY (BUSINESS_ID)^
-- end FINANCE_COMPANY
-- begin FINANCE_BUSINESS
alter table FINANCE_BUSINESS add constraint FK_FINANCE_BUSINESS_ON_FIN_DIRECTOR foreign key (FIN_DIRECTOR_ID) references SEC_USER(ID)^
alter table FINANCE_BUSINESS add constraint FK_FINANCE_BUSINESS_ON_MANAGEMENT_COMPANY foreign key (MANAGEMENT_COMPANY_ID) references FINANCE_MANAGEMENT_COMPANY(ID)^
alter table FINANCE_BUSINESS add constraint FK_FINANCE_BUSINESS_ON_PARENT foreign key (PARENT_ID) references FINANCE_BUSINESS(ID)^
create index IDX_FINANCE_BUSINESS_ON_FIN_DIRECTOR on FINANCE_BUSINESS (FIN_DIRECTOR_ID)^
create index IDX_FINANCE_BUSINESS_ON_MANAGEMENT_COMPANY on FINANCE_BUSINESS (MANAGEMENT_COMPANY_ID)^
create index IDX_FINANCE_BUSINESS_ON_PARENT on FINANCE_BUSINESS (PARENT_ID)^
-- end FINANCE_BUSINESS
-- begin FINANCE_PAYMENT_REGISTER_DETAIL
alter table FINANCE_PAYMENT_REGISTER_DETAIL add constraint FK_FINANCE_PAYMENT_REGISTER_DETAIL_ON_PAYMENT_CLAIM foreign key (PAYMENT_CLAIM_ID) references FINANCE_PAYMENT_CLAIM(ID)^
alter table FINANCE_PAYMENT_REGISTER_DETAIL add constraint FK_FINANCE_PAYMENT_REGISTER_DETAIL_ON_PAYMENT_REGISTER foreign key (PAYMENT_REGISTER_ID) references FINANCE_PAYMENT_REGISTER(ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_DETAIL_ON_PAYMENT_CLAIM on FINANCE_PAYMENT_REGISTER_DETAIL (PAYMENT_CLAIM_ID)^
create index IDX_FINANCE_PAYMENT_REGISTER_DETAIL_ON_PAYMENT_REGISTER on FINANCE_PAYMENT_REGISTER_DETAIL (PAYMENT_REGISTER_ID)^
-- end FINANCE_PAYMENT_REGISTER_DETAIL
-- begin FINANCE_USER_PROPERTY
alter table FINANCE_USER_PROPERTY add constraint FK_FINANCE_USER_PROPERTY_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table FINANCE_USER_PROPERTY add constraint FK_FINANCE_USER_PROPERTY_ON_MANAGEMENT_COMPANY foreign key (MANAGEMENT_COMPANY_ID) references FINANCE_MANAGEMENT_COMPANY(ID)^
alter table FINANCE_USER_PROPERTY add constraint FK_FINANCE_USER_PROPERTY_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_USER_PROPERTY add constraint FK_FINANCE_USER_PROPERTY_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
create index IDX_FINANCE_USER_PROPERTY_ON_USER on FINANCE_USER_PROPERTY (USER_ID)^
create index IDX_FINANCE_USER_PROPERTY_ON_MANAGEMENT_COMPANY on FINANCE_USER_PROPERTY (MANAGEMENT_COMPANY_ID)^
create index IDX_FINANCE_USER_PROPERTY_ON_BUSINESS on FINANCE_USER_PROPERTY (BUSINESS_ID)^
create index IDX_FINANCE_USER_PROPERTY_ON_COMPANY on FINANCE_USER_PROPERTY (COMPANY_ID)^
-- end FINANCE_USER_PROPERTY
-- begin FINANCE_ACCOUNT
alter table FINANCE_ACCOUNT add constraint FK_FINANCE_ACCOUNT_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_ACCOUNT add constraint FK_FINANCE_ACCOUNT_ON_TYPE foreign key (TYPE_ID) references FINANCE_ACCOUNT_TYPE(ID)^
alter table FINANCE_ACCOUNT add constraint FK_FINANCE_ACCOUNT_ON_CURRENCY foreign key (CURRENCY_ID) references FINANCE_CURRENCY(ID)^
alter table FINANCE_ACCOUNT add constraint FK_FINANCE_ACCOUNT_ON_BANK foreign key (BANK_ID) references FINANCE_BANK(ID)^
create index IDX_FINANCE_ACCOUNT_ON_COMPANY on FINANCE_ACCOUNT (COMPANY_ID)^
create index IDX_FINANCE_ACCOUNT_ON_TYPE on FINANCE_ACCOUNT (TYPE_ID)^
create index IDX_FINANCE_ACCOUNT_ON_CURRENCY on FINANCE_ACCOUNT (CURRENCY_ID)^
create index IDX_FINANCE_ACCOUNT_ON_BANK on FINANCE_ACCOUNT (BANK_ID)^
-- end FINANCE_ACCOUNT
-- begin FINANCE_PAYMENT_CLAIM
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_CLIENT foreign key (CLIENT_ID) references FINANCE_CLIENT(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_ACCOUNT foreign key (ACCOUNT_ID) references FINANCE_ACCOUNT(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_CURRENCY foreign key (CURRENCY_ID) references FINANCE_CURRENCY(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_CASH_FLOW_ITEM foreign key (CASH_FLOW_ITEM_ID) references FINANCE_CASH_FLOW_ITEM(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_CASH_FLOW_ITEM_BUSINESS foreign key (CASH_FLOW_ITEM_BUSINESS_ID) references FINANCE_CASH_FLOW_ITEM_BUSINESS(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_PAYMENT_TYPE foreign key (PAYMENT_TYPE_ID) references FINANCE_PAYMENT_TYPE(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
alter table FINANCE_PAYMENT_CLAIM add constraint FK_FINANCE_PAYMENT_CLAIM_ON_STATUS foreign key (STATUS_ID) references FINANCE_PROC_STATUS(ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_BUSINESS on FINANCE_PAYMENT_CLAIM (BUSINESS_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_COMPANY on FINANCE_PAYMENT_CLAIM (COMPANY_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_CLIENT on FINANCE_PAYMENT_CLAIM (CLIENT_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_ACCOUNT on FINANCE_PAYMENT_CLAIM (ACCOUNT_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_CURRENCY on FINANCE_PAYMENT_CLAIM (CURRENCY_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_CASH_FLOW_ITEM on FINANCE_PAYMENT_CLAIM (CASH_FLOW_ITEM_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_CASH_FLOW_ITEM_BUSINESS on FINANCE_PAYMENT_CLAIM (CASH_FLOW_ITEM_BUSINESS_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_PAYMENT_TYPE on FINANCE_PAYMENT_CLAIM (PAYMENT_TYPE_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_AUTHOR on FINANCE_PAYMENT_CLAIM (AUTHOR_ID)^
create index IDX_FINANCE_PAYMENT_CLAIM_ON_STATUS on FINANCE_PAYMENT_CLAIM (STATUS_ID)^
-- end FINANCE_PAYMENT_CLAIM
-- begin FINANCE_MANAGEMENT_COMPANY
alter table FINANCE_MANAGEMENT_COMPANY add constraint FK_FINANCE_MANAGEMENT_COMPANY_ON_FIN_CONTROLER foreign key (FIN_CONTROLER_ID) references SEC_USER(ID)^
alter table FINANCE_MANAGEMENT_COMPANY add constraint FK_FINANCE_MANAGEMENT_COMPANY_ON_FIN_DIRECTOR foreign key (FIN_DIRECTOR_ID) references SEC_USER(ID)^
create index IDX_FINANCE_MANAGEMENT_COMPANY_ON_FIN_CONTROLER on FINANCE_MANAGEMENT_COMPANY (FIN_CONTROLER_ID)^
create index IDX_FINANCE_MANAGEMENT_COMPANY_ON_FIN_DIRECTOR on FINANCE_MANAGEMENT_COMPANY (FIN_DIRECTOR_ID)^
-- end FINANCE_MANAGEMENT_COMPANY

-- begin FINANCE_ACCOUNT_REMAINS
alter table FINANCE_ACCOUNT_REMAINS add constraint FK_FINANCE_ACCOUNT_REMAINS_ON_ACCOUNT foreign key (ACCOUNT_ID) references FINANCE_ACCOUNT(ID)^
create index IDX_FINANCE_ACCOUNT_REMAINS_ON_ACCOUNT on FINANCE_ACCOUNT_REMAINS (ACCOUNT_ID)^
-- end FINANCE_ACCOUNT_REMAINS
-- begin FINANCE_BUSINESS_CONTROLLERS
alter table FINANCE_BUSINESS_CONTROLLERS add constraint FK_FINANCE_BUSINESS_CONTROLLERS_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table FINANCE_BUSINESS_CONTROLLERS add constraint FK_FINANCE_BUSINESS_CONTROLLERS_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
create index IDX_FINANCE_BUSINESS_CONTROLLERS_ON_USER on FINANCE_BUSINESS_CONTROLLERS (USER_ID)^
create index IDX_FINANCE_BUSINESS_CONTROLLERS_ON_BUSINESS on FINANCE_BUSINESS_CONTROLLERS (BUSINESS_ID)^
-- end FINANCE_BUSINESS_CONTROLLERS
-- begin FINANCE_ADDRESSING
alter table FINANCE_ADDRESSING add constraint FK_FINANCE_ADDRESSING_ON_BUSSINES foreign key (BUSSINES_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_ADDRESSING add constraint FK_FINANCE_ADDRESSING_ON_PROC_DEFINITION foreign key (PROC_DEFINITION_ID) references BPM_PROC_DEFINITION(ID)^
alter table FINANCE_ADDRESSING add constraint FK_FINANCE_ADDRESSING_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
create index IDX_FINANCE_ADDRESSING_ON_BUSSINES on FINANCE_ADDRESSING (BUSSINES_ID)^
create index IDX_FINANCE_ADDRESSING_ON_PROC_DEFINITION on FINANCE_ADDRESSING (PROC_DEFINITION_ID)^
create index IDX_FINANCE_ADDRESSING_ON_COMPANY on FINANCE_ADDRESSING (COMPANY_ID)^
-- end FINANCE_ADDRESSING
-- begin FINANCE_BUSINESS_OPERATORS
alter table FINANCE_BUSINESS_OPERATORS add constraint FK_FINANCE_BUSINESS_OPERATORS_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table FINANCE_BUSINESS_OPERATORS add constraint FK_FINANCE_BUSINESS_OPERATORS_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
create index IDX_FINANCE_BUSINESS_OPERATORS_ON_USER on FINANCE_BUSINESS_OPERATORS (USER_ID)^
create index IDX_FINANCE_BUSINESS_OPERATORS_ON_BUSINESS on FINANCE_BUSINESS_OPERATORS (BUSINESS_ID)^
-- end FINANCE_BUSINESS_OPERATORS
-- begin FINANCE_CURRENCY_RATE
alter table FINANCE_CURRENCY_RATE add constraint FK_FINANCE_CURRENCY_RATE_ON_CURRENCY foreign key (CURRENCY_ID) references FINANCE_CURRENCY(ID)^
create index IDX_FINANCE_CURRENCY_RATE_ON_CURRENCY on FINANCE_CURRENCY_RATE (CURRENCY_ID)^
-- end FINANCE_CURRENCY_RATE
-- begin FINANCE_REGISTER_TYPE_DETAIL
alter table FINANCE_REGISTER_TYPE_DETAIL add constraint FK_FINANCE_REGISTER_TYPE_DETAIL_ON_CASH_FLOW_ITEM foreign key (CASH_FLOW_ITEM_ID) references FINANCE_CASH_FLOW_ITEM(ID)^
alter table FINANCE_REGISTER_TYPE_DETAIL add constraint FK_FINANCE_REGISTER_TYPE_DETAIL_ON_REGISTER_TYPE foreign key (REGISTER_TYPE_ID) references FINANCE_REGISTER_TYPE(ID)^
create index IDX_FINANCE_REGISTER_TYPE_DETAIL_ON_CASH_FLOW_ITEM on FINANCE_REGISTER_TYPE_DETAIL (CASH_FLOW_ITEM_ID)^
create index IDX_FINANCE_REGISTER_TYPE_DETAIL_ON_REGISTER_TYPE on FINANCE_REGISTER_TYPE_DETAIL (REGISTER_TYPE_ID)^
-- end FINANCE_REGISTER_TYPE_DETAIL
-- begin FINANCE_REGISTER_TYPE
alter table FINANCE_REGISTER_TYPE add constraint FK_FINANCE_REGISTER_TYPE_ON_PROC_DEFINITION foreign key (PROC_DEFINITION_ID) references BPM_PROC_DEFINITION(ID)^
create index IDX_FINANCE_REGISTER_TYPE_ON_PROC_DEFINITION on FINANCE_REGISTER_TYPE (PROC_DEFINITION_ID)^
-- end FINANCE_REGISTER_TYPE
-- begin FINANCE_ADDRESSING_DETAIL
alter table FINANCE_ADDRESSING_DETAIL add constraint FK_FINANCE_ADDRESSING_DETAIL_ON_PROC_ROLE foreign key (PROC_ROLE_ID) references BPM_PROC_ROLE(ID)^
alter table FINANCE_ADDRESSING_DETAIL add constraint FK_FINANCE_ADDRESSING_DETAIL_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table FINANCE_ADDRESSING_DETAIL add constraint FK_FINANCE_ADDRESSING_DETAIL_ON_ADDRESSING foreign key (ADDRESSING_ID) references FINANCE_ADDRESSING(ID)^
create index IDX_FINANCE_ADDRESSING_DETAIL_ON_PROC_ROLE on FINANCE_ADDRESSING_DETAIL (PROC_ROLE_ID)^
create index IDX_FINANCE_ADDRESSING_DETAIL_ON_USER on FINANCE_ADDRESSING_DETAIL (USER_ID)^
create index IDX_FINANCE_ADDRESSING_DETAIL_ON_ADDRESSING on FINANCE_ADDRESSING_DETAIL (ADDRESSING_ID)^
-- end FINANCE_ADDRESSING_DETAIL
-- begin FINANCE_BANK
alter table FINANCE_BANK add constraint FK_FINANCE_BANK_ON_PARENT_BANK foreign key (PARENT_BANK_ID) references FINANCE_BANK(ID)^
create index IDX_FINANCE_BANK_ON_PARENT_BANK on FINANCE_BANK (PARENT_BANK_ID)^
-- end FINANCE_BANK
-- begin BPM_PROC_INSTANCE
alter table BPM_PROC_INSTANCE add constraint FK_BPM_PROC_INSTANCE_ON_PAYMENT_REGISTER foreign key (PAYMENT_REGISTER_ID) references FINANCE_PAYMENT_REGISTER(ID)^
create index IDX_BPM_PROC_INSTANCE_ON_PAYMENT_REGISTER on BPM_PROC_INSTANCE (PAYMENT_REGISTER_ID)^
-- end BPM_PROC_INSTANCE
-- begin FINANCE_ASSET
alter table FINANCE_ASSET add constraint FK_FINANCE_ASSET_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_ASSET add constraint FK_FINANCE_ASSET_ON_RESPONSIBLE_IT foreign key (RESPONSIBLE_IT) references SEC_USER(ID)^
alter table FINANCE_ASSET add constraint FK_FINANCE_ASSET_ON_RESPONSIBLE_BUSINESS foreign key (RESPONSIBLE_BUSINESS) references SEC_USER(ID)^
create index IDX_FINANCE_ASSET_ON_COMPANY on FINANCE_ASSET (COMPANY_ID)^
create index IDX_FINANCE_ASSET_ON_RESPONSIBLE_IT on FINANCE_ASSET (RESPONSIBLE_IT)^
create index IDX_FINANCE_ASSET_ON_RESPONSIBLE_BUSINESS on FINANCE_ASSET (RESPONSIBLE_BUSINESS)^
-- end FINANCE_ASSET
-- begin FINANCE_ISSUE
alter table FINANCE_ISSUE add constraint FK_FINANCE_ISSUE_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
create index IDX_FINANCE_ISSUE_ON_AUTHOR on FINANCE_ISSUE (AUTHOR_ID)^
-- end FINANCE_ISSUE
-- begin FINANCE_ISSUE_FILE
alter table FINANCE_ISSUE_FILE add constraint FK_FINANCE_ISSUE_FILE_ON_DOCUMENT foreign key (DOCUMENT_ID) references SYS_FILE(ID)^
alter table FINANCE_ISSUE_FILE add constraint FK_FINANCE_ISSUE_FILE_ON_ISSUE foreign key (ISSUE_ID) references FINANCE_ISSUE(ID)^
create index IDX_FINANCE_ISSUE_FILE_ON_DOCUMENT on FINANCE_ISSUE_FILE (DOCUMENT_ID)^
create index IDX_FINANCE_ISSUE_FILE_ON_ISSUE on FINANCE_ISSUE_FILE (ISSUE_ID)^
-- end FINANCE_ISSUE_FILE
-- begin FINANCE_CONSULTATION_REQUEST
alter table FINANCE_CONSULTATION_REQUEST add constraint FK_FINANCE_CONSULTATION_REQUEST_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_CONSULTATION_REQUEST add constraint FK_FINANCE_CONSULTATION_REQUEST_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_CONSULTATION_REQUEST add constraint FK_FINANCE_CONSULTATION_REQUEST_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
alter table FINANCE_CONSULTATION_REQUEST add constraint FK_FINANCE_CONSULTATION_REQUEST_ON_EXECUTOR foreign key (EXECUTOR_ID) references SEC_USER(ID)^
alter table FINANCE_CONSULTATION_REQUEST add constraint FK_FINANCE_CONSULTATION_REQUEST_ON_ISSUES foreign key (ISSUES_ID) references FINANCE_ISSUE(ID)^
create index IDX_FINANCE_CONSULTATION_REQUEST_ON_BUSINESS on FINANCE_CONSULTATION_REQUEST (BUSINESS_ID)^
create index IDX_FINANCE_CONSULTATION_REQUEST_ON_COMPANY on FINANCE_CONSULTATION_REQUEST (COMPANY_ID)^
create index IDX_FINANCE_CONSULTATION_REQUEST_ON_AUTHOR on FINANCE_CONSULTATION_REQUEST (AUTHOR_ID)^
create index IDX_FINANCE_CONSULTATION_REQUEST_ON_EXECUTOR on FINANCE_CONSULTATION_REQUEST (EXECUTOR_ID)^
create index IDX_FINANCE_CONSULTATION_REQUEST_ON_ISSUES on FINANCE_CONSULTATION_REQUEST (ISSUES_ID)^
-- end FINANCE_CONSULTATION_REQUEST
-- begin FINANCE_HOT_FIX_REQUEST
alter table FINANCE_HOT_FIX_REQUEST add constraint FK_FINANCE_HOT_FIX_REQUEST_ON_ISSUE foreign key (ISSUE_ID) references FINANCE_ISSUE(ID)^
alter table FINANCE_HOT_FIX_REQUEST add constraint FK_FINANCE_HOT_FIX_REQUEST_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID)^
alter table FINANCE_HOT_FIX_REQUEST add constraint FK_FINANCE_HOT_FIX_REQUEST_ON_BUSINESS foreign key (BUSINESS_ID) references FINANCE_BUSINESS(ID)^
alter table FINANCE_HOT_FIX_REQUEST add constraint FK_FINANCE_HOT_FIX_REQUEST_ON_EXECUTOR foreign key (EXECUTOR_ID) references SEC_USER(ID)^
create index IDX_FINANCE_HOT_FIX_REQUEST_ON_ISSUE on FINANCE_HOT_FIX_REQUEST (ISSUE_ID)^
create index IDX_FINANCE_HOT_FIX_REQUEST_ON_COMPANY on FINANCE_HOT_FIX_REQUEST (COMPANY_ID)^
create index IDX_FINANCE_HOT_FIX_REQUEST_ON_BUSINESS on FINANCE_HOT_FIX_REQUEST (BUSINESS_ID)^
create index IDX_FINANCE_HOT_FIX_REQUEST_ON_EXECUTOR on FINANCE_HOT_FIX_REQUEST (EXECUTOR_ID)^
-- end FINANCE_HOT_FIX_REQUEST
