package com.BMSX.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.BMSX.control.Bookhandler;
import com.BMSX.model.dao.BookDao;
import com.BMSX.model.dao.BookDaoImpl;
import com.BMSX.modelbean.Book;

public class Modifyframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;//图书编号
	private JTextField textField_2;//图书名称
	private JTextField textField_3;//图书价格
	private JTextField textField_4;//图书库存
	private JTextField textField_5;//图书类型
	private BookDao bookdao;
	private JLabel lblNewLabel;//图片
	private JTextArea textArea;//图书描述
	private Object[][] data;
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifyframe frame = new Modifyframe(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modifyframe(BookDao bookdao) {
		this.bookdao=bookdao;
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(132, 25, 170, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("请输入要修改的图书名");
		label.setFont(new Font("黑体", Font.PLAIN, 12));
		label.setBounds(10, 28, 120, 15);
		contentPane.add(label);
		
		JButton button = new JButton("查询");
		button.setFont(new Font("黑体", Font.PLAIN, 18));
		button.setBounds(316, 24, 93, 23);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				List<Book> list = (List<Book>) bookdao.searchone(name);
				data =((BookDaoImpl) bookdao).Createdata(list);
				lblNewLabel.setIcon(new ImageIcon((String) data[0][4]));
				textField_2.setText(data[0][0].toString());
				textField_3.setText(data[0][2].toString());
				textField_4.setText(data[0][3].toString());
				textField_5.setText(data[0][1].toString());
				textArea.setText(data[0][5].toString());
			}
		});
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("图书图片");
		label_1.setFont(new Font("黑体", Font.PLAIN, 12));
		label_1.setBounds(20, 76, 54, 15);
		contentPane.add(label_1);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(20, 101, 76, 80);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.red));
		contentPane.add(lblNewLabel);
		
		/*JLabel label_2 = new JLabel("图书编号");
		label_2.setFont(new Font("黑体", Font.PLAIN, 12));
		label_2.setBounds(116, 76, 54, 15);
		contentPane.add(label_2);*/
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 73, 66, 21);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书名称");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(116, 103, 48, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 101, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("图书价格");
		label_3.setFont(new Font("黑体", Font.PLAIN, 12));
		label_3.setBounds(116, 135, 54, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 132, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("图书库存");
		label_4.setFont(new Font("黑体", Font.PLAIN, 12));
		label_4.setBounds(116, 166, 54, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(175, 163, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("图书类型");
		label_5.setFont(new Font("黑体", Font.PLAIN, 12));
		label_5.setBounds(116, 202, 54, 15);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(175, 199, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("图书描述");
		label_6.setFont(new Font("黑体", Font.PLAIN, 12));
		label_6.setBounds(304, 79, 54, 15);
		contentPane.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 101, 153, 104);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button_1 = new JButton("确认");
		button_1.setFont(new Font("黑体", Font.PLAIN, 18));
		button_1.setBounds(77, 243, 93, 23);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bno=textField_1.getText();
				String bname=textField_2.getText();
				String bprice=textField_3.getText();
				String baccount=textField_4.getText();
				String bauthor=textField_5.getText();
				String bdes=textArea.getText();
				String bimagepath=(String) data[0][4];
				/*int price=Integer.parseInt(gprice);
				int account=Integer.parseInt(gaccount);
				int no=Integer.parseInt(gno);*/
				Book b=new Book(bno, bname, bprice, baccount, bimagepath, bauthor, bdes);
				Bookhandler bh=new Bookhandler();
				bh.modifybook(b);
				JOptionPane.showMessageDialog(Modifyframe.this, "修改成功！", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(button_1);
		
		JLabel label_7 = new JLabel("$");
		label_7.setFont(new Font("黑体", Font.PLAIN, 16));
		label_7.setBounds(243, 135, 24, 15);
		contentPane.add(label_7);
	/*	
		JButton button_2 = new JButton("去查看");
		button_2.setFont(new Font("黑体", Font.PLAIN, 18));
		button_2.setBounds(279, 245, 93, 23);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="select * from good;";
				List<Good> list = Modifyframe.this.operatergoods.queryAllgood(sql);
				Object[][] data = Modifyframe.this.operatergoods.Createdata(list);
				Showgoodframe show=new Showgoodframe(data);
				show.setVisible(true);
			}
		});
		contentPane.add(button_2);*/
	}
}
