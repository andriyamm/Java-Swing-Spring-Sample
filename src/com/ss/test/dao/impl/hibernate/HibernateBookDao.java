package com.ss.test.dao.impl.hibernate;

import java.util.List;

import com.ss.test.dao.IBookDao;
import com.ss.test.dao.impl.HibernateDao;
import com.ss.test.domain.Book;

public class HibernateBookDao extends HibernateDao implements IBookDao {

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> find(String property_name, String property_value) {
		// TODO Auto-generated method stub
		return null;
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
