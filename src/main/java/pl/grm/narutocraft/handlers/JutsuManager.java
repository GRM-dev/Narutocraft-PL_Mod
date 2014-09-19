package pl.grm.narutocraft.handlers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pl.grm.narutocraft.gui.skilltrees.SkillTreeEntry;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class JutsuManager {
	public static JutsuManager instance = new JutsuManager();
	private int jutsuID, durationLeft;
	private IJutsu jutsu;
	private List<int[]> activeJutsus;
	private Iterator<int[]> iterator;
	private final HashMap<Integer, SkillTreeEntry> registeredEntries;
	private int[] elem;

	public JutsuManager() {
		this.registeredEntries = new HashMap<>();
	}

	public SkillTreeEntry getJutsu(int id) {
		SkillTreeEntry component = this.registeredEntries.get(Integer
				.valueOf(id));
		return component;
	}

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

	public synchronized void loadJutsuEffectsOnPlayer() {
		if (!ExtendedProperties.activeJutsus.isEmpty()) {
			int[] elem;
			while (this.iterator.hasNext()) {
				elem = this.activeJutsus.iterator().next();
				if (this.jutsu.isActive()) {
					this.jutsu.onJutsuUpdate();
				} else {
					this.jutsu.setActive(false);
				}
			}
		}
	}

	public SkillTreeEntry getJutsu(String name) {
		Integer ID = JutsuEnum.getByName(name).getID();
		if (ID == null) {
			return null;
		}
		return this.registeredEntries.get(ID);
	}

	public int getJutsuID(JutsuEnum jutsuListElem) {
		return jutsuListElem.getID();
	}

	public int getJutsuID(IJutsu jutsu) {
		return jutsu.getJutsuID();
	}
}