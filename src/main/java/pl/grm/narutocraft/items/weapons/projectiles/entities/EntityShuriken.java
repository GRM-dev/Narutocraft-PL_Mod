package pl.grm.narutocraft.items.weapons.projectiles.entities;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import pl.grm.narutocraft.libs.DamSource;
import pl.grm.narutocraft.registry.RegWeapons;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityShuriken extends EntityArrow implements IProjectile {
	private int		d		= -1;
	private int		e		= -1;
	private int		f		= -1;
	private Block	contactBlock;
	private int		inData;
	public boolean	inGround;
	private int		ticksInGround;
	private int		ticksInAir;
	private double	damage	= 2.0D;
	
	public EntityShuriken(World par1World) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
	}
	
	/**
	 * Constructor of entity
	 *
	 * @param par1World
	 *            World
	 * @param par2
	 *            x
	 * @param par4
	 *            y
	 * @param par6
	 *            z
	 */
	public EntityShuriken(World par1World, double par2, double par4, double par6) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(par2, par4, par6);
		this.yOffset = 0.0F;
	}
	
	public EntityShuriken(World par1World, EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase, float par4, float par5) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = par2EntityLivingBase;
		
		if (par2EntityLivingBase instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}
		
		this.posY = (par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight()) - 0.10000000149011612D;
		double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
		double d1 = (par3EntityLivingBase.boundingBox.minY + (par3EntityLivingBase.height / 3.0F))
				- this.posY;
		double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
		double d3 = MathHelper.sqrt_double((d0 * d0) + (d2 * d2));
		
		if (d3 >= 1.0E-7D) {
			float f2 = (float) ((Math.atan2(d2, d0) * 180.0D) / Math.PI) - 90.0F;
			float f3 = (float) (-((Math.atan2(d1, d3) * 180.0D) / Math.PI));
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY,
					par2EntityLivingBase.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			float f4 = (float) d3 * 0.2F;
			this.setThrowableHeading(d0, d1 + f4, d2, par4, par5);
		}
	}
	
	public EntityShuriken(World par1World, EntityLivingBase par2EntityLivingBase,
			float par3) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = par2EntityLivingBase;
		
		if (par2EntityLivingBase instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}
		
		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(par2EntityLivingBase.posX, par2EntityLivingBase.posY
				+ par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ,
				par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
		this.posX -= MathHelper.cos((this.rotationYaw / 180.0F) * (float) Math.PI) * 0.16F;
		this.posY -= 0.10000000149011612D;
		this.posZ -= MathHelper.sin((this.rotationYaw / 180.0F) * (float) Math.PI) * 0.16F;
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = -MathHelper.sin((this.rotationYaw / 180.0F) * (float) Math.PI)
				* MathHelper.cos((this.rotationPitch / 180.0F) * (float) Math.PI);
		this.motionZ = MathHelper.cos((this.rotationYaw / 180.0F) * (float) Math.PI)
				* MathHelper.cos((this.rotationPitch / 180.0F) * (float) Math.PI);
		this.motionY = (-MathHelper.sin((this.rotationPitch / 180.0F) * (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F,
				1.0F);
	}
	
	@Override
	public boolean canAttackWithItem() {
		return true;
	}
	
	@Override
	public double getDamage() {
		return this.damage;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0F;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (!this.worldObj.isRemote && this.inGround) {
			boolean flag = (this.canBePickedUp == 1)
					|| ((this.canBePickedUp == 2) && par1EntityPlayer.capabilities.isCreativeMode);
			
			if ((this.canBePickedUp == 1)
					&& !par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(
							RegWeapons.Shuriken, 1))) {
				flag = false;
			}
			
			if (flag) {
				this.playSound(
						"random.pop",
						0.2F,
						(((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				par1EntityPlayer.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		
		if ((this.prevRotationPitch == 0.0F) && (this.prevRotationYaw == 0.0F)) {
			float f = MathHelper.sqrt_double((this.motionX * this.motionX)
					+ (this.motionZ * this.motionZ));
			this.prevRotationYaw = this.rotationYaw = (float) ((Math.atan2(this.motionX,
					this.motionZ) * 180.0D) / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) ((Math.atan2(
					this.motionY, f) * 180.0D) / Math.PI);
		}
		
		Block block = this.worldObj.getBlock(this.d, this.e, this.f);
		
		if (block.getMaterial() != Material.air) {
			block.setBlockBoundsBasedOnState(this.worldObj, this.d, this.e, this.f);
			AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(
					this.worldObj, this.d, this.e, this.f);
			
			if ((axisalignedbb != null)
					&& axisalignedbb.isVecInside(this.worldObj.getWorldVec3Pool()
							.getVecFromPool(this.posX, this.posY, this.posZ))) {
				this.inGround = true;
			}
		}
		
		if (this.inGround) {
			int j = this.worldObj.getBlockMetadata(this.d, this.e, this.f);
			
			if ((block == this.contactBlock) && (j == this.inData)) {
				++this.ticksInGround;
				
				if (this.ticksInGround == 1200) // 1200 = 60s
				{
					this.setDead();
				}
			} else {
				this.inGround = false;
				this.motionX *= this.rand.nextFloat() * 0.2F;
				this.motionY *= this.rand.nextFloat() * 0.2F;
				this.motionZ *= this.rand.nextFloat() * 0.2F;
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
		} else {
			++this.ticksInAir;
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX,
					this.posY, this.posZ);
			Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(
					this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(
					vec31, vec3, false, true, false);
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY,
					this.posZ);
			vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(
					this.posX + this.motionX, this.posY + this.motionY,
					this.posZ + this.motionZ);
			
			if (movingobjectposition != null) {
				vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(
						movingobjectposition.hitVec.xCoord,
						movingobjectposition.hitVec.yCoord,
						movingobjectposition.hitVec.zCoord);
			}
			
			Entity entity = null;
			@SuppressWarnings("rawtypes")
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
					this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
							.expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			int i;
			float f1;
			
			for (i = 0; i < list.size(); ++i) {
				Entity entity1 = (Entity) list.get(i);
				
				if (entity1.canBeCollidedWith()
						&& ((entity1 != this.shootingEntity) || (this.ticksInAir >= 5))) {
					f1 = 0.3F;
					AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
					MovingObjectPosition movingobjectposition1 = axisalignedbb1
							.calculateIntercept(vec31, vec3);
					
					if (movingobjectposition1 != null) {
						double d1 = vec31.distanceTo(movingobjectposition1.hitVec);
						
						if ((d1 < d0) || (d0 == 0.0D)) {
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}
			
			if (entity != null) {
				movingobjectposition = new MovingObjectPosition(entity);
			}
			
			if ((movingobjectposition != null)
					&& (movingobjectposition.entityHit != null)
					&& (movingobjectposition.entityHit instanceof EntityPlayer)) {
				EntityPlayer entityplayer = (EntityPlayer) movingobjectposition.entityHit;
				
				if (entityplayer.capabilities.disableDamage
						|| ((this.shootingEntity instanceof EntityPlayer) && !((EntityPlayer) this.shootingEntity)
								.canAttackPlayer(entityplayer))) {
					movingobjectposition = null;
				}
			}
			
			float f2;
			float f4;
			
			if (movingobjectposition != null) {
				if (movingobjectposition.entityHit != null) {
					f2 = MathHelper.sqrt_double((this.motionX * this.motionX)
							+ (this.motionY * this.motionY)
							+ (this.motionZ * this.motionZ));
					int k = MathHelper.ceiling_double_int(f2 * this.damage);
					
					/*
					 * if (this.getIsCritical()) { k += this.rand.nextInt(k / 2
					 * + 2); }
					 */
					
					DamageSource damagesource = null;
					
					if (this.shootingEntity == null) {
						damagesource = DamSource.causeShurikenDamage(this, this);
					} else {
						damagesource = DamSource.causeShurikenDamage(this,
								this.shootingEntity);
					}
					
					if (movingobjectposition.entityHit.attackEntityFrom(damagesource, k)) {
						if (movingobjectposition.entityHit instanceof EntityLivingBase) {
							EntityLivingBase entitylivingbase = (EntityLivingBase) movingobjectposition.entityHit;
							
							if (!this.worldObj.isRemote) {
								entitylivingbase.setArrowCountInEntity(entitylivingbase
										.getArrowCountInEntity() + 1);
							}
							
							if ((this.shootingEntity != null)
									&& (movingobjectposition.entityHit != this.shootingEntity)
									&& (movingobjectposition.entityHit instanceof EntityPlayer)
									&& (this.shootingEntity instanceof EntityPlayerMP)) {
								((EntityPlayerMP) this.shootingEntity).playerNetServerHandler
										.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
							}
						}
						
						this.playSound("random.bowhit", 1.0F,
								1.2F / ((this.rand.nextFloat() * 0.2F) + 0.9F));
						
						if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
							this.setDead();
						}
					} else {
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.rotationYaw += 180.0F;
						this.prevRotationYaw += 180.0F;
						this.ticksInAir = 0;
					}
				} else {
					this.d = movingobjectposition.blockX;
					this.e = movingobjectposition.blockY;
					this.f = movingobjectposition.blockZ;
					this.contactBlock = block;
					this.inData = this.worldObj.getBlockMetadata(this.d, this.e, this.f);
					this.motionX = ((float) (movingobjectposition.hitVec.xCoord - this.posX));
					this.motionY = ((float) (movingobjectposition.hitVec.yCoord - this.posY));
					this.motionZ = ((float) (movingobjectposition.hitVec.zCoord - this.posZ));
					f2 = MathHelper.sqrt_double((this.motionX * this.motionX)
							+ (this.motionY * this.motionY)
							+ (this.motionZ * this.motionZ));
					this.posX -= (this.motionX / f2) * 0.05000000074505806D;
					this.posY -= (this.motionY / f2) * 0.05000000074505806D;
					this.posZ -= (this.motionZ / f2) * 0.05000000074505806D;
					this.playSound("random.bowhit", 1.0F,
							1.2F / ((this.rand.nextFloat() * 0.2F) + 0.9F));
					this.inGround = true;
					
					if (this.contactBlock.getMaterial() != Material.air) {
						this.contactBlock.onEntityCollidedWithBlock(this.worldObj,
								this.d, this.e, this.f, this);
					}
				}
			}
			
			/*
			 * if (this.getIsCritical()) { for (i = 0; i < 4; ++i) {
			 * this.worldObj.spawnParticle("crit", this.posX + this.motionX *
			 * (double)i / 4.0D, this.posY + this.motionY * (double)i / 4.0D,
			 * this.posZ + this.motionZ * (double)i / 4.0D, -this.motionX,
			 * -this.motionY + 0.2D, -this.motionZ); } }
			 */
			
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			f2 = MathHelper.sqrt_double((this.motionX * this.motionX)
					+ (this.motionZ * this.motionZ));
			this.rotationYaw = (float) ((Math.atan2(this.motionX, this.motionZ) * 180.0D) / Math.PI);
			
			for (this.rotationPitch = (float) ((Math.atan2(this.motionY, f2) * 180.0D) / Math.PI); (this.rotationPitch - this.prevRotationPitch) < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}
			
			while ((this.rotationPitch - this.prevRotationPitch) >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}
			
			while ((this.rotationYaw - this.prevRotationYaw) < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}
			
			while ((this.rotationYaw - this.prevRotationYaw) >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}
			
			this.rotationPitch = this.prevRotationPitch
					+ ((this.rotationPitch - this.prevRotationPitch) * 0.2F);
			this.rotationYaw = this.prevRotationYaw
					+ ((this.rotationYaw - this.prevRotationYaw) * 0.2F);
			float f3 = 0.99F;
			f1 = 0.05F;
			
			if (this.isInWater()) {
				for (int l = 0; l < 4; ++l) {
					f4 = 0.25F;
					this.worldObj.spawnParticle("bubble",
							this.posX - (this.motionX * f4), this.posY
									- (this.motionY * f4), this.posZ
									- (this.motionZ * f4), this.motionX, this.motionY,
							this.motionZ);
				}
				
				f3 = 0.8F;
			}
			
			if (this.isWet()) {
				this.extinguish();
			}
			
			this.motionX *= f3;
			this.motionY *= f3;
			this.motionZ *= f3;
			this.motionY -= f1;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.func_145775_I();
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		this.d = par1NBTTagCompound.getShort("xTile");
		this.e = par1NBTTagCompound.getShort("yTile");
		this.f = par1NBTTagCompound.getShort("zTile");
		this.ticksInGround = par1NBTTagCompound.getShort("life");
		this.contactBlock = Block
				.getBlockById(par1NBTTagCompound.getByte("inTile") & 255);
		this.inData = par1NBTTagCompound.getByte("inData") & 255;
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
	
	@Override
	public void setDamage(double par1) {
		this.damage = par1;
	}
	
	/**
	 * Sets the position and rotation. Only difference from the other one is no
	 * bounding on the rotation. Args: posX, posY, posZ, yaw, pitch
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double par1, double par3, double par5,
			float par7, float par8, int par9) {
		this.setPosition(par1, par3, par5);
		this.setRotation(par7, par8);
	}
	
	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z
	 * direction.
	 */
	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7,
			float par8) {
		float f2 = MathHelper.sqrt_double((par1 * par1) + (par3 * par3) + (par5 * par5));
		par1 /= f2;
		par3 /= f2;
		par5 /= f2;
		par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * par8;
		par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * par8;
		par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1)
				* 0.007499999832361937D * par8;
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
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw,
					this.rotationPitch);
			this.ticksInGround = 0;
		}
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("xTile", (short) this.d);
		par1NBTTagCompound.setShort("yTile", (short) this.e);
		par1NBTTagCompound.setShort("zTile", (short) this.f);
		par1NBTTagCompound.setShort("life", (short) this.ticksInGround);
		par1NBTTagCompound.setByte("inTile",
				(byte) Block.getIdFromBlock(this.contactBlock));
		par1NBTTagCompound.setByte("inData", (byte) this.inData);
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
