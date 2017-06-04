package Time_Table_FileIO;

/*import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;*/

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Time_Table_Schedule.Schedule;
import Time_Table_Schedule.ScheduleObject;
import Time_Table_Subject.SubjectObject;
import Time_Table_UI.TimeTablePrintMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class FileIO {

	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	ArrayList<SubjectObject> subjectList = new ArrayList<SubjectObject>();
	String cellString[] = new String[13];

	public ArrayList<SubjectObject> fileLoad()
	{
		try {
			fis = new FileInputStream(new File("src/Sejong.xlsx"));
			wb = new XSSFWorkbook(fis);

			if (wb != null) {
				sheet = wb.getSheet("강의시간표");
				if (sheet != null) {
					for(int i=0; i<sheet.getPhysicalNumberOfRows();i++)
					{
						row=sheet.getRow(i);
						{
							for(int j=0; j<row.getPhysicalNumberOfCells();j++)
							{
								cellString[j]=row.getCell(j).getStringCellValue();
							}
							if(cellString[1].equals("개설학과전공")||cellString[1].equals("컴퓨터공학과")
									||cellString[1].equals("디지털콘텐츠학과"))
							{
								subjectList.add(new SubjectObject(cellString));
							}
						}
					}

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectList;
	}

	public void fileSave(ArrayList<ScheduleObject> scheduleList)
	{
		wb = new XSSFWorkbook();
		sheet = wb.createSheet();
		sheet.setColumnWidth(0,5000);
		sheet.setColumnWidth(1,5000);
		sheet.setColumnWidth(2,5000);
		sheet.setColumnWidth(3,5000);
		sheet.setColumnWidth(4,5000);
		sheet.setColumnWidth(5,5000);
		
		ScheduleObject schedule;
		for(int i=0;i<scheduleList.size();i++)
		{
			schedule=scheduleList.get(i);
			row=sheet.createRow(i);

			cell=row.createCell(0);
			cell.setCellValue(schedule.getClassTime());
			cell=row.createCell(1);
			cell.setCellValue(schedule.getMon());
			cell=row.createCell(2);
			cell.setCellValue(schedule.getTue());
			cell=row.createCell(3);
			cell.setCellValue(schedule.getWed());
			cell=row.createCell(4);
			cell.setCellValue(schedule.getThu());
			cell=row.createCell(5);
			cell.setCellValue(schedule.getFri());
		}
		try {
			System.out.println("Saving the File......");
			fos=new FileOutputStream(new File("src/TIMETABLE.xlsx"));
			wb.write(fos);
			TimeTablePrintMenu.pressKey();

		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try {
				fos.close();
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

/*					
//단순히 출력만을 위한거라면 Iterator 쓰는 방법이 편함.
Iterator<Row> rows = sheet.rowIterator();
while (rows.hasNext()) {

	Iterator<Cell> cells = rows.next().iterator();

	while (cells.hasNext()) {
		System.out.print(cells.next().getStringCellValue()); // 출력
	}
	System.out.println();
}
 */
