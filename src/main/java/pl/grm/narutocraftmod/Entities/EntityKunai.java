package pl.grm.narutocraftmod.Entities;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.network.rcon.RConThreadClient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.JsonSerializableSet;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKunai extends EntityThrowable
	{
	private int field_145791_d = -1;
    private int field_145792_e = -1;
    private int field_145789_f = -1;
    private Block field_145790_g;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public static int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 2.0D;
    private int knockbackStrength;
    private static final String __OBFID = "CL_00001715";
	float speed = 0.1F; 
	float speed2 = 1.0F; //3.0F
	
	public EntityKunai(World par1World)
	{
	    super(par1World);
	    this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
	    setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed2, speed);
	}
	    
	public EntityKunai(World par1World, EntityLivingBase par2EntityLivingBase)
	{
	    super(par1World, par2EntityLivingBase);
	    setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed2, speed);
	}
	
	public EntityKunai(World par1World, double arg1Double, double arg2Double, double arg3Double)
	{
	    super(par1World, arg1Double, arg2Double, arg3Double);
	    setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed2, speed);
	}
	
	    
	
	@Override
	protected float getGravityVelocity() 
	 {
		return 0;
	  }
	    
	    //par2World.playSoundAtEntity(par3EntityPlayer, "kunai", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	    
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	 {
	       if (par1MovingObjectPosition.entityHit != null)
	       {
	           byte b0 = 0;
	          if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
	          {
	              b0 = 3;
	          }
	            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
	       }
	     for (int i = 0; i < 8; ++i)
	     {
	          this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	        }
	        if (!this.worldObj.isRemote)
	        {
	            this.setDead();
	        }
	    
	}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
	    boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
	    EntityKunai entitykunai = new EntityKunai(par2World, par3EntityPlayer);

	    int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

	        if (k > 0)
	        {
	        	//entitykunai.setDamage(entitykunai.getDamage() + (double)k * 0.5D + 0.5D);
	        }

	        int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

	        if (l > 0)

	        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	        {
	        	entitykunai.setFire(100);
	        }

	        par1ItemStack.damageItem(1, par3EntityPlayer);
	        //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);

	       
	            par3EntityPlayer.inventory.consumeInventoryItem(NarutoCraftMod.Kunai);

	     if (!par2World.isRemote)
	     {
	     }
	   
	}

}
