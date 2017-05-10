
public class Animal {
String name;
String species;

	public Animal(String name, String species)
	{
		this.name = name;
		this.species = species;
	}
	
	////////getters and setters////////
	public String getName()
	{
		return this.name;
	}
	public void setName()
	{
		this.name = name;
	}
	public String getSpecies()
	{
		return this.species;
	}
	public void setSpecies()
	{
		this.species = species; 
	}
	public String toString()
	{
		return "Name: " + this.name + " Species: " + this.species;
	}
}
