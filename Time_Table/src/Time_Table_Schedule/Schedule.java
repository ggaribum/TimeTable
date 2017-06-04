package Time_Table_Schedule;

import java.util.ArrayList;
import java.util.Iterator;

import Time_Table_FileIO.FileIO;
import Time_Table_Subject.SubjectObject;
import Time_Table_UI.TimeTableConstant;
import Time_Table_UI.TimeTablePrintMenu;

public class Schedule {
	ArrayList<ScheduleObject> schedule=new ArrayList<ScheduleObject>();
	ArrayList<SubjectObject> applyList = new ArrayList<SubjectObject>();
	TimeTableConstant cons=new TimeTableConstant();
	public String mon="";
	public String tue="";
	public String wed="";
	public String thu="";
	public String fri="";
	public Schedule(ArrayList<SubjectObject> applyList) {

		schedule.add(new ScheduleObject("0���� 00:00 - 00:00","[   ������   ]","[   ȭ����   ]","[   ������   ]","[   �����   ]","[   �ݿ���   ]"));
		schedule.add(new ScheduleObject("1���� 08:00 - 08:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("2���� 08:30 - 09:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("3���� 09:00 - 09:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("4���� 09:30 - 10:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("5���� 10:00 - 10:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("6���� 10:30 - 11:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("7���� 11:00 - 11:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("8���� 11:30 - 12:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("9���� 12:00 - 12:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("10���� 12:30 - 13:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("11���� 13:00 - 13:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("12���� 13:30 - 14:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("13���� 14:00 - 14:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("14���� 14:30 - 15:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("15���� 15:00 - 15:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("16���� 15:30 - 16:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("17���� 16:00 - 16:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("18���� 16:30 - 17:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("19���� 17:00 - 17:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("20���� 17:30 - 18:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("21���� 18:00 - 18:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("22���� 18:30 - 19:00", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("23���� 19:00 - 19:30", mon, tue, wed, thu, fri));
		schedule.add(new ScheduleObject("24���� 19:30 - 20:00", mon, tue, wed, thu, fri));
		this.applyList=applyList;
	}

	public boolean settingSchedule(ArrayList<SubjectObject> applyList)
	{
		boolean settingFlag=false;
		for(int i=0;i<applyList.size();i++)
		{
			if(applyList.get(i).time.contains("��"))
			{settingFlag=updateSchedule(i,cons.Mon);}
			if(applyList.get(i).time.contains("ȭ"))
			{settingFlag=updateSchedule(i,cons.Tue);}
			if(applyList.get(i).time.contains("��"))
			{settingFlag=updateSchedule(i,cons.Wed);}
			if(applyList.get(i).time.contains("��"))
			{settingFlag=updateSchedule(i,cons.Thu);}
			if(applyList.get(i).time.contains("��"))
			{settingFlag=updateSchedule(i,cons.Fri);}
		}
		return settingFlag;
	}

	public boolean updateSchedule(int i,int day)
	{
		String startTime;
		String finishTime;
		int sIndex;
		int fIndex;
		boolean updateFlag=false;

		startTime=getStartTime(applyList.get(i).time);
		finishTime=getFinishTime(applyList.get(i).time);
		sIndex=getIndexofStartingSchedule(startTime);
		fIndex=getIndexofFinishingSchedule(finishTime);

		if(checkSchedule(sIndex, fIndex, day))
		{
			if(day==cons.Mon)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{schedule.get(j).mon=applyList.get(i).subjectName;}
			}
			if(day==cons.Tue)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{schedule.get(j).tue=applyList.get(i).subjectName;}
			}
			if(day==cons.Wed)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{schedule.get(j).wed=applyList.get(i).subjectName;}
			}
			if(day==cons.Thu)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{schedule.get(j).thu=applyList.get(i).subjectName;}
			}
			if(day==cons.Fri)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{schedule.get(j).fri=applyList.get(i).subjectName;}
			}
			updateFlag=true;
			return updateFlag;
		}
		else
		{
			return updateFlag;
		}
	}

	//�ð�ǥ��ġ���� üũ 
	public boolean checkSchedule(int sIndex, int fIndex, int day)
	{
		boolean checkFlag=false;
		int count=0;
		if(day==cons.Mon)
		{
			for(int j=sIndex;j<fIndex+1;j++)
			{
				if(schedule.get(j).mon.equals(""))
				{count++;}
			}
		}
		if(day==cons.Tue)
		{
			for(int j=sIndex;j<fIndex+1;j++)
			{
				if(schedule.get(j).tue.equals(""))
				{count++;}
			}
		}
		if(day==cons.Wed)
		{
			for(int j=sIndex;j<fIndex+1;j++)
			{
				if(schedule.get(j).wed.equals(""))
				{count++;}
			}
		}
		if(day==cons.Thu)
		{
			for(int j=sIndex;j<fIndex+1;j++)
			{
				if(schedule.get(j).thu.equals(""))
				{count++;}
			}
		}
		if(day==cons.Fri)
		{
			for(int j=sIndex;j<fIndex+1;j++)
			{
				if(schedule.get(j).fri.equals(""))
				{count++;}
			}
		}
		
		//�ش� ĭ�� ��������� count++�̹Ƿ�,
		//count���� �ʿ��� ĭ���� ���ٸ� ���δ� ����ִٰ� �� �� �ִ�.
		if(count==(fIndex+1)-sIndex) 
		{
			checkFlag=true;
		}
		return checkFlag;
	}



	public int getIndexofStartingSchedule(String startTime)
	{
		int index;
		String tempTime[];

		for(int j=0;j<schedule.size();j++)
		{
			tempTime=schedule.get(j).classTime.split(" ");
			tempTime[1]=tempTime[1].replaceAll("[^0-9]","");
			if(tempTime[1].equals(startTime))
			{
				index = j;
				return index;				
			}
		}
		return -1;
	}

	public int getIndexofFinishingSchedule(String finishTime)
	{
		int index;
		String tempTime[];

		for(int j=0;j<schedule.size();j++)
		{
			tempTime=schedule.get(j).classTime.split(" ");
			tempTime[3]=tempTime[3].replaceAll("[^0-9]","");
			if(tempTime[3].equals(finishTime))
			{
				index = j;
				return index;				
			}
		}
		return -1;
	}

	public String getStartTime(String s)//s==�������� [���� �� ���ǽð�] �κ�.
	{
		String startTime=s;
		startTime=startTime.replaceAll("[^0-9]", "");
		startTime=startTime.substring(0,4);
		return startTime;
	}
	public String getFinishTime(String s)
	{
		String finishTime=s;
		finishTime=finishTime.replaceAll("[^0-9]", "");
		finishTime=finishTime.substring(4,8);
		return finishTime;
	}

	public void scheduleSave()
	{
		new FileIO().fileSave(schedule);
	}
	public void schedulePrint()
	{
		Iterator<ScheduleObject> iter = schedule.iterator();
		while(iter.hasNext())
		{
			ScheduleObject iter_list = iter.next();
			System.out.printf("%-11s",iter_list.classTime);
			System.out.printf("\t|%-11s",iter_list.mon);
			System.out.printf("\t|%-11s",iter_list.tue);
			System.out.printf("\t|%-11s",iter_list.wed);
			System.out.printf("\t|%-11s",iter_list.thu);
			System.out.printf("\t|%-11s",iter_list.fri);
			System.out.printf("\t|%-11s","");
			System.out.println("");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("");
		}
		TimeTablePrintMenu.pressKey();
	}
}
