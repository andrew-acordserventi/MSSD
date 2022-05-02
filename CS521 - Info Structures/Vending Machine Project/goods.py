"""
DONE name
DONE price
DONE quantity in stock
NOY IMP # sold
NOT IMP expiration date
DONE vend slot (eg, A1, A2, etc.)
"""


class Goods:
    """Food/drink or other item to be sold in the vending machine."""

    # keeps track of all instances of goods created
    instances = []

    # slot shouldn't change once it's set (beyond default), so it is private
    def __init__(self, name='default', price=5.00, stock=0, __slot='AA'):
        self.name = name
        self.price = price
        self.stock = stock
        self.__slot = __slot
        # keeps track of all instances of goods created
        Goods.instances.append(name)

    def __repr__(self):
        return "{name} that costs ${price}. There are {stock} left and it " \
               "is found in slot {slot}.".format(name=self.name,
                                                 price=self.price,
                                                 stock=self.stock,
                                                 slot=self.__slot)

    def __add__(self, other):
        """Adds stock of the good."""
        try:
            int(other)
        except:
            return print("Must type an integer to restock.")
        return self.stock + other

    def __sub__(self, other):
        """Subtracts stock of the good."""
        try:
            int(other)
        except:
            return print("Can only reduce stock with an integer.")
        return self.stock - other

    def get_slot(self):
        """Returns the slot of the good."""
        return self.__slot

    def get_name(self):
        """Returns the name of the good."""
        return self.name

    def get_price(self):
        """Returns the price of the good."""
        return self.price

    def get_stock(self):
        """Returns the stock of the good."""
        return self.stock


if __name__ == "__main__":
    # creating a new goods class to unit test in assertion
    a1 = Goods('Snickers', 1.29, 10, 'A1')

    print("Running assertion tests...")

    # assert tests
    assert a1.get_stock() > 0, print("Stock should always be > 0.")
    assert (a1 - 1) == 9, print("Stock should subtract.")
    assert a1.get_price() == 1.29, print("Get_price should return price...")
    assert a1.get_name() == 'Snickers', print("get_name should return name...")
    assert a1.get_slot() == 'A1', print("Get_slot should return slot...")
    assert (a1 + 1) == 11, print("Adding should equal 11...")

    print("Assertion tests complete and passed!")
