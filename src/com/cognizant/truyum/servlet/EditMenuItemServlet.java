package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet({ "/EditMenuItemServlet", "/EditMenuItem" })
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Integer.parseInt(request.getParameter("menuItemId"));
		
			String name = request.getParameter("txtName");
			float price = Float.parseFloat(request.getParameter("txtPrice"));
			boolean active = request.getParameter("active").equalsIgnoreCase("yes");
			String dateOfLaunch = request.getParameter("txtDoL");
			String category = request.getParameter("Category");
			boolean freeDelivery =  request.getParameter("freeDelivery").equalsIgnoreCase("yes");
			MenuItem m = new MenuItem(id, name, price, active, DateUtil.convertToDate(dateOfLaunch), category,freeDelivery);
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

			menuItemDao.modifyMenuItem(m);
			request.setAttribute("msg", "Menu Item details saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
