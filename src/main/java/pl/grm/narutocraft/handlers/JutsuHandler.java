package pl.grm.narutocraft.handlers;

import java.util.Iterator;
import java.util.Map;

import pl.grm.narutocraft.effects.IEffect;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class JutsuHandler {

	public JutsuHandler() {

	}

	public static void iterateOverJutsus() {
		if (!ExtendedProperties.activeEffects.isEmpty()) {
			Iterator iterator = ExtendedProperties.activeEffects.entrySet()
					.iterator();
			Map.Entry<IJutsu, IEffect> elem;
			IJutsu jutsu;
			IEffect effect;
			while (iterator.hasNext()) {
				elem = (Map.Entry) iterator.next();
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
