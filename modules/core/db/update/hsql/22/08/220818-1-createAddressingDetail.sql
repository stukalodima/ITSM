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
);