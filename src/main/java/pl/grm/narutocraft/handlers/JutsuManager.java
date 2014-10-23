package pl.grm.narutocraft.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.skilltrees.SkillTreeEntry;
import pl.grm.narutocraft.stats.ExtendedProperties;
import cpw.mods.fml.common.registry.GameRegistry;

public class JutsuManager {
	public static JutsuManager						instance		= new JutsuManager();
	private int										jutsuID;
	private Jutsu									jutsu;
	private Iterator<int[]>							iterator;
	private final HashMap<Integer, SkillTreeEntry>	registeredEntries;
	private int[]									elem;
	private static int								count			= 0;
	private List<int[]>								activeJutsus	= new ArrayList<int[]>();
	
	public JutsuManager() {
		this.registeredEntries = new HashMap<Integer, SkillTreeEntry>();
		if (ExtendedProperties.jutsuList == null) {
			ExtendedProperties.jutsuList = new HashMap<Integer, IJutsu>();
		}
	}
	
	/**
	 * Iterate over JutsuEnum and calls regitster method
	 */
	public static void regJutsusList() {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu != JutsuEnum.NONE && jutsu != null) {
				registerJutsu(jutsu);
			}
		}
	}
	
	/**
	 * Add jutsu to GameRegistry.
	 * 
	 * @param jutsuE
	 */
	private static void registerJutsu(JutsuEnum jutsuE) {
		IJutsu jutsu = jutsuE.getJutsu();
		GameRegistry.registerItem((Item) jutsu, jutsuE.getName());
		count++;
		ExtendedProperties.jutsuList.put(jutsu.getJutsuProps().getID(), jutsu);
		if (count == ExtendedProperties.jutsuList.size()) {
			System.out.println("Added " + jutsu.getJutsuProps().getID() + " Jutsu.");
		} else {
			System.out.println("Smth wrong with registerinh Jutsu");
		}
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList jutsuList = new NBTTagList();
		this.activeJutsus = ExtendedProperties.activeJutsus;
		if (!this.activeJutsus.isEmpty()) {
			for (int[] jutsu : activeJutsus) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setIntArray("JutsuID: " + jutsu[0], jutsu);
				jutsuList.appendTag(tag);
			}
		}
		compound.setTag("JutsuManager", jutsuList);
	}

	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList jutsus = compound.getTagList("JutsuManager", Constants.NBT.TAG_COMPOUND); // compound.getId(
		int jCount = jutsus.tagCount();
		System.out.println("JCount: " + jCount);
		if (jutsus != null) {
			for (int i = 0; i < jCount; i++) {
				NBTTagCompound jutsu = jutsus.getCompoundTagAt(jCount);
				this.activeJutsus.add(jutsu.getIntArray("Jutsu" + i));
			}
		}
		ExtendedProperties.activeJutsus = this.activeJutsus;
	}
	
	/**
	 * Called on every PLayerTick to update all Jutsu effects.
	 */
	public synchronized void iterateOverJutsus() {
		this.activeJutsus = ExtendedProperties.activeJutsus;
		if (!this.activeJutsus.isEmpty()) {
			this.iterator = this.activeJutsus.iterator();
			while (this.iterator.hasNext()) {
				this.elem = this.iterator.next();
				this.jutsuID = this.elem[0];
				
				if (this.jutsu.isActive()) {
					this.jutsu.onJutsuUpdate();
				} else {
					this.jutsu.setActive(false);
				}
			}
		}
	}
	
	/**
	 * Called after read from NBT.
	 */
	public synchronized void loadJutsuEffectsOnPlayer() {
		if (!ExtendedProperties.activeJutsus.isEmpty()) {
			while (this.iterator.hasNext()) {
				this.elem = this.activeJutsus.iterator().next();
				if (this.jutsu.isActive()) {
					this.jutsu.onJutsuUpdate();
				} else {
					this.jutsu.setActive(false);
				}
			}
		}
	}
	
	public SkillTreeEntry getJutsu(int id) {
		SkillTreeEntry component = this.registeredEntries.get(Integer.valueOf(id));
		return component;
	}
	
	public SkillTreeEntry getJutsu(String name) {
		Integer ID = JutsuEnum.getByName(name).getJutsuID();
		if (ID == null) { return null; }
		return this.registeredEntries.get(ID);
	}
	
	public int getJutsuID(IJutsu jutsu) {
		return jutsu.getJutsuProps().getID();
	}
	
	public int getJutsuID(JutsuEnum jutsuListElem) {
		return jutsuListElem.getJutsuID();
	}
}