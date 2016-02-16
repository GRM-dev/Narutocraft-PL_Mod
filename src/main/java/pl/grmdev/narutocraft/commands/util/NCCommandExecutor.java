package pl.grmdev.narutocraft.commands.util;

import net.minecraft.command.ICommandSender;

public class NCCommandExecutor {

	private ICommandSender commSender;
	private String[] args;

	public NCCommandExecutor(ICommandSender commSender, String[] args) {
		this.commSender = commSender;
		this.args = args;
	}

	public void processCommand() {
		// TODO Auto-generated method stub

	}
}
