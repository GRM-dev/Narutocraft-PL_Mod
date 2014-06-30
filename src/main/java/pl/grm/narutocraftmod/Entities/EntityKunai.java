package pl.grm.narutocraftmod.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKunai extends EntityThrowable
	{
	int speed = 1;   
	public EntityKunai(World par1World)
	    {
	        super(par1World);
	        this.motionX*=speed;
	        this.motionY*=speed;
	        this.motionZ*=speed;
			setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
	    }
	    
	    public EntityKunai(World par1World, double arg1Double, double arg2Double, double arg3Double)
	    {
	        super(par1World, arg1Double, arg2Double, arg3Double);
	        this.motionX*=speed;
	        this.motionY*=speed;
	        this.motionZ*=speed;
	        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
	    }
	   
	    public EntityKunai(World par1World, EntityLivingBase par2EntityLivingBase)
	    {
	        super(par1World, par2EntityLivingBase);
	        this.motionX*=speed;
	        this.motionY*=speed;
	        this.motionZ*=speed;
	        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
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
}
