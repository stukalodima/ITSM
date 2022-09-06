alter table FINANCE_ISSUE add constraint FK_FINANCE_ISSUE_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID);
create index IDX_FINANCE_ISSUE_ON_AUTHOR on FINANCE_ISSUE (AUTHOR_ID);
