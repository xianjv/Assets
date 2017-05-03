package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ResultInfo extends JFrame implements ActionListener,ListSelectionListener{

	JLabel jlabel=new JLabel();
	JButton jBEXit =new JButton();
	JButton createQRcode =new JButton("生成二维码");
	JScrollPane jScrollPane1;
	JTable jTable;
	ListSelectionModel listSelectionModel =null;
	
	String sNum;
	String[][] colValue;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;
	String tableID;
	String name;
	String result;
	
	public ResultInfo() {
		createQRcode.addActionListener(this);
		createQRcode.setEnabled(false);
	}
	public void resultAssetsAll(){
		
		this.setTitle("资产查询结果");
		//this.setLocationRelativeTo(null);
		
		String[] colName ={"资产编号","资产名称","所属类型","型号","价格","购买日期","状态","备注"};
		
		AssetsBean ab =new AssetsBean();
		colValue=ab.searchAll();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			listSelectionModel =jTable.getSelectionModel();
			listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listSelectionModel.addListSelectionListener(this);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.add(createQRcode, BorderLayout.SOUTH);
			this.pack();
			this.setVisible(true);
		}
	}

	
public void resultPersonAll(){
		
		this.setTitle("资产查询结果");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"人员编号","姓名","性别","部门","职位","其他"};
		
		PersonBean pb =new PersonBean();
		colValue=pb.searchAll();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
	}
	
	public void resultUseAll(){
		this.setTitle("信息查询结果");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"编号","资产名称","操作时间","领用人","用途","备注"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForUse();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
	}
	
	public void resultBackAll(){
		this.setTitle("信息查询结果");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"编号","资产名称","操作时间","领用人","用途","备注"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForBack();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
	}
	
	public void resultInvalidAll(){
		this.setTitle("信息查询结果");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"编号","资产名称","操作时间","领用人","用途","备注"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForInvalid();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
	}


	public void resultAssetsID(String ID) {
		this.tableID=ID;
		this.setTitle("信息查询结果");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"资产编号","资产名称","所属类型","型号","价格","购买日期","状态","备注"};
		AssetsBean ab =new AssetsBean();
		colValue=ab.searchAll(tableID);
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
		
		
	}
	
	public void resultPersonID(String ID) {
		this.tableID=ID;
		this.setTitle("信息查询结果");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"人员编号","姓名","性别","部门","职位","其他"};
		PersonBean pb =new PersonBean();
		colValue=pb.searchAll(tableID);
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "没有符合条件的记录");
			this.dispose();
		}else{
			jTable = new JTable(colValue,colName);
			
			jScrollPane1 =new JScrollPane(jTable);
			
			this.add(jScrollPane1,BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
		
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {	
		Object obj =e.getSource();
		if(obj==createQRcode){ 
			CreateQRCode qr=new CreateQRCode();
			qr.toQRCode(name,result);
		}
		
	
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		createQRcode.setEnabled(true);
		int [] selectedRow =jTable.getSelectedRows();
		int [] selectedCol =jTable.getSelectedColumns();
		//定义文本框的显示内容"资产编号","资产名称","所属类型","型号","价格","购买日期","状态","备注"
		for(int i=0;i<selectedRow.length;i++){
			for(int j=0;j<selectedCol.length;j++){
				 name = colValue[selectedRow[i]][1];
				 result="资产编号:"+colValue[selectedRow[i]][0]+
						"        资产名称:"+colValue[selectedRow[i]][1]+
						"        所属类型:"+colValue[selectedRow[i]][2]+
						"        型号:"+colValue[selectedRow[i]][3]+
						"        价格:"+colValue[selectedRow[i]][4]+
						"        购买日期:"+colValue[selectedRow[i]][5]+
						"        状态:"+colValue[selectedRow[i]][6]+
						"        备注:"+colValue[selectedRow[i]][7];
				//System.out.println(name);
			}
		}
	}
	
}
