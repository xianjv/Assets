package com.lxj.assets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

public class DeleteAssets extends AssetsInfo{
	String id_str;
	public DeleteAssets(){
		this.setTitle("ɾ���ʲ���Ϣ");
		this.setResizable(false);
		
		jTextField1.setEditable(false);
		jTextField1.setText("���ѯ���");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		jComboBox1.setEditable(false);
		jComboBox1.setEnabled(false);
		
		this.setLocationRelativeTo(null); //����
		
		this.setVisible(true);
	}
	public void downInit(){
		searchInfo.setText("�ʲ���Ų�ѯ");
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
		String[] str =new String[8];
		if(obj==searchInfo){ //��ȡ�±��
			setNull();
			ModifyAssetsSearch modify_search =new ModifyAssetsSearch(this);
			modify_search.pack();
			try {
				id_str =modify_search.getID();
			} catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "û���ҵ��ñ�ţ�");
			}
			AssetsBean ab= new AssetsBean();
			str= ab.search(id_str);
			if(str==null){
				JOptionPane.showInternalMessageDialog(null, "��¼�����ڣ�");
				
				jTextField1.setText("�������ʲ����");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				jTextField7.setEditable(false);
				jTextField8.setEditable(false);
				jComboBox1.setEnabled(false);
				return;
			}else{
				jTextField1.setText(id_str);
				jTextField2.setText(str[0]);
				jTextField3.setText(str[1]);
				int index =Integer.parseInt(str[1])-1;
				//System.out.println(index);
				jComboBox1.setSelectedIndex(index);
				jTextField4.setText(str[2]);
				jTextField5.setText(str[3]);
				jTextField6.setText(str[4]);
				jTextField7.setText(str[5]);
				jTextField8.setText(str[6]);
				
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
				AssetsBean ab= new AssetsBean();
				ab.delete(id_str);
				setNull();
				deleteInfo.setEnabled(false);
			}else{
				return;
			}
		}
	}
	
}
