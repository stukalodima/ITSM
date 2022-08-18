alter table FINANCE_CURRENCY_RATE add constraint FK_FINANCE_CURRENCY_RATE_ON_CURRENCY foreign key (CURRENCY_ID) references FINANCE_CURRENCY(ID);
create index IDX_FINANCE_CURRENCY_RATE_ON_CURRENCY on FINANCE_CURRENCY_RATE (CURRENCY_ID);
