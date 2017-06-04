package Time_Table_UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import Time_Table_Subject.SubjectObject;


public class TimeTableException {
	ArrayList<SubjectObject> subjectList;

	public TimeTableException() {
	}
	public TimeTableException(ArrayList<SubjectObject> tempList) 
	{
		subjectList=tempList;
	}

	public int inputNum(int boundaryNum)
	{
		try{
			int i=new Scanner(System.in).nextInt();
			if(!(0<i && i<boundaryNum+1))

			{
				System.out.println("�Է� ������ ������ϴ�. �ٽ� �Է��ϼ���");
				TimeTablePrintMenu.sleep();
				return 0;
			}
			else return i;
		}catch (InputMismatchException e) {
			System.out.println("������ �Է��ϼ���.");
			TimeTablePrintMenu.sleep();
			return 0;
		}
	}	
	
	public String yesORno()
	{	
		String s=new Scanner(System.in).nextLine();
		s=s.toUpperCase();//.charAt(0);
		if(!(s.equals("Y") || s.equals("N")))
		{
			System.out.println("Y / N ���θ� �Է��� �ּ���.");
			return s=null;
		}

		else return s;
	}
	public boolean interestedException(SubjectObject tempObj, ArrayList<SubjectObject> tempList)
	{
		for(int i=0; i<tempList.size();i++)
		{
			if(tempList.get(i).no.equals(tempObj.no))
			{
				return false;
			}
		}
		return true;
	}
	public SubjectObject applyException(ArrayList<SubjectObject> tempList ,ArrayList<SubjectObject> applyList,
			String info[])
	{
		for(int i=0; i<tempList.size();i++)
		{
			if(tempList.get(i).majorHost.equals(info[0])
					&&tempList.get(i).subjectNum.equals(info[1])
					&&tempList.get(i).subjectClassnum.equals(info[2])
					)
			{
				for(int j=0; j<applyList.size();j++)
				{
					if((tempList.get(i).no.equals(applyList.get(j).no)) )
					{
						System.out.println("�̹� �׸� �ֽ��ϴ�.");
						return null;
					}
				}
				return tempList.get(i);
			}
		}
		System.out.println("������ �߸� ����ϴ�. Ȯ�� �ٶ��ϴ�.");
		TimeTablePrintMenu.sleep();
		return null;
	}
	
	public boolean deleteException(ArrayList<SubjectObject> applyList, int num)
	{
		System.out.print(applyList.get(num-1).subjectName);
		System.out.print("\t"+applyList.get(num-1).prof);
		System.out.print("\t"+applyList.get(num-1).classRoom);
		System.out.println("\t"+applyList.get(num-1).time);
		System.out.print("�ش� ������ �������� �Ͻðڽ��ϱ� ? [Y/N]�Է� :");
		String answer=yesORno();
		if(answer==null||answer.equals("N"))
		{
			return false;
		}
		return true;
	}
}
