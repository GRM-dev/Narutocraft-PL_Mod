package pl.grm.narutocraft.skilltrees;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.jutsu.JutsuTier;

public class SkillTreeEntry {
	public int				x;
	public int				y;
	public SkillTree		tree;
	public JutsuTier		tier;
	public IJutsu			jutsu;
	public int				points;
	public SkillTreeEntry[]	prerequisites;
	public EntryStates		entryState;
	public JutsuEnum		reqJutsu;
	
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
	
	public SkillTreeEntry(JutsuEnum rasengan) {
		this.reqJutsu = rasengan;
		
	}
}