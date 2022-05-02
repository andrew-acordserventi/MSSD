<?php

// php code to edit an order

// Get the change form data from post form
$UPC = filter_input(INPUT_POST, 'UPC_Field');
$quantity = filter_input(INPUT_POST, 'quantity_Field');
$orderPrice = filter_input(INPUT_POST, 'price_Field');
$orderNumber = filter_input(INPUT_POST, 'orderNumber');

require_once('database.php');

// if a new UPC was entered, update it
if ($UPC != null) {
    $queryUpdate = "UPDATE customer_orders 
                    SET UPC=$UPC
                    WHERE orderNumber=$orderNumber";
    $statement2 = $db->prepare($queryUpdate);
    $statement2->execute();
    $statement2->closeCursor();
}
// if a new quantity was entered, update it
if ($quantity != null) {
    $queryUpdate = "UPDATE customer_orders 
                    SET quantity=$quantity 
                    WHERE orderNumber=$orderNumber";
    $statement2 = $db->prepare($queryUpdate);
    $statement2->execute();
    $statement2->closeCursor();
}
// if a new price was entered, update it
if ($orderPrice != null) {
    $queryUpdate = "UPDATE customer_orders 
                    SET orderPrice=$orderPrice 
                    WHERE orderNumber=$orderNumber";
    $statement2 = $db->prepare($queryUpdate);
    $statement2->execute();
    $statement2->closeCursor();
}
// if nothing was entered, display the error page
if ($UPC == null && $quantity == null && $orderPrice == null) {
    $error = "No updates were made since no changes were submitted.";
    include('error.php');
}

// redirect to home
header('Location: admin_home.php');

?>