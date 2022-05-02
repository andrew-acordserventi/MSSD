<?php

// admin_orders; contains html to display all orders to an admin

require_once('database.php');

// Get all orders
$queryOrders = 'SELECT customer_orders.*, sellable_products.productName
                FROM  customer_orders
                INNER JOIN sellable_products ON customer_orders.UPC= sellable_products.UPC
                ORDER BY orderNumber';
$statementOrders = $db -> prepare($queryOrders);
$statementOrders->execute();
$orders = $statementOrders->fetchAll();
$statementOrders->closeCursor();

// Get all products
$queryProducts = 'SELECT * FROM sellable_products ORDER BY UPC';
$statementProducts = $db -> prepare($queryProducts);
$statementProducts->execute();
$products = $statementProducts->fetchAll();
$statementProducts->closeCursor();

?>

<!DOCTYPE html>
<html>

<!-- the head section -->
<head>
    <title>Phil's Pills</title>
    <link rel="stylesheet" type="text/css" href="main.css" />
</head>

<!-- the body section -->
<body>
<header><h1>Phil's Pills</h1></header>
<main>
    <center><h1>My Orders</h1></center>

    <section>
        <!-- display a table of Orders -->
        <table>
            <tr>
                <th>Order Number</th>
                <th>UPC</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Date</th>
                <th>Edit</th>
            </tr>
            <?php foreach ($orders as $order) : ?>
            <tr>
                <td><?php echo $order['orderNumber']; ?></td>
                <td><?php echo $order['UPC']; ?></td>
                <td><?php echo $order['productName']; ?></td>
                <td><?php echo $order['quantity']; ?></td>
                <td>$<?php echo $order['orderPrice']; ?></td>
                <td><?php echo $order['dateOrdered']; ?></td>
                <td><form action="edit_order_form.php" method="POST">
                    <input type="submit" value="Edit Order!">
                    <input type="hidden" name="order_Field"
                            value="<?php echo $order['orderNumber'];?>"></td> 
                </form>
            </tr>
            <?php endforeach; ?>
        </table>
        <p><a href="admin_home.php">Admin Home</a></p>    
    </section>
</main>

<footer>
    <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
</footer>
</body>
</html>