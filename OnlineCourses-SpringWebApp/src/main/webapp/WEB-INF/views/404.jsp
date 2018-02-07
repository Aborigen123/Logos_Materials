<jsp:include page="/WEB-INF/fragments/style-include.jsp" />
<br/>
<div class="container">
	<div class="panel panel-default demo-icons">
		<div class="panel-heading">
			<h2>404 Not Found</h2>
		</div>
		<div class="panel-body">
			<div class="text-center">
				<i class="fa fa-5x fa-frown-o" style="color: #d9534f;"></i>
			</div>
			<h1 class="text-center">
				<p>
					<small class="text-center"> Oh does everything broke</small>
				</p>
			</h1>
			<p class="text-center">Try clicking on this button.</p>
			<p class="text-center">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath }/"><i
					class="fa fa-home"></i> Take Me Home</a>
			</p>

		</div>
	</div>
</div>