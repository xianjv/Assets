package com.lxj.assets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
/*
 * ��Ա��Ϣ�ۺ���
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonInfo extends JFrame implements ActionListener{


	JPanel upPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	JPanel downPanel=new JPanel();
	//�����ܴ�С
	Dimension faceSize =new Dimension(800,500);
	//����ͼ�ν���Ԫ��
	JLabel jlabel1 =new JLabel("���:");
	JLabel jlabel2 =new JLabel("����:");
	JLabel jlabel3 =new JLabel("�Ա�:");
	JLabel jlabel4 =new JLabel("����:");
	JLabel jlabel5 =new JLabel("ְλ:");
	JLabel jlabel6 =new JLabel("����:");
	
	JTextField jTextField1 =new JTextField(15); //���
	JTextField jTextField2 =new JTextField(15); //����
	JTextField jTextField3 =new JTextField(15); //�Ա�
	JTextField jTextField4 =new JTextField(15); //����
	JTextField jTextField5 =new JTextField(15); //ְλ
	JTextField jTextField6 =new JTextField(15); //����
	
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
	
	public PersonInfo(){
		//���ô����С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("��Ա�ۺ���Ϣ����");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);		
	}
	
	public void Init() throws Exception{
this.setLayout(new BorderLayout());
		
		//�в���岼��
		centerPanel.setLayout(gridBag);
		//���
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
		//����
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
		//�Ա�
		gridBagCon.gridx =0;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,10,10,1);
		gridBag.setConstraints(jlabel3, gridBagCon);
		centerPanel.add(jlabel3);
		
		
		gridBagCon.gridx =1;
		gridBagCon.gridy =1;
		gridBagCon.insets =new Insets(10,1,10,15);
		gridBag.setConstraints(jTextField3, gridBagCon);
		centerPanel.add(jTextField3);
		//����
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
		//ְλ
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
		//����
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
		
		this.add(centerPanel,BorderLayout.CENTER);
		
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
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
		
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		saveInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(false);
	}
		
	void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
