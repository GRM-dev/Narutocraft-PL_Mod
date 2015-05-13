package pl.grm.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaAttrSync implements IMessage {

	private String[] info;

	public static class PacketNinjaAttrSyncHandler
			implements
				IMessageHandler<PacketNinjaAttrSync, IMessage> {

		@Override
		public IMessage onMessage(PacketNinjaAttrSync message, MessageContext ctx) {
			// ExtendedProperties.get(Minecraft.getMinecraft().thePlayer).getNinAttrs().setInfo(message.info);
			return null;
		}
	}

	// Need a empty constructor just for the network registry to use
	public PacketNinjaAttrSync() {

	}

	// The command is changed to "set" because there is information to be used
	public PacketNinjaAttrSync(String[] info) {
		this.info = info;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.info = decompressString(ByteBufUtils.readUTF8String(buf));
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, compressInfo(info));
	}

	private String compressInfo(String[] info) {
		String compressedString = "";

		for (int i = 0; i < info.length; i++) {
			if (i == 0)
				compressedString += info[i];
			else compressedString += ";" + info[i];
		}
		return compressedString;
	}

	private String[] decompressString(String compressedString) {
		return compressedString.split(";");
	}
}
