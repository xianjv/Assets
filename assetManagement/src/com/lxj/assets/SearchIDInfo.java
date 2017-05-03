package com.lxj.assets;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchIDInfo extends JFrame implements ActionListener{

	JLabel jLabel1 =new JLabel();
	JLabel jLabel2 =new JLabel();
	JTextField jTextField =new JTextField(10);
	JButton searchInfo =new JButton();
	String tablename =null;
	
	public SearchIDInfo(String str){
		this.setTitle("按编号查询");
		//this.setResizable(false);
		
		this.tablename =str;
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private void Init() throws Exception{
		//this.setSize(500,200);
		this.setLayout(new FlowLayout());
		
		jLabel1.setText("请输入编号:");
		this.add(jLabel1);
		jTextField.setText(null);
		this.add(jTextField);
		searchInfo.setText("确定");
		this.add(searchInfo);
		
		searchInfo.addActionListener(this);
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj ==searchInfo){
			if(tablename == "Assets"){
				ResultInfo info =new ResultInfo();
				info.resultAssetsID(jTextField.getText());
				this.dispose();
			}
			else if(tablename == "Person"){
				ResultInfo info =new ResultInfo();
				info.resultPersonID(jTextField.getText());
				this.dispose();
			}
		}
	}
	
}
