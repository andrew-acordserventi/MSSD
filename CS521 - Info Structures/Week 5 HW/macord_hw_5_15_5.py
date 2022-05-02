"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/22/2021
Homework Problem: 5.15.5
Description of Problem: Compound interest calculator - recursion
"""

def calc_compound_interest(p, i, n):
    """Calculates compound interest using given formula. Takes principle,
    interest, and number of years as inputs."""
    # compound interest formula
    amount = p * ((1 + i) ** n)
    return amount


def calc_compound_interest_recursive(p, i, n):
    """Calculates compound interest using recursion. Takes principle,
    interest, and number of years as inputs."""

    # first year, returns just the principle since no compounding
    if n == 0:
        return p
    else:

        # annual interest amount to be added for that year
        interest = p * i

        # recursively calcs compound interest -
        # passes interest + principle as p and years minus 1 as time
        return calc_compound_interest_recursive((p + interest), i, n-1)


if __name__ == '__main__':
    # gets input for principle
    while True:
        principle = input("Please enter your principle amount (ie., 5000):\n")

        # validation check for principle
        try:
            principle = float(principle)
            break
        except:
            print("Invalid principle. Please try again.")

    # gets input for interest rate
    while True:
        int_rate = input("Please enter your interest rate in numbers with no "
                         "percent signs (ie., 5% would be entered as 5:\n")

        # validation check for interest rate
        try:
            int_rate = float(int_rate)/100
            break
        except:
            print("Invalid interest rate. Please try again.")

    # gets input for years
    while True:
        years = input("Please enter the number of years to compound:\n")

        # validation check for years
        try:
            years = float(years)
            break
        except:
            print("Invalid years. Please try again.")

    # calls and stores the formulaic compound interest function
    formula = calc_compound_interest(principle, int_rate, years)

    # calls and stores the recursive compound interest function
    recursive = calc_compound_interest_recursive(principle, int_rate, years)

    # formats and prints the input and 2 functions for compound interest
    print("Principle: {:,.2f}, Interest: {}, Years: {:.0f}".format(
        principle, int_rate, years))
    print("Compounded using formula: {:,.2f}".format(formula))
    print("Compounded using recursion: {:,.2f}".format(recursive))

    # creates a rounded to 4 decimal places to compare
    rounded_formula = round(formula, 4)
    rounded_recursive = round(recursive, 4)

    # checks if the rounded versions are the same
    if rounded_formula == rounded_recursive:
        print("The formula and recursive methods produced the same number!")

    # triggers if rounded versions are not the same;
    # normal triggers on very large results or large # of years (200+ years)
    elif rounded_formula != rounded_recursive:
        print("The formula and recursive methods did not produce the "
              "same number!")

"""
Test cases:

Please enter your principle amount (ie., 5000):
50000
Please enter your interest rate in numbers with no percent signs (ie., 5% would be entered as 5:
5
Please enter the number of years to compound:
5
Principle: 50,000.00, Interest: 0.05, Years: 5
Compounded using formula: 63,814.08
Compounded using recursion: 63,814.08
The formula and recursive methods produced the same number!

Process finished with exit code 0

Please enter your principle amount (ie., 5000):
fifty thousand
Invalid principle. Please try again.
Please enter your principle amount (ie., 5000):
50000
Please enter your interest rate in numbers with no percent signs (ie., 5% would be entered as 5:
five
Invalid interest rate. Please try again.
Please enter your interest rate in numbers with no percent signs (ie., 5% would be entered as 5:
5
Please enter the number of years to compound:
five
Invalid years. Please try again.
Please enter the number of years to compound:
5
Principle: 50,000.00, Interest: 0.05, Years: 5
Compounded using formula: 63,814.08
Compounded using recursion: 63,814.08
The formula and recursive methods produced the same number!

Please enter your principle amount (ie., 5000):
5000
Please enter your interest rate in numbers with no percent signs (ie., 5% would be entered as 5:
5
Please enter the number of years to compound:
400
Principle: 5,000.00, Interest: 0.05, Years: 400
Compounded using formula: 1,495,166,756,244.22
Compounded using recursion: 1,495,166,756,244.20
The formula and recursive methods did not produce the same number!
"""