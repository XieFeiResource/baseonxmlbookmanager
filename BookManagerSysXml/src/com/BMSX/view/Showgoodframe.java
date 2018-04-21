package com.BMSX.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.BMSX.control.Bookhandler;
import com.BMSX.control.DBToXmlService;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Showgoodframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Mainframe mainframe;
	private Object[][] data;
	private DefaultTableModel model;
	private JScrollPane scrollPane ;
	
	public JTable getTable() {
		return table;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showgoodframe frame = new Showgoodframe(null);
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
	public Showgoodframe(Object[][] data) {
		this.data=data;
		setBounds(100, 100, 642, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("图书展示");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(256, 10, 93, 15);
		contentPane.add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 606, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] biaotou=new String[] {"图书名称", "图书作者","图书价格", "图书库存", "图书图片", "图书描述"};
		model=new DefaultTableModel(data,biaotou);
		table.setModel(model);
		table.getColumnModel().getColumn(5).setPreferredWidth(102);
		table.getColumnModel().getColumn(5).setPreferredWidth(155);
		scrollPane.setViewportView(table);
		
		String[] items = new String[]{"导入xml到数据库", "导出数据到xml"};
		JMenuBar menubar = new JMenuBar();
        JMenu jmManager = new JMenu("导入/导出");
        JMenuItem item1 = new JMenuItem(items[0]);
        jmManager.add(item1);
        item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bookhandler bh=new Bookhandler();
				try {
					bh.importDataIntoDB();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(Showgoodframe.this, "导入成功！", "温馨提示", JOptionPane.INFORMATION_MESSAGE);

			}
		});
        JMenuItem item2 = new JMenuItem(items[1]);
        jmManager.add(item2);
        item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DBToXmlService dbtoxml=new DBToXmlService();
				try {
					dbtoxml.exportDataToXMlFile("bookmanage", "book");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(Showgoodframe.this, "导出成功！", "温馨提示", JOptionPane.INFORMATION_MESSAGE);

			}
		});
        menubar.add(jmManager);
        menubar.setBounds(0, 0, 111, 22);
        this.setJMenuBar(menubar);
	}
}
