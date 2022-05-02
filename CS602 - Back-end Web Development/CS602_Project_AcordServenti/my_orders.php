<?php

// displays orders to customers in HTML

require_once('database.php');

// Get all orders; joins by UPC to display product name
$queryOrders = 'SELECT customer_orders.*, sellable_products.productName
                FROM  customer_orders
                INNER JOIN sellable_products ON customer_orders.UPC= sellable_products.UPC
                ORDER BY orderNumber';
$statementOrders = $db -> prepare($queryOrders);
$statementOrders->execute();
$orders = $statementOrders->fetchAll();
$statementOrders->closeCursor();

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
            </tr>
            <?php foreach ($orders as $order) : ?>
            <tr>
                <td><?php echo $order['orderNumber']; ?></td>
                <td><?php echo $order['UPC']; ?></td>
                <td><?php echo $order['productName']; ?></td>
                <td><?php echo $order['quantity']; ?></td>
                <td>$<?php echo $order['orderPrice']; ?></td>
                <td><?php echo $order['dateOrdered']; ?></td>
            </tr>
            <?php endforeach; ?>
        </table>
        <p><a href="index.php">Home</a></p>    
    </section>
</main>

<footer>
    <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
</footer>
</body>
</html>