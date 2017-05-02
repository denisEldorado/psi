#!/bin/bash -x
user_id=kzmuhia
ussd_pass=028725
trans_id=`date +"%Y%m%d%H%M%S%6N"`
msisdn_=254733814627
imsi_=639030825277051
code_=533
sess_id=`echo ${trans_id}| awk '{ print substr($0,1,length($0)-6)}'`
params=userid=${user_id}&password=${ussd_pass}&input=$0&sessionid=${sess_id}&msisdn=${msisdn_}&transactionid=${trans_id}&imsi=${imsi_}&newrequest=$2&code=${code_}&status=9
echo $(echo "${params}")
#curl --data `echo "${params}"` 'http://127.0.0.1:7021/ussd/ussdke'