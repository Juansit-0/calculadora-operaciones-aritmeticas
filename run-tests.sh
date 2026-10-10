#!/usr/bin/env bash
# Compila la aplicacion y ejecuta los tests unitarios con JUnit 5.
# Descarga el jar de JUnit si no existe.
set -euo pipefail
cd "$(dirname "$0")"
JUNIT=lib/junit-platform-console-standalone-1.11.3.jar
if [ ! -f "$JUNIT" ]; then
  mkdir -p lib
  curl -sSL -o "$JUNIT" https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.3/junit-platform-console-standalone-1.11.3.jar
fi
rm -rf out && mkdir -p out
javac -d out src/main/java/*.java
javac -d out -cp "out:$JUNIT" src/test/java/*.java
java -jar "$JUNIT" execute --class-path out --scan-class-path \
  --details=tree --reports-dir=test-reports
