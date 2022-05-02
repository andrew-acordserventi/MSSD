const data = require('./zips.json');

module.exports.lookupByZipCode =  (zip) => {
    console.log("Looking up zip code " + zip);

    let result = data.find(zipCode => zipCode._id === zip);

    return result;
};

module.exports.lookupByCityState = (city, state) => {
    console.log("Lookup by city, state " + city + ", " + state);

    // filters results by city first, then by state
    let results = data.filter(cityState => cityState.city === city && cityState.state === state);
    
    // creates a new object, and maps the zips to populations
    let zipPop = {city: city, 
                    state: state,
                    data: results.map(element => {return {zip: element._id, pop: element.pop};})
                };

    return zipPop;
};

module.exports.getPopulationByState = (state) => {
    console.log("Getting population by state " + state);

    let results = data.reduce((pop, curr) => {
        // checks state value against current object state. if it matches, add it to the pop, and return it to keep track
        if (curr.state === state) pop += curr.pop;
        return pop;
        // sets default value of pop to 0
        }, 0);

    // must return "" or it logs an extra undefined
    return results;
};

