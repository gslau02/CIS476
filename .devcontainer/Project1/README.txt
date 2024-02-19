+--------------------------------------+
|Word Processing Application GUI Tester|
+--------------------------------------+

## Description

This program tests the GUI components of different generations of Word Processing Applications produced by MicroOffice (Word90, Word00, Word10, Word24). The GUI components include Panel, Button, and Textbox, which look different in each generation.

## Installation

Ensure you have Java Development Kit (JDK) installed on your machine. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

## Usage

1. Compile the program using the following command:
   javac Main.java

2. Run the program using the the following command:
   java Main

## Configuration file

The configuration file (config.txt) contains a list of Word Processing Application generations to test. 
Each generation should be on a separate line. Example content:
Word90
Word00
Word90
Word24
Word10
Word00
Word24
Word90
Word00

## Output

The program will display the GUI components for each generation specified in the configuration file. If the same generation is specified more than twice, a warning message will be displayed.
