curl https://archive.apache.org/dist/hadoop/core/hadoop-3.1.4/hadoop-3.1.4.tar.gz --output hadoop-3.1.4.tar.gz
cp config/* master/config/ -r
cp config/* worker/config/ -r
cp hadoop-3.1.4.tar.gz master
cp hadoop-3.1.4.tar.gz worker