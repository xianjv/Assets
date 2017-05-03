package com.lxj.assets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
/*
 *资产信息综合管理类 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssetsInfo extends JFrame implements ActionListener,ItemListener{

	JPanel upPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	JPanel downPanel=new JPanel();
	//定义框架大小
	Dimension faceSize =new Dimension(800,500);
	//定义图形界面元素
	JLabel jlabel1 =new JLabel("资产编号:");
	JLabel jlabel2 =new JLabel("资产名称:");
	JLabel jlabel3 =new JLabel("所属类型:");
	JLabel jlabel4 =new JLabel("资产型号:");
	JLabel jlabel5 =new JLabel("资产价格:");
	JLabel jlabel6 =new JLabel("购买日期:");
	JLabel jlabel7 =new JLabel("资产状态:");
	JLabel jlabel8 =new JLabel("备注:");
	JLabel jlabel9 =new JLabel(":");
	
	JTextField jTextField1 =new JTextField(15); //资产编号
	JTextField jTextField2 =new JTextField(15); //资产名称
	JTextField jTextField3 =new JTextField(15); //所属类型
	JTextField jTextField4 =new JTextField(15); //资产型号
	JTextField jTextField5 =new JTextField(15); //资产价格
	JTextField jTextField6 =new JTextField(15); //购买日期
	JTextField jTextField7 =new JTextField(15); //资产状态
	JTextField jTextField8 =new JTextField(15); //备注
//	JTextField jTextField9 =new JTextField(46); 
	
	JComboBox jComboBox1 =null;
//	JComboBox jComboBox2 =null;
	
	JButton searchInfo =new JButton("查询");
	JButton addInfo =new JButton("增加");
	JButton modifyInfo =new JButton("修改");
	JButton deleteInfo =new JButton("删除");
	JButton clearInfo =new JButton("清空");
	JButton saveInfo =new JButton("保存");
	JButton exitInfo =new JButton("退出");
	
	JButton jBSee =new JButton("");
	JButton JBSearch =new JButton("");
	JButton JBExit =new JButton("");
	JButton JBSum =new JButton("");
	JButton JBGrade =new JButton("");
	
	GridBagLayout gridBag =new GridBagLayout();
	GridBagConstraints gridBagCon;
	
	public AssetsInfo() {
		//设置窗体大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("资产综合信息管理");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	public void Init()throws Exception{
		this.setLayout(new BorderLayout());
		
		//中部面板布局
		centerPanel.setLayout(gridBag);
		//资产编号
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx =0;
		gridBagCon.gridy =0;
		gridBagCon.insets =new Insets(10,10,10,1);
		gridBag.setConstraints(jlabel1, gridBagCon);
		centerPanel.add(jlabel1);
		
		gridBagCon.gridx =1;
		gridBagCon.gridy =0;
		gridBagCon.insets =new Insets(10,1,10,15);
		gridBag.setConstraints(jTextField1, gridBagCon);
		centerPanel.add(jTextField1);
		//资产名称
		gridBagCon.gridx =2;
		gridBagCon.gridy =0;
		gridBagCon.insets =new Insets(10,15,10,1);
		gridBag.setConstraints(jlabel2, gridBagCon);
		centerPanel.add(jlabel2);
		
		gridBagCon.gridx =3;
		gridBagCon.gridy =0;
		gridBagCon.insets =new Insets(10,1,10,10);
		gridBag.setConstraints(jTextField2, gridBagCon);
		centerPanel.add(jTextField2);
		//所属类型
		gridBagCon.gridx =0;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,10,10,1);
		gridBag.setConstraints(jlabel3, gridBagCon);
		centerPanel.add(jlabel3);
		
		TypeBean bean=new TypeBean();
		String[] allType =bean.searchAllForAssets();
		jComboBox1 =new JComboBox(allType);
		gridBagCon.gridx =1;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,1,10,15);
		gridBag.setConstraints(jComboBox1, gridBagCon);
		centerPanel.add(jComboBox1);
		//资产型号
		gridBagCon.gridx =2;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,1,10,1);
		gridBag.setConstraints(jlabel4, gridBagCon);
		centerPanel.add(jlabel4);
		
		gridBagCon.gridx =3;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,1,10,10);
		gridBag.setConstraints(jTextField4, gridBagCon);
		centerPanel.add(jTextField4);
		//资产价格
		gridBagCon.gridx =0;
		gridBagCon.gridy =2;
		gridBagCon.insets =new Insets(10,10,10,1);
		gridBag.setConstraints(jlabel5, gridBagCon);
		centerPanel.add(jlabel5);
		
		gridBagCon.gridx =1;
		gridBagCon.gridy =2;
		gridBagCon.insets =new Insets(10,1,10,15);
		gridBag.setConstraints(jTextField5, gridBagCon);
		centerPanel.add(jTextField5);
		//购买日期
		gridBagCon.gridx =2;
		gridBagCon.gridy =2;
		gridBagCon.insets =new Insets(10,15,10,1);
		gridBag.setConstraints(jlabel6, gridBagCon);
		centerPanel.add(jlabel6);
		
		gridBagCon.gridx =3;
		gridBagCon.gridy =2;
		gridBagCon.insets =new Insets(10,1,10,10);
		gridBag.setConstraints(jTextField6, gridBagCon);
		centerPanel.add(jTextField6);
		//资产状态
		gridBagCon.gridx =0;
		gridBagCon.gridy =3;
		gridBagCon.insets =new Insets(10,10,10,1);
		gridBag.setConstraints(jlabel7, gridBagCon);
		centerPanel.add(jlabel7);
		
		gridBagCon.gridx =1;
		gridBagCon.gridy =3;
		gridBagCon.insets =new Insets(10,1,10,15);
		gridBag.setConstraints(jTextField7, gridBagCon);
		centerPanel.add(jTextField7);
		//备注
		gridBagCon.gridx =2;
		gridBagCon.gridy =3;
		gridBagCon.insets =new Insets(10,15,10,1);
		gridBag.setConstraints(jlabel8, gridBagCon);
		centerPanel.add(jlabel8);
		
		gridBagCon.gridx =3;
		gridBagCon.gridy =3;
		gridBagCon.insets =new Insets(10,1,10,10);
		gridBag.setConstraints(jTextField8, gridBagCon);
		centerPanel.add(jTextField8);
		
		this.add(centerPanel,BorderLayout.CENTER);
		
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		
	}
	
	public void downInit(){
		downPanel.add(searchInfo);
		downPanel.add(addInfo);
		downPanel.add(modifyInfo);
		downPanel.add(deleteInfo);
		downPanel.add(saveInfo);
		downPanel.add(clearInfo);
		downPanel.add(exitInfo);
		
		this.add(downPanel,BorderLayout.SOUTH);
		
		//添加事件监听
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		jComboBox1.addItemListener(this);
		
		saveInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(false);
		
		
		
	}
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==searchInfo){ //获取新编号
			setNull();
			TypeBean bean =new TypeBean();
			jTextField1.setText(""+bean.getID());
			jTextField2.setEditable(true);
			jTextField3.setEditable(true);
			
			addInfo.setEnabled(true);
			modifyInfo.setEnabled(false);
			deleteInfo.setEnabled(false);
			
		}
		else if(obj==addInfo){//增加
			TypeBean bean =new TypeBean();
			bean.add(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
			this.dispose();  //关闭当前窗体
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==modifyInfo){//修改
			TypeBean bean =new TypeBean();
			bean.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
			this.dispose();
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==deleteInfo){//删除
			TypeBean bean =new TypeBean();
			bean.delete(jTextField1.getText());
			this.dispose();
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==clearInfo){//清空
			setNull();
		}
		else if(obj==exitInfo){//退出
			this.dispose();
		}
	}
	
	void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
		jTextField7.setText(null);
		jTextField8.setText(null);
	}

}
