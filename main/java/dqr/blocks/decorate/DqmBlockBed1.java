package dqr.blocks.decorate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.event.DqrBedEvent;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDqmbed;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmBlockBed1 extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockBed1(Material var2)
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

    public DqmBlockBed1 setmodel(String m)
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
        this.blockIcon = var1.registerIcon("dqr:DqmbedB");
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int p_149915_2_)
    {

        return new DqmTileEntityDqmbed();
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
		//外部からの干渉用
		DqrBedEvent event = new DqrBedEvent(ep, 1, 0, new int[]{yadodai});
		event.setCanceled(false);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return false;
		}
		//yadodai = event.param[0];
    	if(ep.isSneaking())
    	{
    		event = new DqrBedEvent(ep, 1, 1, new int[]{yadodai});
    		event.setCanceled(false);
    		MinecraftForge.EVENT_BUS.post(event);
    		if (event.isCanceled())
    		{
    			return false;
    		}

	    	if(gold - yadodai < 0)
	    	{
	    		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.yadoya.messages.3.txt",new Object[] {yadodai}));
	    		DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.yadoya.messages.3.txt",new Object[] {yadodai}));
	    		return true;
	    	}

	    	//モンスターチェック
	    	if(!DQR.checkBed.checkMob(par1World, par2, par3, par4, ep))
	    	{
	    		//ep.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
	    		DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
	    		return false;
	    	}

	    	//ブロックチェック

    		event = new DqrBedEvent(ep, 1, 2, new int[]{yadodai});
    		event.setCanceled(false);
    		MinecraftForge.EVENT_BUS.post(event);
    		if (event.isCanceled())
    		{
    			return false;
    		}


	    	ExtendedPlayerProperties.get(ep).setGold(gold - yadodai);
	    	ep.setHealth(ep.getMaxHealth());
	    	ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());

	    	//ペットの回復処理
	    	DQR.checkBed.healPet(par1World, par2, par3, par4, ep);

	    	ep.getFoodStats().addStats(20, 0.6F);
	    	if(!ep.worldObj.isRemote)
	    	{
	    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.yado", 1.0F, 1.0F);
	    	}

    		event = new DqrBedEvent(ep, 1, 3, new int[]{yadodai});
    		event.setCanceled(false);
    		MinecraftForge.EVENT_BUS.post(event);
    		if (event.isCanceled())
    		{
    			return false;
    		}

			if(!par1World.isRemote)
			{
		        for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
		        {
		            WorldServer worldserver = MinecraftServer.getServer().worldServers[j];

		            long setTime = worldserver.getWorldTime();
		            worldserver.setWorldTime(setTime + (long)(12 * 1000));
		            /*
					long setTime = worldserver.getWorldTime() % 24000;
		            if(setTime + (long)(12 * 1000) >= 24000)
		            {
		            	worldserver.setWorldTime(setTime + (long)(12 * 1000) - 24000);
		            }else
		            {
		            	worldserver.setWorldTime(setTime + (long)(12 * 1000));
		            	//System.out.println("DEBUG : " + worldserver.getWorldTime());
		            }
		            */
		        }
			}

    		event = new DqrBedEvent(ep, 1, 4, new int[]{yadodai});
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
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.yadoya.messages.0.txt",new Object[] {yadodai}));
    			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.yadoya.messages.0.txt",new Object[] {yadodai}));
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.yadoya.messages.1.txt",new Object[] {}));
    			DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.yadoya.messages.1.txt",new Object[] {}));
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    		}
    	}


    	return true;
    }



}
