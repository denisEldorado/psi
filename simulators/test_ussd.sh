#!/usr/bin/env bash
curl --data "userid=kzmuhia&password=028725&input=533*1&sessionid=20170421223107&msisdn=254733814627&transactionid=20170421223107846855&imsi=639030825277051&newrequest=1&code=533&status=9" 'http://127.0.0.1:7021/ussd/ussdke'

614517
Dear customer you have successfully been registered with Maisha Akiba. Your PIN is 730840

curl --data "userid=kzmuhia&password=614517&subno=254723703068&code=111&status=0" -vv 'http://127.0.0.1:7021/tasks/generateToken'


curl --data "userid=kzmuhia&password=028725&subno=254733814627&code=533*1&status=1" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254733814627&code=533*1&status=1" -vv -k 'http://127.0.0.1:7021/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254736117128&code=533*1&status=1" -vv -k 'http://127.0.0.1:7021/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254736630476&code=533*1&status=1" -vv -k 'http://127.0.0.1:7021/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254733334477&code=533*1&status=1" -vv -k 'http://127.0.0.1:7021/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254733330606&code=533*1&status=1" -vv -k 'http://127.0.0.1:7021/tasks/whitelistsubscriber'

curl --data "userid=kzmuhia&password=614517&subno=254723703068&code=533&status=0" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=614517&subno=254736117128&code=533&status=0" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=614517&subno=254736630476&code=533&status=0" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=614517&subno=254733334477&code=533&status=0" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=614517&subno=254733330606&code=533&status=0" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254732535077&code=533&status=1" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'
curl --data "userid=kzmuhia&password=028725&subno=254732534077&code=533*1&status=1" -vv -k 'https://10.64.0.236:7022/tasks/whitelistsubscriber'



SELECT COUNT(*) FROM v$transaction t, v$session s, v$mystat m

select t.start_time,s.sid,s.serial#,s.username,s.status,s.sql_id 
from v$transaction t, v$session s  
where s.saddr = t.ses_addr;


select s.sid, s.serial#, p.spid from    v$session s,     v$process p   where      s.paddr = p.addr and    s.sid in (select SESSION_ID from v$locked_object);

select 
   b.username, 
   a.sql_text 
from 
   v$sqltext_with_newlines a, 
   v$session b, 
   v$process c
where 
   c.spid = to_number('300', 'xxx') 
and 
   c.addr = b.paddr 
and 
   b.sql_address = a.address; 



INSERT INTO PSI.CRM_PRICING_PROFILE (ID, APPLICATION_DST, WALLET_TYPE, WALLET, WALLET_VALUE, WALLET_DESC, PRIORITY, PRICING_PROFILE_TIER, PRODUCT_ID, APPLICATION_SRC, MAPPING_SUB_GROUP, STATUS) VALUES (18, 2, 1, 'AM', 0.0000, 'Deduct 0 from Airtel Money Account', 0, 1, 18, 1, 1, 1);

update product parameters
UPDATE PSI.CFG_PRODUCT_PARAMETERS SET PRODUCT_ID = 18, PLACE_HOLDER1 = 'cellphonenumber', PLACE_HOLDER1_DESC = null, PLACE_HOLDER2 = 'acceptedTerms', PLACE_HOLDER2_DESC = null, PLACE_HOLDER3 = 'firstname', PLACE_HOLDER3_DESC = null, PLACE_HOLDER4 = 'middlename', PLACE_HOLDER4_DESC = null, PLACE_HOLDER5 = 'lastname', PLACE_HOLDER5_DESC = null, PLACE_HOLDER6 = 'idnumbertype', PLACE_HOLDER6_DESC = null, PLACE_HOLDER7 = 'idnumber', PLACE_HOLDER7_DESC = null, PLACE_HOLDER8 = 'product_id', PLACE_HOLDER8_DESC = null, PLACE_HOLDER9 = null, PLACE_HOLDER9_DESC = null, PLACE_HOLDER10 = null, PLACE_HOLDER10_DESC = null, STATUS = 1, CREATION_DATE = TO_TIMESTAMP('2017-03-22 08:13:40.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), LAST_UPDATED_DATE = TO_TIMESTAMP('2017-03-22 08:13:40.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), LAST_UPDATED_BY = 1, PARAMETER_TYPE = null, SMS_KEYWORD = null WHERE ID = 18;


update ussd_menus, acceptedTerms

org.muhia.app.psi.config.order.sr.order.accepted.terms.keyword=acceptedTerms

You will be registered as {2} {3} {4}, ID/PP#: {6}


scp -P 10222 build/libs/psi-portal-8.7.1-SNAPSHOT.war  appsusr@62.12.112.15:/app/apps_home/psi/bin/