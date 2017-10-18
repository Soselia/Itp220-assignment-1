
public class Faculty extends Employee{

	// length 5, each course is 6 chars
	String courses[];
	// a 3 digit int
	int officeNum;
	//since it represents pay it cuts at two decimals
	double finalPay;
	//unneccessary, prune if you have time
	int courseL;
	//Strings for the three employee vars
	String firstName;
	String lastName;
	String empID;

	
	public Faculty(String fName, String lName, String empID) {
		super(fName, lName, empID);
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(String courses[],int officeNum,Double salary,String fName, String lName, String empID)
	{
		super(fName, lName, empID);
		this.courses = courses;
		this.officeNum = officeNum;
		this.finalPay = salary;
		this.finalPay=calculatePay(salary);
		this.firstName = fName;
		this.lastName = lName;
		this.empID = empID;
	}
	
	public double calculatePay(int overload)
	
	{
		double payCalc = 0;
		int tempCourses = 0;
		if(courses.length>3)
		{
			tempCourses=courses.length*4;
			tempCourses-=15;
		}
		payCalc = finalPay +(tempCourses*900.50);
		finalPay= payCalc;
		return payCalc;
		}
public double calculatePay(double overload)
	
	{
		//I wasnt sure what more to do with this, so I just created an overloaded method.
		double payCalc = 0;
		int tempCourses = 0;
		if(courses.length>3)
		{
			tempCourses=courses.length*4;
			tempCourses-=15;
		}
		payCalc = finalPay +(tempCourses*900.50);
		finalPay= payCalc;
		return payCalc;
		}
	public void displayEmployee()
	{
		System.out.printf("NAME: %s %s \n", firstName,lastName);
		System.out.printf("EMPLOYEE ID: %s \n", empID);
		System.out.printf("OFFICE NUMBER: %s \n", officeNum);
		//finalPay=calculatePay(Integer.parseInt(finalPay.toString()));
		System.out.printf("SALARY: %.2f \n", finalPay);
		courseL= courses.length;
		for(int r=0;r<courseL;r++)
		{
			System.out.printf("COURSE#"+(r+1)+": "+"%s \n", courses[r]);
		}
	}
}
