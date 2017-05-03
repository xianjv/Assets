package com.lxj.assets;
/**
 *修改资产信息 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

public class ModifyAssets extends AssetsInfo{

	String id_str="";
	public ModifyAssets(){
		this.setTitle("修改资产信息");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);
		jTextField7.setEditable(true);
		jTextField8.setEditable(true);
		jComboBox1.setEnabled(false);
		
		//设置运行时窗口的位置
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		Point size =new Point((screenSize.width-400)/2,(screenSize.height-300)/2);
		this.setLocation(size);
		
		this.setVisible(true);
		
	}
	
	public void downInit(){
		searchInfo.setText("资产编号查询");
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
		
		jComboBox1.addItemListener(this);
		this.add(downPanel,BorderLayout.SOUTH);
	}
	//事件处理
	public void actionPerformed(ActionEvent e){
		Object obj =e.getSource();
		String[] str=new String[7];
		if(obj==exitInfo){
			this.dispose();
		}else if(obj==modifyInfo){ //修改
			AssetsBean modify = new AssetsBean();
			modify.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), 
					jTextField4.getText(), jTextField5.getText(), jTextField6.getText(),
					jTextField7.getText(), jTextField8.getText());
			modify.search(jTextField1.getText());
			str= modify.search(id_str);
					
			jTextField2.setText(str[0]);
			jTextField3.setText(str[1]);
			jTextField4.setText(str[2]);
			jTextField5.setText(str[3]);
			jTextField6.setText(str[4]);
			jTextField7.setText(str[5]);
			jTextField8.setText(str[6]);
			
		}else if(obj==clearInfo){ //清空
			setNull();
			jTextField1.setText("请查询编号");
			jComboBox1.setEnabled(false);
		}else if(obj==searchInfo){ //编号查询
			setNull();
			ModifyAssetsSearch modify_search =new ModifyAssetsSearch(this);
			modify_search.pack();
			try {
				id_str =modify_search.getID();
			} catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "没有找到该编号！");
			}
			AssetsBean ab= new AssetsBean();
			str= ab.search(id_str);
			if(str==null){
				JOptionPane.showInternalMessageDialog(null, "记录不存在！");
				
				jTextField1.setText("请输入资产编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				jTextField7.setEditable(false);
				jTextField8.setEditable(false);
				jComboBox1.setEnabled(false);
				return;
			}else{
				jTextField1.setText(id_str);
				jTextField2.setText(str[0]);
				jTextField3.setText(str[1]);
				int index =Integer.parseInt(str[1])-1;
				//System.out.println(index);
				jComboBox1.setSelectedIndex(index);
				jTextField4.setText(str[2]);
				jTextField5.setText(str[3]);
				jTextField6.setText(str[4]);
				jTextField7.setText(str[5]);
				jTextField8.setText(str[6]);
				
				modifyInfo.setEnabled(true);
				
			}
		}
		
		
	}
	public void itemStateChangeed(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			String tempStr =""+e.getItem();
			int i =tempStr.indexOf("-");
			jTextField3.setText(tempStr.substring(0,i));
		}
	}
	
}
