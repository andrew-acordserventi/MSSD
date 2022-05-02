"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.7.1
Description of Problem: List comprehension - evens and odds
"""
# creates our constant list
X_CONST = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print("Evaluating the numbers in:", X_CONST)

# adds up the resulting list comprehension of even numbers
y = sum([i for i in X_CONST if i % 2 == 0])
print("Even:", y)

# adds up the resulting list comprehension of odd numbers
y = sum([i for i in X_CONST if i % 2 == 1])
print("Odd:", y)
