package pl.grm.narutocraft.network;

import io.netty.buffer.ByteBuf;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.PlayerSkillsAtrributes;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaStatsRequest implements IMessage {
	public static class PacketNinjaStatsRequestHandler implements IMessageHandler<PacketNinjaStatsRequest, IMessage> {
		
		@Override
		public IMessage onMessage(PacketNinjaStatsRequest message, MessageContext ctx) {
			if (message.command.equals("get")) {
				return new PacketNinjaStatsResponse(ExtendedProperties.get(ctx
						.getServerHandler().playerEntity).psa.getValues());
			} else if (message.command.equals("set")) {
				int totalPointsUsed = 0;
				// Check Strength, Resistance, Dex, Agility
				totalPointsUsed += (message.data[0] + message.data[1] + message.data[2] + message.data[3]) * 3;
				// Check Element, max chakra, and regen
				totalPointsUsed += (message.data[4] + message.data[5] + message.data[6]);
				
				// Check to make sure the proper amount of skill points where
				// used
				if (totalPointsUsed <= ((message.data[7] - 1) * PlayerSkillsAtrributes.skillPointsPerLevel)) {
					ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa
							.setValues(message.data);
				} else {
					ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa
							.setValues(resetValues(message.data));
				}
				
				return new PacketNinjaStatsResponse(ExtendedProperties.get(ctx
						.getServerHandler().playerEntity).psa.getValues());
			} else if (message.command.equals("reset")) {
				ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa
						.setValues(resetValues(message.data));
				return new PacketNinjaStatsResponse(ExtendedProperties.get(ctx
						.getServerHandler().playerEntity).psa.getValues());
			} else {
				return null;
			}
			
		}
		
		private int[] resetValues(int[] oldData) {
			// These values are to reset all values if someone is 'cheating' aka
			// memory hacking
			int[] resetValues = oldData;
			resetValues[0] = 0;
			resetValues[1] = 0;
			resetValues[2] = 0;
			resetValues[3] = 0;
			resetValues[4] = 0;
			resetValues[5] = 0;
			resetValues[6] = 0;
			resetValues[10] = (resetValues[7] - 1)
					* PlayerSkillsAtrributes.skillPointsPerLevel;
			return resetValues;
		}
		
	}
	
	private String	command;
	
	private int[]	data;
	
	// Need a empty constructor just for the network registry to use
	public PacketNinjaStatsRequest() {
		
	}
	
	public PacketNinjaStatsRequest(String command, int[] values) {
		this.command = command;
		this.data = values;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.command = ByteBufUtils.readUTF8String(buf);
		this.data = new int[PlayerSkillsAtrributes.arraySize];
		for (int v = 0; v < this.data.length; v++) {
			this.data[v] = buf.readInt();
		}
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.command);
		for (int v : this.data) {
			buf.writeInt(v);
		}
	}
}
