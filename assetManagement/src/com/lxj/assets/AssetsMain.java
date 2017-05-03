package com.lxj.assets;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AssetsMain extends JFrame implements ActionListener{
	//框架大小
	Dimension faceSize =new Dimension(600,450);
	//建立菜单栏
	JMenuBar mainMenu =new JMenuBar();
	//系统管理菜单
	JMenu menuSystem =new JMenu("系统管理");
	JMenuItem itemTypeMan =new JMenuItem("类别管理");
	JMenuItem itemExit =new JMenuItem("退出");
	
	
	//资产信息管理菜单
	JMenu menuAssets =new JMenu("资产信息管理");
	JMenuItem itemAddAssets =new JMenuItem("增加");
	JMenuItem itemModifyAssets =new JMenuItem("修改");
	JMenuItem itemDeleteAssets =new JMenuItem("删除");
	
	//资产查询菜单
	JMenu menuSelectAssets =new JMenu("查询");
	JMenuItem itemSelectAssetsAll =new JMenuItem("查询所有(生成二维码)");
	JMenuItem itemSelectAssetsID =new JMenuItem("按编号查询");
	
	//人员信息管理菜单
	JMenu menuPerson =new JMenu("人员信息管理");
	JMenuItem itemAddPerson =new JMenuItem("增加人员信息");
	JMenuItem itemModifyPerson =new JMenuItem("修改人员信息");
	JMenuItem itemDeletePerson =new JMenuItem("删除人员信息");
	
	//人员查询菜单
	JMenu menuSelectPerson =new JMenu("查询人员信息");
	JMenuItem itemSelectPersonAll =new JMenuItem("查询所有人员信息");
	JMenuItem itemSelectPersonID =new JMenuItem("按编号查询人员信息");
	
	//资产领用菜单
	JMenu menuUsing =new JMenu("资产领用");
	JMenuItem itemUsing =new JMenuItem("资产领用管理");
	JMenuItem itemSelectUsing =new JMenuItem("领用信息查询");
	
	//资产归还菜单
	JMenu menuBack =new JMenu("资产归还");
	JMenuItem itemBack =new JMenuItem("资产归还管理");
	JMenuItem itemSelectBack =new JMenuItem("归还信息查询");
	
	//资产报废菜单
	JMenu menuInvalid =new JMenu("资产报废");
	JMenuItem itemInvalid =new JMenuItem("资产报废管理");
	JMenuItem itemSelectInvalid =new JMenuItem("报废信息查询");
	
	
	public AssetsMain(){
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		//添加程序的关闭事件处理
		this.setDefaultCloseOperation(3);
		this.pack();
		//设置框架大小
		this.setSize(faceSize);
		this.setLocationRelativeTo(null);
		this.setTitle("资产管理系统");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}

	public void Init() throws Exception{
		//加入系统管理菜单
		menuSystem.add(itemTypeMan);
		menuSystem.add(itemExit);
		mainMenu.add(menuSystem);
		
		//加入资产信息管理菜单
		menuAssets.add(itemAddAssets);
		menuAssets.add(itemModifyAssets);
		menuAssets.add(itemDeleteAssets);
		menuAssets.addSeparator();
		menuAssets.add(menuSelectAssets);
		menuSelectAssets.add(itemSelectAssetsAll);
		menuSelectAssets.add(itemSelectAssetsID);
		mainMenu.add(menuAssets);
		
		//加入人员信息管理菜单
		menuPerson.add(itemAddPerson);
		menuPerson.add(itemModifyPerson);
		menuPerson.add(itemDeletePerson);
		menuPerson.addSeparator();
		menuPerson.add(menuSelectPerson);
		menuSelectPerson.add(itemSelectPersonAll);
		menuSelectPerson.add(itemSelectPersonID);
		mainMenu.add(menuPerson);
		//加入资产领用菜单
		menuUsing.add(itemUsing);
		menuUsing.add(itemSelectUsing);
		mainMenu.add(menuUsing);
		//加入资产归还菜单
		menuBack.add(itemBack);
		menuBack.add(itemSelectBack);
		mainMenu.add(menuBack);
		//加入资产报废菜单
		menuInvalid.add(itemInvalid);
		menuInvalid.add(itemSelectInvalid);
		mainMenu.add(menuInvalid);
		//加入到菜单栏
		this.setJMenuBar(mainMenu);
		//添加事件监听
		itemTypeMan.addActionListener(this);
		itemExit.addActionListener(this);
		itemAddAssets.addActionListener(this);
		itemModifyAssets.addActionListener(this);
		itemDeleteAssets.addActionListener(this);
		itemSelectAssetsAll.addActionListener(this);
		itemSelectAssetsID.addActionListener(this);
		itemAddPerson.addActionListener(this);
		itemModifyPerson.addActionListener(this);
		itemDeletePerson.addActionListener(this);
		itemSelectPersonAll.addActionListener(this);
		itemSelectPersonID.addActionListener(this);
		itemUsing.addActionListener(this);
		itemSelectUsing.addActionListener(this);
		itemBack.addActionListener(this);
		itemSelectBack.addActionListener(this);
		itemInvalid.addActionListener(this);
		itemSelectInvalid.addActionListener(this);
		
		//关闭程序时的操作
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		//退出
		if(obj ==itemExit){
			System.exit(0);
		}
		//资产类别管理
		else if(obj == itemTypeMan){
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
		}
		//增加资产信息
		else if(obj == itemAddAssets){
			AddAssets add =new AddAssets();
			add.downInit();
			add.pack();
		}
		//修改资产信息
		else if(obj == itemModifyAssets){
			ModifyAssets modify =new ModifyAssets();
			modify.downInit();
			modify.pack();
		}
		//删除资产信息
		else if(obj == itemDeleteAssets){
			DeleteAssets delete =new DeleteAssets();
			delete.downInit();
			delete.pack();
		}
		//查询所有资产信息
		else if(obj == itemSelectAssetsAll){
			ResultInfo info =new ResultInfo();
			info.resultAssetsAll();
		}
		//以编号查询资产信息
		else if(obj == itemSelectAssetsID){
			SearchIDInfo info =new SearchIDInfo("Assets");
			info.pack();
		}
		//增加人员信息
		else if(obj == itemAddPerson){
			AddPerson add =new AddPerson();
			add.downInit();
			add.pack();
		}
		//修改人员信息
		else if(obj == itemModifyPerson){
			ModifyPerson modify =new ModifyPerson();
			modify.downInit();
			modify.pack();
		}
		//删除人员信息
		else if(obj == itemDeletePerson){
			DeletePerson delete =new DeletePerson();
			delete.downInit();
			delete.pack();
		}
		//查询所有人员信息
		else if(obj == itemSelectPersonAll){
			ResultInfo info =new ResultInfo();
			info.resultPersonAll();
		}
		//以编号查询人员信息
		else if(obj == itemSelectPersonID){
			SearchIDInfo info =new SearchIDInfo("Person");
			info.pack();
		}
		//资产领用
		else if(obj == itemUsing){
			UseAssets use =new UseAssets();
			use.pack();
		}
		//领用资产查询
		else if(obj == itemSelectUsing){
			ResultInfo info =new ResultInfo();
			info.resultUseAll();
		}
		//资产归还
		else if(obj == itemBack){
			BackAssets ba =new BackAssets();
			ba.pack();
		}
		//资产归还查询
		else if(obj == itemSelectBack){
			ResultInfo info =new ResultInfo();
			info.resultBackAll();
		}
		//资产报废
		else if(obj == itemInvalid){
			InvalidAssets ia =new InvalidAssets();
			ia.pack();
		}
		//资产报废查询
		else if(obj == itemSelectInvalid){
			ResultInfo info =new ResultInfo();
			info.resultInvalidAll();
		}

		
	}
	
}
	
	
