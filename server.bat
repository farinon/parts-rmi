REM cd server
javac -d bin src/RMIServer.java
java bin/RMIServer
REM java -Djava.security.manager -Djava.security.policy=server.policy RMIServer