<?php

// Get the change form data from the form
$UPC = filter_input(INPUT_POST, 'UPC_Field');
$productName = filter_input(INPUT_POST, 'name_Field');
$productDescription = filter_input(INPUT_POST, 'description_Field');
$size = filter_input(INPUT_POST, 'size_Field');
$stockQuantity = filter_input(INPUT_POST, 'quantity_Field');
$price = filter_input(INPUT_POST, 'price_Field');

require_once('database.php');

// check for duplicate UPC in the database
$checkDuplicate = 'SELECT * FROM sellable_products WHERE UPC='.$UPC;
$statement = $db -> prepare($checkDuplicate);
$statement->execute();
$duplicate = $statement->fetch();
$statement->closeCursor();
            
// all fields must be filled out or new product won't be created
if ($UPC == null || $productName == null ||
    $productDescription == null || $size == null ||
    $stockQuantity == null || $price == null) {
        $error = "No updates were made. All fields must be submitted. Please try again.";
        include('error.php');
}
// if a duplicate UPC in DB is found, show error and don't crash
else if ($duplicate != null) {
    $error = "No updates were made. UPC must be unique. Please try again.";
    include('error.php');
}
// else creat a new product
else {
    require_once('database.php');

    // Add the product to the database  
    $query = 'INSERT INTO sellable_products
                 (UPC, productName, productDescription, size, stockQuantity, price)
              VALUES
                (:UPC, :productName, :productDescription, :size, :stockQuantity, :price)';
    $statement = $db->prepare($query);
    $statement->bindValue(':UPC', $UPC);
    $statement->bindValue(':productName', $productName);
    $statement->bindValue(':productDescription', $productDescription);
    $statement->bindValue(':size', $size);
    $statement->bindValue(':stockQuantity', $stockQuantity);
    $statement->bindValue(':price', $price);
    $statement->execute();
    $statement->closeCursor();

    // redirect to admin_home once product is created
    header('Location: admin_home.php');
}
?>