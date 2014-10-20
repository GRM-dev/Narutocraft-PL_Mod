package pl.grm.narutocraft.libs.math;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Vector3D {
	public float	x;
	
	public float	y;
	
	public float	z;
	
	public Vector3D(double x, double y, double z) {
		this.x = ((float) x);
		this.y = ((float) y);
		this.z = ((float) z);
	}
	
	public Vector3D(Entity entity) {
		this(entity.posX, entity.posY, entity.posZ);
	}
	
	public Vector3D(TileEntity tile) {
		this.x = tile.xCoord;
		this.y = tile.yCoord;
		this.z = tile.zCoord;
	}
	
	public Vector3D(Vec3 vec) {
		this.x = ((float) vec.xCoord);
		this.y = ((float) vec.yCoord);
		this.z = ((float) vec.zCoord);
	}
	
	public Vector3D(Vector3D a, Vector3D b) {
		a.x -= b.x;
		a.y -= b.y;
		a.z -= b.z;
	}
	
	public static float angle(Vector3D vec1, Vector3D vec2) {
		return anglePreNorm(vec1.copy().normalize(), vec2.copy().normalize());
	}
	
	public static float anglePreNorm(Vector3D vec1, Vector3D vec2) {
		return (float) Math.acos(dotProduct(vec1, vec2));
	}
	
	public static Vector3D crossProduct(Vector3D vec1, Vector3D vec2) {
		return new Vector3D((vec1.y * vec2.z) - (vec1.z * vec2.y), (vec1.z * vec2.x)
				- (vec1.x * vec2.z), (vec1.x * vec2.y) - (vec1.y * vec2.x));
	}
	
	public static float dotProduct(Vector3D vec1, Vector3D vec2) {
		return (vec1.x * vec2.x) + (vec1.y * vec2.y) + (vec1.z * vec2.z);
	}
	
	public static Vector3D getPerpendicular(Vector3D vec) {
		if (vec.z == 0.0F) { return zCrossProduct(vec); }
		return xCrossProduct(vec);
	}
	
	public static Vector3D readFromNBT(NBTTagCompound compound) {
		return new Vector3D(compound.getFloat("Vec3_x"), compound.getFloat("Vec3_y"),
				compound.getFloat("Vec3_z"));
	}
	
	public static Vector3D xCrossProduct(Vector3D vec) {
		return new Vector3D(0.0D, vec.z, -vec.y);
	}
	
	public static Vector3D zCrossProduct(Vector3D vec) {
		return new Vector3D(-vec.y, vec.x, 0.0D);
	}
	
	public static Vector3D zero() {
		return new Vector3D(0.0D, 0.0D, 0.0D);
	}
	
	public Vector3D add(Vector3D vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		return this;
	}
	
	public void ceilToI() {
		this.x = ((float) Math.ceil(this.x));
		this.y = ((float) Math.ceil(this.y));
		this.z = ((float) Math.ceil(this.z));
	}
	
	public Vector3D copy() {
		return new Vector3D(this.x, this.y, this.z);
	}
	
	public double distanceSqTo(Vector3D target) {
		double var2 = target.x - this.x;
		double var4 = target.y - this.y;
		double var6 = target.z - this.z;
		return (var2 * var2) + (var4 * var4) + (var6 * var6);
	}
	
	public double distanceTo(Vector3D target) {
		double var2 = target.x - this.x;
		double var4 = target.y - this.y;
		double var6 = target.z - this.z;
		return MathHelper.sqrt_double((var2 * var2) + (var4 * var4) + (var6 * var6));
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Vector3D)) {
			Vector3D comp = (Vector3D) obj;
			return (comp.x == this.x) && (comp.y == this.y) && (comp.z == this.z);
		}
		return false;
	}
	
	public void floorToI() {
		this.x = ((float) Math.floor(this.x));
		this.y = ((float) Math.floor(this.y));
		this.z = ((float) Math.floor(this.z));
	}
	
	@Override
	public int hashCode() {
		return (int) (this.x + this.y + this.z);
	}
	
	public boolean isWithinRange(float min, float max) {
		return (this.x >= min) && (this.x <= max) && (this.y >= min) && (this.y <= max)
				&& (this.z >= min) && (this.z <= max);
	}
	
	public boolean isZero() {
		return (this.x == 0.0F) && (this.y == 0.0F) && (this.z == 0.0F);
	}
	
	public float length() {
		return (float) Math.sqrt((this.x * this.x) + (this.y * this.y)
				+ (this.z * this.z));
	}
	
	public float lengthPow2() {
		return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
	}
	
	public Vector3D modulo(float divisor) {
		this.x %= divisor;
		this.y %= divisor;
		this.z %= divisor;
		return this;
	}
	
	public Vector3D normalize() {
		float length = length();
		this.x /= length;
		this.y /= length;
		this.z /= length;
		return this;
	}
	
	public Vector3D rotate(float angle, Vector3D axis) {
		return Matrix4.rotationMat(angle, axis).translate(this);
	}
	
	public void roundToI() {
		this.x = Math.round(this.x);
		this.y = Math.round(this.y);
		this.z = Math.round(this.z);
	}
	
	public Vector3D scale(float scale) {
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		return this;
	}
	
	public Vector3D scale(float scalex, float scaley, float scalez) {
		this.x *= scalex;
		this.y *= scaley;
		this.z *= scalez;
		return this;
	}
	
	public Vector3D sub(Vector3D vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
		return this;
	}
	
	@Override
	public String toString() {
		return "[" + this.x + "," + this.y + "," + this.z + "]";
	}
	
	public Vec3 toVec3D() {
		return Vec3.createVectorHelper(this.x, this.y, this.z);
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		compound.setFloat("Vec3_x", this.x);
		compound.setFloat("Vec3_y", this.y);
		compound.setFloat("Vec3_z", this.z);
	}
}
