#!/bin/bash
#
# Purpose: build a zip

set -e
cd "$(dirname $0)/.."
mvn clean
rm /tmp/dojo.zip
cd ..
zip -r /tmp/dojo.zip  dojo -x '*/lib*' -x '*.DS_Store*' -x '*target*'
