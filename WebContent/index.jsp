<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page......</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		var fname = $('#fname').val();
		var lname = $('#lname').val();
		var uid = $('#uid').val();
		var pwd = $('#pwd').val();
		var email = $('#email').val();

		var user = {

			fname : $('#fname').val(),
			lname : $('#lname').val(),
			uid : $('#uid').val(),
			pwd : $('#pwd').val(),
			email : $('#email').val()
		};

		$.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "register",

			data : JSON.stringify(user),
			dataType : 'json',

			success : function(data, textStatus) {
				// alert('request successful');
			},
			error : function(xhr, textStatus, errorThrown) {
				window.location
						.replace("http://localhost:8080/SpringTest/login.jsp");

			}
		});

	}
</script>

</head>
<body>
<br /><br /><br /><br /><br /><br /><br />
	<div style="background-color: #9ECAD0;">
		</br>
		<div align="center"
			style="background-color: #999999; height: 4em; width: 100%">
			<h1>
				<font color="#FFFFFF">Registration Page</font>
			</h1>
		</div>
		<br />
		<table border="2" align="center" cellpadding="3" cellspacing="4">
			
			<tbody bgcolor="#CCCCCC">
				<tr>
					<th>First Name:</th>
					<td><input type="text" id="fname"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" id="lname"></td>
				</tr>
				<tr>
					<th>UserId:</th>
					<td><input type="text" id="uid"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" id="pwd"></td>
				</tr>
				<tr>
					<th>EmailId:</th>
					<td><input type="text" id="email"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" style="font-size: large;" onclick="doAjaxPost();"
						value="submit" /></td>
				</tr>
			</tbody>
		</table>
		<br /><br />
	</div>
</body>
</html>