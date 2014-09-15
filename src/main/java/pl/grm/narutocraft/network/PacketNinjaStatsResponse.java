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
			ExtendedProperties.get(Minecraft.getMinecraft().thePlayer).psa.setValues(message.data);
			return null;
		}

	}
}
