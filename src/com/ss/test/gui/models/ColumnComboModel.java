package com.ss.test.gui.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ColumnComboModel extends AbstractListModel implements ComboBoxModel  {

	private static final long serialVersionUID = -3142617656737211731L;

	private List<String> columns = new ArrayList<String>(
			Arrays.asList("id", "isbn", "name", "author", "pageCount",
					"publishDate"));
	
	String selection = null;
	
	
	// constructors
	public ColumnComboModel() {
		super();
	}
	
	//getters and setters
	
	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	

	//methods
		
	@Override
	public Object getElementAt(int index) {
		return columns.get(index);
	}

	@Override
	public int getSize() {
		return columns.size();
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

	@Override
	public void setSelectedItem(Object item) {
		selection = (String) item;
	}

}
