package pl.grm.narutocraft.commands;

public enum CommandList {
	HELP(
			"help") ,
	LEVELUP(
			"levelup",
			"lvlup") ,
	CHAKRA(
			"chakra") ,
	CHAKRA_REPLENISH(
			"replenish",
			"repl");
	
	private String[]	commands;
	
	private CommandList(String... command) {
		this.commands = command;
	}
	
	public String[] getCommandNames() {
		return commands;
	}
	
	public static CommandList getByName(String commandName) {
		String lowerCaseCommandName = commandName.toLowerCase();
		for (CommandList command : CommandList.values()) {
			for (String name : command.commands) {
				if (name.equals(lowerCaseCommandName))
					return command;
			}
		}
		return HELP;
	}
}