package pl.grm.narutocraft.skilltrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.Test;

import pl.grm.narutocraft.jutsu.JutsuEnum;

public class TestSkillTreeManager {
	SkillTreeManager	skillsManager;
	JutsuEnum			jutsu	= JutsuEnum.RASENGAN;
	
	/**
	 * fail if typeList=null
	 */
	@Test
	public void testInstance() {
		skillsManager = SkillTreeManager.instance;
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
		skillsManager = SkillTreeManager.instance;
		skillsManager.init();
		if (skillsManager.getEntry(jutsu) != null) {
			SkillTreeEntry entry = skillsManager.getEntry(JutsuEnum.RASENGAN);
			if (!entry.getJutsu().getJutsuProps().equals(jutsu.getJutsu().getJutsuProps())) {
				fail("Not equal Jutsu: " + entry.getJutsu().getJutsuProps().getUnlocalizedName()
						+ ". Should be: " + jutsu.getJutsuName());
			}
		} else {
			fail("Entry empty!");
		}
	}
	
	@Test
	public void testLoadPrerequisites() {
		skillsManager = SkillTreeManager.instance;
		skillsManager.init();
		skillsManager.selectTreefromTreeMap(SkillTreeEnum.NINJUTSU);
		SkillTree tree = skillsManager.getSelectedTree();
		// if(tree.containsKey())
	}
	
	@Test
	public void testLockAllEntries() {
		
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