"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/22/2021
Homework Problem: 5.5.1
Description of Problem: Vowel and consonant function
"""

def vc_counter(sentence):
    """Counts the number of vowels and consonants in a given sentence"""
    # list comprehension to split up the input sentence
    sentence_list = [i for i in sentence]

    # list of vowels and consonants
    vowels = "aeiou"
    consonants = "bcdfghjklmnpqrstvwxyz"

    # iterates through the length of the list
    for i in range(len(sentence_list)):

        # if the current entry is a vowel, add 1 to the dictionary entry
        if sentence_list[i] in vowels:
            vc_dict['Vowels'] += 1

        # if the current entry is a consonant, add 1 to the dictionary entry
        elif sentence_list[i] in consonants:
            vc_dict['Consonants'] += 1

    # returns the dictionary entry
    return vc_dict


if __name__ == '__main__':
    # creates the dictionary and sets vowels and consonants to 0
    vc_dict = {'Vowels': 0, 'Consonants': 0}

    # gets input and makes it all lower case to compare
    # note, no input validation - if user enters numbers or other characters,
    # the counter will simply not count them, no need to validate
    sentence = input("Please input an English sentence: \n")
    sentence = sentence.lower()

    # calls the vc_counter function
    vc_counter(sentence)

    # prints the number of vowels and consonants
    print("Number of vowels:", vc_dict['Vowels'])
    print("Number of consonants:", vc_dict['Consonants'])

"""
Test:
Please input an English sentence: 
The quick brown fox's jump landed past the lazy dog!
Number of vowels: 12
Number of consonants: 29

Process finished with exit code 0
"""
