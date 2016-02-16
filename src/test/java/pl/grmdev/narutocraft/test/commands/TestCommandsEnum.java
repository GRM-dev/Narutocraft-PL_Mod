package pl.grmdev.narutocraft.test.commands;

import static org.junit.Assert.fail;

import org.junit.Test;

import net.minecraft.command.ICommand;
import pl.grmdev.narutocraft.commands.util.CommandEnum;

public class TestCommandsEnum {

	@Test
	public void testEnumInstanceCreation() {
		Exception ec = null;
		for (CommandEnum comm : CommandEnum.values()) {
			if (comm.isExecutve()) {
				String name = comm.getName();
				ICommand instance = null;
				try {
					instance = comm.getInstance();
				}
				catch (InstantiationException e) {
					e.printStackTrace();
					ec = e;
				}
				catch (IllegalAccessException e) {
					e.printStackTrace();
					ec = e;
				}
				finally {
					if (instance == null) {
						if (ec == null) {
							fail("Create Instance failed");
						} else {
							fail("Create Instance failed. Error:" + ec.getLocalizedMessage());
						}
					} else if (instance.getCommandName() == null) {
						fail("Instance created, but something wrong with (" + name + ")");
					}
				}
			}
		}
	}

	@Test
	public void testEnumStatics() {
		for (CommandEnum comm : CommandEnum.values()) {
			if (comm.getName() == null || comm.getDeclaringClass() == null) fail("Empty field in declaration?");
		}
	}
}
