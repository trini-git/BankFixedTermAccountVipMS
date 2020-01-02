FROM openjdk:8
VOLUME /tmp
ADD ./target/BankFixedTermAccountVipMS-0.0.1-SNAPSHOT.jar bank-fixed-term-account-vip.jar
ENTRYPOINT ["java","-jar","/bank-fixed-term-account-vip.jar"]