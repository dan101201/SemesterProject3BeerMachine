REM === Compile ===
call mvn package
REM ===

REM === Run ===
cd "target/jar"
call java -jar BeerBackend.jar
REM ===