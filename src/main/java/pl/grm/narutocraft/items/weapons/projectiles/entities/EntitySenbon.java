package pl.grm.narutocraft.items.weapons.projectiles.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.grm.narutocraft.registry.RegItems;

/**
 * Senbon Entity
 *
 * @author Admaster
 */
public class EntitySenbon extends Entity implements IProjectile {

	private int d = -1;
	private int e = -1;
	private int f = -1;
	private Block field_145790_g;
	private int inData;
	private boolean inGround;
	public int canBePickedUp;
	public static int SenbonShake;
	public Entity shootingEntity;
	private int ticksInGround;
	private int ticksInAir;
	private double damage = 2.0D;

	public EntitySenbon(World par1World) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
	}

	/**
	 * @param par1World
	 *            World
	 * @param par2
	 *            x
	 * @param par4
	 *            y
	 * @param par6
	 *            z
	 */
	public EntitySenbon(World par1World, double par2, double par4, double par6) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(par2, par4, par6);
	}

	public EntitySenbon(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase,
			float par4, float par5) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = par2EntityLivingBase;

		if (par2EntityLivingBase instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}

		this.posY = (par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight()) - 0.10000000149011612D;
		double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
		double d1 = (par3EntityLivingBase.getMountedYOffset() + (par3EntityLivingBase.height / 3.0F)) - this.posY;
		double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
		double d3 = MathHelper.sqrt_double((d0 * d0) + (d2 * d2));

		if (d3 >= 1.0E-7D) {
			float f2 = (float) ((Math.atan2(d2, d0) * 180.0D) / Math.PI) - 90.0F;
			float f3 = (float) (-((Math.atan2(d1, d3) * 180.0D) / Math.PI));
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
			float f4 = (float) d3 * 0.2F;
			this.setThrowableHeading(d0, d1 + f4, d2, par4, par5);
		}
	}

	public EntitySenbon(World par1World, EntityLivingBase par2EntityLivingBase, float par3) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = par2EntityLivingBase;

		if (par2EntityLivingBase instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}

		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(par2EntityLivingBase.posX,
				par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ,
				par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
		this.posX -= MathHelper.cos((this.rotationYaw / 180.0F) * (float) Math.PI) * 0.16F;
		this.posY -= 0.10000000149011612D;
		this.posZ -= MathHelper.sin((this.rotationYaw / 180.0F) * (float) Math.PI) * 0.16F;
		this.setPosition(this.posX, this.posY, this.posZ);
		this.motionX = -MathHelper.sin((this.rotationYaw / 180.0F) * (float) Math.PI)
				* MathHelper.cos((this.rotationPitch / 180.0F) * (float) Math.PI);
		this.motionZ = MathHelper.cos((this.rotationYaw / 180.0F) * (float) Math.PI)
				* MathHelper.cos((this.rotationPitch / 180.0F) * (float) Math.PI);
		this.motionY = (-MathHelper.sin((this.rotationPitch / 180.0F) * (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
	}

	@Override
	public boolean canAttackWithItem() {
		return true;
	}

	public double getDamage() {
		return this.damage;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (!this.worldObj.isRemote && this.inGround && (EntitySenbon.SenbonShake <= 0)) {
			boolean flag = (this.canBePickedUp == 1)
					|| ((this.canBePickedUp == 2) && par1EntityPlayer.capabilities.isCreativeMode);

			if ((this.canBePickedUp == 1)
					&& !par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegItems.Senbon, 1))) {
				flag = false;
			}

			if (flag) {
				this.playSound("random.pop", 0.2F,
						(((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				par1EntityPlayer.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		this.d = par1NBTTagCompound.getShort("xTile");
		this.e = par1NBTTagCompound.getShort("yTile");
		this.f = par1NBTTagCompound.getShort("zTile");
		this.ticksInGround = par1NBTTagCompound.getShort("life");
		this.field_145790_g = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 255);
		this.inData = par1NBTTagCompound.getByte("inData") & 255;
		EntitySenbon.SenbonShake = par1NBTTagCompound.getByte("shake") & 255;
		this.inGround = par1NBTTagCompound.getByte("inGround") == 1;

		if (par1NBTTagCompound.hasKey("damage", 99)) {
			this.damage = par1NBTTagCompound.getDouble("damage");
		}

		if (par1NBTTagCompound.hasKey("pickup", 99)) {
			this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
		} else if (par1NBTTagCompound.hasKey("player", 99)) {
			this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
		}
	}

	public void setDamage(double par1) {
		this.damage = par1;
	}

	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z
	 * direction.
	 */
	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
		float f2 = MathHelper.sqrt_double((par1 * par1) + (par3 * par3) + (par5 * par5));
		par1 /= f2;
		par3 /= f2;
		par5 /= f2;
		par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par1 *= par7;
		par3 *= par7;
		par5 *= par7;
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;
		float f3 = MathHelper.sqrt_double((par1 * par1) + (par5 * par5));
		this.prevRotationYaw = this.rotationYaw = (float) ((Math.atan2(par1, par5) * 180.0D) / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) ((Math.atan2(par3, f3) * 180.0D) / Math.PI);
		this.ticksInGround = 0;
	}

	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void setVelocity(double par1, double par3, double par5) {
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;

		if ((this.prevRotationPitch == 0.0F) && (this.prevRotationYaw == 0.0F)) {
			float f = MathHelper.sqrt_double((par1 * par1) + (par5 * par5));
			this.prevRotationYaw = this.rotationYaw = (float) ((Math.atan2(par1, par5) * 180.0D) / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) ((Math.atan2(par3, f) * 180.0D) / Math.PI);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("xTile", (short) this.d);
		par1NBTTagCompound.setShort("yTile", (short) this.e);
		par1NBTTagCompound.setShort("zTile", (short) this.f);
		par1NBTTagCompound.setShort("life", (short) this.ticksInGround);
		par1NBTTagCompound.setByte("inTile", (byte) Block.getIdFromBlock(this.field_145790_g));
		par1NBTTagCompound.setByte("inData", (byte) this.inData);
		par1NBTTagCompound.setByte("shake", (byte) EntitySenbon.SenbonShake);
		par1NBTTagCompound.setByte("inGround", (byte) (this.inGround ? 1 : 0));
		par1NBTTagCompound.setByte("pickup", (byte) this.canBePickedUp);
		par1NBTTagCompound.setDouble("damage", this.damage);
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}
}
