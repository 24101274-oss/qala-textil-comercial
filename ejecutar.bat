@echo off
REM =====================================================
REM Ejecutar QALA_TEXTIL con configuración externa
REM =====================================================

echo =====================================================
echo ATENCION: NO CIERRE ESTA VENTANA
echo El programa se esta ejecutando y la ventana debe permanecer abierta
echo =====================================================
echo.

REM Carpeta donde está el .bat
set BASE_DIR=%~dp0

REM Ruta del JAR “fat” generado por Maven
set JAR_NAME=%BASE_DIR%target\QALA_TEXTIL-1.0-SNAPSHOT-jar-with-dependencies.jar

REM Intentar usar db.properties en la raíz del proyecto
if exist "%BASE_DIR%db.properties" (
    set PROP_PATH=%BASE_DIR%db.properties
) else (
    REM Si no está, buscar en la carpeta dist
    if exist "%BASE_DIR%dist\db.properties" (
        set PROP_PATH=%BASE_DIR%dist\db.properties
    ) else (
        echo No se encontro db.properties.
        pause
        exit /b 1
    )
)

REM Ejecutar el JAR pasando la ruta del properties como argumento
java -jar "%JAR_NAME%" "%PROP_PATH%"

echo.
echo =====================================================
echo El programa ha finalizado. Puede cerrar esta ventana.
echo =====================================================

pause
