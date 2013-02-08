package com.ss.test.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.test.dao.IBookDao;
import com.ss.test.dao.impl.JDBCDao;
import com.ss.test.domain.Book;

public class JDBCBookDao extends JDBCDao implements IBookDao {

	@Override
	public List<Book> findAll(){
		
		String sql_query = "SELECT * FROM books";

		Connection conn = createConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql_query);
	
			List<Book> books = new ArrayList<Book>();
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				books.add( new Book(
							rs.getInt("id"),
							rs.getString("isbn"),
							rs.getString("name"),
							rs.getString("author"),
							rs.getInt("pageCount"),
							rs.getDate("publishDate")
						));
			}
			rs.close();
			ps.close();
			
			return books;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

	@Override
	public List<Book> find(String property_name, String property_value) {
		String sql_query = "SELECT * FROM books WHERE " + property_name + " LIKE '" + property_value + "%' ";

		Connection conn = createConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql_query);
	
			List<Book> books = new ArrayList<Book>();
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				books.add( new Book(
							rs.getInt("id"),
							rs.getString("isbn"),
							rs.getString("name"),
							rs.getString("author"),
							rs.getInt("pageCount"),
							rs.getDate("publishDate")
						));
			}
			rs.close();
			ps.close();
			 
			return books;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Book book) {
		// TODO Auto-generated method stub
		
	}

}
