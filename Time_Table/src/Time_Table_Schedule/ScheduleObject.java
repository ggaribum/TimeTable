package Time_Table_Schedule;

public class ScheduleObject {

	public String classTime;
	public String mon;
	public String tue;
	public String wed;
	public String thu;
	public String fri;
	
	public ScheduleObject(String ct, String mon, String tue, String wed, String thu, String fri) 
	{
		this.classTime=ct;
		this.mon=mon;
		this.tue=tue;
		this.wed=wed;
		this.thu=thu;
		this.fri=fri;
	}

	public String getClassTime() {
		return classTime;
	}

	public String getMon() {
		return mon;
	}

	public String getTue() {
		return tue;
	}


	public String getWed() {
		return wed;
	}



	public String getThu() {
		return thu;
	}



	public String getFri() {
		return fri;
	}


	
}
