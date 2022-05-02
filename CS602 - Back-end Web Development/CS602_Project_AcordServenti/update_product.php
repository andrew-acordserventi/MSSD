<?php

// php code to update a product;
// note UPC is not updateable, since it is a primary key in database
// if UPC needs to be updated, entry should be deleted and re-added to database

// Get the change form data
$productUPC = filter_input(INPUT_POST, 'productUPC');
$quantity = filter_input(INPUT_POST, 'quantity_Field');
$price = filter_input(INPUT_POST, 'price_Field');
$productName = filter_input(INPUT_POST, 'name_Field');
$description = filter_input(INPUT_POST, 'description_Field');
$size = filter_input(INPUT_POST, 'size_Field');

require_once('database.php');
            
// if quantity is available, update it
if ($quantity != null) {
    $queryUpdate1 = "UPDATE sellable_products
                    SET stockQuantity='$quantity'
                    WHERE UPC='$productUPC'";
    $statement1 = $db->prepare($queryUpdate1);
    $statement1->execute();
    $statement1->closeCursor();
}

// if price is available, update it
if ($price != null) {
    $queryUpdate2 = "UPDATE sellable_products 
                    SET price='$price' 
                    WHERE UPC='$productUPC'";
    $statement2 = $db->prepare($queryUpdate2);
    $statement2->execute();
    $statement2->closeCursor();
}

// if productName is available, update it
if ($productName != null) {
    $queryUpdate3 = "UPDATE sellable_products 
                    SET productName='$productName' 
                    WHERE UPC='$productUPC'";
    $statement3 = $db->prepare($queryUpdate3);
    $statement3->execute();
    $statement3->closeCursor();
}

// if description is available, update it
if ($description != null) {
    $queryUpdate4 = "UPDATE sellable_products 
                    SET productDescription='$description' 
                    WHERE UPC='$productUPC'";
    $statement4 = $db->prepare($queryUpdate4);
    $statement4->execute();
    $statement4->closeCursor();
}

// if size is available, update it
if ($size != null) {
    $queryUpdate5 = "UPDATE sellable_products 
                    SET size='$size' 
                    WHERE UPC='$productUPC'";
    $statement5 = $db->prepare($queryUpdate5);
    $statement5->execute();
    $statement5->closeCursor();
}

// if UPC is available, update it
// needs to be last since others check UPC

// redirects to home once update is made
header('Location: admin_home.php');

?>