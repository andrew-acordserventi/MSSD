"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/22/2021
Homework Problem: 5.5.2
Description of Problem: Input validation of 3 numbers
"""
if __name__ == '__main__':
    # while loop so user can try multiple times
    loop = True
    while loop is True:

        # gets input
        user_num = input("Please enter 3 numbers, separated by spaces. "
                         "For example: 1 2 3 or 123 456 789\n")

        # splits input into a list, separated by spaces
        user_list = user_num.split(" ")

        # if the list doesn't have 3 numbers, repeat the input and loop again
        if len(user_list) != 3:
            print("Did not enter 3 numbers. Please try again.")
            continue

        # sets a flag to true to check later
        flag = True

        # checks each entry of the list for a valid number (ValueError)
        for i in range(len(user_list)):
            try:
                user_list[i] = float(user_list[i])

            # sets flag to false to skip if statement if a ValueError happens
            except:
                print("Error: invalid input. Not a number. Please try again.")
                flag = False
                break

        # tries to do the calculation if the numbers are valid
        if flag is True:
            try:
                calc = (user_list[0] / user_list[1]) + user_list[2]
                loop = False # breaks the while loop

            # catches ZeroDivisionError
            except ZeroDivisionError:
                print("Cannot divide by zero. Please try again.")
                continue

    # prints the calculation
    print(user_list[0], "/", user_list[1], "+", user_list[2], "=", calc)

"""
Test case: 
Please enter 3 numbers, separated by spaces. For example: 1 2 3 or 123 456 789
10 5 2
10.0 / 5.0 + 2.0 = 4.0

Process finished with exit code 0

Please enter 3 numbers, separated by spaces. For example: 1 2 3 or 123 456 789
10 52
Did not enter 3 numbers. Please try again.
Please enter 3 numbers, separated by spaces. For example: 1 2 3 or 123 456 789
10 5 f
Error: invalid input. Not a number. Please try again.
Please enter 3 numbers, separated by spaces. For example: 1 2 3 or 123 456 789
10 0 2
Cannot divide by zero. Please try again.
Please enter 3 numbers, separated by spaces. For example: 1 2 3 or 123 456 789
10 5 2
10.0 / 5.0 + 2.0 = 4.0

Process finished with exit code 0
"""