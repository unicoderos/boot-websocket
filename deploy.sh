#!/bin/sh

copyToAWS_01 build/libs/boot-websocket-0.0.1-SNAPSHOT.war
ssh -i ~/.ssh/olg-aws.pem ubuntu@18.223.10.187 <<EOF

RUNPID=$(ps ax -l | grep "boot-websocket-0.0.1-SNAPSHOT.war" | awk '{print $4}' | head -n 1)
kill -9 $RUNPID

sudo nohup java -jar boot-websocket-0.0.1-SNAPSHOT.war &
mv boot-websocket-0.0.1-SNAPSHOT.war boot-websocket-0.0.1-SNAPSHOT_$(date '+%d/%m/%Y_%H:%M:%S').war
mv boot-websocket-0.0.1-SNAPSHOT_$(date '+%d/%m/%Y_%H:%M:%S').war back-up
exit
exit
exit
EOF
exit

