package dqr.thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import dqr.functions.FuncDqrExplosion;


public class ThreadExplosion extends Thread{

    public boolean isFlaming;
    /** whether or not this explosion spawns smoke particles */
    public boolean isSmoking = true;
    public int field_77289_h = 26;
    public Random explosionRNG = new Random();
    public World worldObj;
    public double explosionX;
    public double explosionY;
    public double explosionZ;
    public Entity exploder;
    public float explosionSize;



	private boolean setParticle = true;
	public FuncDqrExplosion explosion;

	public ThreadExplosion(World p_i1948_1_, Entity p_i1948_2_, double p_i1948_3_, double p_i1948_5_, double p_i1948_7_, float p_i1948_9_)
	{
        this.worldObj = p_i1948_1_;
        this.exploder = p_i1948_2_;
        this.explosionSize = p_i1948_9_;
        this.explosionX = p_i1948_3_;
        this.explosionY = p_i1948_5_;
        this.explosionZ = p_i1948_7_;
	}

	public void run()
	{
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
            //for (j = 0; j < this.field_77289_h; ++j)
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
                                float f3 = this.exploder != null ? this.exploder.func_145772_a(null, this.worldObj, j1, k1, l1, block) : block.getExplosionResistance(this.exploder, worldObj, j1, k1, l1, explosionX, explosionY, explosionZ);
                                f1 -= (f3 + 0.3F) * f2;
                            }

                            if (f1 > 0.0F && (this.exploder == null || this.exploder.func_145774_a(null, this.worldObj, j1, k1, l1, block, f1)))
                            {
                                hashset.add(new ChunkPosition(j1, k1, l1));
                            	//this.worldObj.setBlockToAir(j1, k1, l1);
                            }

                            d5 += d0 * (double)f2;
                            d6 += d1 * (double)f2;
                            d7 += d2 * (double)f2;
                        }
                    }
                }
            }
        }
        Iterator iterator;
        ChunkPosition chunkposition;

        iterator = this.explosion.affectedBlockPositions.iterator();
        //IChunkProvider test = this.worldObj.getChunkProvider();
        //test.
        //Chunk test = new Chunk(this.worldObj, 0, 0);

        while (iterator.hasNext())
        {
            chunkposition = (ChunkPosition)iterator.next();
            i = chunkposition.chunkPosX;
            j = chunkposition.chunkPosY;
            k = chunkposition.chunkPosZ;
            this.worldObj.setBlockToAir(i, j, k);
        }
		/*
        Iterator iterator;
        ChunkPosition chunkposition;
        int i;
        int j;
        int k;
        Block block;
        iterator = this.explosion.affectedBlockPositions.iterator();

        while (iterator.hasNext())
        {
            chunkposition = (ChunkPosition)iterator.next();
            i = chunkposition.chunkPosX;
            j = chunkposition.chunkPosY;
            k = chunkposition.chunkPosZ;
            block = this.explosion.worldObj.getBlock(i, j, k);

	        double d0 = (double)((float)i + this.explosion.worldObj.rand.nextFloat());
	        double d1 = (double)((float)j + this.explosion.worldObj.rand.nextFloat());
	        double d2 = (double)((float)k + this.explosion.worldObj.rand.nextFloat());
	        double d3 = d0 - this.explosion.explosionX;
	        double d4 = d1 - this.explosion.explosionY;
	        double d5 = d2 - this.explosion.explosionZ;
	        double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
	        d3 /= d6;
	        d4 /= d6;
	        d5 /= d6;
	        double d7 = 0.5D / (d6 / (double)this.explosion.explosionSize + 0.1D);
	        d7 *= (double)(this.explosion.worldObj.rand.nextFloat() * this.explosion.worldObj.rand.nextFloat() + 0.3F);
	        d3 *= d7;
	        d4 *= d7;
	        d5 *= d7;
	        this.explosion.worldObj.spawnParticle("explode", (d0 + this.explosion.explosionX * 1.0D) / 2.0D, (d1 + this.explosion.explosionY * 1.0D) / 2.0D, (d2 + this.explosion.explosionZ * 1.0D) / 2.0D, d3, d4, d5);
	        this.explosion.worldObj.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
        }
        */
	}
}
