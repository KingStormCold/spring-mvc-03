<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><dec:title default="Login Page" /></title>
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace-rtl.min.css' />" />
    <dec:head />
    
</head>
<body class="login-layout">
		<div class="main-container">
				<div class="main-content">
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1">
							<div class="login-container">
								<div class="center">
									<h1>
										<i class="ace-icon fa fa-leaf green"></i>
										<span class="red">PTIT</span>
										<span class="white" id="id-text2">University</span>
									</h1>
									<h4 class="blue" id="id-company-text">&copy; PTIT TEAM</h4>
								</div>
								<div class="space-6"></div>
								
								<!-- begin body -->
									 <dec:body />
								<!-- close body -->
														
								<div class="navbar-fixed-top align-right">
									<br />
									&nbsp;
									<a id="btn-login-dark" href="#">Dark</a>
									&nbsp;
									<span class="blue">/</span>
									&nbsp;
									<a id="btn-login-blur" href="#">Blur</a>
									&nbsp;
									<span class="blue">/</span>
									&nbsp;
									<a id="btn-login-light" href="#">Light</a>
									&nbsp; &nbsp; &nbsp;
								</div>							
							</div>
						</div>
					</div>
				</div>
		</div>		
		<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>
</body>
</html>