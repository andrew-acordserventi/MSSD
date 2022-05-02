# CS 665 Assignment 1

###Marcus Andrew Acord-Serventi

###Assumptions

Assignment asked us to create a coffee machine capable of making a few drinks, adding milk/sugar, and adding a price (as optional).

No main method or GUI - all testing to be run through JUnit and codeassist.

The Drink class was really the main goal of the assignment. A constructor to build drinks, add milk/sugar methods, and various variables to keep track of all the drink options was created. The coffee machine is the test class.

Assumed there was no difference between coffee and tea, in terms of production. Think like a Keurig machine and K-Cups and/or a Nescafe machine.

###Implementation details

The coffee machine created is TestCoffeeMachine. It contains two test methods to assert functionality of the Drink class.

The Drink class contains most of the code necessary to produce a drink. Pricing, type, name, etc.

###UML

![alt text](UML.jpg)

###Assignment Questions

1. Flexibility - Code is somewhat flexible. Adding new types of drinks really only requires adding to the price method. There's probably a better way of doing this though. Went back and added a few final variables to improve flexibility. Coupling is tight, which is not good for flexibility... but not sure how to improve in this aspect...
2. Simplicity - The code should be very simple and easy to understand.
3. Duplicated code - Not much code is duplicated - for now. As the system grows larger and more complex, some code might get duplicated. I hope to learn to avoid some of the duplicated code in this course.

Checked the code through CodeAssist and it compiled, passed the tests, and passed the bug finder.
