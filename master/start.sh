#!/bin/bash
echo ----- hdfs format -----
hdfs namenode -format
echo ----- start hdfs -----
start-dfs.sh
echo ----- hdfs report -----
hdfs dfsadmin -report

echo ----- start yarn -----
start-yarn.sh
yarn node -list
yarn application -list

echo ----- copy data to hdfs -----
cp data.txt /home/hadoop/data.txt
hdfs dfs -mkdir -p job
hdfs dfs -put data.txt job
echo ----- start job: hadoop-job -----
yarn jar hadoop-job.jar pl.lodz.bartoszujazdowski.hadoopjob.Main job/data.txt job/result

hdfs dfs -ls job
hdfs dfs -get job/result /result
cp -r /result /ssh-keys