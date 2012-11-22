package com.ss.test;

import java.awt.EventQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ss.test.gui.BookView;

public class Launcher {

	public void launch() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationContext context = new ClassPathXmlApplicationContext(
							"applicationContext-client.xml");

					BookView bookView = (BookView) context.getBean("bookView");
					bookView.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
