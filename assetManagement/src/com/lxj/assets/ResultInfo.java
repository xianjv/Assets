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
	JButton createQRcode =new JButton("���ɶ�ά��");
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
		
		this.setTitle("�ʲ���ѯ���");
		//this.setLocationRelativeTo(null);
		
		String[] colName ={"�ʲ����","�ʲ�����","��������","�ͺ�","�۸�","��������","״̬","��ע"};
		
		AssetsBean ab =new AssetsBean();
		colValue=ab.searchAll();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		
		this.setTitle("�ʲ���ѯ���");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"��Ա���","����","�Ա�","����","ְλ","����"};
		
		PersonBean pb =new PersonBean();
		colValue=pb.searchAll();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		this.setTitle("��Ϣ��ѯ���");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForUse();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		this.setTitle("��Ϣ��ѯ���");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForBack();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		this.setTitle("��Ϣ��ѯ���");
		this.setSize(1500,450);
		this.setLocationRelativeTo(null);
		
		String[] colName ={"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		
		AssetsTrjnBean bean =new AssetsTrjnBean();
		colValue=bean.searchAllForInvalid();
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		this.setTitle("��Ϣ��ѯ���");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"�ʲ����","�ʲ�����","��������","�ͺ�","�۸�","��������","״̬","��ע"};
		AssetsBean ab =new AssetsBean();
		colValue=ab.searchAll(tableID);
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		this.setTitle("��Ϣ��ѯ���");
		this.setLocationRelativeTo(null);
		
		String[] colName ={"��Ա���","����","�Ա�","����","ְλ","����"};
		PersonBean pb =new PersonBean();
		colValue=pb.searchAll(tableID);
		if(colValue==null){
			JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
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
		//�����ı������ʾ����"�ʲ����","�ʲ�����","��������","�ͺ�","�۸�","��������","״̬","��ע"
		for(int i=0;i<selectedRow.length;i++){
			for(int j=0;j<selectedCol.length;j++){
				 name = colValue[selectedRow[i]][1];
				 result="�ʲ����:"+colValue[selectedRow[i]][0]+
						"        �ʲ�����:"+colValue[selectedRow[i]][1]+
						"        ��������:"+colValue[selectedRow[i]][2]+
						"        �ͺ�:"+colValue[selectedRow[i]][3]+
						"        �۸�:"+colValue[selectedRow[i]][4]+
						"        ��������:"+colValue[selectedRow[i]][5]+
						"        ״̬:"+colValue[selectedRow[i]][6]+
						"        ��ע:"+colValue[selectedRow[i]][7];
				//System.out.println(name);
			}
		}
	}
	
}
