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
    ON_DATE date,
    NUMBER bigint,
    TOPIC longvarchar,
    DESCRIPTION longvarchar,
    AUTHOR_ID varchar(36),
    --
    primary key (ID)
);