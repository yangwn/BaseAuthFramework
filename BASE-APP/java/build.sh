#/bin/sh

cd ./all-dependency-infrastructure
mvn clean install -Dmaven.test.skip=true

# create tables and init data.
#cd ../app-database 
#mvn clean test -Pcreate-db
#mvn clean test -Pinit-db

cd ../
mvn clean install -Dmaven.test.skip=true

#cd ../app-base-admin
#mvn clean eclipse:eclipse package -Dmaven.test.skip=true

#cd ../app-memeber
#mvn clean eclipse:eclipse package -Dmaven.test.skip=true

## 查看CAS service
# app-cas-server on http://localhost:8080/cas/services/

## Client service
# cas-shiros-app on http://localhost:8080/app
# cas-shiros-app-admin on http://localhost:8080/app-admin
