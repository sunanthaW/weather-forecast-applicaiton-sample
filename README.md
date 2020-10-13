# Weather Forecast Applicaiton
This is sample spring boot project

# Requirement
This project need [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed in your environment



# Running this application locally
You need to register **TMD Weather Forecast API**
[https://data.tmd.go.th/nwpapi](https://data.tmd.go.th/nwpapi/doc/main/getting_start.html#%E0%B8%81%E0%B8%B2%E0%B8%A3%E0%B8%AA%E0%B8%A1%E0%B8%B1%E0%B8%84%E0%B8%A3%E0%B9%83%E0%B8%8A%E0%B9%89%E0%B8%87%E0%B8%B2%E0%B8%99)

After registered and get your token type and access token
open file ./src/main/resources/application.properties

replace `<<token-type>>` with your token type

replace `<<acccess-token>>` with your access token



After that Go to project root directory and run command
```shell
mvnw spring-boot:run
```

Open [localhost:8080](http://localhost:8080)

**Enjoy !**

