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
	//��ܴ�С
	Dimension faceSize =new Dimension(600,450);
	//�����˵���
	JMenuBar mainMenu =new JMenuBar();
	//ϵͳ����˵�
	JMenu menuSystem =new JMenu("ϵͳ����");
	JMenuItem itemTypeMan =new JMenuItem("������");
	JMenuItem itemExit =new JMenuItem("�˳�");
	
	
	//�ʲ���Ϣ����˵�
	JMenu menuAssets =new JMenu("�ʲ���Ϣ����");
	JMenuItem itemAddAssets =new JMenuItem("����");
	JMenuItem itemModifyAssets =new JMenuItem("�޸�");
	JMenuItem itemDeleteAssets =new JMenuItem("ɾ��");
	
	//�ʲ���ѯ�˵�
	JMenu menuSelectAssets =new JMenu("��ѯ");
	JMenuItem itemSelectAssetsAll =new JMenuItem("��ѯ����(���ɶ�ά��)");
	JMenuItem itemSelectAssetsID =new JMenuItem("����Ų�ѯ");
	
	//��Ա��Ϣ����˵�
	JMenu menuPerson =new JMenu("��Ա��Ϣ����");
	JMenuItem itemAddPerson =new JMenuItem("������Ա��Ϣ");
	JMenuItem itemModifyPerson =new JMenuItem("�޸���Ա��Ϣ");
	JMenuItem itemDeletePerson =new JMenuItem("ɾ����Ա��Ϣ");
	
	//��Ա��ѯ�˵�
	JMenu menuSelectPerson =new JMenu("��ѯ��Ա��Ϣ");
	JMenuItem itemSelectPersonAll =new JMenuItem("��ѯ������Ա��Ϣ");
	JMenuItem itemSelectPersonID =new JMenuItem("����Ų�ѯ��Ա��Ϣ");
	
	//�ʲ����ò˵�
	JMenu menuUsing =new JMenu("�ʲ�����");
	JMenuItem itemUsing =new JMenuItem("�ʲ����ù���");
	JMenuItem itemSelectUsing =new JMenuItem("������Ϣ��ѯ");
	
	//�ʲ��黹�˵�
	JMenu menuBack =new JMenu("�ʲ��黹");
	JMenuItem itemBack =new JMenuItem("�ʲ��黹����");
	JMenuItem itemSelectBack =new JMenuItem("�黹��Ϣ��ѯ");
	
	//�ʲ����ϲ˵�
	JMenu menuInvalid =new JMenu("�ʲ�����");
	JMenuItem itemInvalid =new JMenuItem("�ʲ����Ϲ���");
	JMenuItem itemSelectInvalid =new JMenuItem("������Ϣ��ѯ");
	
	
	public AssetsMain(){
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		//��ӳ���Ĺر��¼�����
		this.setDefaultCloseOperation(3);
		this.pack();
		//���ÿ�ܴ�С
		this.setSize(faceSize);
		this.setLocationRelativeTo(null);
		this.setTitle("�ʲ�����ϵͳ");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}

	public void Init() throws Exception{
		//����ϵͳ����˵�
		menuSystem.add(itemTypeMan);
		menuSystem.add(itemExit);
		mainMenu.add(menuSystem);
		
		//�����ʲ���Ϣ����˵�
		menuAssets.add(itemAddAssets);
		menuAssets.add(itemModifyAssets);
		menuAssets.add(itemDeleteAssets);
		menuAssets.addSeparator();
		menuAssets.add(menuSelectAssets);
		menuSelectAssets.add(itemSelectAssetsAll);
		menuSelectAssets.add(itemSelectAssetsID);
		mainMenu.add(menuAssets);
		
		//������Ա��Ϣ����˵�
		menuPerson.add(itemAddPerson);
		menuPerson.add(itemModifyPerson);
		menuPerson.add(itemDeletePerson);
		menuPerson.addSeparator();
		menuPerson.add(menuSelectPerson);
		menuSelectPerson.add(itemSelectPersonAll);
		menuSelectPerson.add(itemSelectPersonID);
		mainMenu.add(menuPerson);
		//�����ʲ����ò˵�
		menuUsing.add(itemUsing);
		menuUsing.add(itemSelectUsing);
		mainMenu.add(menuUsing);
		//�����ʲ��黹�˵�
		menuBack.add(itemBack);
		menuBack.add(itemSelectBack);
		mainMenu.add(menuBack);
		//�����ʲ����ϲ˵�
		menuInvalid.add(itemInvalid);
		menuInvalid.add(itemSelectInvalid);
		mainMenu.add(menuInvalid);
		//���뵽�˵���
		this.setJMenuBar(mainMenu);
		//����¼�����
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
		
		//�رճ���ʱ�Ĳ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		//�˳�
		if(obj ==itemExit){
			System.exit(0);
		}
		//�ʲ�������
		else if(obj == itemTypeMan){
			TypeInfo ti = new TypeInfo();
			ti.downInit();
			ti.pack();
		}
		//�����ʲ���Ϣ
		else if(obj == itemAddAssets){
			AddAssets add =new AddAssets();
			add.downInit();
			add.pack();
		}
		//�޸��ʲ���Ϣ
		else if(obj == itemModifyAssets){
			ModifyAssets modify =new ModifyAssets();
			modify.downInit();
			modify.pack();
		}
		//ɾ���ʲ���Ϣ
		else if(obj == itemDeleteAssets){
			DeleteAssets delete =new DeleteAssets();
			delete.downInit();
			delete.pack();
		}
		//��ѯ�����ʲ���Ϣ
		else if(obj == itemSelectAssetsAll){
			ResultInfo info =new ResultInfo();
			info.resultAssetsAll();
		}
		//�Ա�Ų�ѯ�ʲ���Ϣ
		else if(obj == itemSelectAssetsID){
			SearchIDInfo info =new SearchIDInfo("Assets");
			info.pack();
		}
		//������Ա��Ϣ
		else if(obj == itemAddPerson){
			AddPerson add =new AddPerson();
			add.downInit();
			add.pack();
		}
		//�޸���Ա��Ϣ
		else if(obj == itemModifyPerson){
			ModifyPerson modify =new ModifyPerson();
			modify.downInit();
			modify.pack();
		}
		//ɾ����Ա��Ϣ
		else if(obj == itemDeletePerson){
			DeletePerson delete =new DeletePerson();
			delete.downInit();
			delete.pack();
		}
		//��ѯ������Ա��Ϣ
		else if(obj == itemSelectPersonAll){
			ResultInfo info =new ResultInfo();
			info.resultPersonAll();
		}
		//�Ա�Ų�ѯ��Ա��Ϣ
		else if(obj == itemSelectPersonID){
			SearchIDInfo info =new SearchIDInfo("Person");
			info.pack();
		}
		//�ʲ�����
		else if(obj == itemUsing){
			UseAssets use =new UseAssets();
			use.pack();
		}
		//�����ʲ���ѯ
		else if(obj == itemSelectUsing){
			ResultInfo info =new ResultInfo();
			info.resultUseAll();
		}
		//�ʲ��黹
		else if(obj == itemBack){
			BackAssets ba =new BackAssets();
			ba.pack();
		}
		//�ʲ��黹��ѯ
		else if(obj == itemSelectBack){
			ResultInfo info =new ResultInfo();
			info.resultBackAll();
		}
		//�ʲ�����
		else if(obj == itemInvalid){
			InvalidAssets ia =new InvalidAssets();
			ia.pack();
		}
		//�ʲ����ϲ�ѯ
		else if(obj == itemSelectInvalid){
			ResultInfo info =new ResultInfo();
			info.resultInvalidAll();
		}

		
	}
	
}
	
	
