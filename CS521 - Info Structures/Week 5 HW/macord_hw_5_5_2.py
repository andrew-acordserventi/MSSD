"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/22/2021
Homework Problem: 5.5.2
Description of Problem: Date and time function checker
"""
import sys as sys

def is_validate_datetime(user_time_date):
    """Checks the passed string to see if the date/time is valid.
    Returns a boolean for validity and an error message."""
    # splits the input by the space in the middle into a list
    date_time = user_time_date.split(" ")

    # splits the date and time into two separate lists, divided by : and /
    date = date_time[0].split("/")
    time = date_time[1].split(":")

    # validation to check for numbers
    for i in range(len(date)):
        try:
            int(date[i])
            int(time[i])

        # if non-numbers input, error message printed and exit w/out crashing
        except:
            print("Invalid numbers input. Please re-run program. Exiting.")
            sys.exit()

    # creates an empty global error to return
    global error
    error = ""

    # checks through each possible error
    # returns false and error message if not valid
    if date[0] > "12":
        error = "Error: months cannot exceed 12 per year."
        return False, error
    elif date[1] > "31":
        error = "Error: days cannot exceed 31 per month."
        return False, error
    elif date[2] < "0001" or date[2] > "9999":
        error = "Error: years out of range."
        return False, error
    elif "0" < time[0] > "23":
        error = "Error: there are only 24 hours in a day - " \
                "hours must be between 0 to 23."
        return False, error
    elif "0" < time[1] > "59":
        error = "Error: there are only 60 minutes per hour - " \
                "minutes must be 0 to 59."
        return False, error
    elif "0" < time[2] > "59":
        error = "Error: there are only 60 seconds per minute - " \
                "seconds must be 0 to 59."
        return False, error
    else:
        error = ""
        return True, error


if __name__ == '__main__':
    # gets user input, asking for the following format
    print("Please enter a date and time in the following format: "
          "\"MM/DD/YYYY HR:MIN:SEC\"")
    user_time = input("Don't forget the space between the date and time!\n")

    # calls the validation function
    valid = is_validate_datetime(user_time)

    # splits the input by the space in the middle into a list
    date_time = user_time.split(" ")

    # splits the date and time into two separate lists, divided by : and /
    date = date_time[0].split("/")
    time = date_time[1].split(":")

    # if the input is valid, prints the various formatted time and date
    if valid[0] is True:
        print("MM/DD/YYYY is {}/{}/{}".format(date[0], date[1], date[2]))
        print("HR:MIN:SEC is {}:{}:{}".format(time[0], time[1], time[2]))
        print("MM/YYYY is {}/{}".format(date[1], date[2]))

        # checks for AM/PM
        if time[0] >= "12":
            print("The time is PM.")
        elif time[0] < "12":
            print("The time is AM.")

    # if the input is not valid, prints the error message
    elif valid[0] is False:
        print(valid[1])

"""
Test cases:
Please enter a date and time in the following format: "MM/DD/YYYY HR:MIN:SEC"
Don't forget the space between the date and time!
05/23/2021 15:54:13
MM/DD/YYYY is 05/23/2021
HR:MIN:SEC is 15:54:13
MM/YYYY is 23/2021
The time is PM.

Process finished with exit code 0

Please enter a date and time in the following format: "MM/DD/YYYY HR:MIN:SEC"
Don't forget the space between the date and time!
05/32/2021 15:54:13
Error: days cannot exceed 31 per month.

Process finished with exit code 0

Please enter a date and time in the following format: "MM/DD/YYYY HR:MIN:SEC"
Don't forget the space between the date and time!
05/23/2021 28:54:13
Error: there are only 24 hours in a day - hours must be between 0 to 23.

Process finished with exit code 0

Please enter a date and time in the following format: "MM/DD/YYYY HR:MIN:SEC"
Don't forget the space between the date and time!
05/23/2021 15:54:1f
Invalid numbers input. Please re-run program. Exiting.

Process finished with exit code 0
"""