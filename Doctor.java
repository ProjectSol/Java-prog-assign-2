//Importing necessary libraries
import java.util.*;
import java.lang.*;

public class Doctor
{
	//defining the global vars for each Doctor object
	private String name; 	// the name of the Doctor
	private String specialisation; 	// the specialisation of the Doctor (it can be "dog" or "cat")
	private Doctor[] doctorList;
	Scanner console = new Scanner(System.in);

  public Doctor[] newDoctor()
  { //The line below never completes after applying the suggested change

    doctorList[1] = new Doctor(); 

    return doctorList;
  }

  /*private void reSize(Doctor[] arr, int newSize)
  {
    Doctor[] arr2 = Arrays.copyOf(arr, newSize);
    return arr2;
  }*/

	public Doctor()
	{
		setName();
		setSpecialisation();
	}

	// Defines a scanner object to read input asks the user for a name and recives this input setting it to the current Doctor objects specialisation
	//It also prevents duplicate names through the use of the dcomp variables and then will force a loop on the user until fixed
	public void setName()
	{
		System.out.println("Please enter the name of the Doctor");
		int loop = 1;
		String nam;
		do {
			nam = console.nextLine();
			if (1 == 2)
			{
				System.out.println("Two doctorList cannot share the same name, please enter the doctorList name again");
			}
			else
			{
				loop = -1;
			}
		} while (loop == 1);
		this.name = nam;
	}

	// a simple return method. Is self explanatory
	public String getName()
	{
		return name;
	}

	// Defines a scanner object to read input asks the user for a specialisation and recives this input setting it to the current Doctor objects specialisation also prevents the assinging of the input unless the user input dog or cat
	public void setSpecialisation()
	{
		int loop = 1;
		System.out.println("Please enter the specialisation of the Doctor, this specialisation should be cat or dog");
		do {
			String spec = console.nextLine();
			this.specialisation = spec;

			if (this.specialisation.equalsIgnoreCase("cat") || this.specialisation.equalsIgnoreCase("dog"))
			{
				//this.specialisation = spec;
				loop = -1;
				//System.out.print("It ran this");
			}
			else
			{
				System.out.println("The specialisation must be either dog or cat please re-enter the doctorList specialisation");
				//System.out.println("It did not run it");
			}
		} while (loop == 1);
	}

	// a simple return method. Is self explanatory
	public String getSpecialisation()
	{
		return specialisation;
	}
}
