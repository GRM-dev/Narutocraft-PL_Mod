package pl.grm.narutocraft.gui.skilltrees;

import pl.grm.narutocraft.jutsu.IJutsu;

public class SkillTreeEntry {
	public final int x;
	public final int y;
	public final SkillTrees tree;
	public final SkillTreeEntry[] prerequisites;
	public final int tier;
	public boolean enabled;
	private IJutsu jutsu;

	public SkillTreeEntry(int x, int y, SkillTrees tree,
			SkillTreeEntry[] prerequisites, IJutsu jutsu, boolean enabled) {
		this.x = x;
		this.y = y;
		this.tree = tree;
		this.prerequisites = prerequisites;
		this.jutsu = jutsu;
		this.enabled = enabled;

		int highestTier = 0;
		for (SkillTreeEntry entry : prerequisites) {
			if (entry.tier >= highestTier) {
				highestTier = entry.tier + 1;
			}
		}
		this.tier = highestTier;
	}

	public IJutsu getJutsu() {
		return jutsu;
	}
}