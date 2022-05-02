<?php

// HTML to display and update a specific product

// must recieve a posted product
$productUPC = filter_input(INPUT_POST, 'product_UPC');

require_once('database.php');

// access database to get the product for display
$getProduct = 'SELECT * FROM sellable_products WHERE UPC='.$productUPC;
$statement = $db -> prepare($getProduct);
$statement->execute();
$product = $statement->fetch();
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
        <h1>Edit Product</h1>
        <form action="update_product.php" method="post"
              id="editProduct">
            <input type="hidden" name="productUPC" value="<?php echo $productUPC?>">
            
            <label>UPC: <?php echo $product['UPC']?></label></br>

            <label>Product Name: <?php echo $product['productName']?></label>
            <input type="text" name="name_Field"><br>

            <label>Product Description: <?php echo $product['productDescription']?></label>
            <input type="text" name="description_Field"><br>

            <label>Product Size: <?php echo $product['size']?></label>
            <input type="text" name="size_Field"><br>

            <label>Quantity: <?php echo $product['stockQuantity']?></label>
            <input type="number" name="quantity_Field"><br>

            <label>Product Price: <?php echo $product['price']?></label>
            <input type="number" step="0.01" name="price_Field"><br>

            <label>&nbsp;</label>
            <input type="submit" value="Submit Changes"><br>
        </form>
        <form action="delete_product.php" method="post">
            <label>&nbsp;</label>
            <input type="submit" value="Delete Product" action="delete_product.php" method="post"><br>
            <input type="hidden" name="UPC" value="<?php echo $productUPC?>">
        </form>
        <p><a href="admin_home.php">Admin Home</a></p>
    </main>
    <footer>
        <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
    </footer>
</body>
</html>