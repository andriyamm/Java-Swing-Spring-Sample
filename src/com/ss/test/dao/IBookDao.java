package com.ss.test.dao;

import java.util.List;

import com.ss.test.domain.Book;

public interface IBookDao extends IDao {
	
	List<Book> findAll();
	List<Book> find(String property_name, String property_value);
	
	void save(Book book);
	void remove(Book book);
}
