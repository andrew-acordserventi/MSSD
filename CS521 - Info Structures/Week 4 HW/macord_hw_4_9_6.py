"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/14/2021
Homework Problem: 4.9.6
Description of Problem: Converting a number to words (fun!)
"""
# sets a flag to exit the while loop
flag = False
user_num = ""

# number validation loop
while flag is not True:

    # gets a fresh user number
    user_num = input("Enter a number: \n")

    # checks for commas
    if "," in user_num:
        print("Please try again without commas.")
        continue

    # checks for an int. if int is found, exits the loop
    try:
        user_num = int(user_num)
        flag = True

    # triggers if type isn't castable to int
    except:

        # checks for a float (decimal). if number is float, exits the loop
        try:
            user_num = float(user_num)
            flag = True

        # if number is not float, and not int, tells them its not valid
        # and goes back to start of loop to re-prompt
        except:
            print(user_num, "is not a valid number. Please try again.")
            continue

# creates our dictionary of numbers, decimal, and negative to use
text_dict = {'1': 'one', '2': 'two', '3': 'three', '4': 'four', '5': 'five',
             '6': 'six', '7': 'seven', '8': 'eight', '9': 'nine', '0': 'zero',
             '.': 'point', '-': 'negative'}

# typecasts our user_num into a str and splits that string into a list
user_num_str = str(user_num)
user_num_list = list(user_num_str)

# iterates through each digit in the list
for i in range(len(user_num_list)):

    # prints the value of our dictionary for each number in the list
    print(text_dict[user_num_list[i]], end=" ")

"""
Test cases:

Enter a number: 
1,234.56
Please try again without commas.
Enter a number: 
one
one is not a valid number. Please try again.
Enter a number: 
one two three
one two three is not a valid number. Please try again.
Enter a number: 
12345.6
one two three four five point six 
Process finished with exit code 0

Enter a number: 
54321
five four three two one 
Process finished with exit code 0

Enter a number: 
-456
negative four five six 
Process finished with exit code 0
"""