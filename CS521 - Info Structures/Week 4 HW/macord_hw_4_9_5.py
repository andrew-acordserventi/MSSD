"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.9.5
Description of Problem: Histogram frequency of letters
"""
import sys as sys

# sets the constant and prints it to the user; test cases below
#X = "WAS IT A RAT I SAW"
#X = "was it a rat i sawqqqqq"
#X = "WWAS IT A RAT I SAWW"
X = "WWAS IT A RAT I SAWWQQQQ"


if len(X) < 15:
    print("Constant does not have 15 or more characters. Exiting.")
    sys.exit()

# sets the constant to all upper for easy analysis and comparison
# in case the constant is changed during testing, etc.
X = X.upper()
print("String being analyzed:", X)

# removes whitespace
X = X.replace(" ", "")

letter_dict = {}

# iterates through each letter in the constant
for letter in X:

    # if the letter is already in dictionary, add one more instance to it
    if letter in letter_dict:
        letter_dict[letter] += 1

    # if the letter isn't in the dictionary, create it, with a value of 1
    else:
        letter_dict[letter] = 1

# creates a sort of the dictionary by values (reversed so biggest is first)
key_sort = sorted(letter_dict, key=letter_dict.get, reverse=True)
value_sort_dict = {}

# creates a new dictionary that is sorted by value
for i in key_sort:
    value_sort_dict[i] = letter_dict[i]
print("Sorted dictionary of letter counts:", value_sort_dict)

# gets the most commonly used value's number
frequency = list(value_sort_dict.values())[0]

# iterates through the sorted dictionary
freq_letter_list = []
for i in range(len(value_sort_dict)):

    # checks if the value of the most frequent letter is the same as i
    if frequency == list(value_sort_dict.values())[i]:
        # if frequency is same as the i position in the dictionary,
        # it means theres a tie, and it appends it to the letter list
        freq_letter_list.append(list(value_sort_dict.keys())[i])

    # once there are no more ties, the else breaks the iteration loop
    else:
        break

# note, if we didn't need to turn the list into strings for printing (per
# the prompt), this block of code would be unnecessary
# iterates through the frequency letter list
freq_letter = ""
for i in range(len(freq_letter_list)):

    # if the list only has one item, then the frequency letter is done
    if len(freq_letter_list) == 1:
        freq_letter = freq_letter_list[0]
        break

    # if the list contains more than one item, the else triggers
    else:

        # formatting for the comma; does not include comma on last item
        if i < len(freq_letter_list)-1:
            freq_letter += "\"" + str(freq_letter_list[i]) + "\", "
        else:
            freq_letter += "\"" + str(freq_letter_list[i]) + "\""

print("The most frequent letter is", freq_letter,
      "which appears", frequency, "times.")

# creates a list of all the keys, multiplied by the number of times
histo_list = []
for i in value_sort_dict:
    histo_list.append(i*value_sort_dict[i])

# prints the list, 1 line per entry
for i in range(len(histo_list)):
    print(histo_list[i])

"""
Test cases:
String being analyzed: WWAS IT A RAT I SAWW
Sorted dictionary of letter counts: {'W': 4, 'A': 4, 'S': 2, 'I': 2, 'T': 2, 'R': 1}
The most frequent letter is "W", "A" which appears 4 times.
WWWW
AAAA
SS
II
TT
R

String being analyzed: WAS IT A RAT I SAWQQQQQ
Sorted dictionary of letter counts: {'Q': 5, 'A': 4, 'W': 2, 'S': 2, 'I': 2, 'T': 2, 'R': 1}
The most frequent letter is Q which appears 5 times.
QQQQQ
AAAA
WW
SS
II
TT
R

String being analyzed: WAS IT A RAT I SAW
Sorted dictionary of letter counts: {'A': 4, 'W': 2, 'S': 2, 'I': 2, 'T': 2, 'R': 1}
The most frequent letter is A which appears 4 times.
AAAA
WW
SS
II
TT
R

String being analyzed: WWAS IT A RAT I SAWWQQQQ
Sorted dictionary of letter counts: {'W': 4, 'A': 4, 'Q': 4, 'S': 2, 'I': 2, 'T': 2, 'R': 1}
The most frequent letter is "W", "A", "Q" which appears 4 times.
WWWW
AAAA
QQQQ
SS
II
TT
R
"""