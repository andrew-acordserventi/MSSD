"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/26/2021
Homework Problem: 6.11.1
Description of Problem: Creating classes - sentences
"""


class Sentence:
    """Creates an object of a sentence. Allows for getting words and
    replacing words."""
    def __init__(self, sentence=''):
        self.__sentence = sentence

    def __str__(self):
        return self.__sentence

    def get_all_words(self):
        """Returns all the words in the sentence as a list."""
        return self.__sentence.split(" ")

    def get_word(self, index):
        """Takes an int and returns the word at that specific index."""
        # assert to test that an integer was passed
        assert int(index), 'Get word needs an integer for index'
        return self.get_all_words()[index]

    def set_word(self, index, new_word):
        """Takes a word at an index location (int) and a new word and changes
        the word in the sentence at that index to the new word."""
        # gets all the words as a list and stores it
        sentence = self.get_all_words()

        # assert to test for an actual word to be passed
        assert new_word.isalpha(), 'set_word should have a new word passed'

        # changes the word at a specific index to the new word
        sentence[index] = new_word

        # recompiles the sentence as a new string, not list
        new_sentence = ""
        for i in range(len(sentence)):
            new_sentence += sentence[i] + " "

        # sets the new sentence
        self.__sentence = new_sentence


if __name__ == '__main__':

    # creates a new sentence object, prints it
    x = Sentence("this sentence contains strawberry in it.")
    print(x)

    # prints all the words in a list, then word at position 3
    print(x.get_all_words())
    print(x.get_word(3))

    # sets variables to change the word in the sentence
    new_word_index = 3
    new_word = input("New word?\n")
    # assert, test with the word banana (other words crash)
    #assert new_word == 'banana', 'New word did not equal banana.'

    # tests the set word function, changing sentence to banana
    print(x)
    x.set_word(new_word_index, new_word)
    print(x.get_word(3))
    print(x)

"""Test Case:

1,2. this sentence contains strawberry in it.
3. ['this', 'sentence', 'contains', 'strawberry', 'in', 'it.']
4. strawberry
5. New word?
5. banana
6. this sentence contains strawberry in it.
5. banana
6. this sentence contains banana in it. 

Process finished with exit code 0

Assert test for word:

this sentence contains strawberry in it.
['this', 'sentence', 'contains', 'strawberry', 'in', 'it.']
strawberry
New word?
34
this sentence contains strawberry in it.
Traceback (most recent call last):
  File 
    x.set_word(new_word_index, new_word)
  File 
    assert new_word.isalpha(), 'set_word should have a new word passed'
AssertionError: set_word should have a new word passed

Process finished with exit code 1

"""