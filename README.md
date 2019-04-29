Spring boot GRPC application for sample banc account
========================================

This sample shows Client Server GRPC applciations build with  [Spring Boot][spring-boot] . Spring boot grpc starter was used.

Java 8 is needed to run this sample.

- Make sure that JAVA_HOME setup correctly.

Clone
--------

```sh
git clone https://github.com/epixelll/grpc.git
```

Run Server
--------

```create database/user in postgres like below, or you can change it as you like in applicatin.properties of project.
sudo -u postgres psql
postgres=# create database grpc_server;
postgres=# create user grpc with encrypted password '123456';
postgres=# grant all privileges on database grpc_server to gprc;
```

```sh
cd server
```

```sh
./gradlew bootRun
```

Run Client
--------

```sh
cd client
```

```sh
./gradlew bootRun -Dusers=N -Dconcurrent_threads_per_user=N -Drounds_per_thread=N
```

