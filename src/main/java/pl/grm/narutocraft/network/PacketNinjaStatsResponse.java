package pl.grm.narutocraft.network;

import net.minecraft.client.Minecraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.PlayerSkillsAtrributes;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaStatsResponse implements IMessage
{
	private int[] data;
	
	//Need a empty constructor just for the network registry to use
	public PacketNinjaStatsResponse()
	{
		
	}
	
	public PacketNinjaStatsResponse(int[] values)
	{
		data = values;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		data = new int[PlayerSkillsAtrributes.arraySize];
		for(int v = 0; v < data.length; v++)
		{
			data[v] = buf.readInt();
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		for (int v : data)
		{
			buf.writeInt(v);
		}
	}

	public static class PacketNinjaStatsResponseHandler implements IMessageHandler<PacketNinjaStatsResponse, IMessage> 
	{

		@Override
		public IMessage onMessage(PacketNinjaStatsResponse message, MessageContext ctx) 
		{
			/*System.out.println(String.format("Received %d %f %s from %s", 
					message.exampleInt, message.exampleFloat,message.exampleString, 
					ctx.getServerHandler().playerEntity.getDisplayName()));*/
			System.out.println(message.data);
			ExtendedProperties.get(Minecraft.getMinecraft().thePlayer).psa.setValues(message.data);
			//the return is null because there is no response.
			return null;
			/*If you wanted a response you'd make another packet for the response and register it on the other side
			Such as if a GUI was to send info to the server, and the server was to say "got it" you'd need:
			return new PacketResponse("Got it");
			and PacketResponse takes just a String
			*/
		}

	}
}
