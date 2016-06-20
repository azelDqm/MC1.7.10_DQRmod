package dqr.blocks.decorate;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQDecorates;
import dqr.api.enums.EnumDqmWorldType;
import dqr.blocks.decorate.tileEntity.DqmTileEntityTubokku;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterHell.DqmEntityTubokku;

public class DqmBlockTubokku2 extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockTubokku2(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
    }

    public DqmBlockTubokku2 setmodel(String m)
    {
        model = m;
        return this;
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        int x = 0;
        int x3 = x + getRandom(100, 0);
        int x4 = x + getRandom(2, 0);
        int x5 = x + getRandom(4, 0);

        Random rand = new Random();
        DqmMobBase spawnMob = null;
        ItemStack doropiItems = null;
        int rateMob = 0;
        int rateItem = 0;
        int dim = par1World.provider.dimensionId;

        rateItem = rand.nextInt(15);
        if(rateItem == 0)
        {
        	if (!par1World.isRemote)
        	{
	        	if(dim == 0)
	        	{
	        		par1World.setBlock(par2, par3, par4, Blocks.flowing_water, 0, 2);
	        	}else
	        	{
	        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
	        	}
        	}
        }else if(rateItem < 3)
        {
        	if (!par1World.isRemote)
        	{
        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
        	}
        }else
        {
        	if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        	{
        		spawnMob = new DqmEntityTubokku(par1World);

            	rateItem = rand.nextInt(50);

            	if(rateItem < 4)
            	{
            		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
            	}else if(rateItem < 5)
            	{
            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
            	}else if(rateItem < 10)
            	{
            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
            	}else if(rateItem < 25)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
            	}else if(rateItem < 40)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
            	}else
            	{
            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
            	}
        	}else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        	{
    			spawnMob = new DqmEntityTubokku(par1World);

            	rateItem = rand.nextInt(50);

            	if(rateItem < 5)
            	{
            		if(rand.nextInt(5) == 0)
            		{
            			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
            		}else
            		{
            			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
            		}
            	}else if(rateItem < 10)
            	{
            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
            	}else if(rateItem < 20)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
            	}else if(rateItem < 30)
            	{
            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
            	}else if(rateItem < 40)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
            	}else
            	{
            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
            	}
        	}else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        	{
    			spawnMob = new DqmEntityTubokku(par1World);

            	rateItem = rand.nextInt(50);

            	if(rateItem < 5)
            	{
            		if(rand.nextInt(5) == 0)
            		{
            			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
            		}else
            		{
            			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
            		}
            	}else if(rateItem < 10)
            	{
            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
            	}else if(rateItem < 20)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
            	}else if(rateItem < 30)
            	{
            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
            	}else if(rateItem < 40)
            	{
            		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
            	}else
            	{
            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
            	}
        	}


            if(rand.nextInt(8) == 0)
            {
            	spawnMob = null;
            }

            if(spawnMob == null && rand.nextInt(2) == 0)
            {
            	doropiItems = new ItemStack(DQDecorates.DqmBlockTubokku, 1);
            }

        }



        if (!par1World.isRemote)
        {
        	if(spawnMob != null)
        	{
        		spawnMob.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        	}

        	if(doropiItems != null)
        	{
        		this.dropBlockAsItem(par1World, par2, par3, par4, doropiItems);
        	}
        }
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return null;
    }
    /*
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(250, -150);

        if (x3 >= 243 && x3 <= 250)
        {
            j = DqmItemList.Littlemedal5.itemID;
        }

        if (x3 >= 190 && x3 <= 240)
        {
            j = DqmItemList.Littlemedal.itemID;
        }

        if (x3 >= 175 && x3 <= 180)
        {
            j = DqmItemList.Doragonkira.itemID;
        }

        if (x3 >= 165 && x3 <= 170)
        {
            j = DqmItemList.Gureitoakusu.itemID;
        }

        if (x3 >= 157 && x3 <= 162)
        {
            j = DqmItemList.Majinnokanaduti.itemID;
        }

        if (x3 >= 155 && x3 <= 156)
        {
            j = DqmItemList.Sinpinoyoroi.itemID;
        }

        if (x3 >= 147 && x3 <= 150)
        {
            j = DqmItemList.Sinkanohiseki.itemID;
        }

        if (x3 >= 136 && x3 <= 140)
        {
            j = DqmItemList.Rubinogenseki.itemID;
        }

        if (x3 >= 136 && x3 <= 130)
        {
            j = DqmItemList.Moon.itemID;
        }

        if (x3 >= 130 && x3 <= 137)
        {
            j = DqmItemList.Urokonoyoroi.itemID;
        }

        if (x3 >= 70 && x3 <= 75)
        {
            j = DqmItemList.Seinarunaifu.itemID;
        }

        if (x3 >= 63 && x3 <= 69)
        {
            j = DqmItemList.Haganenoyoroi.itemID;
        }

        if (x3 >= 60 && x3 <= 62)
        {
            j = DqmItemList.Haganenokabuto.itemID;
        }

        if (x3 >= 55 && x3 <= 59)
        {
            j = DqmItemList.Haganenokote.itemID;
        }

        if (x3 >= 50 && x3 <= 54)
        {
            j = DqmItemList.Haganenokutu.itemID;
        }

        //if(x3>=11 && x3<=30){j=DqmItemList.Tubokku.blockID;}
        if (x3 >= 1 && x3 <= 30)
        {
            j = DqmItemList.Konbou.itemID;
        }

        if (x3 >= -20 && x3 <= 0)
        {
            j = DqmItemList.Tokuyakusou.itemID;
        }

        if (x3 >= -40 && x3 <= -21)
        {
            j = DqmItemList.Dokukesisou.itemID;
        }

        if (x3 >= -60 && x3 <= -41)
        {
            j = DqmItemList.Tikaranotane.itemID;
        }

        if (x3 >= -80 && x3 <= -61)
        {
            j = DqmItemList.Subayasanotane.itemID;
        }

        if (x3 >= -100 && x3 <= -81)
        {
            j = DqmItemList.Mamorinotane.itemID;
        }

        if (x3 >= -120 && x3 <= -101)
        {
            j = DqmItemList.Kinkai.itemID;
        }

        //else{j=0;}
        return j;
    }
    */
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:Tubokku");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntityTubokku();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }
    /**
     * Called when the block is placed in the world.
     */
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
    public boolean renderAsNormalBlock()
    {
        return true;
    }
    /**
     * Called upon block activation (right click on the block.)
     */
    /*
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        if (var1.getBlockMetadata(var2, var3, var4) % 2 == 0)
        {
            int var10 = var1.getBlockMetadata(var2, var3, var4) + 1;
            var1.setBlock(var2, var3, var4, this.blockID, var10, 0);
        }
        else if (var1.getBlockMetadata(var2, var3, var4) % 2 == 1)
        {
            var1.setBlock(var2, var3, var4, this.blockID, var1.getBlockMetadata(var2, var3, var4) - 1, 0);
        }

        return true;
    }*/
    /*
        public int getLightValue(IBlockAccess var1, int var2, int var3, int var4)
        {
            return (var1.getBlockMetadata(var2, var3, var4) & 2) == 0 ? 14 : 0;
        }*/

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    /*
    public boolean renderAsNormalBlock()
    {
        return false;
    }*/

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    /*
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
        double var6 = (double)((float)var2 + 0.75F);
        double var8 = (double)((float)var3 + 0.7F);
        double var10 = (double)((float)var4 + 0.5F);
        double var12 = 0.2199999988079071D;
        double var14 = 0.27000001072883606D;

        if (var1.getBlockMetadata(var2, var3, var4) == 0 || var1.getBlockMetadata(var2, var3, var4) == 10)
        {
            var1.spawnParticle("flame", var6 - var14, var8 + var12, var10, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("smoke", var6 - var14, var8 + var12, var10, 0.0D, 0.0D, 0.0D);

            if (var1.getBlockMetadata(var2, var3, var4) >= 10)
            {
                var1.spawnParticle("flame", var6 - var14, var8 + var12, (double)((float)var4 + 0.75F), 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", var6 - var14, var8 + var12, (double)((float)var4 + 0.25F), 0.0D, 0.0D, 0.0D);
            }
            else
            {
                var1.spawnParticle("flame", (double)((float)var2 + 1.0F) - var14, var8 + var12, var10, 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", (double)((float)var2 + 0.5F) - var14, var8 + var12, var10, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    */

    /**
     * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
     * is the only chance you get to register icons.
     */

    /*
    public static int renderType;
    private DqmModelTubo mode = new DqmModelTubo();
    @SideOnly(Side.CLIENT)
    public void renderInvBlock(RenderBlocks var1, Block var2, int var3, int var4)
    {
        if (var4 == renderType)
        {
            Tessellator var5 = Tessellator.instance;
            RenderEngine var6 = ModLoader.getMinecraftInstance().renderEngine;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.5F, 1.9F, 0.5F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

            //if (var2 instanceof DqmBlockMain)
          //  {
                var6.bindTexture("/DQMII/Textures/BlockModel/Tubo.png");
                this.mode.modelRender(0.09F);
          //  }

            GL11.glPopMatrix();
        }
    }*/

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return false;
    }
}
