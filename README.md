When does the application STOP returning Fibonacci numbers in their correct sequence?

- From positive index 29 i.e "514228" onwards the series is returning incorrect value
- From negative index 25 i.e "75025" onwards the series is returning incorrect value

http://localhost:7003/fib/range?startIndex=-27&finishIndex=30
["196419","-121393","75025","-46368","28657","-17711","10946","-6765","4181","-2584","1597","-987","610","-377","233","-144","89","-55","34","-21","13",
"-8","5","-3","2","-1","1","0","1","1","2","3","5","8","13","21","34","55","89","144","233","377","610","987","1597","2584","4181","6765","10946","17711",
"28657","46368","75025","121393","196418","317811","514228"]

Outofbounds index : 2147483648

============================================================================

Fork:
https://github.com/vindukatta/fibonacci-rest

============================================================================

Prereqs: Java must be installed and JAVA_HOME defined in environment variables (Ex: JAVA_HOME=C:\Program Files\Java\jdk-10.0.1)

Goals: Defined 3 goals in POM - clean, compile, test. Run the following

//prerequisite: start server

mvn compile exec:java

//run test

mvn clean compile test

