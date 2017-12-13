# monitorMagnificent
monitor health system

do you compile with gradle:

"gradle clean build"

and you use for execution:

java -jar build/libs/monitorMagnificent-0.0.1-SNAPSHOT.jar

----------------------------------------------
Config
There is variable monitor.url at application.yml
This case for test is "http://localhost:12345"

----------------------------------------------
The monitor continues execute in 2 seconds.
----------------------------------------------

For look log use GET in "/monitor"

Example: "http://localhost:8080/monitor"
