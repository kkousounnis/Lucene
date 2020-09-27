<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>SearchPage</title>
</head>
<body>
<fieldset>
Type your query
<br></br>
 <form method="post" action="UserController">
 <input type="hidden" name="action" value="Search" />
 <textarea rows="2" cols="70" name=Query></textarea>
 
 <br></br>
 <input  type="submit" value="Search">
 
 </form>
</fieldset>
</body>
</html>


