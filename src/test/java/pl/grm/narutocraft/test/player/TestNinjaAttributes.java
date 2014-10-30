package pl.grm.narutocraft.test.player;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import org.junit.Test;

import pl.grm.narutocraft.player.Attributes;
import pl.grm.narutocraft.player.NinjaAtrributes;

public class TestNinjaAttributes {
	NinjaAtrributes	att;
	
	@Test
	public void testCreatingAndFillingMapWithAttrbts() {
		att = new NinjaAtrributes();
		assertThat(att.getAttValues().isEmpty(), is(false));
	}
	
	@Test
	public void testWritoToNBT() {
		String name = null;
		boolean found = false;
		att = new NinjaAtrributes();
		NBTTagCompound compound = new NBTTagCompound();
		att.writoToNBT(compound);
		NBTTagList tagList = compound.getTagList("NinjaAttributes", Constants.NBT.TAG_COMPOUND);
		NBTTagCompound n = tagList.getCompoundTagAt(1);
		assertThat(n, notNullValue());
		
		for (Attributes att : Attributes.values()) {
			name = att.getSName();
			if (n.hasKey(name)) {
				found = true;
			}
		}
		assertThat(found, is(true));
	}
	
	@Test
	public void testReadFromNBT() {
		String name = null;
		att = new NinjaAtrributes();
		int value = att.getAgility();
		NBTTagCompound compound = new NBTTagCompound();
		att.writoToNBT(compound);
		att.setAgility(5);
		assertThat(att.getAgility(), is(5));
		att.readFromNBT(compound);
		assertThat(att.getAgility(), is(value));
	}
	
	@Test
	public void testSettersAndGetters() {
		att = new NinjaAtrributes();
		int v1 = 5, v2 = 8;
		att.setStrength(v1);
		v2 = att.getAttValues().get(Attributes.STRENGHT.getSName()).intValue();
		assertThat(v1, is(v2));
		v2 = att.getStrength();
		assertThat(v1, is(v2));
	}
	
	@Test
	public void testLevelUP() {
		// TODO implementation
	}
}
