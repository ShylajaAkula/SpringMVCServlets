<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function signUp(){
	var password=document.getElementById("password").value;
	var conpwd=document.getElementById("conpwd").value;
	if(password==conpwd){
		alert("regisbody::");
		document.forms[0].action="registerbody.do";
		document.forms[0].submit();
	}
	else
		alert("password and confirm password are not same");
    }
	/* password=password.trim();
	if(password==""){
		alert("password is blank");
	}
	else if(password.length<8){
		alert("password min length is 8");
	}
	elseif(password==conpwd){
	}
	
	 */
	
</script>
</head>
<body>
<form>
<fieldset>
<legend>Registration</legend>
User Name:<input type="text" name="name"><br>
Password:<input type="password" id="password" name="password"><br>
ConfirmPassword:<input type="password" id="conpwd" name="conpassword">
<input type="button" value="Signpage" onclick="signUp()">
</fieldset>
</form>
</body>
</html>