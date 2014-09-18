package pl.grm.narutocraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.ByteBufUtils;

public class DataWriter {
	ByteArrayOutputStream bytes;
	DataOutputStream data;

	public DataWriter() {
		this.bytes = new ByteArrayOutputStream();
		this.data = new DataOutputStream(this.bytes);
	}

	public DataWriter add(boolean value) {
		try {
			this.data.writeBoolean(value);
		} catch (IOException e) {
			FMLLog.severe(e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(byte value) {
		try {
			this.data.writeByte(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(byte[] value) {
		try {
			this.data.write(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(double value) {
		try {
			this.data.writeDouble(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(float value) {
		try {
			this.data.writeFloat(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(int value) {
		try {
			this.data.writeInt(Integer.valueOf(value).intValue());
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(int[] value) {
		try {
			this.data.writeInt(Integer.valueOf(value.length).intValue());
			for (int element : value) {
				this.data.writeInt(Integer.valueOf(element).intValue());
			}
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(ItemStack stack) {
		NBTTagCompound compound = new NBTTagCompound();
		stack.writeToNBT(compound);
		return add(compound);
	}

	public DataWriter add(long value) {
		try {
			this.data.writeLong(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(NBTTagCompound compound) {
		try {
			ByteBuf buf = Unpooled.buffer();
			ByteBufUtils.writeTag(buf, compound);
			byte[] arr = buf.array();
			this.data.writeInt(arr.length);
			this.data.write(arr);
		} catch (IOException ex) {
			FMLLog.severe("DataWriter: " + ex.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(short value) {
		try {
			this.data.writeShort(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public DataWriter add(String value) {
		try {
			this.data.writeUTF(value);
		} catch (IOException e) {
			FMLLog.severe("DataWriter: " + e.getMessage(), new Object[0]);
		}
		return this;
	}

	public byte[] generate() {
		return this.bytes.toByteArray();
	}
}
