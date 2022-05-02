<!DOCTYPE html>
<html>
<!-- generic error message used by other pages; requires an error message to be sent -->
<!-- the head section -->
<head>
    <title>Phil's Pills</title>
    <link rel="stylesheet" type="text/css" href="main.css" />
</head>

<!-- the body section -->
<body>
    <header><h1>Phil's Pills</h1></header>

    <main>
        <h2 class="top">Error</h2>
        <p>Error Message: <?php echo $error; ?></p>
        <a href="index.php">Home Page</a>
    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> Andrew Acord-Serventi</p>
    </footer>
</body>
</html>