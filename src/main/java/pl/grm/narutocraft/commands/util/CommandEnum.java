package pl.grm.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import pl.grm.narutocraft.commands.NCCommandHelp;

/**
 * The enum of Commands containing it's aliasses.
 */
public enum CommandEnum {
	HELP(
			1,
			"help",
			NCCommandHelp.class) ,
	LEVELUP(
			1,
			"levelup",
			"lvlup") ,
	CHAKRA(
			0,
			"chakra") ,
	CHAKRA_REPLENISH(
			1,
			"replenish",
			"repl") ,
	STATS(
			0,
			"stats",
			"stat");
	
	private List<String>					aliases	= new ArrayList<String>();
	private int								type;
	private String							name;
	private Class<? extends NCCommandBase>	command;
	
	private CommandEnum(int type, String name, String... aliases) {
		this.type = type;
		this.name = name;
		this.aliases.add(name);
		for (String alias : aliases) {
			this.aliases.add(alias);
		}
	}
	
	private CommandEnum(int type, String name, Class<? extends NCCommandBase> command,
			String... aliases) {
		this(type, name, aliases);
		this.command = command;
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
	
	public int getType() {
		return this.type;
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