@echo off
:kill
set /p create_op=Please enter the port number to terminate:
for /f "tokens=5" %%a in ('netstat -aon ^| find ":%create_op%" ^| find "LISTENING"') do taskkill /f /pid %%a
	set /p conti=Do you want to kill other port(Y = yes):
	if "%conti%" == "Y" GOTO kill
	if "%conti%" == "y" GOTO kill
	echo Bye Bye !! remember do assginment
pause