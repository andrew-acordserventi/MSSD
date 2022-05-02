<?php

// php to check admin login table and goto admin_home or error

$admin_username = filter_input(INPUT_POST, 'username_Field');
$admin_password = filter_input(INPUT_POST, 'password_Field');

require_once('database.php');

// Get all admin usernames and passwords that match input
$queryLogin = "SELECT * FROM admin_login 
               WHERE username='$admin_username' 
               AND admin_pass='$admin_password'";
$statement = $db -> prepare($queryLogin);
$statement->execute();
$login = $statement->fetchAll();
$statement->closeCursor();

// no username/password combo found, error
if($login == null) {
    $error = "Incorrect username/password. Please try again.";
    include('error.php');
    
}
// else, proceed to admin_home
else {
    header('Location:admin_home.php');
}

?>
