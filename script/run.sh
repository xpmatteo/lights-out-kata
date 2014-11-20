#!/bin/bash
#
# Purpose: run the application
#
# Before you call this script, you should run 'mvn clean package'
#

set -e
cd "$(dirname $0)/.."

java -cp target/classes:"target/dependency/*" it.xpug.dojo.Main
