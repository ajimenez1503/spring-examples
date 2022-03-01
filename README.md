# spring-examples
In this repository you will find different examples using spring.

## Examples:

### Hello:
https://spring.io/guides/gs/spring-boot/

### Demo:
https://spring.io/quickstart

### Demo Rest
https://spring.io/guides/gs/rest-service/

### accessingdatajpa
https://spring.io/guides/gs/accessing-data-jpa/

### accessingdatarest
https://spring.io/guides/gs/accessing-data-rest/

HTTPS commands:
```
curl http://localhost:8080/
curl http://localhost:8080/person
curl -H "Content-Type:application/json" -d '{"firstName": "Frodo", "lastName": "Baggins"}' -X POST http://localhost:8080/addperson
curl http://localhost:8080/person
```

### resthateoas
https://spring.io/guides/gs/rest-hateoas/

### accessingmongodbdatarest
https://spring.io/guides/gs/accessing-mongodb-data-rest/

### restservicecors
https://spring.io/guides/gs/rest-service-cors/

```
 ./mvnw spring-boot:run

```
Open: http://localhost:8080/

### consuming-rest-jquery
https://spring.io/guides/gs/consuming-rest-jquery/

### Payroll
https://spring.io/guides/tutorials/rest/

### Eureka
https://spring.io/guides/gs/service-registration-and-discovery/
#### steps:
```shell
cd server
./mvnw spring-boot:run
```

Open ``http://localhost:8761``

```shell
cd cliente
./mvnw spring-boot:run
```

```shell
curl  http://localhost:8080/service-instances/a-bootiful-client | json_pp
```

