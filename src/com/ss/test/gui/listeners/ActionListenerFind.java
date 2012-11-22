package com.ss.test.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ss.test.service.impl.BookManager;

public class ActionListenerFind implements ActionListener {
	
	//private BookTableModel bookTableModel;
	private BookManager bookManager;
	
	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

//	public ActionListenerFind(BookTableModel bookTableModel) {
//		super();
//		this.bookTableModel = bookTableModel;
//	}

	public ActionListenerFind() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Hi, there");
		//bookTableModel.setBooks(bookManager.find());
	}

}
