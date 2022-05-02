<?php
// returns an array of all courses
function getAllCourses(){
    require_once('database.php');
    $queryCourses = 'SELECT * FROM sk_courses ORDER BY courseID';
    $statementCourses = $db -> prepare($queryCourses);
    $statementCourses->execute();
    // fetch_assoc from TA - thanks John!
    $courses = $statementCourses->fetchAll(PDO::FETCH_ASSOC);
    $statementCourses->closeCursor();
    return $courses;
}

// takes a course ID; returns array of students that have that course ID
function getStudentsByCourse($courseID){
    require_once('database.php');
    $queryStudents = "SELECT * FROM sk_students WHERE courseID='$courseID' ORDER BY studentID";
    $statementStudents = $db -> prepare($queryStudents);
    $statementStudents->execute();
    // fetch_assoc from TA - thanks John!
    $studentsByCourseID = $statementStudents->fetchAll(PDO::FETCH_ASSOC);
    $statementStudents->closeCursor();
    return $studentsByCourseID;
}

// json format of all courses
if($_GET['format'] == 'json' && $_GET['action'] == 'courses') {
    // sets the html header to text/plain for readability purposes
    header('Content-Type: text/plain');

    // print method from https://stackoverflow.com/questions/6054033/pretty-printing-json-with-php
    echo json_encode(getAllCourses(), JSON_PRETTY_PRINT);
}

// json format of all students in a particular course
else if ($_GET['format'] == 'json' && $_GET['action'] == 'students'){
    // sets the html header to text/plain for readability purposes
    header('Content-Type: text/plain');

    $courseid=$_GET['course'];
    // print method from https://stackoverflow.com/questions/6054033/pretty-printing-json-with-php
    echo json_encode(getStudentsByCourse($courseid),JSON_PRETTY_PRINT);
}

// xml format of all courses
else if ($_GET['format'] == 'xml' && $_GET['action'] == 'courses'){
    // sets the html header to text/plain for readability purposes
    header('Content-Type: text/plain');

    // stores all the courses
    $allCourses = getAllCourses();
    $addCourse = "";

    // loops through to create an XML string for each course
    foreach($allCourses as $course) {
         $addCourse .= ' <course>
  <courseID>'.$course['courseID'].'</courseID>
  <courseName>'.$course['courseName'].'</courseName>
 </course>
';
    };

    // similar to assignment 2?
    // adds the overall courses tag
    $coursesXml = '<?xml version="1.0"?>
<courses>
'.
$addCourse.
'</courses>';

    // prints to screen
    echo $coursesXml;
}

// xml format of all students in a particular course
else if ($_GET['format'] == 'xml' && $_GET['action'] == 'students'){
    // sets the html header to text/plain for readability purposes
    header('Content-Type: text/plain');

    // stores all students
    $allStudents = getStudentsByCourse($_GET['course']);
    $addStudent = "";

    // loops through to create an XML string for each student
    foreach($allStudents as $student) {
        $addStudent .= ' <student>
  <studentID>'.$student['studentID'].'</studentID>
  <courseID>'.$student['courseID'].'</courseID>
  <firstName>'.$student['firstName'].'</firstName>
  <lastName>'.$student['lastName'].'</lastName>
  <email>'.$student['email'].'</email>
 </student>
';
   };

    // similar to assignment 2?
    // adds the overall students tag
    $studentXML = '<?xml version="1.0"?>
<students>
'.
$addStudent.
'</students>';

    //prints to screen
    echo $studentXML;
}
else {
    return "Incorrect URL.";
}
?>