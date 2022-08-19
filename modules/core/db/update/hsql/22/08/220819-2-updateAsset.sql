alter table FINANCE_ASSET add column ASSET_STATES varchar(50) ;
alter table FINANCE_ASSET add column EXPIRY_DATE timestamp ;
alter table FINANCE_ASSET add column COMMISSIONING_DATE timestamp ;
alter table FINANCE_ASSET add column COMMENT varchar(255) ;
alter table FINANCE_ASSET add column RESPONSIBLE_IT varchar(36) ;
alter table FINANCE_ASSET add column RESPONSIBLE_BUSINESS varchar(36) ;
