package pl.grm.narutocraft.gui.skilltrees;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuTier;

public class SkillTreeEntry {
	public final int				x;
	public final int				y;
	public final SkillTree			tree;
	public final JutsuTier			tier;
	public final IJutsu				jutsu;
	public final int				reqPoints;
	public final SkillTreeEntry[]	prerequisites;
	public EntryStates				entryState;
	
	public SkillTreeEntry(int x, int y, SkillTree tree, IJutsu jutsu, JutsuTier tier,
			int reqPoints, SkillTreeEntry[] prerequisites) {
		this.x = x;
		this.y = y;
		this.tree = tree;
		this.jutsu = jutsu;
		this.tier = tier;
		this.reqPoints = reqPoints;
		this.prerequisites = prerequisites;
	}
}