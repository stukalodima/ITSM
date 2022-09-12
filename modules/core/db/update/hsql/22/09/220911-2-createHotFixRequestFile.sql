alter table FINANCE_HOT_FIX_REQUEST_FILE add constraint FK_FINANCE_HOT_FIX_REQUEST_FILE_ON_DOCUMENT foreign key (DOCUMENT_ID) references SYS_FILE(ID);
alter table FINANCE_HOT_FIX_REQUEST_FILE add constraint FK_FINANCE_HOT_FIX_REQUEST_FILE_ON_HOT_FIX_REQUEST foreign key (HOT_FIX_REQUEST_ID) references FINANCE_HOT_FIX_REQUEST(ID);
create index IDX_FINANCE_HOT_FIX_REQUEST_FILE_ON_DOCUMENT on FINANCE_HOT_FIX_REQUEST_FILE (DOCUMENT_ID);
create index IDX_FINANCE_HOT_FIX_REQUEST_FILE_ON_HOT_FIX_REQUEST on FINANCE_HOT_FIX_REQUEST_FILE (HOT_FIX_REQUEST_ID);
