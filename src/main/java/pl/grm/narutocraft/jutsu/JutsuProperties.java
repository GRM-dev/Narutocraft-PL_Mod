package pl.grm.narutocraft.jutsu;

public class JutsuProperties {
	private int		jutsuID;
	private long	passDuration;
	private long	totalDuration;
	private long	chakraConsumption;
	private String	unlocalizedName;
	private boolean	activated;
	
	public JutsuProperties(int jutsuID, String unlocalizedName, long passDuration,
			long totalDuration, long chakraConsumption, boolean activated) {
		this.jutsuID = jutsuID;
		this.unlocalizedName = unlocalizedName;
		this.passDuration = passDuration;
		this.totalDuration = totalDuration;
		this.chakraConsumption = chakraConsumption;
		this.activated = activated;
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