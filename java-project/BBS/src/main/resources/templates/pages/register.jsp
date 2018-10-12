
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="/doRegister" method="post">
		<input type="hidden" name="md" value="doRegister">
		<table border="0" align="center">
			<tr>
				<td>账号:</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="repassword"></td>
			</tr>
			<tr>
				<td>nickname:</td>
				<td><input type="text" name="nickname"></td>
			</tr>
			<tr>
				<td>生日:</td>
				<td><input type="text" name="birthday"></td>

			</tr>
			<tr>
				<td>性别：</td>
				<td>男<input type="radio" name="gender" value="m"> 女<input
					type="radio" name="gender" value="f">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册"></td>
			</tr>

		</table>

	</form>
</body>
</html>