#!/bin/bash 
count=`ps -ef | grep psi-portal| grep -v grep| wc -l|sed 's/ //g'`
app_dir=/app/apps_home/psi/bin
conf_dir=/app/apps_home/psi/conf/test
app_logs=/app/apps_home/psi/logs
if [ ${count} -eq  0 ]
then
        cd ${app_dir}
        nohup java -jar -DCONFIG_PATH="${conf_dir}" -Xms768m -Xmx1270m -server -XX:-UsePerfData ${app_dir}/psi-portal.jar 2>>${app_logs}/psi-portal_`date +"%d%m%Y"`.err &
else
        echo "psi-portal is already running is already running" 1>>${app_logs}/psi-portal_`date +"%d%m%Y"`.log 2>>${app_logs}/psi-portal_`date +"%d%m%Y"`.err

fi
