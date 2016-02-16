package pl.grmdev.narutocraft.jutsu;

/**
 * Properties of jutsu: ID, durations,chakra consumption, name, ...
 */
public class JutsuProperties {

	private int jutsuID;
	private long passDuration;
	private long totalDuration;
	private long chakraConsumption;
	private String unlocalizedName;
	private boolean activated;

	/**
	 * Properties of jutsu
	 * 
	 * @param jutsuID
	 * @param unlocalizedName
	 * @param passDuration
	 * @param totalDuration
	 * @param chakraConsumption
	 * @param activated
	 */
	public JutsuProperties(int jutsuID, String unlocalizedName, long passDuration, long totalDuration,
			long chakraConsumption, boolean activated) {
		this.jutsuID = jutsuID;
		this.unlocalizedName = unlocalizedName;
		this.passDuration = passDuration;
		this.totalDuration = totalDuration;
		this.chakraConsumption = chakraConsumption;
		this.activated = activated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.jutsuID;
		result = prime * result + ((this.unlocalizedName == null) ? 0 : this.unlocalizedName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		JutsuProperties other = (JutsuProperties) obj;
		if (this.jutsuID != other.jutsuID) return false;
		if (this.unlocalizedName == null) {
			if (other.unlocalizedName != null) return false;
		} else if (!this.unlocalizedName.equals(other.unlocalizedName)) return false;
		return true;
	}

	public long getPassDuration() {
		return this.passDuration;
	}

	public void setJutsuID(int jutsuID) {
		this.jutsuID = jutsuID;
	}

	public void setTotalDuration(long totalDuration) {
		this.totalDuration = totalDuration;
	}

	public void setChakraConsumption(long chakraConsumption) {
		this.chakraConsumption = chakraConsumption;
	}

	public void setUnlocalizedName(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	public void setPassDuration(long passDuration) {
		this.passDuration = passDuration;
	}

	public boolean isActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public int getID() {
		return this.jutsuID;
	}

	public long getTotalDuration() {
		return this.totalDuration;
	}

	public long getChakraConsumption() {
		return this.chakraConsumption;
	}

	public String getUnlocalizedName() {
		return this.unlocalizedName;
	}
}