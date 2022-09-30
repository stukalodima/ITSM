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
);