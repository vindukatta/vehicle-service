#Prereqs: Java must be installed and JAVA_HOME defined in environment variables (Ex: JAVA_HOME=C:\Program Files\Java\jdk-10.0.1)
#prerequisite: start server

mvn compile exec:java

#run test

mvn clean compile test

