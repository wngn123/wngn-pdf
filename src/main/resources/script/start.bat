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
cd app
 
for /R %%s in (*.jar) do ( 
    set LIBS=%LIBS%;%%s
) 
cd ..
:: java -classpath D:\temp\app\wngn-pdf-2.0.0.jar;D:\temp\lib\junit-4.12.jar com.zzia.wngn.pdf.ui.UIMain
:: java %JVMS% -cp %LIBS% com.zzia.wngn.pdf.ui.UIMain &
start  javaw -classpath %LIBS% com.zzia.wngn.pdf.ui.UIMain

