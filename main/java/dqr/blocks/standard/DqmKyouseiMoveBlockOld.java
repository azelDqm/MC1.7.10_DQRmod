package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;

public class DqmKyouseiMoveBlockOld extends Block
{
    //クラス本体。Blockクラスを継承する
	private int point; //N=0 S =1 E=2 W=3

    public DqmKyouseiMoveBlockOld(int i) //ブロックの基本設定
    {
        super(Material.iron); //材質を土に
        point = i;
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	//DQR.func.debugString("DqmKyouseiMoveBlock2(" + par1World.isRemote + ") : 1");

    	Entity entity = par5Entity;
    	World world = par1World;

    	if(!par1World.isRemote)
    	{
	    	if(par5Entity.isSneaking())
	    	{
	    		//DQR.func.debugString("DqmKyouseiMoveBlock2(" + test.xCoord + " / " + test.yCoord + " / " + test.zCoord);
	    	}



	    	if(!par5Entity.isSneaking())
	    	{
	    		/*
	    		DqmPetBase elb = (DqmPetBase)par5Entity;
	    		double posX = elb.posX;
	    		double posY = elb.posY;
	    		double posZ = elb.posZ;
	    		this.repositionEntity(par1World, posX , posY, posZ, elb, 0.7D, 0, 0);
				*/



	    		/*
	            switch(this.point)
	            {
		            case 0: elb.setLocationAndAngles(posX, par3+1.0D, posZ - 0.7, elb.rotationYaw, elb.rotationPitch); break;
		            case 1: elb.setLocationAndAngles(posX, par3+1.0D, posZ + 0.7D, elb.rotationYaw, elb.rotationPitch); break;
		            case 2: elb.setLocationAndAngles(posX+0.7D, par3+1.0D , posZ, elb.rotationYaw, elb.rotationPitch); break;
		            case 3: elb.setLocationAndAngles(posX-0.7D, par3+1.0D , posZ, elb.rotationYaw, elb.rotationPitch); break;
	            }
	            */
	    		DQR.func.debugString("DqmKyouseiMoveBlock2("+ this.point+")");
	    		//elb.getMoveHelper()().setMoveTo(x, y, z, ((EntityLiving)e).getMoveHelper().getSpeed());

	    		/*
	            switch(this.point)
	            {
		            case 0: elb.getNavigator().tryMoveToXYZ(posX, par3+1.0D, posZ - 0.7, 5.0D); break;
		            case 1: elb.getNavigator().tryMoveToXYZ(posX, par3+1.0D, posZ + 0.7D, 5.0D); break;
		            case 2: elb.getNavigator().tryMoveToXYZ(posX+0.7D, par3+1.0D , posZ, 5.0D); break;
		            case 3: elb.getNavigator().tryMoveToXYZ(posX-0.7D, par3+1.0D , posZ, 5.0D); break;
	            }

	            */
	    		/*
	            switch(this.point)
	            {
		            case 0: elb.getMoveHelper().setMoveTo(posX, par3+1.1D, posZ - 0.7, 5.0D); break;
		            case 1: elb.getMoveHelper().setMoveTo(posX, par3+1.1D, posZ + 0.7D, 5.0D); break;
		            case 2: elb.getMoveHelper().setMoveTo(posX+0.7D, par3+1.1D , posZ, 5.0D); break;
		            case 3: elb.getMoveHelper().setMoveTo(posX-0.7D, par3+1.1D , posZ, 5.0D); break;
	            }
	            */

	    		//elb.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);


	    		/*
	    		elb.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	            switch(this.point)
	            {
		            case 0: elb.moveEntityWithHeading(elb.posX, par3+1.0D, elb.posZ-0.7); break;
		            case 1: elb.moveEntityWithHeading(elb.posX, par3+1.0D, elb.posZ+0.7); break;
		            case 2: elb.moveEntityWithHeading(elb.posX+0.7, par3+1.0D, elb.posZ); break;
		            case 3: elb.moveEntityWithHeading(elb.posX-0.7, par3+1.0D, elb.posZ); break;
	            }
	            */
	            //elb.getNavigator().tryMoveToXYZ();

	    		/*
	            switch(this.point)
	            {
		            case 0: par5Entity.setPosition(p_70107_1_, p_70107_3_, p_70107_5_); = par4-0.7; break;
		            case 1: par5Entity.posZ = par4 +0.7; break;
		            case 2: par5Entity.posX = par2+0.7; break;
		            case 3: par5Entity.posX = par2-0.7; break;
	            }
	            */
	    	}
    	}


        //if (par5Entity instanceof EntityLivingBase && !par5Entity.worldObj.isRemote)
        //{
        	//DQR.func.debugString("DqmKyouseiMoveBlock2(" + par1World.isRemote + ") : 2");
        	//elv2.setPositionAndUpdate(this.location[0], this.location[1] + 0.5D, this.location[2]);
        	//EntityLivingBase elb = (EntityLivingBase)par5Entity;
        	//elb.moveEntity(, p_70091_3_, p_70091_5_);

        	/*
            switch(this.point)
            {
	            case 0: elb.moveEntity(par2, par3 + 1, par4 - 0.7); break;
	            case 1: elb.moveEntity(par2, par3 + 1, par4 + 0.7); break;
	            case 2: elb.moveEntity(par2 + 0.7, par3 + 1, par4); break;
	            case 3: elb.moveEntity(par2 - 0.7, par3 + 1, par4); break;
            }
            */
        	//moveEntity
        	//elb.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
        	//DQR.func.debugString("DqmKyouseiMoveBlock2(" + par1World.isRemote + ") : R[" + elb.onGround + " / " + elb.isSneaking() + "]");
        	//if(elb.onGround && !elb.isSneaking())
        	/*
        	if(!elb.isSneaking())
        	{
        		DQR.func.debugString("DqmKyouseiMoveBlock2(" + par1World.isRemote + ") : 3");
        		for(int cntX = -1; cntX <= 1; cntX++)
        		{
        			for(int cntZ = -1; cntZ <= 1; cntZ++)
        			{
        				if(par5Entity.worldObj.getBlock((int)par5Entity.posX, (int)par5Entity.posY - 1, (int)par5Entity.posZ) == this)
        				{

        					int fixY = (int)(elb.posY + 0.9D);
        					DQR.func.debugString("DqmKyouseiMoveBlock2(" + par1World.isRemote + ") : 4");
        		            switch(this.point)
        		            {
        			            case 0: elb.setPositionAndUpdate(elb.posX, fixY, elb.posZ-0.7); break;
        			            case 1: elb.setPositionAndUpdate(elb.posX, fixY, elb.posZ+0.7); break;
        			            case 2: elb.setPositionAndUpdate(elb.posX+0.7, fixY, elb.posZ); break;
        			            case 3: elb.setPositionAndUpdate(elb.posX-0.7, fixY, elb.posZ); break;
        		            }
        					break;
        				}
        			}
        		}

        	}
        	*/
        	//int fixY = (int)(elb.posY + 0.9D);
        	/*
        	int fixY = (int)(elb.posY);
        	//if(!elb.isSneaking() && elb.onGround)
        	if(!elb.isSneaking())
        	{
	            switch(this.point)
	            {
		            case 0: elb.moveEntity(elb.posX, fixY, elb.posZ-0.7); break;
		            case 1: elb.moveEntity(elb.posX, fixY, elb.posZ+0.7); break;
		            case 2: elb.moveEntity(elb.posX+0.7, fixY, elb.posZ); break;
		            case 3: elb.moveEntity(elb.posX-0.7, fixY, elb.posZ); break;
	            }
        	}
        	*/
        	/*
            switch(this.point)
            {
	            case 0: par5Entity.motionZ = -0.7; break;
	            case 1: par5Entity.motionZ = 0.7; break;
	            case 2: par5Entity.motionX = 0.7;; break;
	            case 3: par5Entity.motionX = -0.7; break;
            }
            */

            /*

            ep.motionY = 3;
            DQR.func.addPotionEffect2(ep, new PotionEffect(Potion.Subayasa.id, 20*3, 0));*/
        //}



    	boolean isItem = par5Entity instanceof EntityItem || par5Entity instanceof EntityXPOrb;


		if(!(isItem || par5Entity instanceof EntityLivingBase || par5Entity instanceof EntityTNTPrimed))
			return;


		double mult = 2.1D;
		//mult *= par1World.getBlockState(pos.down()).getBlock().slipperiness;

		double xVelocity = 0;
		double yVelocity = 0;
		double zVelocity = 0;

		switch(this.point) {
			case 0:
				xVelocity = -0.3D * mult;
				break;
			case 1:
				zVelocity = -0.3D * mult;
				break;
			case 2:
				xVelocity = 0.3D * mult;
				break;
			case 3:
				zVelocity = 0.3D * mult;
				break;
		}
l:
{
		this.repositionEntity(world, (double)par2, (double)par3, (double)par4, (EntityLivingBase)entity, xVelocity, yVelocity, zVelocity);


				switch(this.point) {
					case 0:
						if(entity.posX < par2 + 1)
							break l;
						break;
					case 1:
						if(entity.posX > par2)
							break l;
						break;
					case 2:
						if(entity.posZ <par4 + 1)
							break l;
						break;
					case 3:
						if(entity.posZ > par4)
							break l;
						break;
				}

				entity.motionX = xVelocity;
				entity.motionZ = zVelocity;
}


    }



	private void repositionEntity(World world, double pX, double pY, double pZ, EntityLivingBase ent, double xO, double yO, double zO) {

		/*
			if (!world.getCollisionBoxes(ent, ent.getEntityBoundingBox()).isEmpty() || !world.getCollisionBoxes(ent, ent.getEntityBoundingBox().offset(xO, yO, zO)).isEmpty()) {
				return;
			}
			*/
			if (isZero(ent.motionX) && isZero(ent.motionZ)) {
				if (xO == 0)
					xO += (pX - (ent.posX - .5)) / 20;
				if (zO == 0)
					zO += (pZ - (ent.posZ - .5)) / 20;
			} else {
				xO += ent.motionX;
				zO += ent.motionZ;
			}
			double eY = yO != 0 ? ent.prevPosY : ent.posY;
			double xT = ent.lastTickPosX, yT = ent.lastTickPosY, zT = ent.lastTickPosZ;

			ent.setPositionAndUpdate(ent.prevPosX + xO, eY + yO, ent.prevPosZ + zO);

			ent.lastTickPosX = xT;
			ent.lastTickPosY = yT;
			ent.lastTickPosZ = zT;
			if (yO != 0) {
				ent.motionY = 0;
			}
			ent.motionX *= .5;
			ent.motionZ *= .5;
	}

	public static boolean isZero(double x) {

		return -.025 <= x && x <= .025;
	}

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
