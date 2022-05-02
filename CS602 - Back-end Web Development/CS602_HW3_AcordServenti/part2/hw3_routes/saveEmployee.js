// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// saves a new employee after addemployee is invoked
module.exports = async (req , res , next) => {
 
    // Fill in the code
    // creates a new employee from the handlebars form
    let employee = new Employee({
      firstName:     req.body.fname,
      lastName:       req.body.lname
    }); 
 
    // saves that employee to the database
    employee.save((err) => {
      if(err)
        console.log("Error : %s ",err);
        res.redirect('/employees');
    });
  };
