<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<h1>Employee Management System</h1>
</div>
<h4>Welcome ${sessionScope.username}</h4>
<div align="right">
<jstl:if test='${!sessionScope.username.equals("Guest") }'>
<h4><a href="logout.app">Logout</a></h4>
</div>
</jstl:if>