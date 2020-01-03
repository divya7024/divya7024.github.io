<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>menu item list customer</title>
<link rel="stylesheet" type="text/css" href="./style/style.css"/>
</head>
<body>
	<header><span>truYum</span>
                           <img src="./images/truyum-logo-light.png" />
                           <a id="cart" href="ShowCart">Cart</a>
                           <a id="menu" href="ShowMenuItemListCustomer">Menu</a>
	</header>
<div>
   <h3 class="cont">MenuItems</h3>
   <table class="cont">
    <h4>${msg}</h4>
  
		<tr>
			<th class="txt-left">Name</th>			
			<th class="txt-center">Free Delivery</th>
			<th class="txt-right">Price</th>
			<th class="txt-center">category</th>
			<th class="txt-center">Action</th>
		</tr>
		<c:forEach items="${menuItemList}" var="menu">
		<tr>
			<td class="txt-left">${menu.name}</td>			
			<td class="txt-center"><c:if test ="${menu.freeDelivery}">Yes</c:if>
                                                <c:if test="${!menu.freeDelivery}">No</c:if></td>
			<td class="txt-right">Rs.${menu.price}</td>
			<td class="txt-center">${menu.category}</td>			
			<td class="txt-center">
				<c:if test ="${menu.active}">Yes</c:if>
	            <c:if test="${!menu.active}">No</c:if></td>
             <td class="txt-center"><a href="AddToCart?menuItemId=${menu.id}" target="_blank">Add to Cart</a></td>
		</tr>
		</c:forEach>
		
		</table>
</div>
<footer><span class="cont">Copyright@2019</span></footer>
</body>
</html>