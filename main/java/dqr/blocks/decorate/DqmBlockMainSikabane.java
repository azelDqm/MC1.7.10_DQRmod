package dqr.blocks.decorate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.decorate.tileEntity.DqmTileEntitySikabane;

public class DqmBlockMainSikabane extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockMainSikabane(Material var2)
    {
        super( var2);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        //ライト
        // this.setLightValue(0.9375F);
    }

    public DqmBlockMainSikabane setmodel(String m)
    {
        model = m;
        return this;
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
    /*
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(500, 0);

        if (x3 >= 490 && x3 <= 500)
        {
            j = DQR.miscs.itemLittlemedal5;
        }

        if (x3 >= 301 && x3 <= 489)
        {
            j = DqmItemList.Littlemedal.itemID;
        }

        if (x3 >= 201 && x3 <= 300)
        {
            j = Item.bone.itemID;
        }

        if (x3 >= 21 && x3 <= 200)
        {
            j = DqmItemList.Honehone.itemID;
        }

        if (x3 >= 11 && x3 <= 20)
        {
            j = DqmItemList.Sikabane.blockID;
        }

        return j;
    }
    */
    //アイコン
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:Sikabane");
    }

    //エンティティ
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntitySikabane();
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
