package com.lxj.assets;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ModifyAssetsSearch extends JDialog implements ActionListener{

	String[] s;
	Dimension faceSize = new Dimension(300,100);
	JLabel jLabel1 =new JLabel();
	JComboBox selectID;
	JButton searchInfo =new JButton();
	
	public ModifyAssetsSearch(JFrame frame) {
		super(frame,true);
		this.setTitle("资产编号查询");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	public void Init() throws Exception{
		this.setSize(faceSize);
		this.setLayout(new FlowLayout());
		
		jLabel1.setText("请输入或者选择编号");
		this.add(jLabel1);
		
		AssetsBean ab =new AssetsBean();
		s= ab.getAllID();
		
		selectID = new JComboBox(s);
		selectID.setEditable(true);
		this.add(selectID);
		searchInfo.setText("查询");
		this.add(searchInfo);
		
		searchInfo.addActionListener(this);
	}
	
	
	public String getID(){
		return this.selectID.getSelectedItem().toString();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==selectID){
			this.dispose();
		}
		else if(obj == searchInfo){
			this.dispose();
			
		}
	}

}
