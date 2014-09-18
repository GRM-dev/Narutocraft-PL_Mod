package pl.grm.narutocraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.ByteBufUtils;

public class DataReader {

	ByteArrayInputStream input;
	DataInputStream dataStream;
	public byte ID;

	public DataReader(byte[] data) {
		this(data, true);
	}

	public DataReader(byte[] data, boolean getID) {
		this.input = new ByteArrayInputStream(data);
		this.dataStream = new DataInputStream(this.input);
		if (getID) {
			try {
				this.ID = this.dataStream.readByte();
			} catch (IOException e) {
				FMLLog.severe("DataReader (getID): " + e.toString(),
						new Object[0]);
				e.printStackTrace();
			}
		}
	}

	public boolean getBoolean() {
		boolean value = false;
		try {
			value = this.dataStream.readBoolean();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getBoolean): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public byte getByte() {
		byte value = 0;
		try {
			value = this.dataStream.readByte();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getByte): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public double getDouble() {
		double value = 0.0D;
		try {
			value = this.dataStream.readDouble();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getDouble): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public float getFloat() {
		float value = 0.0F;
		try {
			value = this.dataStream.readFloat();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getFloat): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public int getInt() {
		int value = 0;
		try {
			value = this.dataStream.readInt();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getInt): " + e.toString(), new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public int[] getIntArray() {
		try {
			int[] arr = new int[this.dataStream.readInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = this.dataStream.readInt();
			}
			return arr;
		} catch (IOException e) {
			FMLLog.severe("DataReader (getIntArray): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return new int[0];
	}

	public ItemStack getItemStack() {
		NBTTagCompound compound = getNBTTagCompound();
		if (compound == null) {
			return null;
		}
		ItemStack stack = ItemStack.loadItemStackFromNBT(compound);
		return stack;
	}

	public long getLong() {
		long value = 0L;
		try {
			value = this.dataStream.readLong();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getLong): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public NBTTagCompound getNBTTagCompound() {
		NBTTagCompound data = null;
		try {
			int len = this.dataStream.readInt();
			byte[] bytes = new byte[len];
			this.dataStream.read(bytes);
			ByteBuf buf = Unpooled.copiedBuffer(bytes);
			data = ByteBufUtils.readTag(buf);
		} catch (IOException e) {
			FMLLog.severe("DataReader (getNBTTagCompound): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return data;
	}

	public byte[] getRemainingBytes() {
		byte[] remaining = null;
		try {
			remaining = new byte[this.dataStream.available()];
			this.dataStream.read(remaining);
		} catch (IOException e) {
			FMLLog.severe("DataReader (getRemainingBytes): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return remaining;
	}

	public short getShort() {
		short value = 0;
		try {
			value = this.dataStream.readShort();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getShort): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}

	public String getString() {
		String value = "";
		try {
			value = this.dataStream.readUTF();
		} catch (IOException e) {
			FMLLog.severe("DataReader (getString): " + e.toString(),
					new Object[0]);
			e.printStackTrace();
		}
		return value;
	}
}
