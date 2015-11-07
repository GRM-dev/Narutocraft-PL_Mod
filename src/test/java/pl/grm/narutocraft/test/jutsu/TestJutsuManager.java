package pl.grm.narutocraft.test.jutsu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.*;

import net.minecraft.nbt.*;
import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.JutsuParams;
import pl.grm.narutocraft.player.ExtendedProperties;
import pl.grm.narutocraft.skilltrees.SkillTreeEntry;

public class TestJutsuManager {

	private JutsuManager jutsuM;

	@Before
	public final void testJutsuManager() {
		jutsuM = new JutsuManager();
		assertThat(jutsuM).isNotNull();
		assertThat(ExtendedProperties.jutsuList).isNotNull();
	}

	@Test
	public final void testRegJutsusList() {
		JutsuManager.regJutsusList();
		assertThat(ExtendedProperties.jutsuList).isNotEmpty();
	}

	@Test
	public final void testWriteToNBT() {
		NBTTagCompound compound = new NBTTagCompound();
		jutsuM.writeToNBT(compound);
		NBTBase tag = compound.getTag("JutsuManager");
		assertThat(tag).isNotNull();
	}

	@Test
	public final void testReadFromNBT() {
		NBTTagCompound compound = new NBTTagCompound();
		jutsuM.readFromNBT(compound);
	}

	@Test
	public final void testIterateOverJutsus() {
		jutsuM.iterateOverJutsus();
	}

	@Test
	public final void testLoadJutsuEffectsOnPlayer() {
		jutsuM.loadJutsuEffectsOnPlayer();
	}

	@Test
	public final void testGetJutsuEntryById() {
		SkillTreeEntry jutsu = jutsuM.getJutsuEntry(JutsuParams.ASAKUJAKU.getJutsuID());
		assertThat(jutsu).isNotNull();
	}

	@Test
	public final void testGetJutsuEntryByName() {
		SkillTreeEntry jutsu = jutsuM.getJutsuEntry(JutsuParams.CHAKURANOMESU.getName());
		assertThat(jutsu).isNotNull();
	}
}
