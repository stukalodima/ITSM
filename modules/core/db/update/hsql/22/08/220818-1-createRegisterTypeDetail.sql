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
);