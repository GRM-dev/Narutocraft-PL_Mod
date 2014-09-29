package pl.grm.narutocraft.commands;

/**
 * The enum of Commands containing it's aliasses.
 */
public enum CommandAliases {
	HELP(
			"help") ,
	LEVELUP(
			"levelup",
			"lvlup") ,
	CHAKRA(
			"chakra") ,
	CHAKRA_REPLENISH(
			"replenish",
			"repl") ,
	STATS(
			"stats",
			"stat");
	
	private String[]	commands;
	
	private CommandAliases(String... command) {
		this.commands = command;
	}
	
	public String[] getCommandNames() {
		return commands;
	}
	
	public static CommandAliases getByName(String commandName) {
		String lowerCaseCommandName = commandName.toLowerCase();
		for (CommandAliases command : CommandAliases.values()) {
			for (String name : command.commands) {
				if (name.equals(lowerCaseCommandName)) { return command; }
			}
		}
		return HELP;
	}
}