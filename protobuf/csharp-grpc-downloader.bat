@echo off
setlocal enableextensions

:: This is just a convoluted way to extract the grpc version from the gradle.properties
FOR /F "tokens=* USEBACKQ" %%F IN (`findstr "grpcCsharpVersion" ..\gradle.properties`) DO (
SET grpcCsharpVersionConfig=%%F
)
for /f "tokens=2 delims==" %%a in ("%grpcCsharpVersionConfig%") do (
  set version=%%a
)

mkdir generator
cd ./generator
powershell -Command "Invoke-WebRequest https://globalcdn.nuget.org/packages/grpc.tools.%version%.nupkg -OutFile grpc.tools.%version%.nupkg"

unzip grpc.tools.%version%.nupkg tools/*/* -d .