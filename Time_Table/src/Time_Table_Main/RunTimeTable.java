package Time_Table_Main;

import java.util.ArrayList;

import Time_Table_FileIO.*;
import Time_Table_Schedule.Schedule;
import Time_Table_Subject.*;
import Time_Table_UI.*;


public class RunTimeTable {

	int caseNum;
	ArrayList<SubjectObject> subjectList = new ArrayList<SubjectObject>();
	TimeTableException exceptionManager=new TimeTableException();
	FileIO fileManager = new FileIO();

	public RunTimeTable() {

		subjectList=fileManager.fileLoad();
		SubjectFunction subjectManager= new SubjectFunction(subjectList);
		while(true)
		{
			TimeTablePrintMenu.jump();
			TimeTablePrintMenu.baseMenu();

			caseNum=exceptionManager.inputNum(9);

			switch(caseNum)
			{
			case 0:continue;
			case TimeTableConstant.Print_Classes: subjectManager.subjectPrint(); break;
			case TimeTableConstant.Add_Classes:	subjectManager.subjectApply(TimeTableConstant.SubjectMode); break;
			case TimeTableConstant.Delete_Classes:subjectManager.subjectDelete(TimeTableConstant.SubjectMode); break;
			case TimeTableConstant.Add_InterstSubject:subjectManager.subjectApply(TimeTableConstant.InterestedMode); break;
			case TimeTableConstant.Delete_InterstSubject:subjectManager.subjectDelete(TimeTableConstant.InterestedMode); break;
			case TimeTableConstant.Print_TimeTable: subjectManager.setSchedule(); break;
			case TimeTableConstant.Print_InterestSubject:subjectManager.ApplyFromInterested();break;
			case TimeTableConstant.Save_File: subjectManager.saveSchedule();break;
			case TimeTableConstant.EXIT: return;
			}
		}
	}

}
