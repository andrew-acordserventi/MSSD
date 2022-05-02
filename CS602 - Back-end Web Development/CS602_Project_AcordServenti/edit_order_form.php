<?php

// html data to display an order and form to modify selected order

// requires an order to be posted
$orderNumber = filter_input(INPUT_POST, 'order_Field');

require_once('database.php');

// gets order; joins the table to display the right product based on UPC
$getOrder = 'SELECT customer_orders.*, sellable_products.productName
            FROM  customer_orders
            INNER JOIN sellable_products ON customer_orders.UPC= sellable_products.UPC
            WHERE orderNumber='.$orderNumber;
$statement = $db -> prepare($getOrder);
$statement->execute();
$order = $statement->fetch();
$statement->closeCursor();

?>
<!DOCTYPE html>
<html>

<!-- the head section -->
<head>
    <title>Phil's Pills</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<!-- the body section -->
<body>
    <header><h1>Phil's Pills</h1></header>

    <main>
        <h1>Edit Order</h1>
        <form action="edit_order.php" method="post"
              id="editOrder">

            <input type="hidden" value="<?php echo $order['orderNumber']?>" name="orderNumber">

            <label>Order Number: <?php echo $order['orderNumber']?></label><br>
            
            <label>UPC: <?php echo $order['UPC']?></label>
            <input type="text" name="UPC_Field"><br>

            <label>Product Name: <?php echo $order['productName']?></label>
            <br>

            <label>Quantity: <?php echo $order['quantity']?></label>
            <input type="number" name="quantity_Field"><br>

            <label>Order Price: <?php echo $order['orderPrice']?></label>
            <input type="number" name="price_Field"><br>

            <label>&nbsp;</label>
            <input type="submit" value="Submit Changes"><br>
        </form>
        <form action="delete_order.php" method="post">
            <label>&nbsp;</label>
            <input type="submit" value="Delete Order" action="delete_order.php" method="post"><br>
            <input type="hidden" name="orderNumber" value="<?php echo $orderNumber?>">
        </form>
        <p><a href="admin_home.php">Admin Home</a></p>
    </main>
    <footer>
        <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
    </footer>
</body>
</html>