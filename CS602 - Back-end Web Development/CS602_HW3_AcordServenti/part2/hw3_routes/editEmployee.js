// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// routes screen to show an editable employee information
module.exports = async (req , res , next) => {

    // Fill in the code
    // grabs the id of the employee
    let id = req.params.id;

    // searches database for the employee by id, checks for errors, and logs 404 if not found
    Employee.findById(id, (err, employee) => {
      if(err)
        console.log("Error Selecting : %s ", err); 
      if (!employee)
        return res.render('404');
      
      // renders the edit employee view using the employee's info
      res.render('editEmployeeView',
          {title:"Edit Employee", 
           data: {id: employee._id,
                  firstName: employee.firstName,
                  lastName: employee.lastName}
          });                
    });
    
};

