<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
		 ul{
			background-color: #2f4f4f;
		 	margin: 0 auto;
			width: 100%;
			height: 50px;
			padding: 0px;
		}
		li{
			list-style-type: none;
			float: right;
		}
		a{
			display: block;
			width: 100px;
			height: 50px;
			font-family: Microsoft Yahei;
			line-height: 50px;
			background-color: #2f4f4f;
			margin: 0px 0px;
			color: #fff;
			text-align: center;
			text-decoration: none;
			font-size: 15px;
		}
		a:hover{
			background-color: #2f6f4f;
		}
	</style>
<title>投票系统主页</title>
</head>
<body style='background-color:#D2FFD2'>
<div float=right>
	<ul class=daohang>
		<li ><a href="#">首  页</a></li>
		<li><a href="./addcharacter.html">添  加</a></li>
		<li><a href="./backend">后  台</a></li>
		<li><a href="./login.html">登  录</a></li>
	</ul>
</div>
<div style='text-align:center;padding:0.7em'><h1>投票系统</h1></div>
<form action="POST" >
<input type="text" value=''>
<input type="submit" value='搜索'>
</form>


</body>
</html>