//Importing necessary libraries
import java.util.*;
import java.lang.*;
import java.io.*;

public class Doctor
{
	//defining the global vars for each Doctor object
	private String name; 	// the name of the Doctor
	private String specialisation; 	// the specialisation of the Doctor (it can be "dog" or "cat")
	private Doctor[] doctorList;
	Scanner console = new Scanner(System.in);



  public static Doctor[] newDoctor(Doctor[] doctorList)
  { //The line below never completes after applying the suggested change
		//Clinic.printOut(""+doctorList.length);
		if(doctorList.length != 1)
		{
			//Clinic.printOut("We ran the length is not 1 loop");
			doctorList[doctorList.length-1] = new Doctor();
			doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
			//Clinic.printOut(doctorList[0].getName());
		}
		else
		{
			doctorList[0] = new Doctor();
			doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
			/*Clinic.printOut(""+doctorList.length);
			Clinic.printOut(doctorList[0].getName());*/
		}
		return doctorList;
  }

	public static void listDoctors(Doctor[] doctorList)
	{
		//This is our output for listing the doctors, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		Clinic.printOut("Listing Doctors: \n");
		Clinic.printOut("---------------------------------------------------------------------------------------------------------\n");
		try
		{
			if (doctorList.length == 1)
			{
				Clinic.printOut("Nothing to display, please enter a doctor\n");
			}
			else
			{
				for(int i = 0; i < (doctorList.length-1); i++)
				{
					Clinic.printOut("Doctor "+(i+1)+":\n Name: "+doctorList[i].getName()+" Specialisation: "+doctorList[i].getSpecialisation()+"\n");
				}
			}
		}
		catch(NullPointerException e)
		{
			Clinic.printOut("Exception Thrown: "+e+"\nThis was most likely caused by not defining at least one doctor. Please define a doctor\n");
		}

		Clinic.printOut("---------------------------------------------------------------------------------------------------------");
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
			if doctorList.length > 1
			{
				for (int i = 0; i < doctorList.length-1; i++ )
				{
					if (nam.equals(doctorList[i].getName()))
					{
						System.out.println("Two doctorList cannot share the same name, please enter the doctorList name again");
						break;
					}
					else if(i == doctorList.length-2)
					{
						loop = -1;
					}
				}
			}
		} while (loop == 1);
		this.name = nam.toUpperCase();
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
			this.specialisation = spec.toUpperCase();

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
