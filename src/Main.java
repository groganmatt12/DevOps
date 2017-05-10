import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//Read data from a file, parse the data into objects, add relationships between the two objects, then perform some calculations on said objects.
	public static void main(String[] args) 
	{
		
		String fileInfo = readFile("ExData.txt");
		parseFile("&", fileInfo);
		String peopleAndAnimals[] = parseFile("&", fileInfo);
		String people[] = parseFile("%", peopleAndAnimals[0]);
		String animals[] = parseFile("%", peopleAndAnimals[1]);
		
		String pDetails[] = new String[4];
		ArrayList<Person> peopleList = new ArrayList<Person>();
		
		for(int i = 0; i <people.length; i++)
		{
			pDetails = parseFile(",", people[i]);
			pDetails[4] = pDetails[4].replace("£", "");
			int pSalary = Integer.parseInt(pDetails[4]);
			Person p = new Person(pDetails[1], pDetails[2], pDetails[3], pSalary);
			peopleList.add(p);
		}
		
		String aDetails[] = new String[5];
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		for(int i = 0; i < animals.length; i++)
		{
			aDetails = parseFile(",", animals[i]);
			Animal a = new Animal(aDetails[1], aDetails[2]);
			animalList.add(a);
		}
		getPets(peopleList, animalList);
		calcAvgEarning(peopleList, animalList);
				
	}
	
	//assign elliot a cat and a tortoise//
	//assign gareth a cat and a dolphin//
	//assign devetta no pets//
	
	public static void getPets(ArrayList<Person> peopleList, ArrayList<Animal> animalList)
	{
		for(Person p : peopleList)
		{
			if(p.name.equals("Elliott"))
			{
				for(Animal a : animalList)
				{
				    
					if(a.species.equals("Tortoise"))
					{
						p.addPet(a);
					}
					else if(a.species.equals("Cat"))
					{
						p.addPet(a);
					}
				}
				System.out.println(p.name + " has the following pets: " + p.getPetName());
			}
			if(p.name.equals("Gareth"))
			{
				for(Animal a : animalList)
				{
					if(a.species.equals("Cat"))
					{
						p.addPet(a);
					}
					else if(a.species.equals("Dolphin"))
					{
						p.addPet(a);
					}
				}
				System.out.println(p.name + " has the following pets: " + p.getPetName());
			}
			if(p.name.equals("Devdetta"))
			{
				System.out.println("Dev has no pets!");
			}
	
		}
		
	}
	
	public static void calcAvgEarning(ArrayList<Person> peopleList, ArrayList<Animal> animalList)
	{
		for(Animal a : animalList)
		{
			if(a.getSpecies().equals("Cat"))
			{ 		
				int i = 0;
				int petOwnerSalary = 0;
				int petOwnerAvgSalary = 0;
				for(Person p : peopleList)
				{
					for(Animal a1 : p.pets)
					{
						if(a1.getSpecies().equals("Cat"))
						{
							petOwnerSalary += p.getSalary();
							System.out.println(petOwnerSalary);
							i++;
						}
					}
				}
				petOwnerAvgSalary = petOwnerSalary / i; 
				System.out.println(petOwnerAvgSalary + " is the average salary of a Cat owner!");
				i = 0;
				petOwnerSalary = 0;
				petOwnerAvgSalary = 0;
			}
//			else if(a.getSpecies().equals("Dog"))
//			{ 		
//				int i = 0;
//				int petOwnerSalary = 0;
//				int petOwnerAvgSalary = 0;
//				for(Person p : peopleList)
//				{
//					for(Animal a1 : p.pets)
//					{
//						if(a1.getSpecies().equals("Dog"))
//						{
//							petOwnerSalary += p.getSalary();
//							System.out.println(petOwnerSalary);
//							i++;
//						}
//					}
//				}
//				petOwnerAvgSalary = petOwnerSalary / i; 
//				System.out.println(petOwnerAvgSalary + " is the average salary of a Dog owner!");
//				i = 0;
//				petOwnerSalary = 0;
//				petOwnerAvgSalary = 0;
//			}		
		}
	}
		//given a species, return the average salaray that their owners earn//
		
	//given a species, return all occupations that their owners' have//
	//given an occupation, return all the species that people with that occupation have//
	
	
		
	public static String readFile(String fileName)
	{
		String fileInfo = ",";
		File x = new File(fileName);
		try
		{
			Scanner sc = new Scanner(x);
			while(sc.hasNext())
			{
				fileInfo += (sc.nextLine() + "");
				fileInfo += ",";
			}
			sc.close();
			return fileInfo;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "System Alert!";
		}	
	}
	
	
	public static String[] parseFile(String delim, String fileInfo) //input &, input %, input ,, 
	{
		String returnArray[] = fileInfo.split(delim);
		return returnArray;
	}	

}
