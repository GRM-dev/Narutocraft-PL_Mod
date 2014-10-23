package pl.grm.narutocraft.stats;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

/**
 * NinjaAtrributes use {@link Attributes}
 */
public class NinjaAtrributes {
	private static final String		NBTCompoundName	= "NinjaAttributes";
	private Map<String, Integer>	attributes;
	
	public NinjaAtrributes() {
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
	
	/** Returns a Map of attributes values */
	public Map<String, Integer> getAttValues() {
		return attributes;
	}
	
	/**
	 * Takes an Int Array
	 * Best used with getValues, harder to mess up
	 **/
	public void setValues(int[] values) {
		
	}
	
	// Getters
	public int getStrength() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getAgility() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getDexterity() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getResistance() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getElementPowerMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getMaxChakraMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getChakraRegenMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	// Setters
	public void setStrength(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setAgility(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setDexterity(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setResistance(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setElementPowerMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setMaxChakraMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setChakraRegenMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
}
