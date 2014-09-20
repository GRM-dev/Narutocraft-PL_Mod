package pl.grm.narutocraft.handlers;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import pl.grm.narutocraft.commands.NCCommandRefreshChekra;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * FML Event Handler
 *
 * @author Admaster
 */
public class NCPLFMLEventHandler {
	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager manager = (ServerCommandManager) command;
		manager.registerCommand(new NCCommandRefreshChekra());
	}
}
