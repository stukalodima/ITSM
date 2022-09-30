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
    NAME varchar(100) not null,
    CODE varchar(5) not null,
    NOT_RELEVANT boolean,
    PROJECT_MCO boolean,
    NOT_AVAILABLE boolean,
    ASSET_ID varchar(36),
    DESCRIPTION varchar(250),
    --
    primary key (ID)
);