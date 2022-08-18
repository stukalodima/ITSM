alter table FINANCE_PAYMENT_CLAIM alter column STATUS rename to STATUS__U65920 ^
alter table FINANCE_PAYMENT_CLAIM alter column STATUS__U65920 set null ;
alter table FINANCE_PAYMENT_CLAIM add column BUDGET_ANALITIC longvarchar ;
alter table FINANCE_PAYMENT_CLAIM add column STATUS_ID varchar(36) ;
alter table FINANCE_PAYMENT_CLAIM add column EXPRESS boolean ;
update FINANCE_PAYMENT_CLAIM set SUMM = 0 where SUMM is null ;
alter table FINANCE_PAYMENT_CLAIM alter column SUMM set not null ;
