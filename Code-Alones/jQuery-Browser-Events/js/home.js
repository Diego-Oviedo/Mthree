$(document).ready(function () {
	
	//When the Show/Hide Weather button is clicked, the page should display the associated weather information if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
	var visbility_louisville = document.getElementById("louisvilleInfoDiv");
	var visbility_minneapolis = document.getElementById("minneapolisInfoDiv");
	var visbility_akron = document.getElementById("akronInfoDiv");
	//Only the content in the Main section should display when the page is loaded.
	$('body').load(
 	$('body').css('visibility','hidden'),
	$('#mainInfoDiv').css('visibility','visible'),
	
	
	$('#akronWeatherButton').css('visibility','visible'),
	//When the Akron button is clicked, only the content in the Akron section should display; the weather information for Akron should be hidden initially.
	$('#akronWeatherButton').on('click', function() {
		//When the Show/Hide Weather button is clicked, the page should display the associated weather information if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
	 if (visbility_akron.style.visibility == "visible") {
	    $('#akronInfoDiv').css('visibility','hidden');
		$('#akronWeatherButton').css('visibility','visible');
	  } else {
	    $('#akronInfoDiv').css('visibility','visible');
		$('#akronWeatherButton').css('visibility','visible');
	  }
    }),


	$('#minneapolisWeatherButton').css('visibility','visible'),
	//When the Minneapolis button is clicked, only the content in the Minneapolis section should display; the weather information for Minneapolis should be hidden initially.
	$('#minneapolisWeatherButton').on('click', function() {
		//When the Show/Hide Weather button is clicked, the page should display the associated weather information if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
	 if (visbility_minneapolis.style.visibility == "visible") {
	    $('#minneapolisInfoDiv').css('visibility','hidden');
		$('#minneapolisWeatherButton').css('visibility','visible');
	  } else {
	    $('#minneapolisInfoDiv').css('visibility','visible');
		$('#minneapolisWeatherButton').css('visibility','visible');
	  }
	}),
	
	
	
	//When the Louisville button is clicked, only the content in the Louisville section should display; the weather information for Louisville should be hidden initially.
	$('#louisvilleWeatherButton').css('visibility','visible'),
	$('#louisvilleWeatherButton').on('click', function() {
		//When the Show/Hide Weather button is clicked, the page should display the associated weather information if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
	 if (visbility_louisville.style.visibility == "visible") {
	    $('#louisvilleInfoDiv').css('visibility','hidden');
		$('#louisvilleWeatherButton').css('visibility','visible');
	  } else {
	    $('#louisvilleInfoDiv').css('visibility','visible');
		$('#louisvilleWeatherButton').css('visibility','visible');
	  }
	}),
	
	
	//The background color of any table row should change to “WhiteSmoke” when the mouse pointer is hovering over the row.
	//This applies to all rows in all tables except the first (header) row in a given table. The first (header) row in any table should not change appearance when the mouse pointer hovers over it.
	$('.table  tr').not(':first-child').hover(
        // in callback
        function() {
            $(this).css('background-color', 'WhiteSmoke');
        },
        // out callback
		//The background color of the row should return to white when the mouse pointer is no longer hovering over the row.
        function() {
            $(this).css('background-color', '');
        })
	);
	
	

});
