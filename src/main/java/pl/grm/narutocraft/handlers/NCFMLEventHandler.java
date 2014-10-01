package pl.grm.narutocraft.handlers;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * FML Event Handler
 */
public class NCFMLEventHandler {
	/**
	 * Register commands on Server Start
	 * 
	 * @param event
	 *            "unused"
	 */
	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager manager = (ServerCommandManager) command;
		NCCommandHandler commandHandler = new NCCommandHandler(manager);
		commandHandler.registerCommands(false);
	}
}