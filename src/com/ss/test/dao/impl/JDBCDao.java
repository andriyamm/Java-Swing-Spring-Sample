package com.ss.test.dao.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import com.ss.test.dao.IJDBCDao;

public class JDBCDao implements IJDBCDao {

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

}
