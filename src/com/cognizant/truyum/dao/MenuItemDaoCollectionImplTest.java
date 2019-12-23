package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("Admin menu item list");
			testGetMenuItemListAdmin();
			System.out.println("Customer menu item list");
			testGetMenuItemListCustomer();
			testModifyMenuItem();
			System.out.println("modified menu item list");
			testGetMenuItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : customerList) {
			System.out.println(x);
		}
	}

	private static void testModifyMenuItem() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = new MenuItem(1, "Pasta", 50.0f, false, DateUtil.convertToDate("17/08/2019"), "Special",false);
		menuItemDao.modifyMenuItem(menuItem);

	}
}
