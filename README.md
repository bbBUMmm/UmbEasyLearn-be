# UmbEasyLearn-be

To run an application you need to build each service:

1) `cd apigateway`, `mvn clean install -DskipTests`
2) `cd cofig-server`, `mvn clean install -DskipTests`
3) ...
4) `cd usermicroservice`, `mvn clean install -DskipTests`

Run docker-compose:

`docer compose up`

The project is provided with the connection string to the database