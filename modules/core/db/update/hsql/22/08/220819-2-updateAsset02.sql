alter table FINANCE_ASSET add constraint FK_FINANCE_ASSET_ON_RESPONSIBLE_BUSINESS foreign key (RESPONSIBLE_BUSINESS) references SEC_USER(ID);
create index IDX_FINANCE_ASSET_ON_RESPONSIBLE_BUSINESS on FINANCE_ASSET (RESPONSIBLE_BUSINESS);
