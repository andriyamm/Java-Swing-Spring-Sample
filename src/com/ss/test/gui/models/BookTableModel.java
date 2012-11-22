package com.ss.test.gui.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ss.test.domain.Book;
import com.ss.test.service.IBookManager;

public class BookTableModel extends AbstractTableModel  {

	private static final long serialVersionUID = 4542486426749190671L;

	IBookManager bookManager;
	
	private List<Book> books;

	protected ArrayList<String> columnNames = new ArrayList<String>(
			Arrays.asList("id", "isbn", "name", "author", "pageCount",
					"publishDate"));

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected ArrayList<Class> columnClasses = new ArrayList<Class>(
			Arrays.asList(Long.class, String.class, String.class, String.class,
					Integer.class, Date.class));
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// constructors
	
	public BookTableModel(IBookManager bookManager) {
		super();
		this.bookManager = bookManager;
		this.books = this.bookManager.findAll();
	}
	
//	public BookTableModel(List<Book> books) {
//		super();
//		this.books = books;
//	}

	public BookTableModel() {
		super();
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// getters and setters
	public IBookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(IBookManager bookManager) {
		this.bookManager = bookManager;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Class> getColumnClasses() {
		return columnClasses;
	}

	@SuppressWarnings("rawtypes")
	public void setColumnClasses(ArrayList<Class> columnClasses) {
		this.columnClasses = columnClasses;
	}

	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// methods
	
	public void findBooks(String property_name, String property_value){
		this.books = this.bookManager.find(property_name, property_value);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int col) {
		return columnClasses.get(col);
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book book = books.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return book.getId();
		case 1:
			return book.getIsbn();
		case 2:
			return book.getName();
		case 3:
			return book.getAuthor();
		case 4:
			return book.getPageCount();
		case 5:
			return book.getPublishDate();
		default:
			return null;

		}
	}
	
}// po class
