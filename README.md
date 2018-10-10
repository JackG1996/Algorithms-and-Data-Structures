#Algorithms & Data Structures

#Lab 1 - Collinear Test
Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if: x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0

Number of methods to complete and various questions to complete in relation to runtimes.
Methods to compelete:

Implement brute force solotion
non-trivial use of InsertionSort and Binary Search.
InsertionSort & Binary Search themselves

#Lab 2 - Doubly Linked List
Class DoublyLinkedList: implements a generic Doubly Linked List. @param This is a type parameter. T is used as a class name in the definition of this class. When creating a new DoublyLinkedList, T should be instantiated with an actual class name that extends the class Comparable. Such classes include String and Integer.

For example to create a new DoublyLinkedList class containing String data: DoublyLinkedList myStringList = new DoublyLinkedList();

The class offers a toString() method which returns a comma-separated sting of all elements in the data structure.

This is a bare minimum class you would need to completely implement. You can add additional methods to support your code. Each method will need to be tested by your jUnit tests -- for simplicity in jUnit testing introduce only public methods.

#Lab 3 - Binary Search Tree
binary search trees (BST), sometimes called ordered or sorted binary trees, are a particular type of container: data structures that store "items" (such as numbers, names etc.) in memory. They allow fast lookup, addition and removal of items, and can be used to implement either dynamic sets of items, or lookup tables that allow finding an item by its key (e.g., finding the phone number of a person by name).

Complete methods for the data structure including height(), get(), put(), rank() and submit unit testing.

#Lab 4 - FaceBook Circles

#Lab 5 - Nine Digit Perfect Square
A natural number, p, is a perfect square if for some natural number k, k^2=p. For example, 16 is a perfect square, as 4^2=16. The number 20 is not a perfect square as there is no natural number k such that k^2=20.

Problem: Develop an algorithm that will find all nine-digit perfect squares that use all nine digits exactly once. For example, 139,854,276 is a solution (the first) as 11,826^2=139,854,276.

Fill in the implementation of the methods described in this file.
Test your implementation by developing suitable test suite in the NineDigitPerfectSquareTest JUnit test case.

#Lab 6 - Floyds Random Number
Complete algorithm using recursive, iterative and other methods

#Lab 7 - Chapman Puzzle
The Chapman 15-Puzzle (previous mis-named the Sam Loyd 15-puzzle) is represented as a 4 * 4 board with tiles numbered from 1 to 15 and one blank location into which a neighbouring tile can be moved. To solve the puzzle the tiles on the ‘initial’ board are re-arranged to create the ‘final’ board where the tiles are arranged in numerical order from top left to bottom right of the board. This is achieved by swapping tiles into the blank location so that they can be moved around the board.

Complete:

Simulating the ‘playing’ of the 15-puzzle
Checking if a solution is possible.

#Lab 8 - Self Divisible Numbers
Self divisible numbers are those, that satisfy the following property: a) All the 9 digits in the number are different, i.e. each of the 9 digits 1..9 is used once. b) The number denoted by the first k-digits is divisible by k (i.e. the first k-digits are a multiple of k)

Consider the number 723654981; We have: 1|7, 2|72, 3|723, 4|7236, 5|72365, 6|723654 [read a|b as “a divides b” or “b is a multiple of a” ] but 7 does not divide 7236549. So this number does not satisfy property b).

Create a Java program that generates all 9-digit numbers.
