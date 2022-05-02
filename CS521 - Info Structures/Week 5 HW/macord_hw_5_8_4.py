"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/22/2021
Homework Problem: 5.8.4
Description of Problem: Read from a file - return words that only appear once
"""
import sys as sys

def list_to_words(file_words):
    """Takes a list of words. Returns unique words in the list."""
    unique_list = []

    # iterates through each word in the list
    for i in range(len(file_words)):

        # sets the remove counter to 0
        remove = 0

        # creates a nested iteration to compare the i word against all words
        for e in range(len(file_words)):

            # if the word at i matches the word at e, adds one to remove
            if file_words[i] == file_words[e]:

                # if it catches multiple words, remove will be greater than 1
                remove +=1

        # if it only caught one unique instance, append to list of unique words
        if remove == 1:
            unique_list.append(file_words[i])

    # return the list of unique words
    return unique_list


if __name__ == '__main__':
    # name of the file
    read_database = input("Please input the exact filename to be analyzed:\n")

    # initializes the current_database for the try/except
    current_database = ""

    # opens the file, checks to ensure file exists, or exit without crash
    try:
        current_database = open(read_database, "rt")
    except:
        print("Error: file does not exist. Exiting program.")
        sys.exit()

    # reads the first line -
    # this must be done here to start the while loop or line_read will be empty
    line_read = current_database.readline().rstrip()

    line_list_split = []

    # loops through each line of the file
    while line_read != "":

        # appends each word to a list
        line_list_split += line_read.split()

        # moves to the next line
        line_read = current_database.readline().rstrip()

    # closes the text file
    current_database.close()

    # calls the list to words function
    unique_words = list_to_words(line_list_split)

    # prints the name of the file and the unique words
    print("The file checked is:", read_database)
    print(read_database, "contains the following unique words:")
    for i in range(len(unique_words)):
        print("\"" + unique_words[i] + "\"", end= " ")

"""
Test cases:

test to see if this
splits the list or not
to validate
the program and get HW credit

Please input the exact filename to be analyzed:
sample.txt
The file checked is: sample.txt
sample.txt contains the following unique words:
"test" "see" "if" "this" "splits" "list" "or" "not" "validate" "program" "and" "get" "HW" "credit" 
Process finished with exit code 0

test test
and and
not not
two
three

Please input the exact filename to be analyzed:
sample.txt
The file checked is: sample.txt
sample.txt contains the following unique words:
"two" "three" 
Process finished with exit code 0

Please input the exact filename to be analyzed:
sample1.txt
Error: file does not exist. Exiting program.

Process finished with exit code 0
"""