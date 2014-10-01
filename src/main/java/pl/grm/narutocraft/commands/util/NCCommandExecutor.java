package pl.grm.narutocraft.commands.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.command.ICommand;
import net.minecraft.command.ServerCommandManager;
import net.minecraftforge.client.ClientCommandHandler;

public class NCCommandExecutor {
	private ServerCommandManager		sManager;
	private ClientCommandHandler		cManager;
	private List<CommandEnum>			commands	= new ArrayList<CommandEnum>();
	private Map<String, NCCommandBase>	ncCommandsMap;
	
	public NCCommandExecutor(ServerCommandManager manager,
			Map<String, NCCommandBase> ncCommandsMap) {
		this.sManager = manager;
		this.ncCommandsMap = ncCommandsMap;
	}
	
	public NCCommandExecutor(ClientCommandHandler manager,
			Map<String, NCCommandBase> ncCommandsMap) {
		this.cManager = manager;
		this.ncCommandsMap = ncCommandsMap;
	}
	
	public void setupCommands(boolean both) {
		for (CommandEnum comm : CommandEnum.values()) { // TODO init List
			if (comm.isExecutve()) {
				String name = comm.getName();
				ICommand instance = null;
				try {
					instance = comm.getInstance();
				}
				catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ncCommandsMap.put(name, (NCCommandBase) instance);
				commands.add(comm);
				if (both) {
					setupClientCommand(instance);
				} else {
					setupServerCommand(instance);
				}
			}
		}
	}
	
	private void setupServerCommand(ICommand instance) {
		sManager.registerCommand(instance);
	}
	
	private void setupClientCommand(ICommand instance) {
		cManager.registerCommand(instance);
	}
}
