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
		int durabilityLost = pencil.getWriting().length();
		assertEquals(39996,pencil.getDurability() - durabilityLost ,0);
	}
	
	@Test //Requirement: A pencil can write
	public void pencilWrites() {
		Pencil pencil = new Pencil();
		pencil.write("Furthermore, I am of the opinion Charthage should be destroyed.");
		assertEquals("Furthermore, I am of the opinion Charthage should be destroyed.", pencil.paper.toString().substring(1,pencil.paper.toString().length()-1));
	}
	
}
