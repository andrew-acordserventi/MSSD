"""
Main function
    |goods class
    |core functions
    |enhanced functions
"""
import goods as goods
import core_functions as core
import enhanced_functions as enhanced

import time as time


if __name__ == '__main__':

    # reads from the file to get starting stock
    object_list = core.read_stock()

    # making objects global (easier to use in enhanced functions menu)
    global a1
    global a2
    global a3

    # creates goods for each item, based on vending slots and the file
    a1 = goods.Goods(object_list[0][0], float(object_list[0][1]),
                     int(object_list[0][2]), object_list[0][3])
    a2 = goods.Goods(object_list[1][0], float(object_list[1][1]),
                     int(object_list[1][2]), object_list[1][3])
    a3 = goods.Goods(object_list[2][0], float(object_list[2][1]),
                     int(object_list[2][2]), object_list[2][3])

    # allows the selection to loop
    while True:

        # displays the vending machine
        core.vend_art()

        # displays the vending machine's options
        core.vend_options(a1, a2, a3)

        # gets the user selection and sets to uppercase for comparison
        selection = input("Please select an item, A1, A2, or A3: \n")
        selection = selection.upper()

        # validity check the selection
        if core.valid(selection) is False:
            continue

        # sets the result to false for the if statement below
        result = False

        # checks user selection and stock of item
        if selection == a1.get_slot() and int(a1.get_stock()) > 0:

            # calls the get money function to get the user's money
            result = core.get_money(a1.get_price(), a1.get_name())

            # if an item vended, subtract 1 from the item's stock
            if result == True:
                a1.stock = int(a1.stock) - 1
            continue

        # if stock is out, do not allow to vend
        elif int(a1.get_stock()) <= 0:
            print("Out of stock. Please select something else...")
            time.sleep(5)
            continue

        if selection == a2.get_slot() and int(a2.get_stock()) > 0:

            # calls the get money function to get the user's money
            result = core.get_money(a2.get_price(), a2.get_name())

            # if an item vended, subtract 1 from the item's stock
            if result == True:
                a2.stock = int(a2.stock) - 1
            continue

        elif int(a2.get_stock()) <= 0:
            print("Out of stock. Please select something else...")
            time.sleep(5)
            continue

        if selection == a3.get_slot() and int(a3.get_stock()) > 0:

            # calls the get money function to get the user's money
            result = core.get_money(a3.get_price(), a3.get_name())

            # if an item vended, subtract 1 from the item's stock
            if result == True:
                a3.stock = int(a3.stock) - 1
            continue

        elif int(a3.get_stock()) <= 0:
            print("Out of stock. Please select something else...")
            time.sleep(5)
            continue

        # allows a maintainer access to an enhanced function menu
        if selection == 'EN':

            # password for added security
            # TODO code obfuscation here somehow would be useful...
            password_input = input("Please enter password: \n")
            password = 'password123'

            if password == password_input:
                enhanced.menu()
            else:
                print("Password is incorrect.")
                time.sleep(3)
                continue

        # stops the system (shutdown)
        if selection == 'SD':

            password_input = input("Please enter password: \n")
            password = 'password123'

            if password == password_input:
                print("Shutting down. Thank you for using Vend-O-Tron 9000!")
                break
            else:
                print("Password is incorrect.")
                time.sleep(3)
                continue
