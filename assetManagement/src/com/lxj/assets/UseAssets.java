package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UseAssets extends JFrame implements ActionListener,ListSelectionListener,ItemListener{
	//定义所用面板
	JPanel mainPanel=new JPanel();
	JPanel upPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	JPanel downPanel=new JPanel();
	
	//定义图形界面元素
	JLabel jLabel1 =new JLabel();
	JLabel jLabel2 =new JLabel();
	JLabel jLabel3 =new JLabel();
	JLabel jLabel4 =new JLabel();
	JLabel jLabel5 =new JLabel();
	
	String JourNo ="1";
	String FormAcc="设备借用";
	String AssetsID=null;
	JComboBox jComboBox =null;
	String PersonID="1";
	JTextField jTextField1 =new JTextField(15);
	JTextField jTextField2 =new JTextField(15);
	JTextField jTextField3 =new JTextField(15);
	JButton modifyInfo =new JButton();
	JButton clearInfo =new JButton();
	
	//定义表格
	JScrollPane jScrollPane1;
	JTable jTable;
	ListSelectionModel listSelectionModel =null;
	String[] colName ={"资产编号","名称","类别","型号","价格"};
	String[][] colValue;
	
	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints gridBagCon;
	
	public UseAssets() {
		this.setLayout(new BorderLayout());
		this.setTitle("资产领用管理");
		
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		Point size =new Point((screenSize.width-400)/2,(screenSize.height-500)/2);
		this.setLocation(size);
		
		try {
			Init();
			makeFrame();
			addListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		this.setVisible(true);
		
	}
	
	public void Init() throws Exception{
		AssetsBean bean=new AssetsBean();
		upPanel.setLayout(gridBag);
		
		jLabel1.setText("资产领用管理");
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx=0;
		gridBagCon.gridy=0;
		gridBagCon.gridwidth=4;
		gridBagCon.gridheight=1;
		gridBagCon.insets =new Insets(0,10,0,10);
		gridBag.setConstraints(jLabel1, gridBagCon);
		upPanel.add(jLabel1);
		
		gridBagCon =new GridBagConstraints();
		colValue =bean.searchAllForUse();
		jTable =new JTable(colValue,colName);
		jTable.setPreferredScrollableViewportSize(new Dimension(450,280));
		listSelectionModel =jTable.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel.addListSelectionListener(this);
		jScrollPane1 =new JScrollPane(jTable);
		jScrollPane1.setPreferredSize(new Dimension(450,280));
		
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx=0;
		gridBagCon.gridy=1;
		gridBagCon.gridwidth=4;
		gridBagCon.gridheight=1;
		gridBagCon.insets =new Insets(0,0,10,0);
		gridBag.setConstraints(jScrollPane1, gridBagCon);
		upPanel.add(jScrollPane1);
		
		gridBagCon =new GridBagConstraints();
		jLabel2.setText("资产名称");
		gridBagCon.gridx=0;
		gridBagCon.gridy=2;
		gridBagCon.insets =new Insets(10,20,10,1);
		gridBag.setConstraints(jLabel2, gridBagCon);
		upPanel.add(jLabel2);
		
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx=1;
		gridBagCon.gridy=2;
		gridBagCon.insets =new Insets(10,1,10,20);
		gridBag.setConstraints(jTextField1, gridBagCon);
		upPanel.add(jTextField1);
		
		gridBagCon =new GridBagConstraints();
		jLabel3.setText("领用人员");
		gridBagCon.gridx=2;
		gridBagCon.gridy=2;
		gridBagCon.insets =new Insets(10,20,10,1);
		gridBag.setConstraints(jLabel3, gridBagCon);
		upPanel.add(jLabel3);
		
		gridBagCon =new GridBagConstraints();
		PersonBean pb =new PersonBean();
		String[] allType =pb.searchAllName();
		jComboBox =new JComboBox(allType);
		gridBagCon.gridx=3;
		gridBagCon.gridy=2;
		gridBagCon.insets =new Insets(10,1,10,20);
		gridBag.setConstraints(jComboBox, gridBagCon);
		upPanel.add(jComboBox);
		
		gridBagCon =new GridBagConstraints();
		jLabel4.setText("用	途");
		gridBagCon.gridx=0;
		gridBagCon.gridy=3;
		gridBagCon.insets =new Insets(10,20,10,1);
		gridBag.setConstraints(jLabel4, gridBagCon);
		upPanel.add(jLabel4);
		
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx=1;
		gridBagCon.gridy=3;
		gridBagCon.insets =new Insets(10,1,10,20);
		gridBag.setConstraints(jTextField2, gridBagCon);
		upPanel.add(jTextField2);
		
		gridBagCon =new GridBagConstraints();
		jLabel5.setText("备	注");
		gridBagCon.gridx=2;
		gridBagCon.gridy=3;
		gridBagCon.insets =new Insets(10,20,10,1);
		gridBag.setConstraints(jLabel5, gridBagCon);
		upPanel.add(jLabel5);
		
		gridBagCon =new GridBagConstraints();
		gridBagCon.gridx=3;
		gridBagCon.gridy=3;
		gridBagCon.insets =new Insets(10,1,10,20);
		gridBag.setConstraints(jTextField3, gridBagCon);
		upPanel.add(jTextField3);
		
		gridBagCon =new GridBagConstraints();
		modifyInfo.setText("领用");
		gridBagCon.gridx=0;
		gridBagCon.gridy=4;
		gridBagCon.gridwidth=2;
		gridBagCon.gridheight=1;
		gridBagCon.insets =new Insets(10,80,10,20);
		gridBag.setConstraints(modifyInfo, gridBagCon);
		upPanel.add(modifyInfo);
		
		gridBagCon =new GridBagConstraints();
		clearInfo.setText("清空");
		gridBagCon.gridx=2;
		gridBagCon.gridy=4;
		gridBagCon.gridwidth=2;
		gridBagCon.gridheight=1;
		gridBagCon.insets =new Insets(10,20,10,80);
		gridBag.setConstraints(clearInfo, gridBagCon);
		upPanel.add(clearInfo);
		
		jTextField1.setEnabled(false);
		jTextField2.setEnabled(false);
		jTextField3.setEnabled(false);
	}
	//生成主界面
	public void makeFrame(){
		this.setLayout(new BorderLayout());
		this.add(upPanel,BorderLayout.SOUTH);
		
	}
	
	void setNull(){
		jTextField2.setText(null);
		jTextField3.setText(null);
	}
	
	public void addListener(){
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		
		jComboBox.addItemListener(this);
	}
	
	
	
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){ 
			String tempStr =""+e.getItem();
			int i =tempStr.indexOf("-");
			PersonID=tempStr.substring(0,i);
		}
			
	}
	
	
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(1);
		int [] selectedRow =jTable.getSelectedRows();
		int [] selectedCol =jTable.getSelectedColumns();
		//定义文本框的显示内容
		for(int i=0;i<selectedRow.length;i++){
			for(int j=0;j<selectedCol.length;j++){
				jTextField1.setText(colValue[selectedRow[i]][1]);//名称
				AssetsID =colValue[selectedRow[i]][0];//资产编号
			}
		}
		//设置可否操作
		jTextField2.setEnabled(true);
		jTextField3.setEnabled(true);
		modifyInfo.setEnabled(true);
		clearInfo.setEnabled(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj ==modifyInfo){
			AssetsBean ab=new AssetsBean();
			ab.updateStatus(AssetsID,"借出");
			
			AssetsTrjnBean atb =new AssetsTrjnBean();
			JourNo =""+atb.getID();
			Date now = new Date();
			DateFormat date =DateFormat.getTimeInstance();
			String f4 =""+date.format(now);
			atb.add(JourNo,"设备借用",AssetsID,f4,PersonID,jTextField2.getText(),
					jTextField3.getText());
			//重新生成界面
			this.dispose();
			UseAssets ua =new UseAssets();
			ua.pack();
			
		}
		else if(obj ==clearInfo){
			setNull();
			
		}
		jTable.revalidate();
	}

	
}
