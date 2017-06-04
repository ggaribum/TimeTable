package Time_Table_Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Time_Table_Schedule.Schedule;
import Time_Table_UI.TimeTableException;
import Time_Table_UI.TimeTablePrintMenu;

//각각 클래스로 만들지 않고 한 클래스로 메서드화 시킨이유
//컴파일되고 수강출력을 먼저 하지않고 바로 신청 눌렀을 경우 엑셀파일에 있는 내용들이
//list에 담겨있지 않아서 각각 담아주는 형식으로 해야되므로 하나의 클래스에 메서드화 시킴.
//returnList 메서드 만들어서 RunTimeTable로 List들 넘겨준 뒤 RunTimeTable Run()메서드에서 제어 해주는게 더 편할 듯.
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
					System.out.println("수강과목에 추가했습니다.");
					TimeTablePrintMenu.printApplySubject(applyList);
					TimeTablePrintMenu.pressKey();	
					}
					else
					{
						applyList.remove(applyObj);
						System.out.println("시간표가 겹칩니다.");
						TimeTablePrintMenu.pressKey();
					}
				}
				else
				{
					System.out.println("이미 관심과목 항목에 있습니다.");
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
				System.out.println("관심과목에 추가했습니다.");
				TimeTablePrintMenu.printApplySubject(interestedList);
				TimeTablePrintMenu.pressKey();
				}
				else 
				{
					System.out.println("이미 수강 중 입니다.");
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

		System.out.print("삭제하고자 하는 강의의 no.를 입력하세요(ex 1) : ");
		int selectNum=exceptionManager.inputNum(tempList.size());
		if(selectNum!=0)
		{	
			if(exceptionManager.deleteException(tempList, selectNum))
			{
				tempList.remove(selectNum-1);
				System.out.println("삭제되었습니다.");
				TimeTablePrintMenu.pressKey();
			}
			else
			{
				System.out.println("취소되었습니다.");
				TimeTablePrintMenu.sleep();
			}
		}
	}
	public void ApplyFromInterested()
	{
		TimeTablePrintMenu.jump();
		TimeTablePrintMenu.printApplySubject(interestedList);
		
		System.out.print("수강등록을 하실려면 [Y], 뒤로 가실려면 [N]을 입력해 주세요 : ");
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
		System.out.print("신청하고자 하는 과목의 no를 입력하세요 : ");
		int selectNum=exceptionManager.inputNum(interestedList.size());
		if (selectNum==0){return;}
		applyList.add(interestedList.get(selectNum-1));
		interestedList.remove(selectNum-1);
		System.out.println("수강신청이 완료되었습니다.");
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
