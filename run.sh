#/bin/bash
mvn package
docker-compose -f ./src/main/docker/docker-compose.yml up --build