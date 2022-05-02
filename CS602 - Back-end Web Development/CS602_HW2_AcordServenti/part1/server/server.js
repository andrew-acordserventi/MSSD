const net = require('net');

const colors = require('colors');

const cities = require('./zipCodeModule_v2');

const server = net.createServer((socket) => {

	console.log("Client connection...".red);

	socket.on('end', () => {
		console.log("Client disconnected...".red);
	});

	// HW Code - Write the following code to process data from client
	
	socket.on('data', (data) => {

		let input = data.toString();
		console.log(colors.blue('...Received %s'), input);

		// Fill in the rest
		let commands = input.split(',');

		if(commands[0] == 'lookupByZipCode'){
			let object = cities.lookupByZipCode(commands[1]);
			if (object == undefined) {
				socket.write('undefined');
			}
			else {
				socket.write(JSON.stringify(object));
			}
		}
		else if (commands[0] == 'lookupByCityState') {
			let object = cities.lookupByCityState(commands[1], commands[2]);
			socket.write(JSON.stringify(object));
		}
		else if (commands[0] == 'getPopulationByState') {
			let object = {state:commands[1], pop:cities.getPopulationByState(commands[1])};
			socket.write(JSON.stringify(object));
		}
		else {
			socket.write('Invalid Command...')
		}
		
	});

});

// listen for client connections
server.listen(3008, () => {
	console.log("Listening for connections on port 3008");
});
