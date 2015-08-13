package pl.grm.narutocraft.libs.network;
 
import javax.vecmath.Vector3f;

import pl.grm.narutocraft.items.weapons.Kurosawa;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class PacketKurosawaAttack implements IMessage, IMessageHandler<PacketKurosawaAttack, IMessage>
{
	int targetID;
 
	public PacketKurosawaAttack() {}
 
	public PacketKurosawaAttack(int target)
	{
		this.targetID = target;
	}
 
	public void toBytes(ByteBuf target)
	{
		target.writeInt(targetID);	
	}
 
	public void fromBytes(ByteBuf dat)
	{
		targetID = dat.readInt();
	}
 
	@Override
	public IMessage onMessage(PacketKurosawaAttack message, MessageContext ctx)
	{
		EntityPlayer player = ctx.getServerHandler().playerEntity;
		Kurosawa item = (Kurosawa) player.getHeldItem().getItem();
		
		if(!item.getCooldown())
		{
			World world = player.worldObj;
			EntityLivingBase target = (EntityLivingBase) world.getEntityByID(message.targetID);
			Vec3 targetPos = target.getPositionVector();
			Vec3 attackerPos = player.getPositionVector();
			
			Vec3 distance = targetPos.subtractReverse(attackerPos).normalize();
			distance = new Vec3(distance.xCoord * 3, distance.yCoord * 3, distance.zCoord * 3);
	
			player.setPositionAndRotation(target.posX - distance.xCoord, target.posY - distance.yCoord, target.posZ - distance.zCoord, player.rotationYaw+ 180, player.rotationPitch);			
			player.setRotationYawHead(player.rotationYawHead + 180);
			player.cameraPitch += 180;
			player.setPositionAndUpdate(target.posX - distance.xCoord, target.posY - distance.yCoord, target.posZ - distance.zCoord);
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), 44);
			item.setCooldown();
		}
		return null;
	} 
} 