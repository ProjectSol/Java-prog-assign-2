import java.util.*;
import java.lang.*;
import java.io.*;

public class Pet
{
	private String type; 	//the type of the pet. It can be only "cat" or "dog".
	private String size; 	//the size of the pet. It can be only "small", "medium" or "large".
	private String name; 	//the name of the pet.
	private double weight;//the weight of the pet.
	private int age; 		  //the age of the pet.
	private String doctor;//the doctor of the pet.
	Scanner console = new Scanner(System.in);//Declaration of the scanner

	//this exists so i have to type less
	public static void printOut(String string)
	{
		System.out.println(string);
	}

	//This also exists so that I have to type slig htly less
	public void printNLN(String string)
	{
		System.out.print(string);
	}

  public static Pet[] newPet(Pet[] petList)
  {
    //Our general way of calling the constructor for pets, does what it says on the tin
  	if(petList.length != 1)
  	{
  		petList[petList.length-1] = new Pet(petList, 1);
  		petList = Arrays.copyOf(petList, petList.length+1);

  	}
  	else
  	{
  		petList[0] = new Pet(petList, 1);
  		petList = Arrays.copyOf(petList, petList.length+1);
  		/*printOut(""+petList.length);
  		printOut(petList[0].getName());*/
  	}
  	return petList;
  }


	public Pet(Pet[] petList, int selection)
	{
		//pet constructor proper, the selection variable is present so we can initialise it without values when we input the data from a file
		if (selection != -1)
		{
			setName(petList);
			setType();
			setSize();
			setWeight();
			setAge();
			setDoctorInitialisation("no doctor assigned");
		}
		else
		{

		}
	}

	//We set the types and with the use of our loop after asking for input from the user we ensure that the input is either dog or cat.
	//The case of the word is ignored but what matters is that it is either DOG or CAT
	public void setType()
	{
		System.out.println("Please enter the type of pet to be treated, this type must be cat or dog");
		int loop = 1;
		do {
			String type = console.next();
			this.type = type.toUpperCase();

			if (this.type.equalsIgnoreCase("cat") || this.type.equalsIgnoreCase("dog"))
			{
				loop = -1;
			}
			else
			{
				//We'll keep looping till the user puts in dog or cat
				System.out.println("The type must be either dog or cat please reenter the pet's type");
			}
		} while (loop == 1);
	}

	public void setTypeFile(String petType)
	{
		//same as above but no loop. I will not comment all of the other file set functions as they are the same deal as this one
		String type = petType;
		this.type = type.toUpperCase();
		if (this.type.equalsIgnoreCase("cat") || this.type.equalsIgnoreCase("dog"))
		{

		}
		else
		{
			//We remove the loop in the new version so and set our error value to be setting the name to -999
			printOut("The type must be either dog or cat.\nThis pet has an error and will not be added to the list of pets");
			this.name = "-999";
		}
	}
	// a simple return method. Is self explanatory
	public String getType()
	{
		return type;
	}

	// The same as the set type above except we are ensuring it is small medium or large
	public void setSize()
	{
		System.out.println("Please input the pets size, small, medium or large");
		int loop = 1;
		String sizestr;
		do
		{
			sizestr = console.next();
      sizestr = sizestr.toUpperCase();
			if (sizestr.equalsIgnoreCase("small")||sizestr.equalsIgnoreCase("medium")||sizestr.equalsIgnoreCase("large"))
			{
				loop=-1;
			}
			else
			{
				//if they input an incorrect value the program won't let it go through
				System.out.println("The size must be either small, medium or large, please reenter the size");
			}
		} while (loop == 1);
		size = sizestr;
	}

	public void setSizeFile(String petSize)
	{
		int loop = 1, err = 1;
		String sizestr;
		do
		{
			sizestr = petSize;
			sizestr = sizestr.toUpperCase();
			if (sizestr.equalsIgnoreCase("small")||sizestr.equalsIgnoreCase("medium")||sizestr.equalsIgnoreCase("large"))
			{
				loop=-1;
			}
			else
			{
				//if they input an incorrect value the program won't let it go through
				System.out.println("The size must be either small, medium or large\nThis pet has an error and will not be added to the list of pets");
				name = "-999";
				err = -1;
			}
		} while (loop == 1);
		if (err != -1)
		{
			size = sizestr;
		}
	}

	// a simple return method. Is self explanatory
	public String getSize()
	{
		return size;
	}

	//We use the initial version of our input validation function because I forgot to update it to the new version and
	//it still works just fine as it is. we're ensuring that all our strings ignore case and that pets cannot share namestr
	//If they do not obey the program it will loop back tot he start and force a unique name for the pet to be entered
	public void setName(Pet[] petList)
	{
		System.out.println("Please input the pets name");

		String namestr;
		int loop = 1;
		do
		{
			namestr = console.next();
			if (petList.length > 1)
			{
				for (int i = 0; i < petList.length-1; i++)
				{
					if (namestr.equalsIgnoreCase(petList[i].getName()))
					{
						System.out.println("Two pets cannot share the same name, please reenter the name of the pet");
					}
					else if (i == petList.length-2)
					{
						loop = -1;
						break;
					}
				}
			}
			else
			{
				loop = -1;
			}
		} while (loop == 1);
		name = namestr.toUpperCase();
	}

	public void setNameFile(Pet[] petList, String petName)
	{
		String namestr;
		int err = 1;
		namestr = petName;

		if (petList.length > 1)
		{
			for (int i = 0; i < petList.length-1; i++)
			{
				if (namestr.equalsIgnoreCase(petList[i].getName()))
				{
					System.out.println("Two pets cannot share the same name, if you would like to add this pet please remove it from the existing list first.\n");
					name = "-999";
					err = -1;
					break;
				}
				else if (i == petList.length-2)
				{

					break;
				}
			}
		}
		if (err != -1)
		{
			name = namestr.toUpperCase();
		}
	}

	// a simple return method. Is self explanatory
	public String getName()
	{
		return name;
	}

	//much the same as all the other sets. The weight cannot be a negative number
	public void setWeight()
	{
		System.out.println("Please input the pets weight in kg");
		int loop = 1;
		double weightdbl;
		do {
			weightdbl = console.nextDouble();
			if (weightdbl > 0)
			{
				loop = -1;
			}
			else
			{
				System.out.println("The weight must be greater than 0, please re enter the weight");
			}
		} while (loop==1);
		weight = weightdbl;
	}
	public void setWeightFile(double petWeight)
	{
		//System.out.println("Please input the pets weight in kg");
		int err = 1;
		double weightdbl;
		weightdbl = petWeight;
		if (weightdbl > 0)
		{

		}
		else
		{
			System.out.println("The weight must be greater than 0\nThis pet has an error and will not be added to the list of pets");
			name = "-999";
			err = -1;
		}
		if (err != -1)
		{
			weight = weightdbl;
		}
	}

	// a simple return method. Is self explanatory
	public double getWeight()
	{
		return weight;
	}

	//much like the weight, this also cannot be negative
	public void setAge()
	{
		System.out.println("Please input the pets age");
		int loop = 1;
		int ageint;
		do {
			ageint = console.nextInt();
			if (ageint > 0)
			{
				loop = -1;
			}
			else
			{
				System.out.println("The age must be greater than 0, please re enter the age");
			}
		} while (loop==1);
		age = ageint;
	}


	public void setAgeFile(int petAge)
	{
		int err = 1;
		int ageint;
		ageint = petAge;
		if (ageint > 0)
		{

		}
		else
		{
			System.out.println("The age must be greater than 0\nThis pet has an error and will not be added to the list of pets");
			name = "-999";
			err = -1;
		}
		if (err != -1)
		{
			age = ageint;
		}
	}

	//Analyses the pet based on the requirements in the assesment guidelines. Just checks for weight, type and size and then returns if the pet is overweight or not, this takes no player input and was thus much easier to inplementssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssadasd
	public static void analysePetSelection(Pet[] petList)
	{
		//We'll list out the pets so that our user can see what their options are when analysing pets. Then we'll ask for input and run nameInputValidation() that defines our comp1 through 4 Strings to ensure that both the pets exist and that we do not have two with teh same name though in this case, it's just checking if they exist
		//After running that opening section we begin our while loop defining comp and loop outside to avoid any shenanigans and get user input comparing it to the names of each of our existing pet objects and if we get a match we run the actual analysis.
		//else we print out a little message to enter a new pet name and try again
		//It is worth mentioning that we ensure that there is atleast one pet before even running the main loop so as not to get trapped with no inputs tha t will exit the loop
		Scanner console = new Scanner(System.in);
		int loop = 1;
		if (petList.length == 1)
		{
			printOut("There are no pets, please define a pet first");
		}
		else
		{
			do
			{
				listPets(petList);
				printOut("Enter the name of the pet you would like to analyse\n");
				String petNam = console.next();
				for (int i = 0; i < petList.length-1; i++)
				{
					if (petList[i].getName().equalsIgnoreCase(petNam))
					{
						petList[i].analysePet();
						loop = -1;
						break;
					}
					else if (i == petList.length-2)
					{
						printOut("There is no pet to analyse with this name");
					}
				}
			} while (loop != -1);
		}
	}


	//runs all the comparisons based on the assignments criteria, weight type size and all that
	public void analysePet()
	{
		System.out.print(name+": \n");
		System.out.print("Name: "+name+": Type: "+type+" Size: "+size+" Weight: "+weight+" Age: "+age+" Doctor: "+doctor+"\n ");
		if (size.equalsIgnoreCase("small"))
		{
			if (weight>4 && type.equalsIgnoreCase("cat") || weight>6 && type.equalsIgnoreCase("dog"))
			{
				System.out.println("\n"+name+" is overweight, this system recomends more exercise");
			}
			else
			{
				System.out.println("\n"+name+" is at a healthy weight.");
			}
		}
		else if (size.equalsIgnoreCase("medium"))
		{
			if (weight>6 && type.equalsIgnoreCase("cat") || weight>9 && type.equalsIgnoreCase("dog"))
			{
				System.out.println("\n"+name+" is overweight, this system recomends more exercise");
			}
			else
			{
				System.out.println("\n"+name+" is at a healthy weight.");
			}
		}
		else if (size.equalsIgnoreCase("Large"))
		{
			if (weight>8 && type.equalsIgnoreCase("cat") || weight>12 && type.equalsIgnoreCase("dog"))
			{
				System.out.println("\n"+name+" is overweight, this system recomends more exercise");
			}
			else
			{
				System.out.println("\n"+name+" is at a healthy weight.");
			}
		}
	}

	// a simple return method. Is self explanatory
	public int getAge()
	{
		return age;
	}

	//This function is set up the way it is so that it can be run from functions within the clinic class. It is almost never run as a pet specific thing so it works better this way.
	public void setDoctorInitialisation(String docNam)
	{
		doctor = " "+docNam.toUpperCase();
	}

	//Sets the doc of the pet, checks against pet type to return messages if they docs type doesn't match
	public void setDoctor(Doctor[] doctorList, String petType)
	{
		int loop = 1;
		do {
			Doctor.listDoctors(doctorList);
			printOut("Name of Doctor you wish to assign to the pet, if you would like to assign no doctor please input 0");
			String docNam = console.next();
			doctor = docNam.toUpperCase();
			if (docNam.equalsIgnoreCase("0"))
			{
				doctor = "No doctor assigned";
				doctor = " "+doctor.toUpperCase();
				loop = -1;
			}
			else
			{
				int err = 0;
				if (doctorList.length != 0)
				{
					for (int i = 0; i < doctorList.length-1; i++)
					{
						if (doctorList[i].getName().equalsIgnoreCase(docNam))
						{
							err = 1;
						}
						else if (doctorList[i].getName().equalsIgnoreCase(docNam) == false && i == doctorList.length-2)
						{
								err = -1;
						}

						if (err == 1 && doctorList[i].getSpecialisation().equalsIgnoreCase(petType) != true)
						{
							err = -2;
						}



						if (err == 1)
						{
							loop = -1;
						}
						else if (err == -1)
						{
							printOut("Doctor does not exist\n");
						}
						else if (err == -2)
						{
							printOut("Pet type does not match doctor "+doctorList[i].getName()+"'S specialisation.\n"+doctorList[i].getName()+" has been assigned to this pet regardless\n");
							loop = -1;
						}
					}
				}
				else
				{
					printOut("Doctor does not exist\n");
				}
			}
		} while(loop != -1);
	}

	public void setDoctorFile(Doctor[] doctorList, String petType, String petDoctor)
	{
		int loop = 1;
		int run = 1;
		String docNam = petDoctor;
		doctor = docNam.toUpperCase();
		if (docNam.equalsIgnoreCase(" no doctor assigned"))
		{
			doctor = " no doctor assigned";
			doctor = docNam.toUpperCase();
			run = -1;
		}
		int err = 0;
		if (doctorList.length != 1)
		{
			if (run != -1)
			{
				for (int i = 0; i < doctorList.length-1; i++)
				{
					if (doctorList[i].getName().equalsIgnoreCase(docNam))
					{
						err = 1;
					}
					else if (doctorList[i].getName().equalsIgnoreCase(docNam) == false && i == doctorList.length-2)
					{
						printOut("Doctor does not exist\nThis pet has an error and will not be added to the list of pets");
						name = "-999";
					}

					if (err == 1 && doctorList[i].getSpecialisation().equalsIgnoreCase(petType) != true)
					{
						printOut("Pet type does not match doctor "+doctorList[i].getName()+"'S specialisation.\n"+doctorList[i].getName()+" has been assigned to this pet regardless\n");
					}
					else if (err == 1)
					{
						break;
					}
					else if (err == -1)
					{

					}
				}
			}
		}
		else
		{
			printOut("Doctor does not exist\nThis pet has an error and will not be added to the list of pets");
			name = "-999";
		}
	}


	// a simple return method. Is self explanatory
	public String getDoctor()
	{
		return doctor;
	}

	public static void listPets(Pet[] petList)
	{
		//This is our output for listing the pets, nothing if they don't exist and the proper values if they do. The strings are formatted in the same was as the chooseOption() method
		//Yes I copied that and changed one thing. Yes you know how this works, it's just slightly longer
		printOut("Listing Pets: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
			try
			{
				if (petList.length == 1)
				{
					printOut("Nothing to display, please enter a pet\n");
				}
				else
				{
					for(int i = 0; i < (petList.length-1); i++)
					{
						printOut("Pet "+(i+1)+":\nName: "+petList[i].getName()+": Type: "+petList[i].getType()+" Size: "+petList[i].getSize()+" Weight: "+petList[i].getWeight()+" Age: "+petList[i].getAge()+" Doctor: "+petList[i].getDoctor()+"\n");
					}
				}
			}
			catch(NullPointerException e)
			{
				printOut("Exception Thrown: "+e+"\n");
			}
			printOut("---------------------------------------------------------------------------------------------------------");
	}

	public static void listPetsDoc(Pet[] petList, Doctor[] doctorList)
	{
		//This is our output for listing the pets, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		//Yes I copied that and changed one thing. Yes you know how this works, it's just slightly longer
		//This one also only outputs if the doctor that was input matches teh doctor of the pet
		Scanner console = new Scanner(System.in);
		Doctor.listDoctors(doctorList);
		printOut("Please enter the name of the doctor whose paitients you would like to check\n");
		int foundOne = -1;
		String docName = console.next();

		printOut("Listing Pets: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		try
		{
			if (petList.length == 1)
			{
				printOut("Nothing to display, please enter a pet\n");
			}
			else
			{
				for(int i = 0; i < (petList.length-1); i++)
				{
					if (petList[i].getDoctor().equalsIgnoreCase(docName))
					{
						foundOne = 1;
						printOut("\nName: "+petList[i].getName()+": Type: "+petList[i].getType()+" Size: "+petList[i].getSize()+" Weight: "+petList[i].getWeight()+" Age: "+petList[i].getAge()+" Doctor: "+petList[i].getDoctor()+"\n");
					}
					else if( foundOne != 1 && i == petList.length-2 )
					{
						printOut("Nothing to display, no pets assigned to this doctor\n");
					}
				}
			}
		}
		catch(NullPointerException e)
		{
			printOut("Exception Thrown: "+e+"\n");
		}

		printOut("---------------------------------------------------------------------------------------------------------");
	}

	//updates the pets age var, does all of the same checks as when the pet is created, primarily because it calls the same function
	//Not going to cooment all the changes as they are all the same
	public static Pet[] changeAge(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose age you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
				petList[i].setAge();
				return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	public static Pet[] changeName(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose name you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
				petList[i].setName(petList);
				return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	public static Pet[] changeSize(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose size you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
				petList[i].setSize();
				return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	public static Pet[] changeWeight(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose weight you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
				petList[i].setWeight();
				return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	public static Pet[] changeType(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose age you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
			petList[i].setType();
			return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	public static Pet[] changeDoctor(Pet[] petList, Doctor[] doctorList)
	{
		Scanner console = new Scanner(System.in);
		Pet.listPets(petList);
		printOut("Please enter the name of the pet whose doctor you would like to change\n");
		String petNam = console.next();
		for (int i = 0; i < petList.length-1; i++)
		{
			if (petList[i].getName().equalsIgnoreCase(petNam))
			{
				String petType = petList[i].getType();
				petList[i].setDoctor(doctorList, petType);
				listPets(petList);
				return petList;
			}
		}
		printOut("There is no pet with that name.\n");
		return petList;
	}

	//Removes a pet from the list then shrinks the size of the list.
	//Fairly self explanatory
	public static Pet[] removePet(Pet[] petList)
	{
		Scanner console = new Scanner(System.in);
		listPets(petList);
		if (petList.length>1)
		{
			printOut("Are you sure you would like to remove a pet?\nThis process cannot be undone if you would like remove a pet please enter the corresponding number eg( 1 for pet 1, 2 for pet 2 )\nIf you have changed your mind and would not like to delete a doctor, please enter -1\n\n");
			int numDelete = console.nextInt();
			if (numDelete != -1)
			{
				int petToBeDel = numDelete-1;
				printOut("Are you sure you would like to delete "+petList[numDelete-1].getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{
					Pet[] petListNew = new Pet[petList.length-1];

					for (int i = 0; i < (petListNew.length-1); i++)
					{
						if ( i < petToBeDel )
						{
							petListNew[i] = petList[i];
							printOut(petListNew[i].getName());
						}
						else if ( i >= petToBeDel )
						{
							petListNew[i] = petList[i+1];
							printOut(petListNew[i].getName());
						}
					}

					petListNew = Arrays.copyOf(petListNew, petList.length-1);

					listPets(petListNew);
					return petListNew;
				}
				else
				{
					printOut("Cancelling pet removal");
					return petList;
				}
			}
			return petList;
		}
		return petList;
	}

	//Runs all the set file functions in order. Will not save the pet if anything breaks
	public static Pet[] newPetFromFile(Doctor[] doctorList, Pet[] petList, String petName, int petAge, String petSize, double petWeight, String petDoctor, String petType)
  {
    //The line below never completes after applying the suggested change
			petList[petList.length-1] = new Pet(petList, -1);

  		petList[petList.length-1].setNameFile(petList, petName);
			if(!petList[petList.length-1].getName().equals("-999"))
			{

				petList[petList.length-1].setTypeFile(petType);
				if(!petList[petList.length-1].getName().equals("-999"))
				{

					petList[petList.length-1].setSizeFile(petSize);
					if(!petList[petList.length-1].getName().equals("-999"))
					{

						petList[petList.length-1].setWeightFile(petWeight);
						if(!petList[petList.length-1].getName().equals("-999"))
						{

							petList[petList.length-1].setAgeFile(petAge);
							if(!petList[petList.length-1].getName().equals("-999"))
							{

								petList[petList.length-1].setDoctorFile(doctorList, petType, petDoctor);
								if(!petList[petList.length-1].getName().equals("-999"))
								{

					  			petList = Arrays.copyOf(petList, petList.length+1);
									return petList;
								}
							}
						}
					}
				}
			}
  	return petList;
  }

	//Checks all the doctors assigned to pets then checks all the doctors, if there is not
	//match between the pet and existing docs, it removes the pets doc and sets it back to no doctor assigned
	public static Pet[] checkDoctorExists(Pet[] petList, Doctor[] doctorList)
	{
		for (int i = 0; i < petList.length-1; i++)
		{
			if (doctorList.length == 1)
			{
				printOut(petList[i].getName()+"'S doctor no longer exists\nRemoving...");
				petList[i].setDoctorInitialisation("no doctor assigned");
			}
			for (int k = 0; k < doctorList.length-1; k++)
			{
				String namDelete = doctorList[k].getName();
				if (petList[i].getDoctor().equalsIgnoreCase(namDelete))
				{
					printOut(namDelete+" exists, "+petList[i].getName()+" will not have their doctor removed");
					break;
				}
				else if (k == doctorList.length-2)
				{
					printOut(petList[i].getName()+"'S doctor no longer exists\nRemoving...");
					petList[i].setDoctorInitialisation("no doctor assigned");
				}
			}
		}
		return petList;
	}

}
