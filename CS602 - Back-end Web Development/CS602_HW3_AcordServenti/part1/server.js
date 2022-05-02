const express = require('express');
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// setup handlebars view engine
const handlebars = require('express-handlebars');

app.engine('handlebars', 
	handlebars({defaultLayout: 'main'}));

app.set('view engine', 'handlebars');

// static resources
app.use(express.static(__dirname + '/public'));

// Use the employee module
const cities = require('./mongo_zipCodeModule_v2');

// GET request to the homepage
app.get('/', function (req, res){
	res.render('homeView');
});

app.get('/zip', async function(req, res) {
	if (req.query.id) {
		let id = req.query.id;
		let result = await cities.lookupByZipCode(id);
		res.render('lookupByZipView', result);
	} else {
		res.render('lookupByZipForm');
	}
});

app.post('/zip', async function(req, res) {
	let id = req.body.id;
	let result = await cities.lookupByZipCode(id);
	res.render('lookupByZipView', result);
});


app.get('/zip/:id', async function(req, res) {
	let id = req.params.id;
	let result = await cities.lookupByZipCode(id);

	res.format({

		'application/json': function() {
			res.json(result);
		},

		'application/xml': function() {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
						'<zipCode id="' + result._id + '">\n' + 
						'   <city>' + result.city + '</city>\n' + 
						'   <state>' + result.state + '</state>\n' + 	
						'   <pop>' + result.pop + '</pop>\n' + 				 
						'</zipCode>\n';
					
			
			res.type('application/xml');
			res.send(resultXml);
		},

		'text/html': function() {
			res.render('lookupByZipView', result);

		}
	});
});


// Complete the code for the following

app.get('/city', async function(req, res){
	if(req.query.city && req.query.state) {
		let result = await cities.lookupByCityState(req.query.city.toUpperCase(), req.query.state.toUpperCase());
		res.render('lookupByCityStateView', result);
	}
	else {
		res.render('lookupByCityStateForm');
	}
	
});

app.post('/city', async function(req, res){
	let result = await cities.lookupByCityState(req.body.city.toUpperCase(), req.body.state.toUpperCase());
	res.render('lookupByCityStateView', result);

});

app.get('/city/:city/state/:state', async function(req, res) {
	let result = await cities.lookupByCityState(req.params.city.toUpperCase(), req.params.state.toUpperCase());

	res.format({

		'application/json': function() {
			res.json(result);
		},

		'application/xml': function() {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
						'<zipCode id="' + result._id + '">\n' + 
						'   <pop>' + result.pop + '</pop>\n' + 				 
						'</zipCode>\n';
					
			
			res.type('application/xml');
			res.send(resultXml);
		},

		'text/html': function() {
			res.render('lookupByCityStateView', result);
		}
	});
});

app.get('/pop', async function(req, res) {
	if(req.query.state) {
		let result = await cities.getPopulationByState(req.query.state);
		res.render('populationView', {state: req.query.state, pop: result});
	}
	else {
		res.render('populationForm');
	}
});

app.get('/pop/:state', async function(req, res) {
	let result = await cities.getPopulationByState(req.params.state);

	res.format({

		'application/json': function() {
			res.json(result);
		},

		'application/xml': function() {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
						'<state="' + result.state + '">\n' + 
						'   <pop>' + result.pop + '</pop>\n' + 				 
						'</zipCode>\n';
					
			
			res.type('application/xml');
			res.send(resultXml);
		},

		'text/html': function() {
			res.render('populationView', {state: req.params.state, pop: result});
		}
	});
});


app.use(function(req, res) {
	res.status(404);
	res.render('404');
});

app.listen(3008, function(){
  console.log('http://localhost:3008');
});




