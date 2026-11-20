#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"

# kono target/out folder lagbe na - .java file direct run hochey
LOG="$(mktemp)"
java src/main/java/labfinal1/Server.java > "$LOG" 2>&1 &
SERVER_PID=$!
trap 'kill $SERVER_PID 2>/dev/null || true; rm -f "$LOG"' EXIT

sleep 1
java src/main/java/labfinal1/Client.java
sleep 1

echo "--- SERVER OUTPUT ---"
cat "$LOG"
