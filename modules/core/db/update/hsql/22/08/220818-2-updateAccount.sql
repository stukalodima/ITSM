alter table FINANCE_ACCOUNT alter column NAME rename to NAME__U06129 ^
alter table FINANCE_ACCOUNT alter column NAME__U06129 set null ;
alter table FINANCE_ACCOUNT add column CLOSE_ boolean ;
alter table FINANCE_ACCOUNT add column LOCK_ boolean ;
alter table FINANCE_ACCOUNT add column TYPE_ID varchar(36) ;
alter table FINANCE_ACCOUNT add column END_DATE date ;
alter table FINANCE_ACCOUNT add column START_DATE date ;
alter table FINANCE_ACCOUNT alter column IBAN set data type varchar(50) ;
