<?php
/**
 * Rest Methods; can return JSON of all products, products of a specific name, or products of a price range
 * Syntax:
 * Get all products: 
 * rest.php?format=json&action=products
 * Get a named product: 
 * rest.php?format=json&action=namedProducts&productName=ProductNameGoesHere
 * Get all products in price range: 
 * rest.php?format=json&action=priceRange&minPrice=somenumber&maxPrice=somenumber
 * 
 * Example URLs:
 * Get all products
 * http://127.0.0.1/project/rest.php?format=json&action=products
 * 
 * Get a named product (lisinopril)
 * http://127.0.0.1/project/rest.php?format=json&action=namedProduct&productName=Lisinopril
 * 
 * Get all products within a price range (6 cents to 15 cents)
 * http://127.0.0.1/project/rest.php?format=json&action=priceRange&minPrice=0.06&maxPrice=0.15
 */

// returns an JSON of all products
function getAllProducts(){
    require_once('database.php');
    $queryProducts = 'SELECT * FROM sellable_products ORDER BY productName';
    $statementProducts = $db -> prepare($queryProducts);
    $statementProducts->execute();
    // fetch_assoc from TA - thanks John!
    $products = $statementProducts->fetchAll(PDO::FETCH_ASSOC);
    $statementProducts->closeCursor();
    return $products;
}

// takes a product ID; returns array of products that have that product ID
function getProductsByName($product_name){
    require_once('database.php');
    $queryProducts = "SELECT * FROM sellable_products WHERE productName='$product_name' ORDER BY productName";
    $statementProducts = $db -> prepare($queryProducts);
    $statementProducts->execute();
    // fetch_assoc from TA - thanks John!
    $productsByName = $statementProducts->fetchAll(PDO::FETCH_ASSOC);
    $statementProducts->closeCursor();
    return $productsByName;
}

// returns products between a price point
function getProductsByPrice($min, $max){
    require_once('database.php');
    $queryMinMax = "price>'$min' AND price<'$max'";
    $queryProducts = "SELECT * FROM sellable_products WHERE $queryMinMax ORDER BY productName";
    $statementProducts = $db -> prepare($queryProducts);
    $statementProducts->execute();
    // fetch_assoc from TA - thanks John!
    $productsByName = $statementProducts->fetchAll(PDO::FETCH_ASSOC);
    $statementProducts->closeCursor();
    return $productsByName;
}

// json format of all products
if($_GET['format'] == 'json' && $_GET['action'] == 'products') {
    // sets the html header to text/plain for readability purposes
    header('Content-Type: JSON');

    // print method from https://stackoverflow.com/questions/6054033/pretty-printing-json-with-php
    echo json_encode(getAllProducts(), JSON_PRETTY_PRINT);
}

// json format of all products with a certain name
else if ($_GET['format'] == 'json' && $_GET['action'] == 'namedProduct'){
    // sets the html header to text/plain for readability purposes
    header('Content-Type: JSON');

    $productName=$_GET['productName'];
    // print method from https://stackoverflow.com/questions/6054033/pretty-printing-json-with-php
    echo json_encode(getProductsByName($productName),JSON_PRETTY_PRINT);
}

// json format of all products in a price range
else if ($_GET['format'] == 'json' && $_GET['action'] == 'priceRange'){
    // sets the html header to text/plain for readability purposes
    header('Content-Type: JSON');

    $productMinPrice=$_GET['minPrice'];
    $productMaxPrice=$_GET['maxPrice'];
    // print method from https://stackoverflow.com/questions/6054033/pretty-printing-json-with-php
    echo json_encode(getProductsByPrice($productMinPrice, $productMaxPrice),JSON_PRETTY_PRINT);
}
// if the url sent was incorrect, return text saying incorrect url
else {
    echo "Incorrect URL.";
    return "Incorrect URL.";
}
?>