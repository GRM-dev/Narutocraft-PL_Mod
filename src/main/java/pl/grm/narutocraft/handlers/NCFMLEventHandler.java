package pl.grm.narutocraft.handlers;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * FML Event Handler
 *
 * @author Admaster
 */
public class NCFMLEventHandler {
	@EventHandler
	public void serverStart(@SuppressWarnings("unused")
	FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager manager = (ServerCommandManager) command;
		NCCommandHandler commandHandler = new NCCommandHandler(manager);
		commandHandler.registerCommands();
		
	}
}