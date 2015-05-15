package pl.grm.narutocraft.player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

/**
 * NinjaAtrributes use {@link Attributes} such as strength, dexterity, etc.
 */
public class NinjaAttributes {

	private static final String NBTCompoundName = "NinjaAttributes";
	private Map<String, Integer> attributes;

	public NinjaAttributes() {
		this.attributes = new HashMap<String, Integer>();
		for (Attributes att : Attributes.values()) {
			this.attributes.put(att.getSName(), att.getBaseValue());
		}
	}

	public void writoToNBT(NBTTagCompound properties) {
		NBTTagList tagList = new NBTTagList();
		Iterator<Entry<String, Integer>> iterator = attributes.entrySet().iterator();
		while (iterator.hasNext()) {
			NBTTagCompound tag = new NBTTagCompound();
			Entry<String, Integer> entry = iterator.next();
			String name = entry.getKey();
			Integer value = entry.getValue();
			tag.setInteger(name, value);
			tagList.appendTag(tag);
		}
		properties.setTag(NBTCompoundName, tagList);
	}

	public void readFromNBT(NBTTagCompound properties) {
		NBTTagList tagList = properties.getTagList(NBTCompoundName, Constants.NBT.TAG_COMPOUND);
		int amount = tagList.tagCount();
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				NBTTagCompound tag = tagList.getCompoundTagAt(i);
				if (!tag.hasNoTags()) {
					for (Attributes att : Attributes.values()) {
						String name = att.getSName();
						if (tag.hasKey(name)) {
							int value = tag.getInteger(name);
							attributes.put(name, value);
						}
					}
				}
			}
		}
	}

	// For Networking
	public String[] getInfo() {
		String[] info = new String[attributes.size()];
		Iterator<Entry<String, Integer>> iterator = attributes.entrySet().iterator();
		int index = 0;
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			String name = entry.getKey();
			Integer value = entry.getValue();
			info[index] = name + ":" + value;
			index++;
		}
		return info;
	}

	// For Networking
	public void setInfo(String[] info) {
		String[] splitInfo;
		for (String i : info) {
			splitInfo = i.split(":");
			attributes.put(splitInfo[0], Integer.parseInt(splitInfo[1]));
		}
	}

	/** Returns a Map of attributes values */
	public Map<String, Integer> getAttValues() {
		return attributes;
	}

	public int getStrength() {
		Integer param = attributes.get(Attributes.STRENGTH.getSName());
		return param;
	}

	public int getAgility() {
		Integer param = attributes.get(Attributes.AGILITY.getSName());
		return param;
	}

	public int getDexterity() {
		Integer param = attributes.get(Attributes.DEXTERITY.getSName());
		return param;
	}

	public int getResistance() {
		Integer param = attributes.get(Attributes.RESISTANCE.getSName());
		return param;
	}

	// TODO as its setters
	public int getElementPowerMod() {
		Integer param = attributes.get(Attributes.STRENGTH.getSName());
		return param;
	}

	public int getMaxChakraMod() {
		Integer param = attributes.get(Attributes.STRENGTH.getSName());
		return param;
	}

	public int getChakraRegenMod() {
		Integer param = attributes.get(Attributes.STRENGTH.getSName());
		return param;
	}

	public int getStamina() {
		Integer param = attributes.get(Attributes.STAMINA.getSName());
		return param;
	}

	public int getWillPower() {
		Integer param = attributes.get(Attributes.WILLPOWER.getSName());
		return param;
	}

	public int getLife() {
		Integer param = attributes.get(Attributes.LIFE.getSName());
		return param;
	}

	public int getThrow() {
		Integer param = attributes.get(Attributes.THROW.getSName());
		return param;
	}

	public int getAlertness() {
		Integer param = attributes.get(Attributes.ALERTNESS.getSName());
		return param;
	}

	public int getCharisma() {
		Integer param = attributes.get(Attributes.CHARISMA.getSName());
		return param;
	}

	public int getLuck() {
		Integer param = attributes.get(Attributes.LUCK.getSName());
		return param;
	}

	public void setStrength(int v) {
		attributes.put(Attributes.STRENGTH.getSName(), v);
	}

	public void setAgility(int v) {
		attributes.put(Attributes.AGILITY.getSName(), v);
	}

	public void setDexterity(int v) {
		attributes.put(Attributes.DEXTERITY.getSName(), v);
	}

	public void setResistance(int v) {
		attributes.put(Attributes.RESISTANCE.getSName(), v);
	}

	// TODO move to stats?
	public void setElementPowerMod(int v) {
		attributes.put(Attributes.STRENGTH.getSName(), v);
	}

	public void setMaxChakraMod(int v) {
		attributes.put(Attributes.STRENGTH.getSName(), v);
	}

	public void setChakraRegenMod(int v) {
		attributes.put(Attributes.STRENGTH.getSName(), v);
	}
}
