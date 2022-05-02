<?php
require_once('database.php');

// Delete the student from the database

// Get IDs
$studentID = filter_input(INPUT_POST, 'student_id');
$courseID = filter_input(INPUT_POST, 'course_id');

// Delete the student from the database
if ($courseID != false && $studentID != false) {
    $query = 'DELETE FROM sk_students
              WHERE studentID = :studentID';
    $statement = $db->prepare($query);
    $statement->bindValue(':studentID', $studentID);
    $success = $statement->execute();
    $statement->closeCursor();    
}

// Display the Home page
header('Location: index.php?course_id='.$courseID);
