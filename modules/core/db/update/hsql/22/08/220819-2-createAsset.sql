alter table FINANCE_ASSET add constraint FK_FINANCE_ASSET_ON_COMPANY foreign key (COMPANY_ID) references FINANCE_COMPANY(ID);
create index IDX_FINANCE_ASSET_ON_COMPANY on FINANCE_ASSET (COMPANY_ID);