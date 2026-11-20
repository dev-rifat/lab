#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"

# IDE-r jonno class gulo banai (target/classes)
rm -rf target
mkdir -p target/classes
javac -d target/classes src/main/java/labfinal1/*.java

echo "Ready: target/classes - ekhon IDE-r Run button chapo."
