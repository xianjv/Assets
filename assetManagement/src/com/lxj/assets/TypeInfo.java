package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TypeInfo extends JFrame implements ActionListener,ListSelectionListener{

	//Container contentPane;
	//�������õ����
	JPanel upPanel =new JPanel();
	JPanel centerPanel =new JPanel();
	JPanel downPanel =new JPanel();
	
	//��ܴ�С
	Dimension faceSize =new Dimension(700,450);
	
	//����ͼ�ν���Ԫ��
	JLabel jLabel1= new JLabel("���");
	JLabel jLabel2= new JLabel("����");
	JLabel jLabel3= new JLabel("С��");
	
	JTextField jTextField1 =new JTextField(15);
	JTextField jTextField2 =new JTextField(15);
	JTextField jTextField3 =new JTextField(15);
	
	JButton searchInfo =new JButton("��ȡ�±��");
	JButton addInfo =new JButton("����");
	JButton modifyInfo =new JButton("�޸�");
	JButton deleteInfo =new JButton("ɾ��");
	JButton clearInfo =new JButton("���");
	//JButton saveInfo =new JButton("");
	JButton exitInfo =new JButton("�˳�");
	
	//������
	JScrollPane jScrollPane1;
	JTable jTable;
	ListSelectionModel listSelectionModel =null;
	String [] colName ={"�ʲ������","�ʲ�����","�ʲ�С��"};
	String [] [] colValue;
	
	GridBagLayout girdBag =new GridBagLayout();
	GridBagConstraints girdBagCon;
	
	public TypeInfo(){
		this.setSize(faceSize);
		this.setTitle("�ʲ�������");
		this.setResizable(false);
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-700)/2, (screenSize.height-450)/2);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
	public void Init() throws Exception{
		//contentPane=this.getContentPane();
		this.setLayout(new BorderLayout());
		
		//�в����Ĳ���
		TypeBean bean =new TypeBean();
		colValue = bean.searchAll();
		jTable= new JTable(colValue,colName);
		jTable.setPreferredScrollableViewportSize(new Dimension(400, 300));
		listSelectionModel =jTable.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel.addListSelectionListener(this);
		jScrollPane1=new JScrollPane(jTable);
		jScrollPane1.setPreferredSize(new Dimension(400, 300));
		
		upPanel.add(jScrollPane1);
		this.add(upPanel,BorderLayout.NORTH);
		
		centerPanel.add(jLabel1);
		centerPanel.add(jTextField1);
		centerPanel.add(jLabel2);
		centerPanel.add(jTextField2);
		centerPanel.add(jLabel3);
		centerPanel.add(jTextField3);
		this.add(centerPanel,BorderLayout.CENTER);
		
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		
	}
	/*
	 * �²���岼��
	 * */
	public void downInit(){
		downPanel.add(searchInfo);
		downPanel.add(addInfo);
		downPanel.add(modifyInfo);
		downPanel.add(deleteInfo);
		downPanel.add(clearInfo);
		downPanel.add(exitInfo);
		
		this.add(downPanel,BorderLayout.SOUTH);
		
		//����¼�����
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);
	}
	
	
	
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
//		System.out.println(1);
		int [] selectedRow =jTable.getSelectedRows();
		int [] selectedCol =jTable.getSelectedColumns();
		//�����ı������ʾ����
		for(int i=0;i<selectedRow.length;i++){
			for(int j=0;j<selectedCol.length;j++){
				jTextField1.setText(colValue[selectedRow[i]][0]);
				jTextField2.setText(colValue[selectedRow[i]][1]);
				jTextField3.setText(colValue[selectedRow[i]][2]);
			}
		}
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(true);
		deleteInfo.setEnabled(true);
		clearInfo.setEnabled(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==searchInfo){ //��ȡ�±��
			setNull();
			TypeBean bean =new TypeBean();
			jTextField1.setText(""+bean.getID());
			jTextField2.setEditable(true);
			jTextField3.setEditable(true);
			
			addInfo.setEnabled(true);
			modifyInfo.setEnabled(false);
			deleteInfo.setEnabled(false);
			
		}
		else if(obj==addInfo){//����
			TypeBean bean =new TypeBean();
			bean.add(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
			this.dispose();  //�رյ�ǰ����
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==modifyInfo){//�޸�
			TypeBean bean =new TypeBean();
			bean.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
			this.dispose();
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==deleteInfo){//ɾ��
			TypeBean bean =new TypeBean();
			bean.delete(jTextField1.getText());
			this.dispose();
			
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
			ti.setVisible(true);
		}
		else if(obj==clearInfo){//���
			setNull();
		}
		else if(obj==exitInfo){//�˳�
			this.dispose();
		}
		jTable.revalidate();
		
	}
	
	public void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);
	}
}
