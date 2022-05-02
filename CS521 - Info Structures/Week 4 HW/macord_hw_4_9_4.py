"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.9.4
Description of Problem: Dictionary printing keys and values
Note: Did the output a few different ways to practice
"""
# initial dictionary
my_dict = {'a': 15, 'c': 18, 'b': 20}

# creates a list to work with for the dictionary
my_dict_list = [(key, value) for key, value in my_dict.items()]

# creates a list of the keys from the dict_list using list comprehension
key_list = [key for key, value in my_dict_list]
print("Keys:", key_list)

# creates a list of all the values
value_list = [value for key, value in my_dict_list]
print("Values:", value_list)

# prints the key/value pairs using iteration
# note we don't want a comma for the last entry
print("Key value pairs: ", end="")
for i in range(len(key_list)):
    if i < len(key_list) - 1:
        print(key_list[i], ":", value_list[i], end=", ")
    else:
        print(key_list[i], ":", value_list[i])

# prints the key value pairs, ordered by key
print("Key value pairs ordered by key:", sorted(my_dict_list))

# creates a list of the dictionary values and sorts them
key_sort = sorted(my_dict, key=my_dict.get)
value_sort_dict = {}

# loop to go through each value and add it to a new dictionary entry
for i in key_sort:
    value_sort_dict[i] = my_dict[i]

print("Key value pairs ordered by value: ", value_sort_dict)

"""
Test case:
Keys: ['a', 'c', 'b']
Values: [15, 18, 20]
Key value pairs: a : 15, c : 18, b : 20
Key value pairs ordered by key: [('a', 15), ('b', 20), ('c', 18)]
Key value pairs ordered by value:  {'a': 15, 'c': 18, 'b': 20}

Process finished with exit code 0
"""
