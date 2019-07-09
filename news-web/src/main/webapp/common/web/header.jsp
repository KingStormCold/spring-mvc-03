<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header">
			<div class="headertop_desc">
				<div class="account_desc">
					<ul>
						<security:authorize access="isAnonymous()">
							<li>
								<a href="#">Đăng ký</a>
							</li>
							<li>
								<a href='<c:url value="/dang-nhap"/>'>Đăng nhập</a>
							</li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li>
								<a href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a>
							</li>
							<li>
								<a href='<c:url value="/logout"/>'>Thoát</a>
							</li>
						</security:authorize>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="header_top">
				<div class="logo">
					<a href="#">
						<img src="<c:url value='/image/logo-header.png' />" alt="">
					</a>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents: function () {
							var obj = this;

							obj.dd.on('click', function (event) {
								$(this).toggleClass('active');
								event.stopPropagation();
							});
						}
					}

					$(function () {

						var dd = new DropDown($('#dd'));

						$(document).click(function () {
							// all dropdowns
							$('.wrapper-dropdown-2').removeClass('active');
						});

					});
				</script>
				<div class="clear">

				</div>
			</div>
			<div class="header_bottom">
				<div class="menu">
					<ul>
						<li class="active">
							<a href='<c:url value="/trang-chu"/>'>Trang chủ</a>
						</li>
						<li>
							<a href="#">Gioi thiệu</a>
						</li>
						<li>
							<a href="#">Liên hệ</a>
						</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>

</div>