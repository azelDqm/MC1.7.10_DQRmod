package dqr.blocks.decorate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.event.DqrBedEvent;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDqmbed3;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmBlockBed3 extends BlockContainer
{
    public static String setmodel;
    private String model;
    //public static final int[][] field_149981_a = new int[][] {{0, 1}, { -1, 0}, {0, -1}, {1, 0}};
    public static final int[][] field_149981_a = new int[][] {{0, 0}, { 0, 0}, {0, 0}, {0, 0}};

    public DqmBlockBed3(Material var2)
    {
        super(var2);
        // this.setLightValue(0.9375F);
        // this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    public DqmBlockBed3 setmodel(String m)
    {

        model = m;
        return this;
    }
    //光を通す
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    public int getRenderType()
    {
        return -1;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:Dqmbed3B");
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int p_149915_2_)
    {

        return new DqmTileEntityDqmbed3();
    }

    /**
     * Called when the block is placed in the world.
     */

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        float var5 = 0.0F;
        //return AxisAlignedBB.getBoundingBox((double)((float)p_149633_2_ + var5), (double)p_149633_3_, (double)((float)p_149633_4_ + var5), (double)((float)(p_149633_2_ + 1) - var5), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1) - var5));
        return AxisAlignedBB.getBoundingBox(p_149633_2_, p_149633_3_, p_149633_4_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer ep, int par6, float par7, float par8, float par9)
    {
    	int[] jobLv = ExtendedPlayerProperties.get(ep).getJobLvA();
    	int gold =  ExtendedPlayerProperties.get(ep).getGold();
    	int jobLvTotal = 0;
    	for(int cnt = 0; cnt < jobLv.length; cnt++)
    	{
    		jobLvTotal +=  jobLv[cnt];
    	}

    	int yadodai = jobLvTotal * (jobLvTotal / 100 + 1);
    	yadodai = DQR.calcPlayerStatus.calcShoninGold(yadodai, ep);

    	DqrBedEvent event = new DqrBedEvent(ep, 2, 0, new int[]{yadodai});
    	event.setCanceled(false);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return false;
		}

    	if(ep.isSneaking())
    	{
        	event = new DqrBedEvent(ep, 2, 1, new int[]{yadodai});
        	event.setCanceled(false);
    		MinecraftForge.EVENT_BUS.post(event);
    		if (event.isCanceled())
    		{
    			return false;
    		}

	    	if(gold - yadodai < 0)
	    	{
	    		ep.addChatMessage(new ChatComponentTranslation("msg.yadoya.messages.3.txt",new Object[] {yadodai}));
	    		return true;
	    	}

	    	//モンスターチェック
	    	if(!DQR.checkBed.checkMob(par1World, par2, par3, par4, ep))
	    	{
	    		ep.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
	    		return false;
	    	}

	    	//夜かどうかチェック
            if (!par1World.isRemote && par1World.isDaytime())
            {
            	ep.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
            	return false;
            }

            //寝ることができる
            if (!par1World.provider.canRespawnHere() || par1World.getBiomeGenForCoords(par2, par4) == BiomeGenBase.hell)
            {
            	ep.addChatComponentMessage(new ChatComponentTranslation("tile.bed.cantArea", new Object[0]));
            	return false;
            }
	    	//ブロックチェック

	    	event = new DqrBedEvent(ep, 2, 2, new int[]{yadodai});
	    	event.setCanceled(false);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled())
			{
				return false;
			}


			ep.setSpawnChunk(this.func_149977_a(par1World, par2, par3, par4, 0), false);


	    	ExtendedPlayerProperties.get(ep).setGold(gold - yadodai);
	    	ep.setHealth(ep.getMaxHealth());
	    	ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
	    	ep.getFoodStats().addStats(20, 0.6F);
	    	if(!ep.worldObj.isRemote)ep.worldObj.playSoundAtEntity(ep, "dqr:player.yado", 1.0F, 1.0F);

	    	event = new DqrBedEvent(ep, 2, 3, new int[]{yadodai});
	    	event.setCanceled(false);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled())
			{
				return false;
			}

    	}else
    	{
    		if(!par1World.isRemote)
    		{
    			ep.addChatMessage(new ChatComponentTranslation("msg.yadoya.messages.0.txt",new Object[] {yadodai}));
    			ep.addChatMessage(new ChatComponentTranslation("msg.yadoya.messages.1.txt",new Object[] {}));
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    		}
    	}


    	return true;
    }


    public void mdamaA(EntityPlayer ep, int Job, int pat)
    {
    	//String jobName = I18n.format("main.job." + Job);
    	//ep.addChatMessage(new ChatComponentTranslation("msg.startingJob.Set" + pat +".txt",new Object[] {jobName}));
    	ep.addChatMessage(new ChatComponentTranslation("msg.startingJob.Set" + pat +".txt",new Object[] {new ChatComponentTranslation("main.job." + Job)}));

    }

    public void mdamaB(EntityPlayer ep, int Job)
    {
    	for (int cnt = 0; cnt < 10; cnt ++)
    	{
    		//String message = I18n.format("msg.startingJob.jobInfo." + Job + "." + cnt + ".txt");
    		String message = String.format("msg.startingJob.jobInfo." + Job + "." + cnt + ".txt");
    		if (message.equalsIgnoreCase("")) break;

    		ep.addChatMessage(new ChatComponentTranslation(message,new Object[] {}));
    	}

    }

    public boolean isBed(IBlockAccess world, int x, int y, int z, EntityLivingBase player)
    {
        return true;
    }

    public static ChunkCoordinates func_149977_a(World p_149977_0_, int p_149977_1_, int p_149977_2_, int p_149977_3_, int p_149977_4_)
    {

    	/*
        int i1 = p_149977_0_.getBlockMetadata(p_149977_1_, p_149977_2_, p_149977_3_);
        int j1 = BlockDirectional.getDirection(i1);

        for (int k1 = 0; k1 <= 1; ++k1)
        {
            int l1 = p_149977_1_ - field_149981_a[j1][0] * k1 - 1;
            int i2 = p_149977_3_ - field_149981_a[j1][1] * k1 - 1;
            int j2 = l1 + 2;
            int k2 = i2 + 2;

            for (int l2 = l1; l2 <= j2; ++l2)
            {
                for (int i3 = i2; i3 <= k2; ++i3)
                {
                    if (World.doesBlockHaveSolidTopSurface(p_149977_0_, l2, p_149977_2_ - 1, i3) && !p_149977_0_.getBlock(l2, p_149977_2_, i3).getMaterial().isOpaque() && !p_149977_0_.getBlock(l2, p_149977_2_ + 1, i3).getMaterial().isOpaque())
                    {
                        if (p_149977_4_ <= 0)
                        {
                        	//System.out.println(l2 + "/" + p_149977_2_ + "/" + i3);
                            return new ChunkCoordinates(l2, p_149977_2_, i3);
                        }

                        --p_149977_4_;
                    }
                }
            }
        }
		*/

        //return null;

    	return new ChunkCoordinates(p_149977_1_, p_149977_2_, p_149977_3_);
    }


   public ChunkCoordinates getBedSpawnPosition(IBlockAccess world, int x, int y, int z, EntityPlayer player)
   {
       if (world instanceof World)
           return this.func_149977_a((World)world, x, y, z, 0);
       return null;
   }

}
