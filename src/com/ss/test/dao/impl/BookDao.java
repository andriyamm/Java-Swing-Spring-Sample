package com.ss.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ss.test.dao.IBookDao;
import com.ss.test.domain.Book;

public class BookDao implements IBookDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection createConnection() {
		Connection con = null;
		try {
				con = dataSource.getConnection();
				System.out.println("Connection Done successfully");
		} catch (Exception e) {
			System.out.println("Error Occured " + e.toString());
		}
		
		return con;
	}

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
			
//			 for (Book book : books) {
//			 System.out.println(book);
//			 }
//			
//			 System.out.println("_____________________________");
			
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
			
			
//			 for (Book book : books) {
//			 System.out.println(book);
//			 }
//			
//			 System.out.println("_____________________________");
			 
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

	
}//po class
