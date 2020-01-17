package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public void addCartItem(long userId, long menuItemId) {

		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "insert into cart(ct_us_id,ct_pr_id) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,userId);
			pstmt.setLong(2,menuItemId);
			int result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId)throws CartEmptyException{
	    List<MenuItem> cartlist=new ArrayList<>();
	    Cart cart=new Cart();
	    String sql= "select me_id,me_name,me_price,"
	    		+"me_active,me_date_of_launch,"
	    		+"from menu_item inner join cart,"
	    		+"on ct_pr_id=me_id where ct_us_id=?";
	    		Connection con=ConnectionHandler.getConnection();
		try {
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setLong(1,userId);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));
				cart.getMenuItemList().add(m);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cart.getMenuItemList();
		}
			
		
		
		
	
	@Override
      public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "DELETE FROM cart " + 
					"WHERE ct_us_id=? AND ct_pr_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,userId);
			pstmt.setLong(2, menuItemId);
			int result=pstmt.executeUpdate();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
