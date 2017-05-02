#!/bin/bash
count=`ps -ef | grep psi-portal| grep -v grep| wc -l|sed 's/ //g'`
pid=`ps -ef | grep psi-portal| grep -v grep| awk '{ print $2 }'`
app_dir=/app/apps_home/psi/bin
conf_dir=/app/apps_home/psi/conf/test
app_logs=/app/apps_home/psi/logs
if [ ${count} -gt 0 ]
then
        cd ${app_dir}
        nohup kill -15 ${pid} 1>>${app_logs}/psi-portal_`date +"%d%m%Y"`.log 2>>${app_logs}/psi-portal_`date +"%d%m%Y"`.err &

        while [ ${count} -gt 0 ]; do
            echo "Stopped psi [pid = ${pid}] waiting for a graceful shutdown to complete at `date +"%d-%m-%Y %H:%m:%S"`" 1>>${app_logs}/psi-portal_`date +"%d%m%Y"`.log 2>>${app_logs}/psi-portal_`date +"%d%m%Y"`.err
            sleep 1
            count=`ps -ef | grep psi-portal| grep -v grep| wc -l|sed 's/ //g'`
        done
else
        echo "psi-portal is not running !" 1>>${app_logs}/psi-portal_`date +"%d%m%Y"`.log 2>>${app_logs}/psi-portal_`date +"%d%m%Y"`.err

fi