import java.util.ArrayList;

public class Person {
String name;
String dob;
String occupation;
int salary;
ArrayList<Animal> pets = new ArrayList<Animal>();

	public Person(String name, String dob, String occupation, int salary)
	{
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	}
	
	
	//////getters and setters///////
	public String getName()
	{
		return this.name;
	}
	public void setName()
	{
		this.name = name;
	}
	public String getDob()
	{
		return this.dob;
	}
	public void setDob()
	{
		this.dob = dob;
	}
	public String getOccupation()
	{
		return this.occupation;
	}
	public void setOccupation()
	{
		this.occupation = occupation; 
	}
	
	public int getSalary()
	{
		return this.salary;
	}
	public void setSalary()
	{
		this.salary = salary;
	}

	
	public String getPetName()
	{
		String petNames = "";
		for(Animal a : pets)
		{
			petNames += " " +  a.getName();
		}
		return petNames;
	}
//	public String getPetSpecies()
//	{
//		ArrayList<Animal> petSpecies = new ArrayList<Animal>();
//		int i = 0;
//		for(Animal a : pets)
//		{
//			petSpecies = a.getSpecies[i];
//			i++
//		}
//		return petSpecies;
//	}
	public void addPet(Animal a)
	{
		pets.add(a);
	}
	
	public String toString()
	{
		return "Name: " + this.name + " D.O.B: " + this.dob + " Occupation: " + this.occupation + " Salary: £" + this.salary;
	}
}
