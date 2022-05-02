<?php

// php code to modify database
// allows customer to buy product, creates new order, and subtracts quantity
// ideally this would add to cart before order is created (requires cookies)

// Get the product form data
$productUPC = filter_input(INPUT_POST, 'product_UPC');
$quantityAdded = filter_input(INPUT_POST, 'order_quantity');

// gets product from database
require_once('database.php');

$getProduct = 'SELECT * FROM sellable_products WHERE UPC='.$productUPC;
$statement = $db -> prepare($getProduct);
$statement->execute();
$product = $statement->fetch();
$statement->closeCursor();

// customer has bought the product, need to check to ensure no back order,
// then decrement stock, then create order
// reroute to index

// Validate inputs
if ($quantityAdded > $product['stockQuantity']) {
    $error = "Order quantity cannot exceed in stock quantity.";
    include('error.php');
} 
// Validate inputs
else if ($quantityAdded <= 0 || $quantityAdded == null) {
    $error = "Must submit a quantity!";
    include('error.php');
} 
// creates a new order
else {
    require_once('database.php');

    $orderPrice = (int)$quantityAdded * (float)$product['price'];
    // from https://stackoverflow.com/questions/9541029/insert-current-date-in-datetime-format-mysql
    $dateOrdered = date('Y-m-d H:i:s');
    $newStock = (int)$product['stockQuantity'] - (int)$quantityAdded;
    $newStock = (int)$newStock;

    // Add the order to the database  
    $query = 'INSERT INTO customer_orders
                 (UPC, quantity, orderPrice, dateOrdered)
              VALUES
                 (:UPC, :quantityAdded, :orderPrice, :dateOrdered)';
    $statement = $db->prepare($query);
    $statement->bindValue(':UPC', $productUPC);
    $statement->bindValue(':quantityAdded', $quantityAdded);
    $statement->bindValue(':orderPrice', $orderPrice);
    $statement->bindValue(':dateOrdered', $dateOrdered);
    $statement->execute();
    $statement->closeCursor();

    // updates the stock on hand
    $queryUpdate = "UPDATE sellable_products 
                    SET stockQuantity=$newStock 
                    WHERE UPC=$productUPC";
    $statement2 = $db->prepare($queryUpdate);
    $statement2->execute();
    $statement2->closeCursor();

    // Display the Product List page
    header('Location: index.php');
}

?>