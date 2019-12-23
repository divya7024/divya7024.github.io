package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void main(String[] args) throws CartEmptyException {
		
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("Show All Cart Items");
		for (MenuItem menuItem : menuItemListCustomer) {

			System.out.println(menuItem);
		}
	}

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();

		cartDao.addCartItem(1, 1L);
		cartDao.addCartItem(1, 4L);

		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for Checkout");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for Customer after Remove");
		try {
			cartDao.removeCartItem(1, 1L);
			cartDao.removeCartItem(1, 4L);

			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}