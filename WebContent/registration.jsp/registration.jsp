<%@page import="constant.LoginConstant" %>
<!DOCTYPE html>
<html lang="en">
<%
	String url = request.getRequestURL().toString();
	String baseURL = url.substring(0, url.length() - request.getRequestURI().length())
			+ request.getContextPath() + "/";
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="msapplication-tap-highlight" content="no">
<meta name="description"
	content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
<meta name="keywords"
	content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
<title>Registartion</title>

<!-- Favicons-->
<link rel="icon" href="<%=baseURL%>images/favicon/favicon-32x32.png"
	sizes="32x32">
<!-- Favicons-->
<link rel="apple-touch-icon-precomposed"
	href="images/favicon/apple-touch-icon-152x152.png">
<!-- For iPhone -->
<meta name="msapplication-TileColor" content="#00bcd4">
<meta name="msapplication-TileImage"
	content="images/favicon/mstile-144x144.png">
<!-- For Windows Phone -->


<!-- CORE CSS-->

<link href="<%=baseURL%>css/materialize.min.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link href="<%=baseURL%>css/style.min.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<!-- Custome CSS-->
<link href="<%=baseURL%>css/custom/custom.min.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link href="<%=baseURL%>css/layouts/page-center.css" type="text/css"
	rel="stylesheet" media="screen,projection">

<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="<%=baseURL%>js/plugins/prism/prism.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link
	href="<%=baseURL%>js/plugins/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="screen,projection">
  <link href="<%=baseURL%>js/plugins/dropify/css/dropify.min.css" type="text/css" rel="stylesheet" media="screen,projection">

</head>

<body class="cyan">
	<!-- Start Page Loading -->
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<!-- End Page Loading -->



	<div id="login-page" class="row">
		<h4 class="header">Registration</h4>
		<div class="col s12  card-panel">
			<form class="login-form" method="get" action="<%=baseURL%>Registration">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="first_name" type="text" name="<%=LoginConstant.FIRST_NAME %>"
							class="validate" required="required"> <label for="first_name" class="active">First
							Name</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate" name="<%=LoginConstant.LAST_NAME %>" required="required"> <label
							for="last_name" >Last Name</label>
					</div>
				</div>


				<div class="row">

					<div class="input-field col s12">
						<select name="<%=LoginConstant.USER_TYPE %>" required="required"> 
							<option value="" disabled selected>Choose your option</option>
							<option value="1">Student</option>
							<option value="2">Trainer</option>
							<option value="3">Principal</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="first_name" type="text" name="<%=LoginConstant.STREET%>" required="required"
							class="validate"> <label for="first_name" class="active">Street</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate" name="<%=LoginConstant.CITY %>" required="required" > <label
							for="last_name">City</label>
					</div>
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="first_name" type="text" name="<%=LoginConstant.STATE %>" required="required"
							class="validate"> <label for="first_name" class="active">State</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate" name="<%=LoginConstant.ZIPCODE%>" required="required"> <label
							for="last_name">Zipcode</label>
					</div>
				</div>
		<button type="submit" class="waves-effect waves-light btn-large " text="submit">Submit</button>			</form>
<!--Default version-->
						<form action="<%=baseURL%>BulkRegister" method="post"
                        enctype="multipart/form-data">
          <div id="file-upload" class="section">

            <div class="row section">
              <div class="col s12 m4 l3">
                 <p>Default version</p>
              </div>
              <div class="col s12 m8 l9">
                  <input type="file" id="input-file-now" name="<%=LoginConstant.FILE %>" class="dropify" data-default-file="" />
              </div>
            </div>
</div>
		<button type="submit" class="waves-effect waves-light btn-large " text="submit">Submit</button>			</form>

</form>
            <!--Default value-->
	
	
		</div>
		
		
	</div>





	<!-- ================================================
    Scripts
    ================================================ -->

	<!-- jQuery Library -->
	<script type="text/javascript"
		src="<%=baseURL%>js/plugins/jquery-1.11.2.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="<%=baseURL%>js/materialize.min.js"></script>
	<!--prism-->
	<script type="text/javascript"
		src="<%=baseURL%>js/plugins/prism/prism.js"></script>
	<!--scrollbar-->
	<script type="text/javascript"
		src="<%=baseURL%>js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="<%=baseURL%>js/plugins/dropify/js/dropify.min.js"></script>

	<!--plugins.js - Some Specific JS codes for Plugin Settings-->
	<script type="text/javascript" src="<%=baseURL%>js/plugins.min.js"></script>
	<!--custom-script.js - Add your own theme custom JS-->
	<script type="text/javascript" src="<%=baseURL%>js/custom-script.js"></script>
  <script type="text/javascript">
        $(document).ready(function(){
            // Basic
            $('.dropify').dropify();

            // Translated
            $('.dropify-fr').dropify({
                messages: {
                    default: 'Glissez-déposez un fichier ici ou cliquez',
                    replace: 'Glissez-déposez un fichier ou cliquez pour remplacer',
                    remove:  'Supprimer',
                    error:   'Désolé, le fichier trop volumineux'
                }
            });

            // Used events
            var drEvent = $('.dropify-event').dropify();

            drEvent.on('dropify.beforeClear', function(event, element){
                return confirm("Do you really want to delete \"" + element.filename + "\" ?");
            });

            drEvent.on('dropify.afterClear', function(event, element){
                alert('File deleted');
            });
        });
    </script>
</body>

</html>