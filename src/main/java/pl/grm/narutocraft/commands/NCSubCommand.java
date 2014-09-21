package pl.grm.narutocraft.commands;

public abstract class NCSubCommand {
	
	private String[]	args;
	private CommandList	commands;
	
	public NCSubCommand(String[] args) {
		this.args = args;
		if (args.length > 0) {
			if (args.length == 1) {
				subCommandHelp();
			}
		}
	}
	
	public abstract void SubCommands();
	
	public abstract void subCommandHelp();
}