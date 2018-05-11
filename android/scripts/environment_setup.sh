#!/bin/bash

#SETUP ANDROID_HOME
export ANDROID_HOME=/home/wagner/PROGSATIVOS/androidSdk

#export ANDROID_SDK_ROOT=/home/wagner/PROGSATIVOS/androidSdk

export JAVA_HOME=/home/wagner/PROGSATIVOS/jdk1.8.0_161

export GRADLE_HOME=/home/wagner/PROGSATIVOS/gradle-4.6-rc-2

export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$ANDROID_SDK_ROOT/tools:$ANDROID_SDK_ROOT/platform-tools:$GRADLE_HOME/bin
