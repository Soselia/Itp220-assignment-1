
public class Staff extends Employee {
	
	// 4 values, between 4 and 20 characters each value
	String responsibilities[];
	//3 char code for the dept
	String dept;
	//Strings for the three original args
	String firstName;
	String lastName;
	String empID;
	// has to cut off at two decimals since its real money
	double finalPay;
	
	public Staff(String fName, String lName, String empID) {
		super(fName, lName, empID);
		// TODO Auto-generated constructor stub
	}
	
	public Staff(String responsibilities[],String dept,Double salary,String fName, String lName, String empID)
	{
		super(fName, lName, empID);
		this.responsibilities = responsibilities;
		this.dept = dept;
		this.finalPay = salary;
		this.finalPay=calculatePay(salary);
		this.firstName = fName;
		this.lastName = lName;
		this.empID = empID;
	}
	
	public double calculatePay(int overload)
	
	{
		double payCalc = finalPay;
	
		return payCalc;
		
	}
	public double calculatePay(double overload)
	
	{
		double payCalc = finalPay;
	
		return payCalc;
		
	}


	public void displayEmployee()
	{
		//use formatted output to output all data onto screen into readable format. Dont forget to make double ony go two places
		System.out.printf("FULL NAME: %s %s \n",firstName,lastName);
		System.out.printf("EMPLOYEE ID: %s \n", empID);
		//System.out.printf("RESPONSIBILITIES: %s, %s,%s,%s \n", responsibilities[0],responsibilities[1],responsibilities[2],responsibilities[3]);
		System.out.printf("DEPARTMENT: %s \n", dept);
		//finalPay = calculatePay(Integer.parseInt(finalPay.toString()));
		System.out.printf("SALARY: %.2f \n", finalPay);
		for(int r=0;r<responsibilities.length;r++)
		{
			System.out.printf("RESPONSIBILITY#"+(r+1)+": "+" %s \n", responsibilities[r]);
		}
	}

}
