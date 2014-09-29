package pl.grm.narutocraft.commands;

public abstract class NCSubCommand {
	private String[]		args;
	private CommandAliases	commands;
	
	public NCSubCommand(String[] args) {
		this.args = args;
		if (args != null) {
			if (args.length == 1) {
				subCommandHelp();
			} else {
				subCommands();
			}
		} else {
			subCommandHelp();
		}
	}
	
	public abstract void subCommands();
	
	public abstract void subCommandHelp();
}