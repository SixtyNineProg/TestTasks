# User service

## Description
Microservice

## REST-services:
        
### GET [http://localhost:9000/webapplication/user/{userId}](http://localhost:9000/webapplication/user/{userId})
##### getting user by id

        where:
        {userId} - identity number

### DOC
JSON format:<br/>
http://localhost:8082/base/v3/api-docs/<br/>
YAML format:<br/>
http://localhost:8082/base/v3/api-docs.yaml<br/>
SWAGGER:<br/>
http://localhost:8082/base/swagger-ui/index.html<br/>

### Build tool        
This project uses such build tool as maven.<br/>
Use "mvn clean package" to build project.<br/>
Use "mvn spring-boot:run" to run project.