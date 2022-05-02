const mongoose = require('mongoose');

// unused since the mongoDB was local
const credentials = require("./credentials.js");

// local mongoDB address - may need to modify to get to work
const dbUrl = 'mongodb://localhost:27017/cs602db';

let connection = null;
let model = null;

let Schema = mongoose.Schema;

// create a new employee schema to feed the database with the correct layout
let employeeSchema = new Schema({
	firstName: 'string',
	lastName: 'string'
}, {
	collection: 'employees_AcordServenti'
});

// exports the mongodb model (??)
module.exports = {	
	getModel: () => {
		if (connection == null) {
			console.log("Creating connection and model...");
			connection = mongoose.createConnection(dbUrl, { useNewUrlParser: true, useUnifiedTopology: true });
			model = connection.model("EmployeeModel", 
							employeeSchema);
		};
		return model;
	}
};
























