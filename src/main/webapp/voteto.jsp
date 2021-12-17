<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="swu.doom.character.Character" %>
<%@ page import="swu.doom.DBUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>投票系统 &mdash; Free VoteSystem Website by Doom</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="FreeHTML5.co" />


	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	
	</head>
	<body>
	<div id="fh5co-page">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary" class="border js-fullheight">

			<h1 id="fh5co-logo"><a href="index.html">投票系统</a></h1>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
					<li><a href="index.html">网站主页</a></li>
					<li><a href="voteproject.html">投票项目</a></li>
					<li><a href="voteto.html">参与投票</a></li>
					<li><a href="about.html">关于作者</a></li>
					<li ><a href="login.html">登陆注册</a></li>
				</ul>
			</nav>

			<div class="fh5co-footer">
				<p><small>&copy; 2021javaweb课程项目.</span> <span>Designed by 杜中华&nbsp;<a href="https://github.com/Lemy28" target="_blank">My GitHub</a> </span></small></p>
			</div>


		</aside>



		<div id="fh5co-main">
			<div class="fh5co-narrow-content">
				<h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">最受欢迎动漫人物</h2>
				<div class="row row-bottom-padded-md"  style="padding:56px 0 0 0">
						
						<%		
								String end ="</span></div></a></div>";
								String sql = "SELECT * FROM characters ORDER BY votes DESC LIMIT 8";
								List<Character> characters = DBUtils.getCharacters(sql);
	
								for(Character character : characters) {
									StringBuilder front = new StringBuilder();
									front.append( 
										String.format(	"<div class=\"col-md-3 col-sm-6 col-padding text-center animate-box\"><a href='./vote?id=%s' class=\"work image-popup\" style=\"background-image: ",character.getId())
											);
									front.append("url(imgs/").append(character.getPics().replaceAll(",", "")).append(");\"><div class=\"desc\"><h2>");
									out.println(front+character.getName() + "</h2><span>年龄："+character.getAge()+"</span>"+"<span>能力："+character.getAbility()+"</span>"+"<span>来自："+character.getWorks()+"</span>"+"<br><br><span>票数："+character.getVotes()+end);

								}%>
						
						
						
				</div>
				
				<div class="row row-bottom-padded-md"   id="characterDiv">
						
				</div>
							
			</div>
			<center><button onclick="showCharacters('1')">展示所有</button></center>
		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	
	<script  type="text/javascript">
	
   		 function showCharacters(page) {
   			$.ajax({
	            url: "./characters?page=" + page,
	            method: "GET",
	            dataType: "json"
	        }).done(function(result){
	        	updateCharacterTable(result.characters);
	        	hidebutton();
	        }).fail(function(xhr, status){
	            console.log(status);
	        });
	
	        console.log("button clicked!");
	    }
	
	    function updateCharacterTable(characters) {
	        var d = $("#characterDiv");
			
	        for (var i=0; i<characters.length; i++) {
	            var c = characters[i];
	            var block = $("<div class=\"col-md-3 col-sm-6 col-padding text-center animate-box fadeInUp animated\"></div>");
  	            block.append("<a href=\"./vote?id="+ c.id +  "\"class=\"work image-popup\" style=\"background-image: url(imgs/" + c.pics +");\" ><div class=\"desc\"><h2>" + c.name+"</h2><span>年龄：" + c.age +"</span>"+"<span>能力："+ c.ability+"</span>"+"<span>来自："+ c.works  +"</span>"+"<br><br><span>票数：" + c.votes+"</span></div></a>")

	            d.append(block);
	        }
	        
	    }
	    
	    function hidebutton(){
	    	$('button').hide();
	    }
	
	</script>










	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	
	
	<!-- MAIN JS -->
	<script src="js/main.js"></script>
	
	
	
	
	</body>
</html>