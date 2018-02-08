<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<nav class="cm-navbar cm-navbar-midnight">
	<div class="btn btn-yellow md-menu-white hidden-md hidden-lg"
		data-toggle="cm-menu"></div>
	<div class="cm-flex">
		<h1>Home</h1>
	</div>
	<div class="dropdown pull-right">
		<button class="btn btn-midnight md-shopping-cart-white"
			data-toggle="dropdown">
			<span class="label label-danger">2</span>
		</button>
		<div class="popover cm-popover bottom">
			<div class="arrow"></div>
			<div class="popover-content">
				<div class="list-group">
					<a href="#" class="list-group-item">
						<h4 class="list-group-item-heading text-overflow">
							<i class="fa fa-fw fa-plus"></i> Nunc volutpat aliquet magna.
						</h4>
						<p class="list-group-item-text text-overflow">Pellentesque
							tincidunt mollis scelerisque. Praesent vel blandit quam.</p>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">
							<i class="fa fa-fw fa-plus"></i> Aliquam orci lectus
						</h4>
						<p class="list-group-item-text">Donec quis arcu non risus
							sagittis</p>
					</a>
				</div>
				<div style="padding: 10px">
					<a class="btn btn-success btn-block" href="#">Go to shopping
						card...</a>
				</div>
			</div>
		</div>
	</div>
	<div class="dropdown pull-right">
		<button class="btn btn-midnight md-account-box-white"
			data-toggle="dropdown"></button>
		<ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-fw fa-sign-in"></i> Login</a></li>
			<li class="divider"></li>

			<li><a href="${pageContext.request.contextPath}/register"><i class="fa fa-fw fa-sign-out"></i>
					Register</a></li>
		</ul>
	</div>
	<div class="dropdown pull-right">
		<button class="btn btn-midnight md-account-circle-white"
			data-toggle="dropdown"></button>
		<ul class="dropdown-menu">
			<li class="disabled text-center"><a style="cursor: default;"><strong>John
						Smith</strong></a></li>
			<li class="divider"></li>
			<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
			<li><a href="#"><i class="fa fa-fw fa-cog"></i> Settings</a></li>
			<li><a href="login.html"><i class="fa fa-fw fa-sign-out"></i>
					Sign out</a></li>
		</ul>
	</div>
</nav>
