FROM maven:3-jdk-8

COPY m2_temp/* /root/.m2/repository/

RUN git clone --depth=1 --branch=mqtt https://github.com/eclipse/lyo.trs-client.git && cd lyo.trs-client && mvn clean install -Dmaven.test.skip=true
RUN git clone --depth=1 --branch=mqtt https://github.com/eclipse/lyo.trs-server.git && cd lyo.trs-server && mvn clean install -Dmaven.test.skip=true
