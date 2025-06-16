@echo off
echo Compiling Java files...
rd /s /q out
mkdir out
javac -d out src\app\Main.java src\model\*.java src\model\payment\*.java src\util\*.java

echo Running program...
java -cp out app.Main

pause
