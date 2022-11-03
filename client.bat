REM cd client
REM javac RMIClient.java
javac -d bin src/RMIClient.java
java bin/RMIClient
REM java -Djava.security.manager -Djava.security.policy=client.policy RMIClient
