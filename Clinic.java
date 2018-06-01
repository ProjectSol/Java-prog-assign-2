/*Clinic Assignment
*Author: Solomon Scobie
*Student No: 3302821
*Date: 13/04/18
*Description: This program uses doctor and pet objects to emulate very basic software for organising a small veterinary clinic
*/

//Inclusion of required libraries
import java.util.*;
import java.lang.*;
import java.io.*;

public class Clinic
{
	/*Definition of all the necessary variables. Most should be self explanatory except for opt and comp1 through dcomp2.
	 *opt stands for option and is the variable used by the chooseOption() method, it is sent to a switch statment and controls when a method is run and how. Opt is defined by player input.
	 *comp1 through dcomp2 are the names of the pets and doctors, dcomp being doctors used for comparison so that we can use the strings to ensure both that the specific pet or doctor exists but also
	 *ensuring that there is not another pet or doctor with the same name
	 */
	Scanner console = new Scanner(System.in);
	private int opt;
	public Doctor[] doctorList = new Doctor[1];
	public Pet[] petList = new Pet[1];

	public static void main(String[] args)
	{
		//The main primarily takes a back seat to the run method but we do define our clinic object here and use it to run "run"
  	Clinic clinic = new Clinic();
  	clinic.run();
	}

	private void run()
	{
		/*This method controls the flow of the program primarly through the chooseOption() method. We also setout all our starting values for doctors and pets
		 *The switch statement below chooseOption selects all the ways that we can access the program and get it to run our subprograms to add pets, remove pets, assign doctors and so forth
		 */

		int runcounter = 0;
		do
		{
			if (runcounter == 1)
			{
				printOut("\nEnter any character to return to the menu");
				console.next();
			}
			runcounter = 1;
			try
			{
				//Choose option lists out the possible selections and returns what the player has selected.
				//I would comment what all these functions do but the name says it and there are comments in them
				opt = chooseOption();
				switch (opt)
				{
					case 1:
						doctorList = newDoc(doctorList);
						break;
					case 2:
						doctorList = removeDoc(doctorList);
						petList = checkPetDoctors(petList, doctorList);
						break;
					case 3:
						doctorList = bubbleDoctorByAlpha(doctorList);
						listDocs(doctorList);
						break;
					case 4:
						petList = newPet(petList);
						break;
					case 5:
						petList = removePet(petList);
						break;
					case 6:
						petList = changePetDetails(petList, doctorList);
						runcounter = 0;
						opt = 1;
						break;
					case 7:
						petList = bubblePetByAlpha(petList);
						listPets(petList);
						break;
					case 8:
						petList = bubblePetByAlpha(petList);
						listPetsDoc(petList, doctorList);
						break;
					case 9:
						analysePets(petList);
						break;
					case 10:
						doctorList = pullDataDoctors(petList, doctorList);
						petList = pullDataPets(petList,doctorList);
						listDocs(doctorList);
						break;
					case 11:
						storePets(petList);
						storeDoctors(doctorList);
						break;


					//Now that we've laid out all the options for using the program we should also add a way to exit without simply crashing the program
					case -1:
						System.exit(0);
						break;
					}
				}
				catch(InputMismatchException e)
				{
					//Handling the user putting in an invalid input
					printOut("Your input caused an error, please try again.\nThe error was an "+e+"\n");
					runcounter = 1;
					console.next();
				}
		}	while (opt != -1);
	}

	public Pet[] changePetDetails(Pet[] petList, Doctor[] doctorList)
	{
		//This is a second menu for our changing the pet details,runs off of the same principle as run.
		int runcounter = 0;
		do
		{
			if (runcounter == 1)
			{
				printOut("\nEnter any character to return to the menu");
				console.next();
			}
			runcounter = 1;
			opt = chooseOption2();
			switch (opt)
			{
				case 1:
					petList = changeDoctor(petList, doctorList);
					break;
				case 2:
					petList = changeType(petList);
					break;
				case 3:
					petList = changeSize(petList);
					break;
				case 4:
					petList = changeAge(petList);
					break;
				case 5:
					petList = changeWeight(petList);
					break;
				case 6:
					petList = changeName(petList);
					break;
				case -1:
					//opt is now == to -1 so we'll leave the loop after breaking
					break;

			}
		} while (opt != -1);
		return petList;
	}

	private int chooseOption()
	{
		//Simple print statements, I made a method specifically so I would not have to type System.out.println and System.out.print. At the end of this section we return our users selection as an integer
		//This integer is set as the value for opt. opt is short for option and described above.
		int option;

		printOut("\nClinic settings, please select an option \n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to add a new Doctor to the roster please input ------- 1\n");
		printOut("If you would like to remove a Doctor from the roster please input ------ 2\n");
		printOut("If you would like to list all doctors please input --------------------- 3\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to add a new Pet being treated please input ---------- 4\n");
		printOut("If you would like to remove a pet from being treated please input ------ 5\n");
		printOut("If you would like to change a pets details please input ---------------- 6\n");
		printOut("If you would like to list all pets please input ------------------------ 7\n");
		printOut("If you would like to list all pets based on a doctor please input ------ 8\n");
		printOut("If you would like to analyse a pet please input ------------------------ 9\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to add doctors and pets from file please enter ------ 10\n");
		printOut("If you would like to save data to file please enter ------------------- 11\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to quit, please input ------------------------------- -1\n");
		printOut("--------------------------------------------------------------------------\n");
		option = console.nextInt();
		return option;
	}

	public int chooseOption2()
	{
		//see the previous function
		printOut("Pet editor, please select an option\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to change the Doctor assigned to a pet please input -- 1\n");
		printOut("If you would like to change the type of a pet please input ------------- 2\n");
		printOut("If you would like to change the size of a pet please input ------------- 3\n");
		printOut("If you would like to change the age of a pet please input -------------- 4\n");
		printOut("If you would like to change the weight of a pet please input ----------- 5\n");
		printOut("If you would like to change the name of a pet please input ------------- 6\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to return to the main menu please input ------------- -1\n");
		printOut("--------------------------------------------------------------------------\n");
		int option = console.nextInt();
		return option;
	}

	//This exists so that I have to type slightly less
	public static void printOut(String string)
	{
		System.out.println(string);
	}

	//This also exists so that I have to type slightly less
	public void printNLN(String string)
	{
		System.out.print(string);
	}



	//Doctor functions
	//These will get their comments inside their classes

	public Doctor[] newDoc(Doctor[] doctorList)
	{
		doctorList = Doctor.newDoctor(doctorList);
		return doctorList;
	}

	public void listDocs(Doctor[] doctorList)
	{
 		Doctor.listDoctors(doctorList);
	}

	public Doctor[] removeDoc(Doctor[] doctorList)
	{
		doctorList = Doctor.removeDoctor(doctorList);
		return doctorList;
	}


	//And now the thousands of pet functions


	public Pet[] newPet(Pet[] petList)
	{
		petList = Pet.newPet(petList);
		return petList;
	}

	public void listPets(Pet[] petList)
	{
		Pet.listPets(petList);
	}

	public void listPetsDoc(Pet[] petList, Doctor[] doctorList)
	{
		Pet.listPetsDoc(petList, doctorList);
	}

	public Pet[] changeDoctor(Pet[] petList, Doctor[] doctorList)
	{
		petList = Pet.changeDoctor(petList, doctorList);
		return petList;
	}

	public Pet[] changeName(Pet[] petList)
	{
		petList = Pet.changeName(petList);
		return petList;
	}

	public Pet[] changeType(Pet[] petList)
	{
		petList = Pet.changeType(petList);
		return petList;
	}

	public Pet[] changeSize(Pet[] petList)
	{
		petList = Pet.changeSize(petList);
		return petList;
	}

	public Pet[] changeWeight(Pet[] petList)
	{
		petList = Pet.changeWeight(petList);
		return petList;
	}

	public Pet[] changeAge(Pet[] petList)
	{
		petList = Pet.changeAge(petList);
		return petList;
	}

	public Pet[] removePet(Pet[] petList)
	{
		petList = Pet.removePet(petList);
		return petList;
	}

	public void analysePets(Pet[] petList)
	{
		Pet.analysePetSelection(petList);
	}

	public Pet[] checkPetDoctors(Pet[] petList, Doctor[] doctorList)
	{
		petList = Pet.checkDoctorExists(petList, doctorList);
		return petList;
	}

	//File Reading and writing

	public Doctor[] pullDataDoctors(Pet[] petList, Doctor[] doctorList)
	{
		//Alright, we're using scanners to get out all the details of the files we're interested in.
		//We'll return one string at a time with input.next() ensuring we have more things that we can read with .hasNext()
		//Then we'll check what var type we're entering then after we know that we'll get the var and store it in the required pet

		String fileName = "VetManagement.txt";
		Scanner input = null;
		try {
			String docName = "-999", docSpec = "-999";
			int docNameCheck = 0, docSpecCheck = 0;
			input = new Scanner (new File (fileName));
			while (input.hasNext())
			{
				String line = input.next();
				if (line.equals("Doctors"))
				{
					int loop = 0;
					while (input.hasNext())
					{
						line = input.next();
						if (true != line.equals("Pets"))
						{
							printNLN(line+": ");
							if (line.equals("name"))
							{
								if (input.hasNext())
								{
									docName = input.next();
									printOut(docName);
									docNameCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("specialisation"))
							{
								if (input.hasNext())
								{
									docSpec = input.next();
									printOut(docSpec);
									docSpecCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else
							{
								if (input.hasNext())
								{
									String moveToNext = input.next();
								}
								else
								{
									loop = -1;
								}
								printOut("Input invalid.\nCancelling...\n");
							}
							if (loop == -1)
							{
								return doctorList;
							}
							if (docNameCheck == 1 && docSpecCheck == 1)
							{
								printOut("Run doctor setup\n");
								docNameCheck = 0;
								docSpecCheck = 0;
								doctorList = Doctor.newDocFromFile(doctorList, petList, docName, docSpec);
							}
						}
						else
						{
							printOut("All doctors read, exiting\n");
							return doctorList;
						}
					}
					if(input.hasNext())
					{
						printOut("All doctors read, exiting\n");
						doctorList = Doctor.newDocFromFile(doctorList, petList, docName, docSpec);
						return doctorList;
					}
				}
			}
			printOut("All doctors read, exiting\n");
			return doctorList;
		}
		catch (FileNotFoundException e)
		{
			printOut("Error opening the file " +fileName);
		}
		finally
		{
			//Using finally ensures that our file will always close if it is open.
			if (input != null)
			{
        input.close();
      }
		}
		return doctorList;
	}

	public Pet[] pullDataPets(Pet[] petList, Doctor[] doctorList)
	{


		//Read the previous function

		String fileName = "VetManagement.txt";
		Scanner input = null;

		try {
			String petName = "uninitialised", petType = "uninitialised", petSize = "uninitialised", petDoctor = "uninitialised";
			double petWeight = -999;
			int petAge = -999;
			int petAgeCheck = 0, petNamCheck = 0, petTypCheck = 0, petWeightCheck = 0, petDocCheck = 0, petSizCheck = 0;
			input = new Scanner (new File (fileName));
			while (input.hasNext())
			{
				String line = input.next();
				if (line.equals("Pets"))
				{
					int loop = 0;
					while (input.hasNext())
					{
						line = input.next();
						if (true != line.equals("Doctors"))
						{
							printNLN(line+": ");
							if (line.equals("type"))
							{
								if (input.hasNext())
								{
									petType = input.next();
									printOut(petType);
									petTypCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("size"))
							{
								if (input.hasNext())
								{
									petSize = input.next();
									printOut(petSize);
									petSizCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("name"))
							{
								if (input.hasNext())
								{
									petName = input.next();
									printOut(petName);
									petNamCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("weight"))
							{
								if (input.hasNextDouble())
								{
									petWeight = input.nextDouble();
									printOut(""+petWeight);
									petWeightCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("age"))
							{
								if (input.hasNextInt())
								{
									petAge = input.nextInt();
									printOut(""+petAge);
									petAgeCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else if (line.equals("doctor"))
							{
								if (input.hasNext())
								{
									petDoctor = input.nextLine();
									printOut(""+petDoctor);
									petDocCheck = 1;
								}
								else
								{
									printOut("Input invalid.\nCancelling...\n");
									//loop = -1;
								}
							}
							else
							{
								if (input.hasNext())
								{
									String moveToNext = input.next();
								}
								else
								{
									loop = -1;
								}
								printOut("Input invalid.\nCancelling...\n");
							}
							if (loop == -1)
							{
								break;
							}
							if (petNamCheck == 1 && petAgeCheck == 1 && petWeightCheck == 1 && petSizCheck == 1 && petDocCheck == 1 && petTypCheck == 1)
							{
								printOut("Running pet setup\n");
								petNamCheck = 0;
								petSizCheck = 0;
								petAgeCheck = 0;
								petWeightCheck = 0;
								petTypCheck = 0;
								petDocCheck = 0;
								//run the pet setup
								petList = Pet.newPetFromFile(doctorList, petList, petName, petAge, petSize, petWeight, petDoctor, petType);
							}
						}
						else
						{
							printOut("All pets read, exiting\n");
							return petList;
						}
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			printOut("Error opening the file " +fileName);
		}
		finally
		{
			//Using finally ensures that our file will always close if it is open.
			if (input != null)
			{
      	input.close();
    	}
		}
		return petList;
	}


	public void storePets(Pet[] petList)
	{
		//Really this is pretty basic. We just iterate through every entry in the array
		//and print their values to the file in the order of the original petManagement.java.
		PrintWriter output = null;
		String fileName = "VetManagement.txt";
		try
		{
			output = new PrintWriter(fileName);
			output.println("Pets");
			for (int i = 0; i < petList.length-1; i++)
			{
				output.println("type "+petList[i].getType().toLowerCase());
				output.println("size "+petList[i].getSize().toLowerCase());
				output.println("name "+petList[i].getName().toLowerCase());
				output.println("weight "+petList[i].getWeight());
				output.println("age "+petList[i].getAge());
				output.println("doctor"+petList[i].getDoctor().toLowerCase());
			}
	 	}
		catch (FileNotFoundException e)
		{
			printOut("Error opening the file " + fileName);
		}
		finally
		{
			//I've commented the finally twice already
			if (output != null)
			{
      	output.close();
    	}
		}
	}

	public void storeDoctors(Doctor[] doctorList)
	{
		//This is the same as storePets but instead of deleting the file and starting from the beginning
		//storeDoctors will appened to the file. The option that makes it append is detailed just below this
		PrintWriter output = null;
		String fileName = "VetManagement.txt";
		try
		{
			//the true exists in order to set the doctor func to append rather than delete the whole file and start printing from there
			output = new PrintWriter(new FileOutputStream(new File(fileName), true));
			output.println("Doctors");
			for (int i = 0; i < doctorList.length-1; i++)
			{
				output.println("name "+doctorList[i].getName().toLowerCase());
				output.println("specialisation "+doctorList[i].getSpecialisation().toLowerCase());
			}
	 	}
		catch (FileNotFoundException e)
		{
			System.out.println ("Error opening the file " + fileName);
		}
		finally
		{
			//HaHaaaaaaaaaaaaaaaaaaa
			if (output != null)
			{
      	output.close();
    	}
		}
	}


	Pet[] swapPet(Pet[] petList, int k, int j)
	{
		//Takes two entries in an array if one should be before the other after comparing their name strings
		//Then it swaps them first creating a temporary variable to stop frmo just duplicating the original
		//IF they don't need to change positions it doesn't change their positions. That kinda goes without saying but ya know
	  if(petList[j].getName().compareTo(petList[k].getName()) < 0)
	  {
	    Pet temp = petList[k];
	    petList[k] = petList[j];
	    petList[j] = temp;
	    return petList;
	  }
	  else if(petList[j].getName().compareTo(petList[k].getName()) == 0)
	  {
	    return petList;
	  }
	  else
	  {
	    return petList;
	  }
	}

	Doctor[] swapDoc(Doctor[] doctorList, int k, int j)
	{
		//see above
	  if(doctorList[j].getName().compareTo(doctorList[k].getName()) < 0)
	  {
	    Doctor temp = doctorList[k];
	    doctorList[k] = doctorList[j];
	    doctorList[j] = temp;
	    return doctorList;
	  }
	  else if(doctorList[j].getName().compareTo(doctorList[k].getName()) == 0)
	  {
	    return doctorList;
	  }
	  else
	  {
	    return doctorList;
	  }
	}

	Pet[] bubblePetByAlpha(Pet[] petList)
	{
		//The most basic possible bubble sort. Check swap pet for the actual swap
		//all this does is iterate through then call a method that swaps the two entries if their values should be in the opposite order
		printOut("Would you like to sort all pets alphabetically before displaying?\nPlease enter y for yes and n for no");
		String yn = console.next();
		if (yn.equalsIgnoreCase("y"))
		{
			int	j;
		  int arraySize = petList.length-1;
		  for(int i	=	0;	i	<	arraySize;	i++)
		  {
		    for(int k	=	0;	k	<	arraySize-1;	k++)
		    {
		      j  = k+1;
		      petList = swapPet(petList,k,j);
				}
			}
		}
		else
		{
			printOut("\nPets will not be sorted prior to display.\n\nDisplaying...\n");
		}
		return petList;
	}

	Doctor[] bubbleDoctorByAlpha(Doctor[] doctorList)
	{
		//The most basic possible bubble sort. Check swap pet for the actual swap all this does is iterate through then call a method that swaps the two entries if their values should be in the opposite order
		printOut("Would you like to sort all pets alphabetically before displaying?\nPlease enter y for yes and n for no");
		String yn = console.next();
		if (yn.equalsIgnoreCase("y"))
		{
			int	j;
		  int arraySize = doctorList.length-1;
		  for(int i	=	0;	i	<	arraySize;	i++)
		  {
		    for(int k	=	0;	k	<	arraySize-1;	k++)
		    {
		      j  = k+1;
		      doctorList = swapDoc(doctorList,k,j);
				}
			}
		}
		else
		{
			printOut("Doctors will not be sorted prior to display.\n\nDisplaying...\n");
		}
		return doctorList;
	}

	public Pet[] sortPets(Pet[] petList)
	{
		//Check the bubble functions I'm not repeating this below
		petList = bubblePetByAlpha(petList);
		return petList;
	}

	public Doctor[] sortDoctors(Doctor[] doctorList)
	{
		doctorList = bubbleDoctorByAlpha(doctorList);
		return doctorList;
	}
}
