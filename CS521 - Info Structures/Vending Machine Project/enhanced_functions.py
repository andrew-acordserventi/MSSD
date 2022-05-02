"""
NOT IMPLEMENTED
read from a file to upload new goods
set stock of items (restock)
output file of goods sold
output file of money/withdraw
restart machine (easter egg?)
"""
import time as time
import goods as goods


def menu():
    """Allows additional owner/maintenance access to an enhanced menu, with
    special functions not publicly available to consumers."""

    # remove once implemented
    print("Not yet implemented...")
    return time.sleep(5)

    # gets the input
    maint_select = input("Please select an option:\n"
                         "1. Upload new goods.\n"
                         "2. Restock goods.\n"
                         "3. Output file of goods sold.\n"
                         "4. Output file of money in machine.\n"
                         "5. Reset stock of goods.\n"
                         "6. Manually remove a good from the vending machine.\n"
                         "7. Manually add a good from the vending machine. \n"
                         "8. Exit maintenance mode.\n")

    if maint_select == '1':
        pass

    elif maint_select == '2':
        pass

    elif maint_select == '3':
        pass

    elif maint_select == '4':
        pass

    elif maint_select == '5':
        pass

    elif maint_select == '6':
        pass

    elif maint_select == '7':
        pass

    elif maint_select == '8':
        return ""

    # non-option input - exits maintenance mode
    else:
        print("Invalid input. Exiting maintenance mode...")
        time.sleep(3)


def upload_new():
    """Resets inventory. Allows maintainer to upload a new file containing
    new inventory."""
    pass


def restock():
    """Restocks inventory. Does NOT change inventory slot position, only
    changes current stock of an item."""
    pass


def output_sold():
    """Outputs the sales of the vending machine for analysis purposes."""
    pass


def output_money():
    """Outputs a file of the current value in the vending machine. Allows
    maintainer to withdraw money from the machine."""
    pass


def reset_stock():
    """Sets all stock to 0. Then allows maintainer to manually update stock
    of each item, individually. Does not change inventory slot position."""
    pass


def remove_good():
    """Allows the maintainer to remove a good from the vending machine.
    Resets a slot to 0, with default good (none) in slot."""
    pass


def add_good():
    """Allows the maintainer to add a good to the vending machine. Asks for
    name, price, slot, and quantity being added."""
    pass

