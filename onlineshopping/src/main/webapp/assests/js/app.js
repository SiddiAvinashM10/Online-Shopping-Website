$(function(){
	
	switch(menu){
		case 'About':
			$('#about').addClass('active');
			break;
		case 'Contact':
			$('#contact').addClass('active');
			break;
		case 'Home':
			$('#home').addClass('active');
			break;
		case 'Products':
			$('#listProducts').addClass('active');
			break;
		default:
			if (menu == "Home")
				break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;
	}
})