CS 442 Design Patterns
Spring 2015
PROJECT 5 README FILE

Due Date: Monday, May 4, 2015
Submission Date: Monday, May 4, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: ? Days
Author(s): Adam Almonte, David Morris
e-mail(s): aalmont4@binghamton.edu, dmorris4@binghamton.edu


PURPOSE:

An assignment designed to be an example of reflection in Java, parsing an input file and using reflection to create objects based on given fqn (Fully Qualified class Name) values.

PERCENT COMPLETE:

We believe we have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

None that we know of.

BUGS:

None that we know of.

FILES:

almonte_adam_morris_david_assign5/objComp/README.txt
almonte_adam_morris_david_assign5/objComp/src/build.xml
almonte_adam_morris_david_assign5/objComp/src/objComp/driver/Driver.java
almonte_adam_morris_david_assign5/objComp/src/objComp/fileOperations/FileProcessor.java
almonte_adam_morris_david_assign5/objComp/src/objComp/util/First.java
almonte_adam_morris_david_assign5/objComp/src/objComp/util/Second.java
almonte_adam_morris_david_assign5/objComp/src/objComp/util/PopulateObjects.java
almonte_adam_morris_david_assign5/objComp/src/objComp/util/MyLogger.java


SAMPLE OUTPUT:

run:
     [java] Number of non-duplicate First objects: 237
     [java] Total Number of First objects: 474
     [java] Number of non-duplicate Second objects: 263
     [java] Total Number of Second objects: 526
     [java] Total Time: 119


TO COMPILE:

Open a terminal and, from the folder containing this README, type

ant -buildfile src/build.xml all

TO RUN:

In a terminal window at the folder containing this README, type

ant -buildfile src/build.xml run -Darg0=[input file name] -Darg1=[number of iterations to use] -Darg2=[debug value]

The debug granularities are as follows:

0: Prints only the typical output (see in "SAMPLE OUTPUT" above)
1: Prints any time a method is called, as well as the typical output
2: Prints any time a hash map (the data structure we chose to use) is modified, as well as the typical output
3: Prints any time a constructor is called, as well as the typical output



EXTRA CREDIT:

N/A

BIBLIOGRAPHY:

This serves as evidence that I am in no way intending Academic Dishonesty.
Adam Almonte
David Morris

  *Official Java and Oracle Documentation

  *Class e-mail list


ACKNOWLEDGEMENT:

N/A
