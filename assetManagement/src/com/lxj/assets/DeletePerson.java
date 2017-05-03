package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

public class DeletePerson extends PersonInfo{
	String id_str;
	public DeletePerson(){
		this.setTitle("删除人员信息");
		this.setResizable(false);
		
		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		
		this.setLocationRelativeTo(null); //居中
		
		this.setVisible(true);
	}
	public void downInit(){
		searchInfo.setText("人员编号查询");
		downPanel.add(searchInfo);
		downPanel.add(deleteInfo);
		downPanel.add(exitInfo);
		
		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		exitInfo.setEnabled(true);
		
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.add(downPanel,BorderLayout.SOUTH);
		
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		String[] str =new String[6];
		if(obj==searchInfo){ //获取新编号
			setNull();
			ModifyPersonSearch modify_search=new ModifyPersonSearch(this);
			modify_search.pack();
			try {
				id_str =modify_search.getID();
			} catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "没有找到该编号！");
			}
			PersonBean pb= new PersonBean();
			str= pb.search(id_str);
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
				
				deleteInfo.setEnabled(true);
			}
		}
		if(obj==exitInfo){
			this.dispose();
		}
		if(obj==deleteInfo){
			int ifdel =JOptionPane.showConfirmDialog(null, "确认删除该信息","提示信息",
					JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			
			if(ifdel == JOptionPane.YES_OPTION){
				PersonBean pb= new PersonBean();
				pb.delete(id_str);
				setNull();
				deleteInfo.setEnabled(false);
			}else{
				return;
			}
		}
	}
	
}
