package pencilKata;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencilTest {

	@Test
	public void pencilInitialDurability() {
		Pencil pencil = new Pencil();
		assertEquals(40000, pencil.getDurability(), 0);

	}

}
