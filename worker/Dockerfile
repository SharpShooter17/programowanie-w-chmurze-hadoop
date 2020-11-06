FROM ubuntu

USER root

RUN apt-get update && \
	apt-get install -y openssh-client openssh-server openssl supervisor openjdk-8-jre
	
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV JRE_HOME /usr/lib/jvm/java-8-openjdk-amd64/jre
ENV HADOOP_HOME /var/hadoop
ENV PATH ${JAVA_HOME}/bin:${HADOOP_HOME}/bin:${HADOOP_HOME}/sbin:${PATH}

COPY hadoop-3.1.4.tar.gz hadoop-3.1.4.tar.gz

VOLUME /ssh-keys

RUN	ssh-keygen -b 4096 -N '' -f ~/.ssh/id_rsa && \
	cat ~/.ssh/id_rsa.pub > /ssh-keys/node.pub
	
RUN mkdir /var/run/sshd && \
	sed -ri 's/^#?PermitRootLogin\s+.*/PermitRootLogin yes/' /etc/ssh/sshd_config && \
	sed -ri 's/UsePAM no/#UsePAM yes/g' /etc/ssh/sshd_config && \
	sed -ri 's/PasswordAuthentication no/#PasswordAuthentication yes/g' /etc/ssh/sshd_config && \
	apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN tar -xzf hadoop-3.1.4.tar.gz &&\
	mv hadoop-3.1.4/ ${HADOOP_HOME}/ && \
	rm -rf ${HADOOP_HOME}/share/doc

COPY config ${HADOOP_HOME}/etc/hadoop

EXPOSE 22/tcp
COPY run.sh node-start.sh
RUN chmod 777 node-start.sh
ENTRYPOINT ["./node-start.sh", "/usr/sbin/sshd", "-D"]
