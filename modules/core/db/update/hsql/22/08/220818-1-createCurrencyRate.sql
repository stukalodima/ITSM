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
);