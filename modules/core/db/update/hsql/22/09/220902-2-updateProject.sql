alter table FINANCE_PROJECT alter column ASSET_ID rename to ASSET_ID__U15422 ^
alter table FINANCE_PROJECT drop constraint FK_FINANCE_PROJECT_ON_ASSET ;
drop index IDX_FINANCE_PROJECT_ON_ASSET ;
alter table FINANCE_PROJECT alter column NOT_AVAILABLE rename to NOT_AVAILABLE__U79831 ^
alter table FINANCE_PROJECT alter column PROJECT_MCO rename to PROJECT_MCO__U51897 ^
alter table FINANCE_PROJECT add column SHUT boolean ;
alter table FINANCE_PROJECT add column END_DATE date ;
alter table FINANCE_PROJECT add column START_DATE date ;
alter table FINANCE_PROJECT add column MANAGER_ID varchar(36) ;
