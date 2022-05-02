// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// allows for editing of an employee's firstname/lastname
// does NOT allow modifying an employee's ID
module.exports = async (req , res , next) => {

    // Fill in the code
    // grabs the id of the employee from the text body rendered
    let id = req.body.id;

    // searches database for the employee by id, checks for errors, and logs 404 if not found
    Employee.findById(id, (err, employee) => {
      if(err)
        console.log("Error Selecting : %s ", err); 
      if (!employee)
        return res.render('404');

        // sets the employees firstname/lastname from the text form handlebar website
        employee.firstName = req.body.fname;
        employee.lastName = req.body.lname;
        
        // saves the employee's new firstname/lastname and redirects to home
        employee.save((err) => {
          if (err)
            console.log("Error updating : %s ",err );
            res.redirect('/employees');
        });
    });
    
 };
