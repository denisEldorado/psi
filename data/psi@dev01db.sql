ALTER TABLE FCT_MOM_ITEMISEDAIRTELMONEY
  ADD DestinationAccountId VARCHAR2(500 CHAR);


create TABLE FCT_MOMA_TRANSACTION_SUMMARY(
ID NUMBER not NULL PRIMARY KEY,
AccountType VARCHAR2(150 CHAR),
TotalGSMExpenditure NUMBER(30,4),
TotalAMDebits  NUMBER(30,4),
TotalAMCredits  NUMBER(30,4),
TotalSMS  NUMBER(30,4),
TotalUSSD  NUMBER(30,4),
TotalVoiceCalls  NUMBER(30,4),
TotalRoamingCF  NUMBER(30,4),
TotalContentDownload  NUMBER(30,4),
TotalHybridBundles  NUMBER(30,4),
TotalMMS  NUMBER(30,4),
TotalCF  NUMBER(30,4),
TotalGPRS  NUMBER(30,4),
TotalData  NUMBER(30,4),
TotalCashIn  NUMBER(30,4),
TotalCashOut  NUMBER(30,4),
TotalAMTopup  NUMBER(30,4),
TotalMerchantPayments  NUMBER(30,4),
TotalP2P  NUMBER(30,4),
TotalWalletLoad  NUMBER(30,4),
TotalPOSWithdrawal  NUMBER(30,4),
CREATEDON DATE DEFAULT SYSDATE NOT NULL )
PARTITION BY RANGE (CREATEDON) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "TAU_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00'));

alter table FCT_MOM_TRANSACTION_SUMMARY add accountId VARCHAR2(500 CHAR);
alter table FCT_MOM_TRANSACTION_SUMMARY add MostFrequentLocation VARCHAR2(500 CHAR);

CREATE SEQUENCE  "FCT_MOMATRANSACTIONSUMMARY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger FCT_MOM_GSMITEMISED_TRG' || chr(10) ||
                    '   before insert on FCT_MOM_GSMITEMISED ' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select FCT_MOM_GSMITEMISED_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


CREATE SEQUENCE  FCT_MOM_TRANSACTION_SUMMARY_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  FCT_MOM_REGISTRY_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  FCT_MOM_ITEMISEDAIRTELMONEY_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  FCT_MOM_GSM_SERVICE_SUMMARY_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  FCT_MOM_GSMITEMISED_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


create TABLE FCT_MOM_GSM_SERVICE_SUMMARY(
  ID NUMBER not NULL PRIMARY KEY,
  AccountId VARCHAR2(250 char),
  TransactionType VARCHAR2(250 char),
  Timestamp date default sysdate,
  GrossAmount NUMBER(30,4),
  CREATEDON DATE DEFAULT SYSDATE NOT NULL )
PARTITION BY RANGE (CREATEDON) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "TAU_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00'));

CREATE SEQUENCE  "FCT_MOM_GSM_SERVICE_SUMMARY_SQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger FCT_MOM_GSM_SERVICE_SUMMARY_TG  ' || chr(10) ||
                    '   before insert on FCT_MOM_GSM_SERVICE_SUMMARY ' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select FCT_MOM_GSM_SERVICE_SUMMARY_SQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


create TABLE FCT_MOM_AM_SERVICE_DETAILS(
  ID NUMBER not NULL PRIMARY KEY,
  AccountId VARCHAR2(250 char),
TransactionType VARCHAR2(500 CHAR),
GrossAmount NUMBER(30,4),
CREATEDON DATE DEFAULT SYSDATE NOT NULL )
PARTITION BY RANGE (CREATEDON) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "TAU_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00'));


CREATE SEQUENCE  "FCT_MOM_AM_SERVICE_DETAILS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger FCT_MOM_AM_SERVICE_DETAILS_TRG  ' || chr(10) ||
                    '   before insert on FCT_MOM_AM_SERVICE_DETAILS ' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select FCT_MOM_AM_SERVICE_DETAILS_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

SELECT 'CREATE SEQUENCE  '||table_name||'_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;' FROM ALL_TABLES where owner ='PSI' AND table_name like 'FCT_MOM%';

SELECT
  'CREATE SEQUENCE  ' || sequence_name || ' MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH '
  || last_number || ' CACHE 20 NOORDER  NOCYCLE ;'
FROM user_sequences
WHERE sequence_name LIKE 'FCT_MOM%';


ALTER SEQUENCE FCT_MOM_ITEMISEDAIRTELMONEY_SQ INCREMENT BY 100;
ALTER SEQUENCE FCT_MOM_GSMITEMISED_SEQ INCREMENT BY 100;
ALTER SEQUENCE FCT_MOM_GSMITEMISED_SEQ INCREMENT BY 100;

CREATE TABLE dat_registration_details (
  id                       NUMBER                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              NOT NULL PRIMARY KEY,
  accepted_terms           NUMBER(3, 0) DEFAULT 0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             NOT NULL,
  accepted_terms_date      DATE,
  first_name               VARCHAR2(250 CHAR)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 NOT NULL,
  last_name                VARCHAR2(250 CHAR)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 NOT NULL,
  middle_name              VARCHAR2(250 CHAR)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 NOT NULL,
  user_pin                 VARCHAR2(35 CHAR),
  user_msisdn              VARCHAR2(35 CHAR)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  NOT NULL UNIQUE,
  user_id_doc_type         NUMBER             DEFAULT 1 REFERENCES CFG_REGISTRATION_DOCS (id)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             NOT NULL,
  user_id_number           VARCHAR2(20 CHAR)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  NOT NULL UNIQUE,
  user_registration_status NUMBER(3, 0)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       NOT NULL,
  service_request          NUMBER REFERENCES CRM_SERVICE_REQUESTS (id)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        NOT NULL,
  registration_date        DATE DEFAULT sysdate                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               NOT NULL,
  iprs_validation_date     DATE,
  login_activation_date    DATE,
  organisation             NUMBER REFERENCES ADM_ORGANIZATIONS (id),
  account_number           VARCHAR2(350 CHAR),
  var_text_field_1         VARCHAR2(350 CHAR),
  var_text_field_2         VARCHAR2(350 CHAR),
  var_text_field_3         VARCHAR2(350 CHAR),
  var_text_field_4         VARCHAR2(350 CHAR),
  var_text_field_5         VARCHAR2(350 CHAR),
  var_text_field_6         VARCHAR2(350 CHAR),
  var_text_field_7         VARCHAR2(350 CHAR),
  var_text_field_8         VARCHAR2(350 CHAR),
  var_text_field_9         VARCHAR2(350 CHAR),
  var_text_field_10        VARCHAR2(350 CHAR),
  version                  NUMBER(3, 0) DEFAULT '0'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           NOT NULL,
  createdby                VARCHAR2(100 CHAR) DEFAULT 'admin',
  createdon                DATE               DEFAULT sysdate,
  modifiedby               VARCHAR2(100 CHAR) DEFAULT 'admin',
  modified_on              DATE               DEFAULT sysdate,
  deleteby                 VARCHAR2(100 CHAR) DEFAULT 'admin',
  deletedon                DATE
)
PARTITION BY RANGE (registration_date) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "PSI_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00')
);

CREATE SEQUENCE DAT_REGISTRATION_DETAILS_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger dat_registration_details_TRG  ' || chr(10) ||
                    '   before insert on dat_registration_details ' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select dat_registration_details_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

ALTER TABLE PSI.DAT_USSD_CODES
  ADD organization NUMBER DEFAULT 1 REFERENCES ADM_ORGANIZATIONS (ID) NOT NULL;

ALTER TABLE PSI.DAT_USSD_CODES
  ADD CONSTRAINT USSD_CODES_ORGANIZATIONS_ID_fk
FOREIGN KEY (organization) REFERENCES ADM_ORGANIZATIONS (ID);

CREATE INDEX IDX_REGISTRATION_DETAILS_SR
  ON DAT_REGISTRATION_DETAILS (service_request);

CREATE TABLE ADM_USSD_SESSIONS (
  id            NUMBER                                NOT NULL PRIMARY KEY,
  SESSION_ID VARCHAR2(100 CHAR),
  CREATION_TIME DATE DEFAULT sysdate                  NOT NULL,
  User_id       NUMBER REFERENCES ADM_PRINCIPALS (id) NOT NULL,
  VAR_FLD_01    VARCHAR2(255 CHAR),
  VAR_FLD_02    VARCHAR2(255 CHAR),
  VAR_FLD_03    VARCHAR2(255 CHAR),
  VAR_FLD_04    VARCHAR2(255 CHAR),
  VAR_FLD_05    VARCHAR2(255 CHAR),
  VAR_FLD_06    VARCHAR2(4000 CHAR),
  VAR_FLD_07    VARCHAR2(255 CHAR),
  VAR_FLD_08    VARCHAR2(255 CHAR),
  var_fld_09    VARCHAR2(255 CHAR),
  var_fld_10    VARCHAR2(255 CHAR),
  status        NUMBER DEFAULT 0                      NOT NULL
)
PARTITION BY RANGE (CREATION_TIME) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION TAU_20170107
    VALUES LESS THAN (TO_DATE(' 2017-01-08 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN'))
);

CREATE SEQUENCE ADM_USSD_SESSIONS_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger ADM_USSD_SESSIONS_TRG  ' || chr(10) ||
                    '   before insert on ADM_USSD_SESSIONS' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select ADM_USSD_SESSIONS_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


SELECT *
FROM DAT_USSD_MENU_IMSI_CODE_VW
WHERE USSD_CODE = '533*1' AND MENU_KEY = 'maishaAkibaAdvanceRequest';

SELECT * from DAT_USSD_MENUS WHERE id in (150, 151,144,146,200);


ALTER TABLE PSI.DAT_USSD_MENUS
  ADD FTU INT DEFAULT 0 NOT NULL;

SELECT *
FROM LOG_USSD_REQUESTS
WHERE SESSIONID = '20170411172157' ORDER BY id;

SELECT *
FROM LOG_USSD_REQUESTS
WHERE SESSIONID = '03042017183759' AND STATUS = '0' AND VAR_FLD_4 IS NOT NULL
ORDER BY ID;
-- SELECT u FROM UssdRequests u WHERE u.sessionid = :sessionid and u.status = :status and u.varFld4 is not null
SELECT *
FROM LOG_USSD_RESPONSES a
WHERE a.SEQUENCE_ID = '23032017234837';

select * from CFG_PRODUCT_PRV_TEMPLATES where PRODUCT_ID=18;
SELECT *
FROM CRM_ORDER_MASTER
WHERE SUBMITTED_DATE > trunc(sysdate -1);

TRUNCATE TABLE DAT_REGISTRATION_DETAILS;

ALTER TABLE PSI.ADM_PRINCIPALS ADD Registration_details NUMBER NULL;
ALTER TABLE PSI.ADM_PRINCIPALS ADD CONSTRAINT PRINCIPALS_REG_DETAILS_ID_fk FOREIGN KEY (Registration_details) REFERENCES DAT_REGISTRATION_DETAILS (ID) ON DELETE CASCADE;


DROP TABLE ADM_PERSISTENT_LOGINS;

CREATE TABLE ADM_PERSISTENT_LOGINS (
  username              VARCHAR2(200 CHAR) NOT NULL,
  series                VARCHAR(64) PRIMARY KEY,
  token                 VARCHAR(64)        NOT NULL,
  last_used             TIMESTAMP          NOT NULL,
  SESSION_ID            VARCHAR2(300 CHAR),
  CREATION_TIME         DATE,
  LAST_ACCESS_TIME      TIMESTAMP,
  MAX_INACTIVE_INTERVAL NUMBER,
  PRINCIPAL_NAME        VARCHAR2(200 CHAR)
);


CREATE TABLE ADM_SPRING_SESSION (
  SESSION_ID            CHAR(36),
  CREATION_TIME         NUMBER(19, 0) NOT NULL,
  LAST_ACCESS_TIME      NUMBER(19, 0) NOT NULL,
  MAX_INACTIVE_INTERVAL NUMBER(10, 0) NOT NULL,
  PRINCIPAL_NAME        VARCHAR2(100 CHAR),
  CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (SESSION_ID)
);

CREATE INDEX SPRING_SESSION_IX1
  ON ADM_SPRING_SESSION (LAST_ACCESS_TIME);

CREATE TABLE ADM_SPRING_SESSION_ATTRIBUTES (
  SESSION_ID      CHAR(36),
  ATTRIBUTE_NAME  VARCHAR2(200 CHAR),
  ATTRIBUTE_BYTES BLOB,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_ID, ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_ID) REFERENCES ADM_SPRING_SESSION (SESSION_ID) ON DELETE CASCADE
);

CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1
  ON ADM_SPRING_SESSION_ATTRIBUTES (SESSION_ID);

select ur.ID, ur.STATUS, p.LOGIN_NAME,p.STATUS user_status, r.ROLENAME FROM ADM_PRINCIPALS p, ADM_USER_ROLES ur, ADM_ROLES r
WHERE ur.USERID = p.ID
and ur.ROLEID = r.ID
ORDER BY p.ID;

UPDATE DAT_USSD_MENUS set MENU_IS_CHOICE = 0 where MENU_IS_CHOICE  is NULL ;

COMMIT ;

SELECT * FROM CFG_PRODUCT_PARAMETERS where ID = 18;

INSERT INTO PSI.CRM_PRICING_PROFILE (ID, APPLICATION_DST, WALLET_TYPE, WALLET, WALLET_VALUE, WALLET_DESC, PRIORITY, PRICING_PROFILE_TIER, PRODUCT_ID, APPLICATION_SRC, MAPPING_SUB_GROUP, STATUS) VALUES (18, 2, 1, 'AM', 0.0000, 'Deduct 0 from Airtel Money Account', 0, 1, 18, 1, 1, 1);

DROP INDEX PSI.SYS_C0010597;

ALTER TABLE PSI.DAT_REGISTRATION_DETAILS DROP CONSTRAINT SYS_C0010513;

ALTER TABLE PSI.DAT_REGISTRATION_DETAILS DROP CONSTRAINT SYS_C0010514;

ALTER TABLE PSI.ADM_USER_ROLES DROP CONSTRAINT SYS_C0010597;

CREATE UNIQUE INDEX PSI.SYS_C0010513 ON PSI.DAT_REGISTRATION_DETAILS(USER_MSISDN, USER_REGISTRATION_STATUS, FIRST_NAME, MIDDLE_NAME, LAST_NAME, USER_ID_DOC_TYPE, ID, USER_ID_NUMBER);

DELETE FROM DAT_REGISTRATION_DETAILS cascaded;

DELETE from DAT_USER_BENEFICIARIES;
DELETE from DAT_PRINCIPALS_LOANS cascaded;
DELETE from DAT_PRINCIPALS_GUARANTOR cascaded;
DELETE from DAT_PRINCIPALS_GUARANTOR;
DELETE FROM DAT_PRINCIPALS_SAVINGS_TARGETS;
DELETE FROM DAT_PRINCIPALS_CONTRIBUTIONS;

DELETE FROM ADM_USER_ROLES WHERE USERID not in (2,166);
DELETE FROM ADM_USER_SECURITY_QUESTIONS WHERE USER_ID not in (2,166);
DELETE FROM DAT_SACCO_REGISTRATION WHERE USER_ID not in (2,166);

DELETE FROM DAT_REGISTRATION_DETAILS;
COMMIT ;




SELECT * from user_constraints where constraint_name ='SYS_C0010645';

DELETE ADM_PRINCIPALS WHERE id not in (2,166);

SELECT max(id)FROM DAT_USSD_MENUS;

SELECT * from DAT_USSD_MENUS WHERE MENU_KEY IN ('oldPassword','changePassword', 'confirmPassword', 'confirmPinChange','notifyPinChange', 'confirmPinMenu') AND USSD_CODE_IMSI = 5;

UPDATE DAT_USSD_MENUS set STATUS=10 where id in (178,181,183,185,192);



create table cbm_Banks
(
  id NUMBER NOT NULL PRIMARY KEY ,
  BankName VARCHAR2(200 CHAR),
  BankCode VARCHAR2(50) not null,
  BankContactEmail VARCHAR2(50),
  BankPassword VARCHAR2(50),
  IsActive VARCHAR2(50),
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  PathToLogoImage VARCHAR2(1300 CHAR),
  PathToPublicKey VARCHAR2(1300 CHAR),
  ThemeColor VARCHAR2(50),
  NavbarTextColor VARCHAR2(50),
  BankVaultAccNumber VARCHAR2(50)
);

CREATE SEQUENCE CBM_BANKS_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_BANKS_TRG  ' || chr(10) ||
                    '   before insert on CBM_BANKS' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_BANKS_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/



create table CBM_BANK_BRANCHES
(
  Id NUMBER NOT NULL PRIMARY KEY ,
  BranchName NVARCHAR2(50),
  BranchCode NVARCHAR2(50),
  Location NVARCHAR2(100),
  IsActive NUMBER(2,0),
  BankCode NUMBER REFERENCES cbm_Banks(id) NOT NULL ,
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  BranchVaultAccNumber VARCHAR2(50)
);


CREATE SEQUENCE CBM_BANK_BRANCHES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_BANK_BRANCHES_TRG  ' || chr(10) ||
                    '   before insert on CBM_BANK_BRANCHES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_BANK_BRANCHES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

create table CBM_ACCOUNT_TYPES
(
  Id NUMBER NOT NULL PRIMARY KEY ,
  AccTypeName VARCHAR2(50 CHAR),
  AccTypeCode VARCHAR2(50 CHAR),
  MinimumBal NUMBER(38,2),
  BankCode NUMBER REFERENCES CBM_BANKS(ID),
  IsDebitable NUMBER(2,0),
  Description VARCHAR2(150 CHAR),
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  IsActive NUMBER(2,0),
  MinNumberOfSignatories NUMBER(2,0),
  MaxNumberOfSignatories NUMBER(2,0)
);


CREATE SEQUENCE CBM_ACCOUNT_TYPES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_ACCOUNT_TYPES_TRG  ' || chr(10) ||
                    '   before insert on CBM_ACCOUNT_TYPES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_ACCOUNT_TYPES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/



INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('COMMISSION ACCOUNT', 'COMMISSION_ACCOUNT', 0, 1, 1, 'Commission Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('TELLER ACCOUNT', 'TELLER_ACCOUNT', 0, 1, 1, 'Teller Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('SAVINGS ACCOUNT', 'SAVINGS_ACCOUNT', 0, 1, 1, 'Savings Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('CURRENT ACCOUNT', 'CURRENT_ACCOUNT', 0, 1, 1, 'Current Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('CORPORATE ACCOUNT', 'CORPORATE_ACCOUNT', 0, 1, 1, 'Corporate Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 4);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('COMMISSION ACCOUNT', 'COMMISSION_ACCOUNT', 0, 1, 1, 'Commission Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('SUSPENSE ACCOUNT', 'SUSPENSE_ACCOUNT', -1000000000, 1, 1, 'Suspense Account', 'admin', 'admin', sysdate, sysdate, 1, 0, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('TELLER ACCOUNT', 'TELLER_ACCOUNT', 0, 1, 1, 'Teller Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('SAVINGS ACCOUNT', 'SAVINGS_ACCOUNT', 0, 1, 1, 'Savings Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('CURRENT ACCOUNT', 'CURRENT_ACCOUNT', 0, 1, 1, 'Current Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 1);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('CORPORATE ACCOUNT', 'CORPORATE_ACCOUNT', 0, 1, 1, 'Corporate Account', 'admin', 'admin', sysdate, sysdate, 1, 1, 4);
INSERT INTO CBM_ACCOUNT_TYPES (AccTypeName, AccTypeCode, MinimumBal, BankCode, IsDebitable, Description, ModifiedBy, CreatedBy, CreatedOn, LASTUPDATEDATE, IsActive, MinNumberOfSignatories, MaxNumberOfSignatories) VALUES ('SUSPENSE ACCOUNT', 'SUSPENSE_ACCOUNT', -1000000000, 1, 1, 'Suspense Account', 'admin', 'admin', sysdate, sysdate, 1, 0, 1);
COMMIT ;


create table CBM_CURRENCIES
(
  Id NUMBER NOT NULL PRIMARY KEY ,
  CurrencyName VARCHAR2(150 CHAR),
  CurrencyCode VARCHAR2(50),
  IsActive NUMBER(2,0),
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  ValueInLocalCurrency NUMBER(38,2)
);


CREATE SEQUENCE CBM_CURRENCIES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_CURRENCIES_TRG  ' || chr(10) ||
                    '   before insert on CBM_CURRENCIES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_CURRENCIES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

INSERT INTO CBM_CURRENCIES (CurrencyName, CurrencyCode, IsActive, CreatedOn, LastUpdateDate, CreatedBy, ModifiedBy, ValueInLocalCurrency) VALUES ('KENYA SHILLINGS','KES',1,sysdate,sysdate,'admin','admin',1);
COMMIT ;

CREATE TABLE CBM_EXCHANGE_RATES(
  id NUMBER NOT NULL PRIMARY KEY ,
  currency_id NUMBER REFERENCES CBM_CURRENCIES(ID),
  exchange_rate NUMBER(20,6) NOT NULL ,
  rate_start_date DATE NOT NULL ,
  rate_end_date DATE,
  isActive NUMBER(2,0) DEFAULT 0 NOT NULL,
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR)
);

CREATE SEQUENCE CBM_EXCHANGE_RATES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_EXCHANGE_RATES_TRG  ' || chr(10) ||
                    '   before insert on CBM_EXCHANGE_RATES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_EXCHANGE_RATES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

create table CBM_CHARGE_TYPES
(
  id NUMBER NOT NULL PRIMARY KEY ,
  Charge_Type_Code VARCHAR2(50 CHAR),
  Charge_Type_Name VARCHAR2(50),
  isActive NUMBER(2,0) DEFAULT 0 NOT NULL,
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  Description VARCHAR2(500 CHAR)
);

CREATE SEQUENCE CBM_CHARGE_TYPES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_CHARGE_TYPES_TRG  ' || chr(10) ||
                    '   before insert on CBM_CHARGE_TYPES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_CHARGE_TYPES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

DROP TABLE  CBM_BANK_ACCOUNTS;
create table CBM_BANK_ACCOUNTS
(
  id NUMBER NOT NULL PRIMARY KEY ,
  Acc_Balance NUMBER(38,2),
  Acc_Number VARCHAR2(50 CHAR),
  Acc_Type NUMBER REFERENCES CBM_ACCOUNT_TYPES(ID) NOT NULL,
  Bank_Code NUMBER REFERENCES CBM_BANKS(ID) NOT NULL ,
  Is_Active NUMBER(2,0),
  Approved_By VARCHAR2(50 CHAR),
  Approved_date DATE,
  Branch_Code NUMBER REFERENCES CBM_BANK_BRANCHES(ID) NOT NULL ,
  Currency_Code NUMBER REFERENCES CBM_CURRENCIES(ID) NOT NULL,
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR),
  user_id NUMBER REFERENCES ADM_PRINCIPALS(ID) not NULL
);

CREATE SEQUENCE CBM_BANK_ACCOUNTS_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_BANK_ACCOUNTS_TRG  ' || chr(10) ||
                    '   before insert on CBM_BANK_ACCOUNTS' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_BANK_ACCOUNTS_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


create table CFG_TRANSACTION_CATEGORIES
(
  Id NUMBER NOT NULL PRIMARY KEY ,
  TranType VARCHAR2(50 CHAR),
  Description VARCHAR2(150 CHAR),
  isActive NUMBER(2,0) DEFAULT 0 NOT NULL,
  CreatedOn DATE,
  LastUpdateDate DATE,
  CreatedBy VARCHAR2(200 CHAR),
  ModifiedBy VARCHAR2(200 CHAR)
);

CREATE SEQUENCE CFG_TRANSACTION_CATEGORIES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CFG_TRANSACTION_CATEGORIES_TRG  ' || chr(10) ||
                    '   before insert on CFG_TRANSACTION_CATEGORIES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CFG_TRANSACTION_CATEGORIES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('WITHDRAW', 'WITHDRAW OPERATION',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('DEPOSIT', 'DEPOSIT OPERATION',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('INTERNAL_TRANSFER', 'AN INTERNAL TRANSFER',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('EXTERNAL_TRANSFER', 'AN EXTERNAL TRANSFER',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('WITHDRAW', 'WITHDRAW OPERATION',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('DEPOSIT', 'DEPOSIT OPERATION',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('INTERNAL_TRANSFER', 'AN INTERNAL TRANSFER',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
INSERT INTO CFG_TRANSACTION_CATEGORIES (TranType, Description,  CreatedOn, LASTUPDATEDATE, MODIFIEDBY, CreatedBy, IsActive) VALUES ('EXTERNAL_TRANSFER', 'AN EXTERNAL TRANSFER',  SYSDATE, SYSDATE, 'admin', 'admin', 1);
COMMIT ;


create table CBM_BANK_CHARGES
(
  ID NUMBER NOT NULL PRIMARY KEY ,
  Charge_Amount NUMBER(38,2),
  Commission_Account NUMBER REFERENCES CBM_BANK_ACCOUNTS(ID) NOT NULL ,
  Trans_Category NUMBER REFERENCES CFG_TRANSACTION_CATEGORIES(ID) NOT NULL ,
  IsDebit NUMBER(2,0) DEFAULT 0 NOT NULL ,
  Bank_Code NUMBER REFERENCES CBM_BANKS(ID) NOT NULL ,
  Charge_Code NUMBER REFERENCES CBM_CHARGE_TYPES(ID),
  Charge_Name VARCHAR2(50 CHAR),
  CreatedBy varchar(250 CHAR),
  ModifiedBy varchar(250 CHAR),
  CreatedOn DATE,
  ModifiedOn DATE,
  ChargeDesc VARCHAR2(1500 CHAR),
  IsActive NUMBER(2,0) DEFAULT 0 NOT NULL ,
  Account_Type NUMBER REFERENCES CBM_ACCOUNT_TYPES(ID) NOT NULL ,
  Charge_Type NUMBER REFERENCES CBM_CHARGE_TYPES(ID) NOT NULL
);

CREATE SEQUENCE CBM_BANK_CHARGES_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger CBM_BANK_CHARGES_TRG  ' || chr(10) ||
                    '   before insert on CBM_BANK_CHARGES' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select CBM_BANK_CHARGES_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


select
smsregistr0_.ID as ID1_74_,
smsregistr0_.CREATION_DATE as CREATION_DATE2_74_,
smsregistr0_.DELIVERY_STATUS as DELIVERY_STATUS3_74_,
smsregistr0_.DIRECTION as DIRECTION4_74_,
smsregistr0_.KANNEL_RESPONSE as KANNEL_RESPONSE5_74_,
smsregistr0_.MESSAGE_TEXT as MESSAGE_TEXT6_74_,
smsregistr0_.RECEIVED_TIME as RECEIVED_TIME7_74_,
smsregistr0_.RESPONSE_MESSAGE as RESPONSE_MESSAGE8_74_,
smsregistr0_.RETRIED as RETRIED9_74_,
smsregistr0_.RETRY_ATTEMPTS as RETRY_ATTEMPTS10_74_,
smsregistr0_.SENDER as SENDER11_74_,
smsregistr0_.SENT_TIME as SENT_TIME12_74_,
smsregistr0_.SERVICE_REQUEST as SERVICE_REQUEST16_74_,
smsregistr0_.SHORT_CODE as SHORT_CODE13_74_,
smsregistr0_.SUB_IMSI as SUB_IMSI14_74_,
smsregistr0_.SUBNO as SUBNO15_74_
from
LOG_SMS_REGISTRY smsregistr0_
where
smsregistr0_.DIRECTION='OUT'
and smsregistr0_.DELIVERY_STATUS=0
and smsregistr0_.RETRIED<smsregistr0_.RETRY_ATTEMPTS;

UPDATE LOG_SMS_REGISTRY set RETRIED = 0 WHERE DELIVERY_STATUS = 40;
COMMIT ;

update DAT_USSD_MENUS set MENU_NEXT_ID='maishaAkibaAdvanceRequestNotifyLimitOk' where id =172;
update PSI.DAT_USSD_MENUS
set USSD_CODE_IMSI    = 5, MENU_KEY = 'maishaAkibaAdvanceRequestConfirm', MENU_ACTION = 'nextMenu', MENU_NEXT_ID = null,
  MENU_PARAMETER      = null, MENU_IS_CHOICE = '0', MENU_CONDITION = null, STATUS = 1, CREATEDBY = 'admin',
  CREATEDON           = TO_DATE('2017-03-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), MODIFIEDBY = 'muhia',
  MODIFIEDON          = TO_DATE('2017-03-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), DELETEBY = 'muhia', DELETEDON = null,
  TEXT_VAR_1          = 'Request loan of {1} @ {3} for {2}', TEXT_VAR_2 = null, TEXT_VAR_3 = null, TEXT_VAR_4 = null,
  TEXT_VAR_5          = null, TEXT_VAR_6 = null, MENU_SESSION_END = 'N', SECURE_MENU = 'Y', POST_PROCESSING_INFO = null,
  PRE_PROCESSING_INFO = 'loanRate,loanRateQuery=Select b from BankCharges b,productid=19', FTU = 0
where ID = 171;

SELECT * from DAT_USSD_MENUS where MENU_KEY='maishaAkibaAdvanceRequestNotify';



drop TABLE bat_shedlock;

CREATE TABLE shedlock(
  name varchar2(64 char) not null primary key ,
  lock_until TIMESTAMP(3) NULL,
  locked_at TIMESTAMP(3) NULL,
  locked_by  varchar2(255 char)
) ;

create table cbm_Transaction_Requests
(
  ID NUMBER NOT NULL PRIMARY KEY ,
  CustomerName varchar2(500 char),
  AccountNumber number references CBM_BANK_ACCOUNTS(ID) not null,
  ToAccount varchar2(150 char),
  FromAccount varchar2(150 char),
  TranAmount number(38,2),
  TranCategory number references CFG_TRANSACTION_CATEGORIES(ID) not null ,
  PaymentDate timestamp(3),
  Record_Date date default sysdate not null ,
  Teller varchar2(150 char),
  ApprovedBy varchar2(150 char),
  Narration varchar2(150 char),
  RequiresApproval number(2,0),
  Approver varchar2(150 char),
  Status varchar2(150 char),
  Reason varchar2(3950 char),
  CurrencyCode number references CBM_CURRENCIES(ID) not null ,
  PaymentType varchar2(150 char),
  ChequeNumber varchar2(150 char),
  transaction_status number(3,0) default 0 not null ,
  service_request number references CRM_SERVICE_REQUESTS(id),
  prepare_start_date date,
  prepare_end_date date,
  provisioning_start_date date,
  provisioning_end_date date,
  provisioning_transaction varchar2(200 char),
  provisioning_retries number(3,0) default 0 not null ,
  provisioning_retried number(3,0) default 0 not null ,
  accounting_start_date date,
  accounting_end_date date,
  accounting_transaction varchar2(200 char),
  accounting_retries number(3,0) default 0 not null ,
  accounting_retried number(3,0) default 0 not null ,
  gl_update_start_date date,
  gl_update_end_date date,
  gl_update_transaction varchar2(200 char),
  gl_update_retries number(3,0) default 0 not null ,
  gl_update_retried number(3,0) default 0 not null ,
  crba_update_start_date date,
  crba_update_end_date date,
  crba_update_transaction varchar2(200 char),
  crba_update_retries number(3,0) default 0 not null ,
  crba_update_retried number(3,0) default 0 not null ,
  var_field_1 varchar2(200 char),
  var_field_2 varchar2(200 char),
  var_field_3 varchar2(200 char),
  var_field_4 varchar2(200 char),
  var_field_5 varchar2(200 char),
  var_field_6 varchar2(200 char),
  var_field_7 varchar2(200 char),
  var_field_8 varchar2(200 char),
  var_field_9 varchar2(200 char),
  var_field_10 varchar2(200 char),
  Created_By varchar(250 CHAR),
  Modified_By varchar(250 CHAR),
  deleted_By varchar(250 CHAR),
  CreatedOn DATE,
  ModifiedOn DATE,
  deletedon                DATE
)
PARTITION BY RANGE (Record_Date) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "PSI_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00')

);

CREATE SEQUENCE cbm_Transaction_Requests_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger cbm_Transaction_Requests_TRG  ' || chr(10) ||
                    '   before insert on cbm_Transaction_Requests' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select cbm_Transaction_Requests_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

drop table cfg_mobile_money_providers;

create table cfg_mobile_money_providers(
  id number not null primary key ,
  provider varchar2(200 char) not null,
  status number(2,0) default 0 not null ,
  country number references REF_COUNTRY_CODES(COUNTRY_ID ) not null,
  mnc varchar2(50 char) not null unique,
  mcc varchar2(50 char) not null unique,
  cc varchar2(50 char) not null ,
  ndc varchar2(50 char) not null,
  Created_By varchar(250 CHAR),
  Modified_By varchar(250 CHAR),
  deleted_By varchar(250 CHAR),
  Created_On DATE,
  Modified_On DATE,
  deleted_on DATE
);

CREATE SEQUENCE cfg_mobile_money_providers_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger cfg_mobile_money_providers_TRG  ' || chr(10) ||
                    '   before insert on cfg_mobile_money_providers' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select cfg_mobile_money_providers_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

drop index PSI.SYS_C0011309;
create unique index PSI.SYS_C0011309 on PSI.CFG_MOBILE_MONEY_PROVIDERS(MNC, MCC);
drop index PSI.SYS_C0011310;
alter table PSI.CFG_MOBILE_MONEY_PROVIDERS drop constraint SYS_C0011310;
alter table PSI.CFG_MOBILE_MONEY_PROVIDERS drop constraint SYS_C0011309;

create table bat_mobile_money_requests(
  id number not null unique ,
  provider varchar2(50 char) not null ,
  from_subno varchar2(30 char) not null ,
  to_subno varchar2(30 char) not null ,
  transaction_type number references CFG_TRANSACTION_CATEGORIES(id) not null ,
  ammount number (38,2) not null ,
  var_parameter_1 varchar2(200 char),
  var_parameter_2 varchar2(200 char),
  var_parameter_3 varchar2(200 char),
  var_parameter_4 varchar2(200 char),
  var_parameter_5 varchar2(200 char),
  var_parameter_6 varchar2(200 char),
  var_parameter_7 varchar2(200 char),
  var_parameter_8 varchar2(200 char),
  var_parameter_9 varchar2(200 char),
  var_parameter_10 varchar2(200 char),
  var_value_1 varchar2(200 char),
  var_value_2 varchar2(200 char),
  var_value_3 varchar2(200 char),
  var_value_4 varchar2(200 char),
  var_value_5 varchar2(200 char),
  var_value_6 varchar2(200 char),
  var_value_7 varchar2(200 char),
  var_value_8 varchar2(200 char),
  var_value_9 varchar2(200 char),
  var_value_10 varchar2(200 char),
  Created_By varchar(250 CHAR),
  Modified_By varchar(250 CHAR),
  deleted_By varchar(250 CHAR),
  CreatedOn DATE default sysdate not null ,
  ModifiedOn DATE,
  deletedon                DATE)
PARTITION BY RANGE (CreatedOn) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "PSI_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00')

);


CREATE SEQUENCE bat_mobile_money_requests_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger bat_mobile_money_requests_TRG  ' || chr(10) ||
                    '   before insert on bat_mobile_money_requests' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select bat_mobile_money_requests_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/

create table log_mobile_money_responses(
  id number not null unique ,
  request number references bat_mobile_money_requests(id) not null ,
  provider varchar2(50 char) not null ,
  var_parameter_1 varchar2(200 char),
  var_parameter_2 varchar2(200 char),
  var_parameter_3 varchar2(200 char),
  var_parameter_4 varchar2(200 char),
  var_parameter_5 varchar2(200 char),
  var_parameter_6 varchar2(200 char),
  var_parameter_7 varchar2(200 char),
  var_parameter_8 varchar2(200 char),
  var_parameter_9 varchar2(200 char),
  var_parameter_10 varchar2(200 char),
  var_parameter_11 varchar2(200 char),
  var_parameter_12 varchar2(200 char),
  var_parameter_13 varchar2(200 char),
  var_parameter_14 varchar2(200 char),
  var_parameter_15 varchar2(200 char),
  var_parameter_16 varchar2(200 char),
  var_parameter_17 varchar2(200 char),
  var_parameter_18 varchar2(200 char),
  var_parameter_19 varchar2(200 char),
  var_parameter_20 varchar2(200 char),
  var_value_1 varchar2(200 char),
  var_value_2 varchar2(200 char),
  var_value_3 varchar2(200 char),
  var_value_4 varchar2(200 char),
  var_value_5 varchar2(200 char),
  var_value_6 varchar2(200 char),
  var_value_7 varchar2(200 char),
  var_value_8 varchar2(200 char),
  var_value_9 varchar2(200 char),
  var_value_10 varchar2(200 char),
  var_value_11 varchar2(200 char),
  var_value_12 varchar2(200 char),
  var_value_13 varchar2(200 char),
  var_value_14 varchar2(200 char),
  var_value_15 varchar2(200 char),
  var_value_16 varchar2(200 char),
  var_value_17 varchar2(200 char),
  var_value_18 varchar2(200 char),
  var_value_19 varchar2(200 char),
  var_value_20 varchar2(200 char),
  Created_By varchar(250 CHAR),
  Modified_By varchar(250 CHAR),
  deleted_By varchar(250 CHAR),
  CreatedOn DATE default sysdate not null ,
  ModifiedOn DATE,
  deletedon                DATE)
PARTITION BY RANGE (CreatedOn) INTERVAL (NUMTODSINTERVAL(1, 'DAY'))
(
  PARTITION "PSI_201703015"
    VALUES LESS THAN (TIMESTAMP ' 2017-03-14 00:00:00')

);

CREATE SEQUENCE log_mobile_money_responses_SEQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;

BEGIN
  EXECUTE IMMEDIATE 'create or replace trigger log_mobile_money_responses_TRG  ' || chr(10) ||
                    '   before insert on log_mobile_money_responses' || chr(10) ||
                    '   for each row ' || chr(10) ||
                    'begin  ' || chr(10) ||
                    '   if inserting then ' || chr(10) ||
                    '      if :NEW."ID" is null then ' || chr(10) ||
                    '         select log_mobile_money_responses_SEQ.nextval into :NEW."ID" from dual; ' || chr(10) ||
                    '      end if; ' || chr(10) ||
                    '   end if; ' || chr(10) ||
                    'end;' || chr(10);
END;
/


alter table PSI.CBM_BANK_BRANCHES
  modify BRANCHNAME varchar2(50) default null;
alter table PSI.CBM_BANK_BRANCHES
  modify BRANCHCODE varchar2(50) default null;
alter table PSI.CBM_BANK_BRANCHES
  modify LOCATION varchar2(100) default null;

insert into PSI.CBM_BANK_BRANCHES (ID, BRANCHNAME, BRANCHCODE, LOCATION, ISACTIVE, BANKCODE, CREATEDON, LASTUPDATEDATE, CREATEDBY, MODIFIEDBY, BRANCHVAULTACCNUMBER)
values (1, 'CHESTER HOUSE BRANCH', '001', '2nd Flr, Chester House, Koinange Street', 1, 1,
           TO_DATE('2017-04-13 00:10:46', 'YYYY-MM-DD HH24:MI:SS'),
           TO_DATE('2017-04-13 00:10:51', 'YYYY-MM-DD HH24:MI:SS'), 'Muhia', 'Muhia', null);
commit;

alter table PSI.REF_COUNTRY_CODES
  modify CURR_DESCRIPTION varchar2(300) default null;


alter table PSI.CBM_BANK_CHARGES
  add product_id number references CFG_PRODUCTS_MASTER (ID) not null;

alter table PSI.CBM_BANK_CHARGES
  modify CHARGE_CODE varchar2(50 char) default null;

select *
from CBM_BANK_CHARGES;

create unique index PSI.ACCOUNTTYPES_TYPECODE_UNIQUE
  on PSI.CBM_ACCOUNT_TYPES (ACCTYPECODE, BANKCODE);

alter table CBM_TRANSACTION_REQUESTS
  add transaction_duration number(38, 5);


alter table PSI.DAT_REGISTRATION_DETAILS add Imsi_number varchar2(150 char) default '1234567890' not null;

