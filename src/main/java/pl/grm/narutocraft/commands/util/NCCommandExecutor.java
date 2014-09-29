package pl.grm.narutocraft.commands.util;

import java.util.List;
import java.util.Map;

import net.minecraft.command.ICommand;
import net.minecraft.command.ServerCommandManager;

public class NCCommandExecutor {
	private ServerCommandManager		manager;
	private List<CommandEnum>			commands;
	private Map<String, NCCommandBase>	ncCommandsMap;
	
	public NCCommandExecutor(ServerCommandManager manager,
			Map<String, NCCommandBase> ncCommandsMap) {
		this.manager = manager;
		this.ncCommandsMap = ncCommandsMap;
	}
	
	public void setupCommands() {
		for (CommandEnum comm : commands) {
			if (comm.getType() == 1) {
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
				manager.registerCommand(instance);
			}
		}
	}
}
