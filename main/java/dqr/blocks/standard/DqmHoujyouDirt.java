package dqr.blocks.standard;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQOres;
import dqr.api.Blocks.DQPlants;

public class DqmHoujyouDirt extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_94441_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_94440_b;
    @SideOnly(Side.CLIENT)
    private IIcon baseIcon;

    public DqmHoujyouDirt()
    {
        super(Material.ground);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the sthared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? (par2 > 0 ? this.field_94441_a : this.field_94440_b) : this.baseIcon;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.isWaterNearby(par1World, par2, par3, par4) && !par1World.canLightningStrikeAt(par2, par3 + 1, par4))
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l > 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l - 1, 2);
            }
            else if (!this.isCropsNearby(par1World, par2, par3, par4))
            {
                //par1World.setBlock(par2, par3, par4, Block.dirt);
            }
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 2);

            if(par1World.isAirBlock(par2, par3 + 1, par4))
            {
            	canNewGerminate(par1World, par2, par3, par4, par5Random);
            }
        }
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
    {
    	/*
        if (!par1World.isRemote && par1World.rand.nextFloat() < par6 - 0.5F)
        {
            if (!(par5Entity instanceof EntityPlayer) && !par1World.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }

            par1World.setBlock(par2, par3, par4, Block.dirt);
        }
        */
    }

    /**
     * returns true if there is at least one cropblock nearby (x-1 to x+1, y+1, z-1 to z+1)
     */
    private boolean isCropsNearby(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;

        for (int l = par2 - b0; l <= par2 + b0; ++l)
        {
            for (int i1 = par4 - b0; i1 <= par4 + b0; ++i1)
            {
                //int j1 = par1World.getBlockId(l, par3 + 1, i1);
                Block plant = par1World.getBlock(l, par3 + 1, i1);

                if (plant instanceof IPlantable && canSustainPlant(par1World, par2, par3, par4, ForgeDirection.UP, (IPlantable)plant))
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * returns true if there's water nearby (x-4 to x+4, y to y+1, k-4 to k+4)
     */
    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 4; l <= par2 + 4; ++l)
        {
            for (int i1 = par3; i1 <= par3 + 1; ++i1)
            {
                for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)
                {
                    Block blc = par1World.getBlock(l, i1, j1);
                    Material material = blc.getMaterial();
                    if (material == Material.water)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        Block blc = par1World.getBlock(par2, par3 + 1, par4);
        Material material = blc.getMaterial();

        if (material.isSolid())
        {
            //par1World.setBlock(par2, par3, par4, Block.dirt);
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*
    public int idDropped(int par1, Random par2Random, int par3)
    {
        //return Block.dirt.idDropped(0, par2Random, par3);
    	return this;
    }
*/

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    /*
    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this;
    }
*/
    /**
     * When this method is called, your block should register all the IIcons it needs with the given IIconRegister. This
     * is the only chance you get to register IIcons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	this.baseIcon = par1IconRegister.registerIcon("dqr:HoujyouDirt");
        this.field_94441_a = par1IconRegister.registerIcon("dqr:HoujyouDirt_wet");
        this.field_94440_b = par1IconRegister.registerIcon("dqr:HoujyouDirt_dry");
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        for (int l = 0; l < 3; ++l)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            d0 = (double)((float)par4 + par5Random.nextFloat());
            double d2 = 0.0D;
            double d3 = 0.0D;
            double d4 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            int j1 = par5Random.nextInt(2) * 2 - 1;
            d2 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double)par4 + 0.5D + 0.25D * (double)j1;
            d4 = (double)(par5Random.nextFloat() * 1.0F * (float)j1);
            double d6 = (double)par2 + 0.5D + 0.25D * (double)i1;
            d2 = (double)(par5Random.nextFloat() * 1.0F * (float)i1);
            par1World.spawnParticle("portal", d6, d1, d5, d2, d3, d4);
        }
    }



    public void canNewGerminate(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	Random rand = new Random();

    	Block[] keySeed1 = new Block[]{null, par1World.getBlock(par2 + 1, par3+1, par4), null,
    						par1World.getBlock(par2 , par3+1, par4 -1), null, par1World.getBlock(par2 , par3+1, par4 + 1),
    						null, par1World.getBlock(par2 - 1, par3+1, par4), null};

    	int[] SeedMeta = new int[]{0, par1World.getBlockMetadata(par2 + 1, par3+1, par4), 0,
						  par1World.getBlockMetadata(par2 , par3+1, par4 -1), 0, par1World.getBlockMetadata(par2 , par3+1, par4 + 1),
						  0, par1World.getBlockMetadata(par2 - 1, par3+1, par4), 0};

    	Block[] keyBlock = new Block[]{par1World.getBlock(par2 + 1, par3, par4 - 1), Blocks.farmland, par1World.getBlock(par2 + 1, par3, par4 + 1),
    						 Blocks.farmland, DQPlants.BlockHoujyouDirt, Blocks.farmland,
    						 par1World.getBlock(par2 - 1, par3, par4 - 1), Blocks.farmland, par1World.getBlock(par2 + 1, par3, par4 + 1)};

    	int[] BlockMeta = new int[]{par1World.getBlockMetadata(par2 + 1, par3, par4 - 1), 0, par1World.getBlockMetadata(par2 + 1, par3, par4 + 1),
				 		   0, 0, 0,
				 		   par1World.getBlockMetadata(par2 - 1, par3, par4 - 1), 0, par1World.getBlockMetadata(par2 + 1, par3, par4 + 1)};

    	Block[] keySeed2 = null;

    	if(DQR.debug == 0)
    	{
	    	for(int cnt = 1; cnt <= 7; cnt= cnt + 2)
	    	{
	    		if(keySeed1[cnt] == null || keySeed1[cnt] == Blocks.air || SeedMeta[cnt] < 6)
	    		{
	    			return;
	    		}
	    	}
    	}

    	if(keySeed1[1] != keySeed1[3])
    	{
    		keySeed2 = new Block[9];
    		//keySeed2 = keySeed1;
    		keySeed2[1] = keySeed1[3];
    		keySeed2[3] = keySeed1[1];
    		keySeed2[5] = keySeed1[7];
    		keySeed2[7] = keySeed1[5];
    	}

    	ArrayList<Integer> keySet1 = DQR.mutationTable.getMutationSeedBlocksKey(keySeed1);
    	ArrayList<Integer> keySet2 = null;

    	if(keySeed2 != null)
    	{
    		keySet2 = DQR.mutationTable.getMutationSeedBlocksKey(keySeed2);
    	}

    	int setCnt = 0;


    	for(int cnt = 0; cnt < keySet1.size(); cnt++)
    	{
    		Block[] checkBlocks = (Block[])DQR.mutationTable.mutationBlocks.get(keySet1.get(cnt));
    		int[] checkMetas = (int[])DQR.mutationTable.mutationBlockMetas.get(keySet1.get(cnt));
    		Block mutationBlock = (Block)DQR.mutationTable.mutationResultBlocks.get(keySet1.get(cnt));

    		//DQR.func.debugString(DQR.func.equalBlockArray(checkBlocks, keyBlock) + "/" + DQR.func.equalIntArray(checkMetas, BlockMeta));
    		if(DQR.func.equalBlockArray(checkBlocks, keyBlock) && DQR.func.equalIntArray(checkMetas, BlockMeta))
    		{
    			if(rand.nextInt(5) == 0)
    			{
    				par1World.setBlock(par2, par3 + 1, par4, mutationBlock, 1, 2);
    			}else
    			{
    				if(rand.nextInt(2) == 0)
    				{
    					par1World.setBlock(par2, par3 + 1, par4, keySeed1[1], 1, 2);
    				}else
    				{
    					par1World.setBlock(par2, par3 + 1, par4, keySeed1[3], 1, 2);
    				}
    			}
    		}
    	}

    	if(keySet2 != null)
    	{
	    	for(int cnt = 0; cnt < keySet2.size(); cnt++)
	    	{
	    		Block[] checkBlocks = (Block[])DQR.mutationTable.mutationBlocks.get(keySet2.get(cnt));
	    		int[] checkMetas = (int[])DQR.mutationTable.mutationBlockMetas.get(keySet2.get(cnt));
	    		Block mutationBlock = (Block)DQR.mutationTable.mutationResultBlocks.get(keySet2.get(cnt));

	    		DQR.func.debugString(DQR.func.equalBlockArray(checkBlocks, keyBlock) + "/" + DQR.func.equalIntArray(checkMetas, BlockMeta));
	    		if(DQR.func.equalBlockArray(checkBlocks, keyBlock) && DQR.func.equalIntArray(checkMetas, BlockMeta))
	    		{
	    			if(rand.nextInt(5) == 0)
	    			{
	    				par1World.setBlock(par2, par3 + 1, par4, mutationBlock, 1, 2);
	    			}else
	    			{
	    				if(rand.nextInt(2) == 0)
	    				{
	    					par1World.setBlock(par2, par3 + 1, par4, keySeed1[1], 1, 2);
	    				}else
	    				{
	    					par1World.setBlock(par2, par3 + 1, par4, keySeed1[3], 1, 2);
	    				}
	    			}
	    		}
	    	}
    	}

    	/*
        for (int cX = par2 - 1; cX <= par2 + 1; ++cX)
        {
            for (int cZ = par4 - 1; cZ <= par4 + 1; ++cZ)
            {
            	keySeed1[setCnt] =par1World.getBlock(cX, par3+1, cZ);
            	blockMetaSet[setCnt] =par1World.getBlockMetadata(cX, par3+1, cZ);
            	baseIdSet[setCnt] =par1World.getBlock(cX, par3, cZ);
            	baseMetaSet[setCnt] =par1World.getBlockMetadata(cX, par3, cZ);
            	++setCnt;
            }
        }
        */
    }



    public void canNewGerminate2(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	Block[] blockIdSet;
    	Block[] baseIdSet;
    	int[] blockMetaSet;
    	int[] baseMetaSet;

    	Block l = par1World.getBlock(par2, par3 + 1, par4);
    	int m = par1World.getBlockMetadata(par2, par3 + 1, par4);
    	int setCnt = 0;
    	boolean canGerm = false;

    	blockIdSet = new Block[9];
    	blockMetaSet = new int[9];
    	baseIdSet = new Block[9];
    	baseMetaSet = new int[9];

        for (int cX = par2 - 1; cX <= par2 + 1; ++cX)
        {
            for (int cZ = par4 - 1; cZ <= par4 + 1; ++cZ)
            {
            	blockIdSet[setCnt] =par1World.getBlock(cX, par3+1, cZ);
            	blockMetaSet[setCnt] =par1World.getBlockMetadata(cX, par3+1, cZ);
            	baseIdSet[setCnt] =par1World.getBlock(cX, par3, cZ);
            	baseMetaSet[setCnt] =par1World.getBlockMetadata(cX, par3, cZ);
            	++setCnt;
            }
        }

    	canGerm = true;
        for (int cnt = 0; cnt < 9; ++cnt)
        {

        	if (cnt == 4)
        	{
        		++cnt;
        	}
        	if (blockMetaSet[cnt] < 5)
        	{
        		canGerm = false;
        		//return;
        	}
        }

        if (canGerm)
        {
        	//毒消し薬Lv1ベース
        	if(blockIdSet[3] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[5] == DQPlants.BlockDokukesisouSeed1)
        	{
        		//System.out.println("TESTC");
        		//薬草
        		if(blockIdSet[0] == DQPlants.BlockYakusouSeed1 && blockIdSet[1] == DQPlants.BlockYakusouSeed1 && blockIdSet[2] == DQPlants.BlockYakusouSeed1 &&
        		   blockIdSet[6] == DQPlants.BlockYakusouSeed1 && blockIdSet[7] == DQPlants.BlockYakusouSeed1 && blockIdSet[8] == DQPlants.BlockYakusouSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed1, 2, 2);
        			}
        			return;
        		}
        		//毒消し薬
        		if(blockIdSet[0] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[1] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[2] == DQPlants.BlockDokukesisouSeed1 &&
             	   blockIdSet[6] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[7] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[8] == DQPlants.BlockDokukesisouSeed1)
             	{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed1, 2, 2);
        			}
             		return;
             	}
        		//守りの種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed1 && blockIdSet[1] == DQPlants.BlockMamoriSeed1 && blockIdSet[2] == DQPlants.BlockMamoriSeed1 &&
                   blockIdSet[6] == DQPlants.BlockMamoriSeed1 && blockIdSet[7] == DQPlants.BlockMamoriSeed1 && blockIdSet[8] == DQPlants.BlockMamoriSeed1)
          		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed1, 2, 2);
        			}
          			return;
          		}
        		//素早さの種
        		if(blockIdSet[0] == DQPlants.BlockSubayasaSeed1 && blockIdSet[1] == DQPlants.BlockSubayasaSeed1 && blockIdSet[2] == DQPlants.BlockSubayasaSeed1 &&
                   blockIdSet[6] == DQPlants.BlockSubayasaSeed1 && blockIdSet[7] == DQPlants.BlockSubayasaSeed1 && blockIdSet[8] == DQPlants.BlockSubayasaSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed1, 2, 2);
        			}
        			return;
        		}
        		//力の種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed1 && blockIdSet[1] == DQPlants.BlockTikaraSeed1 && blockIdSet[2] == DQPlants.BlockTikaraSeed1 &&
                   blockIdSet[6] == DQPlants.BlockTikaraSeed1 && blockIdSet[7] == DQPlants.BlockTikaraSeed1 && blockIdSet[8] == DQPlants.BlockTikaraSeed1)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed1, 2, 2);
        			}
         			return;
         		}
        	}
        	if(blockIdSet[1] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[7] == DQPlants.BlockDokukesisouSeed1)
        	{
        		//薬草
        		if(blockIdSet[0] == DQPlants.BlockYakusouSeed1 && blockIdSet[3] == DQPlants.BlockYakusouSeed1 && blockIdSet[6] == DQPlants.BlockYakusouSeed1 &&
        		   blockIdSet[2] == DQPlants.BlockYakusouSeed1 && blockIdSet[5] == DQPlants.BlockYakusouSeed1 && blockIdSet[8] == DQPlants.BlockYakusouSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed1, 2, 2);
        			}
        			return;
        		}
        		//毒消し薬
        		if(blockIdSet[0] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[3] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[6] == DQPlants.BlockDokukesisouSeed1 &&
             	   blockIdSet[2] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[5] == DQPlants.BlockDokukesisouSeed1 && blockIdSet[8] == DQPlants.BlockDokukesisouSeed1)
             	{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed1, 2, 2);
        			}
             		return;
             	}
        		//守りの種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed1 && blockIdSet[3] == DQPlants.BlockMamoriSeed1 && blockIdSet[6] == DQPlants.BlockMamoriSeed1 &&
                   blockIdSet[2] == DQPlants.BlockMamoriSeed1 && blockIdSet[5] == DQPlants.BlockMamoriSeed1 && blockIdSet[8] == DQPlants.BlockMamoriSeed1)
          		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed1, 2, 2);
        			}
          			return;
          		}
        		//素早さの種
        		if(blockIdSet[0] == DQPlants.BlockSubayasaSeed1 && blockIdSet[3] == DQPlants.BlockSubayasaSeed1 && blockIdSet[6] == DQPlants.BlockSubayasaSeed1 &&
                   blockIdSet[2] == DQPlants.BlockSubayasaSeed1 && blockIdSet[5] == DQPlants.BlockSubayasaSeed1 && blockIdSet[8] == DQPlants.BlockSubayasaSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed1, 2, 2);
        			}
        			return;
        		}
        		//力の種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed1 && blockIdSet[3] == DQPlants.BlockTikaraSeed1 && blockIdSet[6] == DQPlants.BlockTikaraSeed1 &&
                   blockIdSet[2] == DQPlants.BlockTikaraSeed1 && blockIdSet[5] == DQPlants.BlockTikaraSeed1 && blockIdSet[8] == DQPlants.BlockTikaraSeed1)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed1, 2, 2);
        			}
         			return;
         		}
        	}

        	//毒消し薬Lv2ベース
        	if(blockIdSet[3] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[5] == DQPlants.BlockDokukesisouSeed2)
        	{
        		//薬草
        		if(blockIdSet[0] == DQPlants.BlockYakusouSeed2 && blockIdSet[1] == DQPlants.BlockYakusouSeed2 && blockIdSet[2] == DQPlants.BlockYakusouSeed2 &&
        		   blockIdSet[6] == DQPlants.BlockYakusouSeed2 && blockIdSet[7] == DQPlants.BlockYakusouSeed2 && blockIdSet[8] == DQPlants.BlockYakusouSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed2, 2, 2);
        			}
        			return;
        		}
        		//毒消し薬
        		if(blockIdSet[0] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[1] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[2] == DQPlants.BlockDokukesisouSeed2 &&
             	   blockIdSet[6] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[7] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[8] == DQPlants.BlockDokukesisouSeed2)
             	{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}
             		return;
             	}
        		//守りの種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed2 && blockIdSet[1] == DQPlants.BlockMamoriSeed2 && blockIdSet[2] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[6] == DQPlants.BlockMamoriSeed2 && blockIdSet[7] == DQPlants.BlockMamoriSeed2 && blockIdSet[8] == DQPlants.BlockMamoriSeed2)
          		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed2, 2, 2);
        			}
          			return;
          		}
        		//素早さの種
        		if(blockIdSet[0] == DQPlants.BlockSubayasaSeed2 && blockIdSet[1] == DQPlants.BlockSubayasaSeed2 && blockIdSet[2] == DQPlants.BlockSubayasaSeed2 &&
                   blockIdSet[6] == DQPlants.BlockSubayasaSeed2 && blockIdSet[7] == DQPlants.BlockSubayasaSeed2 && blockIdSet[8] == DQPlants.BlockSubayasaSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed2, 2, 2);
        			}
        			return;
        		}
        		//力の種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed2 && blockIdSet[1] == DQPlants.BlockTikaraSeed2 && blockIdSet[2] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[6] == DQPlants.BlockTikaraSeed2 && blockIdSet[7] == DQPlants.BlockTikaraSeed2 && blockIdSet[8] == DQPlants.BlockTikaraSeed2)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed2, 2, 2);
        			}
         			return;
         		}

        		//癒しの種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed2 && blockIdSet[1] == DQPlants.BlockTikaraSeed2 && blockIdSet[2] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[6] == DQPlants.BlockYakusouSeed2 && blockIdSet[7] == DQPlants.BlockYakusouSeed2 && blockIdSet[8] == DQPlants.BlockYakusouSeed2)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}
         			return;
         		}
        		if(blockIdSet[6] == DQPlants.BlockTikaraSeed2 && blockIdSet[7] == DQPlants.BlockTikaraSeed2 && blockIdSet[8] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[0] == DQPlants.BlockYakusouSeed2 && blockIdSet[1] == DQPlants.BlockYakusouSeed2 && blockIdSet[2] == DQPlants.BlockYakusouSeed2)
              	{
             		if (par5Random.nextInt(4) == 0)
             		{
             			par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
             		}else
             		{
             			par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
             		}
              		return;
              	}

        		//炎の種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed2 && blockIdSet[1] == DQPlants.BlockMamoriSeed2 && blockIdSet[2] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[6] == DQPlants.BlockSubayasaSeed2 && blockIdSet[7] == DQPlants.BlockSubayasaSeed2 && blockIdSet[8] == DQPlants.BlockSubayasaSeed2)
          		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
         			}
          			return;
          		}
        		if(blockIdSet[6] == DQPlants.BlockMamoriSeed2 && blockIdSet[7] == DQPlants.BlockMamoriSeed2 && blockIdSet[8] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[0] == DQPlants.BlockSubayasaSeed2 && blockIdSet[1] == DQPlants.BlockSubayasaSeed2 && blockIdSet[2] == DQPlants.BlockSubayasaSeed2)
           		{
          			if (par5Random.nextInt(4) == 0)
          			{
          				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
          			}else
          			{
          				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
          			}
           			return;
           		}

        		//癒しの種2
        		if(blockIdSet[0] == DQPlants.BlockIyasiSeed1 && blockIdSet[1] == DQPlants.BlockIyasiSeed1 && blockIdSet[2] == DQPlants.BlockIyasiSeed1 &&
        		   blockIdSet[6] == DQPlants.BlockIyasiSeed1 && blockIdSet[7] == DQPlants.BlockIyasiSeed1 && blockIdSet[8] == DQPlants.BlockIyasiSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
        			}
        			return;
        		}

        		//炎の種2
        		if(blockIdSet[0] == DQPlants.BlockHonooSeed1 && blockIdSet[1] == DQPlants.BlockHonooSeed1 && blockIdSet[2] == DQPlants.BlockHonooSeed1 &&
         		   blockIdSet[6] == DQPlants.BlockHonooSeed1 && blockIdSet[7] == DQPlants.BlockHonooSeed1 && blockIdSet[8] == DQPlants.BlockHonooSeed1)
         		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed2, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
         			}
         			return;
         		}
        	}
        	if(blockIdSet[1] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[7] == DQPlants.BlockDokukesisouSeed2)
        	{
        		//薬草
        		if(blockIdSet[0] == DQPlants.BlockYakusouSeed2 && blockIdSet[3] == DQPlants.BlockYakusouSeed2 && blockIdSet[6] == DQPlants.BlockYakusouSeed2 &&
        		   blockIdSet[2] == DQPlants.BlockYakusouSeed2 && blockIdSet[5] == DQPlants.BlockYakusouSeed2 && blockIdSet[8] == DQPlants.BlockYakusouSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockYakusouSeed2, 2, 2);
        			}
        			return;
        		}
        		//毒消し薬
        		if(blockIdSet[0] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[3] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[6] == DQPlants.BlockDokukesisouSeed2 &&
             	   blockIdSet[2] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[5] == DQPlants.BlockDokukesisouSeed2 && blockIdSet[8] == DQPlants.BlockDokukesisouSeed2)
             	{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}
             		return;
             	}
        		//守りの種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed2 && blockIdSet[3] == DQPlants.BlockMamoriSeed2 && blockIdSet[6] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[2] == DQPlants.BlockMamoriSeed2 && blockIdSet[5] == DQPlants.BlockMamoriSeed2 && blockIdSet[8] == DQPlants.BlockMamoriSeed2)
          		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMamoriSeed2, 2, 2);
        			}
          			return;
          		}
        		//素早さの種
        		if(blockIdSet[0] == DQPlants.BlockSubayasaSeed2 && blockIdSet[3] == DQPlants.BlockSubayasaSeed2 && blockIdSet[6] == DQPlants.BlockSubayasaSeed2 &&
                   blockIdSet[2] == DQPlants.BlockSubayasaSeed2 && blockIdSet[5] == DQPlants.BlockSubayasaSeed2 && blockIdSet[8] == DQPlants.BlockSubayasaSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockSubayasaSeed2, 2, 2);
        			}
        			return;
        		}
        		//力の種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed2 && blockIdSet[3] == DQPlants.BlockTikaraSeed2 && blockIdSet[6] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[2] == DQPlants.BlockTikaraSeed2 && blockIdSet[5] == DQPlants.BlockTikaraSeed2 && blockIdSet[8] == DQPlants.BlockTikaraSeed2)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockTikaraSeed2, 2, 2);
        			}
         			return;
         		}

        		//癒しの種
        		if(blockIdSet[0] == DQPlants.BlockTikaraSeed2 && blockIdSet[3] == DQPlants.BlockTikaraSeed2 && blockIdSet[6] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[2] == DQPlants.BlockYakusouSeed2 && blockIdSet[5] == DQPlants.BlockYakusouSeed2 && blockIdSet[8] == DQPlants.BlockYakusouSeed2)
         		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
        			}
         			return;
         		}
        		if(blockIdSet[2] == DQPlants.BlockTikaraSeed2 && blockIdSet[5] == DQPlants.BlockTikaraSeed2 && blockIdSet[8] == DQPlants.BlockTikaraSeed2 &&
                   blockIdSet[0] == DQPlants.BlockYakusouSeed2 && blockIdSet[3] == DQPlants.BlockYakusouSeed2 && blockIdSet[6] == DQPlants.BlockYakusouSeed2)
              	{
             		if (par5Random.nextInt(4) == 0)
             		{
             			par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
             		}else
             		{
             			par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
             		}
              		return;
              	}

        		//炎の種
        		if(blockIdSet[0] == DQPlants.BlockMamoriSeed2 && blockIdSet[3] == DQPlants.BlockMamoriSeed2 && blockIdSet[6] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[2] == DQPlants.BlockSubayasaSeed2 && blockIdSet[5] == DQPlants.BlockSubayasaSeed2 && blockIdSet[8] == DQPlants.BlockSubayasaSeed2)
          		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
         			}
          			return;
          		}
        		if(blockIdSet[2] == DQPlants.BlockMamoriSeed2 && blockIdSet[5] == DQPlants.BlockMamoriSeed2 && blockIdSet[8] == DQPlants.BlockMamoriSeed2 &&
                   blockIdSet[0] == DQPlants.BlockSubayasaSeed2 && blockIdSet[3] == DQPlants.BlockSubayasaSeed2 && blockIdSet[6] == DQPlants.BlockSubayasaSeed2)
           		{
          			if (par5Random.nextInt(4) == 0)
          			{
          				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
          			}else
          			{
          				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockDokukesisouSeed2, 2, 2);
          			}
           			return;
           		}

        		//癒しの種2
        		if(blockIdSet[0] == DQPlants.BlockIyasiSeed1 && blockIdSet[3] == DQPlants.BlockIyasiSeed1 && blockIdSet[6] == DQPlants.BlockIyasiSeed1 &&
        		   blockIdSet[2] == DQPlants.BlockIyasiSeed1 && blockIdSet[5] == DQPlants.BlockIyasiSeed1 && blockIdSet[8] == DQPlants.BlockIyasiSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed1, 2, 2);
        			}
        			return;
        		}

        		//炎の種2
        		if(blockIdSet[0] == DQPlants.BlockHonooSeed1 && blockIdSet[3] == DQPlants.BlockHonooSeed1 && blockIdSet[6] == DQPlants.BlockHonooSeed1 &&
         		   blockIdSet[2] == DQPlants.BlockHonooSeed1 && blockIdSet[5] == DQPlants.BlockHonooSeed1 && blockIdSet[8] == DQPlants.BlockHonooSeed1)
         		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed2, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed1, 2, 2);
         			}
         			return;
         		}
        	}

        	//毒消し薬Lv3ベース
        	if(blockIdSet[3] == DQPlants.BlockDokukesisouSeed3 && blockIdSet[5] == DQPlants.BlockDokukesisouSeed3)
        	{
        		//癒しの種
        		if(blockIdSet[0] == DQPlants.BlockIyasiSeed2 && blockIdSet[1] == DQPlants.BlockIyasiSeed2 && blockIdSet[2] == DQPlants.BlockIyasiSeed2 &&
        		   blockIdSet[6] == DQPlants.BlockIyasiSeed2 && blockIdSet[7] == DQPlants.BlockIyasiSeed2 && blockIdSet[8] == DQPlants.BlockIyasiSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed2, 2, 2);
        			}
        			return;
        		}

        		//炎の種
        		if(blockIdSet[0] == DQPlants.BlockHonooSeed2 && blockIdSet[1] == DQPlants.BlockHonooSeed2 && blockIdSet[2] == DQPlants.BlockHonooSeed2 &&
         		   blockIdSet[6] == DQPlants.BlockHonooSeed2 && blockIdSet[7] == DQPlants.BlockHonooSeed2 && blockIdSet[8] == DQPlants.BlockHonooSeed2)
         		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed3, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed2, 2, 2);
         			}
         			return;
         		}

        		//黄金の実
        		/*
        		if(blockIdSet[0] == DQPlants.BlockOugonSeed1 && blockIdSet[1] == DQPlants.BlockOugonSeed1 && blockIdSet[2] == DQPlants.BlockOugonSeed1 &&
        		   blockIdSet[6] == DQPlants.BlockOugonSeed1 && blockIdSet[7] == DQPlants.BlockOugonSeed1 && blockIdSet[8] == DQPlants.BlockOugonSeed1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, Block.tallGrass, 0, 2);
        			}
        			return;
        		}
        		*/

        		//黄金の実2
        		/*
        		if(blockIdSet[0] == DQPlants.BlockOugonSeed2 && blockIdSet[1] == DQPlants.BlockOugonSeed2 && blockIdSet[2] == DQPlants.BlockOugonSeed2 &&
        		   blockIdSet[6] == DQPlants.BlockOugonSeed2 && blockIdSet[7] == DQPlants.BlockOugonSeed2 && blockIdSet[8] == DQPlants.BlockOugonSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, Block.tallGrass, 0, 2);
        			}
        			return;
        		}
        		*/
        	}
        	if(blockIdSet[1] == DQPlants.BlockDokukesisouSeed3 && blockIdSet[7] == DQPlants.BlockDokukesisouSeed3)
        	{
        		//癒しの種
        		if(blockIdSet[0] == DQPlants.BlockIyasiSeed2 && blockIdSet[3] == DQPlants.BlockIyasiSeed2 && blockIdSet[6] == DQPlants.BlockIyasiSeed2 &&
        		   blockIdSet[2] == DQPlants.BlockIyasiSeed2 && blockIdSet[5] == DQPlants.BlockIyasiSeed2 && blockIdSet[8] == DQPlants.BlockIyasiSeed2)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed2, 2, 2);
        			}
        			return;
        		}

        		//炎の種
        		if(blockIdSet[0] == DQPlants.BlockHonooSeed2 && blockIdSet[3] == DQPlants.BlockHonooSeed2 && blockIdSet[6] == DQPlants.BlockHonooSeed2 &&
         		   blockIdSet[2] == DQPlants.BlockHonooSeed2 && blockIdSet[5] == DQPlants.BlockHonooSeed2 && blockIdSet[8] == DQPlants.BlockHonooSeed2)
         		{
         			if (par5Random.nextInt(4) == 0)
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed3, 2, 2);
         			}else
         			{
         				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed2, 2, 2);
         			}
         			return;
         		}

        		//黄金の実
        		/*
        		if(blockIdSet[0] == DQPlants.BlockOugonSeed1 && blockIdSet[8] == DQPlants.BlockOugonSeed1 && blockIdSet[2] == DQPlants.BlockOugonSeed1 && blockIdSet[6] == DQPlants.BlockOugonSeed1 &&
        	       baseIdSet[1] == DqmItemList2.DqmOreBlocks && baseIdSet[3] == DqmItemList2.DqmOreBlocks && baseIdSet[5] == DqmItemList2.DqmOreBlocks && baseIdSet[7] == DqmItemList2.DqmOreBlocks &&
        	       baseMetaSet[1] == 1 && baseMetaSet[3] == 9 && baseMetaSet[5] == 9 && baseMetaSet[7] == 1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed2, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, Block.tallGrass, 0, 2);
        			}
        			return;
        		}
        		*/

        		//黄金の実2
        		/*
        		if(blockIdSet[0] == DQPlants.BlockOugonSeed2 && blockIdSet[2] == DQPlants.BlockOugonSeed2 && blockIdSet[6] == DQPlants.BlockOugonSeed2 &&  blockIdSet[8] == DQPlants.BlockOugonSeed2 &&
     	           baseIdSet[1] == DqmItemList2.DqmOreBlocks && baseIdSet[3] == DqmItemList2.DqmOreBlocks && baseIdSet[5] == DqmItemList2.DqmOreBlocks && baseIdSet[7] == DqmItemList2.DqmOreBlocks &&
        	       baseMetaSet[1] == 1 && baseMetaSet[3] == 9 && baseMetaSet[5] == 9 && baseMetaSet[7] == 1)
        		{
        			if (par5Random.nextInt(4) == 0)
        			{
        				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed3, 2, 2);
        			}else
        			{
        				par1World.setBlock(par2, par3+1, par4, Block.tallGrass, 0, 2);
        			}
        			return;
        		}
        		*/
        	}


    		//黄金の実3
    		if(blockIdSet[0] == DQPlants.BlockOugonSeed3 && blockIdSet[1] == DQPlants.BlockOugonSeed3 && blockIdSet[2] == DQPlants.BlockOugonSeed3 &&
    		   blockIdSet[3] == DQPlants.BlockOugonSeed3 && blockIdSet[5] == DQPlants.BlockOugonSeed3 &&
    		   blockIdSet[6] == DQPlants.BlockOugonSeed3 && blockIdSet[7] == DQPlants.BlockOugonSeed3 && blockIdSet[8] == DQPlants.BlockOugonSeed3)
    		{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed4, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
    			}
    			return;
    		}
        }

        canGerm = true;
        //System.out.println("TEST1" + blockIdSet[0] + "/" + blockIdSet[1] + "/" + blockIdSet[2]);
        //System.out.println("TEST1" + blockIdSet[3] + "/" + blockIdSet[4] + "/" + blockIdSet[5]);
        //System.out.println("TEST1" + blockIdSet[6] + "/" + blockIdSet[7] + "/" + blockIdSet[8]);

        //System.out.println("TEST2" + blockMetaSet[0] + "/" + blockMetaSet[2] + "/" + blockMetaSet[6] + "/" + blockMetaSet[8]);

        //System.out.println("TEST3" + baseMetaSet[1] + "/" + baseMetaSet[3] + "/" + baseMetaSet[5] + "/" + baseMetaSet[7]);

        if(blockMetaSet[0] < 5 || blockMetaSet[2] < 5 || blockMetaSet[6] < 5 || blockMetaSet[8] < 5)
        {
        	//System.out.println("TEST1" + par2 + "/" + par3 + "/" + par4);
        	canGerm = false;
        }

        if(canGerm)
        {
         	//魔法の実
        	if(blockIdSet[0] == DQPlants.BlockIyasiSeed3 && blockIdSet[2] == DQPlants.BlockIyasiSeed3 && blockIdSet[6] == DQPlants.BlockIyasiSeed3 && blockIdSet[8] == DQPlants.BlockIyasiSeed3 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
        	   baseMetaSet[1] == 2 && baseMetaSet[3] == 2 && baseMetaSet[5] == 2 && baseMetaSet[7] == 2)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMahounomiSeed1, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockIyasiSeed3, 2, 2);
    			}
    			return;
        	}

        	//魔法の実2
        	if(blockIdSet[0] == DQPlants.BlockMahounomiSeed1 && blockIdSet[2] == DQPlants.BlockMahounomiSeed1 && blockIdSet[6] == DQPlants.BlockMahounomiSeed1 && blockIdSet[8] == DQPlants.BlockMahounomiSeed1 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
        	   baseMetaSet[1] == 8 && baseMetaSet[3] == 8 && baseMetaSet[5] == 8 && baseMetaSet[7] == 8)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMahounomiSeed2, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMahounomiSeed1, 2, 2);
    			}
    			return;
        	}

        	//魔法の実3
        	if(blockIdSet[0] == DQPlants.BlockMahounomiSeed2 && blockIdSet[2] == DQPlants.BlockMahounomiSeed2 && blockIdSet[6] == DQPlants.BlockMahounomiSeed2 && blockIdSet[8] == DQPlants.BlockMahounomiSeed2 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
        	   baseMetaSet[1] == 12 && baseMetaSet[3] == 12 && baseMetaSet[5] == 12 && baseMetaSet[7] == 12)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMahounomiSeed3, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMahounomiSeed2, 2, 2);
    			}
    			return;
        	}

        	//魔力の実
        	if(blockIdSet[0] == DQPlants.BlockHonooSeed3 && blockIdSet[2] == DQPlants.BlockHonooSeed3 && blockIdSet[6] == DQPlants.BlockHonooSeed3 && blockIdSet[8] == DQPlants.BlockHonooSeed3 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
               baseMetaSet[1] == 5 && baseMetaSet[3] == 5 && baseMetaSet[5] == 5 && baseMetaSet[7] == 5)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMaryokunotaneSeed1, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockHonooSeed3, 2, 2);
    			}
    			return;
        	}

        	//魔力の実2
        	if(blockIdSet[0] == DQPlants.BlockMaryokunotaneSeed1 && blockIdSet[2] == DQPlants.BlockMaryokunotaneSeed1 && blockIdSet[6] == DQPlants.BlockMaryokunotaneSeed1 && blockIdSet[8] == DQPlants.BlockMaryokunotaneSeed1 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
               baseMetaSet[1] == 4 && baseMetaSet[3] == 4 && baseMetaSet[5] == 4 && baseMetaSet[7] == 4)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMaryokunotaneSeed2, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMaryokunotaneSeed1, 2, 2);
    			}
    			return;
        	}

        	//魔力の実3
        	if(blockIdSet[0] == DQPlants.BlockMaryokunotaneSeed2 && blockIdSet[2] == DQPlants.BlockMaryokunotaneSeed2 && blockIdSet[6] == DQPlants.BlockMaryokunotaneSeed2 && blockIdSet[8] == DQPlants.BlockMaryokunotaneSeed2 &&
        	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
               baseMetaSet[1] == 7 && baseMetaSet[3] == 7 && baseMetaSet[5] == 7 && baseMetaSet[7] == 7)
        	{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMaryokunotaneSeed3, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockMaryokunotaneSeed2, 2, 2);
    			}
    			return;
        	}

            //System.out.println("TEST5" + blockIdSet[0] + "/" + blockIdSet[1] + "/" + blockIdSet[2]);
            //System.out.println("TEST5" + blockIdSet[3] + "/" + blockIdSet[4] + "/" + blockIdSet[5]);
            //System.out.println("TEST5" + blockIdSet[6] + "/" + blockIdSet[7] + "/" + blockIdSet[8]);
            //System.out.println("TEST7" + baseMetaSet[1] + "/" + baseMetaSet[3] + "/" + baseMetaSet[5] + "/" + baseMetaSet[7]);

        	//黄金の実
        	if(blockIdSet[0] == DQPlants.BlockMaryokunotaneSeed3 && blockIdSet[8] == DQPlants.BlockMaryokunotaneSeed3 &&
        	   blockIdSet[2] == DQPlants.BlockMahounomiSeed3 && blockIdSet[6] == DQPlants.BlockMahounomiSeed3 &&
         	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
               baseMetaSet[1] == 9 && baseMetaSet[3] == 1 && baseMetaSet[5] == 1 && baseMetaSet[7] == 9)
         	{
     			if (par5Random.nextInt(8) == 0)
     			{
     				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed1, 2, 2);
     			}else
     			{
     				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass , 0, 2);
     			}
     			return;
         	}

        	if(blockIdSet[2] == DQPlants.BlockMaryokunotaneSeed3 && blockIdSet[6] == DQPlants.BlockMaryokunotaneSeed3 &&
         	   blockIdSet[0] == DQPlants.BlockMahounomiSeed3 && blockIdSet[8] == DQPlants.BlockMahounomiSeed3 &&
          	   baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
               baseMetaSet[1] == 1 && baseMetaSet[3] == 9 && baseMetaSet[5] == 9 && baseMetaSet[7] == 1)
          	{
      			if (par5Random.nextInt(8) == 0)
      			{
      				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed1, 2, 2);
      			}else
      			{
      				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
      			}
      			return;
          	}

    		//黄金の実2
    		if(blockIdSet[0] == DQPlants.BlockOugonSeed1 && blockIdSet[8] == DQPlants.BlockOugonSeed1 && blockIdSet[2] == DQPlants.BlockOugonSeed1 && blockIdSet[6] == DQPlants.BlockOugonSeed1 &&
    	       baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
    	       baseMetaSet[1] == 1 && baseMetaSet[3] == 9 && baseMetaSet[5] == 9 && baseMetaSet[7] == 1)
    		{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed2, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
    			}
    			return;
    		}
    		if(blockIdSet[0] == DQPlants.BlockOugonSeed1 && blockIdSet[8] == DQPlants.BlockOugonSeed1 && blockIdSet[2] == DQPlants.BlockOugonSeed1 && blockIdSet[6] == DQPlants.BlockOugonSeed1 &&
    	       baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
    	       baseMetaSet[1] == 9 && baseMetaSet[3] == 1 && baseMetaSet[5] == 1 && baseMetaSet[7] == 9)
    		{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed2, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
    			}
    			return;
    		}

    		//黄金の実3
    		if(blockIdSet[0] == DQPlants.BlockOugonSeed2 && blockIdSet[2] == DQPlants.BlockOugonSeed2 && blockIdSet[6] == DQPlants.BlockOugonSeed2 &&  blockIdSet[8] == DQPlants.BlockOugonSeed2 &&
 	           baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
    	       baseMetaSet[1] == 1 && baseMetaSet[3] == 9 && baseMetaSet[5] == 9 && baseMetaSet[7] == 1)
    		{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed3, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
    			}
    			return;
    		}

    		if(blockIdSet[0] == DQPlants.BlockOugonSeed2 && blockIdSet[2] == DQPlants.BlockOugonSeed2 && blockIdSet[6] == DQPlants.BlockOugonSeed2 &&  blockIdSet[8] == DQPlants.BlockOugonSeed2 &&
 	           baseIdSet[1] == DQOres.DqmOreBlocks && baseIdSet[3] == DQOres.DqmOreBlocks && baseIdSet[5] == DQOres.DqmOreBlocks && baseIdSet[7] == DQOres.DqmOreBlocks &&
    	       baseMetaSet[1] == 9 && baseMetaSet[3] == 1 && baseMetaSet[5] == 1 && baseMetaSet[7] == 9)
    		{
    			if (par5Random.nextInt(4) == 0)
    			{
    				par1World.setBlock(par2, par3+1, par4, DQPlants.BlockOugonSeed3, 2, 2);
    			}else
    			{
    				par1World.setBlock(par2, par3+1, par4, Blocks.tallgrass, 0, 2);
    			}
    			return;
    		}

        }

    }
}
