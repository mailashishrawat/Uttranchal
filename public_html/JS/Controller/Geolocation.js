app.factory('Geolocation', ["$rootScope",  function($rootScope) {
	
	     
return{
	geolocation:function(lt,ln)
	{
		
		
        
		$rootScope.map = 
	        { center: 
	        { latitude: lt, longitude: ln }, 
	        zoom: 4
	        
	       
	       
	        
	        
	        
	        
	        
	        
	        
	        };
		  $rootScope.marker = {
			      id: 0,
			      coords: {
			        latitude: lt,
			        longitude:ln
			      },
			      
			      options: { draggable: true },
			      events: {
			        dragend: function (marker, eventName, args) {
			          $log.log('marker dragend');
			          var lat = marker.getPosition().lat();
			          alert("lat"+lat);
			          var lon = marker.getPosition().lng();
			          alert("lon"+lon);
			          $log.log(lat);
			          $log.log(lon);

			          $scope.marker.options = {
			            draggable: true,
			            labelContent: "lat: " + $scope.marker.coords.latitude + ' ' + 'lon: ' + $scope.marker.coords.longitude,
			            labelAnchor: "100 0",
			            labelClass: "marker-labels"
			          };
			        }
			      }
			    };
		
	
	        if (navigator.geolocation) navigator.geolocation.getCurrentPosition(onPositionUpdate);
	        function onPositionUpdate(position) {

	            var lat = position.coords.latitude;
	            var lng= position.coords.longitude;
	            $rootScope.map1 = {
	                    center: {
	                            latitude: lat,
	                            longitude: lng
	                    },
	                    zoom: 8
	            };
		        $rootScope.marker1 = {
					      id: 1,
					      coords: {
					        latitude: lat,
					        longitude:lng
					      },
					      
					      options: { draggable: true }
					  
					    }
	             
	              
	               
	               
	             
	            }
	      
			

	}
	
};
}]);