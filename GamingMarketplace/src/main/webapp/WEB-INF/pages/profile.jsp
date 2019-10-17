<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="/GamingMarketplace/resources/styles.css">
</head>
<body>

	<div class="display">
		<p>Welcome, ${username}</p>
		<table>
<!-- 		<table style="width:100%"> -->
			  <tr>
			    <th>Firstname</th>
			    <th>Lastname</th>
			    <th>Avatar</th>
			    <th>Coins</th>
			    <th>Minutes Played</th>
			  </tr>
			  <tr>
			    <td>${player.firstname}</td>
			    <td>${player.lastname}</td>
			    <td>${player.avatarFilename}</td>
			    <td>${player.coins}</td>
			    <td>${player.minutes}</td>
			  </tr>
			</table>
<!-- 		</table> -->
	</div>
	<div>
		<form action="/GamingMarketplace/logout" method="get">
			<fieldset>
				<input type="submit" value="logout" name = "logout"/>
			</fieldset>
		</form>
	</div>

</body>
</html>
--%>