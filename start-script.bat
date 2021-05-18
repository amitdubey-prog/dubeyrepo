@echo off
echo "starting zookeeper"
start D:\software\kafka_2.12-2.4.1\bin\windows\zookeeper-server-start.bat D:\software\kafka_2.12-2.4.1\config\zookeeper.properties

pause

echo "starting kafka broker"
start D:\software\kafka_2.12-2.4.1\bin\windows\kafka-server-start.bat D:\software\kafka_2.12-2.4.1\config\server.properties

pause

echo "starting kafka connect on 8083(default)"
start D:\software\kafka_2.12-2.4.1\bin\windows\connect-distributed.bat D:\software\kafka_2.12-2.4.1\config\connect-distributed.properties