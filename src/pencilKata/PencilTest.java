package pencilKata;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencilTest {

	@Test //A pencil has a finite durability
	public void pencilInitialDurability() {
		Pencil pencil = new Pencil();
		assertEquals(40000, pencil.getDurability(), 0);

	}
	
	@Test //Requirement: A pencil can lose durability
	public void pencilWritesDurabilityLost() {
		Pencil pencil = new Pencil();
		pencil.write("food");
		assertEquals(39996,pencil.getDurability(),0);
	}
	
	@Test 
	public void pencilSpaceNoDurabilityLost() {
		Pencil pencil = new Pencil();
		pencil.write("cool story");
		assertEquals(39991,pencil.getDurability(),0);
	}
	
	
	@Test //Requirement: A pencil can write
	public void pencilWrites() {
		Pencil pencil = new Pencil();
		pencil.write("Furthermore, I am of the opinion Charthage should be destroyed.");
		assertEquals("Furthermore, I am of the opinion Charthage should be destroyed.", pencil.paper.toString().substring(1,pencil.paper.toString().length()-1));
	}
	
	@Test //Requirement: Capital Letters degrade pencil durability faster than lower case
	public void pencilWritesCapitalsDegradesFaster() {
		Pencil pencil = new Pencil();
		pencil.write("Quaint");
		assertEquals(39993,pencil.getDurability(),0);
	}
	
	@Test 
	public void pencilAppendsWritingToExistingText() {
		Pencil pencil = new Pencil();
		pencil.paper.add("This is the wrong");
		pencil.write("approach");
		assertEquals("This is the wrong approach",pencil.getWriting());
	}
	
	
	@Test
	public void pencilIsDullWritesSpaces() {
		Pencil pencil = new Pencil();
		pencil.setDurability(-1);
		pencil.write("the");
		assertEquals("   ",pencil.getWriting());
	}
}
