package com.lxj.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AssetsBean {

	String sql;
	ResultSet rs=null;
	
	String field1;   //assetsID
	String field2;   //assetsName
	String field3;   //typeID
	String field4;   //model
	String field5;	 //price
	String field6;	 //buyDate
	String field7;	 //status
	String field8;	 //other
	
	String colName;    //列名
	String colValue;   //列值
	String colValue2;  //列值
	
	public void add(String f1,String f2,String f3,String f4,String f5,String f6,String f7,String f8){
		Database db= new Database();
		
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		this.field7=f7;
		this.field8=f8;
		
		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入资产编号","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备名称","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备类型","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field4 == null||field4.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备型号","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field5 == null||field5.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备价格","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}else{
				sql ="insert into Assets values("+field1+",'"+field2+"','"+field3
						+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"')";
				
				db.OpenConn();
				db.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功添加一条记录！");
				db.close();
			}
		}
	public int getID(){
		Database db =new Database();
		int ID=1;
		sql="select max(AssetsID) from Assets";
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
	
	public void modify(String f1,String f2,String f3,String f4,String f5,String f6,String f7,String f8){
		Database db= new Database();
		
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		this.field7=f7;
		this.field8=f8;
		
		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入资产编号","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备名称","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备类型","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field4 == null||field4.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备型号","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if(field5 == null||field5.equals("")){
			JOptionPane.showMessageDialog(null, "请输入设备价格","错误",JOptionPane.ERROR_MESSAGE);
			return;
			}else{
				sql ="update Assets set Name='"+field2+"',TypeID='"+field3+"',Model='"+field4
						+"',Price='"+field5+"',BuyDate='"+field6+"',Status='"+field7
						+"',Other='"+field8+"' where AssetsID ="+field1;
				
				db.OpenConn();
				db.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功修改一条记录！");
				db.close();
			}
		}
	public String[] search(String id){
		Database db= new Database();
		
		this.field1 =id;
		String[] s=new String[7];
		
		sql = "select * from Assets where AssetsID = "+field1;
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.next()){
				s[0]=rs.getString("Name");
				s[1]=rs.getString("TypeID");
				s[2]=rs.getString("Model");
				s[3]=rs.getString("Price");
				s[4]=rs.getString("BuyDate");
				s[5]=rs.getString("Status");
				s[6]=rs.getString("Other");
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
		sql ="select AssetsID from Assets";
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
				rs.previous();
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
		sql ="delete from Assets where AssetsID ="+field1;
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "成功删除一条记录！");
		db.close();
	}
	
	public String[][] searchAllForUse(){
		Database db =new Database();
		TypeBean tb= new TypeBean();
		String[][] sn= null;
		int row =0;
		int i =0;
		sql ="select * from Assets where Status='在库' order by AssetsID";
		
		try {
			db.OpenConn();
			rs =db.executeQuery(sql);
			if(rs.last()){
				row =rs.getRow();
			}
			if(row ==0){
				sn = new String[1][5];
				sn[0][0]=" ";
				sn[0][1]=" ";
				sn[0][2]=" ";
				sn[0][3]=" ";
				sn[0][4]=" ";
			}else{
				sn= new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] =rs.getString("AssetsID");
					sn[i][1] =rs.getString("Name");
					sn[i][2] =tb.getDeptStr(rs.getString("TypeID"));
					sn[i][3] =rs.getString("Model");
					sn[i][4] =rs.getString("Price");
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		
		return sn;
	}
	//修改信息
	public void updateStatus(String f1,String f7){
		Database db=new Database();
		this.field1=f1;
		this.field7=f7;
		sql ="update Assets set Status = '"+field7+"' where AssetsID ="+field1;
		
		db.OpenConn();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "操作成功");
		db.close();
		
	}
	
	public String[][] searchAllForBack(){
		Database db =new Database();
		TypeBean tb= new TypeBean();
		String[][] sn= null;
		int row =0;
		int i =0;
		sql ="select * from Assets where Status='借出' order by AssetsID";
		
		try {
			db.OpenConn();
			rs =db.executeQuery(sql);
			if(rs.last()){
				row =rs.getRow();
			}
			if(row ==0){
				sn = new String[1][5];
				sn[0][0]=" ";
				sn[0][1]=" ";
				sn[0][2]=" ";
				sn[0][3]=" ";
				sn[0][4]=" ";
			}else{
				sn= new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] =rs.getString("AssetsID");
					sn[i][1] =rs.getString("Name");
					sn[i][2] =tb.getDeptStr(rs.getString("TypeID"));
					sn[i][3] =rs.getString("Model");
					sn[i][4] =rs.getString("Price");
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
		sql="select * from Assets order by AssetsID";
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =null;
			}else{
				sn =new  String[row][8];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("AssetsID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("TypeID");
					sn[i][3]=rs.getString("Model");
					sn[i][4]=rs.getString("Price");
					sn[i][5]=rs.getString("BuyDate");
					sn[i][6]=rs.getString("Status");
					sn[i][7]=rs.getString("Other");
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		
		return sn;
	}
	
	
	public String getAssetsName(String f1){
		Database db =new Database();
		this.field1 =f1;
		String s= "";
		sql="select Name from Assets where AssetsID="+field1;
		
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
		sql ="select * from Assets where AssetsID="+field1+" order by AssetsID";
		
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =null;
			}else{
				sn =new  String[row][8];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("AssetsID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("TypeID");
					sn[i][3]=rs.getString("Model");
					sn[i][4]=rs.getString("Price");
					sn[i][5]=rs.getString("BuyDate");
					sn[i][6]=rs.getString("Status");
					sn[i][7]=rs.getString("Other");
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
