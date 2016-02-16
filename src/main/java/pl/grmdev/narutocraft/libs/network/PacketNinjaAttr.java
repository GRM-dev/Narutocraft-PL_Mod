package pl.grmdev.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import pl.grmdev.narutocraft.player.ExtendedProperties;
import pl.grmdev.narutocraft.player.NinjaAttributes;

public class PacketNinjaAttr implements IMessage {

	private String[] info;
	private int command = 1;// 0 is set, 1 is get

	public static class PacketNinjaAttrHandler implements IMessageHandler<PacketNinjaAttr, IMessage> {

		@Override
		public IMessage onMessage(PacketNinjaAttr message, MessageContext ctx) {
			// TODO update
			if (message.command == 0) {
				NinjaAttributes na = ExtendedProperties.get(ctx.getServerHandler().playerEntity).getNinAttrs();
				na.setInfo(message.info);
				return null;
			} else return new PacketNinjaAttrSync(message.info);
		}
	}

	// Need a empty constructor just for the network registry to use
	public PacketNinjaAttr() {

	}

	// The command is changed to "set" because there is information to be used
	public PacketNinjaAttr(String[] info) {
		this.info = info;
		this.command = 0;
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
