package pl.grm.narutocraft.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import pl.grm.narutocraft.gui.skilltrees.SkillTreeEntry;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.libs.ExtendedProperties;
import cpw.mods.fml.common.registry.GameRegistry;

public class JutsuManager {
	public static JutsuManager						instance		= new JutsuManager();
	private int										jutsuID, durationLeft;
	private Jutsu									jutsu;
	private Iterator<int[]>							iterator;
	private final HashMap<Integer, SkillTreeEntry>	registeredEntries;
	private int[]									elem;
	private static int								count			= 0;
	private List<int[]>								activeJutsus	= new ArrayList<int[]>();
	private int[]									jutsuLine;
	
	public JutsuManager() {
		this.registeredEntries = new HashMap<Integer, SkillTreeEntry>();
	}
	
	/**
	 * Iterate over JutsuEnum and calls regitster method
	 */
	public static void regJutsusList() {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu != JutsuEnum.NONE && jutsu != null)
				registerJutsu(jutsu);
		}
	}
	
	/**
	 * Add jutsu to GameRegistry.
	 * 
	 * @param jutsu
	 */
	public static void registerJutsu(JutsuEnum jutsu) {
		GameRegistry.registerItem(jutsu.getJutsu(), jutsu.getName());
		count++;
		System.out.println(count);
	}
	
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList jutsus = compound.getTagList("JutsuManager", compound.getId());
		
		int jCount = jutsus.tagCount();
		System.out.println("JCount: " + jCount);
		if (jCount > 0) {
			for (int i = 0; i < jCount; i++) {
				NBTTagCompound jutsu = jutsus.getCompoundTagAt(jCount);
				this.activeJutsus.add(jutsu.getIntArray("Jutsu" + i));
			}
		}
		ExtendedProperties.activeJutsus = this.activeJutsus;
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList jutsuList = new NBTTagList();
		NBTTagCompound jutsus = new NBTTagCompound();
		this.activeJutsus = ExtendedProperties.activeJutsus;
		
		if (!this.activeJutsus.isEmpty()) {
			while (this.activeJutsus.iterator().hasNext()) {
				this.jutsuLine = this.activeJutsus.iterator().next();
				jutsus.setIntArray("Jutsu" + this.jutsuLine[0], this.jutsuLine);
				jutsuList.appendTag(jutsus);
			}
		}
		compound.setTag("JutsuManager", jutsus);
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
				this.durationLeft = this.elem[1];
				
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
		Integer ID = JutsuEnum.getByName(name).getID();
		if (ID == null) { return null; }
		return this.registeredEntries.get(ID);
	}
	
	public int getJutsuID(IJutsu jutsu) {
		return jutsu.getJutsuProps()[0];
	}
	
	public int getJutsuID(JutsuEnum jutsuListElem) {
		return jutsuListElem.getID();
	}
}