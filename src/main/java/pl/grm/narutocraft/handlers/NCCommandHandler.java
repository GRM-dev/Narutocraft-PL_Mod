package pl.grm.narutocraft.handlers;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.command.ServerCommandManager;
import net.minecraftforge.client.ClientCommandHandler;
import pl.grm.narutocraft.commands.util.NCCommandBase;
import pl.grm.narutocraft.commands.util.NCCommandExecutor;

public class NCCommandHandler {
	private Map<String, NCCommandBase>	ncCommandsMap;
	private NCCommandExecutor			executor;
	private ServerCommandManager		sManager;
	private ClientCommandHandler		cManager;
	
	public NCCommandHandler() {
		ncCommandsMap = new HashMap<>();
	}
	
	public NCCommandHandler(ServerCommandManager manager) {
		this();
		this.sManager = manager;
		executor = new NCCommandExecutor(sManager, ncCommandsMap);
	}
	
	public NCCommandHandler(ClientCommandHandler manager) {
		this();
		this.cManager = manager;
		executor = new NCCommandExecutor(cManager, ncCommandsMap);
	}
	
	public Map<String, NCCommandBase> getNCCommandsMap() {
		return this.ncCommandsMap;
	}
	
	public void registerCommands(boolean both) {
		executor.setupCommands(both);
	}
}