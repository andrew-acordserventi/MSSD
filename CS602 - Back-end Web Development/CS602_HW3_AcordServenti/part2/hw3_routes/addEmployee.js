// moves to addemployee view when button is clicked
module.exports = (req , res , next) => {
		
		// Fill in the code
		//renders the addemployee view handlebar when button is clicked
		res.render('addEmployeeView', {title:"Add an Employee"}); 


};
