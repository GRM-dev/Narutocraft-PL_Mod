package pl.grm.narutocraft.commands;

import java.util.ArrayList;
import java.util.List;

import pl.grm.narutocraft.libs.ExtendedProperties;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class NCCommandLevelUp extends CommandBase 
{

	@Override
	public String getCommandName() {
		return "ninLvlUp";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/ninLvlUp Ninja Up.. Wait that's not right.";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		if(var1 instanceof EntityPlayer)
		{
		EntityPlayer player = (EntityPlayer) var1;
		// Turn the sender into a player entity

		ExtendedProperties.get(player).psa.levelUp(ExtendedProperties.get(player).psa.getXpCap());
		}
	}
	
	
	
}
