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
	Scanner console = new Scanner(System.in);

	public Pet(String pet1, String pet2, String pet3, String pet4)
	{
		setName(pet1, pet2, pet3, pet4);
		setType();
		setSize();
		setWeight();
		setAge();
		setDoctor("no doctor assigned");
	}
	//We set the types and with the use of our loop after asking for input from the user we ensure that the input is either dog or cat. The case of the word is ignored but what matters is that it is either DOG or CAT
	public void setType()
	{
		System.out.println("Please enter the type of pet to be treated, this type must be cat or dog");
		int loop = 1;
		do {
			String type = console.next();
			this.type = type;

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

	// a simple return method. Is self explanatory
	public String getSize()
	{
		return size;
	}

	//We use the initial version of our input validation function because I forgot to update it to the new version and it still works just fine as it is. we're ensuring that all our strings ignore case and that pets cannot share namestr
	//If they do not obey the program it will loop back tot he start and force a unique name for the pet to be entered
	public void setName(String pet1, String pet2, String pet3, String pet4)
	{
		System.out.println("Please input the pets name");

		String namestr;
		int loop = 1;
		String compName;
		String compName1;
		String compName2;
		String compName3;
		String compName4;
		do
		{
			namestr = console.nextLine();
			compName = namestr.toUpperCase();
			compName1 = pet1.toUpperCase();
			compName2 = pet2.toUpperCase();
			compName3 = pet3.toUpperCase();
			compName4 = pet4.toUpperCase();

			if (compName.equalsIgnoreCase(compName1) || compName.equalsIgnoreCase(compName2) || compName.equalsIgnoreCase(compName3) || compName.equalsIgnoreCase(compName4) )
			{
				System.out.println("Two pets cannot share the same name, please reenter the name of the pet");
			}
			else
			{
				loop = -1;
			}
		} while (loop == 1);
		name = namestr;
	}

	// a simple return method. Is self explanatory
	public String getName()
	{
		return name;
	}

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

	// a simple return method. Is self explanatory
	public double getWeight()
	{
		return weight;
	}

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

	//Analyses the pet based on the requirements in the assesment guidelines. Just checks for weight, type and size and then returns if the pet is overweight or not, this takes no player input and was thus much easier to inplementssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssadasd
	public void analysePet()
	{
		System.out.print(name+": \n ");
		System.out.print("Name: "+name+": Type: "+type+" Size: "+size+" Weight: "+weight+" Age: "+age+" Doctor: "+doctor+"\n ");
		if (size.equalsIgnoreCase("small"))
		{
			if (weight>4&&type.equalsIgnoreCase("cat") || weight>6&&type.equalsIgnoreCase("dog"))
			{
				System.out.println(name+" is overweight, this system recomends more exercise");
			}
		}
		else if (size.equalsIgnoreCase("medium"))
		{
			if (weight>6&&type.equalsIgnoreCase("cat") || weight>9&&type.equalsIgnoreCase("dog"))
			{
				System.out.println(name+" is overweight, this system recomends more exercise");
			}
		}
		else if (size.equalsIgnoreCase("Large"))
		{
			if (weight>8&&type.equalsIgnoreCase("cat") || weight>12&&type.equalsIgnoreCase("dog"))
			{
				System.out.println(name+" is overweight, this system recomends more exercise");
			}
		}
		else
		{
			System.out.println(name+" is at a healthy weight.");
		}
	}

	// a simple return method. Is self explanatory
	public int getAge()
	{
		return age;
	}

	//This function is set up the way it is so that it can be run from functions within the clinic class. It is almost never run as a pet specific thing so it works better this way.
	public void setDoctor(String docNam)
	{
		doctor = docNam;
	}

	// a simple return method. Is self explanatory
	public String getDoctor()
	{
		return doctor;
	}
}
