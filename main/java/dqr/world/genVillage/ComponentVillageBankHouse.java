package dqr.world.genVillage;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import dqr.DQR;
import dqr.api.Blocks.DQDecorates;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;

public class ComponentVillageBankHouse extends StructureVillagePieces.Village {

	private boolean field_143014_b;
	private StructureVillagePieces.Start startPiece;

	public ComponentVillageBankHouse(){}

	public ComponentVillageBankHouse(StructureVillagePieces.Start p_i2107_1_, int p_i2107_2_)
    {
        super(p_i2107_1_, p_i2107_2_);

        if (p_i2107_1_ != null)
        {
            this.field_143014_b = p_i2107_1_.inDesert;
            startPiece = p_i2107_1_;
        }
    }

    public ComponentVillageBankHouse(StructureVillagePieces.Start p_i2102_1_, int p_i2102_2_, Random p_i2102_3_, StructureBoundingBox p_i2102_4_, int p_i2102_5_)
    {
        super(p_i2102_1_, p_i2102_2_);
        this.coordBaseMode = p_i2102_5_;
        this.boundingBox = p_i2102_4_;
    }

	@Override
	public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {

        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

            if (this.field_143015_k < 0)
            {
                return true;
            }
            //System.out.println("DEBUGLINE:" + this.field_143015_k + "/" + this.boundingBox.maxY );
            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 5 - 2, 0);
        }

        Block baseBlc = Blocks.stonebrick;
        int baseMeta = 0;
        if(this.field_143014_b)
        {
        	baseBlc = Blocks.sandstone;
        	baseMeta = 1;
        }

        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 5, 9, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 4, 9, baseBlc, baseBlc, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 2, 6, 4, 8, Blocks.air, Blocks.air, false);
        for (int xCnt = 1; xCnt <= 7; xCnt++)
        {
        	for(int zCnt = 1; zCnt <= 9; zCnt++)
        	{
        		this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, xCnt, 5, zCnt, p_74875_3_);
        	}
        }

        this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 1, 6, 0, 8, Blocks.brick_block, Blocks.brick_block, false);

        //System.out.println("DEBUG_VILLAGE" +  this.coordBaseMode);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 1, 2, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 1, 2, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 1, 2, 6, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 1, 2, 7, p_74875_3_);

        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 7, 2, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 7, 2, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 7, 2, 6, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 7, 2, 7, p_74875_3_);

        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 7, 2, 7, p_74875_3_);

        //this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockBukiya, this.coordBaseMode, 2, 2, 0, p_74875_3_);
        //this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockBukiya, this.coordBaseMode, 6, 2, 0, p_74875_3_);

        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockTaimatu2, 0, 2, 1, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockIsu, 0, 3, 1, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockIsu, 0, 5, 1, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockTaimatu2, 0, 6, 1, 4, p_74875_3_);

        for(int x = 2; x < 7; x++)
        {
        	this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset2(Blocks.oak_stairs, 5), x, 1, 5, p_74875_3_);
        }

        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockHepaitosu, 0, 3, 2, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockMaki, 0, 6, 1, 6, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockTubo2, 0, 6, 1, 7, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockTubo2, 0, 6, 1, 8, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockTaru, 0, 2, 1, 8, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, DQDecorates.DqmBlockHondana, this.coordBaseMode, 4, 1, 8, p_74875_3_);

        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 4, 1, 0, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 4, 2, 0, p_74875_3_);
        this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));

        /*
        if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
        {
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
        }
		*/
        /*
        for (j = 0; j < 9; ++j)
        {
            for (int k = 0; k < 5; ++k)
            {
                this.clearCurrentPositionBlocksUpwards(p_74875_1_, k, 12, j, p_74875_3_);
                this.func_151554_b(p_74875_1_, Blocks.stonebrick, 0, k, -1, j, p_74875_3_);
            }
        }
		*/
        this.spawnVillagers2(p_74875_1_, p_74875_3_, 4, 1, 6, 1);
        return true;
    }

    public static Object buildComponent(StructureVillagePieces.Start p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_)
    {
    	//System.out.println("DEBUGLINE:" + p_74919_3_ +  "/" + p_74919_4_ + "/" + p_74919_5_);
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 10, 5, 11, p_74919_6_);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74919_1_, structureboundingbox) == null ? new ComponentVillageBankHouse(p_74919_0_, p_74919_7_, p_74919_2_, structureboundingbox, p_74919_6_) : null;
    }


	//public static Object buildComponent(StructureVillagePieces.Start startPiece,
	//		List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
		/*
		 * バニラのソースコードのコピーになってしまうのでここは省略
		 * ComponentVillageのサブクラスを参照のこと
		 */
	//	return null;
	//}

	@Override
	protected int getVillagerType(int par1) {
		/*
		 * 今回追加した村人用の家であることを示します
		 * このメソッドの戻り値に基いた職業の村人がスポーンします
		 */
		return DQR.villager.vlgBukiyaID;
		//return 0;
	}

    protected int getMetadataWithOffset2(Block p_151555_1_, int p_151555_2_)
    {

    	if (p_151555_2_ >= 4 && (p_151555_1_ == Blocks.stone_stairs || p_151555_1_ == Blocks.oak_stairs || p_151555_1_ == Blocks.nether_brick_stairs || p_151555_1_ == Blocks.stone_brick_stairs || p_151555_1_ == Blocks.sandstone_stairs))
    	{
    		//System.out.println("LINT_LINE:" + p_151555_2_ + "/" + this.coordBaseMode);
	    	if (this.coordBaseMode == 1)
	        {
	            if (p_151555_2_ == 6)
	            {
	                return 7;
	            }

	            if (p_151555_2_ == 7)
	            {
	                return 6;
	            }
	        }
	    	else if (this.coordBaseMode == 0)
	        {
	            if (p_151555_2_ == 4)
	            {
	                return 6;
	            }

	            if (p_151555_2_ == 5)
	            {
	                return 6;
	            }

	            if (p_151555_2_ == 6)
	            {
	                return 4;
	            }

	            if (p_151555_2_ == 7)
	            {
	                return 5;
	            }
	        }
	        else if (this.coordBaseMode == 2)
	        {
	            if (p_151555_2_ == 4)
	            {
	                return 6;
	            }

	            if (p_151555_2_ == 5)
	            {
	                return 7;
	            }

	            if (p_151555_2_ == 6)
	            {
	                return 4;
	            }

	            if (p_151555_2_ == 7)
	            {
	                return 5;
	            }
	        }else if (this.coordBaseMode == 3)
	        {
	            if (p_151555_2_ == 4)
	            {
	                return 6;
	            }

	            if (p_151555_2_ == 5)
	            {
	                return 4;
	            }

	            if (p_151555_2_ == 6)
	            {
	                return 5;
	            }

	            if (p_151555_2_ == 7)
	            {
	                return 4;
	            }
	        }else if (this.coordBaseMode == 4)
	        {
	            if (p_151555_2_ == 4)
	            {
	                return 6;
	            }

	            if (p_151555_2_ == 5)
	            {
	                return 4;
	            }

	            if (p_151555_2_ == 6)
	            {
	                return 5;
	            }

	            if (p_151555_2_ == 7)
	            {
	                return 4;
	            }
	        }
    	}

        if (p_151555_1_ == Blocks.rail)
        {
            if (this.coordBaseMode == 1 || this.coordBaseMode == 3)
            {
                if (p_151555_2_ == 1)
                {
                    return 0;
                }

                return 1;
            }
        }
        else if (p_151555_1_ != Blocks.wooden_door && p_151555_1_ != Blocks.iron_door)
        {
            if (p_151555_1_ != Blocks.stone_stairs && p_151555_1_ != Blocks.oak_stairs && p_151555_1_ != Blocks.nether_brick_stairs && p_151555_1_ != Blocks.stone_brick_stairs && p_151555_1_ != Blocks.sandstone_stairs)
            {
                if (p_151555_1_ == Blocks.ladder)
                {
                    if (this.coordBaseMode == 0)
                    {
                        if (p_151555_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_151555_2_ == 3)
                        {
                            return 2;
                        }
                    }
                    else if (this.coordBaseMode == 1)
                    {
                        if (p_151555_2_ == 2)
                        {
                            return 4;
                        }

                        if (p_151555_2_ == 3)
                        {
                            return 5;
                        }

                        if (p_151555_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_151555_2_ == 5)
                        {
                            return 3;
                        }
                    }
                    else if (this.coordBaseMode == 3)
                    {
                        if (p_151555_2_ == 2)
                        {
                            return 5;
                        }

                        if (p_151555_2_ == 3)
                        {
                            return 4;
                        }

                        if (p_151555_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_151555_2_ == 5)
                        {
                            return 3;
                        }
                    }
                }
                else if (p_151555_1_ == Blocks.stone_button)
                {
                    if (this.coordBaseMode == 0)
                    {
                        if (p_151555_2_ == 3)
                        {
                            return 4;
                        }

                        if (p_151555_2_ == 4)
                        {
                            return 3;
                        }
                    }
                    else if (this.coordBaseMode == 1)
                    {
                        if (p_151555_2_ == 3)
                        {
                            return 1;
                        }

                        if (p_151555_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_151555_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_151555_2_ == 1)
                        {
                            return 4;
                        }
                    }
                    else if (this.coordBaseMode == 3)
                    {
                        if (p_151555_2_ == 3)
                        {
                            return 2;
                        }

                        if (p_151555_2_ == 4)
                        {
                            return 1;
                        }

                        if (p_151555_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_151555_2_ == 1)
                        {
                            return 4;
                        }
                    }
                }
                else if (p_151555_1_ != Blocks.tripwire_hook && !(p_151555_1_ instanceof BlockDirectional))
                {
                    if (p_151555_1_ == Blocks.piston || p_151555_1_ == Blocks.sticky_piston || p_151555_1_ == Blocks.lever || p_151555_1_ == Blocks.dispenser)
                    {
                        if (this.coordBaseMode == 0)
                        {
                            if (p_151555_2_ == 2 || p_151555_2_ == 3)
                            {
                                return Facing.oppositeSide[p_151555_2_];
                            }
                        }
                        else if (this.coordBaseMode == 1)
                        {
                            if (p_151555_2_ == 2)
                            {
                                return 4;
                            }

                            if (p_151555_2_ == 3)
                            {
                                return 5;
                            }

                            if (p_151555_2_ == 4)
                            {
                                return 2;
                            }

                            if (p_151555_2_ == 5)
                            {
                                return 3;
                            }
                        }
                        else if (this.coordBaseMode == 3)
                        {
                            if (p_151555_2_ == 2)
                            {
                                return 5;
                            }

                            if (p_151555_2_ == 3)
                            {
                                return 4;
                            }

                            if (p_151555_2_ == 4)
                            {
                                return 2;
                            }

                            if (p_151555_2_ == 5)
                            {
                                return 3;
                            }
                        }
                    }
                }
                else if (this.coordBaseMode == 0)
                {
                    if (p_151555_2_ == 0 || p_151555_2_ == 2)
                    {
                        return Direction.rotateOpposite[p_151555_2_];
                    }
                }
                else if (this.coordBaseMode == 1)
                {
                    if (p_151555_2_ == 2)
                    {
                        return 1;
                    }

                    if (p_151555_2_ == 0)
                    {
                        return 3;
                    }

                    if (p_151555_2_ == 1)
                    {
                        return 2;
                    }

                    if (p_151555_2_ == 3)
                    {
                        return 0;
                    }
                }
                else if (this.coordBaseMode == 3)
                {
                    if (p_151555_2_ == 2)
                    {
                        return 3;
                    }

                    if (p_151555_2_ == 0)
                    {
                        return 1;
                    }

                    if (p_151555_2_ == 1)
                    {
                        return 2;
                    }

                    if (p_151555_2_ == 3)
                    {
                        return 0;
                    }
                }
            }
            else if (this.coordBaseMode == 0)
            {
                if (p_151555_2_ == 2)
                {
                    return 3;
                }

                if (p_151555_2_ == 3)
                {
                    return 2;
                }
            }
            else if (this.coordBaseMode == 1)
            {
                if (p_151555_2_ == 0)
                {
                    return 2;
                }

                if (p_151555_2_ == 1)
                {
                    return 3;
                }

                if (p_151555_2_ == 2)
                {
                    return 0;
                }

                if (p_151555_2_ == 3)
                {
                    return 1;
                }
            }
            else if (this.coordBaseMode == 3)
            {
                if (p_151555_2_ == 0)
                {
                    return 2;
                }

                if (p_151555_2_ == 1)
                {
                    return 3;
                }

                if (p_151555_2_ == 2)
                {
                    return 1;
                }

                if (p_151555_2_ == 3)
                {
                    return 0;
                }
            }
        }
        else if (this.coordBaseMode == 0)
        {
            if (p_151555_2_ == 0)
            {
                return 2;
            }

            if (p_151555_2_ == 2)
            {
                return 0;
            }
        }
        else
        {
            if (this.coordBaseMode == 1)
            {
                return p_151555_2_ + 1 & 3;
            }

            if (this.coordBaseMode == 3)
            {
                return p_151555_2_ + 3 & 3;
            }
        }

        return p_151555_2_;
    }

    public void spawnVillagers2(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_)
    {
        //if (this.villagersSpawned < p_74893_6_)
        //{
            //for (int i1 = this.villagersSpawned; i1 < p_74893_6_; ++i1)
            //{
                int j1 = this.getXWithOffset(p_74893_3_, p_74893_5_);
                int k1 = this.getYWithOffset(p_74893_4_);
                int l1 = this.getZWithOffset(p_74893_3_, p_74893_5_);


                if (!p_74893_2_.isVecInside(j1, k1, l1))
                {
                    return;
                }

                //++this.villagersSpawned;
                DqmEntityNPCBank entityvillager = new DqmEntityNPCBank(p_74893_1_);
                entityvillager.setLocationAndAngles((double)j1 + 0.5D, (double)k1, (double)l1 + 0.5D, 0.0F, 0.0F);
                p_74893_1_.spawnEntityInWorld(entityvillager);
            //}
        //}
    }
}
