Spring boot GRPC application for sample banc account
========================================

This sample shows Client Server GRPC applciations build with  [Spring Boot][spring-boot] . Spring boot grpc starter was used.

Java 8 is needed to run this sample.

Clone
--------

```sh
git clone https://github.com/epixelll/grpc.git
```

Run Server
--------

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

