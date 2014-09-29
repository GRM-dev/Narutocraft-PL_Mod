package pl.grm.narutocraft.commands;

import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class NCCommandHelp extends NCSubCommand {
	
	private String[]		params;
	private EntityPlayer	player;
	
	public NCCommandHelp(String[] args, EntityPlayer player) {
		super(args);
		params = args;
		this.player = player;
	}
	
	@Override
	public void subCommands() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void subCommandHelp() {
		// TODO Auto-generated method stub
		
	}
	
	public void showHelp(boolean withParams) {
		if (withParams) {
			player.addChatMessage(new ChatComponentText("Your Command: " + params[0]));
		} else {
			player.addChatMessage(new ChatComponentText("No parameters."));
			throw new WrongUsageException("commands.ncpl.usage", new Object[0]);
		}
	}
	
}
