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
);