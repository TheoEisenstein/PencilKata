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
		assertEquals("Furthermore, I am of the opinion Charthage should be destroyed.", pencil.getWriting());
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
	
	@Test
	public void pencilBecomesDullWhiteWriting() {
		Pencil pencil = new Pencil();
		pencil.setDurability(4);
		pencil.write("famished");
		assertEquals("fami    ",pencil.getWriting());
	}
	
	@Test
	public void pencilNewLineNoDegredation() {
		Pencil pencil = new Pencil();
		pencil.setDurability(2);
		pencil.write("x\n");
		assertEquals(1,pencil.getDurability(),0);
	}
	
	@Test
	public void pencilSharpenable() {
		Pencil pencil = new Pencil();
		pencil.setDurability(2);
		pencil.sharpen();
		assertEquals(40000, pencil.getDurability(),0);
	}
	
	@Test
	public void pencilSharpenedLosesLength() {
		Pencil pencil = new Pencil();
		pencil.sharpen();
		assertEquals(3, pencil.getLength(),0);
	}
	
	@Test
	public void pencilUnsharpenable() {
		Pencil pencil = new Pencil();
		pencil.setDurability(5);
		pencil.setLength(0);
		pencil.sharpen();
		assertEquals(5, pencil.getDurability(),0);
	}
	//Eraser Tests
	@Test
	public void eraseTargetWord() {
		Pencil pencil = new Pencil();
		pencil.write("The King was crowned King on Tuesday.");
		pencil.eraseTarget("King");
		assertEquals("The King was crowned      on Tuesday.", pencil.getWriting());
	}
	
	@Test
	public void eraseTargetWordTwice() {
		Pencil pencil = new Pencil();
		pencil.write("The King was crowned King on Tuesday.");
		pencil.eraseTarget("King");
		pencil.eraseTarget("King");
		assertEquals("The      was crowned      on Tuesday.", pencil.getWriting());
	}
	
	@Test
	public void eraserDegredation() {
		Pencil pencil = new Pencil();
		pencil.write("Nice!");
		pencil.erase(2);
		assertEquals(48, pencil.getEraserDurability(),0);
	}
	
	@Test
	public void eraseSpecifiedNumberOfCharacters() {
		Pencil pencil = new Pencil();
		pencil.write("Nice!");
		pencil.erase(2);
		assertEquals("Nic", pencil.getWriting());
	}
	
	@Test
	public void eraseWithNoDurability() {
		Pencil pencil = new Pencil();
		pencil.write("Bad!");
		pencil.setEraserDurability(0);
		pencil.erase(2);
		assertEquals("Bad!", pencil.getWriting());
	}
}
