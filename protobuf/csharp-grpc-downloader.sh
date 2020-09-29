#!/bin/sh

version=$(grep grpcCsharpVersion ../gradle.properties | cut -d "=" -f2)
mkdir -p ./generator
cd ./generator
curl https://globalcdn.nuget.org/packages/grpc.tools.${version}.nupkg -O
unzip grpc.tools.${version}.nupkg tools/*/* -d .

chmod +x ./tools/linux_x64/grpc_csharp_plugin
chmod +x ./tools/linux_x86/grpc_csharp_plugin