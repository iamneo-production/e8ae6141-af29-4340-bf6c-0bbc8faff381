<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="http://localhost:8080/jspservlet-app-bmi-calculator/assets/style.css" /> 
		<title>BMI CALCULATOR</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
	<form action="/jspservlet-app-bmi-calculator/main" method="post">
		<div>
			<img id="headerimage" src="http://localhost:8080/jspservlet-app-bmi-calculator/assets/image1.svg">
		</div>
		<div class="container">
			<div class="calculate" id="inputSection">
					<h2>Enter Your Name</h2>
					<input type="text" name="name"><br>
					<h2>Enter Your Height</h2>
					<input type="number" placeholder="in cms" name="height"><br>
					<h2>Enter Your Weight</h2>
					<input type="number" placeholder="in kgs" name="weight"><br>
					<button type="submit" name="calculate">CALCULATE</button>
			</div>
			<div class="calculate" id="resultSection">
				<h2>Hai <%out.print(request.getAttribute("name"));%></h2><br><br>
				<hr><br><br>
				<h3>Here's your BMI value</h3><br>
				<h2><%out.print(request.getAttribute("value"));%></h2><br>
				<h3><%out.print(request.getAttribute("description"));%></h3>
			</div>
			<img id="bmivalues" src="http://localhost:8080/jspservlet-app-bmi-calculator/assets/image2.svg">
		</div>
		</form>
	</body>
</html>