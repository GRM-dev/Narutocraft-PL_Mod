package pl.grm.narutocraftmod.Mobs.Bijuu;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityKyuubi extends EntityMob 
{

	private String texture;

	public EntityKyuubi(World par1World)
    {
        super(par1World);
        this.setSize(0.9F, 1.3F);
        this.texture = "assets/narutocraftmod:textures/model/Kyuubi.png";
        this.getNavigator().setAvoidsWater(false);
        this.isImmuneToFire = true;
        float var2 = 0.25F;
        
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.5D);
	}
	
	 public boolean isAIEnabled() {
         return true;
	 }

/*	 @Override
	 public float getMaxHealth() {
         return 10;
 }*/

    @Override
    protected String getLivingSound()
    {
        return "narutocraftpl:sounds.mobs.Kyuubi";   //refers to:yourmod/sound/YourSound
    }

    @Override
    protected String getHurtSound()
    {
        return "narutocraftpl:sounds.mobs.KyuubiHurt";      //refers to:yourmod/sound/optionalFile/YourSound
    }

    @Override
    protected String getDeathSound()
    {
        return "narutocraftpl:sounds.mobs.KyuubiDeath";    //etc.
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.7F;
    }

}
