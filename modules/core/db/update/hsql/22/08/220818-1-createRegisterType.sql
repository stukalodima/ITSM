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
);