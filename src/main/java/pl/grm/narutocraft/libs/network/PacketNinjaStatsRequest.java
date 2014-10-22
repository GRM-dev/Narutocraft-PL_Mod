package pl.grm.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import pl.grm.narutocraft.stats.ExtendedProperties;
import pl.grm.narutocraft.stats.PlayerSkillsAtrributes;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaStatsRequest implements IMessage {
	private String	command;
	private int[]	data;
	
	public static class PacketNinjaStatsRequestHandler implements IMessageHandler<PacketNinjaStatsRequest, IMessage> {
		
		@Override
		public IMessage onMessage(PacketNinjaStatsRequest message, MessageContext ctx) {
			if (message.command.equals("get")) {
				return new PacketNinjaStatsResponse(
						ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa.getValues());
				
			} else if (message.command.equals("set")) {
				PlayerSkillsAtrributes psa = ExtendedProperties
						.get(ctx.getServerHandler().playerEntity).psa;
				/*
				 * strUpg, agiUpg, dexUpg, resUpg,
				 * epmUpg, chaUpg, crbUpg, stbUpg, stfUpg, stgUpg,
				 * stiUpg, stnUpg, sttUpg
				 */
				psa.setStrength(psa.getStrength() + message.data[0]);
				psa.setAgility(psa.getAgility() + message.data[1]);
				psa.setDexterity(psa.getDexterity() + message.data[2]);
				psa.setResistance(psa.getResistance() + message.data[3]);
				
				psa.setElementPowerMod(psa.getElementPowerMod() + message.data[4]);
				psa.setMaxChakraMod(psa.getMaxChakraMod() + message.data[5]);
				psa.setChakraRegenMod(psa.getChakraRegenMod() + message.data[6]);
				
				psa.setBukiTreeLevel(psa.getBukiTreeLevel() + message.data[7]);
				psa.setFuuinTreeLevel(psa.getFuuinTreeLevel() + message.data[8]);
				psa.setGenTreeLevel(psa.getGenTreeLevel() + message.data[9]);
				psa.setIryoTreeLevel(psa.getIryoTreeLevel() + message.data[10]);
				psa.setNinTreeLevel(psa.getNinTreeLevel() + message.data[11]);
				psa.setTaiTreeLevel(psa.getTaiTreeLevel() + message.data[12]);
				psa.skillPoints = message.data[13];
				
				return new PacketNinjaStatsResponse(psa.getValues());
			} else if (message.command.equals("reset")) {
				ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa
						.setValues(resetValues(message.data));
				return new PacketNinjaStatsResponse(
						ExtendedProperties.get(ctx.getServerHandler().playerEntity).psa.getValues());
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
			resetValues[10] = (resetValues[7] - 1) * PlayerSkillsAtrributes.skillPointsPerLevel;
			return resetValues;
		}
	}
	
	// Need a empty constructor just for the network registry to use
	public PacketNinjaStatsRequest() {
		
	}
	
	public PacketNinjaStatsRequest(String command, int[] values) {
		this.command = command;
		this.data = values;
	}
	
	public PacketNinjaStatsRequest(String command) {
		this.command = command;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.command = ByteBufUtils.readUTF8String(buf);
		this.data = new int[PlayerSkillsAtrributes.arraySize];
		for (int v = 0; v < this.data.length; v++) {
			try {
				this.data[v] = buf.readInt();
			}
			catch (IndexOutOfBoundsException e) {
				break;
			}
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
