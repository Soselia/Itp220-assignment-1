/*Isabella Brooks
 * Itp220
 * finished 10/8/2017
 * Purpose of this program is to use inheritance and exception handling to create a program that can enter things into arrays of objects
 * Total work time: 16-17 hours
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CollegeDean {
	static Scanner inp =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mainRep=0;
		//how many staff you would like to add
		int staffAmount;
		//how many faculty you would like to add
		int facultyAmount;
		//an int array for taking the return statment of addPeople() and transferring it to usable form/
		int addPeopleRet[] =new int[2];
		//Staff staffArray[] = null;
		//Faculty facultyArray[] = null;
		
		//the user login. 
		userLogin();
		//transfers addPeople() to usable form
		//addPeople[0] is staff and [1] is faculty
		addPeopleRet = addPeople();
		/*sets both the arrays to their new length.
		 * I set them both to their super type Object so a method could accept either one and work from there
		 * maybe try for Employee class instead since its their direct super
		 */
		 Object staffArray[] = new Staff[addPeopleRet[0]];
		 Object facultyArray[] = new Faculty[addPeopleRet[1]];
		 //just loops through and adds as many staff as specified.
		while (mainRep<addPeopleRet[0])
		{
			System.out.println("Please enter a new staff member \n");
			//adds the new staff to the array
			staffArray[mainRep] = addStaff();
			mainRep++;
		}
		//could probably reforge this withough the int, check later
		//asks if you want to see the staff data, with a yes or no it will continue to faculty
		if(addPeopleRet[0]>0)
		{
		employeeArrayGetter(0,staffArray);
		}
		//sets the repeater to 0 so it can be used again
		mainRep = 0;
		
		while (mainRep<addPeopleRet[1])
		{
		facultyArray[mainRep] = addFaculty();
		mainRep++;
		}
		if(addPeopleRet[1]>0)
		{
		employeeArrayGetter(1,facultyArray);
		}
	}

	public static void userLogin()
	{
		//the input string storage, for username and password
		String loginInfo[] = new String[2];
		//the boolean for the switch and ifs to parse whether the passwords are correct
		Boolean loginCorrect[] = new Boolean[2];
			do
			{
				try
				{
		//tell them what they are entering, then store the data in their respective variables
		System.out.println("Please input your username \n");
		loginInfo[0] = inp.nextLine();
		System.out.println("Please input your password \n");
		loginInfo[1] = inp.nextLine();
		
		//a switch to match the usernames, keeps the usage of ifs down and minimizes code
		switch (loginInfo[0])
		{
			//the three cases "dean" "Admin" and "USER", all case sensitive
			case "dean":
				//sets the username login boolean to true
				loginCorrect[0] =true;
				//checks the password info against the corresponding info. Has to use a .equals cuz of how strings work
				if(loginInfo[1].equals("abc123"))
					{
						//sets it to true if it matches, sets to false if it doesnt
						loginCorrect[1]=true;
					}
				else
					{
						loginCorrect[1]=false;
					}
				break;
			case "Admin":
				loginCorrect[0] =true;
				if(loginInfo[1].equals("def456"))
					{
						loginCorrect[1]=true;
					}
				else
					{
						loginCorrect[1]=false;
					}
				break;
			case "USER":
				loginCorrect[0] =true;
				if(loginInfo[1].equals("ghi789"))
					{
					loginCorrect[1]=true;
					}
				else
					{
					loginCorrect[1]=false;
					}
				break;
			// Default is for if they enter nothing correctly
			default:
				loginCorrect[0]=false;
				loginCorrect[1]=false;
				break;
		}
		//if both of them are correct it tells you so, then moves on to the next method.
		if(loginCorrect[0]==true&&loginCorrect[1]==true)
			{
				System.out.println("Your info was verified \n");
		
			}
		//otherwise it gives debug info (comment out later) and tells you to retry
		else
			{
				/**
				System.out.println(loginInfo[0]);
				System.out.println(loginInfo[1]);
				System.out.println(loginCorrect[0]);
				System.out.println(loginCorrect[1]);
				//System.out.println("Your info was incorrect, please try again \n");
			 	*/
				throw new Exception();
			}
		//ends try block
		}
		catch (Exception exception) 
			{
		 		System.err.println("Entered info was incorrect, please try again ");
		 		System.out.println("\n");
			}
		//ends do while		
		} while (loginCorrect[0]==false||loginCorrect[1]==false);
	
		
	}
	
	public static int[] addPeople()
	{
		//an int array to put the two inputs for how many you should add. Add parsing to make sure number isn't larger then 3 
		int addPeopleArr[] = new int[2];
		//for making sure they put in 3 or less, maybe replaced when i add custom exception handling
	    boolean correctAmount[]= new boolean[2];
		//asks and enters
		boolean staffZeroExcep = false;
		while (correctAmount[0]==false){
			//asks how many you want with error handling. while statement so it loops if messed up
			System.out.println("How many staff would you like to add?(Up to 3) \n");
			addPeopleArr[0] = Integer.parseInt(inp.nextLine());
				try
				{
					if(addPeopleArr[0]<= 3 )
						{
							correctAmount[0]= true;
						
						}
					else
						{
							System.out.println("You can only enter 3 or less staff \n");
						}
					if(addPeopleArr[0]==0)
					{
						staffZeroExcep =true;
					}
				}
				catch(Exception exception)
				{
					System.err.println("Bad formatting, please retry");
				}
		
		}
		
		while (correctAmount[1]==false){
		System.out.println("How many faculty would you like to add?(Up to 3) \n");
		addPeopleArr[1] = Integer.parseInt(inp.nextLine());
		
		if(addPeopleArr[1] <= 3)
			{
				if(addPeopleArr[1]==0&&staffZeroExcep==true)
				{
					System.out.println("Cant input zero if staff was also zero");
				}
				else
				{
				correctAmount[1]= true;
				}
			}
		else
			{
				System.out.println("You can only enter 3 or less faculty. \n");
			}
			
		}
		//debug info. Ints have a bad habit of needing scanner clears
		//System.out.println(addPeopleArr[1]);
		return addPeopleArr;
	}
	
	public static Staff addStaff()
	{
		//make sure to make these all individual try catches. Will be a bit annoying, but will keep user from having to reinput everything upon a mistake
		//All of these need exception handling. 
		//simple repeater for looping however many times needed
		int r=0;
		int responsRep=0;
		//initializing the main three arrays, responisibilites dept and salary
		//responsibilites will be weird, will have to initialize object with each pass then wipe responsibilities
		int staffResponsAmount=0;
		//String staffResponsibilities[] = null;
		//all the strings to hold the data til its needed
		String staffDepartment = " ";
		String staffFirstName = null;
		String staffLastName = null;
		String staffEmpID = null;
		double staffSalary = 0;
		//the booleans for the while loop for successful error handling
		boolean staffRespEnt =false;
		boolean staffSalaryCorr =false;
		boolean staffDeptCorr =false;		
		boolean staffFNameCorr =false;
		boolean staffLNameCorr = false;
				//only up to 4, between 4 and 20 chars each. string
					while (staffRespEnt ==false )
					{
						try{
							System.out.println("how many responsibilities would you like to enter?(up to 4)");
							staffResponsAmount = Integer.parseInt(inp.nextLine());
			
							//makes sure they only have up 4 responsibilities and more then 0
							if(staffResponsAmount>4||staffResponsAmount<1)
								{
									throw new Exception();
								}
								//if no errors it sets true and escapes the loop
								staffRespEnt= true;
							}
					catch (Exception exception)
						{
							System.err.println("Error inputting, please retry");
						}
					}
				String staffResponsibilities[] =new String[staffResponsAmount];
					while (responsRep < staffResponsAmount)
						{
							try
							{
							System.out.println("Please enter responsibility # " + (responsRep+1) +" (Responsibilities should be between 4 and 20 characters)");
							staffResponsibilities[responsRep] = inp.nextLine();
									
							//if the length is less then 4 or higher then 20 it throws an exception
							if(staffResponsibilities[responsRep].length()<4 || staffResponsibilities[responsRep].length()>20)
								{
									throw new Exception();
								}
							else
								{
									responsRep++;
								}
							}
							catch (Exception exception)
							{
								//added a \n for readability. generic error message, maybe change
								System.err.println("Error inputting, please retry \n");
							}
						
						}
					
			
				//department is a 3 char code. For consistency ill use a toUpperCase. string
				while (staffDeptCorr==false)
					{
						try
						{
							System.out.println("Please enter the department code (a 3 letter identifier)");
							//automatically makes the department uppercase for easier reading
							staffDepartment = inp.nextLine().toUpperCase();
							//staffDepartment =staffDepartment.toUpperCase();
							if(staffDepartment.length()!=3)
								{
									throw new Exception();	
								}
							staffDeptCorr=true;
						}
						catch (Exception exception)
						{
							System.err.println("Error inputting, please retry");
						}
					}
				//enter their salary. double
				while( staffSalaryCorr==false)
				{
					try
					{
						//parse out a double. i us
						System.out.println("Please enter the salary of the staff member (it will round off at two decimal points");
						staffSalary = Double.parseDouble(inp.nextLine());
						staffSalaryCorr=true;
					}
					//i did this one as a mismatch exception, simply because i use the catch all too often.
					catch (NumberFormatException exception)
					{
						System.err.println("Error inputting, please use a double format");
					}
					catch (InputMismatchException exception)
					{
						System.err.println("Error inputting, please use a double format");
					}
				}
				
			//add first name, last name, and emp id entry, add individual exception handling to all
				while(staffFNameCorr==false)
				{
					try
					{
						//sets a character class so I can use advanced operations
						Character uppFirst = null;
						System.out.println("please input the staffs first name");
						staffFirstName=inp.nextLine();
						//takes the first letter of the entered name and makes it uppercase in the character var
						uppFirst = Character.toUpperCase(staffFirstName.charAt(0));
						//replaces the first char with the new uppercase version
						staffFirstName =staffFirstName.replace(staffFirstName.charAt(0),uppFirst);
						staffFNameCorr=true;
					}
					//catch block for safety
					catch (Exception exception)
					{
						System.err.println("Error inputting, please retry");
					}
				}
				while(staffLNameCorr==false)
				{
					try
					{
						//same as the First Name set up
						Character uppLast;
						System.out.println("please input the staffs last name");
						staffLastName=inp.nextLine();
						uppLast = Character.toUpperCase(staffLastName.charAt(0));
						staffLastName =staffLastName.replace(staffLastName.charAt(0),uppLast);
						staffLNameCorr=true;
					}
					catch (Exception exception)
					{
						System.err.println("Error inputting, please retry");
					}
				}
				
				staffEmpID = employeeIDGen(staffFirstName,staffLastName);
				Staff staffMem = new Staff(staffResponsibilities,staffDepartment,staffSalary,staffFirstName,staffLastName,staffEmpID);
				return staffMem;
	}
	
	public static Faculty addFaculty()
	{
		int courseRep = 0;
		// the courses can be up to 5 values, each value can only be 6 chars.
		
		String facultyCourses[] = null;
		//office number should be a 3 digit variable
		
		int facultyOffNum = 0;
		//the salary they recieve. SHould be passed off and then calculate pay
		double facultySalary = 0;
		//strings for the name and id
		String facultyFirstName = null;
		String facultyLastName = null;
		String facultyEmpID = null;
		//booleans for loops
		boolean facCourseCorr =false;
		boolean facSalaryCorr =false;
		boolean facOffNumCorr = false;
		boolean facFNameCorr = false;
		boolean facLNameCorr = false;
		
		while(facCourseCorr==false)
			{
				try
				{
					//add more explanation in the text
					System.out.println("Faculty entry:");
					System.out.println("Faculty are the instructors in the college");
					System.out.println("how many courses would you like to enter?(Up to 5 courses)");
					facultyCourses = new String[Integer.parseInt(inp.nextLine())];
				if (facultyCourses.length> 5 ||facultyCourses.length<1 )
					{
						throw new Exception();
					}
					facCourseCorr = true;
				}
				catch (Exception exception)
				{
					System.err.println("Cant put in more then 5 courses, please re-enter");
				}
			}
				while (courseRep<facultyCourses.length)
					{
						try
						{
							//asks for teh course and adds it to the course array
							System.out.println("please input course # " +(courseRep+1) + " (course names should be 6 characters)");
							facultyCourses[courseRep] = inp.nextLine();
							if(facultyCourses[courseRep].length() !=6 )
								{
									throw new Exception();
								}
							courseRep++;
						}
					catch (Exception exception)
			        {
						System.err.println("The course has to be 6 characters. ITP101 for example");
			        }
					}
		    
				while(facOffNumCorr==false)
					{
						try 
						{
							//sets it so the number has to be more then 100 and less then a 1000. easiest way to ensure 3 digits
							System.out.println("Please enter the office number.(This should be 3 digits)");
							facultyOffNum = Integer.parseInt(inp.nextLine());
							if(facultyOffNum < 100 || facultyOffNum>999)
								{
									throw new Exception();
								}
							facOffNumCorr = true;
						}
						catch (Exception exception)
							{
								System.err.println(" The office number has to be greater then 100, and less then 1000");
							}
					}
				while (facSalaryCorr==false)
					{
						try 
						{
							System.out.println("Please enter the base salary");
							facultySalary = Double.parseDouble(inp.nextLine());
							//add exception handling for wrong input type
							facSalaryCorr = true;
						}
		
						catch (Exception exception)
						{
							System.err.println("Please make sure you add a double, has to have a . place");
						}
					}
				while(facFNameCorr==false)
					{
						try 
						{
							Character uppFirst;
							System.out.println("Please input the employees first name");
							facultyFirstName=inp.nextLine();
							uppFirst = Character.toUpperCase(facultyFirstName.charAt(0));
							facultyFirstName =facultyFirstName.replace(facultyFirstName.charAt(0),uppFirst);
							facFNameCorr=true;
						}
		
						catch (Exception exception)
						{
							System.err.println("Error inputting, please retry");
						}
					}
				while(facLNameCorr==false)
					{
						try 
						{
							Character uppLast;
							System.out.println("Please input the employees last name");
							facultyLastName=inp.nextLine();
							uppLast = Character.toUpperCase(facultyLastName.charAt(0));
							facultyLastName =facultyLastName.replace(facultyLastName.charAt(0),uppLast);
							facLNameCorr = true;
						}
						catch (Exception exception)
						{
							System.err.println("Error inputting, please retry");
						}
					}
		facultyEmpID = employeeIDGen(facultyFirstName,facultyLastName);
		
		Faculty facultyMem = new Faculty(facultyCourses,facultyOffNum,facultySalary,facultyFirstName,facultyLastName,facultyEmpID);
		return facultyMem;
		
		
	}
	        
	public static String employeeIDGen(String name1, String name2)
	{
		//resets the used string to prevent potential pile up
		String idTemp= " ";
		//the random gen for teh last 3 numbers
		Random rand = new Random();
		int tempNum;
		//adds teh two initials at the front
		idTemp+= name1.charAt(0);
		idTemp+= name2.charAt(0);
		//uses a num gen to get a 100-999 number to add to the back
		tempNum =rand.nextInt(899)+100;
		//probably an unneccesary step, come back for revision
		idTemp+= Integer.toString(tempNum);
		return idTemp;
	}
	
	public static void employeeArrayGetter(int classType,Object[] employees)
	{
		//to hold the input to determine if they say yes or no
		String inputTemp = null;
		boolean empInpCorr = false;
		//Object employees[];
		//checks if the object passed in is a staff or faculty object.
		//this is why they are set as a super, so both can be passed then judged inside method
		if(employees[0] instanceof Staff)
		{
			while(empInpCorr==false)
				{
					try
					{
						//asks, then gets a yes or no. sets it to be a lower case answer
						System.out.println("Would you like to get the information of all entered staff?");
						inputTemp = inp.nextLine();
						inputTemp=inputTemp.toLowerCase();
						//simply checks if the input starts with a y or n, so there is no need for multiple ifs for all scenarios
						if(inputTemp.charAt(0)=='y')
						{
							//sets the boolean to true to stop the loop
							empInpCorr=true;
							//creates a for loop so it can get the displayed info for all staff
							for(int r=0;r<employees.length;r++)
							{
								
								//creates an entry line so you know which staff number you are, makes it more readable
								System.out.println("Staff #"+(r+1)+ "\n");
								// I downcasted staff onto the objects array so I can use the displayEmployee method.
								//maybe not the most elegant solution, but it allows this method to be much more flexible, and has easy potential for expansion if needed
								//((Staff)employees[r]).calculatePay(employees[r].finalPay);
								((Staff) employees[r]).displayEmployee();
							}
						}
						else if(inputTemp.charAt(0)=='n')
						{
							
							empInpCorr=true;
							System.out.println("This is a string to let the creator know it was working, remove after testing");
						}
						else if(inputTemp.charAt(0)!='y'&&inputTemp.charAt(0)!='n')
						{
							
							throw new Exception();
							//System.err.println("The input did not process correctly");
						}
					}
					catch (Exception exception)
					{
						System.err.println("Please put yes or no");
					}
				}
		}
		if(employees[0] instanceof Faculty)
		{	
			while(empInpCorr==false)
				{
					try
					{
						System.out.println("Would you like to get the information of all entered faculty?");
						inputTemp = inp.nextLine();
						inputTemp= inputTemp.toLowerCase();
			
						if(inputTemp.charAt(0)=='y')
						{	
							empInpCorr=true;
							for(int r=0;r<employees.length;r++)
							{
								System.out.println("Faculty #"+(r+1));
								((Faculty) employees[r]).displayEmployee();
							}
						}
						else if(inputTemp.charAt(0)=='n')
						{
							empInpCorr=true;
							System.out.println("This is a string to let the creator know it was working, remove after testing");
						}
						else
						{
							throw new Exception();
							//System.err.println("The input did not process correctly");
						}
					}
					catch (Exception exception)
					{
						System.err.println("Please put yes or no \n");
					}
				}
		}
		if( classType != 0 && classType !=1)
		{
			System.err.println("The referenced array is not of type faculty or staff");
		}
	}
}
	
