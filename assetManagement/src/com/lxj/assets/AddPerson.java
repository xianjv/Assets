package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class AddPerson extends PersonInfo{
PersonBean pb= new PersonBean();
	
	public AddPerson(){
		this.setTitle("添加人员信息");
		this.setResizable(true);
		jTextField1.setEditable(false);
		jTextField1.setText(""+pb.getID());
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
		downPanel.add(addInfo);
		downPanel.add(clearInfo);
		downPanel.add(exitInfo);
		
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.add(downPanel,BorderLayout.SOUTH);
	}
	
	
	//事件处理
	
	public void actionPerformed(ActionEvent e){
		Object obj =e.getSource();
		if(obj==exitInfo){ //退出
			this.dispose();
		}
		else if(obj==addInfo){ //增加
			
			jTextField1.setEditable(false);
			jTextField2.setEditable(false);
			jTextField3.setEditable(false);
			jTextField4.setEditable(false);
			jTextField5.setEditable(false);
			jTextField6.setEditable(false);
			
			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			exitInfo.setEnabled(false);
			
			PersonBean pb=new PersonBean();
			pb.add(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
					jTextField4.getText(), jTextField5.getText(), jTextField6.getText());
			this.dispose();
			
			//生成新界面
			AddPerson addPerson=new AddPerson();
			addPerson.downInit();
			addPerson.pack();
			
		}
		else if(obj==clearInfo){ //清空
			setNull();
			jTextField1.setText(""+pb.getID());
		}
	}
}
