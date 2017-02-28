var app = angular.module('Myapp', ['ngRoute', 'uiGmapgoogle-maps']);

app.config(function($routeProvider,uiGmapGoogleMapApiProvider) {
	
	$routeProvider.when('/', {
    templateUrl: "main.php",
    controller: 'myCtrl1'

  })
  .when("/CorNatPark", {
        templateUrl :"CorNatPark.html",
        controller:'mainCtrl'
    })
    .when("/Auli", {
        templateUrl :"Auli.html",
        controller:'Auli'
    }) .when("/Nainital", {
        templateUrl :"Nainital.html",
        controller:'Nainital'
    }).when("/Almora", {
        templateUrl :"Almora.html",
        controller:'Almora'
    })
    .when("/valley", {
        templateUrl :"Valley.html",
        controller:'Valley'
    })
    .when("/Mussoorie", {
        templateUrl :"Mussoorie.html",
        controller:'Mussoorie'
    })
    .when("/kausani", {
        templateUrl :"Kausani.html",
        controller:'Kausani'
    })
   .otherwise({
    redirectTo: '/'
  })
	 
});


	
	app.controller('myCtrl',['$scope','$rootScope', 'Getdata', function($scope,$rootScope,Getdata) {
		$scope.init = function(){
			 Getdata.getSpec().then(function(response) {
				 $rootScope.result = response.data;
			    }, function(error) {
			        console.log('opsssss' + error);
			    });
			

		 };
		
	       
	    }]);





app.controller('myCtrl', function($scope, $rootScope,$http,Getdata) {
	
  $scope.submitdata = function() {
    $http({
        url: "http://localhost:7865/My_Project/Angularjava1",
        method: "post",
        data: {
          "name": $scope.name,
          "email": $scope.email,
          "msg": $scope.msg

        }

      }).success(function(data, status, headers, config) {
    	
        $scope.name = "";
        $scope.msg = "";
        $scope.email = "";
        Getdata.getSpec().then(function(response) {
        	$rootScope.result = response.data;
	    });
       
        
       
    
      }).error(function(data, status, headers, config) {
        alert("AJAX failed!");
      });
  }
});
app.controller('mainCtrl', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(29.4259,79.25);
  
       
    });
app.controller('Auli', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });
app.controller('Nainital', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });
app.controller('Almora', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });
app.controller('Valley', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });

app.controller('Mussoorie', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });
app.controller('Kausani', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation(30.9494,77.7478);
  
       
    });