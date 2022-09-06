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
    START_DATE date,
    --
    primary key (ID)
);