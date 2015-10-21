#!/bin/sh

mvn clean test -Pcreate-db
mvn clean test -Pinit-db