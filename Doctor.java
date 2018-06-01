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
  {
		//much the same as the newPet function check that
		doctorList[doctorList.length-1] = new Doctor(doctorList, 1);
		doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
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
			printOut("Exception Thrown: "+e+"\n");
		}

		printOut("---------------------------------------------------------------------------------------------------------");
	}

  /*private void reSize(Doctor[] arr, int newSize)
  {
    Doctor[] arr2 = Arrays.copyOf(arr, newSize);
    return arr2;
  }*/

	public Doctor(Doctor[] doctorList, int selection)
	{
		//The same as Pet constructor, check there
		if(selection != -1)
		{
			setName(doctorList);
			setSpecialisation();
		}
		else
		{

		}
	}

	// Defines a scanner object to read input asks the user for a name and recives this input setting it to the current Doctor objects specialisation
	//It also prevents duplicate names through the use of the dcomp variables and then will force a loop on the user until fixed
	public void setName(Doctor[] doctorList)
	{
		System.out.println("Please enter the name of the Doctor");
		int loop = 1;
		String nam;
		do {
			nam = " "+console.nextLine();
			if (doctorList.length > 1)
			{
				for (int i = 0; i < doctorList.length-1; i++ )
				{
					if (nam.equalsIgnoreCase(doctorList[i].getName()))
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

	//This all works the way the pets set file functions work, so I'll follow it in the same way
	public void setNameFile(Doctor[] doctorList, String docName)
	{
		String nam = docName;
		this.name = " "+nam.toUpperCase();
		if (doctorList.length > 1)
		{
			for (int i = 0; i < doctorList.length-1; i++ )
			{
				if (nam.equalsIgnoreCase(doctorList[i].getName()))
				{
					System.out.println("Two doctorList cannot share the same name\nThis doctor has an error and will not be added to the list of doctors");
					name = "-999";
				}
			}
		}
	}

	// a simple return method. Is self explanatory
	public String getName()
	{
		return name;
	}

	// Defines a scanner object to read input asks the user for a specialisation and recives this input setting it to
	//the current Doctor objects specialisation also prevents the assinging of the input unless the user input dog or cat
	public void setSpecialisation()
	{
		int loop = 1;
		System.out.println("Please enter the specialisation of the Doctor, this specialisation should be cat or dog");
		do {
			String spec = console.nextLine();
			this.specialisation = spec.toUpperCase();

			if (this.specialisation.equalsIgnoreCase("cat") || this.specialisation.equalsIgnoreCase("dog"))
			{

				loop = -1;

			}
			else
			{
				System.out.println("The specialisation must be either dog or cat please re-enter the doctorList specialisation");
				//System.out.println("It did not run it");
			}
		} while (loop == 1);
	}

	public void setSpecialisationFile(String docSpecialisation)
	{
		String spec = docSpecialisation;
		this.specialisation = spec.toUpperCase();

		if (this.specialisation.equalsIgnoreCase("cat") || this.specialisation.equalsIgnoreCase("dog"))
		{
		}
		else
		{
			System.out.println("The specialisation must be either dog or cat\nThis doctor has an error and will not be added to the list of doctors");
			name = "-999";
		}
	}

	// a simple return method. Is self explanatory
	public String getSpecialisation()
	{
		return specialisation;
	}

	//Removes doctors, remakes the list without adding the removed doctor then shrinks the size of the array.
	//The function to remove doctors that no longer exist from their pets is placed elsewhere
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

	//Makes doctors from files, calling all the set file functions and that jazz
	public static Doctor[] newDocFromFile(Doctor[] doctorList, Pet[] petList, String docName, String docSpecialisation)
	{
		doctorList[doctorList.length-1] = new Doctor(doctorList, -1);
		doctorList[doctorList.length-1].setNameFile(doctorList, docName);
		if(!doctorList[doctorList.length-1].getName().equals("-999"))
		{
			doctorList[doctorList.length-1].setSpecialisationFile(docSpecialisation);
			if(!doctorList[doctorList.length-1].getName().equals("-999"))
			{
				doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
				return doctorList;
			}
		}
		return doctorList;
	}
}
