package pl.grm.narutocraft.handlers;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.command.ServerCommandManager;
import pl.grm.narutocraft.commands.util.NCCommandBase;
import pl.grm.narutocraft.commands.util.NCCommandExecutor;

public class NCCommandHandler {
	private Map<String, NCCommandBase>	ncCommandsMap;
	private ServerCommandManager		manager;
	private NCCommandExecutor			executor;
	
	public NCCommandHandler(ServerCommandManager manager) {
		this.manager = manager;
		ncCommandsMap = new HashMap<>();
	}
	
	public void registerCommands() {
		executor = new NCCommandExecutor(manager, ncCommandsMap);
		executor.setupCommands();
	}
	
	public Map<String, NCCommandBase> getNCCommandsMap() {
		return this.ncCommandsMap;
	}
}