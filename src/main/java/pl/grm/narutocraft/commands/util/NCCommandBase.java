package pl.grm.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class NCCommandBase extends CommandBase {

	@Override
	public String getCommandName() {
		return "narutocraft";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getCommandAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("ncpl");
		aliases.add("nc");
		return aliases;
	}
}
