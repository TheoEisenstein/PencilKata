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
	

}
