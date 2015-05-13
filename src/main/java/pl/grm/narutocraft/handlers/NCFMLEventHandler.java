package pl.grm.narutocraft.handlers;

import net.minecraft.command.*;
import net.minecraft.server.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;

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