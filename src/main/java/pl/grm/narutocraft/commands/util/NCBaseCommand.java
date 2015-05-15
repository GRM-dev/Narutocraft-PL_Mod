package pl.grm.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Registered at forge input/output command stream.
 */
public class NCBaseCommand extends NCCommandBase {

	private NCCommandExecutor executor;

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
