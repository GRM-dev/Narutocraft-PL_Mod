package pl.grmdev.narutocraft.handlers;

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
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.jutsu.JutsuParams;
import pl.grmdev.narutocraft.libs.network.PacketNinjaAttrSync;
import pl.grmdev.narutocraft.player.ExtendedProperties;

/**
 * Event Handler of NCPL mod
 */
public class NCEventHandler {

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
					event.ammount += ExtendedProperties.get(player).getNinAttrs().getStrength() * 0.15f;
				} else if (event.source.getDamageType() == "arrow") {
					event.ammount += ExtendedProperties.get(player).getNinAttrs().getDexterity() * 0.15f;
				}
			}
		}
		// Defense
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			event.ammount -= ExtendedProperties.get(player).getNinAttrs().getResistance() * 0.25f;
		}
	}

	/** on Entity construct action */
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if ((event.entity instanceof EntityPlayer) && (ExtendedProperties.get((EntityPlayer) event.entity) == null)) {
			ExtendedProperties.register((EntityPlayer) event.entity);
		}
		if ((event.entity instanceof EntityPlayer)
				&& (event.entity.getExtendedProperties(ExtendedProperties.EXT_PROP_NAME) == null)) {
			event.entity.registerExtendedProperties(ExtendedProperties.EXT_PROP_NAME, new ExtendedProperties(
					(EntityPlayer) event.entity));
		}

	}

	/** on Entity Join World action */
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		/*
		 * This loadProxyData should be converted so that it is in the
		 * ClonePlayer event, not the proxy. It works but it is not where it
		 * belongs
		 */
		if (!event.entity.worldObj.isRemote && (event.entity instanceof EntityPlayer)) {
			ExtendedProperties.loadProxyData((EntityPlayer) event.entity);
		}
	}

	/** on Living Death action */
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		/*
		 * This saveProxyData should be converted so that it is in the
		 * ClonePlayer event, not the proxy. It works but it is not where it
		 * belongs
		 */
		if (!event.entity.worldObj.isRemote && (event.entity instanceof EntityPlayer)) {
			ExtendedProperties.saveProxyData((EntityPlayer) event.entity);
		}
		// Adding XP when Killing an enemy, plus update client
		if (event.source.getEntity() instanceof EntityPlayer) {
			ExtendedProperties prop = ExtendedProperties.get((EntityPlayer) event.source.getEntity());
			prop.getNinStats().levelUp((int) event.entityLiving.getMaxHealth() / 3);
			// TODO add stats or attr instead of psa
			// FIXME getValues not exists for both types
			// NarutoCraft.netHandler.sendTo(new
			// PacketNinjaStatsResponse(prop.getNinStats()
			// .getValues()), (EntityPlayerMP) event.source.getEntity());
		}
	}

	/** on Living Fall action */
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			ExtendedProperties props = ExtendedProperties.get((EntityPlayer) event.entity);
			if ((event.distance > 3.0F) && (props.getCurrentChakra() > 0)) {
				System.out.println("[EVENT] Fall distance: " + event.distance);
				System.out.println("[EVENT] Current chakra: " + props.getCurrentChakra());
				float reduceby = props.getCurrentChakra() < (event.distance - 3.0F)
						? props.getCurrentChakra()
						: (event.distance - 3.0F);
				event.distance -= reduceby;
				props.consumeChakra((int) reduceby);
			}
		}
	}

	/** on Living Update action **/
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			// ExtendedPlayer.get(player).onUpdate();
			if (ExtendedProperties.get(player).ninjaRun && player.isSneaking()) {
				if (event.entity.worldObj.getWorldTime() % 30 == 0) {
					if (!ExtendedProperties.get(player).consumeChakra(1)) {
						ExtendedProperties.get(player).ninjaRun = false;
					}
				}
				if (player.capabilities.getWalkSpeed() == 0.1f) {
					ExtendedProperties.get(player).updateMoveSpeed();
				}
			} else {
				if (player.capabilities.getWalkSpeed() != 0.1f) {
					ExtendedProperties.get(player).resetMoveSpeed();
				}
			}
			if (event.entity.worldObj.getWorldTime() % 30 == 0) ExtendedProperties.get(player).setMaxChakra(false);
			if ((event.entity.worldObj.getWorldTime() % (150 - ExtendedProperties.get(player).getNinAttrs()
					.getChakraRegenMod())) == 0) {
				ExtendedProperties.get(player).regenChakra(1);
			}
			if (player.isPlayerFullyAsleep()) {
				System.out.println("After a full night's rest, you feel refreshed!");
				ExtendedProperties.get(player).replenishChakra();
			}
		}
	}

	/** on Living Update action */
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
			if ((heldItem != null) && (heldItem.getItem() == JutsuParams.KAWARIMINOJUTSU.getJutsu())) // Testing
			{
				player.capabilities.allowFlying = true;
			} else {
				player.capabilities.allowFlying = player.capabilities.isCreativeMode ? true : false;
			}
		}
	}

	/** When player dies, ninja stats transfer over **/
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		if (event.wasDeath) {
			if (!event.entityPlayer.worldObj.isRemote) {
				ExtendedProperties deadPlayer = ExtendedProperties.get(event.original);
				ExtendedProperties clonePlayer = ExtendedProperties.get(event.entityPlayer);
				// FIXME method getValues not exists
				// clonePlayer.psa.setValues(deadPlayer.psa.getValues());
				clonePlayer.getNinAttrs().setInfo(deadPlayer.getNinAttrs().getInfo());
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
			NarutoCraft.netHandler.sendTo(new PacketNinjaAttrSync(ExtendedProperties.get((EntityPlayer) e.entity)
					.getNinAttrs().getInfo()), (EntityPlayerMP) e.entity);
			// FIXME as other fixers
			// NarutoCraft.netHandler.sendTo(
			// new PacketNinjaStatsResponse(
			// ExtendedProperties.get((EntityPlayer) e.entity).psa.getValues()),
			// (EntityPlayerMP) e.entity);
		}
	}
}