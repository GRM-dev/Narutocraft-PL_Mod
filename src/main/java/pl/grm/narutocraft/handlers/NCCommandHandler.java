package pl.grm.narutocraft.handlers;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommandSender;
import pl.grm.narutocraft.commands.NCCommandBase;

public class NCCommandHandler extends CommandHandler {
	private Map<String, NCCommandBase>	ncCommandsMap	= new HashMap<>();
	
	@Override
	public int executeCommand(ICommandSender par1ICommandSender, String par2Str) {
		super.executeCommand(par1ICommandSender, par2Str);
		return 0;
	}
	
}
