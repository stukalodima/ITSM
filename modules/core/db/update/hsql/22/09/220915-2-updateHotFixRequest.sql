alter table FINANCE_HOT_FIX_REQUEST alter column NUMBER rename to NUMBER__U34629 ^
alter table FINANCE_HOT_FIX_REQUEST add column ACCED_ID varchar(36) ;
alter table FINANCE_HOT_FIX_REQUEST add column NUMBER varchar(255) ;
