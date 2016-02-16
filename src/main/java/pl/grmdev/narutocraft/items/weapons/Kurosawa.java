package pl.grmdev.narutocraft.items.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.libs.config.Materials;
import pl.grmdev.narutocraft.libs.network.PacketKurosawaAttack;

public class Kurosawa extends SwordMain
{
	private boolean cooldown = false;
	private int coolingTime = 0;
	
	public Kurosawa()
	{
		super(Materials.metalsamurajow);
		this.setMaxDamage(-1);
		this.setAttackDamage(30);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if(coolingTime == 1200) cooldown = false;
		if(cooldown) coolingTime += 1;		
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		super.onItemRightClick(stack, world, player);
		
		MovingObjectPosition object = Minecraft.getMinecraft().objectMouseOver;
			
		if(object.typeOfHit.ordinal() == 2)
		{	
			NarutoCraft.netHandler.sendToServer(new PacketKurosawaAttack(((EntityLivingBase)object.entityHit).getEntityId()));								
		}
		
		return stack;
	}
	
	public void setCooldown()
	{
		this.coolingTime = 0;
		this.cooldown = true;
	}
	
	public boolean getCooldown()
	{
		return this.cooldown;
	}
}