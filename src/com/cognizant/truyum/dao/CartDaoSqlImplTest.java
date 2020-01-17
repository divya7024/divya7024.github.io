package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException, SQLException {
		testGetAllCartItems();
		testAddCartItem();
		//testGetAllCartItems();
		testRemoveCartItem();
		//testGetAllCartItems();
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			System.out.println(" List Of All Cart Items");
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testAddCartItem() throws CartEmptyException, SQLException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 3L);

		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException,SQLException {
		CartDao cartDao = new CartDaoSqlImpl();
		System.out.println("Item List for Customer after Removal");
		try {
			cartDao.removeCartItem(1, 2L);
			cartDao.removeCartItem(1, 3L);
			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
