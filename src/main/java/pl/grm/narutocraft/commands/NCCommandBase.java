package pl.grm.narutocraft.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

public class NCCommandBase implements ICommand {
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "narutocraft";
	}
	
	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "Command executed.";
	}
	
	@Override
	public List<String> getCommandAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("ncpl");
		aliases.add("nc");
		return aliases;
	}
	
	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		NCCommandExecutor commandExecutor = new NCCommandExecutor(var1, var2);
		if (var2.length == 0) {
			commandExecutor.showHelp();
		} else if (var2.length > 0) {
			commandExecutor.executeCommand();
		}
	}
	
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
	
}
