#!/bin/sh

# the db must be running for the test to work properly

../gradlew jar
mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
docker build --build-arg DEPENDENCY=build/dependency -t demo/recipe-planner .

