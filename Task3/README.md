# Posting service

## Description
Microservice for postings

### Build tool        
This project uses such build tool as maven.<br/>
Use "mvn clean package" to build project.<br/>
Use "mvn spring-boot:run" to run project.

### CSV Files Path
src\main\resources\csv\

### Manual
Для запуска проекта необходимо:
- иметь postgresql, pgAdmin
- создать пустую базу данных в pgAdmin
- в application.yml задать необходимые данные для подключения к базе данных: 
url, username, password.
- данные в базу заполняются автоматически при запуске проекта

## REST-services:
        
### GET http://localhost:8082/base/search_postings_between_date?date_from={date_from}&date_to={date_to}&authorized_delivery={bool_value}
##### getting postings between dates

        where:
        {date_from} - start date
        {date_to} - end date
        Optional:
        {bool_value} - authorized_delivery(true/false)

### DOC
JSON format:<br/>
http://localhost:8082/base/v3/api-docs/<br/>
YAML format:<br/>
http://localhost:8082/base/v3/api-docs.yaml<br/>
SWAGGER:<br/>
http://localhost:8082/base/swagger-ui/index.html<br/>



