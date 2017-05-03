package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

public class DeletePerson extends PersonInfo{
	String id_str;
	public DeletePerson(){
		this.setTitle("ɾ����Ա��Ϣ");
		this.setResizable(false);
		
		jTextField1.setEditable(false);
		jTextField1.setText("���ѯ���");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		
		this.setLocationRelativeTo(null); //����
		
		this.setVisible(true);
	}
	public void downInit(){
		searchInfo.setText("��Ա��Ų�ѯ");
		downPanel.add(searchInfo);
		downPanel.add(deleteInfo);
		downPanel.add(exitInfo);
		
		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		exitInfo.setEnabled(true);
		
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.add(downPanel,BorderLayout.SOUTH);
		
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		String[] str =new String[6];
		if(obj==searchInfo){ //��ȡ�±��
			setNull();
			ModifyPersonSearch modify_search=new ModifyPersonSearch(this);
			modify_search.pack();
			try {
				id_str =modify_search.getID();
			} catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "û���ҵ��ñ�ţ�");
			}
			PersonBean pb= new PersonBean();
			str= pb.search(id_str);
			if(str==null){
				JOptionPane.showInternalMessageDialog(null, "��¼�����ڣ�");
				
				jTextField1.setText("��������Ա���");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				return;
			}else{
				jTextField1.setText(id_str);
				jTextField2.setText(str[0]);
				jTextField3.setText(str[1]);
				jTextField4.setText(str[2]);
				jTextField5.setText(str[3]);
				jTextField6.setText(str[4]);
				
				deleteInfo.setEnabled(true);
			}
		}
		if(obj==exitInfo){
			this.dispose();
		}
		if(obj==deleteInfo){
			int ifdel =JOptionPane.showConfirmDialog(null, "ȷ��ɾ������Ϣ","��ʾ��Ϣ",
					JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			
			if(ifdel == JOptionPane.YES_OPTION){
				PersonBean pb= new PersonBean();
				pb.delete(id_str);
				setNull();
				deleteInfo.setEnabled(false);
			}else{
				return;
			}
		}
	}
	
}
