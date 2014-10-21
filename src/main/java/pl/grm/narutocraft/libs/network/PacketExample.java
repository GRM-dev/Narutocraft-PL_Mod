package pl.grm.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketExample implements IMessage {
	public static class PacketExampleHandler implements IMessageHandler<PacketExample, IMessage> {
		
		@Override
		public IMessage onMessage(PacketExample message, MessageContext ctx) {
			System.out.println(String.format("Received %d %f %s from %s",
					message.exampleInt, message.exampleFloat, message.exampleString,
					ctx.getServerHandler().playerEntity.getDisplayName()));
			
			// the return is null because there is no response.
			return null;
			/*
			 * If you wanted a response you'd make another packet for the
			 * response and register it on the other side Such as if a GUI was
			 * to send info to the server, and the server was to say "got it"
			 * you'd need: return new PacketResponse("Got it"); and
			 * PacketResponse takes just a String
			 */
		}
		
	}
	
	private int		exampleInt		= 0;
	private float	exampleFloat	= 0f;
	
	private String	exampleString	= "";
	
	// Need a empty constructor just for the network registry to use
	public PacketExample() {
		
	}
	
	public PacketExample(int i, float f, String s) {
		this.exampleInt = i;
		this.exampleFloat = f;
		this.exampleString = s;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.exampleInt = buf.readInt();
		this.exampleFloat = buf.readFloat();
		this.exampleString = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.exampleInt);
		buf.writeFloat(this.exampleFloat);
		ByteBufUtils.writeUTF8String(buf, this.exampleString);
	}
}
