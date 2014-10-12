package pl.grm.narutocraft.skilltrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;
import java.util.Map;

import org.junit.Test;

public class TestSkillTreeManager {
	SkillTreeManager	skillsManager;
	
	/**
	 * fail if typeList=null
	 */
	@Test
	public void testInstance() {
		Map<Integer, SkillTree> typeList = SkillTreeManager.instance
				.getSkillPointTypeList();
		assertFalse(typeList == null);
	}
	
	@Test
	public void testInitCall() {
		skillsManager = SkillTreeManager.instance;
		try {
			skillsManager.init();
		}
		catch (InvalidParameterException e) {
			assertTrue(e.getMessage().contains(
					"Unable to locate one or more prerequisite"));
		}
		catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testRegisterEntry() {
		
	}
}