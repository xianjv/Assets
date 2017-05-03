package com.lxj.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PersonBean {

	String sql;
	ResultSet rs=null;
	
	String field1;   //PersonID
	String field2;   //Name
	String field3;   //Sex
	String field4;   //Dept
	String field5;	 //Job
	String field6;	 //Other

	
	String colName;    //列名
	String colValue;   //列值
	String colValue2;  //列值
	
	public void add(String f1,String f2,String f3,String f4,String f5,String f6){
		Database db= new Database();
		
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		
		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入人员姓名","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "请输入性别","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "请输入工作部门","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}else{
				sql ="insert into Person values("+field1+",'"+field2+"','"+field3
						+"','"+field4+"','"+field5+"','"+field6+"')";
				
				db.OpenConn();
				db.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功添加一条记录！");
				db.close();
			}
		}
	public int getID(){
		Database db =new Database();
		int ID=1;
		sql="select max(PersonID) from Person";
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
	
	public void modify(String f1,String f2,String f3,String f4,String f5,String f6){
		Database db= new Database();
		
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		
		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入人员姓名","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "请输入性别","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "请输入工作部门","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}else{
				sql ="update Person set Name='"+field2+"',Sex='"+field3+"',Dept='"+field4
						+"',Job='"+field5+"',Other='"+field6+"' where PersonID ="+field1;
				
				db.OpenConn();
				db.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功修改一条记录！");
				db.close();
			}
		}
	public String[] search(String id){
		Database db= new Database();
		
		this.field1 =id;
		String[] s=new String[5];
		
		sql = "select * from Person where PersonID = "+field1;
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.next()){
				s[0]=rs.getString("Name");
				s[1]=rs.getString("Sex");
				s[2]=rs.getString("Dept");
				s[3]=rs.getString("Job");
				s[4]=rs.getString("Other");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		return s;
	}
	public String[] getAllID(){
		String[] s=null;
		int row=0;
		int i=0;
		Database db =new Database();
		sql ="select PersonID from Person";
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row ==0){
				s=null;
			}else{
				s= new String[row];
				rs.first();
				rs.previous(); //游标
				while(rs.next()){
					s[i]=rs.getString(1);
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		return s;
	}
	
	public void delete(String f1){
		Database db= new Database();
		this.field1=f1;
		sql ="delete from Person where PersonID ="+field1;
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "成功删除一条记录！");
		db.close();
	}
	
	public String[] searchAllName(){
		Database db=new Database();
		String[] sn =null;
		int row =0;
		int i =0;
		sql ="select PersonID,Name from Person order by PersonID";
		
		try {
			db.OpenConn();
			rs =db.executeQuery(sql);
			if(rs.last()){
				row =rs.getRow();
			}
			if(row ==0){
				sn= null;
			}else{
				sn= new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i] =rs.getString("PersonID")+"-"+rs.getString("Name");
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		
		
		
		return sn;
	}
	
	public String[][] searchAll(){
		Database db=new Database();
		String[][] sn =null;
		int row =0; 
		int i =0;
		sql="select * from Person order by PersonID";
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =null;
			}else{
				sn =new  String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("PersonID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("Sex");
					sn[i][3]=rs.getString("Dept");
					sn[i][4]=rs.getString("Job");
					sn[i][5]=rs.getString("Other");
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		return sn;
	}
	
	
	public String getPersonName(String f1){
		Database db =new Database();
		this.field1 =f1;
		String s= "";
		sql="select Name from Person where PersonID="+field1;
		
		db.OpenConn();
		rs =db.executeQuery(sql);
		try {
			if(rs.next()){
				s =rs.getString("Name");
			}else{
				s =null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		
		return s;
	}
	
	public String[][] searchAll(String f1){
		this.field1=f1;
		Database db =new Database();
		String[][] sn =null;
		int row =0;
		int i =0;
		sql ="select * from Person where PersonID="+field1+" order by PersonID";
		
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =null;
			}else{
				sn =new  String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("PersonID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("Sex");
					sn[i][3]=rs.getString("Dept");
					sn[i][4]=rs.getString("Job");
					sn[i][5]=rs.getString("Other");
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		
		return sn;
	}
	
	
	
	
	
	
	
}
