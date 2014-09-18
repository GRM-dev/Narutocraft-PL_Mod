package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.network.PacketNinjaStatsResponse;
import pl.grm.narutocraft.registry.RegJutsus;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Event Handler of NCPL mod
 *
 * @author Admaster
 *
 */
public class NCPLEventHandler {

	/** Attack and Defense Bonus **/
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onDamage(LivingHurtEvent event) {
		// Offense
		if (event.source instanceof EntityDamageSource) {
			EntityDamageSource source = (EntityDamageSource) event.source;
			if (source.getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) source.getEntity();

				if (event.source.getDamageType() == "player")// physical attack
				{
					event.ammount += ExtendedProperties.get(player).psa
							.getStrength() * 0.15f;
				} else if (event.source.getDamageType() == "arrow") {
					event.ammount += ExtendedProperties.get(player).psa
							.getDexterity() * 0.15f;
				}
			}
		}

		// Defense
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			event.ammount -= ExtendedProperties.get(player).psa.getResistance() * 0.25f;
		}
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if ((event.entity instanceof EntityPlayer)
				&& (ExtendedProperties.get((EntityPlayer) event.entity) == null)) {
			ExtendedProperties.register((EntityPlayer) event.entity);
		}
		if ((event.entity instanceof EntityPlayer)
				&& (event.entity
						.getExtendedProperties(ExtendedProperties.EXT_PROP_NAME) == null)) {
			event.entity.registerExtendedProperties(
					ExtendedProperties.EXT_PROP_NAME, new ExtendedProperties(
							(EntityPlayer) event.entity));
		}

	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		/*
		 * This loadProxyData should be converted so that it is in the
		 * ClonePlayer event, not the proxy. It works but it is not where it
		 * belongs
		 */
		if (!event.entity.worldObj.isRemote
				&& (event.entity instanceof EntityPlayer)) {
			ExtendedProperties.loadProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		/*
		 * This saveProxyData should be converted so that it is in the
		 * ClonePlayer event, not the proxy. It works but it is not where it
		 * belongs
		 */
		if (!event.entity.worldObj.isRemote
				&& (event.entity instanceof EntityPlayer)) {
			ExtendedProperties.saveProxyData((EntityPlayer) event.entity);
		}
		// Adding XP when Killing an enemy, plus update client
		if (event.source.getEntity() instanceof EntityPlayer) {
			ExtendedProperties prop = ExtendedProperties
					.get((EntityPlayer) event.source.getEntity());
			prop.psa.levelUp((int) event.entityLiving.getMaxHealth() / 3);
			NarutoCraft.netHandler.sendTo(
					new PacketNinjaStatsResponse(prop.psa.getValues()),
					(EntityPlayerMP) event.source.getEntity());
		}
	}

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			ExtendedProperties props = ExtendedProperties
					.get((EntityPlayer) event.entity);
			if ((event.distance > 3.0F) && (props.getCurrentChakra() > 0)) {
				System.out.println("[EVENT] Fall distance: " + event.distance);
				System.out.println("[EVENT] Current chakra: "
						+ props.getCurrentChakra());
				float reduceby = props.getCurrentChakra() < (event.distance - 3.0F)
						? props.getCurrentChakra()
						: (event.distance - 3.0F);
				event.distance -= reduceby;

				props.consumeChakra((int) reduceby);

				System.out.println("[EVENT] Adjusted fall distance: "
						+ event.distance);
			}
		}
	}

	/** Refresh chakra by sleeping, and normal chakra regen **/
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			// ExtendedPlayer.get(player).onUpdate();
			if ((event.entity.worldObj.getWorldTime() % (150 - ExtendedProperties
					.get(player).psa.getChakraRegenBonus())) == 0) {
				ExtendedProperties.get(player).regenChakra(1);
			}
			if (player.isPlayerFullyAsleep()) {
				System.out
						.println("After a full night's rest, you feel refreshed!");
				ExtendedProperties.get(player).replenishChakra();
			}
		}
	}

	/** Testing flight by holding jutsu **/
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
			if ((heldItem != null)
					&& (heldItem.getItem() == RegJutsus.KawarimiNoJutsu)) // Testing
			{
				player.capabilities.allowFlying = true;
			} else {
				player.capabilities.allowFlying = player.capabilities.isCreativeMode
						? true
						: false;
			}
		}
	}

	/** When player dies, ninja stats transfer over **/
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		if (event.wasDeath) {
			if (!event.entityPlayer.worldObj.isRemote) {
				ExtendedProperties deadPlayer = ExtendedProperties
						.get(event.original);
				ExtendedProperties clonePlayer = ExtendedProperties
						.get(event.entityPlayer);
				clonePlayer.psa.setValues(deadPlayer.psa.getValues());
			}
		}
	}

	/**
	 * When a player joins game, changes from Overworld to Nether or End update
	 * client info
	 **/
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent e) {
		if ((e.entity instanceof EntityPlayer) && !e.world.isRemote) {
			NarutoCraft.netHandler.sendTo(
					new PacketNinjaStatsResponse(ExtendedProperties
							.get((EntityPlayer) e.entity).psa.getValues()),
					(EntityPlayerMP) e.entity);
		}
	}
}