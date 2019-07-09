<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><dec:title default="Trang chủ" /></title>
	
	<!-- css -->
	<link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
	<link href="<c:url value='/template/web/css/slider.css' />" rel="stylesheet" type="text/css" media="all"/>
	<link href="<c:url value='/template/web/css/custom.css' />" rel="stylesheet" type="text/css" media="all"/>
	
	<!-- jquery -->
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery-1.7.2.min.js' />"></script>
	
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
	
	<script src="<c:url value="/template/web/js/paging/jquery.twbsPagination.js"/>" type="text/javascript"></script>
		
</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/common/web/header.jsp" %>
		<!-- header -->		
		<dec:body/>
	</div>
	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	
	<script type="text/javascript">
		$(document).ready(function () {
			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop">
		<span id="toTopHover"> </span>
	</a>
	
	<!-- javascript -->
	<script type="text/javascript" src="<c:url value='/template/web/js/move-top.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/easing.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/startstop-slider.js' />"></script>
	
</body>
</html>