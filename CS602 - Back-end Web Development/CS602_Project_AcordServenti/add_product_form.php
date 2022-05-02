<?php

// form to creat a new product

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
        <form action="add_product.php" method="post"
              id="addProduct">
            
            <label>UPC: </label>
            <input type="text" name="UPC_Field"><br>
            <p>Note: UPC cannot match any current product UPC. Must be unique.</p>

            <label>Product Name: </label>
            <input type="text" name="name_Field"><br>

            <label>Product Description: </label>
            <input type="text" name="description_Field"><br>

            <label>Product Size: </label>
            <input type="text" name="size_Field"><br>

            <label>Quantity: </label>
            <input type="number" name="quantity_Field"><br>

            <label>Product Price: </label>
            <input type="number" step="0.01" name="price_Field"><br>

            <label>&nbsp;</label>
            <input type="submit" value="Submit Changes"><br>
        </form>
        <p><a href="admin_home.php">Admin Home</a></p>
    </main>
    <footer>
        <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
    </footer>
</body>
</html>