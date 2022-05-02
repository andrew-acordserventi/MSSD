const MongoClient = require('mongodb').MongoClient;
const credentials = require("./credentials.js");

// local mongodb access - else you import credentials file and string together the credentials to access datbase
const dbUrl = 'mongodb://localhost:27017/cs602db';

let client = null;

// connects to mongodb (?)
const getConnection = async () => {
	if (client == null)
		client = await MongoClient.connect(dbUrl,  { useNewUrlParser: true ,  useUnifiedTopology: true });
	return client;
}

// function to lookup a zipcode in the mongodb database
module.exports.lookupByZipCode =  async (zip) => {
		
	let client = await getConnection();
	// stores the database in a variable
	let collection = client.db(credentials.database).collection('zipcodes');
	
	// finds the zip code in the database and makes it an array
	let result = await collection.find({'_id': zip}).toArray();
	
	// if nothing is found (eg, fake zip)
	if (result.length > 0)
		return result[0];
	else
		return undefined;
};

// Complete the code for the following
// function to lookup city/state zips in the mongodb database
module.exports.lookupByCityState = async (city, state) => {

	let client = await getConnection();
	// stores the database in a variable
	let collection = await client.db(credentials.database).collection('zipcodes');

	// finds matching state and city in the database and converts to an array
	let result = await collection.find({'state': state, 'city': city}).toArray();

	// formats the return to match what is expected
	let zipPop = {city: city, 
					state: state,
					data: result.map(result => {return {zip: result._id, pop: result.pop};}) // key value pair for zipcodes and populations
	};

	return zipPop;

};

// function to get population for a state
module.exports.getPopulationByState = 
	async (state) => {

		let client = await getConnection();
			// stores the database in a variable
		let collection = client.db(credentials.database).collection('zipcodes');
	
		// Fill in the rest
		// filters out state and converts to array
		let result = await collection.find({'state': state}).toArray();

		// somewhere to store our total pop
		let population = 0;
	
		// loops through json; 
		for(let i = 0; i < result.length; i++) {
			// if the state of the city matches, add its pop to our running total
			if (result[i].state === state) {
				population += result[i].pop;
			}
		}
	
		return population;
	};

