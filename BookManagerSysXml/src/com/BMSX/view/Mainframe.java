package com.BMSX.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.BMSX.model.dao.BookDao;
import com.BMSX.model.dao.BookDaoImpl;
import com.BMSX.modelbean.Book;


public class Mainframe extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private Allbuttonlistener bunttonlistener;
	private BookDao bookdao;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	{
		bunttonlistener = new Allbuttonlistener();
		bookdao=new BookDaoImpl();
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setBounds(100, 100, 504, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("欢迎来到图书管理系统");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(154, 23, 186, 21);
		contentPane.add(label);

		btnNewButton = new JButton("展示所有图书");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		btnNewButton.setBounds(140, 91, 241, 23);
		btnNewButton.addActionListener(bunttonlistener);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setBounds(110, 93, 25, 15);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("2.");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(110, 139, 25, 15);
		contentPane.add(label_1);

		button = new JButton("查询图书");
		button.setFont(new Font("黑体", Font.PLAIN, 18));
		button.setBounds(140, 135, 241, 23);
		button.addActionListener(bunttonlistener);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(110, 181, 25, 15);
		contentPane.add(label_2);
		
		button_1 = new JButton("修改图书");
		button_1.setFont(new Font("黑体", Font.PLAIN, 18));
		button_1.setBounds(140, 179, 241, 23);
		button_1.addActionListener(bunttonlistener);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setFont(new Font("黑体", Font.PLAIN, 18));
		label_3.setBounds(110, 228, 25, 15);
		contentPane.add(label_3);
		
		button_2 = new JButton("添加图书");
		button_2.setFont(new Font("黑体", Font.PLAIN, 18));
		button_2.setBounds(144, 226, 237, 23);
		button_2.addActionListener(bunttonlistener);
		contentPane.add(button_2);
	}

	// 为所有按钮添加监听器
	class Allbuttonlistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNewButton) {
				List<Book> list =(List<Book>) bookdao.list();
				System.out.println(list.toString());
				Object[][] data = ((BookDaoImpl) bookdao).Createdata(list);
				Showgoodframe show=new Showgoodframe(data);
				show.setVisible(true);
			}else if(e.getSource() == button) {
				Researchframe research=new Researchframe(bookdao);
				research.setVisible(true);
			}else if(e.getSource() == button_1) {
				Modifyframe research=new Modifyframe(bookdao);
				research.setVisible(true);
			}else if(e.getSource() == button_2) {
				Addgoodframe research=new Addgoodframe(bookdao);
				research.setVisible(true);
			}
		}
	}
}