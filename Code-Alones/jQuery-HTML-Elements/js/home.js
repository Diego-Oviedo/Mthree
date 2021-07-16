$(document).ready(function () {
    
	//Center all H1 elements.
	$('h1').addClass('text-center');
	$('h1').css('.text-center { text-align: center}');
	
	//Center all H2 elements.
	$('h2').css({'text-align': 'center'});

	//Replace the class that is on the element containing the text "Team Up!" with the class page-header.
	$('.myBannerHeading').addClass('page-header');
	$('h1').removeClass('myBannerHeading');
	//$('.page-header').css('color', 'blue');
	
	//Change the text of "The Squad" to "Yellow Team".
	$('#yellowHeading').text('Yellow Team');
	
	//Change the background color for each team list to match the name of the team.
	$('#yellowTeamList').css('color', 'yellow');
	$('#blueTeamList').css('color', 'blue');
	$('#orangeTeamList').css('color', 'orange');
	$('#redTeamList').css('color', 'red');
	
	//Add Joseph Banks and Simon Jones to the Yellow Team list.
	$('#yellowTeamList').html('<li>Joseph Banks</li> <li>Simon Jones</li> ');
	
	//Hide the element containing the text "Hide Me!!!"
	$('#oops').hide();
	
	//Remove the element containing the text "Bogus Contact Info" from the footer.
	$('#footerPlaceholder').remove();
	
	//Add a paragraph element containing your name and email to the footer. 
	$('#footer').html('<p id="contact-info" >Name:Diego Oviedo <br>Email: hahaImNotGonnaGivUMyEmail@lol.com </p>');
	//The text must be in Courier font and be 24 pixels in height.
	$('#contact-info').css('font-style','Courier');
	$('#contact-info').css('font-size','24px');
});


//INC3083762