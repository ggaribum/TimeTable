package Time_Table_UI;

import java.util.ArrayList;
import java.util.Scanner;

import Time_Table_Subject.SubjectObject;

public class TimeTablePrintMenu {
	
	public static void baseMenu()
	{
		System.out.println("1. 강의출력");
		System.out.println("2. 강의추가");
		System.out.println("3. 강의삭제");
		System.out.println("4. 관심과목추가");
		System.out.println("5. 관심과목삭제");
		System.out.println("6. 시간표출력");
		System.out.println("7. 관심과목출력");
		System.out.println("8. 파일저장");
		System.out.println("9. 종료");
		System.out.println("");
		System.out.print("입력하세요 :");
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
		System.out.print("개설학과를 입력하세요 : ");
		info[0] = scan.nextLine();
		System.out.print("학수번호를 입력하세요 : ");
		info[1] = scan.nextLine();
		System.out.print("분반을 입력하세요 : ");
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
		System.out.println("계속하실려면 [Enter] key누르세요.....");
		new Scanner(System.in).nextLine();
	}
	public static void sleep()
	{
		try {
			System.out.println("");
			System.out.println("2초후 이전 화면으로 돌아갑니다......");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	



}
