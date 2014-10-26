package pl.grm.narutocraft.test.stats;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.grm.narutocraft.player.Attributes;
import pl.grm.narutocraft.player.NinjaAtrributes;

public class TestNinjaAttributes {
	NinjaAtrributes	att;
	
	@Test
	public void testCreatingAndFillingMapWithAttrbts() {
		att = new NinjaAtrributes();
		assertFalse("No Attributes map declared!", att.getAttValues() == null);
		assertThat(att.getAttValues().isEmpty(), is(false));
	}
	
	@Test
	public void testWritoToNBT() {
		// fail("Not yet implemented");
	}
	
	@Test
	public void testReadFromNBT() {
		// fail("Not yet implemented");
	}
	
	@Test
	public void testSettersAndGetters() {
		att = new NinjaAtrributes();
		int v1 = 5, v2 = 8;
		att.setStrength(v1);
		v2 = att.getAttValues().get(Attributes.STRENGHT.getSName()).intValue();
		assertTrue("#1 Not equal! Should be: " + v1 + " is: " + v2, v1 == v2);
		v2 = att.getStrength();
		assertTrue("#2 Not equal! Should be: " + v1 + " is: " + v2, v1 == v2);
	}
	
	@Test
	public void testLevelUP() {
		// TODO implementation
	}
}
