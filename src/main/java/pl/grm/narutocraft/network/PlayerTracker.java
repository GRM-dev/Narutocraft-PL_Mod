package pl.grm.narutocraft.network;

import java.util.HashMap;
import java.util.TreeMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import pl.grm.narutocraft.handlers.NetHandler;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.skilltrees.SkillTreeManager;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PlayerTracker {
	public static HashMap<String, NBTTagCompound>				storedExtProps_death;
	
	public static HashMap<String, NBTTagCompound>				spellKnowledgeStorage_death;
	
	public static HashMap<String, NBTTagCompound>				storedExtProps_dimension;
	
	public static HashMap<String, NBTTagCompound>				jutsuKnowledgeStorage_dimension;
	
	public static HashMap<String, HashMap<Integer, ItemStack>>	soulbound_Storage;
	private TreeMap<String, Integer>							aals;
	private TreeMap<String, String>								clls;
	private TreeMap<String, Integer>							cldm;
	
	public PlayerTracker() {
		storedExtProps_death = new HashMap<String, NBTTagCompound>();
		storedExtProps_dimension = new HashMap<String, NBTTagCompound>();
		spellKnowledgeStorage_death = new HashMap<String, NBTTagCompound>();
		jutsuKnowledgeStorage_dimension = new HashMap<String, NBTTagCompound>();
		
		soulbound_Storage = new HashMap<String, HashMap<Integer, ItemStack>>();
		
		this.aals = new TreeMap<String, Integer>();
		this.clls = new TreeMap<String, String>();
		this.cldm = new TreeMap<String, Integer>();
	}
	
	public static void storeExtendedPlayerForDimensionChange(EntityPlayer player) {
		if (!storedExtProps_death.containsKey(player.getDisplayName())) {
			if (storedExtProps_dimension.containsKey(player.getDisplayName())) {
				storedExtProps_dimension.remove(player.getDisplayName());
			}
			NBTTagCompound saveExprop = new NBTTagCompound();
			ExtendedProperties.For(player).saveNBTData(saveExprop);
			
			storedExtProps_dimension.put(player.getDisplayName(), saveExprop);
		}
		if (!spellKnowledgeStorage_death.containsKey(player.getDisplayName())) {
			if (jutsuKnowledgeStorage_dimension.containsKey(player.getDisplayName())) {
				jutsuKnowledgeStorage_dimension.remove(player.getDisplayName());
			}
			NBTTagCompound jutsuKnowledge = new NBTTagCompound();
			// Jutsu.For(player).saveNBTData(jutsuKnowledge);
			
			jutsuKnowledgeStorage_dimension.put(player.getDisplayName(), jutsuKnowledge);
		}
	}
	
	public static void storeExtendedPlayerForRespawn(EntityPlayer player) {
		if (storedExtProps_death.containsKey(player.getDisplayName())) {
			storedExtProps_death.remove(player.getDisplayName());
		}
		NBTTagCompound save = new NBTTagCompound();
		ExtendedProperties.For(player).saveNBTData(save);
		
		storedExtProps_death.put(player.getDisplayName(), save);
		
		NBTTagCompound saveSpellKnowledge = new NBTTagCompound();
		// Jutsu.For(player).saveNBTData(saveSpellKnowledge);
		
		spellKnowledgeStorage_death.put(player.getDisplayName(), saveSpellKnowledge);
	}
	
	public static void storeSoulboundItemForRespawn(EntityPlayer player, ItemStack stack) {
		if (!soulbound_Storage.containsKey(player.getDisplayName())) { return; }
		HashMap<Integer, ItemStack> soulboundItems = soulbound_Storage.get(player
				.getDisplayName());
		
		int slotTest = 0;
		while (soulboundItems.containsKey(Integer.valueOf(slotTest))) {
			slotTest++;
			if (slotTest == player.inventory.mainInventory.length) {
				slotTest += player.inventory.armorInventory.length;
			}
		}
		soulboundItems.put(Integer.valueOf(slotTest), stack);
	}
	
	public static void storeSoulboundItemsForRespawn(EntityPlayer player) {
		if (soulbound_Storage.containsKey(player.getDisplayName())) {
			soulbound_Storage.remove(player.getDisplayName());
		}
		HashMap<Integer, ItemStack> soulboundItems = new HashMap<Integer, ItemStack>();
		
		for (ItemStack stack : player.inventory.armorInventory) {
			// {
			// int soulbound_level = EnchantmentHelper.getEnchantmentLevel(
			// NCPLEnchantments.soulbound.effectId, stack);
			// if ((soulbound_level > 0)
			// || (ArmorHelper.isInfusionPreset(stack, "soulbound"))) {
			// soulboundItems.put(
			// Integer.valueOf(slotCount
			// + player.inventory.mainInventory.length),
			// stack.copy());
			// player.inventory.setInventorySlotContents(slotCount
			// + player.inventory.mainInventory.length, null);
			// }
			// slotCount++;
			// }
			soulbound_Storage.put(player.getDisplayName(), soulboundItems);
		}
	}
	
	public int getAAL(EntityPlayer thePlayer) {
		try {
			thePlayer.getDisplayName();
		}
		catch (Throwable t) {
			return 0;
		}
		if ((this.aals == null) || (this.clls == null)) {
			populateAALList();
		}
		if (this.aals.containsKey(thePlayer.getDisplayName().toLowerCase())) { return this.aals
				.get(thePlayer.getDisplayName().toLowerCase()).intValue(); }
		return 0;
	}
	
	public int getCLDM(String userName) {
		return this.cldm.get(userName.toLowerCase()).intValue();
	}
	
	public String getCLF(String userName) {
		return this.clls.get(userName.toLowerCase());
	}
	
	public boolean hasAA(EntityPlayer entity) {
		return getAAL(entity) > 0;
	}
	
	public boolean hasCLDM(String userName) {
		return this.cldm.containsKey(userName.toLowerCase());
	}
	
	public boolean hasCLS(String userName) {
		return this.clls.containsKey(userName.toLowerCase());
	}
	
	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.player.worldObj.isRemote) {
			storeExtendedPlayerForDimensionChange(event.player);
		}
	}
	
	public void onPlayerDeath(EntityPlayer player) {
		storeExtendedPlayerForRespawn(player);
		storeSoulboundItemsForRespawn(player);
	}
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if (hasAA(event.player)) {
			NetHandler.INSTANCE.requestClientAuras((EntityPlayerMP) event.player);
		}
		SkillTreeManager.instance.getLockedJutsusIDs();
		
		DataWriter writer = new DataWriter();
		// writer.add(NarutoCraft.config.getSkillTreeTierCap())
		// .add(disabledSkills);
		byte[] data = writer.generate();
		
		NetHandler.INSTANCE.syncLoginData((EntityPlayerMP) event.player, data);
		if (ServerTickHandler.lastWorldName != null) {
			NetHandler.INSTANCE.syncWorldName((EntityPlayerMP) event.player,
					ServerTickHandler.lastWorldName);
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
		if (!event.player.worldObj.isRemote) {}
	}
	
	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
		if (storedExtProps_death.containsKey(event.player.getDisplayName())) {
			NBTTagCompound stored = storedExtProps_death.get(event.player
					.getDisplayName());
			storedExtProps_death.remove(event.player.getDisplayName());
			
			ExtendedProperties.For(event.player).loadNBTData(stored);
		} else if (storedExtProps_dimension.containsKey(event.player.getDisplayName())) {
			NBTTagCompound stored = storedExtProps_dimension.get(event.player
					.getDisplayName());
			storedExtProps_dimension.remove(event.player.getDisplayName());
			
			ExtendedProperties.For(event.player).loadNBTData(stored);
		}
		if (spellKnowledgeStorage_death.containsKey(event.player.getDisplayName())) {
			spellKnowledgeStorage_death.get(event.player.getDisplayName());
			spellKnowledgeStorage_death.remove(event.player.getDisplayName());
			
			// Jutsu.For(event.player).loadNBTData(stored);
		} else if (jutsuKnowledgeStorage_dimension.containsKey(event.player
				.getDisplayName())) {
			jutsuKnowledgeStorage_dimension.get(event.player.getDisplayName());
			jutsuKnowledgeStorage_dimension.remove(event.player.getDisplayName());
			
			// Jutsu.For(event.player).loadNBTData(stored);
		}
		HashMap<Integer, ItemStack> soulboundItems;
		if (soulbound_Storage.containsKey(event.player.getDisplayName())) {
			soulboundItems = soulbound_Storage.get(event.player.getDisplayName());
			for (Integer i : soulboundItems.keySet()) {
				if (i.intValue() < event.player.inventory.getSizeInventory()) {
					event.player.inventory.setInventorySlotContents(i.intValue(),
							soulboundItems.get(i));
				} else {
					event.player.entityDropItem(soulboundItems.get(i), 0.0F);
				}
			}
		}
	}
	
	public void postInit() {
		populateAALList();
	}
	
	private void populateAALList() {
		this.aals = new TreeMap<String, Integer>();
		this.clls = new TreeMap<String, String>();
		this.cldm = new TreeMap<String, Integer>();
		
		char[] dl = {
				'h', 't', 't', 'p', ':', '/', '/', 'a', 'r', 'c', 'a', 'n', 'a', 'c',
				'r', 'a', 'f', 't', '.', 'q', 'o', 'r', 'c', 'o', 'n', 'c', 'e', 'p',
				't', '.', 'c', 'o', 'm', '/', 'm', 'c', '/', 'D', 'G', 'S', 'V', 'N',
				'T', '3', '5', '2', '.', 't', 'x', 't'};
		try {
			String s = WebUtils.sendPost(new String(dl), new HashMap<String, String>());
			String[] lines = s.replace("\r\n", "\n").split("\n");
			for (String line : lines) {
				if (line.startsWith(":AL")) {
					String[] vals = line.replace(":AL", "").split(",");
					if (vals.length == 2) {
						this.aals.put(vals[0].toLowerCase(),
								Integer.valueOf(Integer.parseInt(vals[1])));
					}
				} else if (line.startsWith(":CL")) {
					String[] vals = line.replace(":CL", "").split(",");
					if (vals.length == 3) {
						this.clls.put(vals[0].toLowerCase(), vals[1]);
						int cdm = 0;
						try {
							cdm = Integer.parseInt(vals[2]);
						}
						catch (Throwable t) {
							throw new Error(t.getMessage());
						}
						this.cldm.put(vals[0].toLowerCase(), Integer.valueOf(cdm));
					}
				}
			}
		}
		catch (Throwable t) {
			throw new Error(t.getMessage());
		}
	}
}
