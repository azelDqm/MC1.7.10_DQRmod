package dqr.blocks.decorate;

import java.util.Random;

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
import dqr.blocks.decorate.tileEntity.DqmTileEntityRotonoturugiMob;

public class DqmBlockRotonoturugiMob extends BlockContainer
{
    public static String setmodel;
    public DqmBlockRotonoturugiMob(Material var2)
    {
        super( var2);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.00F, 1.0F);

    }

    //アイコン
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:EsterkSekizou");
    }
    //エンティティ
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntityRotonoturugiMob();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }
    /*
    public void kaiwa0(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "・・・・返事がない、ただの石像のようだ・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa1(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "少し反応があるようだ・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa2(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "少し動いたような気がした・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa3(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "まだまだ欲しているようだ・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa4(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "何か嫌な予感がする・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa5(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "何か特別なものを欲しがっている気がする・・・。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa6(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "神の創りしこの世界はありとあらゆる罪にまみれている。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa7(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "すべての罪にさばきを下さんとするならば";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa8(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "もはや世界をほろぼす他ない。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa9(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "……つばさなき天使よ。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa10(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "おまえは我が敵にはなりえぬ。";
        var1.sendChatToPlayer(var16);
    }
    public void kaiwa11(ICommandSender var1, String[] var2)
    {
        String var16;
        var16 = "身のほどを知るがいい！";
        var1.sendChatToPlayer(var16);
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer ep, int par6, float par7, float par8, float par9)
    {
        ItemStack var2 = ep.inventory.getCurrentItem();

        if (!par1World.isRemote)
        {
            if (var2 != null && var2.itemID == DqmItemList.Pisaronotamasii.itemID && ep.BazuzuSekizou == 30)
            {
                if (!par1World.isRemote)
                {
                    if (!ep.capabilities.isCreativeMode)
                    {
                        --var2.stackSize;
                    }
                }

                if (var2.stackSize <= 0)
                {
                    ep.inventory.setInventorySlotContents(ep.inventory.currentItem, (ItemStack)null);
                }

                if (!par1World.isRemote)
                {
                    ep.BazuzuSekizou = ep.BazuzuSekizou + 1;
                    kaiwa6(ep, null);
                    return true;
                }
            }

            if (ep.BazuzuSekizou == 30)
            {
                kaiwa5(ep, null);
                return true;
            }

            if (ep.BazuzuSekizou == 31)
            {
                ep.BazuzuSekizou = ep.BazuzuSekizou + 1;
                kaiwa7(ep, null);
                return true;
            }

            if (ep.BazuzuSekizou == 32)
            {
                ep.BazuzuSekizou = ep.BazuzuSekizou + 1;
                kaiwa8(ep, null);
                return true;
            }

            if (ep.BazuzuSekizou == 33)
            {
                ep.BazuzuSekizou = ep.BazuzuSekizou + 1;
                kaiwa9(ep, null);
                return true;
            }

            if (ep.BazuzuSekizou == 34)
            {
                ep.BazuzuSekizou = ep.BazuzuSekizou + 1;
                kaiwa10(ep, null);
                return true;
            }

            if (ep.BazuzuSekizou == 35)
            {
                DqmEntityNorowaretaturugi entitysilverfish = new DqmEntityNorowaretaturugi(par1World);
                entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitysilverfish);
                entitysilverfish.spawnExplosionParticle();
                par1World.playSoundAtEntity(ep, "ambient.weather.thunder", 1.0F, 1.0F);
                par1World.playSoundAtEntity(ep, "random.explode", 1.0F, 1.0F);
                kaiwa11(ep, null);
                ep.BazuzuSekizou = 30;
                return true;
            }

            if (var2 != null && var2.itemID == DqmItemList.Tiisaitamasii.itemID && ep.BazuzuSekizou <= 29)
            {
                if (!par1World.isRemote)
                {
                    if (!ep.capabilities.isCreativeMode)
                    {
                        --var2.stackSize;
                    }
                }

                if (var2.stackSize <= 0)
                {
                    ep.inventory.setInventorySlotContents(ep.inventory.currentItem, (ItemStack)null);
                }

                if (!par1World.isRemote)
                {
                    ep.BazuzuSekizou = ep.BazuzuSekizou + 1;

                    if (ep.BazuzuSekizou <= 7 && ep.BazuzuSekizou >= 1)
                    {
                        kaiwa1(ep, null);
                    }

                    if (ep.BazuzuSekizou <= 14 && ep.BazuzuSekizou >= 8)
                    {
                        kaiwa2(ep, null);
                    }

                    if (ep.BazuzuSekizou <= 22 && ep.BazuzuSekizou >= 15)
                    {
                        kaiwa3(ep, null);
                    }

                    if (ep.BazuzuSekizou <= 29 && ep.BazuzuSekizou >= 23)
                    {
                        kaiwa4(ep, null);
                    }

                    if (ep.BazuzuSekizou == 30)
                    {
                        kaiwa5(ep, null);
                    }
                }

                return true;
            }

            if (ep.BazuzuSekizou <= 0)
            {
                kaiwa0(ep, null);
                return true;
            }
        }

        return true;
    }
    */
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
    public int idDropped(int i, Random random, int j)
    {
        return 0;
    }
}
