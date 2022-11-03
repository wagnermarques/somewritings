#!/bin/bash

#./script-args-1.sh a b c

echo $#
# 3

echo $@
#a b c

echo "${@: $#}"
#c
