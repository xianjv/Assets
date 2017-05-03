package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

public class ModifyPerson extends PersonInfo{
	String id_str="";
	public ModifyPerson(){
		this.setTitle("修改人员信息");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);
		
		//设置运行时窗口的位置
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		Point size =new Point((screenSize.width-400)/2,(screenSize.height-300)/2);
		this.setLocation(size);
		
		this.setVisible(true);
		
	}
	
	public void downInit(){
		searchInfo.setText("人员编号查询");
		downPanel.add(searchInfo);
		downPanel.add(modifyInfo);
		downPanel.add(clearInfo);
		downPanel.add(exitInfo);
		
		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(true);
		clearInfo.setEnabled(true);
		exitInfo.setEnabled(true);
		//添加事件监听
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.add(downPanel,BorderLayout.SOUTH);
	}
	//事件处理
	public void actionPerformed(ActionEvent e){
		Object obj =e.getSource();
		String[] str=new String[7];
		if(obj==exitInfo){
			this.dispose();
		}else if(obj==modifyInfo){ //修改
			PersonBean modify = new PersonBean();
			modify.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), 
					jTextField4.getText(), jTextField5.getText(), jTextField6.getText());
			modify.search(jTextField1.getText());
			str= modify.search(id_str);
					
			jTextField2.setText(str[0]);
			jTextField3.setText(str[1]);
			jTextField4.setText(str[2]);
			jTextField5.setText(str[3]);
			jTextField6.setText(str[4]);
			
		}else if(obj==clearInfo){ //清空
			setNull();
			jTextField1.setText("请查询编号");
		}else if(obj==searchInfo){ //编号查询
			setNull();
			ModifyPersonSearch modify_search =new ModifyPersonSearch(this);
			modify_search.pack();
			try {
				id_str =modify_search.getID();
			} catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "没有找到该编号！");
			}
			PersonBean ab= new PersonBean();
			str= ab.search(id_str);
			if(str==null){
				JOptionPane.showInternalMessageDialog(null, "记录不存在！");
				
				jTextField1.setText("请输入人员编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				return;
			}else{
				jTextField1.setText(id_str);
				jTextField2.setText(str[0]);
				jTextField3.setText(str[1]);
				jTextField4.setText(str[2]);
				jTextField5.setText(str[3]);
				jTextField6.setText(str[4]);
				
				modifyInfo.setEnabled(true);
				
			}
		}
		
		
	}

	
}
