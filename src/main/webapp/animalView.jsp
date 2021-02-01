<%@page import="org.apache.struts.taglib.html.ImgTag"%>
<%@ include file= "/WEB-INF/header.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<div class="container">
	<h1><c:out value="${ location }" /></h1>
	<br>
	<br>
	
			<div class="container-fluid">	
		    <div class="row">
		    
		    <c:forEach var="animal" items="${animalList}">
		      <!-- Gallery item -->
		      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
		        <div class="bg-white rounded shadow-sm">
		        <%
		        	String dogPicPath = "/WEB-INF/IMG/dog1.jpg";
		        	String catPicPath = "/WEB-INF/IMG/cat1.jpg";
		        	String hamsterPicPath = "/WEB-INF/IMG/hamster1.jpg";
		        	String parrotPicPath = "/src/main/webapp/WEB-INF/IMG/parrot1.jpg";
		        %>
		        <!--
		        <%
		        	switch("${ animal.type }"){
		        	case "Cat":
		        	%>
		        		<img src="${catPicPath}" alt="" class="img-fluid card-img-top">
		        	<% 
		        		break;
		        	case "Dog":
		        		%>
		        		<img src="${dogPicPath}" alt="" class="img-fluid card-img-top">
		        	<% 	
		        		break;
		        	case "Hamster":
		        		%>
		        		<img src="${hamsterPicPath}" alt="" class="img-fluid card-img-top">
		        	<% 	
		        		break;
		        	case "Parrot":
		        	%>
		        		<img src="${parrotPicPath}" alt="" class="img-fluid card-img-top">
		        	<% 	
		        		break;
		        	}
		        
		        %>
		        -->
		       <c:forEach var="img" items="${imgList}">
		       	<c:if test="${img.id == animal.id }">
		       	<c:set var="path" value="${img.path}"></c:set>
		       		
		       	</c:if>
		       </c:forEach>
		        
		       	<img src="${path}" 
		       	alt="" class="img-fluid card-img-top" width="200" height="200"/> 
		       	
		        <div class="p-4">
		            <p><c:out value="${ animal.type }" /></p>
		            <h8 class="large text-muted mb-0">
		            	<c:out value="${ animal.name }" />&nbsp;
		            	<c:out value="${ animal.admitted }" />
		            </h8>
		          
		            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
		              <a href="edit?id=<c:out value='${ animal.id }' />">
									<button class="btn btn-primary">Edit</button>
								</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="delete?id=<c:out value='${ animal.id }' />">
									<button class="btn btn-danger">Delete</button>
									
								</a>
		            </div>
		          </div>
		        </div>
		      </div>
		      <!-- End -->
		      
		      </c:forEach>
				</div>
			</div>
				
			

</div>

<<style>
body {
  background: #f4f4f4;
}

.banner {
  background: #a770ef;
  background: -webkit-linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
  background: linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
}

</style>

<%@ include file= "/WEB-INF/footer.jsp" %>