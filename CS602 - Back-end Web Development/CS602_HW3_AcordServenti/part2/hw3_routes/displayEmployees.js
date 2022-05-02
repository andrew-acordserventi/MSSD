// gets the employee database
const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// display all employees
module.exports = async (req , res , next) => {

        // gets employees from database
        let employees = await Employee.find({});

        // key/value pairs employees for easy display
        let results = employees.map( emp => {
            return {
                id: emp._id,
                firstName: emp.firstName,
                lastName: emp.lastName
            }
        });
            
        // renders employee view
        res.render('displayEmployeesView',
                {title:"List of Employees", data:results});
        
};
