package edu.bu.met.cs665;
import edu.bu.met.cs665.drink.coffee.*;
import edu.bu.met.cs665.drink.tea.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoffeeMachine {
    /** This is a JUnit  Test  example.
        * You  should  write  such  JUnit  Test  for  your  code  base.
        * You  should  write  sequences  of user  interactions  with  the
        * system  in  JUnit  Tests.
        * Your  variable  and  class  names  might  be  totally  different  than
        * in this  example.*/

    @Test
    public void testCondimentNumber() {
        //  Create a drink
        Coffee myDrink = new Macchiato();

        // add 3 unit  Milk
        myDrink.addMilk();
        myDrink.addMilk();
        myDrink.addMilk();
        myDrink.addMilk();
        myDrink.addMilk();

        // add 1 unit  sugar
        myDrink.addSugar();

        // Now , we  check  the  total  number  of  condiments  in this  drink.
        // We  added 5 milk  but  only 3 should  be  accepted  and  added
        // And  one  sugar  so the  total  is 4 and  not 5 condiment units.
        assertEquals(myDrink.getCondimentNumber(), 4);

        // price should be 4.05; delta is needed since double is deprecated
        assertEquals(myDrink.getPrice(), 4.05, 0.01d);
    }

    @Test
    public void testPrice() {
        // create new drink, price 2.5
        Tea myDrink = new YellowTea();

        // add 2 units of milk, price 3
        myDrink.addMilk();
        myDrink.addMilk();

        // add 1 unit of sugar, price 3.3
        myDrink.addSugar();

        // price should be 3.3; delta is needed since double is deprecated
        assertEquals(myDrink.getPrice(), 3.3, 0.01d);
    }
}
