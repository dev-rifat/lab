#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"

if lsof -nP -iTCP:1001 -sTCP:LISTEN > /dev/null 2>&1; then
    echo "Port 1001 already in use. Old server bondo koro: pkill -f labfinal1.Server"
    exit 1
fi

java src/main/java/labfinal1/Server.java
