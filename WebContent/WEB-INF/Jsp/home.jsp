<%@page import="java.io.File"%>
<%@page import="com.pojo.Studentpojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function save(){
	alert("save");
	document.getElementById("formid").action="savestud.do";
	document.getElementById("formid").submit();
}
function deletestud(){
	alert("delete");
	document.getElementById("formid").action="delete.do";
	document.getElementById("formid").submit();
}
function update(){
	alert("update");
	document.getElementById("formid").action="update.do";
	document.getElementById("formid").submit();
}
function getall(){
	alert("getall");
	document.getElementById("formid").action="getall.do";
	document.getElementById("formid").submit();
}
function getrec(){
	alert("get");
	document.getElementById("formid").action="get.do";
	document.getElementById("formid").submit();
}
</script>
</head>
<body>
<h1>Home page<a href="logout.do">Log-out</a></h1>
<%-- <h2 style="color:red">${error}</h2> --%>
<h2>Welcome to home page</h2>
<form Id="formid" action="savestud.do" method="post" enctype="multipart/form-data">
<fieldset>
<legend>Student Details</legend>
<input type="hidden" name="sno" value="${getstd.sno}"><br>
Sname::<input type="text" name="sname" value="${getstd.sname}"></br>
Batch::<input type="text" name="batch" value="${getstd.batch}"></br>
Famt::<input type="text" name="famt" value="${getstd.famt}"></br>
Sno::<input type="text" name="sno"><br>
File::<input type="file" name="file">
<input type="button" value="save" onclick="save()"></input> 
<input type="button" value="delete" onclick="deletestud()"></input>
<input type="button" value="update" onclick="update()"></input>
<input type="button" value="getall" onclick="getall()"></input>
<input type="button" value="get" onclick="getrec()"></input>
</fieldset>
</form>
<%-- <% 
List<Studentpojo> student=(List<Studentpojo>)request.getAttribute("stud");
if(student!=null){
	out.print("<table border='2'>");
    out.print("<tr>");
    out.print("<th>Sno</th>");
    out.print("<th>Sname</th>");
    out.print("<th>Batch</th>");
    out.print("<th>Famt</th>");
    out.print("</tr>");

	for(Studentpojo studs : student){
	out.print("<tr>");
	out.print("<td>"+studs.getSno()+"</td>");
	out.print("<td>"+studs.getSname()+"</td>");
	out.print("<td>"+studs.getBatch()+"</td>");
	out.print("<td>"+studs.getFamt()+"</td>");
	out.print("</tr>");
}
	out.print("</table");
}

Studentpojo getstud=(Studentpojo)request.getAttribute("getstd");
if(getstud!=null){
out.print("<table>");
out.print("<tr>");
out.print("<td>"+getstud.getSno()+"</td>");
out.print("<td>"+getstud.getSname()+"</td>");
out.print("<td>"+getstud.getBatch()+"</td>");
out.print("<td>"+getstud.getFamt()+"</td>");
out.print("<tr>");
}
out.print("</table>");
%> --%>
<% 
List<Studentpojo> student=(List<Studentpojo>)request.getAttribute("stud");
if(student!=null){
	%>
	<table border='2'>
    <tr>
    <th><a href="getall.do?sort=sno">Sno</a></th>
    <th><a href="getall.do?sort=sname">Sname</a></th>
    <th><a href="getall.do?sort=batch">Batch</a></th>
    <th><a href="getall.do?sort=famt">Famt</a></th>

    </tr>
    <%-- <%
     for(Studentpojo studs : student){ 
    %>
    <tr>
    <td><%=studs.getSno() %></td>
    or  <td><% out.print studs.getSno() %></td>
    <td><%=studs.getSname() %></td>
    <td><%=studs.getBatch() %></td>
    <td><%=studs.getFamt() %></td>
   </tr> 
   <%
    }
   %> --%>
   <c:forEach items="${stud}" var="studs">
   <tr>
   <td>${studs.sno}</td>
   <td><a href="get.do?sno=${studs.sno}">${studs.sname}</a></td>
   <td>${studs.batch}</td>
   <td>${studs.famt}</td>
   </tr>
   </c:forEach>
   </table> 
   <%
    }
   %>
   <%
   Studentpojo getstud=(Studentpojo)request.getAttribute("getstd");
   if(getstud!=null){
   %>
   <table>
    <tr>
    <td><%=getstud.getSno() %></td>
    <td><%=getstud.getSname() %></td>
    <td><%=getstud.getBatch() %></td>
    <td><%=getstud.getFamt() %></td>
   </tr>
   <%
   }
   %>
   </table>
   
   <%
  File uploadFolder=new File("F:\\fileUploads");
   String[] fileNames=uploadFolder.list();
   for(String file:fileNames){
	   out.print("<li><a href='downloadFile.do?fileName='>"+file+"</a></li>");
   }
   %>
   
    <h2>Active User List</h2>
 <ol>
 <c:forEach items="${userlist}" var="user">
 <li>${user}</li>
 </c:forEach>
 </ol>
   
</body>
</html>