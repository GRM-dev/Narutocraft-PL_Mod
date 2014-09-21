package pl.grm.narutocraft.gui.skilltrees;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuTier;

public class SkillTreeEntry {
	public final int				x;
	public final int				y;
	public final SkillTree			tree;
	public final JutsuTier			tier;
	public final IJutsu				jutsu;
	public final int				points;
	public final SkillTreeEntry[]	prerequisites;
	public EntryStates				entryState;
	
	/**
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param tree
	 *            SkillTree type
	 * @param jutsu
	 *            Jutsu
	 * @param tier
	 *            which Tier it is
	 * @param points
	 *            how many points it require to unlock
	 * @param prerequisites
	 *            what entry should be unlocked before this
	 */
	public SkillTreeEntry(int x, int y, SkillTree tree, IJutsu jutsu, JutsuTier tier,
			int points, SkillTreeEntry[] prerequisites) {
		this.x = x;
		this.y = y;
		this.tree = tree;
		this.jutsu = jutsu;
		this.tier = tier;
		this.points = points;
		this.prerequisites = prerequisites;
	}
}