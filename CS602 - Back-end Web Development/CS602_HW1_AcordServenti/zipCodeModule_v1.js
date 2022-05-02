const data = require('./zips.json');

module.exports.lookupByZipCode =  (zip) => {
    console.log("Looking up zip code " + zip);

    // loops through json
    for(let i = 0; i < data.length; i++) {
        // if the object at i has the a matching zipcode, log it, and exit the function
        if (data[i]._id === zip) {
            console.log(data[i]);
            // must return "" or it logs an extra undefined
            return "";
        }
    }
};

module.exports.lookupByCityState = (city, state) => {
    // somewhere to hold our results
    let results = [];

    console.log("Lookup by city, state " + city + ", " + state);

    // loops through json
    for(let i = 0; i < data.length; i++) {
        // if the state matches, check the city
        if (data[i].state === state) {
            // if the city matches, add data with push to our results array
            if(data[i].city === city) {
                results.push(data[i]);
            }
        }
    }

    // formats in the requested format
    let zipPop = {city: city,
                    state: state,
                    data: []};
    let tempCombiner = {};

    // loops through the results and combines them into an object
    for(let i = 0; i < results.length; i++) {
        let zip = results[i]._id;
        let pop = results[i].pop;
        tempCombiner = {zip,pop};
        // stores the ibject in the data section of the zipPop object
        zipPop.data.push(tempCombiner);
    }

    console.log(zipPop);
    // must return "" or it logs an extra undefined
    return "";
};

module.exports.getPopulationByState = (state) => {
    console.log("Getting population by state " + state);

    // somewhere to store our total pop
    let population = 0;

    // loops through json; 
    for(let i = 0; i < data.length; i++) {
        // if the state of the city matches, add its pop to our running total
        if (data[i].state === state) {
            population += data[i].pop;
        }
    }

    console.log("Population of " + state + " is " + population);
    // must return "" or it logs an extra undefined
    return "";
};

