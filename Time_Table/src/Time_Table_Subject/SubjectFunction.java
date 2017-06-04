package Time_Table_Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Time_Table_Schedule.Schedule;
import Time_Table_UI.TimeTableException;
import Time_Table_UI.TimeTablePrintMenu;

//���� Ŭ������ ������ �ʰ� �� Ŭ������ �޼���ȭ ��Ų����
//�����ϵǰ� ��������� ���� �����ʰ� �ٷ� ��û ������ ��� �������Ͽ� �ִ� �������
//list�� ������� �ʾƼ� ���� ����ִ� �������� �ؾߵǹǷ� �ϳ��� Ŭ������ �޼���ȭ ��Ŵ.
//returnList �޼��� ���� RunTimeTable�� List�� �Ѱ��� �� RunTimeTable Run()�޼��忡�� ���� ���ִ°� �� ���� ��.
public class SubjectFunction {

	ArrayList<SubjectObject> subjectList;
	ArrayList<SubjectObject> applyList = new ArrayList<SubjectObject>();
	ArrayList<SubjectObject> interestedList = new ArrayList<SubjectObject>();

	Scanner scan = new Scanner(System.in);
	TimeTableException exceptionManager = new TimeTableException();
	Schedule schedule = new Schedule(applyList);
	
	public SubjectFunction() {
		// TODO Auto-generated constructor stub
	}
	public SubjectFunction(ArrayList<SubjectObject> tempList) 
	{
		subjectList=tempList;
	}
	public void subjectPrint()
	{
		Iterator<SubjectObject> iter = subjectList.iterator();
		TimeTablePrintMenu.jump();
		while(iter.hasNext())
		{
			SubjectObject iter_list= iter.next();
			System.out.print(iter_list.no);
			System.out.print("\t"+iter_list.major);
			System.out.print("\t"+iter_list.subjectNum);
			System.out.print("\t"+iter_list.subjectClassnum);
			System.out.printf("\t%-11s",iter_list.subjectName);
			System.out.print("\t"+iter_list.isu);
			System.out.print("\t"+iter_list.grade);
			System.out.print("\t"+iter_list.year);
			System.out.printf("\t%-11s",iter_list.majorHost);
			System.out.print("\t"+iter_list.prof);
			System.out.print("\t"+iter_list.time);
			System.out.print("\t"+iter_list.classRoom);
			System.out.print("\t"+iter_list.language);
			System.out.println("");
		}
		TimeTablePrintMenu.pressKey();
	}
	public void subjectApply(int mode)
	{
		TimeTablePrintMenu.jump();

		SubjectObject applyObj;
		String info[]= new String [3];

		info=TimeTablePrintMenu.applyInfo();

		if(mode==0)
		{
			applyObj=exceptionManager.applyException(subjectList,applyList,info);
			if(applyObj!=null)
			{
				if(exceptionManager.interestedException(applyObj, interestedList))
				{
					
					applyList.add(applyObj);
					if(schedule.settingSchedule(applyList))
					{
					System.out.println("�������� �߰��߽��ϴ�.");
					TimeTablePrintMenu.printApplySubject(applyList);
					TimeTablePrintMenu.pressKey();	
					}
					else
					{
						applyList.remove(applyObj);
						System.out.println("�ð�ǥ�� ��Ĩ�ϴ�.");
						TimeTablePrintMenu.pressKey();
					}
				}
				else
				{
					System.out.println("�̹� ���ɰ��� �׸� �ֽ��ϴ�.");
					TimeTablePrintMenu.pressKey();
				}
			}
		}
		else if(mode==1)
		{
			applyObj=exceptionManager.applyException(subjectList,interestedList,info);
			if(applyObj!=null)
			{
				if( exceptionManager.interestedException(applyObj,applyList) )
				{
				interestedList.add(applyObj);
				System.out.println("���ɰ��� �߰��߽��ϴ�.");
				TimeTablePrintMenu.printApplySubject(interestedList);
				TimeTablePrintMenu.pressKey();
				}
				else 
				{
					System.out.println("�̹� ���� �� �Դϴ�.");
					TimeTablePrintMenu.printApplySubject(interestedList);
					TimeTablePrintMenu.pressKey();
				}
			}
		}
	}

	public void subjectDelete(int caseNum)
	{
		TimeTablePrintMenu.jump();
		ArrayList<SubjectObject> tempList;
		
		if(caseNum==0)
		{tempList=applyList;}
		else
		{tempList=interestedList;}
		TimeTablePrintMenu.printApplySubject(tempList);

		System.out.print("�����ϰ��� �ϴ� ������ no.�� �Է��ϼ���(ex 1) : ");
		int selectNum=exceptionManager.inputNum(tempList.size());
		if(selectNum!=0)
		{	
			if(exceptionManager.deleteException(tempList, selectNum))
			{
				tempList.remove(selectNum-1);
				System.out.println("�����Ǿ����ϴ�.");
				TimeTablePrintMenu.pressKey();
			}
			else
			{
				System.out.println("��ҵǾ����ϴ�.");
				TimeTablePrintMenu.sleep();
			}
		}
	}
	public void ApplyFromInterested()
	{
		TimeTablePrintMenu.jump();
		TimeTablePrintMenu.printApplySubject(interestedList);
		
		System.out.print("��������� �ϽǷ��� [Y], �ڷ� ���Ƿ��� [N]�� �Է��� �ּ��� : ");
		String select =exceptionManager.yesORno();
		if(select==null){select="null";}
		switch(select)
		{
		case "Y":ApplyFromInterested_Yes();return;
		case "N":TimeTablePrintMenu.sleep(); return;
		case "null":TimeTablePrintMenu.sleep();return;
		}
	}
	private void ApplyFromInterested_Yes()
	{
		System.out.print("��û�ϰ��� �ϴ� ������ no�� �Է��ϼ��� : ");
		int selectNum=exceptionManager.inputNum(interestedList.size());
		if (selectNum==0){return;}
		applyList.add(interestedList.get(selectNum-1));
		interestedList.remove(selectNum-1);
		System.out.println("������û�� �Ϸ�Ǿ����ϴ�.");
		TimeTablePrintMenu.pressKey();
	}
	public void setSchedule()
	{
		schedule.schedulePrint();
	}
	public void saveSchedule()
	{
		schedule.scheduleSave();
	}
	
}
