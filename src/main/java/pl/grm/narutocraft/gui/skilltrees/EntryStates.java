package pl.grm.narutocraft.gui.skilltrees;

public enum EntryStates {
	LOCKED(
			0) ,
	UNLOCKED(
			1) ,
	LEARNED(
			2) ,
	SELECTED(
			3) ,
	ACTIVATED(
			4);
	
	private int	i;
	
	private EntryStates(int i) {
		this.i = i;
	}
}
