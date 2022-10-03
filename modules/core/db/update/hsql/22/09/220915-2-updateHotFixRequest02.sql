alter table FINANCE_HOT_FIX_REQUEST alter column ACCED_ID rename to ACCED_ID__U92861 ^
alter table FINANCE_HOT_FIX_REQUEST drop constraint FK_FINANCE_HOT_FIX_REQUEST_ON_ACCED ;
drop index IDX_FINANCE_HOT_FIX_REQUEST_ON_ACCED ;
alter table FINANCE_HOT_FIX_REQUEST add column ASSET_ID varchar(36) ;
