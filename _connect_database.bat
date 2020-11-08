@echo off
	
	REM kill port
	set des_cd = "%cd%"
	echo :
	echo ============================================================
	echo  If port is used by other program please kill
	echo ============================================================
	echo :
	
	pause
	
	cd %JAVA_HOME%
	cd ..
	cd db
	cd lib
	
	start java -jar derbynet.jar start
pause
	echo Starting database wait to done continue ...
pause	
	cd "%des_cd%"
	echo connect 'jdbc:derby://localhost:1527/C:/Users/ITSUKA KOTORI/Desktop/Assignment/Database_Data/QuicKarDB;' user 'QuicKarAdmin' password 'quickarPass';
	
	