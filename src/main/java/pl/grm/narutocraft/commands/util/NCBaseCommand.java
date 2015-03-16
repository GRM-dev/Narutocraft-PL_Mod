package pl.grm.narutocraft.commands.util;

import java.util.*;

import net.minecraft.command.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

/**
 * Registered at forge input/output command stream.
 */
public class NCBaseCommand extends NCCommandBase {
	private NCCommandExecutor	executor;
	
	@Override
	public String getCommandName() {
		return "narutocraft";
	}
	
	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "Test Msg";
	}
	
	@Override
	public List<String> getCommandAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("ncpl");
		aliases.add("nc");
		return aliases;
	}
	
	@Override
	public void processCommand(ICommandSender commSender, String[] args) {
		executor = new NCCommandExecutor(commSender, args);
		((EntityPlayer) commSender).addChatMessage(new ChatComponentText("Available commands:"));
		executor.processCommand();
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender var1) {
		return true;
	}
	
	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}
}
