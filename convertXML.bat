#!/usr/bin/env bash

if [ "$(uname)" == "Darwin" ]; then
       java -cp java-json.jar:out/production/XMLIsland main.java.Main %1
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
   java -cp java-json.jar:out/production/XMLIsland main.java.Main %1
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ]; then
   java -cp java-json.jar;out/production/XMLIsland main.java.Main %1
fi

