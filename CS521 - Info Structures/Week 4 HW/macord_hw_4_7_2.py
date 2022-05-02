"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.7.2
Description of Problem: Sum neighboring numbers
"""
# setting list of constants
INPUT_LIST = [10, 20, 30, 40, 50, 60]
print("Input list:", INPUT_LIST)
# creating blank list
result = []

# creating loop using the length of our constant, +1 so inclusive
for i in range(len(INPUT_LIST) + 1):

    # each of the below appends the neighbors to the list
    # first pass so it doesn't show out of bounds error
    if i == 0:
        result.append(INPUT_LIST[i] + INPUT_LIST[i + 1])

    # middle of the list appends
    elif 0 < i < len(INPUT_LIST) - 1:
        result.append(INPUT_LIST[i - 1] + INPUT_LIST[i] + INPUT_LIST[i + 1])

    # last entry in the list appended, so avoids out of bounds error
    elif i == len(INPUT_LIST) - 1:
        result.append(INPUT_LIST[i - 1] + INPUT_LIST[i])

print("Result list (adding neighbors to each other):", result)

"""
Test case:

Input list: [10, 20, 30, 40, 50, 60]
Result list (adding neighbors to each other): [30, 60, 90, 120, 150, 110]
"""