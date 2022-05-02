"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.9.3
Description of Problem: Dictionary zipping
"""
import sys as sys

# set constants
F_NAME = ['Jane', 'John', 'Jack', 'Keanu']
print("First names:", F_NAME)
L_NAME = ['Doe', 'Deer', 'Black', 'Reeves']
print("Last names:", L_NAME)

# check to make sure length of first and last name lists are the same or exit
if len(F_NAME) != len(L_NAME):
    print("Lengths of the first and last name constants do not match.")
    print("Exiting program...")
    sys.exit()

# zip function to combine last and first names
name_dict = dict(zip(L_NAME, F_NAME))
print("Name Dictionary:", name_dict)

"""
Test case:
First names: ['Jane', 'John', 'Jack', 'Keanu']
Last names: ['Doe', 'Deer', 'Black', 'Reeves']
Name Dictionary: {'Doe': 'Jane', 'Deer': 'John', 'Black': 'Jack', 'Reeves': 'Keanu'}

Process finished with exit code 0

"""