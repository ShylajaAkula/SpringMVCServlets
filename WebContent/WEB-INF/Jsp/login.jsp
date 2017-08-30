<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="loginProcessingUrl.do" method="post">
UserName::<input type="text" name="username"></br>
Password::<input type="password" name="password"></br>
 <button type="submit">login</button>
</form>
<a href="regisHome.do">SignUp</a>
<% String message=(String)request.getAttribute("message");
if(message!=null)
{
	out.print(message);
}
%>
</body>
</html>