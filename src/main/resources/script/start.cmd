@echo off
set "DIR=%cd%"
%~d0
cd "%DIR%"
set LIBS=%DIR%\conf
cd lib 
setlocal EnableDelayedExpansion
for /R %%s in (*.jar) do ( 
   set LIBS=!LIBS!;%%s
)

cd ..
cd conf

for /R %%s in (*.xml) do ( 
    set LIBS=%LIBS%;%%s
)

for /R %%s in (*.properties) do ( 
    set LIBS=%LIBS%;%%s
) 

cd ..
cd app

for /R %%s in (*.jar) do ( 
    set LIBS=%LIBS%;%%s
) 
cd ..
:: DEBUG='-Xdebug -Xrunjdwp:transport=dt_socket,address=52002,server=y,suspend=y'
:: JVMS='-server -Xmx256m -Xms126m -XX:+UseConcMarkSweepGC'
start  javaw -cp %LIBS% com.wngn.pdf.BootServer &



