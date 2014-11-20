#!/bin/bash
#
# Purpose: build a zip

set -e

DEST=/tmp/lights-out-kata.zip
git archive --format=zip --prefix=$(basename $DEST .zip)/ HEAD > $DEST
ls -l $DEST
