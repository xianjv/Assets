package com.lxj.assets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
/*
 *�ʲ���Ϣ�ۺϹ����� 
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
	//�����ܴ�С
	Dimension faceSize =new Dimension(800,500);
	//����ͼ�ν���Ԫ��
	JLabel jlabel1 =new JLabel("�ʲ����:");
	JLabel jlabel2 =new JLabel("�ʲ�����:");
	JLabel jlabel3 =new JLabel("��������:");
	JLabel jlabel4 =new JLabel("�ʲ��ͺ�:");
	JLabel jlabel5 =new JLabel("�ʲ��۸�:");
	JLabel jlabel6 =new JLabel("��������:");
	JLabel jlabel7 =new JLabel("�ʲ�״̬:");
	JLabel jlabel8 =new JLabel("��ע:");
	JLabel jlabel9 =new JLabel(":");
	
	JTextField jTextField1 =new JTextField(15); //�ʲ����
	JTextField jTextField2 =new JTextField(15); //�ʲ�����
	JTextField jTextField3 =new JTextField(15); //��������
	JTextField jTextField4 =new JTextField(15); //�ʲ��ͺ�
	JTextField jTextField5 =new JTextField(15); //�ʲ��۸�
	JTextField jTextField6 =new JTextField(15); //��������
	JTextField jTextField7 =new JTextField(15); //�ʲ�״̬
	JTextField jTextField8 =new JTextField(15); //��ע
//	JTextField jTextField9 =new JTextField(46); 
	
	JComboBox jComboBox1 =null;
//	JComboBox jComboBox2 =null;
	
	JButton searchInfo =new JButton("��ѯ");
	JButton addInfo =new JButton("����");
	JButton modifyInfo =new JButton("�޸�");
	JButton deleteInfo =new JButton("ɾ��");
	JButton clearInfo =new JButton("���");
	JButton saveInfo =new JButton("����");
	JButton exitInfo =new JButton("�˳�");
	
	JButton jBSee =new JButton("");
	JButton JBSearch =new JButton("");
	JButton JBExit =new JButton("");
	JButton JBSum =new JButton("");
	JButton JBGrade =new JButton("");
	
	GridBagLayout gridBag =new GridBagLayout();
	GridBagConstraints gridBagCon;
	
	public AssetsInfo() {
		//���ô����С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("�ʲ��ۺ���Ϣ����");
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
		
		//�в���岼��
		centerPanel.setLayout(gridBag);
		//�ʲ����
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
		//�ʲ�����
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
		//��������
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
		//�ʲ��ͺ�
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
		//�ʲ��۸�
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
		//��������
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
		//�ʲ�״̬
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
		//��ע
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
		
		//����¼�����
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
