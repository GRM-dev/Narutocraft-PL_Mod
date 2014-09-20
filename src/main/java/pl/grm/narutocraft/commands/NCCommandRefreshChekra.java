package pl.grm.narutocraft.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class NCCommandRefreshChekra implements ICommand {
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "regChakra";
	}
	
	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "Chakra regenerates.";
	}
	
	@Override
	public List<String> getCommandAliases() {
		List<String> aliases = new ArrayList<String>();
		aliases.add("refreshChakra");
		aliases.add("refch");
		return aliases;
	}
	
	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		EntityPlayer player = (EntityPlayer) var1;
		player.addChatMessage(new ChatComponentText("Sample: [Check]"));
		
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
