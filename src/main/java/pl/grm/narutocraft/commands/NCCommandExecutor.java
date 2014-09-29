package pl.grm.narutocraft.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class NCCommandExecutor {
	private ICommandSender	commSender;
	private String[]		params;
	private EntityPlayer	player;
	private CommandAliases	subCommand;
	private int				paramCount;
	private NCSubCommand	subsubComm;
	
	public NCCommandExecutor(ICommandSender commSender) {
		this.commSender = commSender;
		if (commSender instanceof EntityPlayer) {
			player = (EntityPlayer) commSender;
			new NCCommandHelp(params, player).showHelp(false);
		}
	}
	
	public NCCommandExecutor(ICommandSender commSender, String[] params) {
		this(commSender);
		paramCount = params.length;
		if (paramCount > 0) {
			this.params = params;
			subCommand = CommandAliases.getByName(params[0]);
		}
	}
	
	public void executeCommand() {
		switch (subCommand) {
			case HELP :
				player.addChatMessage(new ChatComponentText("Bad Command!"));
				new NCCommandHelp(params, player).showHelp(true);
				break;
			case LEVELUP :
				levelUP();
				break;
			case CHAKRA :
				subsubComm = new NCChakraCommands(params);
				subsubComm.subCommands();
				break;
			default :
				break;
		}
	}
	
	private void replChakra() {
		ExtendedProperties.get(player).replenishChakra();
	}
	
	private void levelUP() {
		if (commSender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) commSender;
			// Turn the sender into a player entity
			ExtendedProperties.get(player).psa.levelUp(ExtendedProperties.get(player).psa
					.getXpCap());
		}
	}
}
