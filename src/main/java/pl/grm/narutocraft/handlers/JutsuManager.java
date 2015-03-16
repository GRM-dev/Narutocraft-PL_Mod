package pl.grm.narutocraft.handlers;

import java.util.*;

import net.minecraft.nbt.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.fml.common.registry.*;
import pl.grm.narutocraft.jutsu.*;
import pl.grm.narutocraft.player.*;
import pl.grm.narutocraft.skilltrees.*;

public class JutsuManager {
	public static JutsuManager						instance		= new JutsuManager();
	private Jutsu									jutsu;
	private Iterator<int[]>							iterator;
	private final HashMap<Integer, SkillTreeEntry>	registeredEntries;
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
		for (JutsuParams jutsu : JutsuParams.values()) {
			if (jutsu != JutsuParams.NONE && jutsu != null) {
				registerJutsu(jutsu);
			}
		}
	}
	
	/**
	 * Add jutsu to GameRegistry.
	 * 
	 * @param jutsuE
	 */
	private static void registerJutsu(JutsuParams jutsuE) {
		Jutsu jutsu = (Jutsu) jutsuE.getJutsu();
		GameRegistry.registerItem(jutsu, jutsuE.getName());
		ExtendedProperties.jutsuList.put(jutsu.getJutsuProps().getID(), jutsu);
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList jutsuList = new NBTTagList();
		this.activeJutsus = ExtendedProperties.activeJutsus;
		if (!this.activeJutsus.isEmpty()) {
			for (int[] jutsu : activeJutsus) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setIntArray("Jutsu:" + jutsu[0], jutsu);
				jutsuList.appendTag(tag);
			}
		}
		compound.setTag("JutsuManager", jutsuList);
	}
	
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList jutsus = compound.getTagList("JutsuManager", Constants.NBT.TAG_COMPOUND);
		int amount = jutsus.tagCount();
		if (jutsus != null) {
			for (int i = 0; i < amount; i++) {
				NBTTagCompound jutsu = jutsus.getCompoundTagAt(i);
				this.activeJutsus.add(jutsu.getIntArray("Jutsu:" + i));
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
				this.iterator.next();
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
				this.activeJutsus.iterator().next();
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
		Integer ID = JutsuParams.getByName(name).getJutsuID();
		if (ID == null) { return null; }
		return this.registeredEntries.get(ID);
	}
	
	public int getJutsuID(IJutsu jutsu) {
		return ((Jutsu) jutsu).getJutsuProps().getID();
	}
	
	public int getJutsuID(JutsuParams jutsuListElem) {
		return jutsuListElem.getJutsuID();
	}
}