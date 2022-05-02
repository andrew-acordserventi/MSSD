// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// moves to delete employee view when button is pressed
module.exports = async (req , res , next) => {
    
    // Fill in the code
    // grabs the id of the employee
    let id = req.params.id;

    // finds the employee in the database, checks for errors, or not found
    Employee.findById(id,  (err, employee) => {
      if(err)
        console.log("Error Selecting : %s ", err); 
      if (!employee)
        return res.render('404');
      
        // renders the deleteemployee view and populates with specific employee
      res.render('deleteEmployeeView',
      {title:"Delete Employee", 
      data: {id: employee._id,
             firstName: employee.firstName,
             lastName: employee.lastName}} 

      );
    });

  }

  