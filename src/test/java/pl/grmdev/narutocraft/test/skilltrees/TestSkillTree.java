package pl.grmdev.narutocraft.test.skilltrees;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.*;

import pl.grmdev.narutocraft.jutsu.*;
import pl.grmdev.narutocraft.jutsu.ninjutsu.Meisaigakure;
import pl.grmdev.narutocraft.skilltrees.*;

public class TestSkillTree {

	private SkillTree sTree;
	private SkillTreeEntry entry;

	@Before
	public void setupEntry() {
		entry = new SkillTreeEntry(2, 2, SkillTreeEnum.NONE, new Meisaigakure(), JutsuTier.A, 15,
				new ArrayList<SkillTreeEntry>());
	}

	@Test
	public void testConstructor() {
		sTree = new SkillTree(0);
		assertThat(sTree.getEntryMap()).isNotNull();
	}

	@Test
	public void testAddEntry() {
		sTree = new SkillTree(0);
		sTree.addEntry(entry);
		assertThat(sTree.getEntry(entry.getJutsu().getJutsuProps().getID())).isNotNull().isEqualTo(entry);
	}

	@Test
	public void testContains1() {
		sTree = new SkillTree(0);
		sTree.addEntry(entry);
		assertThat(sTree.contains(entry)).isTrue();
	}

	@Test
	public void testContains2() {
		sTree = new SkillTree(0);
		sTree.addEntry(entry);
		assertThat(sTree.contains(JutsuParams.MEISAIGAKURE.getJutsuID())).isTrue();
	}
}
