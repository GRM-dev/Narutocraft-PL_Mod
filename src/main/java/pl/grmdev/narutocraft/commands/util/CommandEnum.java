package pl.grmdev.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import pl.grmdev.narutocraft.commands.NCChakraCommands;
import pl.grmdev.narutocraft.commands.NCCommandChakraReplenish;
import pl.grmdev.narutocraft.commands.NCCommandHelp;
import pl.grmdev.narutocraft.commands.NCCommandLevelUp;
import pl.grmdev.narutocraft.commands.NCCommandStats;

/**
 * The enum of Commands containing it's aliasses. All should be lover cases.
 */
public enum CommandEnum {
	HELP(true, true, "help", NCCommandHelp.class),
	LEVELUP(true, true, "levelup", NCCommandLevelUp.class, "lvlup"),
	CHAKRA(false, true, "chakra", NCChakraCommands.class),
	CHAKRA_REPLENISH(true, true, "replenish", NCCommandChakraReplenish.class, "repl"),
	STATS(true, true, "stats", NCCommandStats.class, "stat");

	private List<String> aliases = new ArrayList<String>();
	private boolean executive;
	private boolean client;

	private String name;
	private Class<? extends NCCommandBase> command;

	private CommandEnum(boolean executive, boolean client, String name, Class<? extends NCCommandBase> command,
			String... aliases) {
		this.client = client;
		this.command = command;
		this.executive = executive;
		this.name = name;
		this.aliases.add(name);
		for (String alias : aliases) {
			this.aliases.add(alias);
		}
	}

	public static CommandEnum getByName(String commandName) {
		String lowerCaseCommandName = commandName.toLowerCase();
		for (CommandEnum command : CommandEnum.values()) {
			for (String name : command.aliases) {
				if (name.equals(lowerCaseCommandName)) { return command; }
			}
		}
		return HELP;
	}

	public boolean isExecutve() {
		return this.executive;
	}

	public boolean isClient() {
		return this.client;
	}

	public String getName() {
		return this.name;
	}

	public Class<? extends NCCommandBase> getCommand() {
		return this.command;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public ICommand getInstance() throws InstantiationException, IllegalAccessException {
		if (command != null) {
			ICommand instance = command.newInstance();
			return instance;
		}
		return null;
	}
}