package com.lxj.assets;
/**
 * 添加资产信息
 * */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class AddAssets extends AssetsInfo{
	AssetsBean ab= new AssetsBean();
	
	public AddAssets(){
		this.setTitle("添加资产信息");
		this.setResizable(true);
		jTextField1.setEditable(false);
		jTextField1.setText(""+ab.getID());
		jTextField2.setEditable(true);
		jTextField3.setText("1");
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);
		jTextField7.setText("在库");
		jTextField7.setEditable(true);
		jTextField8.setEditable(true);
		
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
		
		jComboBox1.addItemListener(this);
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
			jTextField7.setEditable(false);
			jTextField8.setEditable(false);
			
			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			exitInfo.setEnabled(false);
			
			AssetsBean ab=new AssetsBean();
			ab.add(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
					jTextField4.getText(), jTextField5.getText(), jTextField6.getText(),
					jTextField7.getText(), jTextField8.getText());
			this.dispose();
			AddAssets addAssets=new AddAssets();
			addAssets.downInit();
			addAssets.pack();
			
		}
		else if(obj==clearInfo){ //清空
			setNull();
			jTextField1.setText(""+ab.getID());
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){  //使jTextField3获得所选内容
			String tempStr =""+e.getItem();
			int i =tempStr.indexOf("-");
			jTextField3.setText(tempStr.substring(0,i));
		}
	}
	
	
	
	
	
	
	
	
	
}
