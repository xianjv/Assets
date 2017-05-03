package com.lxj.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TypeBean {

	String sql;
	ResultSet rs =null;
	String field1;   //TypeID
	String field2;   //B_Type
	String field3;   //S_Type
	
	String colName;  //����
	String colValue;  //��ֵ
	String colValue2;  //��ֵ
	
	
	//�����Ϣ
	public void add(String id,String B,String S){
		Database db= new Database();
		
		this.field1 =id;
		this.field2 =B;
		this.field3 =S;
		
		if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�����","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�С��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql ="insert into AssetsType values("+field1+",'"+field2+"','"+field3+"')";
		}
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "�ɹ����һ����¼��");
		db.close();
		
		
	}
	//�޸���Ϣ
	public void modify(String id,String B,String S){
		Database db= new Database();
		
		this.field1 =id;
		this.field2 =B;
		this.field3 =S;
		
		if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�����","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�С��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql ="update AssetsType set B_Type= '"+field2+"', S_Type = '"+field3+"' where TypeID = "+field1;
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "�ɹ��޸�һ����¼��");
		db.close();
		}
		
	}
	//ɾ����Ϣ
	public void delete(String id){
		Database db= new Database();
		
		this.field1 =id;

		sql ="delete from AssetsType where TypeID = "+field1;
		
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "�ɹ�ɾ��һ����¼��");
		db.close();
		
	}
	//���ݱ�Ų�ѯ����
	public String[] search(String id){
		Database db= new Database();
		
		this.field1 =id;
		String[] s=new String[3];
		
		sql = "select * from AssetsType where TypeID = "+field1;
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.next()){
				s[0]=rs.getString("TypeID");
				s[1]=rs.getString("B_Type");
				s[2]=rs.getString("S_Type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		return s;
	}
	//���ݱ�Ų�ѯ����
		public String[][] searchAll(){
			Database db= new Database();
			
			String[][] s=null;
			int row =0;
			int i=0;
			
			sql = "select * from AssetsType order by TypeID";
			db.OpenConn();
			rs=db.executeQuery(sql);
			try {
				if(rs.last()){
					row=rs.getRow();
				}
				if(row==0){
					s=new String[1][3];
					s[0][0]="";
					s[0][1]="";
					s[0][2]="";
				}else{
					s=new String[row][3];
					rs.first();  //���α���������
					rs.previous(); //���α�������һ��
					while(rs.next()){
						s[i][0]=rs.getString("TypeID");
						s[i][1]=rs.getString("B_Type");
						s[i][2]=rs.getString("S_Type");
						i++;
						}
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			db.close();
			return s;
		}
	public int getID(){
		Database db =new Database();
		int ID=1;
		sql="select max(TypeID) from AssetsType";
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.next()){
				ID =rs.getInt(1)+1;
			}else
				ID =1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		return ID;
	}
	public String[] searchAllForAssets(){
		Database db=new Database();
		String s[] =null;
		int row=0;
		int i=0;
		sql="select * from AssetsType order by TypeID";
		
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row ==0){
				s[0]="";
				s[1]="";
				s[2]="";
			}else{
				s=new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i]=rs.getString("TypeID")+"-"+rs.getString("B_Type")
					+"-"+rs.getString("S_Type");
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		return s;
	}
	
	
	public String getDeptStr(String f1){
		Database db =new Database();
		this.field1 =f1;
		String s="";
		sql ="select * from AssetsType where TypeID ="+field1;
		
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.next()){
				s =rs.getString("B_Type")+"-"+rs.getString("S_Type");
			}else
				s= null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		return s;
		
		
	}
	
}
