$(document).ready(function(){
	
	// Solution to active menu problem
	switch(menu) {
		case "About Us":
			$("#about").addClass("active");
			break;
		case "Contact Us":
			$("#contact").addClass("active");
			break;
		case "All Products":
			$("#list_products").addClass("active");
			break;
		default:
			$("#home").addClass("active");
	}
});