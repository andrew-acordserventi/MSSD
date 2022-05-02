<?php
// had to use local ip address to get to work - localhost would not connect
    $dsn = 'mysql:host=127.0.0.1:3307;dbname=cs602db';
    $username = 'cs602_user';
    $password = 'password';

    try {
        $db = new PDO($dsn, $username, $password);
    } catch (PDOException $e) {
        $error_message = $e->getMessage();
        include('database_error.php');
        exit();
    }
?>

