alter table BPM_PROC_INSTANCE add constraint FK_BPM_PROC_INSTANCE_ON_PAYMENT_REGISTER foreign key (PAYMENT_REGISTER_ID) references FINANCE_PAYMENT_REGISTER(ID);
create index IDX_BPM_PROC_INSTANCE_ON_PAYMENT_REGISTER on BPM_PROC_INSTANCE (PAYMENT_REGISTER_ID);
