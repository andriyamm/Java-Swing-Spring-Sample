package com.ss.test.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import com.ss.test.gui.models.BookTableModel;
import com.ss.test.gui.models.ColumnComboModel;

public class BookView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	private BookTableModel bookTableModel;
	private ColumnComboModel columnComboModel;

	public BookView() {
		//initialize();
	}

	public BookView(ColumnComboModel columnComboModel,
			BookTableModel bookTableModel) {
		this.columnComboModel = columnComboModel;
		this.bookTableModel = bookTableModel;
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void show() {

		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		textField = new JTextField();
		frame.getContentPane().add(textField, "2, 2, fill, default");
		textField.setColumns(10);

		final JComboBox filterComboBox = new JComboBox(columnComboModel);
		frame.getContentPane().add(filterComboBox, "4, 2, fill, default");

		JButton findButton = new JButton("Find");
		frame.getContentPane().add(findButton, "6, 2");

		findButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bookTableModel.findBooks((String) filterComboBox.getSelectedItem(),
						textField.getText());
				bookTableModel.fireTableDataChanged();
			}
		});

		// Create a TableModel object
		table = new JTable(bookTableModel);
		frame.getContentPane().add(new JScrollPane(table), "2, 4, 5, 1, fill, fill");
		frame.setVisible(true);
	}

}
