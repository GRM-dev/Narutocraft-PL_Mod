package pl.grmdev.narutocraft.skilltrees;

public enum EntryStates {
	LOCKED(0),
	UNLOCKED(1),
	LEARNED(2),
	SELECTED(3),
	ACTIVATED(4);

	private int stateID;

	private EntryStates(int stateID) {
		this.stateID = stateID;
	}

	public int getIStateID() {
		return stateID;
	}

	public static EntryStates getByID(int ID) {
		for (EntryStates state : EntryStates.values()) {
			if (state.stateID == ID) { return state; }
		}
		return null;
	}
}
