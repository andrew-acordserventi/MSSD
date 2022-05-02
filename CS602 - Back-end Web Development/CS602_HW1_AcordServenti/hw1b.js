const cities = require('./zipCodeModule_v2');

console.log(cities.lookupByZipCode("02215"), "\n");

console.log(cities.lookupByZipCode("99999"), "\n");

console.log(cities.lookupByCityState("BOSTON", "MA"), "\n");

console.log(cities.lookupByCityState("BOSTON", "TX"), "\n");

console.log(cities.lookupByCityState("BOSTON", "AK"), "\n");

console.log(cities.getPopulationByState("MA"), "\n");

console.log(cities.getPopulationByState("TX"), "\n");

console.log(cities.getPopulationByState("AA"), "\n");
