<?php

// homepage that displays products html to customer;

require_once('database.php');

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
    <link rel="stylesheet" type="text/css" href="main.css"/>
</head>

<!-- the body section -->
<body>
<header><h1>Phil's Pills</h1></header>
<main>
    <center><h1>Product List</h1></center>

    <section>
        <!-- display a table of products -->
        <table>
            <tr>
                <th>UPC</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Size</th>
                <th>Price</th>
                <th>Stock</th>
                <th>&nbsp;</th>
            </tr>
            <?php foreach ($products as $product) : ?>
            <tr>
                <td><?php echo $product['UPC']; ?></td>
                <td><?php echo $product['productName']; ?></td>
                <td><?php echo $product['productDescription']; ?></td>
                <td><?php echo $product['size']; ?></td>
                <td>$<?php echo $product['price']; ?></td>
                <td><?php echo $product['stockQuantity']; ?></td>
                <td><form action="buy_product_form.php" method="POST">
                    <input type="submit" value="Buy Now!">
                    <input type="hidden" name="product_UPC"
                            value="<?php echo $product['UPC'];?>">
                    </form>
                </td>
            </tr>
            <?php endforeach; ?>
        </table>
        <p><a href="my_orders.php">My Orders</a></p> 
        <p><a href="admin_login_form.php">Admin Login</a></p>       
    </section>
</main>

<footer>
    <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
</footer>
</body>
</html>