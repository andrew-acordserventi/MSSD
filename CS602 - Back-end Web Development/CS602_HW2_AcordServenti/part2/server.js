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

// Use the zipCode module
const cities = require('./zipCodeModule_v2');

// GET request to the homepage

app.get('/',  (req, res) => {
	res.render('homeView');
});

app.get('/zip', (req, res) => {

	if(req.query.id) {
		let result = cities.lookupByZipCode(req.query.id);
		// zip not found handler
		if(result == undefined) {
			res.render('lookupByZipView', {zip: undefined, 
											city: undefined, 
											state: undefined, 
											pop: undefined});
											}
		else {
			res.render('lookupByZipView', {zip: result.zip, 
				city: result.city, 
				state: result.state, 
				pop: result.pop});
		}

	}
	else {
		res.render('lookupByZipForm');
	}
});

app.post('/zip', (req, res) => {
	let result = cities.lookupByZipCode(req.body.id);
	// zip not found handler
	if(result == undefined) {
		res.render('lookupByZipView', {zip: "not found", 
										city: "not found", 
										state: "not found", 
										pop: "not found"});
										}
	else {
		res.render('lookupByZipView', {zip: result.zip, 
			city: result.city, 
			state: result.state, 
			pop: result.pop});
	}
});

app.get('/zip/:id', (req, res) => {

	let result = cities.lookupByZipCode(req.params.id);
	// zip not found handler
	if(result == undefined) {
		res.render('lookupByZipView', {zip: undefined, 
										city: undefined, 
										state: undefined, 
										pop: undefined});
										}
	else {
		res.render('lookupByZipView', {zip: result.zip, 
			city: result.city, 
			state: result.state, 
			pop: result.pop});
	}
	//TODO implement JSON, XML formats
});

app.get('/city', (req, res) => {
	if(req.query.city && req.query.state) {
		let result = cities.lookupByCityState(req.query.city.toUpperCase(), req.query.state.toUpperCase());
		res.render('lookupByCityStateView', result);
	}
	else {
		res.render('lookupByCityStateForm');
	}
});

app.post('/city', (req, res) => {
	let result = cities.lookupByCityState(req.body.city.toUpperCase(), req.body.state.toUpperCase());
	res.render('lookupByCityStateView', result);
});

app.get('/city/:city/state/:state', (req, res) => {
	let result = cities.lookupByCityState(req.params.city.toUpperCase(), req.params.state.toUpperCase());
	res.render('lookupByCityStateView', result);
	//TODO implement JSON, XML formats

});

app.get('/pop', (req, res) => {
	if(req.query.state) {
		let result = cities.getPopulationByState(req.query.state);
		res.render('populationView', {state: req.query.state, pop: result});
	}
	else {
		res.render('populationForm');
	}
	
});

// Implement the JSON, XML, & HTML formats
app.get('/pop/:state', (req, res) => {
	let result = cities.getPopulationByState(req.params.state);
	res.render('populationView', {state: req.params.state, pop: result});

	//TODO implement JSON, XML formats
});

app.use((req, res) => {
	res.status(404);
	res.render('404');
});

app.listen(3000, () => {
  console.log('http://localhost:3000');
});

/**
 * Code needed to support multiple MIME types, including JSON, XML, HTML
 * Needs to be placed in :state, :id, :zip methods
 * Could not get to work - and it breaks the base app; error messages at bottom

res.format({

	'application/json': () => {
		let result = cities.lookupByZipCode(req.params.id);
		// zip not found handler
		if(result == undefined) {
			res.json('lookupByZipView', {zip: undefined, 
											city: undefined, 
											state: undefined, 
											pop: undefined});
											}
		else {
			res.json('lookupByZipView', {zip: result.zip, 
				city: result.city, 
				state: result.state, 
				pop: result.pop});
		}
	
	},

	'application/xml': () => {
		let zipXml = 
			'<?xml version="1.0"?>\n<zipCode>\n' +
				cities.lookupByZipCode().map(function(c){
					return ' <zipCode id="' + c.id + '">\n' + 
						'  <city>' + c.city + '</city>\n' + 
						'  <state>' + c.state + '</state>\n' + 
						'  <pop>' + c.pop + '</pop>\n';
				}).join('\n') + '\n</zipCode>\n';
		
		res.type('application/xml');
		res.send(zipXml);
	},

	'text/html': () => {
		let zipHtml = '<ul>\n' +
			cities.lookupByZipCode().map(function(c){
				return ' <li>' + c.id + ' - ' + 
							c.city + ' - ' + 
							c.state + ' - ' + 
							c.pop + '</li>';
			}).join('\n') + '\n</ul>\n';

		res.type('text/html');
		res.send(zipHtml);
	},

	'default': () => {
		res.status(404);
		res.send("<b>404 - Not Found</b>");
	}
});

Throwing errors:

TypeError: Cannot read property 'map' of undefined
    at Object.text/html (C:\Users\Andrew\IdeaProjects\CS602\CS602_HW2_AcordServenti\part2\server.js:112:29)

express deprecated res.json(status, obj): Use res.status(status).json(obj) instead server.js:104:9
RangeError [ERR_HTTP_INVALID_STATUS_CODE]: Invalid status code: lookupByZipView


*/