
<jsp:include page="header.jsp"></jsp:include>
<br>
<center>
<h2>Welcome To Deliveria Official Website</h2>
</center>
<p>
	<br>

	<% if(session.getAttribute("role") != null) {
			if(session.getAttribute("role").equals("admin")) {
	%>
				administrator.
	<% 
			}
			else if(session.getAttribute("role").equals("user")){ %>
				user.
	<%		}
		} %>
</p>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>

.b{
	width = 10px;
	height = 10px;
}


</style>

<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel" align = "center">
    <!-- Carousel indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for carousel items -->
    <div class="carousel-inner">
        <div class="carousel-item active" >
            <img src="h.jpg" alt="First Slide" class="b">
        </div>
        <div class="carousel-item">
            <img src="g.jpg" alt="Second Slide" >
        </div>
        <div class="carousel-item">
            <img src="i.jpg" alt="Third Slide">
        </div>
    </div>
    <!-- Carousel controls -->
    <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>

<br>
<script>
$(document).ready(function(){
        $("#myCarousel").carousel();
});
</script>
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3><b>Vision</b></h3>
      <p>Our vision is to become the best courier service company.</p>
      <p>providing the best delivering service to our belove customers.</p>
    </div>
    <div class="col-sm-4">
      <h3><b>Mission</b></h3>
      <p>Our mission more focusing to deliver the item safely to the receiver.</p>
      <p>Best courier service in the world</p>
    </div>
    <div class="col-sm-4">
      <h3><b>Company Background</b></h3>        
      <p> Build in January 2021 and already run the business about one days.</p>
      <p> We have 3 branches now at Pulau Pinang, Kedah, Selangor</p>
    </div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>