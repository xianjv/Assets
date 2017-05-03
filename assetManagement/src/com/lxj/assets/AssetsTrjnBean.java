package com.lxj.assets;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssetsTrjnBean {
	String sql;
	ResultSet rs=null;
	
	String field1;   //JourNo
	String field2;   //FromAcc
	String field3;   //OldInfo
	String field4;   //NewInfo
	String field5;	 //ChgTime
	String field6;	 //RegDate
	String field7;	 //PersonID
	
	String colName;    //列名
	String colValue;   //列值
	String colValue2;  //列值
	
	
	public int getID(){
		Database db =new Database();
		int ID =1;
		sql ="select max(JourNo) from AssetsTrjn";
		
		db.OpenConn();
		rs=db.executeQuery(sql);
		try {
			if(rs.next()){
				ID = rs.getInt(1)+1;
			}else
				ID =1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.close();
		
		return ID;
		
		
	}
	
	
	public void add(String f1,String f2,String f3,String f4,String f5,String f6,String f7){
		Database db= new Database();
		
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		this.field7=f7;
		
		sql ="insert into AssetsTrjn values("+field1+",'"+field2+"','"+field3
				+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"')";
		db.OpenConn();
		db.executeUpdate(sql);
		
		db.close();
		
		
	}
	
	
	public String[][] searchAllForUse(){
		Database db =new Database();
		AssetsBean ab=new AssetsBean();
		PersonBean pb=new PersonBean();
		
		String[][] sn =null;
		int row =0; 
		int i=0;
		sql ="select * from AssetsTrjn where FromAcc='设备借用' order by JourNo";
		db.OpenConn();
		rs =db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =new String[1][6];
				sn[0][0] =" ";
				sn[0][1] =" ";
				sn[0][2] =" ";
				sn[0][3] =" ";
				sn[0][4] =" ";
				sn[0][5] =" ";
			}else{
				sn =new  String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("JourNo");
					sn[i][1]=ab.getAssetsName(rs.getString("AssetsID"));
					sn[i][2]=rs.getString("RegDate");
					sn[i][3]=pb.getPersonName(rs.getString("PersonID"));
					sn[i][4]=rs.getString("UseTo");
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
	
	public String[][] searchAllForBack(){
		Database db =new Database();
		AssetsBean ab=new AssetsBean();
		PersonBean pb=new PersonBean();
		
		String[][] sn =null;
		int row =0; 
		int i=0;
		sql ="select * from AssetsTrjn where Fromacc='设备归还' order by JourNo";
		db.OpenConn();
		rs =db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =new String[1][6];
				sn[0][0] =" ";
				sn[0][1] =" ";
				sn[0][2] =" ";
				sn[0][3] =" ";
				sn[0][4] =" ";
				sn[0][5] =" ";
			}else{
				sn =new  String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("JourNo");
					sn[i][1]=ab.getAssetsName(rs.getString("AssetsID"));
					sn[i][2]=rs.getString("RegDate");
					sn[i][3]=pb.getPersonName(rs.getString("PersonID"));
					sn[i][4]=rs.getString("UseTo");
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
	
	public String[][] searchAllForInvalid(){
		Database db =new Database();
		AssetsBean ab=new AssetsBean();
		PersonBean pb=new PersonBean();
		
		String[][] sn =null;
		int row =0; 
		int i=0;
		sql ="select * from AssetsTrjn where Fromacc='设备报废' order by JourNo";
		db.OpenConn();
		rs =db.executeQuery(sql);
		try {
			if(rs.last()){
				row =rs.getRow();
			}
			if(row == 0){
				sn =new String[1][6];
				sn[0][0] =" ";
				sn[0][1] =" ";
				sn[0][2] =" ";
				sn[0][3] =" ";
				sn[0][4] =" ";
				sn[0][5] =" ";
			}else{
				sn =new  String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("JourNo");
					sn[i][1]=ab.getAssetsName(rs.getString("AssetsID"));
					sn[i][2]=rs.getString("RegDate");
					sn[i][3]=pb.getPersonName(rs.getString("PersonID"));
					sn[i][4]=rs.getString("UseTo");
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
