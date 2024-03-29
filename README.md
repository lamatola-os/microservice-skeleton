Microservice skeleton
-----------------------

This demonstrates how to create a microservice with api, http-client and schema as separate jars.

- microservice-api
- microservice-http
- microservice-schema
 
Read [Building Microservice](https://danlebrero.com/2023/01/24/building-microservices-second-edition-designing-fine-grained-systems-summary/#ch-5), Chapter 5/ "**Sharing code via libraries**".

Also read
- https://github.com/Netflix/Hystrix/wiki/#what

publishing artifacts
----------

```bash
λ gradle test

BUILD SUCCESSFUL in 0s
5 actionable tasks: 5 up-to-date

λ gradle publishToMavenLocal
λ ls -l ~/.m2/repository/org/duwamish/microservice/
total 0
drwxr-xr-x  4 prayagupd  184630988  128 Jul 21 16:11 microservice-api
drwxr-xr-x  4 prayagupd  184630988  128 Jul 21 16:13 microservice-schema
```

creating fat artifact
---------

```bash
λ gradle fatJar
λ ls -l microservice-api/build/libs/
total 8
-rw-r--r--  1 prayagupd  184630988  1644 Jul 21 16:00 microservice-api-1.0.jar

λ ls -l microservice-schema/build/libs/
total 8
-rw-r--r--  1 prayagupd  184630988  1233 Jul 21 16:00 microservice-schema-1.0.jar
```

run microservice
--------

```bash
λ gradle clean run

curl localhost:8080/v1/ads
[{"ads":["1","2"]}]


## logs
-------------------------------------- start selection request1 ------------------------
-------------------------------------- start selection request2 ------------------------
rank request1 started: pool-2-thread-1: 5005
rank request2 started: pool-2-thread-1: 5007

rank request1 completed: pool-2-thread-1: 8015
rank request2 completed: pool-2-thread-1: 8018

Response created in pool-2-thread-1: 8018
Response completed in pool-2-thread-1: 8018
```

Implementing Microservice Communication
-----

1) Looking for ideal technology: SOAP, REST, gRPC
2) Make backward compatibility easy
3) Make your interface explicit

Upstream/ consumer microservices practices
- https://martinfowler.com/bliki/TolerantReader.html
```
be conservative in what you do, be liberal in what you accept from others.
Jon Postel
```

Downstrea microservices
---

- 
- https://github.com/lamatola-os/spring-netty-adranking-microservice