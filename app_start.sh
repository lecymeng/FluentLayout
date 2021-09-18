#!/usr/bin/env bash

for i in `seq 1 12`
do 
  adb shell am force-stop com.weicools.fluentlayout
  sleep 2
  adb shell am start-activity -W -n com.weicools.fluentlayout/.MainActivity | grep "TotalTime" | cut -d ' ' -f 2
  sleep 2
done