<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<%
	String url = request.getRequestURL().toString();
	String baseURL = url.substring(0, url.length() - request.getRequestURI().length())
			+ request.getContextPath() + "/";
	HashMap<String, String> button = new HashMap<>();
	button.put("Learn", "fa-mortar-board;" + baseURL + "mobile/partials/learn/learn.jsp");
	button.put("Coach", "fa-blind;" + baseURL + "mobile/partials/coach/coach.jsp");
	button.put("Event", "fa-calendar;" + baseURL + "mobile/partials/event/event.jsp");
	button.put("Notification", "fa-bell-o;" + baseURL + "mobile/partials/notification/notification.jsp");
	/* 			button.put("Job","fa-mortar-board");
	 */
	 
	 SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
%>
<head>
<!-- Required meta tags always come first -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Material Design for Bootstrap</title>
<link rel="stylesheet"
	href="<%=baseURL%>themes/mdbootstrap4/css/font-awesome.min.css">
<link href="<%=baseURL%>themes/mdbootstrap4/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=baseURL%>themes/mdbootstrap4/css/mdb.min.css"
	rel="stylesheet">
<link rel='stylesheet' id='Custom-css'
	href='<%=baseURL%>themes/mdbootstrap4/css/style.min.css?ver=4.5.3'
	type='text/css' media='all' />
<link rel='stylesheet' id='Prism-css'
	href='<%=baseURL%>themes/mdbootstrap4/css/prism.min.css?ver=4.5.3'
	type='text/css' media='all' />
<link rel='stylesheet' id='Style-css'
	href='<%=baseURL%>themes/mdbootstrap4/style.css?ver=4.5.3'
	type='text/css' media='all' />
<link rel="canonical" href="http://mdbootstrap.com/css/helpers/" />
<link rel="stylesheet"
	href="<%=baseURL%>themes/mdbootstrap4/js/rating/jquery.rateyo.min.css">
<script type='text/javascript'
	src='<%=baseURL%>themes/mdbootstrap4/js/jquery/jquery.js?ver=1.12.4'></script>
<script type='text/javascript'
	src='<%=baseURL%>themes/mdbootstrap4/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
<link rel="stylesheet"
	href="<%=baseURL%>jalendarPlugins/jalendar/style/jalendar.css"
	type="text/css" />

<link href="<%=baseURL%>metisMenu/metisMenu.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=baseURL%>metisMenu/demo.css" rel="stylesheet"
	type="text/css">

<style type="text/css">
.btn-sq-lg {
	width: 100%;
	margin: 0px !important;
}

.col-example123 {
	padding: 0px !important;
}

.col-example123 img {
	width: 100%;
}

.dashboard-font-size {
	font-size: 20pt;
}
</style>
</head>
<body data-spy="scroll" data-target="#scrollspy" data-offset="15">
	<ul id="slide-out"
		class="side-nav fixed default-side-nav light-side-nav" style="z-index:100 !important;">
		<div id="yourId3" class="jalendar zoomInDown animated" style="margin-top: 32%;"></div>

	</ul>
	<!--/.SideNav-->
	<!-- Navbar -->
	<!--Login Modal script -->
	<!-- Navbar-->
	<nav
		class="navbar navbar-fixed-top scrolling-navbar double-nav mdb-color">
		<!-- SideNav slide-out button -->
		<div class="pull-left">
			<a href="#" data-activates="slide-out" class="button-collapse"><i
				class="fa fa-bars"></i></a>
		</div>
		<!-- Breadcrumb-->
		<div class="breadcrumb-dn">
			<p>MDB latest versions: Free 4.0.1 | Pro 4.0.1</p>
		</div>
		<!--Navigation icons-->
		<ul class="nav-icons">
			<li><a href="#" class="" data-toggle="modal"
				data-target="#contactForm"><i class="fa fa-envelope-o"></i><br>
					<span>Contact</span></a></li>
			<li><a href="http://mdbootstrap.com/forums/forum/support/"
				class=""><i class="fa fa-comments-o"></i><br> <span>Support</span></a></li>
			<li><a href="http://mdbootstrap.com/account/" class=""><i
					class="fa fa-user"></i><br> <span>Account</span></a></li>
			<li><a
				href="http://mdbootstrap.com/wp-login.php?action=logout&amp;redirect_to=http%3A%2F%2Fmdbootstrap.com&amp;_wpnonce=40a56f9a15"
				class=""><i class="fa fa-sign-out"></i><br> <span>LogOut</span></a></li>
		</ul>
	</nav>
	<!-- /.Navbar-->
	<!--/. Navbar -->

	<!-- Main layout-->
	<main id="main-container">
	<div class="container" style="background: lightgray;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-example123">
				<img class="img-fluid" src="<%=baseURL%>images/dashboard_image.png"
					alt="Card image cap">
			</div>
			<div class="col-xs-12 col-sm-12">
				<div class="row">
				<%for(int i =0;i<20;i++){ %>
					<div class="col-md-6">

						<!--Panel-->
						<div class="card">
							<div class="card-header default-color-dark white-text">
								Featured</div>
							<div class="card-block">
								<h4 class="card-title">Special title treatment</h4>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<a class="btn btn-primary mainlink" href="<%=format1.format(new Date())%>/abc">Go somewhere</a>
							</div>
						</div>
						<!--/.Panel-->
					</div>
					<%} %>
				</div>
			</div>
		</div>

	</div>
	</main>

	<hr>



	<div id="dom-target-fb" style="display: none;"></div>
	<div id="dom-target-tw" style="display: none;"></div>
	<div id="dom-target-gp" style="display: none;"></div>

	<!-- jQuery Plugins Initialization -->
	<script src="<%=baseURL%>themes/mdbootstrap4/js/jquery-2.2.3.min.js"></script>
	<!-- Tooltips and Popups -->
	<script src="<%=baseURL%>themes/mdbootstrap4/js/tether.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script src="<%=baseURL%>themes/mdbootstrap4/js/bootstrap.min.js"></script>
	<!-- Material Design Bootsgtrap scripts -->
	<script src="<%=baseURL%>themes/mdbootstrap4/js/mdb.min.js"></script>
	<script src="<%=baseURL%>themes/mdbootstrap4/js/prism.min.js"></script>
	<script src="<%=baseURL%>themes/mdbootstrap4/js/jquery.validate.js"></script>
	<script src="<%=baseURL%>themes/mdbootstrap4/js/theme_scripts.js"></script>
	<script type="text/javascript"
		src="<%=baseURL%>jalendarPlugins/jalendar/js/jalendar.min.js"></script>
	<script src="<%=baseURL%>jalendarPlugins/jalendar/js/highlight.pack.js"></script>
	<script
		src="<%=baseURL%>themes/mdbootstrap4/js/rating/jquery.rateyo.min.js"></script>
	<script src="<%=baseURL%>themes/mdbootstrap4/js/custom.js"></script>

	<script type="text/javascript"
		src="<%=baseURL%>jalendarPlugins/jalendar/js/jalendar.min.js"></script>
	<script src="<%=baseURL%>metisMenu/metisMenu.min.js"></script>


	<script>
		// MDB Lightbox Init
		$(function() {
			$("#mdb-lightbox-ui")
					.load(
							"http://mdbootstrap.com/wp-content/themes/mdbootstrap4/mdb-addons/mdb-lightbox-ui.html");
		});
	</script>


	<script type="text/javascript">
		$(document).ready(
				function() {
					$(".button-collapse").sideNav();
					$('#yourId3').jalendar(
							{
								color : '#2196f3', // Unlimited
								color2 : '#2196f3',
							    type: 'selector',
								dateType : 'yyyy-mm-dd',
								 done: function() {
								        alert( $('#yourId3 input.data1').val() );
								        
								        $('.mainlink').each(function(){
								        	$(this).attr('href',$('#yourId3 input.data1').val() +'/abc');
								        	
								        });
								    }
							});
				});
	</script>




	<script type='text/javascript'
		src='<%=baseURL%>themes/mdbootstrap4/js/theme_scripts.js?ver=1.0.0'></script>
</html>