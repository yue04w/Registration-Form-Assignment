<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>Registration Page</title>
</head>
<body>

    <div align="center">
        <h1>Registration Page</h1>

        <form action="<%=request.getContextPath()%>/RegistrationServlet" method="post">
            <table style="width: 80%">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="userName" placeholder="Enter username (max 10 characters)" required /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter password (max 10 characters)" required /></td>
                </tr>
                <tr>
                    <td>ReType Password</td>
                    <td><input type="password" name="confirmPassword" placeholder="Confirm your password" required /></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="phoneNumber" placeholder="Enter 10 digit phone number" required /></td>
                </tr>
                <tr>
                    <td>Email Id</td>
                    <td><input type="text" name="email" placeholder="Enter email address" required /></td>
                </tr>
            </table>
            <input type="submit" value="Submit" />
        </form>
    </div>

</body>
</html>