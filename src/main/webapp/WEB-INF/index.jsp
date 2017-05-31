
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>home</title>
<meta name="google-signin-client_id" content="30081514308-nsdkis6qpuda4f9vr2mb2d3aeg0otqgq.apps.googleusercontent.com">
  <script src="https://apis.google.com/js/platform.js" async defer></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>


<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 
</head>
<body>

   <div id="snackbar">${invalid}${norecord}</div>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#" class="brand-logo"><span style="font-family: "Comic Sans MS";">DISCUSSION FORUM</span></a>
  
      <ul class="right hide-on-med-and-down">
     <li><a href="#modal1">Login</a></li>
        <li><a href="a">About</a></li>
        <li><a href="a">Contact Us</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#modal1">Login</a></li>
        <li><a href="a">About</a></li>
        <li><a href="a">Contact Us</a></li>
      </ul>
      <a href="a" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <div id="modal1" class="modal">
				<div class="modal-content">
					<div class="card col s6 offset-s3"
						style="margin-top: 20px; padding: 20px;">
						<div class="card-content" align="center">
							<p style="font-size: 30px; color: #0572d2;">GET STARTED</p>
						</div>
						<div class="card-tabs">
							<ul class="tabs tabs-fixed-width"
								style="background: rgba(255, 255, 255, .7);">
								<li class="tab" onclick="indicator();"><a class="active"
									href="#login_form" style="color: #1E88E5;">Login</a></li>
								<li class="tab" onclick="indicator();"><a
									href="#signup_form" style="color: #1E88E5;">Sign Up</a></li>
							</ul>
						</div>
						<div class="card-content " id="cards" style="margin-top: 0;">
							<div id="login_form">
								<form action="login" method="POST">
									<div class="input-field col s10 offset-s1">
										<input type="text" id="username" name="id" required> <label
											for="email">Email</label>
									</div>

									<div class="input-field col s10 offset-s1">
										<input type="password" id="pass" name="pass" required>
										<label for="pass">Password</label>
									</div>
									<div align="center">
										<button type="submit"
											class="waves-effect waves-light btn blue"
											style="margin-bottom: 0;">Submit</button>
									</div>
								</form>
							</div>
							<div id="signup_form">
								<form action="signup" method="post">
									<div class="input-field col s10 offset-s1">
										<input type="text" name="name" id="team" required>
										<label for="team">Name</label>
									</div>
									<div class="input-field col s10 offset-s1">
										<input type="text" name="email"
											id="participant1_name" required> <label
											for="participant1_name">Email</label>
									</div>
									
									
									<div class="input-field col s10 offset-s1">
										<input type="text" name="contact"
											id="participant2_name" required> <label
											for="participant2_name">Contact</label>
									</div>
									
									<div class="input-field col s10 offset-s1">
										<input type="password" name="password" id="password" required>
										<label for="password">Password</label>
									</div>
									<div align="center">
										<button type="submit"
											class="waves-effect waves-light btn blue"
											style="margin-bottom: 0;">Submit</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
  <!--  Scripts-->
  
  <script src="js/init.js"></script>
  <script>
	function indicator() {
		$(".indicator").css("background", "#1E88E5");
	}
	function snackBar() {
		var x = document.getElementById("snackbar")
		if ($('#snackbar').is(':empty')) {
			return;
		} else {
			x.className = "show";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 3000);
		}
	}
	$(function() {
		indicator();
		snackBar();
	});
	$(document).ready(function() {
		$(".indicator").css("background", "#1E88E5");
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
	});
	$('.modal').modal({
		dismissible : true, // Modal can be dismissed by clicking outside of the modal
		opacity : .5, // Opacity of modal background
		inDuration : 300, // Transition in duration
		outDuration : 200, // Transition out duration
		startingTop : '4%', // Starting top style attribute
		endingTop : '10%', // Ending top style attribute
		ready : function(modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
			alert("Ready");
			console.log(modal, trigger);
		},
		complete : function() {
			alert('Closed');
		} // Callback for Modal close
	});
	$('#modlbtn').on('click', function() {
		indicator();
	});
</script>
  
 
 </body>
 <style>

h1 {
	margin-top: 180px;
	margin-bottom: 50px;
	font-size: 70px;
	color: #fff;
}
#login_form, #signup_form {
	padding: 20px 45px;
}
#login_form h3 {
	font-size: 30px;
	margin: 0;
}
#cards button {
	margin-top: 10px;
	margin-bottom: 15px;
}
#cards {
	padding: 0;
	margin-top: 50px;
}
.indicator {
	background: #1E88E5;
}
#mdlbtn {
	/* 	margin-top:300px; */
	
}
/* snackbar */
/* The snackbar - position it at the bottom and in the middle of the screen */
#snackbar {
	visibility: hidden; /* Hidden by default. Visible on click */
	min-width: 250px; /* Set a default minimum width */
	margin-left: -125px; /* Divide value of min-width by 2 */
	background-color: #333; /* Black background color */
	color: #fff; /* White text color */
	text-align: center; /* Centered text */
	border-radius: 2px; /* Rounded borders */
	padding: 16px; /* Padding */
	position: fixed; /* Sit on top of the screen */
	z-index: 1; /* Add a z-index if needed */
	left: 50%; /* Center the snackbar */
	bottom: 100px; /* 30px from the bottom */
}
/* Show the snackbar when clicking on a button (class added with JavaScript) */
#snackbar.show {
	visibility: visible; /* Show the snackbar */
	/* Add animation: Take 0.5 seconds to fade in and out the snackbar. 
However, delay the fade out process for 2.5 seconds */
	-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}
/* Animations to fade the snackbar in and out */
@
-webkit-keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}
to {
	bottom: 30px;
	opacity: 1;
}
}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}
to {
	bottom: 30px;
	opacity: 1;
}
}
@
-webkit-keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}
to {
	bottom: 0;
	opacity: 0;
}
}
@
keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}
to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</html>