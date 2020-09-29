#!/bin/sh

echo 'WARN: The script MUST be run from the root project folder...'
echo 'WARN: **  Make sure that Docker is running...'
echo 'WARN: **  Make sure to have the Lombok support installed...'

# 1. definition-generator build & publishToMavenLocal
./gradlew :definition-generator:build
./gradlew :definition-generator:publishToMavenLocal

# 2. main project build
./gradlew :build