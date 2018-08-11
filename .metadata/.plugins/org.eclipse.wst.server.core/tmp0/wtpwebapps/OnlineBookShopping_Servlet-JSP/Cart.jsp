<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="alfa" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="mystyle.css">

<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<alfa:if test="${sessionScope.counter == 0}">
		<alfa:redirect url="Error.jsp"></alfa:redirect>
	</alfa:if>
	<alfa:if test="${sessionScope.counter != 0}">
		<form action=".app" method="get">

			<div>
				<table cellspacing="15" align="center" border="2">
					<tr>
						<th colspan="6" height="35"><h2>Your Cart</h2></th>
					</tr>
					<tr>
						<th height="20">Book Id</th>
						<th height="20">Book Name</th>
						<th height="20">Book Description</th>
						<th height="20">Book Price</th>
						<th height="20">Book Quantity</th>

					</tr>

					<alfa:forEach var="booksInCart" items="${sessionScope.booksInCart}">
						<tr>
							<td align="center">${booksInCart.bookObject.bookId}</td>
							<td align="center">${booksInCart.bookObject.bookName}</td>
							<td align="center">${booksInCart.bookObject.bookDescription}</td>
							<td align="center">${booksInCart.bookObject.bookPrice}</td>
							<td align="center">${booksInCart.noofBookAdded}</td>
							<td align="center" colspan="2"><a
								href="removenew.app?bookId=${booksInCart.bookObject.bookId}">Remove
									From Cart</a></td>
						</tr>
					</alfa:forEach>
					<tr>
						<th colspan="6">Total Price = ${sessionScope.price}</th>
					</tr>
				</table>
			</div>

		</form>
	</alfa:if>
	<jsp:include page="footer.html"></jsp:include>

</body>
</html>