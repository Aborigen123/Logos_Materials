<div class="container-fluid">
	<div class="row cm-fix-height">
		<div class="col-sm-offset-2 col-lg-8 col-sm-8 col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading">Register Form</div>
				<div class="panel-body">
					<form class="form-horizontal"
						action="${pageContext.request.contextPath}/register" method="POST">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									name="email" placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputLogin3" class="col-sm-2 control-label">Login</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputLogin3"
									name="login" placeholder="Login">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3"
									name="password" placeholder="Password">
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Role</label>
							<div class="col-sm-10">
								<select class="form-control" id="inputPassword3" name="role">
									<option>STUDENT</option>
									<option>TEACHER</option>
								</select>
							</div>
						</div>

						<div class="form-group" style="margin-bottom: 0">
							<div class="col-sm-offset-2 col-sm-10 text-right">
								<button type="reset" class="btn btn-default">Reset
									fields</button>
								<button type="submit" class="btn btn-primary">Sign Up</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>