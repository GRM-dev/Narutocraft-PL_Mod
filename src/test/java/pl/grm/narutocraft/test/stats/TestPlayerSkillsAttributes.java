package pl.grm.narutocraft.test.stats;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.grm.narutocraft.stats.Attributes;
import pl.grm.narutocraft.stats.NinjaAtrributes;

public class TestPlayerSkillsAttributes {
	NinjaAtrributes	att;
	
	@Test
	public void testCreatingAndFillingMapWithAttrbts() {
		att = new NinjaAtrributes();
		assertFalse("No Attributes map declared!", att.getAttValues() == null);
		assertFalse("Empty map!", att.getAttValues().isEmpty());
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
