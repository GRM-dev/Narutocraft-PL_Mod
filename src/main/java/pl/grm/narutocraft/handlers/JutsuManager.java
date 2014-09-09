package pl.grm.narutocraft.handlers;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class JutsuManager {
	private Integer jutsuID;
	private IJutsu jutsu;
	private Iterator<Entry<Integer, IJutsu>> iterator;
	private Map.Entry<Integer, IJutsu> elem;
	private Map<Integer, IJutsu> activeJutsus;
	private int[] jutsuArray;
	private int[] jutsuProperties;

	public synchronized void iterateOverJutsus() {
		if (!ExtendedProperties.activeJutsus.isEmpty()) {
			Map.Entry<Integer, IJutsu> elem;
			iterator = ExtendedProperties.activeJutsus.entrySet().iterator();
			while (iterator.hasNext()) {
				elem = iterator.next();
				jutsuID = elem.getKey();
				jutsu = elem.getValue();
				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					jutsu.setActive(false);
			}
		}
	}

	public synchronized void loadJutsuEffectsOnPlayer() {
		if (!ExtendedProperties.activeJutsus.isEmpty()) {
			Map.Entry<Integer, IJutsu> elem;
			while (iterator.hasNext()) {
				elem = iterator.next();
				jutsuID = elem.getKey();
				jutsu = elem.getValue();
				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					jutsu.setActive(false);
			}
		}
	}

	/**
	 * Converts Map IJutsu, IEffect to arrays[].
	 */
	public synchronized void jutsuMapToArrays() {
		iterator = ExtendedProperties.activeJutsus.entrySet().iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			elem = iterator.next();
			jutsuID = elem.getKey();
			int durationLeft = jutsu.getTotalDuration()
					- jutsu.getDurationPass();
			if (jutsu.isActive()) {
				ExtendedProperties.activeJutsuArray[i] = jutsuID;
				ExtendedProperties.jutsuProperties[i] = durationLeft;
			}
		}
	}

	/**
	 * Jutsu Arrays to Map.
	 */
	public synchronized void arraysToJutsuMap() {
		activeJutsus = ExtendedProperties.activeJutsus;
		jutsuArray = ExtendedProperties.activeJutsuArray;
		jutsuProperties = ExtendedProperties.jutsuProperties;

		// if (jutsuArray.length > 0)
		// for (int i : jutsuArray) {
		// activeEffects.put(JutsuList.jutsuArray[i],
		// EffectList.getById(effectArray[i]));
		// }
	}
}
