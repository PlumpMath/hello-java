
INTRODUCTION
============

This is the skeleton Java project that support basic command-line
parsing, and log4j logger.

COMPILATION
-----------

        $ # compile the sources
        $ mvn compile
        
        $ # package the class files into a jar
        $ mvn package

        $ # execute the program with command line arguments
        $ mvn exec:java -Dexec.args="argument argument..."
