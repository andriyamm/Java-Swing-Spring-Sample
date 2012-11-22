package com.ss.test.service;

import java.util.List;

import com.ss.test.domain.Book;

public interface IBookManager {
	
	List<Book> findAll();
	List<Book> find(String property_name, String property_value);
}
