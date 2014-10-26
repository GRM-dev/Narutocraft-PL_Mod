package pl.grm.narutocraft.test.skilltrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.jutsu.JutsuTier;
import pl.grm.narutocraft.skilltrees.SkillTreeEntry;
import pl.grm.narutocraft.skilltrees.SkillTreeEnum;

public class TestSkillTreeEntry {
	JutsuManager	jM	= new JutsuManager();
	
	@Test
	public void testSTEntry() {
		int x = 5, y = 5;
		SkillTreeEnum sTree = SkillTreeEnum.NONE;
		IJutsu jutsu = JutsuEnum.ODAMARASENGAN.getJutsu();
		JutsuTier tier = JutsuTier.D;
		int points = 10;
		ArrayList<SkillTreeEntry> req = new ArrayList<SkillTreeEntry>();
		req.add(new SkillTreeEntry(x, y, sTree, jutsu, tier, points, req));
		SkillTreeEntry entry = null;
		try {
			entry = new SkillTreeEntry(x, y, sTree, jutsu, tier, points, req);
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
		SkillTreeEntry[] reqs = entry.getPrerequisites();
		assertFalse("reqs empty?", reqs.length == 0);
		assertFalse("jutsu null?", entry.getReqJutsu() == null);
	}
}
