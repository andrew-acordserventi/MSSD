<?php 

// buy product form; contains html to allow modifying a product

require_once('database.php');

// gets productUPC from post to modify selected product
$productUPC = filter_input(INPUT_POST, 'product_UPC');

// gets the product in question from the database to display current values
$getProduct = 'SELECT * FROM sellable_products WHERE UPC='.$productUPC;
$statement = $db -> prepare($getProduct);
$statement->execute();
$product = $statement->fetch();
$productUPC = $product['UPC'];
$statement->closeCursor();

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
    <center><h1>Buy Product - <?php echo $product['productName']?></h1></center>

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
                <th>Quantity</th>
            </tr>
            <tr>
                <td><?php echo $product['UPC']; ?></td>
                <td><?php echo $product['productName']; ?></td>
                <td><?php echo $product['productDescription']; ?></td>
                <td><?php echo $product['size']; ?></td>
                <td>$<?php echo $product['price']; ?></td>
                <td><?php echo $product['stockQuantity']; ?></td>
                <td>
                    <form action="buy_product.php" method="POST">
                    <input type="number" id="order_quantity" name="order_quantity">
                    <input type="hidden" name="product_UPC" 
                        value="<?php echo $product['UPC']; ?>">
                    <button>Submit Order!</button>
                </td>
            </tr>
        </table>
    </section>
</main>

<footer>
    <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
</footer>
</body>
</html>