package Time_Table_UI;

import java.util.ArrayList;
import java.util.Scanner;

import Time_Table_Subject.SubjectObject;

public class TimeTablePrintMenu {
	
	public static void baseMenu()
	{
		System.out.println("1. �������");
		System.out.println("2. �����߰�");
		System.out.println("3. ���ǻ���");
		System.out.println("4. ���ɰ����߰�");
		System.out.println("5. ���ɰ������");
		System.out.println("6. �ð�ǥ���");
		System.out.println("7. ���ɰ������");
		System.out.println("8. ��������");
		System.out.println("9. ����");
		System.out.println("");
		System.out.print("�Է��ϼ��� :");
	}
	
	public static void jump()
	{
		for(int i=0; i<50 ; i++)
		{
			System.out.println("");
		}
	}
	
	public static String[] applyInfo()
	{
		String info[]= new String[3];
		Scanner scan = new Scanner(System.in);
		System.out.print("�����а��� �Է��ϼ��� : ");
		info[0] = scan.nextLine();
		System.out.print("�м���ȣ�� �Է��ϼ��� : ");
		info[1] = scan.nextLine();
		System.out.print("�й��� �Է��ϼ��� : ");
		info[2] = scan.nextLine();
		
		return info;
	}
	
	public static void printApplySubject(ArrayList<SubjectObject> applyList)
	{
		for(int i=0; i< applyList.size();i++)
		{
			System.out.print("no."+(i+1));
			System.out.print("\t"+applyList.get(i).subjectName);
			System.out.print("\t"+applyList.get(i).prof);
			System.out.print("\t"+applyList.get(i).classRoom);
			System.out.println("\t"+applyList.get(i).time);
			System.out.println("-------------------------------------------------");
		}
	}
	
	public static void pressKey()
	{
		System.out.println("");
		System.out.println("����ϽǷ��� [Enter] key��������.....");
		new Scanner(System.in).nextLine();
	}
	public static void sleep()
	{
		try {
			System.out.println("");
			System.out.println("2���� ���� ȭ������ ���ư��ϴ�......");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	



}
