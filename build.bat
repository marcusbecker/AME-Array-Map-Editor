@ECHO OFF
rem Build

mkdir class

javac -cp src -d class src\br\com\mvbos\ame\App.java

jar cfm Ame.jar MANIFEST.MF -C class/ .
