<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	function showTime() {
		var dat = new Date();
		var H = '' + dat.getHours();
		H = H.length < 2 ? '0' + H : H;
		var M = '' + dat.getMinutes();
		M = M.length < 2 ? '0' + M : M;
		var S = '' + dat.getSeconds();
		S = S.length < 2 ? '0' + S : S;
		var clock = H + ':' + M + ':' + S;
		document.getElementById('time_div').innerHTML = clock;
		setTimeout(showTime, 1000);
	}
</script>

<div class="container-fluid cm-container-white">
	<div class="panel panel-default demo-icons">
		<div class="panel-heading">
			<h2>
				<strong>Online Courses</strong> - Spring Based Web Application !
			</h2>
		</div>

		<div class="panel-body">
			<p class="text-center">
				Current time: <strong><span id="time_div"><script
							type="text/javascript">
					showTime();
				</script></span></strong> <br />
				Pellentesque habitant morbi tristique senectus et netus et malesuada
				fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae,
				ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam
				egestas semper. Aenean ultricies mi vitae est. Mauris placerat
				eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
				Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit
				amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros
				ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim
				in turpis pulvinar facilisis. Ut felis.
			</p>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row cm-fix-height">
		<c:forEach begin="1" end="9" var="item">
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<img
							src="${pageContext.request.contextPath}/resources/img/sass-less.png"
							alt="Less support" class="img-responsive"> <br>
						<p>Clearmin ships with vanilla CSS, but its source code
							utilizes Less CSS preprocessor. Quickly get started with
							precompiled CSS or build on the source. Colors and sizes are
							easily customizable with less variables.</p>
						<div class="pull-right">
							<a href="${pageContext.request.contextPath}/course/${item}"
								class="btn btn-midnight">${item}. Show more -></a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>