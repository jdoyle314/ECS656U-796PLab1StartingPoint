# ECS656U-765PLab1StartingPoint
Based upon grpc tutorial at https://github.com/eugenp/tutorials/tree/master/grpc
Commands for preparing the enviornment (Assuming you are in the main folder e.g. the one with the pom.xml file in it)
1. sudo apt update
2. sudp apt install default-jdk maven
3. mvn clean package install
4. mvn exec:java -Dexec.mainClass="server.GrpcServer"
5. mvn exec:java -Dexec.mainClass="client.GrpcClient" (Need to run this from a seperate terminal or ssh connection)
