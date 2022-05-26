# Agenda API

### API

#### POST /contacts
```
curl -X POST \
  http://localhost:8080/contacts \
  -H 'content-type: application/json' \
  -d '{
	"id": 1,
	"name":"Antonio1",
	"number":"987"
}'
```

#### GET /contacts
```
curl -X GET \
  http://localhost:8080/contacts \
```

```
curl -X GET \
  http://localhost:8080/contacts?name=Antonio \
```

```
curl -X GET \
  http://localhost:8080/contacts?name=Antonio&number=1234 \
```

```
curl -X GET \
  http://localhost:8080/contacts?number=1234 \
```

#### GET /contacts/{id}
```
curl -X GET \
  http://localhost:8080/contacts/1 \
```

#### DELETE /contacts/{id}
```
curl -X DELETE \
  http://localhost:8080/contacts/1 \
```

#### PUT /contacts/{id}
```
curl -X PUT \
  http://localhost:8080/contacts/77 \
  -H 'content-type: application/json' \
  -d '{
	"name":"sdfasdf",
	"number":"3"
}'
```

### Docker
#### Build docker image
```
mvn -B package
docker build -t ajimenez15/agenda .
```
#### Run docker image
```
docker run -n ajimenez15/agenda
```
#### Run docker image
```
docker login
docker push ajimenez15/agenda
```