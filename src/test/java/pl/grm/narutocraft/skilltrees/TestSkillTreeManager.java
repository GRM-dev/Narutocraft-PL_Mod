package pl.grm.narutocraft.skilltrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.Test;

public class TestSkillTreeManager {
	SkillTreeManager	skillsManager;
	
	/**
	 * fail if typeList=null
	 */
	@Test
	public void testInstance() {
		SkillTreeManager skillsManager = SkillTreeManager.instance;
		assertFalse(skillsManager == null);
	}
	
	@Test
	public void testInitCall() {
		skillsManager = SkillTreeManager.instance;
		try {
			skillsManager.init();
		}
		catch (InvalidParameterException e) {
			assertTrue(e.getMessage().contains("Unable to locate one or more prerequisite"));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + " with " + e.getStackTrace());
		}
	}
	
	@Test
	public void testRegisterEntry() {
		
	}
	
	@Test
	public void testLoadPrerequisites() {
		
	}
	
	@Test
	public void testLockAllJutsus() {
		
	}
	
	@Test
	public void testGetterLockedJutsusID() {
		
	}
	
	@Test
	public void testGetterJutsuTreeEntry() {
		
	}
	
	@Test
	public void testTreeGetter() {
		
	}
}