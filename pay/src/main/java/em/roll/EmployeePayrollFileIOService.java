package em.roll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * class that does the file operations
 */
public class EmployeePayrollFileIOService {

	/**
	 * file path madee final
	 */
	public static final String PAYROLL_FILE_NAME="C:\\Users\\adarsh.bhandary_ymed\\Desktop\\bridgelabz\\EmployeePayroll\\pay\\src\\main\\java\\em\\roll\\payroll-file.txt";

	/**
	 * functipn tp write data
	 * @param employeePayrollList
	 */
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer=new StringBuffer();
		employeePayrollList.forEach(employee->{
			String emloyeeDataString=employee.toString().concat("\n");
			empBuffer.append(emloyeeDataString);     
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * functipn that cpunts the entries in the file 
	 * and returns long
	 * @return
	 */
	public long countEntries() {
		long entries=0;
		try {
			entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return entries;
	}


	/**
	 * function to rint the data
	 */
	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
			.forEach(System.out::println);   
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<EmployeePayrollData> readData(){
        List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
        try {
            Files.lines((new File(PAYROLL_FILE_NAME).toPath()))
            .map(line->line.trim())
            .forEach(line->{
                String[] s=line.split(",");
                employeePayrollList.add(new EmployeePayrollData(Integer.parseInt(s[0]),s[1],Double.parseDouble(s[2])));
            });
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

}