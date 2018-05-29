//Importing necessary libraries
import java.util.*;
import java.lang.*;
import java.io.*;

public class Doctor
{
	//defining the global vars for each Doctor object
	private String name; 	// the name of the Doctor
	private String specialisation; 	// the specialisation of the Doctor (it can be "dog" or "cat")
	//private Doctor[] doctorList;
	Scanner console = new Scanner(System.in);

	//This exists so that I have to type slightly less
	public static void printOut(String string)
	{
		System.out.println(string);
	}

	//This also exists so that I have to type slig htly less
	public void printNLN(String string)
	{
		System.out.print(string);
	}

  public static Doctor[] newDoctor(Doctor[] doctorList)
  { //The line below never completes after applying the suggested change
		//printOut(""+doctorList.length);
		if(doctorList.length != 1)
		{
			//printOut("We ran the length is not 1 loop");
			doctorList[doctorList.length-1] = new Doctor(doctorList);
			doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
			//printOut(doctorList[0].getName());
		}
		else
		{
			doctorList[0] = new Doctor(doctorList);
			doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
			/*printOut(""+doctorList.length);
			printOut(doctorList[0].getName());*/
		}
		return doctorList;
  }

	public static void listDoctors(Doctor[] doctorList)
	{
		//This is our output for listing the doctors, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		printOut("Listing Doctors: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		try
		{
			if (doctorList.length == 1)
			{
				printOut("Nothing to display, please enter a doctor\n");
			}
			else
			{
				for(int i = 0; i < (doctorList.length-1); i++)
				{
					printOut("Doctor "+(i+1)+":\n Name: "+doctorList[i].getName()+" Specialisation: "+doctorList[i].getSpecialisation()+"\n");
				}
			}
		}
		catch(NullPointerException e)
		{
			printOut("Exception Thrown: "+e+"\nThis was most likely caused by not defining at least one doctor. Please define a doctor\n");
		}

		printOut("---------------------------------------------------------------------------------------------------------");
	}

  /*private void reSize(Doctor[] arr, int newSize)
  {
    Doctor[] arr2 = Arrays.copyOf(arr, newSize);
    return arr2;
  }*/

	public Doctor(Doctor[] doctorList)
	{
		setName(doctorList);
		setSpecialisation();
	}

	// Defines a scanner object to read input asks the user for a name and recives this input setting it to the current Doctor objects specialisation
	//It also prevents duplicate names through the use of the dcomp variables and then will force a loop on the user until fixed
	public void setName(Doctor[] doctorList)
	{
		System.out.println("Please enter the name of the Doctor");
		int loop = 1;
		String nam;
		do {
			nam = console.nextLine();
			if (doctorList.length > 1)
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
			else
			{
				loop = -1;
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

	public static Doctor[] removeDoctor(Doctor[] doctorList)
	{
		Scanner console = new Scanner(System.in);
		listDoctors(doctorList);
		printOut("Are you sure you would like to remove a doctor?\nThis process cannot be undone if you would like remove a doctor please enter the corresponding number eg( 1 for doc1, 2 for doc2 )\nIf you have changed your mind and would not like to delete a doctor, please enter -1\n\n");
		int numDelete = console.nextInt();
		if (numDelete != -1)
		{
			int docToBeDel = numDelete-1;
			printOut("Are you sure you would like to delete "+doctorList[numDelete-1].getName()+" type y to delete type n to cancel");
			String yn = console.next();
			if (yn.equalsIgnoreCase("y"))
			{
				Doctor[] doctListNew = new Doctor[doctorList.length-1];

				for (int i = 0; i < (doctListNew.length-1); i++)
				{
					if ( i < docToBeDel )
					{
						doctListNew[i] = doctorList[i];
						printOut(doctListNew[i].getName());
					}
					else if ( i >= docToBeDel )
					{
						doctListNew[i] = doctorList[i+1];
						printOut(doctListNew[i].getName());
					}
				}

				doctListNew = Arrays.copyOf(doctListNew, doctorList.length-1);

				listDoctors(doctListNew);
				return doctListNew;
			}
			else
			{
				printOut("Cancelling doctor removal");
				return doctorList;
			}
		}
		return doctorList;
	}
}
