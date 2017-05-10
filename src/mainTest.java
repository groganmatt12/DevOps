import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class mainTest {

	@Parameters
	public static Collection<Object[]> data()
	{
	//	return Arrays.asList(new Object[][] { {0,"Gareth,20/01/1980,Cat Sitter,£12000,"}, {1,",Devdetta,27/01/1994,Smash Player,£11000,"}, {2, ",Elliott,4/4/1994,Trainer,£78000,"} });
		return Arrays.asList(new Object[] [] { {0, ",Jeff,Dog,"}, {1, ",Bob,Cat,"}, {2, ",Cosmo,Tortoise,"}, {3, ",Sir Meowsalot,Dolphin,"}, {4, ",Shelly,T-Rex,"}});
	}
	
	@Parameter public int arrayPosition;		//@Parameter(0) will reference the FIRST thing in the curly brace above ( {0,....} )
	@Parameter(1) public String arrayPerson;	//@parameter(1) will reference the SECOND thing in the curly brace above ( {..., "Gareth,20/01etc} )
	
	
	//if there were more parameters etc. @Parameter(2,3,4....) it would reference the different things in the object array: Object[] [])
	
	
	
	@Test
	public void test() {
		//what we should get//
		//Gareth,20/01/1980,Cat Sitter,£12000,%,Devdetta,27/01/1994,Smash Player,£11000,%,Elliott,4/4/1994,Trainer,£78000,&,Jeff,Dog,%,Bob,Cat,%,Cosmo,Tortoise,%,Sir Meowsalot,Dolphin,%,Shelly,T-Rex,//
		
		
		String fileInfo = Main.readFile("ExData.txt");
		String peopleAndAnimals[] = Main.parseFile("&", fileInfo);
		String animal[] = Main.parseFile("%", peopleAndAnimals[1]);
		
		assertEquals(arrayPerson, animal[arrayPosition]);
	}

}
