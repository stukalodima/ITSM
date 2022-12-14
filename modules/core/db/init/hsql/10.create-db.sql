-- begin FINANCE_CURRENCY
create table FINANCE_CURRENCY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(3) not null,
    SHORT_NAME varchar(3) not null,
    NAME varchar(255) not null,
    BASE_CURRENCY boolean,
    --
    primary key (ID)
)^
-- end FINANCE_CURRENCY
-- begin FINANCE_CLIENT
create table FINANCE_CLIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SHORT_NAME longvarchar not null,
    NAME longvarchar not null,
    CLIENT_TYPE varchar(50) not null,
    EDRPOU varchar(20) not null,
    ADDRESS longvarchar,
    KVED longvarchar,
    BOSS longvarchar,
    STAN varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_CLIENT
-- begin FINANCE_PAYMENT_REGISTER
create table FINANCE_PAYMENT_REGISTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ bigint,
    ON_DATE date not null,
    BUSINESS_ID varchar(36) not null,
    STATUS_ID varchar(36),
    AUTHOR_ID varchar(36),
    REGISTER_TYPE_ID varchar(36),
    PROC_INSTANCE_ID varchar(36),
    SUMMA varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_PAYMENT_REGISTER
-- begin FINANCE_PAYMENT_TYPE
create table FINANCE_PAYMENT_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    NUMBER integer not null,
    --
    primary key (ID)
)^
-- end FINANCE_PAYMENT_TYPE
-- begin FINANCE_CASH_FLOW_ITEM_BUSINESS
create table FINANCE_CASH_FLOW_ITEM_BUSINESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    COMPANY_ID varchar(36) not null,
    CASH_FLOW_ITEM_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_CASH_FLOW_ITEM_BUSINESS
-- begin FINANCE_BANK
create table FINANCE_BANK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FULL_NAME longvarchar,
    MFO varchar(6) not null,
    STAN varchar(255),
    PARENT_BANK_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_BANK
-- begin FINANCE_COMPANY
create table FINANCE_COMPANY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SHORT_NAME varchar(255) not null,
    NAME longvarchar not null,
    EDRPOU varchar(10) not null,
    BUSINESS_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_COMPANY
-- begin FINANCE_BUSINESS
create table FINANCE_BUSINESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FIN_DIRECTOR_ID varchar(36),
    MANAGEMENT_COMPANY_ID varchar(36) not null,
    PARENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_BUSINESS
-- begin FINANCE_PAYMENT_REGISTER_DETAIL
create table FINANCE_PAYMENT_REGISTER_DETAIL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    APPROVED varchar(50),
    PAYMENT_CLAIM_ID varchar(36),
    PAYMENT_REGISTER_ID varchar(36) not null,
    PAYMENT_STATUS_ROW varchar(50),
    COMMENT_ longvarchar,
    --
    primary key (ID)
)^
-- end FINANCE_PAYMENT_REGISTER_DETAIL
-- begin FINANCE_USER_PROPERTY
create table FINANCE_USER_PROPERTY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    MANAGEMENT_COMPANY_ID varchar(36) not null,
    BUSINESS_ID varchar(36) not null,
    COMPANY_ID varchar(36) not null,
    DONT_SEND_EMAIL_BY_TASK boolean,
    DONT_SEND_EMAIL_BY_APPROVAL_RESULT boolean,
    SEND_NOTIFICATION_TASK boolean,
    --
    primary key (ID)
)^
-- end FINANCE_USER_PROPERTY
-- begin FINANCE_ACCOUNT
create table FINANCE_ACCOUNT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPANY_ID varchar(36) not null,
    TYPE_ID varchar(36),
    CURRENCY_ID varchar(36) not null,
    IBAN varchar(50) not null,
    BANK_ID varchar(36) not null,
    START_DATE date,
    END_DATE date,
    LOCK_ boolean,
    CLOSE_ boolean,
    --
    primary key (ID)
)^
-- end FINANCE_ACCOUNT
-- begin FINANCE_CASH_FLOW_ITEM
create table FINANCE_CASH_FLOW_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    NUMBER integer not null,
    --
    primary key (ID)
)^
-- end FINANCE_CASH_FLOW_ITEM
-- begin FINANCE_PAYMENT_CLAIM
create table FINANCE_PAYMENT_CLAIM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ bigint,
    ON_DATE date not null,
    BUSINESS_ID varchar(36) not null,
    COMPANY_ID varchar(36) not null,
    CLIENT_ID varchar(36) not null,
    ACCOUNT_ID varchar(36) not null,
    CURRENCY_ID varchar(36) not null,
    SUMM double precision not null,
    PLAN_PAYMENT_DATE date not null,
    PAYMENT_PURPOSE longvarchar not null,
    CASH_FLOW_ITEM_ID varchar(36) not null,
    CASH_FLOW_ITEM_BUSINESS_ID varchar(36),
    PAYMENT_TYPE_ID varchar(36) not null,
    COMMENT_ longvarchar,
    AUTHOR_ID varchar(36) not null,
    STATUS_ID varchar(36),
    EXPRESS boolean,
    BUDGET_ANALITIC longvarchar,
    --
    primary key (ID)
)^
-- end FINANCE_PAYMENT_CLAIM
-- begin FINANCE_MANAGEMENT_COMPANY
create table FINANCE_MANAGEMENT_COMPANY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SHORT_NAME varchar(255) not null,
    NAME longvarchar not null,
    FIN_CONTROLER_ID varchar(36),
    FIN_DIRECTOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_MANAGEMENT_COMPANY
-- begin FINANCE_ACCOUNT_REMAINS
create table FINANCE_ACCOUNT_REMAINS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ON_DATE date not null,
    ACCOUNT_ID varchar(36) not null,
    SUMM_BEFOR double precision,
    SUMM double precision,
    SUMM_IN_UAH double precision,
    SUMM_IN_USD double precision,
    SUM_IN_EUR double precision,
    SUMM_EQUALS_UAH double precision,
    --
    primary key (ID)
)^
-- end FINANCE_ACCOUNT_REMAINS
-- begin FINANCE_ACCOUNT_TYPE
create table FINANCE_ACCOUNT_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_ACCOUNT_TYPE
-- begin FINANCE_BUSINESS_CONTROLLERS
create table FINANCE_BUSINESS_CONTROLLERS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    BUSINESS_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end FINANCE_BUSINESS_CONTROLLERS
-- begin FINANCE_ADDRESSING
create table FINANCE_ADDRESSING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BUSSINES_ID varchar(36) not null,
    PROC_DEFINITION_ID varchar(36) not null,
    USE_COMPANY boolean,
    COMPANY_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_ADDRESSING
-- begin FINANCE_BUSINESS_OPERATORS
create table FINANCE_BUSINESS_OPERATORS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    BUSINESS_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end FINANCE_BUSINESS_OPERATORS
-- begin FINANCE_CURRENCY_RATE
create table FINANCE_CURRENCY_RATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ON_DATE date,
    CURRENCY_ID varchar(36),
    MULTIPLICITY integer,
    RATE double precision,
    --
    primary key (ID)
)^
-- end FINANCE_CURRENCY_RATE
-- begin FINANCE_PROC_STATUS
create table FINANCE_PROC_STATUS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255) not null,
    NAME varchar(255) not null,
    IS_NEW boolean,
    IS_START boolean,
    --
    primary key (ID)
)^
-- end FINANCE_PROC_STATUS
-- begin FINANCE_REGISTER_TYPE_DETAIL
create table FINANCE_REGISTER_TYPE_DETAIL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CASH_FLOW_ITEM_ID varchar(36) not null,
    USE_CONDITION boolean,
    CONDITION_ varchar(255),
    CONDITION_VALUE double precision,
    REGISTER_TYPE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end FINANCE_REGISTER_TYPE_DETAIL
-- begin FINANCE_REGISTER_TYPE
create table FINANCE_REGISTER_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EXPRESS boolean,
    PROC_DEFINITION_ID varchar(36),
    USE_CONDITION boolean,
    CONDITION_ varchar(255),
    CONDITION_VALUE double precision,
    --
    primary key (ID)
)^
-- end FINANCE_REGISTER_TYPE
-- begin FINANCE_ADDRESSING_DETAIL
create table FINANCE_ADDRESSING_DETAIL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROC_ROLE_ID varchar(36) not null,
    USER_ID varchar(36) not null,
    AUTO boolean,
    ADDRESSING_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end FINANCE_ADDRESSING_DETAIL
-- begin BPM_PROC_INSTANCE
alter table BPM_PROC_INSTANCE add column PAYMENT_REGISTER_ID varchar(36) ^
alter table BPM_PROC_INSTANCE add column DTYPE varchar(31) ^
update BPM_PROC_INSTANCE set DTYPE = 'finance_ExtProcInstance' where DTYPE is null ^
-- end BPM_PROC_INSTANCE
-- begin FINANCE_ASSET
create table FINANCE_ASSET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SHORT_NAME varchar(255) not null,
    NAME varchar(255) not null,
    COMPANY_ID varchar(36),
    RESPONSIBLE_IT varchar(36),
    RESPONSIBLE_BUSINESS varchar(36),
    COMMISSIONING_DATE timestamp,
    EXPIRY_DATE timestamp,
    ACTIVE boolean,
    INITIAL_COST double precision,
    RESIDUAL_COST double precision,
    ASSET_STATES varchar(50),
    COMMENT varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_ASSET
-- begin FINANCE_SUBDIVISION
create table FINANCE_SUBDIVISION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end FINANCE_SUBDIVISION
-- begin FINANCE_UNIT_MEASURE
create table FINANCE_UNIT_MEASURE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(25) not null,
    FULL_NAME varchar(100),
    --
    primary key (ID)
)^
-- end FINANCE_UNIT_MEASURE
-- begin FINANCE_STATUSES
create table FINANCE_STATUSES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_STATUSES
-- begin FINANCE_PROJECT
create table FINANCE_PROJECT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    PARENT_ID varchar(36),
    NOT_RELEVANT boolean,
    SHUT boolean,
    START_DATE date,
    END_DATE date,
    MANAGER_ID varchar(36),
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end FINANCE_PROJECT
-- begin FINANCE_ISSUE
create table FINANCE_ISSUE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ON_DATE timestamp,
    NUMBER varchar(255),
    TOPIC longvarchar,
    DESCRIPTION longvarchar,
    AUTHOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_ISSUE
-- begin FINANCE_ISSUE_FILE
create table FINANCE_ISSUE_FILE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_ID varchar(36),
    AUTHOR_ID varchar(36),
    ISSUE_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_ISSUE_FILE
-- begin FINANCE_CONSULTATION_REQUEST
create table FINANCE_CONSULTATION_REQUEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER varchar(255),
    ON_DATE timestamp,
    BUSINESS_ID varchar(36),
    COMPANY_ID varchar(36),
    AUTHOR_ID varchar(36),
    ASSIGNED_TO_ID varchar(36),
    TOPIC longvarchar,
    DESCRIPTION longvarchar,
    ISSUE_ID varchar(36),
    PROJECT_ID varchar(36),
    ASSET_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_CONSULTATION_REQUEST
-- begin FINANCE_HOT_FIX_REQUEST
create table FINANCE_HOT_FIX_REQUEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER varchar(255),
    DATE date,
    ISSUE_ID varchar(36) not null,
    COMPANY_ID varchar(36),
    BUSINESS_ID varchar(36),
    DESCRIPTION longvarchar,
    EXECUTOR_ID varchar(36),
    ASSET_ID varchar(36),
    START_DATE date,
    --
    primary key (ID)
)^
-- end FINANCE_HOT_FIX_REQUEST
-- begin FINANCE_CONSULTATION_REQUEST_FILE
create table FINANCE_CONSULTATION_REQUEST_FILE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_ID varchar(36),
    CONSULTATION_REQUEST_ID varchar(36),
    AUTHOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_CONSULTATION_REQUEST_FILE
-- begin FINANCE_HOT_FIX_REQUEST_FILE
create table FINANCE_HOT_FIX_REQUEST_FILE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_ID varchar(36),
    HOT_FIX_REQUEST_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_HOT_FIX_REQUEST_FILE
-- begin FINANCE_EXECUTION_STATE
create table FINANCE_EXECUTION_STATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end FINANCE_EXECUTION_STATE
-- begin FINANCE_FUTURE
create table FINANCE_FUTURE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ON_DATE date,
    NUMBER varchar(255),
    ISSUE_ID varchar(36),
    COMPANY_ID varchar(36),
    BUSINESS_ID varchar(36),
    PROJECT_ID varchar(36),
    ASSET_ID varchar(36),
    DESCRIPTION longvarchar,
    TIME_ESTIMATE double precision,
    PLAN_DATE date,
    STATUS_ID varchar(36),
    IMPLEMENTER_ID varchar(36),
    EMPLOYMANT_DATE date,
    --
    primary key (ID)
)^
-- end FINANCE_FUTURE
-- begin FINANCE_FUTURE_FILE
create table FINANCE_FUTURE_FILE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_ID varchar(36),
    AUTHOR_ID varchar(36),
    FUTURE_ID varchar(36),
    --
    primary key (ID)
)^
-- end FINANCE_FUTURE_FILE
