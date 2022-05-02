<?php
    require_once('database.php');

// Get the course form data
$courseID = filter_input(INPUT_POST, 'course_id');
$courseName = filter_input(INPUT_POST, 'course_name');

// Validate inputs
if ($courseID == null || $courseID == false ||
        $courseName == null) {
    $error = "Invalid data. Check all fields and try again.";
    include('error.php');
} else {
    require_once('database.php');

    // Add the product to the database  
    $query = 'INSERT INTO sk_courses
                 (courseID, courseName)
              VALUES
                 (:courseID, :courseName)';
    $statement = $db->prepare($query);
    $statement->bindValue(':courseID', $courseID);
    $statement->bindValue(':courseName', $courseName);
    $statement->execute();
    $statement->closeCursor();
   
    // Display the Course List page
    include('course_list.php');
}
?>