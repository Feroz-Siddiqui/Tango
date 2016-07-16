function getURLData(url) {
	console.log("61->>" + url);

	if (url != "#") {
		$.ajax({
			url : url,
			success : function(result) {
				$('.button-collapse').sideNav('hide');
				$('#main-container').html(result);
				setup_page();
		},
			error : function() {
					}
		});
		
	
	} else {console.log("7333->>" + url);
	}
	return false;
}


function setup_page(){
	setup_event();
	
}

function setup_event(){

	//start calendar initialization //
	$('#yourId3')
	.jalendar(
			{
				color : '#373a3c', // Unlimited
				color2 : '#373a3c',
				type : 'range',
				dateType : 'yyyy-mm-dd',
				done : function() {
					var startdate = $('#yourId3 input.data1').val().split('-');
					var endate = $('#yourId3 input.data2').val().split('-');
					startdate = check_zero(startdate);
					endate = check_zero(endate);
					var daystring = startdate[0] + '-' + startdate[1] + '-'
							+ startdate[2] + '_' + endate[0] + '-' + endate[1]
							+ '-' + endate[2];				
					get_event_data(daystring,"monthly");

				}
			});
	//end calendar initialization //
	setup_event_workflow();		
}


function setup_event_workflow(){
	//start map initialization//
	/*try{ 
	function init_map() {
         var var_location = new google.maps.LatLng(40.725118, -73.997699);

         var var_mapoptions = {
             center: var_location,
             zoom: 14
         };

         var var_marker = new google.maps.Marker({
             position: var_location,
             map: var_map,
             title: "New York"
         });

         var var_map = new google.maps.Map(document.getElementById("map-container"),
             var_mapoptions);

         var_marker.setMap(var_map);

     }
     google.maps.event.addDomListener(window, 'load', init_map);
	} catch(errr){
		console.log('map error --> '+errr);
	}*/
	//end map initialization//
     
    $('#auto-collapse-menu-demo').metisMenu();
    $('#auto-collapse-menu-demo1').metisMenu();
    $('#auto-collapse-menu-demo input[type="checkbox"]').click(function(e) {
        e.stopPropagation();
    });
   //start star rating external js//
	  var $rateYo = $("#rateYo").rateYo({halfStar: true});
	  if($('.rateYo').length){
			 $('.rateYo').each(function(i, obj) {
			 ratingValue = obj.attributes["data-value"].value;
			 ratingID = '#'+obj.attributes["id"].value;


			 $(ratingID).rateYo({
			 rating: ratingValue,
			 readOnly: true,
			 starWidth: "20px"
			 });

			 });
			 }
   //end star rating external js//
}