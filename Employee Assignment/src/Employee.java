
public abstract class Employee {
	
	private final String fName; //employee's first name
	private final String lName; //employee's last name
	private final String empID; //employee's id number
	
	//constructor
	public Employee(String fName, String lName, String empID) {
		this.fName = fName;
		this.lName = lName;
		this.empID = empID;
	}
	
	//abstract method to calculate employee pay
	public abstract double calculatePay(int overloads);
	
	//abstract method to display employee data
	public abstract void displayEmployee();
}