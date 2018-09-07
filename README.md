Prereqs: Java must be installed and JAVA_HOME defined in environment variables (Ex: JAVA_HOME=C:\Program Files\Java\jdk-10.0.1)

Goals: Defined 3 goals in POM for the 3 phases - clean, compile, test. Run the following

//prerequisite: start server

mvn compile exec:java

//run test

mvn clean compile test

