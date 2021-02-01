<%@	page	language =		"java" 
			contentType =	"text/html; charset=UTF-8"
    		pageEncoding =	"UTF-8" 
    		isELIgnored =	"false"%>
<%@ taglib 	prefix = 		"c" 
			uri = 			"http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "java.util.HashMap"%>
<%@ page import= "java.util.Map"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page import= "com.leiskies.app.shelter.model.*"%>
<%@ page import= "com.leiskies.app.shelter.dao.*"%>
<!DOCTYPE html>
<html>
	<!-- head opens -->
	<head>
		<meta charset="UTF-8">
		<title>Teddy's Shelter Network</title>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="jquery-3.5.1.min.js"></script>
	</head>
	<!-- head closes -->
	<!-- body opens-->
	<body>
	
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  		<a class="navbar-brand" href="<%= request.getContextPath() %>/">Main</a>
	  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    		<span class="navbar-toggler-icon"></span>
	  		</button>
	  		<div class="collapse navbar-collapse" id="navbarNav">
	  			
	  			<%
					ModelDAO<Location,Integer> dao = new ModelDAO<Location,Integer>(Location.class);
					List<Location> locationList = dao.readAll();
				%>
				
				<ul class="navbar-nav">
					<%  for(int i = 0; i < locationList.size(); i++) {
				        String location = locationList.get(i).getName();
				        String locationPath = location.replace(" ", "_");
				 	%>
				 	<li class="nav-item">
		        	<a class="nav-link" href="<%= request.getContextPath() %>/<%=locationPath%>"><%=location%></a>
		      		</li>
				  	<% } %>
				  	
				</ul>
	  		
			    
	  		</div>
	  		
	  		<div class="collapse navbar-collapse" id="navbarNav">
	  		
	  		
	  		</div>
	  		
	  		<div class="collapse navbar-collapse" id="navbarNav">
	  			<ul class="navbar-nav">
	  				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Register">Register</a></li>
	  				&nbsp;&nbsp;&nbsp;&nbsp;
	  				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Login">Login</a></li>
	  			</ul>
	  		
	  		</div>
	  		
		</nav>
	</header>
	
	<!-- body DOES NOT close-->