/*Clinic Assignment
*Author: Solomon Scobie
*Student No: 3302821
*Date: 13/04/18
*Description: This program uses doctor and pet objects to emulate very basic software for organising a small veterinary clinic
*/

//Inclusion of required libraries
import java.util.*;
import java.lang.*;

public class Clinic
{
	/*Definition of all the necessary variables. Most should be self explanatory except for opt and comp1 through dcomp2.
	 *opt stands for option and is the variable used by the chooseOption() method, it is sent to a switch statment and controls when a method is run and how. Opt is defined by player input.
	 *comp1 through dcomp2 are the names of the pets and doctors, dcomp being doctors used for comparison so that we can use the strings to ensure both that the specific pet or doctor exists but also
	 *ensuring that there is not another pet or doctor with the same name
	 */
	Scanner console = new Scanner(System.in);
	private int opt;
	String comp1,comp2,comp3,comp4,dcomp1,dcomp2;

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
			opt = chooseOption();
			switch (opt)
			{
				case 1:
					addDoctor();
					break;
				case 2:
					//removeDoctor();
					break;
				case 3:
					//listDocs();
					break;
				case 4:
					//addPet();
					break;
				case 5:
					//removePet();
					break;
				case 6:
					//assignDoctor();
					break;
				case 7:
					//listPets();
					break;
				case 8:
					//listPetsDoc();
					break;
				case 9:
					//analysePets();
					break;



				//Now that we've laid out all the options for using the program we should also add a way to exit without simply crashing the program
				case -1:
					System.exit(0);
					break;
			}
		}	while (opt != -1);
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
		/*printOut("If you would like to list all doctors please input --------------------- 3\n");
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to add a new Pet being treated please input ---------- 4\n");
		printOut("If you would like to remove a pet from being treated please input ------ 5\n");
		printOut("If you would like to change the doctor assigned to a pet please input -- 6\n");
		printOut("If you would like to list all pets please input ------------------------ 7\n");
		printOut("If you would like to list all pets based on a doctor please input ------ 8\n");
		printOut("If you would like to analyse a pet please input ------------------------ 9\n");*/
		printOut("--------------------------------------------------------------------------\n");
		printOut("If you would like to quit, please input ------------------------------- -1\n");
		printOut("--------------------------------------------------------------------------\n");
		option = console.nextInt();
		return option;
	}

	//This exists so that I have to type slightly less
	public void printOut(String string)
	{
		System.out.println(string);
	}

	//This also exists so that I have to type slightly less
	public void printNLN(String string)
	{
		System.out.print(string);
	}

	public void addDoctor()
	{
		//Here is where we define new doctors. docNameInputValidation is the function that defines dcomp1 and dcomp2 those are both used inside of our constructor to ensure we do not have duplicate doctors
		//We are also using a few if statements to ensure that either doctor1 or doctor2 are open and able to take a new doctor object if both are full we print out a little message to the user
		docNameInputValidation();
		if (doctor1==null || doctor2==null)
		{
			Doctor doctor = new Doctor(dcomp1, dcomp2);

			if (doctor1==null)
			{
				doctor1 = doctor;
			}
			else
			{
				doctor2 = doctor;
			}
		}
		else
		{
			System.out.println("no space for a new doctor");
		}
	}

	/*public void addPet()
	{
		//Please refer to add doctor above as both of these functions are almost identical. There are of course more comp inputs than last time and more pet objects to check however we still do almost the same steps and outputs
		if (pet1==null || pet2==null || pet3==null || pet4==null)
		{
			nameInputValidation();
			Pet pet = new Pet(comp1,comp2,comp3,comp4);

			if (pet1==null)
			{
				pet1 = pet;
			}
			else if (pet2==null)
			{
				pet2 = pet;
			}
			else if (pet3==null)
			{
				pet3 = pet;
			}
			else
			{
				pet4 = pet;
			}
		}
		else
		{
			printOut("No space to add a new pet, please delete an old pet first");
		}
	}

	public void analysePets()
	{
		//We'll list out the pets so that our user can see what their options are when analysing pets. Then we'll ask for input and run nameInputValidation() that defines our comp1 through 4 Strings to ensure that both the pets exist and that we do not have two with teh same name though in this case, it's just checking if they exist
		//After running that opening section we begin our while loop defining comp and loop outside to avoid any shenanigans and get user input comparing it to the names of each of our existing pet objects and if we get a match we run the actual analysis.
		//Else we print out a little message to enter a new pet name and try again
		//It is worth mentioning that we ensure that there is atleast one pet before even running the main loop so as not to get trapped with no inputs tha t will exit the loop
		if (pet1==null && pet2==null && pet3==null && pet4==null)
		{
			printOut("There are no pets, please define a pet first");
		}
		else
		{
			listPets();
			printOut("Enter the name of the pet you would like to analyse");
			nameInputValidation();
			String comp;
			int loop =1;
			do
			{
				comp = console.next();
				if (comp.equalsIgnoreCase(comp1))
				{
					pet1.analysePet();
					loop = -1;
				}
				else if (comp.equalsIgnoreCase(comp2))
				{
					pet2.analysePet();
					loop = -1;
				}
				else if (comp.equalsIgnoreCase(comp3))
				{
					pet3.analysePet();
					loop = -1;
				}
				else if (comp.equalsIgnoreCase(comp4))
				{
					pet4.analysePet();
					loop = -1;
				}
				else
				{
					printOut("There is no pet to analyse with this name");
				}
			} while (loop==1);
		}
	}

	public void nameInputValidation()
	{
		//The fabled pet input validation. It sets the comp variables to empty strings if the corresponding pet does not exist else they will just use the name of the pet. This saves time in other places
		if (pet1==null)
		{
			comp1 = " ";
		}
		else
		{
			comp1 = pet1.getName();
		}
		if (pet2==null)
		{
			comp2 = " ";
		}
		else
		{
			comp2 = pet2.getName();
		}
		if (pet3==null)
		{
			comp3 = " ";
		}
		else
		{
			comp3 = pet3.getName();
		}
		if (pet4==null)
		{
			comp4 = " ";
		}
		else
		{
			comp4 = pet4.getName();
		}
	}*/

	public void docNameInputValidation()
	{
		//Just go read the version directly above this. docNameInputValidation() functions identically and is much smaller
		if (doctor1==null)
		{
			dcomp1 = " ";
		}
		else
		{
			dcomp1 = doctor1.getName();
		}
		if (doctor2==null)
		{
			dcomp2 = " ";
		}
		else
		{
			dcomp2 = doctor2.getName();
		}
	}

	public void listDocs()
	{
		//This is our output for listing the doctors, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		printOut("Listing Doctors: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		if (doctor1!=null)
			printOut("Doctor1:\n Name: "+doctor1.getName()+" Specialisation: "+doctor1.getSpecialisation());
		else
			printOut("Doctor1:\n Name: undefined Specialisation: undefined ");
		if (doctor2!=null)
			printOut("Doctor2:\n Name: "+doctor2.getName()+" Specialisation: "+doctor2.getSpecialisation());
		else
			printOut("Doctor2:\n Name: undefined Specialisation: undefined ");
		printOut("---------------------------------------------------------------------------------------------------------");
	}

	/*public void listPets()
	{
		//This is our output for listing the pets, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		//Yes I copied that and changed one thing. Yes you know how this works, it's just slightly longer
		printOut("Listing Pets: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		if (pet1!=null)
			printOut("Pet1:\n Name: "+pet1.getName()+": Type: "+pet1.getType()+" Size: "+pet1.getSize()+" Weight: "+pet1.getWeight()+" Age: "+pet1.getAge()+" Doctor: "+pet1.getDoctor());
		else
			printOut("Pet1:\n Name: undefined Type: undefined Size: undefined Weight: undefined Age: undefined Doctor: undefined");
		if (pet2!=null)
			printOut("Pet2:\n Name: "+pet2.getName()+": Type: "+pet2.getType()+" Size: "+pet2.getSize()+" Weight: "+pet2.getWeight()+" Age: "+pet2.getAge()+" Doctor: "+pet2.getDoctor());
		else
			printOut("Pet2:\n Name: undefined Type: undefined Size: undefined Weight: undefined Age: undefined Doctor: undefined");
		if (pet3!=null)
			printOut("Pet3:\n Name: "+pet3.getName()+": Type: "+pet3.getType()+" Size: "+pet3.getSize()+" Weight: "+pet3.getWeight()+" Age: "+pet3.getAge()+" Doctor: "+pet3.getDoctor());
		else
			printOut("Pet3:\n Name: undefined Type: undefined Size: undefined Weight: undefined Age: undefined Doctor: undefined");
		if (pet4!=null)
			printOut("Pet4:\n Name: "+pet4.getName()+": Type: "+pet4.getType()+" Size: "+pet4.getSize()+" Weight: "+pet4.getWeight()+" Age: "+pet4.getAge()+" Doctor: "+pet4.getDoctor());
		else
			printOut("Pet4:\n Name: undefined Type: undefined Size: undefined Weight: undefined Age: undefined Doctor: undefined\n");
		printOut("---------------------------------------------------------------------------------------------------------");
	}

	public void listPetsDoc()
	{
		//This is our output for listing the pets, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		//Yes I copied that and changed one thing. Yes you know how this works, it's just slightly longer
		//This one also only outputs if the doctor that was input matches teh doctor of the pet
		listDocs();
		printOut("Which doctor's paitients would you like to check?");

		String docName = console.next();

		printOut("Listing Pets: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		if (pet1!=null)
		{
			if (pet1.getDoctor().equals(docName))
			{
				printOut("Pet1:\n Name: "+pet1.getName()+": Type: "+pet1.getType()+" Size: "+pet1.getSize()+" Weight: "+pet1.getWeight()+" Age: "+pet1.getAge()+" Doctor: "+pet1.getDoctor());
			}
		}

		if (pet2!=null)
		{
			if (pet2.getDoctor().equals(docName))
			{
				printOut("Pet2:\n Name: "+pet2.getName()+": Type: "+pet2.getType()+" Size: "+pet2.getSize()+" Weight: "+pet2.getWeight()+" Age: "+pet2.getAge()+" Doctor: "+pet2.getDoctor());
			}
		}

		if (pet3!=null)
		{
			if (pet2.getDoctor().equals(docName))
			{
				printOut("Pet3:\n Name: "+pet3.getName()+": Type: "+pet3.getType()+" Size: "+pet3.getSize()+" Weight: "+pet3.getWeight()+" Age: "+pet3.getAge()+" Doctor: "+pet3.getDoctor());
			}
		}

		if (pet4!=null)
			if (pet2.getDoctor().equals(docName))
			{
				printOut("Pet4:\n Name: "+pet4.getName()+": Type: "+pet4.getType()+" Size: "+pet4.getSize()+" Weight: "+pet4.getWeight()+" Age: "+pet4.getAge()+" Doctor: "+pet4.getDoctor());
			}

		printOut("---------------------------------------------------------------------------------------------------------");
	}

	public int removePet()
		{
			//This is a long method but it's simple. First we check which pet the user would like to delete, listing all of the pets to aid in the choice then we get user input and check again incase the user input the wrong number before returning the corresponding pet to a null value
			//It's probably worth mentioning that this subprogram will cancel itself if the user inputs anything other than what is expected from the user. This forces the user to reenter this section of the program but it is the simplest and easiest way to be certain they are deleting the correct pet
			listPets();
			printOut("Are you sure you would like to remove a pet?\nThis process cannot be undone if you would like remove a pet please enter the corresponding number eg( 1 for pet1, 3 for pet3 )\n\n");
			int numDelete = console.nextInt();
			if (numDelete == 1)
			{
				printOut("Are you sure you would like to delete "+pet1.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{
					pet1 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling pet removal");
					return -1;
				}
			}
			else if (numDelete == 2)
			{
				printOut("Are you sure you would like to delete "+pet2.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{
					pet2 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling pet removal");
					return -1;
				}
			}
			else if (numDelete == 3)
			{
				printOut("Are you sure you would like to delete "+pet3.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{
					pet3 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling pet removal");
					return -1;
				}
			}
			else if (numDelete == 4)
			{
				printOut("Are you sure you would like to delete "+pet4.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{
					pet4 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling pet removal");
					return -1;
				}
			}
			return -1;
		}*/

		public int removeDoctor()
		{
			//Same as the above, this is a bit of a trend with these functions, our doctors and pets inherit a lot of code from each other. They'd inhereit more but we can't use array. In other news the process is the same with one tiny addition that I'll detail ont he next line
			//So for the docotrs removal we also need to check each of the pets before we delete them and reset their assigned doctors. We check that they are not null here as making another input validation function only to be used once seems wasteful. Regardless after checking that
			//they exist we reset the specific pets set dotor to "no doctor assigned" before returning to the process described above in removePet().
			listDocs();
			printOut("Are you sure you would like to remove a doctor?\nThis process cannot be undone if you would like remove a doctor please enter the corresponding number eg( 1 for doc1, 2 for doc2 )\n\n");
			int numDelete = console.nextInt();
			if (numDelete == 1)
			{
				printOut("Are you sure you would like to delete "+doctor1.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{

					String nam = doctor1.getName();
					if (pet1!=null)
					{
						if (nam.equalsIgnoreCase(pet1.getDoctor()))
						{
							pet1.setDoctor("no doctor assigned");
						}
					}
					if (pet2!=null)
					{
						if (nam.equalsIgnoreCase(pet2.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}
					if (pet3!=null)
					{
						if (nam.equalsIgnoreCase(pet3.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}
					if (pet4!=null)
					{
						if (nam.equalsIgnoreCase(pet3.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}

					doctor1 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling doctor removal");
					return -1;
				}
			}
			else if (numDelete == 2)
			{
				printOut("Are you sure you would like to delete "+doctor2.getName()+" type y to delete type n to cancel");
				String yn = console.next();
				if (yn.equalsIgnoreCase("y"))
				{

					String nam = doctor2.getName();
					if (pet1!=null)
					{
						if (nam.equalsIgnoreCase(pet1.getDoctor()))
						{
							pet1.setDoctor("no doctor assigned");
						}
					}
					if (pet2!=null)
					{
						if (nam.equalsIgnoreCase(pet2.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}
					if (pet3!=null)
					{
						if (nam.equalsIgnoreCase(pet3.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}
					if (pet4!=null)
					{
						if (nam.equalsIgnoreCase(pet3.getDoctor()))
						{
							pet3.setDoctor("no doctor assigned");
						}
					}

					doctor2 = null;
					return 1;
				}
				else
				{
					printOut("Cancelling doctor removal");
					return -1;
				}
			}
			else
			{
				System.out.println("Cancelling doctor removal");
			}
			return -1;
		}
	}

		/*public void assignDoctor()
		{
			//Validating names once more Defining our main loop for this method and getting our users input you've seen this before. We do however use both a pet string and a doctor string namestr and docstr respectively
			docNameInputValidation();
			int loop = 1;
			printOut("Please enter the name of the pet whose doctor you would like to change");
			do
			{
				listPets();
				printNLN("Name of pet: ");
				String namestr = console.next();
				String docstr = null;

				//Stopping accidental infinite loops

				if (pet1==null&&pet2==null&&pet3==null&&pet4==null)
				{
					printOut("No pets are defined, you'll need a pet before a doctor can be assigned");
					loop = 0;
				}
				//checking for matches and ignoring the case of the text if we find a match we'll just into the second loop and check for a match with the doctors
				//once a match with the doctors is found we run setDoctor() and assign the name of the doctor to the selected pet objects doctor variable
				//Because this is the same everywhere below this and repeated a lot I will not be reapeating this and will ask you to refer to these lines
				else if (namestr.equalsIgnoreCase(pet1.getName()))
				{
					printOut("\nPlease enter the name of the doctor you would like to assign to "+pet1.getName());
					loop = -1;
					while (loop == -1)
					{
						listDocs();
						printNLN("Name of Doctor: ");
						docstr = console.next();
						if (docstr.equalsIgnoreCase(dcomp1))
						{
							printOut("\n"+doctor1.getName()+" has been assigned to "+pet1.getName());
							pet1.setDoctor(doctor1.getName());
							loop = 0;
						}
						else if (docstr.equalsIgnoreCase(dcomp2))
						{
							printOut("\n"+doctor2.getName()+" has been assigned to "+pet1.getName());
							pet1.setDoctor(doctor2.getName());
							loop = 0;
						}
						else
						{
							printOut("That is not the name of an existing doctor, please reenter the name of a doctor");
						}
					}
				}
				//PLease refer to the first else if
				else if (namestr.equalsIgnoreCase(pet2.getName()))
				{
					printOut("Please enter the name of the doctor you would like to assign to "+pet2.getName());
					loop = -1;
					while (loop == -1)
					{
						listDocs();
						printNLN("Name of Doctor: ");
						docstr = console.next();
						printOut(" ");
						if (docstr.equalsIgnoreCase(doctor1.getName()))
						{
								printOut(doctor1.getName()+" has been assigned to "+pet2.getName());
								pet2.setDoctor(doctor1.getName());
								loop = 0;
						}
						else if (docstr.equalsIgnoreCase(doctor2.getName()))
						{
							printOut(doctor2.getName()+" has been assigned to "+pet2.getName());
							pet2.setDoctor(doctor2.getName());
							loop = 0;
						}
						else
						{
							printOut("That is not the name of an existing doctor, please reenter the name of a doctor");
						}
					}
				}
				//PLease refer to the first else if
				else if (namestr.equalsIgnoreCase(pet3.getName()))
				{
					printOut("Please enter the name of the doctor you would like to assign to "+pet1.getName());
					loop = -1;
					while (loop == -1)
					{
						listDocs();
						printNLN("Name of Doctor: ");
						docstr = console.next();
						printOut(" ");
						if (docstr.equalsIgnoreCase(doctor1.getName()))
						{
							printOut(doctor1.getName()+" has been assigned to "+pet3.getName());
							pet3.setDoctor(doctor1.getName());
							loop = 0;
						}
						else if (docstr.equalsIgnoreCase(doctor2.getName()))
						{
							printOut(doctor2.getName()+" has been assigned to "+pet3.getName());
							pet3.setDoctor(doctor2.getName());
							loop = 0;
						}
						else
						{
							printOut("That is not the name of an existing doctor, please reenter the name of a doctor");
						}
					}
				}
				//PLease refer to the first else if
				else if (namestr.equalsIgnoreCase(pet4.getName()))
				{
					printOut("Please enter the name of the doctor you would like to assign to "+pet1.getName());
					loop = -1;
					while (loop == -1)
					{
						listDocs();
						printNLN("Name of Doctor: ");
						docstr = console.next();
						printOut(" ");
						if (docstr.equalsIgnoreCase(doctor1.getName()))
						{
							printOut(doctor1.getName()+" has been assigned to "+pet4.getName());
							pet4.setDoctor(doctor1.getName());
							loop = 0;
						}
						else if (docstr.equalsIgnoreCase(doctor2.getName()))
						{
							printOut(doctor2.getName()+" has been assigned to "+pet4.getName());
							pet4.setDoctor(doctor2.getName());
							loop = 0;
						}
						else
						{
							printOut("That is not the name of an existing doctor, please reenter the name of a doctor");
						}
					}
				}
				else
				{
					printOut("This is not the name of an existing pet, please reenter the name of a pet");
				}
			} while (loop == 1);
		}
}*/
