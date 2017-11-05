package dqr.api.event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrExplosionEvent extends Event{

	public World worldObj;
    public double explosionX;
    public double explosionY;
    public double explosionZ;
    public Entity exploder;
    public Entity explodeSource;
    public float explosionSize;
    public Explosion explosion;

    private int field_77289_h = 16;
    public List affectedBlockPositions = new ArrayList();
    public List<Entity> entityList;
    public boolean isExplode = true;

	public DqrExplosionEvent(World world, Entity source, Entity exploder, double posX, double posY, double posZ, float size) {
        this.worldObj = world;
        this.exploder = exploder;
        this.explodeSource = source;
        this.explosionSize = size;
        this.explosionX = posX;
        this.explosionY = posY;
        this.explosionZ = posZ;

        this.explosion = new Explosion(this.worldObj, this.exploder, this.explosionX, this.explosionY, this.explosionZ, this.explosionSize);
        this.doExplosionDummy();
	}


    public void doExplosionDummy()
    {
    	field_77289_h = 16;
        float f = this.explosionSize;
        HashSet hashset = new HashSet();
        int i;
        int j;
        int k;
        double d5;
        double d6;
        double d7;

        for (i = 0; i < this.field_77289_h; ++i)
        {
            for (j = 0; j < this.field_77289_h; ++j)
            {
                for (k = 0; k < this.field_77289_h; ++k)
                {
                    if (i == 0 || i == this.field_77289_h - 1 || j == 0 || j == this.field_77289_h - 1 || k == 0 || k == this.field_77289_h - 1)
                    {
                        double d0 = (double)((float)i / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d1 = (double)((float)j / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d2 = (double)((float)k / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        d0 /= d3;
                        d1 /= d3;
                        d2 /= d3;
                        float f1 = this.explosionSize * (0.7F + this.worldObj.rand.nextFloat() * 0.6F);
                        d5 = this.explosionX;
                        d6 = this.explosionY;
                        d7 = this.explosionZ;

                        for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F)
                        {
                            int j1 = MathHelper.floor_double(d5);
                            int k1 = MathHelper.floor_double(d6);
                            int l1 = MathHelper.floor_double(d7);
                            Block block = this.worldObj.getBlock(j1, k1, l1);

                            if (block.getMaterial() != Material.air)
                            {
                                float f3 = this.exploder != null ? this.exploder.func_145772_a(this.explosion, this.worldObj, j1, k1, l1, block) : block.getExplosionResistance(this.exploder, worldObj, j1, k1, l1, explosionX, explosionY, explosionZ);
                                f1 -= (f3 + 0.3F) * f2;
                            }

                            if (f1 > 0.0F && (this.exploder == null || this.exploder.func_145774_a(this.explosion, this.worldObj, j1, k1, l1, block, f1)))
                            {
                                hashset.add(new ChunkPosition(j1, k1, l1));
                            }

                            d5 += d0 * (double)f2;
                            d6 += d1 * (double)f2;
                            d7 += d2 * (double)f2;
                        }
                    }
                }
            }
        }

        this.affectedBlockPositions.addAll(hashset);
        this.explosionSize *= 2.0F;
        i = MathHelper.floor_double(this.explosionX - (double)this.explosionSize - 1.0D);
        j = MathHelper.floor_double(this.explosionX + (double)this.explosionSize + 1.0D);
        k = MathHelper.floor_double(this.explosionY - (double)this.explosionSize - 1.0D);
        int i2 = MathHelper.floor_double(this.explosionY + (double)this.explosionSize + 1.0D);
        int l = MathHelper.floor_double(this.explosionZ - (double)this.explosionSize - 1.0D);
        int j2 = MathHelper.floor_double(this.explosionZ + (double)this.explosionSize + 1.0D);
        this.entityList = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, AxisAlignedBB.getBoundingBox((double)i, (double)k, (double)l, (double)j, (double)i2, (double)j2));
    }

    public List<ChunkPosition> getAffectedBlocks()
    {
        return this.affectedBlockPositions;
    }

    public List<Entity> getAffectedEntities()
    {
        return entityList;
    }

    public boolean isExplode()
    {
    	return isExplode;
    }

    public void setExplode(boolean par1)
    {
    	isExplode = par1;
    }
}
