package pl.grm.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

/**
 * Registered at forge input/output command stream.
 */
public abstract class NCCommandBase extends CommandBase implements ICommand {
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "narutocraft";
	}
	
	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "commands.ncpl";
	}
	
	@Override
	public List<String> getCommandAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("ncpl");
		aliases.add("nc");
		return aliases;
	}
	
	@Override
	public abstract void processCommand(ICommandSender commSender, String[] args);
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender var1) {
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
		return null;
	}
	
	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}
	
	public void subCommands() {
		// TODO Auto-generated method stub
		
	}
}
