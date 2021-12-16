<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="swu.doom.character.Character" %>
<%@ page import="swu.doom.DBUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
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

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">
	
	<link rel="stylesheet" type="text/css" href="css/box.css" />
	
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
			<aside id="fh5co-hero" class="js-fullheight">
				<div class="flexslider js-fullheight">
					<ul class="slides">
				   	<li style="background-image: url(images/img_bg_1.jpg);">
				   		<div class="overlay"></div>
				   		<div class="container-fluid">
				   			<div class="row">
					   			<div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
					   				<div class="slider-text-inner">
					   					<h1>欢迎来到投票系统</h1>
					   					<h2>发起新的投票？请 <a href="./login">联系作者</a></h2>
											<p><a class="btn btn-primary btn-demo popup-vimeo" href="https://vimeo.com/channels/staffpicks/93951774"> <i class="icon-monitor"></i> 选择项目</a> <a class="btn btn-primary btn-learn">开始投票<i class="icon-arrow-right3"></i></a></p>
					   				</div>
					   			</div>
					   		</div>
				   		</div>
				   	</li>
				   	<li style="background-image: url(images/img_bg_2.jpg);">
				   		<div class="overlay"></div>
				   		<div class="container-fluid">
				   			<div class="row">
					   			<div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
					   				<div class="slider-text-inner">
					   					<h1>马上登录</h1>
											<h2>还没有帐号？ <a href="http://freehtml5.co/" target="_blank">立即注册</a></h2>
											<p><a class="btn btn-primary btn-demo popup-vimeo tiyan" href="javascript:;" > <i class="icon-monitor"></i> 立即登录</a> <a class="btn btn-primary btn-learn">开始投票<i class="icon-arrow-right3"></i></a></p>
					   				</div>
					   			</div>
					   		</div>
				   		</div>
				   	</li>
				   	<li style="background-image: url(images/img_bg_3.jpg);">
				   		<div class="overlay"></div>
				   		<div class="container-fluid">
				   			<div class="row">
					   			<div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
					   				<div class="slider-text-inner">
					   					<h1>开始投票吧！</h1>
											<h2>赞助作者→ <a href="http://freehtml5.co/" target="_blank">开玩笑的</a></h2>
											<p><a class="btn btn-primary btn-demo popup-vimeo" href="https://vimeo.com/channels/staffpicks/93951774"> <i class="icon-monitor"></i> 选择项目</a> <a class="btn btn-primary btn-learn">开始投票<i class="icon-arrow-right3"></i></a></p>
					   				</div>
					   			</div>
					   		</div>
				   		</div>
				   	</li>
				  	</ul>
			  	</div>
			</aside>
			
			<div class="fh5co-narrow-content">
				<h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">服务项目</h2>
				<div class="row">
					<div class="col-md-6">
						<div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
							<div class="fh5co-icon">
								<i class="icon-settings"></i>
							</div>
							<div class="fh5co-text">
								<h3>参与投票</h3>
								<p>在这里，你可以参与管理员发起的投票</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
							<div class="fh5co-icon">
								<i class="icon-search4"></i>
							</div>
							<div class="fh5co-text">
								<h3>发起投票</h3>
								<p>想发起投票？可以联系管理员新建投票项目</p>
							</div>
						</div>
					</div>

					
				</div>
			</div>
			<div class="fh5co-narrow-content">
				<h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">最近投票</h2>
				<div class="row row-bottom-padded-md">
					<div class="col-md-3 col-sm-6 col-padding animate-box" data-animate-effect="fadeInLeft">
						<div class="blog-entry">
							<a href="#" class="blog-img"><img src="images/img-1.jpg" class="img-responsive" alt="Free HTML5 Bootstrap Template by FreeHTML5.co"></a>
							<div class="desc">
								<h3><a href="#">Inspirational Website</a></h3>
								<span><small>by Admin </small> / <small> Web Design </small> / <small> <i class="icon-comment"></i> 14</small></span>
								<p>Design must be functional and functionality must be translated into visual aesthetics</p>
								<a href="#" class="lead">Read More <i class="icon-arrow-right3"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-padding animate-box" data-animate-effect="fadeInLeft">
						<div class="blog-entry">
							<a href="#" class="blog-img"><img src="images/img-2.jpg" class="img-responsive" alt="Free HTML5 Bootstrap Template by FreeHTML5.co"></a>
							<div class="desc">
								<h3><a href="#">Inspirational Website</a></h3>
								<span><small>by Admin </small> / <small> Web Design </small> / <small> <i class="icon-comment"></i> 14</small></span>
								<p>Design must be functional and functionality must be translated into visual aesthetics</p>
								<a href="#" class="lead">Read More <i class="icon-arrow-right3"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-padding animate-box" data-animate-effect="fadeInLeft">
						<div class="blog-entry">
							<a href="#" class="blog-img"><img src="images/img-3.jpg" class="img-responsive" alt="Free HTML5 Bootstrap Template by FreeHTML5.co"></a>
							<div class="desc">
								<h3><a href="#">Inspirational Website</a></h3>
								<span><small>by Admin </small> / <small> Web Design </small> / <small> <i class="icon-comment"></i> 14</small></span>
								<p>Design must be functional and functionality must be translated into visual aesthetics</p>
								<a href="#" class="lead">Read More <i class="icon-arrow-right3"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 col-padding animate-box" data-animate-effect="fadeInLeft">
						<div class="blog-entry">
							<a href="#" class="blog-img"><img src="images/img-4.jpg" class="img-responsive" alt="Free HTML5 Bootstrap Template by FreeHTML5.co"></a>
							<div class="desc">
								<h3><a href="#">Inspirational Website</a></h3>
								<span><small>by Admin </small> / <small> Web Design </small> / <small> <i class="icon-comment"></i> 14</small></span>
								<p>Design must be functional and functionality must be translated into visual aesthetics</p>
								<a href="#" class="lead">Read More <i class="icon-arrow-right3"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="get-in-touch">
				<div class="fh5co-narrow-content">
					<div class="row">
						<div class="col-md-4 animate-box" data-animate-effect="fadeInLeft">
							<h1 class="fh5co-heading-colored">此网站用于？</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<p class="fh5co-lead">西南大学2020级网络工程专业学生杜中华的课程设计</p>
							<p><a href="./about.html#" class="btn btn-primary">了解更多</a></p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	
<!--弹窗开始-->
<div class="tan" >
	<div class="box">
		<div class="form">
			<span class="close">✖</span>
			<h3>欢迎来到投票系统</h3>
			<p class="desc">参加投票前请在此登录</p>
			<form action="" onSubmit="return false;">
				<input type="text" name="name" id="name" placeholder="请输入邮箱地址" />
				<input type="password" name="password" id="passw" placeholder="请输入密码" />
				<div class="valicode">
					<input type="text" name="valicode" id="valicode" placeholder="请输入验证码" />
					<img src="./validateCode" />
				</div>
				<div class="error"></div>
				<input type="submit" id="Submit" value="登录">
			</form>
			<p class="reg">
				<a href="#">立即注册</a>
			</p>
		</div>
	</div>
</div>
<!--弹窗结束-->
<script src="js/box.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		//弹窗
		$('.tiyan').click(function() {
			$('.tan').show();
		})
		//关闭
		$('.close').click(function() {
			$('.tan').hide();
		})
		//触焦变色
		$("input").focus(function() {
			$(this).removeClass('red');
		});
		//失去焦点验证当前表单

		$("#name").blur(function() {

			var emailreg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
			var errtxt = "",
				name = $('#name').val();
			if(name == "") {
				errtxt = "邮箱地址不能为空";
				$('#name').addClass('red');
			} else if((!emailreg.test(name))) {
				errtxt = "请输入正确邮箱地址";
				$('#name').addClass('red');
			}else{
				errtxt = "";
				$('#name').removeClass('red');
			}
			//错误提示消息，有错误则显示，没错误就隐藏
			showmsg(errtxt);
		})
		$("#passw").blur(function() {
			var errtxt = "",
				passw = $('#passw').val();
			if(passw == "") {
				errtxt = "请输入密码";
				$('#passw').addClass('red');
			}else{
				errtxt = "";
				$('#passw').removeClass('red');
			}
			//错误提示消息，有错误则显示，没错误就隐藏
			showmsg(errtxt);
		})
		$("#valicode").blur(function() {
			var errtxt = "",
				valicode = $('#valicode').val();
			if(valicode == "") {
				errtxt = "请输入正确的验证码";
				$('#valicode').addClass('red');
			}else{
				errtxt = "";
				$('#valicode').removeClass('red');
			}
			//错误提示消息，有错误则显示，没错误就隐藏
			showmsg(errtxt);
		})
		//验证
		$('#Submit').click(function() {
			var thisid = "",
				errtxt = "";
			$('input').removeClass('red');
			var emailreg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; //邮箱正则
			var name = $('input[name=name]').val(),
				passw = $('input[name=password]').val(),
				valicode = $('input[name=valicode]').val();

			if(name == "") {
				errtxt = "邮箱地址不能为空";
				thisid = "name";
			} else if((!emailreg.test(name))) {
				errtxt = "请输入正确邮箱地址";
				thisid = "name";
			} else if(passw == "") {
				errtxt = "请输入密码";
				thisid = "passw";
			} else if(valicode == "") {
				errtxt = "请输入正确的验证码";
				thisid = "valicode";
			} else {

			}
			//错误提示消息，有错误则显示，没错误就隐藏
			showmsg(errtxt);
			//错误边框变红
			thisid ? $('input').removeClass('red').parents('form').find('#' + thisid).focus().addClass('red') : $('#' + thisid).removeClass('red');
		})

		function showmsg(errtxt) {
			errtxt ? $('.error').show().text(errtxt) : $('.error').hide();
		}
	})
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

