
app.service('Getdata', function ($http) {

    this.getSpec = function() {
     return $http.get('http://localhost:7865/My_Project/Datadisplay');
    }

});





















