--------------------------------------------------------
--  File created - ������-����-11-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EMOJI
--------------------------------------------------------

  CREATE TABLE "EMOJI" 
   (	"ENO" NUMBER, 
	"ADDRESS" VARCHAR2(50), 
	"NAME" VARCHAR2(20)
   ) ;
 

   COMMENT ON COLUMN "EMOJI"."ADDRESS" IS '·����ַ';
 
   COMMENT ON COLUMN "EMOJI"."NAME" IS '����';
--------------------------------------------------------
--  DDL for Table FISHPOND
--------------------------------------------------------

  CREATE TABLE "FISHPOND" 
   (	"FNO" NUMBER, 
	"TITLE" VARCHAR2(40), 
	"SIGN" VARCHAR2(100), 
	"HEADIMG" VARCHAR2(20), 
	"LNO" NUMBER, 
	"UNO" NUMBER, 
	"CREATEDDATE" TIMESTAMP (6), 
	"STATUS" NUMBER
   ) ;
 

   COMMENT ON COLUMN "FISHPOND"."TITLE" IS '��������';
 
   COMMENT ON COLUMN "FISHPOND"."SIGN" IS '��������ǩ��';
 
   COMMENT ON COLUMN "FISHPOND"."HEADIMG" IS '����ͷ��';
 
   COMMENT ON COLUMN "FISHPOND"."UNO" IS '�����߱��';
 
   COMMENT ON COLUMN "FISHPOND"."CREATEDDATE" IS '��������';
 
   COMMENT ON COLUMN "FISHPOND"."STATUS" IS '0 1 �Ƿ񶳽�';
--------------------------------------------------------
--  DDL for Table LABEL
--------------------------------------------------------

  CREATE TABLE "LABEL" 
   (	"LNO" NUMBER, 
	"NAME" VARCHAR2(20)
   ) ;
 

   COMMENT ON COLUMN "LABEL"."NAME" IS '��ǩ��';
--------------------------------------------------------
--  DDL for Table RECORD
--------------------------------------------------------

  CREATE TABLE "RECORD" 
   (	"UNO" NUMBER, 
	"TNO" NUMBER, 
	"CREATEDATE" TIMESTAMP (6)
   ) ;
 

   COMMENT ON COLUMN "RECORD"."UNO" IS '��ǰ';
 
   COMMENT ON COLUMN "RECORD"."TNO" IS '����Ļ���ID';
 
   COMMENT ON COLUMN "RECORD"."CREATEDATE" IS '����ʱ��';
--------------------------------------------------------
--  DDL for Table TOPIC1
--------------------------------------------------------

  CREATE TABLE "TOPIC1" 
   (	"TNO" NUMBER, 
	"TITLE" VARCHAR2(30 CHAR), 
	"UNO" NUMBER, 
	"CONTENT" VARCHAR2(1000 CHAR), 
	"CREATEDATE" TIMESTAMP (6), 
	"STATUS" NUMBER, 
	"PNO" NUMBER
   ) ;
 

   COMMENT ON COLUMN "TOPIC1"."TITLE" IS '���ӱ���';
 
   COMMENT ON COLUMN "TOPIC1"."UNO" IS '�����û�ID';
 
   COMMENT ON COLUMN "TOPIC1"."CONTENT" IS '�������� ����ͼƬ';
 
   COMMENT ON COLUMN "TOPIC1"."CREATEDATE" IS '��������';
 
   COMMENT ON COLUMN "TOPIC1"."STATUS" IS '0 1 �Ƿ񶳽���';
 
   COMMENT ON COLUMN "TOPIC1"."PNO" IS '���������';
--------------------------------------------------------
--  DDL for Table TOPIC2
--------------------------------------------------------

  CREATE TABLE "TOPIC2" 
   (	"TNO" NUMBER, 
	"UNO" NUMBER, 
	"CONTENT" VARCHAR2(300), 
	"TNO1" NUMBER, 
	"CREATEDATE" TIMESTAMP (6), 
	"STATUS" NUMBER
   ) ;
 

   COMMENT ON COLUMN "TOPIC2"."TNO" IS '���';
 
   COMMENT ON COLUMN "TOPIC2"."UNO" IS '�ظ���ID';
 
   COMMENT ON COLUMN "TOPIC2"."CONTENT" IS '�ظ���������';
 
   COMMENT ON COLUMN "TOPIC2"."TNO1" IS 'С���� topic1���';
 
   COMMENT ON COLUMN "TOPIC2"."CREATEDATE" IS '��������';
 
   COMMENT ON COLUMN "TOPIC2"."STATUS" IS '01�Ƿ�Ϊ����';
--------------------------------------------------------
--  DDL for Table TOPIC3
--------------------------------------------------------

  CREATE TABLE "TOPIC3" 
   (	"TNO" NUMBER, 
	"UNO1" NUMBER, 
	"UNO2" NUMBER, 
	"UNO3" NUMBER, 
	"CONTENT" VARCHAR2(300), 
	"CREATEDATE" TIMESTAMP (6), 
	"STATUS" NUMBER, 
	"TNO2" NUMBER
   ) ;
 

   COMMENT ON COLUMN "TOPIC3"."UNO1" IS '�²���';
 
   COMMENT ON COLUMN "TOPIC3"."UNO2" IS '���²���';
 
   COMMENT ON COLUMN "TOPIC3"."UNO3" IS '��ǰ����';
 
   COMMENT ON COLUMN "TOPIC3"."CONTENT" IS '�ظ����� ����ͼƬ �б��飩';
 
   COMMENT ON COLUMN "TOPIC3"."CREATEDATE" IS '����ʱ��';
 
   COMMENT ON COLUMN "TOPIC3"."STATUS" IS '01 �Ƿ�Ϊ����';
 
   COMMENT ON COLUMN "TOPIC3"."TNO2" IS 'Topic2���';
--------------------------------------------------------
--  DDL for Table USERALARM
--------------------------------------------------------

  CREATE TABLE "USERALARM" 
   (	"UNO1" NUMBER, 
	"UNO2" NUMBER, 
	"MSGTYPE" NUMBER, 
	"MSG" VARCHAR2(200), 
	"ISREAD" NUMBER, 
	"TNO1" NUMBER, 
	"UANO" NUMBER
   ) ;
 

   COMMENT ON COLUMN "USERALARM"."UNO1" IS ' �յ���Ϣ��ID';
 
   COMMENT ON COLUMN "USERALARM"."UNO2" IS '������Ϣ��ID';
 
   COMMENT ON COLUMN "USERALARM"."MSGTYPE" IS '1.�ظ� 2.˽�� 3.���� 4.ϵͳ֪ͨ 5.����@';
 
   COMMENT ON COLUMN "USERALARM"."ISREAD" IS '�Ƿ��Ѷ�  01δ��';
 
   COMMENT ON COLUMN "USERALARM"."TNO1" IS 'С�������';
 
   COMMENT ON COLUMN "USERALARM"."UANO" IS '��ţ�ʱ������';
--------------------------------------------------------
--  DDL for Table USERCOLL
--------------------------------------------------------

  CREATE TABLE "USERCOLL" 
   (	"UNO" NUMBER, 
	"TNO1" NUMBER
   ) ;
 

   COMMENT ON COLUMN "USERCOLL"."UNO" IS '��ǰ�û�';
--------------------------------------------------------
--  DDL for Table USERFOCUS_POUND
--------------------------------------------------------

  CREATE TABLE "USERFOCUS_POUND" 
   (	"UNO" NUMBER, 
	"TNO1" NUMBER, 
	"LEVEL" NUMBER, 
	"EXP" NUMBER
   ) ;
 

   COMMENT ON COLUMN "USERFOCUS_POUND"."UNO" IS '�û�id';
 
   COMMENT ON COLUMN "USERFOCUS_POUND"."TNO1" IS '���id';
 
   COMMENT ON COLUMN "USERFOCUS_POUND"."LEVEL" IS '�ղذ��ĵȼ�';
--------------------------------------------------------
--  DDL for Table USERFOCUS_USER
--------------------------------------------------------

  CREATE TABLE "USERFOCUS_USER" 
   (	"UNO1" NUMBER, 
	"UNO2" NUMBER
   ) ;
 

   COMMENT ON COLUMN "USERFOCUS_USER"."UNO1" IS '��ǰ�û�';
 
   COMMENT ON COLUMN "USERFOCUS_USER"."UNO2" IS '����ע���û�';
--------------------------------------------------------
--  DDL for Table USERHOBBY
--------------------------------------------------------

  CREATE TABLE "USERHOBBY" 
   (	"UNO" NUMBER, 
	"NAME" VARCHAR2(20)
   ) ;
 

   COMMENT ON COLUMN "USERHOBBY"."NAME" IS '��������';
--------------------------------------------------------
--  DDL for Table USERINFO
--------------------------------------------------------

  CREATE TABLE "USERINFO" 
   (	"UNO" NUMBER, 
	"SEX" VARCHAR2(20), 
	"REALNAME" VARCHAR2(20), 
	"IDNUMBER" VARCHAR2(20), 
	"CREATEDATE" TIMESTAMP (6), 
	"STATUS" NUMBER, 
	"SIGN" VARCHAR2(200), 
	"SIGNN" NUMBER
   ) ;
 

   COMMENT ON COLUMN "USERINFO"."IDNUMBER" IS '���֤����';
 
   COMMENT ON COLUMN "USERINFO"."CREATEDATE" IS '�˺� ����ʱ��';
 
   COMMENT ON COLUMN "USERINFO"."STATUS" IS '�Ƿ�Ϊ����״̬     1  0��ʾ�Ƿ񶳽�';
 
   COMMENT ON COLUMN "USERINFO"."SIGN" IS '����ǩ��';
 
   COMMENT ON COLUMN "USERINFO"."SIGNN" IS '0 1�����Ƿ��Ѿ�ǩ��';
--------------------------------------------------------
--  DDL for Table USERLIKE
--------------------------------------------------------

  CREATE TABLE "USERLIKE" 
   (	"UNO" NUMBER, 
	"TNO1" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"UNO" NUMBER, 
	"UNAME" VARCHAR2(20), 
	"UEMAIL" VARCHAR2(20), 
	"UPHONE" VARCHAR2(20), 
	"UPASSWORD" VARCHAR2(20), 
	"UHEADIMG" VARCHAR2(255)
   ) ;

---------------------------------------------------
--   DATA FOR TABLE EMOJI
--   FILTER = none used
---------------------------------------------------
REM INSERTING into EMOJI

---------------------------------------------------
--   END DATA FOR TABLE EMOJI
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERINFO
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERINFO
Insert into USERINFO (UNO,SEX,REALNAME,IDNUMBER,CREATEDATE,STATUS,SIGN,SIGNN) values (9,'��','ׯ���','445221199512263250',to_timestamp('11-8�� -17 03.12.54.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,'���Ǵ�ȣ�¯ʯ��˵��������棡',0);
Insert into USERINFO (UNO,SEX,REALNAME,IDNUMBER,CREATEDATE,STATUS,SIGN,SIGNN) values (10,'gay','С��','1654654',to_timestamp('11-8�� -17 04.21.31.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,null,0);

---------------------------------------------------
--   END DATA FOR TABLE USERINFO
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE LABEL
--   FILTER = none used
---------------------------------------------------
REM INSERTING into LABEL
Insert into LABEL (LNO,NAME) values (1,'����');
Insert into LABEL (LNO,NAME) values (2,'����');
Insert into LABEL (LNO,NAME) values (3,'��Ӱ');
Insert into LABEL (LNO,NAME) values (4,'����');

---------------------------------------------------
--   END DATA FOR TABLE LABEL
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERALARM
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERALARM
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (1,2,1,null,0,1,1);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (9,9,1,'�ҵĿ����ǲ��Ǻ�6��',0,20,5);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (2,9,1,'dgsdfgdsfg',0,21,9);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (9,2,1,'66666666',0,21,8);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (9,9,1,'������',0,20,6);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (2,2,1,'�������������ķɻ��ϵĿ��������Ǵ�',0,1,2);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (2,2,1,'?????��????????????????????????',1,19,3);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (2,2,1,'�����',1,19,4);
Insert into USERALARM (UNO1,UNO2,MSGTYPE,MSG,ISREAD,TNO1,UANO) values (9,2,1,'66666666',0,20,7);

---------------------------------------------------
--   END DATA FOR TABLE USERALARM
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERCOLL
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERCOLL
Insert into USERCOLL (UNO,TNO1) values (1,1);
Insert into USERCOLL (UNO,TNO1) values (1,2);
Insert into USERCOLL (UNO,TNO1) values (1,3);
Insert into USERCOLL (UNO,TNO1) values (1,4);
Insert into USERCOLL (UNO,TNO1) values (1,5);
Insert into USERCOLL (UNO,TNO1) values (1,6);
Insert into USERCOLL (UNO,TNO1) values (1,7);
Insert into USERCOLL (UNO,TNO1) values (1,8);
Insert into USERCOLL (UNO,TNO1) values (1,9);

---------------------------------------------------
--   END DATA FOR TABLE USERCOLL
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE FISHPOND
--   FILTER = none used
---------------------------------------------------
REM INSERTING into FISHPOND
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (1,'���ְ�','һ��������������',null,2,1,to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (2,'��Ӱ��','see',null,3,1,to_timestamp('03-8�� -12 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (5,'������',null,null,1,1,to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (3,'��Ӱ��1','see',null,3,1,to_timestamp('03-8�� -12 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (4,'��Ӱ��2','see',null,3,1,to_timestamp('03-8�� -12 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (6,'���ְ�1','һ��������������',null,2,1,to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (7,'���ְ�2','һ��������������',null,2,1,to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into FISHPOND (FNO,TITLE,SIGN,HEADIMG,LNO,UNO,CREATEDDATE,STATUS) values (8,'���ְ�3','һ��������������',null,2,1,to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);

---------------------------------------------------
--   END DATA FOR TABLE FISHPOND
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE RECORD
--   FILTER = none used
---------------------------------------------------
REM INSERTING into RECORD
Insert into RECORD (UNO,TNO,CREATEDATE) values (1,1,to_timestamp('04-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (2,1,to_timestamp('04-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (3,1,to_timestamp('04-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (2,2,to_timestamp('04-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (2,21,to_timestamp('11-8�� -17 04.42.54.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (3,21,to_timestamp('11-8�� -17 04.42.54.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));
Insert into RECORD (UNO,TNO,CREATEDATE) values (4,21,to_timestamp('04-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'));

---------------------------------------------------
--   END DATA FOR TABLE RECORD
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERS
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERS
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (1,'zhangsan',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (2,'lisi',null,null,'123','��������logo.jpg');
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (3,'zhaowu',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (4,'a1',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (5,'a2',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (7,'a3',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (6,'a4',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (8,'a5',null,null,'123',null);
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (9,'FelixV','1231as5d64as@163.com',null,'123456','1310111640652711.jpg');
Insert into USERS (UNO,UNAME,UEMAIL,UPHONE,UPASSWORD,UHEADIMG) values (10,'GG123123','123123123asd@163.com',null,'123123','��������logo.jpg');

---------------------------------------------------
--   END DATA FOR TABLE USERS
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERFOCUS_POUND
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERFOCUS_POUND
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,1,0,2131);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,2,0,4867);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,3,null,2315);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,4,null,786);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,5,null,456);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,7,null,21321);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,6,null,3543);
Insert into USERFOCUS_POUND (UNO,TNO1,LEVEL,EXP) values (1,8,null,21);

---------------------------------------------------
--   END DATA FOR TABLE USERFOCUS_POUND
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERFOCUS_USER
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERFOCUS_USER
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,3);
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,4);
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,5);
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,6);
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,7);
Insert into USERFOCUS_USER (UNO1,UNO2) values (1,8);
Insert into USERFOCUS_USER (UNO1,UNO2) values (2,1);

---------------------------------------------------
--   END DATA FOR TABLE USERFOCUS_USER
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE TOPIC1
--   FILTER = none used
---------------------------------------------------
REM INSERTING into TOPIC1
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (1,'�й���0',1,'������',to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (2,'����һ�ײ���ĸ���1',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (3,'����һ�ײ���ĸ���2',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (4,'����һ�ײ���ĸ���3',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (5,'����һ�ײ���ĸ���4',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (6,'����һ�ײ���ĸ���5',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (7,'����һ�ײ���ĸ���6',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (8,'����һ�ײ���ĸ���7',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (9,'����һ�ײ���ĸ���8',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (10,'����һ�ײ���ĸ���9',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (11,'����һ�ײ���ĸ���10',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (12,'����һ�ײ���ĸ���11',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (13,'����һ�ײ���ĸ���12',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (14,'����һ�ײ���ĸ���13',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (15,'����һ�ײ���ĸ���14',1,'���',to_timestamp('03-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (16,'��������˾��������12',2,'���ľ��츶��ȹ�����ֿ������ž�',to_timestamp('06-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (17,'��������˾��������13',2,'���ľ��츶��ȹ�����ֿ������ž�',to_timestamp('06-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (18,'��������˾��������14',2,'���ľ��츶��ȹ�����ֿ������ž�',to_timestamp('06-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (20,'���Ǵ�ȣ�¯ʯ��˵��������棡Լ��Լ',9,'�����ҵ�ϥ��[ͼƬ��u=304395957,4126044093&fm=26&gp=0.jpg][ͼƬ��u=2349393586,1510236990&fm=26&gp=0.jpg][ͼƬ��u=3758321396,2942401232&fm=26&gp=0.jpg][ͼƬ��u=3992594058,396395192&fm=26&gp=0.jpg]',to_timestamp('11-8�� -17 03.33.49.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,5);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (21,'����һ�ײ���ĸ���14',9,'����һ�ײ���ĸ���14[ͼƬ��u=304395957,4126044093&fm=26&gp=0.jpg]asdas[ͼƬ��u=2349393586,1510236990&fm=26&gp=0.jpg]',to_timestamp('11-8�� -17 04.01.20.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,1);
Insert into TOPIC1 (TNO,TITLE,UNO,CONTENT,CREATEDATE,STATUS,PNO) values (19,'dasdasfkjsdklfasdasdasdasdas',2,'sdadasdasdasdasdassadasd',to_timestamp('11-8�� -17 01.29.50.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,5);

---------------------------------------------------
--   END DATA FOR TABLE TOPIC1
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE TOPIC2
--   FILTER = none used
---------------------------------------------------
REM INSERTING into TOPIC2
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (1,2,'һ��ʺ',1,to_timestamp('31-7�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (3,3,'����ɳ�����ķ�2',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (4,2,'����ɳ�����ķ�3',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (5,3,'����ɳ�����ķ�4',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (6,2,'����ɳ�����ķ�5',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (7,3,'����ɳ�����ķ�6',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (8,3,'����ɳ�����ķ�7',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (2,2,'����ɳ�����ķ�1',1,to_timestamp('08-8�� -17 12.00.00.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (10,9,'�ҵĿ����ǲ��Ǻ�6��',20,to_timestamp('11-8�� -17 03.34.22.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (12,2,'66666666',21,to_timestamp('11-8�� -17 04.01.53.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (9,2,'ttttttttttttttt',19,to_timestamp('11-8�� -17 02.54.24.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);
Insert into TOPIC2 (TNO,UNO,CONTENT,TNO1,CREATEDATE,STATUS) values (11,2,'66666666',20,to_timestamp('11-8�� -17 03.54.27.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0);

---------------------------------------------------
--   END DATA FOR TABLE TOPIC2
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE TOPIC3
--   FILTER = none used
---------------------------------------------------
REM INSERTING into TOPIC3
Insert into TOPIC3 (TNO,UNO1,UNO2,UNO3,CONTENT,CREATEDATE,STATUS,TNO2) values (2,2,2,2,'�����',to_timestamp('11-8�� -17 02.54.41.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,9);
Insert into TOPIC3 (TNO,UNO1,UNO2,UNO3,CONTENT,CREATEDATE,STATUS,TNO2) values (4,9,2,2,'dgsdfgdsfg',to_timestamp('11-8�� -17 04.02.16.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,12);
Insert into TOPIC3 (TNO,UNO1,UNO2,UNO3,CONTENT,CREATEDATE,STATUS,TNO2) values (1,2,2,2,'�������������ķɻ��ϵĿ��������Ǵ�',to_timestamp('11-8�� -17 02.22.14.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,6);
Insert into TOPIC3 (TNO,UNO1,UNO2,UNO3,CONTENT,CREATEDATE,STATUS,TNO2) values (3,9,9,9,'������',to_timestamp('11-8�� -17 03.34.41.000000000 ����','DD-MON-RR HH.MI.SS.FF AM'),0,10);

---------------------------------------------------
--   END DATA FOR TABLE TOPIC3
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERHOBBY
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERHOBBY

---------------------------------------------------
--   END DATA FOR TABLE USERHOBBY
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE USERLIKE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERLIKE

---------------------------------------------------
--   END DATA FOR TABLE USERLIKE
---------------------------------------------------

--------------------------------------------------------
--  Constraints for Table FISHPOND
--------------------------------------------------------

  ALTER TABLE "FISHPOND" ADD CONSTRAINT "FISHPOND_PK" PRIMARY KEY ("FNO") ENABLE;
 
  ALTER TABLE "FISHPOND" MODIFY ("FNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LABEL
--------------------------------------------------------

  ALTER TABLE "LABEL" ADD CONSTRAINT "LABEL_PK" PRIMARY KEY ("LNO") ENABLE;
 
  ALTER TABLE "LABEL" MODIFY ("LNO" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table TOPIC1
--------------------------------------------------------

  ALTER TABLE "TOPIC1" MODIFY ("TNO" NOT NULL ENABLE);
 
  ALTER TABLE "TOPIC1" ADD CONSTRAINT "TOPIC1_PK" PRIMARY KEY ("TNO") ENABLE;
--------------------------------------------------------
--  Constraints for Table TOPIC2
--------------------------------------------------------

  ALTER TABLE "TOPIC2" MODIFY ("TNO" NOT NULL ENABLE);
 
  ALTER TABLE "TOPIC2" ADD CONSTRAINT "TOPIC2_PK" PRIMARY KEY ("TNO") ENABLE;
--------------------------------------------------------
--  Constraints for Table TOPIC3
--------------------------------------------------------

  ALTER TABLE "TOPIC3" MODIFY ("TNO" NOT NULL ENABLE);
 
  ALTER TABLE "TOPIC3" ADD CONSTRAINT "TOPIC3_PK" PRIMARY KEY ("TNO") ENABLE;
--------------------------------------------------------
--  Constraints for Table USERALARM
--------------------------------------------------------

  ALTER TABLE "USERALARM" MODIFY ("UANO" NOT NULL ENABLE);
 
  ALTER TABLE "USERALARM" ADD CONSTRAINT "USERALARM_PK" PRIMARY KEY ("UANO") ENABLE;




--------------------------------------------------------
--  Constraints for Table USERINFO
--------------------------------------------------------

  ALTER TABLE "USERINFO" MODIFY ("UNO" NOT NULL ENABLE);
 
  ALTER TABLE "USERINFO" ADD CONSTRAINT "TABLE1_PK" PRIMARY KEY ("UNO") ENABLE;

--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" MODIFY ("UNO" NOT NULL ENABLE);
 
  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("UNO") ENABLE;
--------------------------------------------------------
--  DDL for Index FISHPOND_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FISHPOND_PK" ON "FISHPOND" ("FNO") 
  ;
--------------------------------------------------------
--  DDL for Index LABEL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LABEL_PK" ON "LABEL" ("LNO") 
  ;
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TABLE1_PK" ON "USERINFO" ("UNO") 
  ;
--------------------------------------------------------
--  DDL for Index TOPIC1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOPIC1_PK" ON "TOPIC1" ("TNO") 
  ;
--------------------------------------------------------
--  DDL for Index TOPIC2_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOPIC2_PK" ON "TOPIC2" ("TNO") 
  ;
--------------------------------------------------------
--  DDL for Index TOPIC3_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOPIC3_PK" ON "TOPIC3" ("TNO") 
  ;
--------------------------------------------------------
--  DDL for Index USERALARM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERALARM_PK" ON "USERALARM" ("UANO") 
  ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("UNO") 
  ;

--------------------------------------------------------
--  Ref Constraints for Table FISHPOND
--------------------------------------------------------

  ALTER TABLE "FISHPOND" ADD CONSTRAINT "FISHPOND_LABEL_FK1" FOREIGN KEY ("LNO")
	  REFERENCES "LABEL" ("LNO") ENABLE;
 
  ALTER TABLE "FISHPOND" ADD CONSTRAINT "FISHPOND_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table RECORD
--------------------------------------------------------

  ALTER TABLE "RECORD" ADD CONSTRAINT "RECORD_TOPIC1_FK1" FOREIGN KEY ("TNO")
	  REFERENCES "TOPIC1" ("TNO") ENABLE;
 
  ALTER TABLE "RECORD" ADD CONSTRAINT "RECORD_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TOPIC1
--------------------------------------------------------

  ALTER TABLE "TOPIC1" ADD CONSTRAINT "TOPIC1_FISHPOND_FK1" FOREIGN KEY ("PNO")
	  REFERENCES "FISHPOND" ("FNO") ENABLE;
 
  ALTER TABLE "TOPIC1" ADD CONSTRAINT "TOPIC1_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TOPIC2
--------------------------------------------------------

  ALTER TABLE "TOPIC2" ADD CONSTRAINT "TOPIC2_TOPIC1_FK1" FOREIGN KEY ("TNO1")
	  REFERENCES "TOPIC1" ("TNO") ENABLE;
 
  ALTER TABLE "TOPIC2" ADD CONSTRAINT "TOPIC2_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TOPIC3
--------------------------------------------------------

  ALTER TABLE "TOPIC3" ADD CONSTRAINT "TOPIC3_TOPIC2_FK1" FOREIGN KEY ("TNO2")
	  REFERENCES "TOPIC2" ("TNO") ENABLE;
 
  ALTER TABLE "TOPIC3" ADD CONSTRAINT "TOPIC3_USERS_FK1" FOREIGN KEY ("UNO1")
	  REFERENCES "USERS" ("UNO") ENABLE;
 
  ALTER TABLE "TOPIC3" ADD CONSTRAINT "TOPIC3_USERS_FK2" FOREIGN KEY ("UNO2")
	  REFERENCES "USERS" ("UNO") ENABLE;
 
  ALTER TABLE "TOPIC3" ADD CONSTRAINT "TOPIC3_USERS_FK3" FOREIGN KEY ("UNO3")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERALARM
--------------------------------------------------------

  ALTER TABLE "USERALARM" ADD CONSTRAINT "USERALARM_TOPIC1_FK1" FOREIGN KEY ("TNO1")
	  REFERENCES "TOPIC1" ("TNO") ENABLE;
 
  ALTER TABLE "USERALARM" ADD CONSTRAINT "USERALARM_USERS_FK1" FOREIGN KEY ("UNO1")
	  REFERENCES "USERS" ("UNO") ENABLE;
 
  ALTER TABLE "USERALARM" ADD CONSTRAINT "USERALARM_USERS_FK2" FOREIGN KEY ("UNO2")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERCOLL
--------------------------------------------------------

  ALTER TABLE "USERCOLL" ADD CONSTRAINT "USERCOLL_TOPIC1_FK1" FOREIGN KEY ("TNO1")
	  REFERENCES "TOPIC1" ("TNO") ENABLE;
 
  ALTER TABLE "USERCOLL" ADD CONSTRAINT "USERCOLL_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERFOCUS_POUND
--------------------------------------------------------

  ALTER TABLE "USERFOCUS_POUND" ADD CONSTRAINT "USERFOCUS_POUND_FISHPOND_FK1" FOREIGN KEY ("TNO1")
	  REFERENCES "FISHPOND" ("FNO") ENABLE;
 
  ALTER TABLE "USERFOCUS_POUND" ADD CONSTRAINT "USERFOCUS_POUND_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERFOCUS_USER
--------------------------------------------------------

  ALTER TABLE "USERFOCUS_USER" ADD CONSTRAINT "USERFOCUS_USERS_FK1" FOREIGN KEY ("UNO1")
	  REFERENCES "USERS" ("UNO") ENABLE;
 
  ALTER TABLE "USERFOCUS_USER" ADD CONSTRAINT "USERFOCUS_USERS_FK2" FOREIGN KEY ("UNO2")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERHOBBY
--------------------------------------------------------

  ALTER TABLE "USERHOBBY" ADD CONSTRAINT "USERHOBBY_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERINFO
--------------------------------------------------------

  ALTER TABLE "USERINFO" ADD CONSTRAINT "TABLE1_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERLIKE
--------------------------------------------------------

  ALTER TABLE "USERLIKE" ADD CONSTRAINT "USERLIKE_TOPIC1_FK1" FOREIGN KEY ("TNO1")
	  REFERENCES "TOPIC1" ("TNO") ENABLE;
 
  ALTER TABLE "USERLIKE" ADD CONSTRAINT "USERLIKE_USERS_FK1" FOREIGN KEY ("UNO")
	  REFERENCES "USERS" ("UNO") ENABLE;

