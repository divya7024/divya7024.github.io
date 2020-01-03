<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			  <title>Edit menu item</title>
			  <link rel="stylesheet" type="text/css" href="./style/style.css"/>
			  <script src="./js/script.js" type="text/javascript"></script>
		</head>
	<body>
			<header>
				<span class="cont">truYum </span>
				<img src="./images/truyum-logo-light.png"/>
				<a id="menu" href="ShowMenuItemListAdmin"/>Menu</a>
			</header>
		<div>
			  <h2 class="cont">Edit Menu Item</h2>
			<form class="cont" name="form" onSubmit="return validation()" method="post" action="EditMenuItem?menuItemId=${menuItem.id}">
				  <table>
						<tr rowspan="4">
							<td colspan="4">
							<label for="txtName">Name</label></td>
						</tr>
						<tr>
							 <td colspan="4">
							 <input type="text" name="txtName" size="80" value="${menuItem.name}">
							 </td>
							</td>
						</tr>
						<tr>
							 <th class="txt-left"><label for="txtPrice">Price</label></th>
							 <th class="txt-left"><label for="txtActive">Active</label></th>
							 <th class="txt-left"><label for="txtDoL">Date of Launch</th>
							 <th class="txt-left"><label for="Category">Category</label></th>
						</tr>
						<tr>
							<td><input type="textbox" id="txtName" name="txtPrice" class="txt-right" value="${menuItem.price}"/></td>
							
							<td><label for="rdYes">
								<input type="radio" id="rdYes" name="rdActive" <c:if test="${menuItem.active eq 'true'}"> checked="checked"</c:if>>Yes</label>
								<label for="rdNo">
								<input type="radio" id="rdNo" name="rdActive"  <c:if test="${menuItem.active eq 'false'}"> checked="checked" </c:if>/>No</label>
							</td>
							
							<td>
							<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}" var="format"/>
							<input type="text" id="txtDoL" name="txtDoL" value="${format}"/></td>
							<td>
									<select name="sel category" id="Category">
										<option value="starters">Starters</option>
										<option value="main course">Main Course</option>
										<option value="Desserts">Desserts</option>
										<option value="Drinks">Drinks</option>
									</select>
							</td>
						</tr>
						<tr>
							<td> <input type="checkbox" name="freedel" id="freedel" value="${menuItem.freeDelivery}" 
							<c:if test="${menuItem.freeDelivery eq 'true'}"> checked="checked"</c:if>
							<c:if test="${menuItem.freeDelivery eq 'false'}"> </c:if>/>Free Delivery</td>
						</tr>
						<tr>
							<td  colspan="2">
							<input class="color" type="submit" value="Save" onclick="validation()">
							</td>
						</tr>
				  </table>
		    </form>
		</div>
			 <footer>
			   <span class="cont">Copyright@2019</span>
			 </footer>
	</body>
</html>
				

	 