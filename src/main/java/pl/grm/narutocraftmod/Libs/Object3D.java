package pl.grm.narutocraftmod.Libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.ConfigurationHandler;

public class Object3D
{
  private ArrayList vertexsets = new ArrayList();
  private ArrayList vertexsetsnorms = new ArrayList();
  private ArrayList vertexsetstexs = new ArrayList();
  private ArrayList faces = new ArrayList();
  private ArrayList facestexs = new ArrayList();
  private ArrayList facesnorms = new ArrayList();
  private int objectlist;
  private int numpolys = 0;
  public float toppoint = 0.0F;
  public float bottompoint = 0.0F;
  public float leftpoint = 0.0F;
  public float rightpoint = 0.0F;
  public float farpoint = 0.0F;
  public float nearpoint = 0.0F;
  
  public Object3D(BufferedReader ref, boolean centerit)
  {
    loadobject(ref);
    if (centerit) {
      centerit();
    }
    opengldrawtolist();
    this.numpolys = this.faces.size();
    cleanup();
  }
  
  private void cleanup()
  {
    this.vertexsets.clear();
    this.vertexsetsnorms.clear();
    this.vertexsetstexs.clear();
    this.faces.clear();
    this.facestexs.clear();
    this.facesnorms.clear();
  }
  
  private void loadobject(BufferedReader br)
  {
    int linecounter = 0;
    try
    {
      boolean firstpass = true;
      String newline;
      while ((newline = br.readLine()) != null)
      {
        linecounter++;
        newline = newline.trim();
        if (newline.length() > 0)
        {
          if ((newline.charAt(0) == 'v') && (newline.charAt(1) == ' '))
          {
            float[] coords = new float[4];
            String[] coordstext = new String[4];
            coordstext = newline.split("\\s+");
            for (int i = 1; i < coordstext.length; i++) {
              coords[(i - 1)] = Float.valueOf(coordstext[i]).floatValue();
            }
            if (firstpass)
            {
              this.rightpoint = coords[0];
              this.leftpoint = coords[0];
              this.toppoint = coords[1];
              this.bottompoint = coords[1];
              this.nearpoint = coords[2];
              this.farpoint = coords[2];
              firstpass = false;
            }
            if (coords[0] > this.rightpoint) {
              this.rightpoint = coords[0];
            }
            if (coords[0] < this.leftpoint) {
              this.leftpoint = coords[0];
            }
            if (coords[1] > this.toppoint) {
              this.toppoint = coords[1];
            }
            if (coords[1] < this.bottompoint) {
              this.bottompoint = coords[1];
            }
            if (coords[2] > this.nearpoint) {
              this.nearpoint = coords[2];
            }
            if (coords[2] < this.farpoint) {
              this.farpoint = coords[2];
            }
            this.vertexsets.add(coords);
          }
          if ((newline.charAt(0) == 'v') && (newline.charAt(1) == 't'))
          {
            float[] coords = new float[4];
            String[] coordstext = new String[4];
            coordstext = newline.split("\\s+");
            for (int i = 1; i < coordstext.length; i++) {
              coords[(i - 1)] = Float.valueOf(coordstext[i]).floatValue();
            }
            this.vertexsetstexs.add(coords);
          }
          if ((newline.charAt(0) == 'v') && (newline.charAt(1) == 'n'))
          {
            float[] coords = new float[4];
            String[] coordstext = new String[4];
            coordstext = newline.split("\\s+");
            for (int i = 1; i < coordstext.length; i++) {
              coords[(i - 1)] = Float.valueOf(coordstext[i]).floatValue();
            }
            this.vertexsetsnorms.add(coords);
          }
          if ((newline.charAt(0) == 'f') && (newline.charAt(1) == ' '))
          {
            String[] coordstext = newline.split("\\s+");
            int[] v = new int[coordstext.length - 1];
            int[] vt = new int[coordstext.length - 1];
            int[] vn = new int[coordstext.length - 1];
            for (int i = 1; i < coordstext.length; i++)
            {
              String fixstring = coordstext[i].replaceAll("//", "/0/");
              String[] tempstring = fixstring.split("/");
              v[(i - 1)] = Integer.valueOf(tempstring[0]).intValue();
              if (tempstring.length > 1) {
                vt[(i - 1)] = Integer.valueOf(tempstring[1]).intValue();
              } else {
                vt[(i - 1)] = 0;
              }
              if (tempstring.length > 2) {
                vn[(i - 1)] = Integer.valueOf(tempstring[2]).intValue();
              } else {
                vn[(i - 1)] = 0;
              }
            }
            this.faces.add(v);
            this.facestexs.add(vt);
            this.facesnorms.add(vn);
          }
        }
      }
    }
    catch (IOException e)
    {
      if (ConfigurationHandler.printErrors) {
        System.out.println("Failed to read file: " + br.toString());
      }
    }
    catch (NumberFormatException e)
    {
      if (ConfigurationHandler.printErrors) {
        System.out.println("Malformed OBJ (on line " + linecounter + "): " + br.toString() + "\r \r" + e.getMessage());
      }
    }
  }
  
  private void centerit()
  {
    float xshift = (this.rightpoint - this.leftpoint) / 2.0F;
    float yshift = (this.toppoint - this.bottompoint) / 2.0F;
    float zshift = (this.nearpoint - this.farpoint) / 2.0F;
    for (int i = 0; i < this.vertexsets.size(); i++)
    {
      float[] coords = new float[4];
      
      coords[0] = (((float[])(float[])this.vertexsets.get(i))[0] - this.leftpoint - xshift);
      coords[1] = (((float[])(float[])this.vertexsets.get(i))[1] - this.bottompoint - yshift);
      coords[2] = (((float[])(float[])this.vertexsets.get(i))[2] - this.farpoint - zshift);
      
      this.vertexsets.set(i, coords);
    }
  }
  
  public float getXWidth()
  {
    float returnval = 0.0F;
    returnval = this.rightpoint - this.leftpoint;
    return returnval;
  }
  
  public float getYHeight()
  {
    float returnval = 0.0F;
    returnval = this.toppoint - this.bottompoint;
    return returnval;
  }
  
  public float getZDepth()
  {
    float returnval = 0.0F;
    returnval = this.nearpoint - this.farpoint;
    return returnval;
  }
  
  public int numpolygons()
  {
    return this.numpolys;
  }
  
  public void opengldrawtolist()
  {
    this.objectlist = GL11.glGenLists(1);
    
    GL11.glNewList(this.objectlist, 4864);
    for (int i = 0; i < this.faces.size(); i++)
    {
      int[] tempfaces = (int[])this.faces.get(i);
      int[] tempfacesnorms = (int[])this.facesnorms.get(i);
      int[] tempfacestexs = (int[])this.facestexs.get(i);
      int polytype;
      if (tempfaces.length == 3)
      {
        polytype = 4;
      }
      else
      {
        if (tempfaces.length == 4) {
          polytype = 7;
        } else {
          polytype = 9;
        }
      }
      GL11.glBegin(polytype);
      for (int w = 0; w < tempfaces.length; w++)
      {
        if (tempfacesnorms[w] != 0)
        {
          float normtempx = ((float[])(float[])this.vertexsetsnorms.get(tempfacesnorms[w] - 1))[0];
          float normtempy = ((float[])(float[])this.vertexsetsnorms.get(tempfacesnorms[w] - 1))[1];
          float normtempz = ((float[])(float[])this.vertexsetsnorms.get(tempfacesnorms[w] - 1))[2];
          GL11.glNormal3f(normtempx, normtempy, normtempz);
        }
        if (tempfacestexs[w] != 0)
        {
          float textempx = ((float[])(float[])this.vertexsetstexs.get(tempfacestexs[w] - 1))[0];
          float textempy = ((float[])(float[])this.vertexsetstexs.get(tempfacestexs[w] - 1))[1];
          float textempz = ((float[])(float[])this.vertexsetstexs.get(tempfacestexs[w] - 1))[2];
          GL11.glTexCoord3f(textempx, 1.0F - textempy, textempz);
        }
        float tempx = ((float[])(float[])this.vertexsets.get(tempfaces[w] - 1))[0];
        float tempy = ((float[])(float[])this.vertexsets.get(tempfaces[w] - 1))[1];
        float tempz = ((float[])(float[])this.vertexsets.get(tempfaces[w] - 1))[2];
        GL11.glVertex3f(tempx, tempy, tempz);
      }
      GL11.glEnd();
    }
    GL11.glEndList();
  }
  
  public void opengldraw()
  {
    GL11.glCallList(this.objectlist);
  }
}
