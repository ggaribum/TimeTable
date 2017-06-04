package Time_Table_Subject;

public class SubjectObject {

	public String no="";
	public String major="";
	public String subjectNum="";
	public String subjectClassnum="";
	public String subjectName="";
	public String isu="";
	public String grade="";
	public String year="";
	public String majorHost="";
	public String prof="";
	public String time="";
	public String classRoom="";
	public String language="";
	
	public SubjectObject() {
	}
	
	public SubjectObject(String subList[]) 
	{
		this.no= subList[0];
		this.major=subList[1];
		this.subjectNum=subList[2];
		this.subjectClassnum=subList[3];
		this.subjectName=subList[4];
		this.isu=subList[5];
		this.grade=subList[6];
		this.year=subList[7];
		this.majorHost=subList[8];
		this.prof=subList[9];
		this.time=subList[10];
		this.classRoom=subList[11];
		this.language=subList[12];
		
	}
	
}
