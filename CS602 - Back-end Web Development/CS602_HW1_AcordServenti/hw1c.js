const ZipCodeEmitter = require('./zipCodeEmitter').ZipCodeEmitter;

const cities = new ZipCodeEmitter();

// subscribing handlers to each function; 
// note if we don't subscribe, output is nothing
cities.on('lookupByZipCode', function (args) {
    console.log('Event lookupByZipCode raised! \n', 
    	args);
});

// handler 1
cities.on('lookupByCityState', function (args) {
    console.log('Event lookupByCityState raised! (Handler1)\n', 
    	args);
});

// handler 2
cities.on('lookupByCityState', function (args) {
    console.log('Event lookupByCityState raised! (Handler2)\n');
    console.log('City: ' + args.city + ', State: ' + args.state);
    // loops through the data to print out a formatted result
    for (let i = 0; i < args.data.length; i++) {
        let zipPop = args.data[i];
        let zip = zipPop.zip;
        let pop = zipPop.pop;
        console.log(zip + " has a population of " + pop);
    };
});

cities.on('getPopulationByState', function (args) {
    console.log('Event getPopulationByState raised!\n', 
    	args);
});

// calling each function
cities.lookupByZipCode('02215');
cities.lookupByCityState('BOSTON', 'MA');
cities.getPopulationByState('MA');
