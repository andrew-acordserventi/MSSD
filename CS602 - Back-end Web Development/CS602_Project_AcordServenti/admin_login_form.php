<?php

// html to allow login to admin portion of website

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
        <h1>Admin Login</h1>
        <form action="admin_login.php" method="post"
              id="adminLogin">
            <table class="center">
              <tr>
                  <td><label>Username: </label></td>
                  <td><input type="text" name="username_Field"></td>
              </tr>
              <tr>  
                   <td><label>Password: </label></td>
                   <td><input type="password" name="password_Field"></td>
            </tr>

            </table>

            <label>&nbsp;</label>
            <input class="login" type="submit" value="Login"><br>
        </form>
        <p><a href="index.php">Home</a></p>
    </main>
    <footer>
        <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
    </footer>
</body>
</html>