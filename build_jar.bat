@echo off
REM ==========================================
REM build_jar.bat - Compila y genera JAR ejecutable
REM ==========================================

REM Directorio del proyecto
set PROJECT_DIR=%~dp0

REM Maven local en la carpeta del proyecto
set MAVEN_HOME=%PROJECT_DIR%maven
set PATH=%MAVEN_HOME%\bin;%PATH%

echo =============================================
echo Usando Maven local: %MAVEN_HOME%
echo =============================================

REM Ir al directorio del proyecto
cd /d %PROJECT_DIR%

REM Limpiar y generar jar con dependencias
mvn clean package

REM Mostrar ubicación del jar
echo ---------------------------------------------
echo .JAR ejecutable generado en:
echo %PROJECT_DIR%target\QALA_TEXTIL-1.0-SNAPSHOT-jar-with-dependencies.jar
echo ---------------------------------------------

pause