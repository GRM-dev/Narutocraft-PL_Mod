package pl.grm.narutocraft.items.weapons;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.libs.Materials;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.UtilityNBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Kubiki extends SwordMain {
	public Kubiki() {
		super(Materials.metalshinobi);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,
			List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		par3List.add("Blood from foes stored: "
				+ UtilityNBTHelper.getInt(par1ItemStack, References.ModTag + "kBlood"));
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		if (!par2EntityLivingBase.isEntityAlive()) {
			UtilityNBTHelper.setInteger(par1ItemStack, References.ModTag + "kBlood",
					UtilityNBTHelper.getInt(par1ItemStack, References.ModTag + "kBlood")
							+ ((int) par2EntityLivingBase.getMaxHealth() / 4));
		}
		return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity,
			int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		if ((par2World.getWorldTime() % 65) == 0) {
			int storedBlood = UtilityNBTHelper.getInt(par1ItemStack, References.ModTag
					+ "kBlood");
			if (storedBlood >= 3) {
				if (par1ItemStack.isItemDamaged()) {
					par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
					storedBlood -= 3;
					UtilityNBTHelper.setInteger(par1ItemStack, References.ModTag
							+ "kBlood", storedBlood);
				}
			}
		}
	}
}