<?php
require_once('database.php');

// Get course ID
$course_id = filter_input(INPUT_GET, 'course_id');
if ($course_id == NULL || $course_id == FALSE) {
    $getFirst = 'SELECT * FROM sk_courses LIMIT 1';
    $statement4 = $db -> prepare($getFirst);
    $statement4->execute();
    $course = $statement4->fetch();
    $course_id = $course['courseID'];
    $statement4->closeCursor();
}

// Get all courses
$queryCourses = 'SELECT * FROM sk_courses ORDER BY courseID';
$statementCourses = $db -> prepare($queryCourses);
$statementCourses->execute();
$courses = $statementCourses->fetchAll();
$statementCourses->closeCursor();

// Get name for selected course
$queryCourse = 'SELECT * FROM sk_courses
                      WHERE courseID = :course_id';
$statement1 = $db->prepare($queryCourse);
$statement1->bindValue(':course_id', $course_id);
$statement1->execute();
$course = $statement1->fetch();
$course_name = $course['courseName'];
$statement1->closeCursor();

// get students for selected course
$queryStudents = 'SELECT * FROM sk_students
              WHERE courseID = :course_id
              ORDER BY studentID';
$statement3 = $db->prepare($queryStudents);
$statement3->bindValue(':course_id', $course_id);
$statement3->execute();
$students = $statement3->fetchAll();
$statement3->closeCursor();

?>

<!DOCTYPE html>
<html>

<!-- the head section -->
<head>
    <title>My Course Manager</title>
    <link rel="stylesheet" type="text/css" href="main.css" />
</head>

<!-- the body section -->
<body>
<header><h1>Course Manager</h1></header>
<main>
    <center><h1>Student List</h1></center>

    <aside>
        <!-- display a list of categories -->
        <h2>Courses</h2>
        <nav>
        <ul>
        <?php foreach ($courses as $course) : ?>
            <li><a href="?course_id=<?php echo $course['courseID']; ?>">
                    <?php echo $course['courseID']; ?>
                </a>
            </li>
            <?php endforeach; ?>
        </ul>
        </nav>          
    </aside>

    <section>
        <!-- display a table of Students -->
        <h2><?php echo $course_id.' - '.$course_name; ?></h2>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>&nbsp;</th>
            </tr>
            <?php foreach ($students as $student) : ?>
            <tr>
                <td><?php echo $student['firstName']; ?></td>
                <td><?php echo $student['lastName']; ?></td>
                <td><?php echo $student['email']; ?></td>
                <td><form action="delete_student.php" method="post">
                    <input type="hidden" name="student_id"
                            value="<?php echo $student['studentID']; ?>">
                        <input type="hidden" name="course_id"
                            value="<?php echo $course_id; ?>">
                        <input type="submit" value="Delete">
                </td>
            </tr>
            <?php endforeach; ?>

            
        </table>

        <p><a href="add_student_form.php">Add Student</a></p>

        <p><a href="course_list.php">List Courses</a></p>    

    </section>
</main>

<footer>
    <p>&copy; <?php echo date("Y"); ?> Suresh Kalathur</p>
</footer>
</body>
</html>