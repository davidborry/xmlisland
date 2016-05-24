env=$(uname)
if [ "$env" == "Linux" ];then
    java -cp java-json.jar:out/production/XMLIsland main.java.Main %1

else
    java -cp java-json.jar;out/production/XMLIsland main.java.Main %1
fi

