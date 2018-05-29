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
	public Doctor[] doctorList;// = new Doctor[1];
	//Player[] thePlayers = new Player[playerCount + 1];

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
				printOut(""+doctorList[0].getName());
				console.next();
			}
			runcounter = 1;
			opt = chooseOption();
			switch (opt)
			{
				case 1:
					addDoctor(doctorList);
					break;
				case 2:
					//removeDoctor();
					break;
				case 3:
					listDocs(doctorList);
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
		printOut("If you would like to list all doctors please input --------------------- 3\n");
	/*printOut("--------------------------------------------------------------------------\n");
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

	//This also exists so that I have to type slig htly less
	public void printNLN(String string)
	{
		System.out.print(string);
	}

	public void addDoctor(Doctor[] doctorList)
	{
		if(doctorList.length)
		{
			doctorList = Arrays.copyOf(doctorList, doctorList.length+1);
			doctorList[doctorList.length-1] = new Doctor();
			printOut(doctorList[0].getName());
		}
		else
		{
			doctorList[doctorList.length-1] = new Doctor();
			printOut(doctorList[0].getName());
		}
	}


	public void listDocs(Doctor[] doctorList)
	{
		//This is our output for listing the doctors, it will output defualt values if it doesn't exist and the proper values if it does. The strings are formatted in the same was as the chooseOption() method
		printOut("Listing Doctors: \n");
		printOut("---------------------------------------------------------------------------------------------------------\n");
		for(int i = 0; i < doctorList.length; i++)
		{
			printOut("Doctor "+i+":\n Name: "+doctorList[i].getName()+" Specialisation: "+doctorList[i].getSpecialisation());
		}
		printOut("---------------------------------------------------------------------------------------------------------");
	}


}
