#!/bin/bash
# /usr/local/bin/
pid=`ps aux | grep balance-reader-0.0.1 | awk '{print $2}'`
kill -9 $pid