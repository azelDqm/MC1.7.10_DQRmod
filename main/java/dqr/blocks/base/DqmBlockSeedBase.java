package dqr.blocks.base;

import static net.minecraftforge.common.EnumPlantType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQPlants;
import dqr.api.Items.DQSeeds;

public class DqmBlockSeedBase extends Block implements IPlantable
{

    public DqmBlockSeedBase(boolean par1)
    {
        super(Material.plants);
        this.setTickRandomly(true);
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
        this.setStepSound(soundTypeGrass);
        //this.setCreativeTab(CreativeTabs.tabDecorations);
        if(!par1)
        {
        	this.disableStats();
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && canBlockStay(par1World, par2, par3, par4);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(Block par1)
    {
    	return DQR.growth.canGrowthBlock(par1);
    }


    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return DQR.growth.canGrowthBlock(p_149854_1_);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        this.checkFlowerChange(par1World, par2, par3, par4);

        //System.out.println("DEBUG_KIGHT");
        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 7)
            {
                float f = this.func_149864_n(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(20.0F / f) + 1) == 0)
                {
                    ++l;

                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    protected final void checkFlowerChange(World par1World, int par2, int par3, int par4)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block soil = par1World.getBlock(par2, par3 - 1, par4);
        return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) &&
               //(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
        		(soil != null && this.canThisPlantGrowOnThisBlockID(soil));
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
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
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }


	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return world.getBlockMetadata(x, y, z);
	}

	private float func_149864_n(World p_149864_1_, int p_149864_2_, int p_149864_3_, int p_149864_4_)
	{
        float f = 1.0F;
        Block block = p_149864_1_.getBlock(p_149864_2_, p_149864_3_, p_149864_4_ - 1);
        Block block1 = p_149864_1_.getBlock(p_149864_2_, p_149864_3_, p_149864_4_ + 1);
        Block block2 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_);
        Block block3 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_);
        Block block4 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_ - 1);
        Block block5 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_ - 1);
        Block block6 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_ + 1);
        Block block7 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_ + 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

        for (int l = p_149864_2_ - 1; l <= p_149864_2_ + 1; ++l)
        {
            for (int i1 = p_149864_4_ - 1; i1 <= p_149864_4_ + 1; ++i1)
            {
                float f1 = 0.0F;

                if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1).canSustainPlant(p_149864_1_, l, p_149864_3_ - 1, i1, ForgeDirection.UP, this))
                {
                    f1 = 1.0F;

                    if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1).isFertile(p_149864_1_, l, p_149864_3_ - 1, i1))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l != p_149864_2_ || i1 != p_149864_4_)
                {
                	f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
        	f /= 2.0F;
        }

        return f;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		// メタデータでブロックを追加する
		// par3List.add(new ItemStack(par1, 1, <メタデータ>));
		for (int i = 0; i < 8; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}

	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        return super.getIcon(p_149673_5_, p_149673_1_.getBlockMetadata(p_149673_2_, p_149673_3_, p_149673_4_));
    }

    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    public void fertilize2(World par1World, int par2, int par3, int par4, int fix)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + fix;

        if (l > 7)
        {
            l = 7;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }


    protected Item getSeedItem()
    {
    	Random rand = new Random();

    	if(this == DQPlants.BlockYakusouSeed1){return DQSeeds.itemYakusouSeed;}
    	else if(this == DQPlants.BlockYakusouSeed2){return DQSeeds.itemYakusouSeed2;}
    	else if(this == DQPlants.BlockYakusouSeed3){return DQSeeds.itemYakusouSeed3;}
    	else if(this == DQPlants.BlockDokukesisouSeed1){return DQSeeds.itemDokukesisouSeed;}
    	else if(this == DQPlants.BlockDokukesisouSeed2){return DQSeeds.itemDokukesisouSeed2;}
    	else if(this == DQPlants.BlockDokukesisouSeed3){return DQSeeds.itemDokukesisouSeed3;}
    	else if(this == DQPlants.BlockTikaraSeed1){return DQSeeds.itemTikaraSeed;}
    	else if(this == DQPlants.BlockTikaraSeed2){return DQSeeds.itemTikaraSeed2;}
    	else if(this == DQPlants.BlockTikaraSeed3){return DQSeeds.itemTikaraSeed3;}
    	else if(this == DQPlants.BlockMamoriSeed1){return DQSeeds.itemMamoriSeed;}
    	else if(this == DQPlants.BlockMamoriSeed2){return DQSeeds.itemMamoriSeed2;}
    	else if(this == DQPlants.BlockMamoriSeed3){return DQSeeds.itemMamoriSeed3;}
    	else if(this == DQPlants.BlockSubayasaSeed1){return DQSeeds.itemSubayasaSeed;}
    	else if(this == DQPlants.BlockSubayasaSeed2){return DQSeeds.itemSubayasaSeed2;}
    	else if(this == DQPlants.BlockSubayasaSeed3){return DQSeeds.itemSubayasaSeed3;}
    	else if(this == DQPlants.BlockHonooSeed1){return DQSeeds.itemHonooSeed;}
    	else if(this == DQPlants.BlockHonooSeed2){return DQSeeds.itemHonooSeed2;}
    	else if(this == DQPlants.BlockHonooSeed3){return DQSeeds.itemHonooSeed3;}
    	else if(this == DQPlants.BlockIyasiSeed1){return DQSeeds.itemIyasiSeed;}
    	else if(this == DQPlants.BlockIyasiSeed2){return DQSeeds.itemIyasiSeed2;}
    	else if(this == DQPlants.BlockIyasiSeed3){return DQSeeds.itemIyasiSeed3;}
    	else if(this == DQPlants.BlockMahounomiSeed1){return DQSeeds.itemMahounomiseed;}
    	else if(this == DQPlants.BlockMahounomiSeed2){return DQSeeds.itemMahounomiseed2;}
    	else if(this == DQPlants.BlockMahounomiSeed3){return DQSeeds.itemMahounomiseed3;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed1){return DQSeeds.itemMaryokunotaneseed;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed2){return DQSeeds.itemMaryokunotaneseed2;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed3){return DQSeeds.itemMaryokunotaneseed3;}
    	else if(this == DQPlants.BlockOugonSeed1){return DQSeeds.itemOugonSeed;}
    	else if(this == DQPlants.BlockOugonSeed2){return DQSeeds.itemOugonSeed2;}
    	else if(this == DQPlants.BlockOugonSeed3){return DQSeeds.itemOugonSeed3;}
    	else if(this == DQPlants.BlockOugonSeed4){return  rand.nextInt(3) == 0 ? DQSeeds.itemOugonSeed4 : DQSeeds.itemOugonSeed3;} //IIFDQSeeds.itemOugonSeed4;}


    	return null;
    }
    protected Item getCropItem()
    {
    	if(this == DQPlants.BlockYakusouSeed1){return DQSeeds.itemYakusou;}
    	else if(this == DQPlants.BlockYakusouSeed2){return DQSeeds.itemYakusou2;}
    	else if(this == DQPlants.BlockYakusouSeed3){return DQSeeds.itemYakusou3;}
    	else if(this == DQPlants.BlockDokukesisouSeed1){return DQSeeds.itemDokukesisou;}
    	else if(this == DQPlants.BlockDokukesisouSeed2){return DQSeeds.itemDokukesisou2;}
    	else if(this == DQPlants.BlockDokukesisouSeed3){return DQSeeds.itemDokukesisou3;}
    	else if(this == DQPlants.BlockTikaraSeed1){return DQSeeds.itemTikaranotane;}
    	else if(this == DQPlants.BlockTikaraSeed2){return DQSeeds.itemTikaranotane2;}
    	else if(this == DQPlants.BlockTikaraSeed3){return DQSeeds.itemTikaranotane3;}
    	else if(this == DQPlants.BlockMamoriSeed1){return DQSeeds.itemMamorinotane;}
    	else if(this == DQPlants.BlockMamoriSeed2){return DQSeeds.itemMamorinotane2;}
    	else if(this == DQPlants.BlockMamoriSeed3){return DQSeeds.itemMamorinotane3;}
    	else if(this == DQPlants.BlockSubayasaSeed1){return DQSeeds.itemSubayasanotane;}
    	else if(this == DQPlants.BlockSubayasaSeed2){return DQSeeds.itemSubayasanotane2;}
    	else if(this == DQPlants.BlockSubayasaSeed3){return DQSeeds.itemSubayasanotane3;}
    	else if(this == DQPlants.BlockHonooSeed1){return DQSeeds.itemHonoonomi;}
    	else if(this == DQPlants.BlockHonooSeed2){return DQSeeds.itemHonoonomi2;}
    	else if(this == DQPlants.BlockHonooSeed3){return DQSeeds.itemHonoonomi3;}
    	else if(this == DQPlants.BlockIyasiSeed1){return DQSeeds.itemIyasinomi;}
    	else if(this == DQPlants.BlockIyasiSeed2){return DQSeeds.itemIyasinomi2;}
    	else if(this == DQPlants.BlockIyasiSeed3){return DQSeeds.itemIyasinomi3;}
    	else if(this == DQPlants.BlockMahounomiSeed1){return DQSeeds.itemMahounomiI;}
    	else if(this == DQPlants.BlockMahounomiSeed2){return DQSeeds.itemMahounomiI2;}
    	else if(this == DQPlants.BlockMahounomiSeed3){return DQSeeds.itemMahounomiI3;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed1){return DQSeeds.itemMaryokunotaneI;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed2){return DQSeeds.itemMaryokunotaneI2;}
    	else if(this == DQPlants.BlockMaryokunotaneSeed3){return DQSeeds.itemMaryokunotaneI3;}
    	else if(this == DQPlants.BlockOugonSeed1){return DQSeeds.itemOugon;}
    	else if(this == DQPlants.BlockOugonSeed2){return DQSeeds.itemOugon2;}
    	else if(this == DQPlants.BlockOugonSeed3){return DQSeeds.itemOugon3;}
    	else if(this == DQPlants.BlockOugonSeed4){return DQSeeds.itemOugon4;}

    	return null;
    }


    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        if (par1 == 7)
        {
            return getCropItem();
        }else
        {
            return getSeedItem();
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

        if (metadata >= 7)
        {
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(this.getSeedItem(), 1, 0));
                }
            }
        }

        return ret;
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 7)
        {
            par2 = 7;
        }
        //System.out.println("" + new ItemStack(this, 1).getDisplayName() + "/" + par1 + "/" + par2);
        return this.iconArray[par2];
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	String textureName = "";
    	if(this == DQPlants.BlockYakusouSeed1){textureName = "dqr:Yakusou_";}
    	else if(this == DQPlants.BlockYakusouSeed2){textureName = "dqr:Yakusou2_";}
    	else if(this == DQPlants.BlockYakusouSeed3){textureName = "dqr:Yakusou3_";}
    	else if(this == DQPlants.BlockDokukesisouSeed1){textureName = "dqr:Dokukesisou_";}
    	else if(this == DQPlants.BlockDokukesisouSeed2){textureName = "dqr:Dokukesisou2_";}
    	else if(this == DQPlants.BlockDokukesisouSeed3){textureName = "dqr:Dokukesisou3_";}
    	else if(this == DQPlants.BlockTikaraSeed1){textureName = "dqr:Tikara_";}
    	else if(this == DQPlants.BlockTikaraSeed2){textureName = "dqr:Tikara2_";}
    	else if(this == DQPlants.BlockTikaraSeed3){textureName = "dqr:Tikara3_";}
    	else if(this == DQPlants.BlockMamoriSeed1){textureName = "dqr:Mamori_";}
    	else if(this == DQPlants.BlockMamoriSeed2){textureName = "dqr:Mamori2_";}
    	else if(this == DQPlants.BlockMamoriSeed3){textureName = "dqr:Mamori3_";}
    	else if(this == DQPlants.BlockSubayasaSeed1){textureName = "dqr:Subayasa_";}
    	else if(this == DQPlants.BlockSubayasaSeed2){textureName = "dqr:Subayasa2_";}
    	else if(this == DQPlants.BlockSubayasaSeed3){textureName = "dqr:Subayasa3_";}
    	else if(this == DQPlants.BlockHonooSeed1){textureName = "dqr:Honoo_";}
    	else if(this == DQPlants.BlockHonooSeed2){textureName = "dqr:Honoo2_";}
    	else if(this == DQPlants.BlockHonooSeed3){textureName = "dqr:Honoo3_";}
    	else if(this == DQPlants.BlockIyasiSeed1){textureName = "dqr:Iyasi_";}
    	else if(this == DQPlants.BlockIyasiSeed2){textureName = "dqr:Iyasi2_";}
    	else if(this == DQPlants.BlockIyasiSeed3){textureName = "dqr:Iyasi3_";}
    	else if(this == DQPlants.BlockMahounomiSeed1){textureName = "dqr:Mahounomi_";}
    	else if(this == DQPlants.BlockMahounomiSeed2){textureName = "dqr:Mahounomi2_";}
    	else if(this == DQPlants.BlockMahounomiSeed3){textureName = "dqr:Mahounomi3_";}
    	else if(this == DQPlants.BlockMaryokunotaneSeed1){textureName = "dqr:Maryokunotane_";}
    	else if(this == DQPlants.BlockMaryokunotaneSeed2){textureName = "dqr:Maryokunotane2_";}
    	else if(this == DQPlants.BlockMaryokunotaneSeed3){textureName = "dqr:Maryokunotane3_";}
    	else if(this == DQPlants.BlockOugonSeed1){textureName = "dqr:Ougon_";}
    	else if(this == DQPlants.BlockOugonSeed2){textureName = "dqr:Ougon2_";}
    	else if(this == DQPlants.BlockOugonSeed3){textureName = "dqr:Ougon3_";}
    	else if(this == DQPlants.BlockOugonSeed4){textureName = "dqr:Ougon4_";}

        this.iconArray = new IIcon[8];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_149651_1_.registerIcon(textureName + i);
        }
    }

    public void checkMutation(World par1World, int par2, int par3, int par4, int meta)
    {
    	Random rand = new Random();
    	int BaseParam1 = 1000;
    	int BaseParam2 = 2000;
    	int BaseParam3 = 3000;
    	int BaseParam4 = 4000;
    	int BaseParam5 = 5000;
    	int boost = par1World.getBlock(par2, par3 - 1, par4) == DQPlants.BlockHoujyouDirt? 2 : 1;

    	if(meta == 7)
    	{
	    	if(this == DQPlants.BlockYakusouSeed1){
	    		if(rand.nextInt(BaseParam1 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockYakusouSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockYakusouSeed2){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockYakusouSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockYakusouSeed3){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockIyasiSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockDokukesisouSeed1){
	    		if(rand.nextInt(BaseParam1 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockDokukesisouSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockDokukesisouSeed2){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockDokukesisouSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockDokukesisouSeed3){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockIyasiSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockTikaraSeed1){
	    		if(rand.nextInt(BaseParam1 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockTikaraSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockTikaraSeed2){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockTikaraSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockTikaraSeed3){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMamoriSeed1){
	    		if(rand.nextInt(BaseParam1 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMamoriSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMamoriSeed2){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMamoriSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMamoriSeed3){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockSubayasaSeed1){
	    		if(rand.nextInt(BaseParam1 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockSubayasaSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockSubayasaSeed2){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockSubayasaSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockSubayasaSeed3){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockHonooSeed1){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockHonooSeed2){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockHonooSeed3){
	    		if(rand.nextInt(BaseParam4 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMaryokunotaneSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockIyasiSeed1){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockIyasiSeed2){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockHonooSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockIyasiSeed3){
	    		if(rand.nextInt(BaseParam4 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMahounomiSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMahounomiSeed1){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMahounomiSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMahounomiSeed2){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMahounomiSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMahounomiSeed3){
	    		if(rand.nextInt(BaseParam4 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockOugonSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMaryokunotaneSeed1){
	    		if(rand.nextInt(BaseParam2 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMaryokunotaneSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMaryokunotaneSeed2){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockMaryokunotaneSeed3, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockMaryokunotaneSeed3){
	    		if(rand.nextInt(BaseParam4 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockOugonSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockOugonSeed1){
	    		if(rand.nextInt(BaseParam3 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockOugonSeed1, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockOugonSeed2){
	    		if(rand.nextInt(BaseParam4 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockOugonSeed2, meta, 2);
	    		}
	    	}
	    	else if(this == DQPlants.BlockOugonSeed3){
	    		if(rand.nextInt(BaseParam5 / boost) == 0)
	    		{
	    			par1World.setBlock(par2, par3, par4, DQPlants.BlockOugonSeed4, meta, 2);
	    		}
	    	}
    	}

    	par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
    }
}
