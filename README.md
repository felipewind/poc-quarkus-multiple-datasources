# poc-quarkus-multiple-datasources project

This is a simple poc using multiple data sources with Quarkus.

Quoting the [Quarkus documentation](https://quarkus.io/guides/hibernate-orm#multiple-persistence-units):
> Starting with Quarkus 1.8, you can define multiple persistence units using the Quarkus configuration properties approach.

Two datasources are defined in `src/resources/application.properties`:
- `Users`:
  - PostgreSQL
- `Orders`:
  - MariaDB or Oracle. 
  - Oracle is initially commented, because the Oracle JDBC driver must be downloaded manually. There are instructions below to change beteween MariaDB and Oracle.

The main project is on the Quarkus 1.9.2.Final version.

There are other three projects available here in more recent versions:
- [Quarkus version 2.7.4.Final using only Hibernate](./quarkus-vrs-2-7-hibernate/README.md) - folder `./quarkus-vrs-2-7-hibernate`
- [Quarkus version 2.7.4.Final using only Panache with the Repository Pattern](./quarkus-vrs-2-7-panache-repository-pattern/README.md) - folder `./quarkus-vrs-2-7-panache-repository-pattern`
- [Quarkus version 2.7.4.Final using only Panache with the Active Record Pattern](./quarkus-vrs-2-7-panache-active-record-pattern/README.md) - folder `./quarkus-vrs-2-7-panache-active-record-pattern`

## Steps to run the test with PostgreSQL and Mariadb
1. Start the database docker images;

```bash
docker run -d --name postgres-db -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=usersdb postgres
docker run -d --name mariadb-db -p 3306:3306 -e MYSQL_USER=maria -e MYSQL_ROOT_PASSWORD=maria -e MYSQL_PASSWORD=maria -e MYSQL_DATABASE=ordersdb mariadb
```

2. Start Quarkus at dev mode:
```bash
./mvnw compile quarkus:dev
```
3. Or you can run inside docker-compose:
```
chmod +x ./run.sh
./run.sh
```
4. From a browser access http://localhost:8080/swagger-ui and the test:
   - /users/list - select data from the PostgreSQL;
   - /orders/list - select data from the MariaDB (or Oracle database);


## Change MariaDB to Oracle:
To test with the Oracle database, you need to:
1. [Download the Oracle JDBC driver](https://www.oracle.com/technetwork/database/application-development/jdbc/downloads/index.html)
2. Put this driver at your Maven repository at: `/com/oracle/jdbc/ojdbc8/12.2.0.1`
3. Uncomment the Oracle JDBC dependency at the `pom.xml`:
```xml
    <dependency>
      <groupId>com.oracle.jdbc</groupId>
      <artifactId>ojdbc8</artifactId>
      <version>12.2.0.1</version>
    </dependency>
```
4. In the `src/resources/application.properties`, comment the MariaDB parameters and uncomment the Oracle parameters;
5. Start the docker container:
```bash
docker run -d --name oracle-db -p 1521:1521 -e ORACLE_DISABLE_ASYNCH_IO=true oracleinanutshell/oracle-xe-11g
```
6. Run the application and be happy!

In case you want to see the data from a client, as DBeaver, use the following parameters:
- Type: SID
- User: system
- Password: oracle

Test Oracle Docker image origin:./mvnw compile quarkus:dev

## Quarkus documentation:
- https://quarkus.io/guides/datasource#multiple-datasources
- https://quarkus.io/guides/hibernate-orm#multiple-persistence-units


## Tip to pass environment variable to property with double quotes

To override a property like host."foo".bar with an environment variable it's necessary to put two underlines (__).

`host."foo".bar` it will be overriden with:
export HOST__FOO__BAR=your_host

In this projet:
- quarkus.datasource."users".jdbc.url
- export QUARKUS_DATA_SOURCE__USERS__JDBC_URL=your_url



# Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `poc-quarkus-multiple-datasources-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/poc-quarkus-multiple-datasources-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/poc-quarkus-multiple-datasources-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.
