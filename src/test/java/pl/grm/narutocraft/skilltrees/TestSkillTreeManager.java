package pl.grm.narutocraft.skilltrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.Test;

import pl.grm.narutocraft.jutsu.JutsuEnum;

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
			assertTrue(e.getMessage().contains(
					"Unable to locate one or more prerequisite"));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + " with " + e.getStackTrace());
		}
	}
	
	@Test
	public void testRegisterEntry() {
		JutsuEnum jutsu = JutsuEnum.RASENGAN;
		skillsManager = SkillTreeManager.instance;
		skillsManager.init();
		if (skillsManager.getEntry(jutsu) != null) {
			SkillTreeEntry entry = skillsManager.getEntry(JutsuEnum.RASENGAN);
			if (entry.getJutsu() != jutsu.getJutsu()) {
				fail("Not equal Jutsu: "
						+ entry.getJutsu().getJutsuProps().getUnlocalizedName()
						+ "and should be: " + jutsu.getJutsuName());
			}
		} else {
			fail("Entry empty!");
		}
	}
	
	@Test
	public void testLoadPrerequisites() {
		skillsManager = SkillTreeManager.instance;
		skillsManager.init();
		SkillTree tree = skillsManager.getTreefromTreeMap(SkillTreeEnum.NINJUTSU);
		// if(tree.containsKey())
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