package pl.grm.narutocraft.handlers;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import pl.grm.narutocraft.effects.IEffect;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class JutsuHandler {
	private IJutsu jutsu;
	private IEffect effect;
	private Iterator<Entry<IJutsu, IEffect>> iterator;

	public synchronized void iterateOverJutsus() {
		if (!ExtendedProperties.activeEffects.isEmpty()) {
			Map.Entry<IJutsu, IEffect> elem;
			iterator = ExtendedProperties.activeEffects.entrySet().iterator();
			while (iterator.hasNext()) {
				elem = iterator.next();
				jutsu = elem.getKey();
				effect = elem.getValue();
				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					effect.endEffect();
			}
		}
	}

	public synchronized void loadJutsuEffectsOnPlayer() {
		if (!ExtendedProperties.activeEffects.isEmpty()) {
			Map.Entry<IJutsu, IEffect> elem;
			while (iterator.hasNext()) {
				elem = iterator.next();
				jutsu = elem.getKey();
				effect = elem.getValue();
				if (jutsu.isActive())
					jutsu.onJutsuUpdate();
				else
					effect.endEffect();
			}
		}
	}
}
