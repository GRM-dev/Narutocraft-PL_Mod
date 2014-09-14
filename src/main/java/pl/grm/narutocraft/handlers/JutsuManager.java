package pl.grm.narutocraft.handlers;

import java.util.Iterator;
import java.util.List;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class JutsuManager {
	private int jutsuID, durationLeft;
	private IJutsu jutsu;
	private List<int[]> activeJutsus;
	private Iterator<int[]> iterator;
	private int[] elem;

	public synchronized void iterateOverJutsus() {
		this.activeJutsus = ExtendedProperties.activeJutsus;
		if (!activeJutsus.isEmpty()) {
			iterator = activeJutsus.iterator();
			while (iterator.hasNext()) {
				elem = iterator.next();
				jutsuID = elem[0];
				durationLeft = elem[1];

				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					jutsu.setActive(false);
			}
		}
	}

	public synchronized void loadJutsuEffectsOnPlayer() {
		if (!ExtendedProperties.activeJutsus.isEmpty()) {
			int[] elem;
			while (iterator.hasNext()) {
				elem = activeJutsus.iterator().next();
				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					jutsu.setActive(false);
			}
		}
	}
}