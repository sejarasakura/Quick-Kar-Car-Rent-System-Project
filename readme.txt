
==================================================================
|	System software start up introductone
==================================================================
|	1 ) read assignement_info.xml
|	2 ) connect server (as local host)
|	3 ) connect database
|	4 ) start up system
==================================================================

==================================================================
|	Part 1 read assignement_info.xml
==================================================================
|	Step 1: open assignement_info.xml
|	Step 2: The server and database username & password is written
==================================================================

==================================================================
|	Part 2 connect to localhost aphche tomcat
==================================================================
|Solution 1 :
|	Step 1: run command prompt as (admin).
|	Step 2: cd to assignment directory.
|	Step 3: [enter] _start_server
|
|Solution 2 :
|	Step 1 : Open Netbean IDE 
|	Step 2 : press [ctrl + 5] (Open services)
|	Step 3 : Click server(right click) > add server > Apache tomcat* >
|		 server location > (choose assginment directory)/Apache tomcat*
|	Step 4 : Right click to new added server and try to connect 
|	Step 5 : If cannot connect run _kill_port.bat file as Admin (key in 8080)
|
|Solution 3 : 
|	Step 1 : Type [win + s] > Search 'edit system environment variable'
|	Step 2 : Click "Environment variable"
|	Step 3 : Add new User / System variable 
|		JRE_HOME --> "C:\Program File\Java\jdk*\bin"
|		JAVA_HOME --> "C:\Program File\Java\jre*"
|	Step 4 : Go back to Assignment directory > apache-tomcat* > bin 
|		> startup.bat (run as admin wait startup)
|	Step 5 : If cannot connect run _kill_port.bat file as Admin (key in 8080)
==================================================================

==================================================================
|	Part 3 connect to derby database
==================================================================
|Solution 1 :Solution 1 :
|	Step 1: run command prompt as (admin).
|	Step 2: cd to assignment directory.
|	Step 3: [enter] _connect_database.
|Solution 2 :
|	Step 1 : Open Netbean IDE 
|	Step 2 : press [ctrl + 5] (Open services)
|	Step 3 : Click database > Java DB > connect to APP database
|Solution 3 : 
|	Step 1: run command prompt as (admin).
|	Step 2: cd to 'Program Files' > Java > jdk* > db > lib > 
|	Step 3: [enter] java -jar derbynet.jar (run the jar file)
==================================================================

==================================================================
|	Part 4 Start up using system								 
==================================================================
|	Step 1 open web bowser 										 
|	Step 2 enter url localhost:8080/GroupProject				
==================================================================