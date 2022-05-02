<?php
// Get the student form data
$courseID = filter_input(INPUT_POST, 'course_id');
$firstName = filter_input(INPUT_POST, 'first_name');
$lastName = filter_input(INPUT_POST, 'last_name');
$email = filter_input(INPUT_POST, 'email');

// Validate inputs
if ($courseID == null || $courseID == false ||
        $firstName == null || $lastName == null || $email == null) {
    $error = "Invalid student data. Check all fields and try again.";
    include('error.php');
} else {
    require_once('database.php');

    // Add the product to the database  
    $query = 'INSERT INTO sk_students
                 (courseID, firstName, lastName, email)
              VALUES
                 (:courseID, :firstName, :lastName, :email)';
    $statement = $db->prepare($query);
    $statement->bindValue(':courseID', $courseID);
    $statement->bindValue(':firstName', $firstName);
    $statement->bindValue(':lastName', $lastName);
    $statement->bindValue(':email', $email);
    $statement->execute();
    $statement->closeCursor();

    // Display the Product List page
    header('Location: index.php?course_id='.$courseID);
}
?>