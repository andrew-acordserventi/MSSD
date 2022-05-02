"""
DONE - display ASCII art
DONE - display selections (item, price, code)
DONE - validate user input
DONE - confirm selection
DONE - keep track of money inserted
DONE - vend product
write to file for shutdown
"""
import time as time


# DONE
def vend_options(slot1, slot2, slot3):
    """Displays the items, prices, and vend slot code to customers."""
    print("Welcome to the Vendo-O-Tron 9000. Options are below: ")
    print()
    print(slot1)
    print(slot2)
    print(slot3)
    return print()

# DONE
def valid(user_input):
    """Checks passed input to ensure input is valid."""

    # tuple of the slots available in the machine, plus other commands
    slots = ('A1', 'A2', 'A3', 'EN', 'SD')

    # checks to see if the user's input is a valid slot or command
    if user_input not in slots:
        print("Invalid input. Please try again.")
        time.sleep(3)
        return False
    else:
        return True

# DONE
def get_money(price, name):
    """Allows the user to input money or cancel order. Gives change. Calls
    function to vend product if product is purchased."""
    # TODO this would be replaced by a money slot in an actual vending
    #  machine and this code would basically interface with that slot
    # creates a total variable of the price as a float for use
    # total is money owed
    total = float(price)

    # loops while the total is greater than 0 (money owed)
    while total > 0:

        # asks the user to input money
        user_money = input("Please insert " + str(round(total, 2)) +
                           " for a " + name + " or type 'a' to cancel "
                                              "and go back...\n")

        # checks to see if they cancel their order, if canceled, returns a pause
        if user_money == 'a':
            print("Canceling...")
            time.sleep(3)
            return False

        # validation to check input as a number, repeats loop if not a number
        try:
            user_money = float(user_money)
        except:
            print("Not a valid amount. Please try again.")
            continue

        # checks for large amounts, repeats loop if amount is too large
        if user_money >= 5:
            print("Vending machine does not have enough change. "
                  "Please use bills lower than $5.")
            continue

        # updates the total owed by the amount the user inputs
        total = total - user_money

        # gives the user change if excess is put in
        if total < 0:
            change = round((total*(-1)), 2)
            print("Please take your change:", change)

    # if the loop completes and user pays, vends the good
    vend_good(name)
    print("Thank you!")

    # pauses vending machine to vend
    time.sleep(5)

    # returns True, so stock can update
    return True

# DONE
def vend_good(name):
    """Vends the item to the customer."""
    # TODO this would be replaced by a function to physically vend
    #  the good to a customer
    return print("The vending machine drops your", name, "below...")

# DONE
def read_stock():
    """Gets the current stock from a file. The file MUST be structured of one
    entry per line, in this order: Name, price, stock, and slot. File must
    include a blank line at the end."""

    # opens the file
    current_database = open('CURR_GOODS.txt', "rt")

    # gets the first line for the loop
    line_read = current_database.readline().rstrip()

    object_list = []

    # reads through the file, for loop, range is set to # of slots
    for i in range(3):
        name = line_read
        line_read = current_database.readline().rstrip()
        price = line_read
        line_read = current_database.readline().rstrip()
        stock = line_read
        line_read = current_database.readline().rstrip()
        slot = line_read

        # creates a list to return of each good
        x = [name, price, stock, slot]
        object_list.append(x)

        # checks the next line (or blank line exits loop)
        line_read = current_database.readline().rstrip()

    # closes the database
    current_database.close()

    return object_list

#TODO
def write_stock(slot1, slot2, slot3):
    """On shutdown, writes the current state of the goods objects to a
    .txt file. Important for stock purposes."""

    current_database = open('CURR_GOODS.txt', "wt")

    # loops 3 times (3 slots)
    print(slot1.get_name, file=current_database)
    print(slot1.get_stock, file=current_database)
    print(slot1.get_price, file=current_database)
    print(slot1.get_slot, file=current_database)

    current_database.close()



# DONE
def vend_art():
    """Bad ASCII art of a vending machine."""

    a = """\
     _____________________   
　　　|　v　|┌─────────────┐|
　　　|　E　|│![] [] [] [] │|
　　　|　N　|::l三三三三三!. │|
　　　|　D　|│![] [] [] [] │|
　　　|　I　|::l三三三三三!. │|
　　　|　N　|┌───────────┐ │|
　　　|　G　|│＿＿＿＿＿＿＿│ │| 
　　　{二二}￣￣￣￣￣￣￣￣{二二}  
    """

    return print(a)
