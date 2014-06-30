package pl.grm.narutocraftmod.Mobs.Bijuu;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
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
    }
	
	 public boolean isAIEnabled() {
         return true;
	 }

	 /*@Override
	 public float getMaxHealth() {
         return 10;
 }*/

    @Override
    protected String getLivingSound()
    {
        return "narutocraftpl:YourSound";   //refers to:yourmod/sound/YourSound
    }

    @Override
    protected String getHurtSound()
    {
        return "narutocraftpl:optionalFile.YourSound";      //refers to:yourmod/sound/optionalFile/YourSound
    }

    @Override
    protected String getDeathSound()
    {
        return "narutocraftpl:optionalFile.optionalFile2.YourSound";    //etc.
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }

}
