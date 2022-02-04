#!/bin/bash

gcc main.c -o gktwindow $(pkg-config --libs --cflags gtk+-2.0)
