#!/bin/bash
echo ----- hdfs format -----
hdfs namenode -format
echo ----- start hdfs -----
start-dfs.sh
echo ----- hdfs report -----
hdfs dfsadmin -report
echo ----- hdfs mkdir books -----
hdfs dfs -mkdir -p books
cd /home/hadoop
echo ----- get example files -----
wget -O alice.txt https://www.gutenberg.org/files/11/11-0.txt
wget -O holmes.txt https://www.gutenberg.org/files/1661/1661-0.txt
wget -O frankenstein.txt https://www.gutenberg.org/files/84/84-0.txt
echo ----- put files -----
hdfs dfs -put alice.txt holmes.txt frankenstein.txt books
hdfs dfs -ls books
echo ----- start yarn -----
start-yarn.sh
yarn node -list
yarn application -list

echo ----- start example job: hadoop-mapreduce-examples-3.1.4 -----
yarn jar /var/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.4.jar wordcount "books/*" output
