package pl.grmdev.narutocraft.test.jutsu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.*;

import net.minecraft.nbt.*;
import pl.grmdev.narutocraft.handlers.JutsuManager;
import pl.grmdev.narutocraft.jutsu.*;
import pl.grmdev.narutocraft.player.ExtendedProperties;

public class TestJutsuManager {

	private JutsuManager jutsuM;

	@Before
	public final void testJutsuManager() {
		jutsuM = new JutsuManager();
		assertThat(jutsuM).isNotNull();
		JutsuManager.regJutsusList();
	}

	@Test
	public final void testRegJutsusList() {
		assertThat(ExtendedProperties.jutsuList).isNotNull();
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
		Map<Integer, IJutsu> list = ExtendedProperties.jutsuList;
		int id = JutsuParams.ASAKUJAKU.getJutsuID();
		if (!list.containsKey(id)) {
			list.put(id, JutsuParams.ASAKUJAKU.getJutsu());
		}
		IJutsu jutsu = jutsuM.getJutsu(id);
		assertThat(jutsu).isNotNull();
	}

	@Test
	public final void testGetJutsuEntryByName() {
		IJutsu jutsu = jutsuM.getJutsu(JutsuParams.CHAKURANOMESU.getName());
		assertThat(jutsu).isNotNull();
	}
}
