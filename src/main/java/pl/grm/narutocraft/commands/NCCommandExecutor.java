package pl.grm.narutocraft.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class NCCommandExecutor {
	private ICommandSender	commSender;
	private String[]		params;
	private EntityPlayer	player;
	private String[]		commands	= {
			"help", "replenishChakra", "addxp", "resetSkillPoints",
			"resetplayerattributes"		};
	
	public NCCommandExecutor(ICommandSender commSender, String[] params) {
		this.commSender = commSender;
		this.params = params;
		player = (EntityPlayer) commSender;
	}
	
	public void showHelp() {
		player.addChatMessage(new ChatComponentText("Command arg1: " + params[0]));
	}
	
	public void executeCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
