<?php

// php code to delete a selected order

$orderNumber = filter_input(INPUT_POST, 'orderNumber');

require_once('database.php');

$deleteOrder = 'DELETE FROM customer_orders WHERE orderNumber='.$orderNumber;
$statement = $db -> prepare($deleteOrder);
$statement->execute();
$statement->closeCursor();

// routes back to admin_home
header('Location: admin_home.php');

?>