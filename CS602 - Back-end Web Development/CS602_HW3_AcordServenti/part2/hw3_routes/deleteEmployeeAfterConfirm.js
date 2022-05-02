// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// removes employee from database
module.exports =  async (req , res , next) => {
    
    // Fill in the code
    // grabs the id of the employee from the text body rendered
    let id = req.body.id;

    // finds the employee in the database, checks for errors, or not found
    Employee.findById(id,  (err, employee) => {
      if(err)
        console.log("Error Selecting : %s ", err); 
      if (!employee)
        return res.render('404');
      
        // removes employee from database, or gives error, and redirects to the homepage
        employee.remove( (err) => {
	        if (err)
	          console.log("Error deleting : %s ",err );
	        res.redirect('/employees');
	      });     

      });
  };

  