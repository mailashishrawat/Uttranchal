var app=angular.module('appMaps', ['uiGmapgoogle-maps'])
    .controller('mainCtrl', function($scope,Geolocation) {
    $scope.MapContainer=Geolocation.geolocation();
  
       
    });