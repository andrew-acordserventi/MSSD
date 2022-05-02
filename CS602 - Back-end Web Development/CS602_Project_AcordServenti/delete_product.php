<?php

// php code to delete a selected product

$productUPC = filter_input(INPUT_POST, 'UPC');

require_once('database.php');

$deleteProduct = 'DELETE FROM sellable_products WHERE UPC='.$productUPC;
$statement = $db -> prepare($deleteProduct);
$statement->execute();
$statement->closeCursor();

// routes back to admin_home
header('Location: admin_home.php');

?>