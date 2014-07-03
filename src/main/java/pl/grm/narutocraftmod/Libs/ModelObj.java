package pl.grm.narutocraftmod.Libs;


import java.util.ArrayList;

import net.minecraft.entity.Entity;

public class ModelObj
{
  ArrayList<Object3D> objectParts = new ArrayList();
  
  public ModelObj(Object3D... objects)
  {
    for (Object3D o : objects) {
      if (o != null)
      {
        this.objectParts.add(o);
        o.opengldrawtolist();
      }
    }
  }
  
  public void renderModel(Entity entity, float var16, float var15, float var13, float f, float var12, float var14)
  {
    for (Object3D o : this.objectParts) {
      o.opengldraw();
    }
  }
}
