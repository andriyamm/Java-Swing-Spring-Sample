package com.ss.test.service.impl;

import java.util.List;

import com.ss.test.dao.IBookDao;

import com.ss.test.domain.Book;
import com.ss.test.service.IBookManager;

public class BookManager implements IBookManager{
	
	private IBookDao bookDao;
	
	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> find(String property_name, String property_value) {
		return bookDao.find(property_name, property_value);
	}

}
