<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Uttarakhand</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.1/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.1/angular-route.min.js"></script>

 <link rel="stylesheet" href=Css/maincss.css>


<script src="https://rawgit.com/angular-ui/angular-google-maps/2.1.5/dist/angular-google-maps.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyA2ouhByoiReSRShjGERs0VY_8hWaaaqBw "></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.5.0/lodash.min.js"></script>
<meta name="keywords" content="ng-map,AngularJS,center">
       <!--   <script src=JS/Controller/controller.js></script>-->
      <script src=JS/Router/router.js></script> 
       
   <script src=JS/Controller/Geolocation.js></script>
      <script src=JS/Controller/GetData.js></script>
 
<script>
$(document).ready(function(){
  // Add scrollspy to <body>
  $('body').scrollspy({target: ".navbar", offset: 50});   

  // Add smooth scrolling on all links inside the navbar
  $("#test a").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuerys animate() method to add smooth page scroll
      // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    }  // End if
  });
});
</script>

 
 <style>
 

 .cmt
 {
background-color:#F5F5F5;
padding:4px 40px 0px 1px;
 }
 #contact { 
   position: relative; 
   width: 100%; /* for IE 6 */
}
.comment_data{

height:100px;
border:1px solid red;
}}

.comment{ 
   position: absolute; 
   top: 10px; 
   left: 650px; 
   right:300px;
   width: 30%; 
   color:black;
}
.textarea
{
float:right;
}

 </style>
</head>
<body ng-app="Myapp">
<div class="maincontainer" id="side-nav" ><!--start of main container-->


   <nav id="nav" class="navbar navbar-inverse navbar-fixed-top"
    data-target=".navbar">
  <div class="contianer-fluid">
  
  
   <div class="navbar-header">
    
    <button type="button" class="navbar-toggle" data-toggle="collapse"
     data-target="#test">
     <span class="icon-bar"></span> 
     <span class="icon-bar"></span> 
     <span class="icon-bar"></span>
    </button>
   <a  class="navbar-brand active" href="#carousel">Welcome to
     Uttarakhand..</a>
  <a ></a>
 <a ></a>
  <a ></a>
   </div>

   <div class="collapse navbar-collapse" id="test">
    <ul class="nav navbar-nav" role="tablist" id="navg">
     
     <li><a href="#home"  >ABOUT UTTARAKHAND</a></li>
     <li><a href="#tour" >TOUR</a></li>
     <li><a href="#adventure">ADVENTURE</a></li>
      <li><a href="#gallery">GALLERY</a></li>
     <li><a href="#contact">CONTACT US</a></li>
     <li><a href="#comments">COMMENTS</a></li>
    </ul>
   </div>
  </div>
  </nav> 
		<!--end of nav-->

<!--carousel-->

<div ng-view="">   </div>

<!-- end of carousel -->
<footer >

  <p>Contact information: <a href="mailto:negi.shewani@gmail.com">
  negi.shewani@gmail.com</a>.</p>
</footer>
</div><!--end of main container-->

</body>
</html>