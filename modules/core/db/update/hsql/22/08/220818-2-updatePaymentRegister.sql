alter table FINANCE_PAYMENT_REGISTER alter column STATUS rename to STATUS__U18180 ^
alter table FINANCE_PAYMENT_REGISTER add column PROC_INSTANCE_ID varchar(36) ;
alter table FINANCE_PAYMENT_REGISTER add column SUMMA varchar(255) ;
alter table FINANCE_PAYMENT_REGISTER add column STATUS_ID varchar(36) ;
alter table FINANCE_PAYMENT_REGISTER add column REGISTER_TYPE_ID varchar(36) ;
