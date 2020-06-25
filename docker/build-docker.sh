#!/bin/sh

cd ..
./gradlew :backend:clean && ./gradlew :backend:compileJava
./gradlew :protobuf:clean && ./gradlew :protobuf:build

cd ./docker
# the db must be running for the test to work properly
docker-compose -f docker-compose.yml up -d demo-db
# Some cleanups
rm -rf build

cd ..
./gradlew :backend:clean && ./gradlew :backend:build && cd ./docker
mkdir -p build/dependency && (cd build/dependency; jar -xf ../../../backend/build/libs/*.jar)

# TODO: this is a brutal hack to make things work
rm ./build/dependency/BOOT-INF/classes/application-local.yml

docker build --build-arg DEPENDENCY=build/dependency -f ./demo-dockerfile -t demo/recipe-planner .

