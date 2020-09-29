#!/bin/sh

echo 'WARN: The script MUST be run from the root project folder...'

# 1. definition-generator build & publishToMavenLocal
./gradlew :definition-generator:build
./gradlew :definition-generator:publishToMavenLocal

# 2. main project build
./gradlew :build