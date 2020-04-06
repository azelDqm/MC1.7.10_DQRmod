package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.potion.DQPotionPlus;

public class DqmKieruBlock extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmKieruBlock() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    public boolean getBlockId(World par3World, int x, int y, int z)
    {
    	/*
        return
            par3World.getBlockId(x, y, z) ==	Block.brick.blockID
            || par3World.getBlockId(x, y, z) ==	Block.chest.blockID
            || par3World.getBlockId(x, y, z) ==	Block.lavaStill.blockID
            || par3World.getBlockId(x, y, z) ==	Block.mobSpawner.blockID
            || par3World.getBlockId(x, y, z) ==	Block.stairsWoodOak.blockID
            || par3World.getBlockId(x, y, z) ==	Block.waterStill.blockID
            || par3World.getBlockId(x, y, z) ==	Block.stairsStoneBrick.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.DiamondB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.DiamondBB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.E.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.EmeraldB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.EmeraldBB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.GoldB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.GoldBB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.IronB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.IronBB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlock2.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlockTerepoBoss1.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlockTerepoBoss2.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlockTerepoBoss3.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlockTerepoBoss4.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.JampBlockTerepo.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kieru.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kowarenai1.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kowarenai2.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kowarenai3.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kowarenai8.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.KowarenaiDoor.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.KowarenaiDoor2.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.KowarenaiDoor3.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Kowareru8.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.N.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.S.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Set1.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.ToramanaYuka.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.Shoumetu.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.HikariB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.HikariB2.blockID
            || par3World.getBlockId(x, y, z) ==	50
            || par3World.getBlockId(x, y, z) ==	Block.stairsNetherQuartz.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.netherrackB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.netherrackBB.blockID
            || par3World.getBlockId(x, y, z) ==	DqmItemList.W.blockID;
            */
    	return false;
    }
    private int hakai;
    public void a(ICommandSender var1, String[] var2)
    {
        String var13 = "このブロックを素手でスニーク&右クリックでダンジョンを破壊することが出来ます。";
        //var1.sendChatToPlayer(var13);
    }
    public void b(ICommandSender var1, String[] var2)
    {
        String var13 = "本当に破壊していいのならスニーク&右クリックをして下さい。";
        //var1.sendChatToPlayer(var13);
    }
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer ep, int par6, float par7, float par8, float par9)
    {
        /*if (!ep.worldObj.isRemote)
        {
        	if(hakai==2)
            {
        		hakai=0;
            }
        	if(hakai==0)
            {
        		a(ep,null);
        		hakai=1;
        		return true;
            }
        	if(hakai==1)
            {
        		b(ep,null);
        		hakai=2;
        		return true;
            }
        }*/

        //Lv1
    	/*
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.GoldB.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -14; x <= 14; ++x)
                    {
                        for (int z = -2; z <= 26; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -14; x <= 14; ++x)
                {
                    for (int z = -2; z <= 26; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }
	**/
        //Lv2
    	/*
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.IronB.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -21; x <= 21; ++x)
                    {
                        for (int z = -2; z <= 40; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -21; x <= 21; ++x)
                {
                    for (int z = -2; z <= 40; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }
		*/
        //Lv3
    	/*
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.EmeraldB.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -28; x <= 28; ++x)
                    {
                        for (int z = -2; z <= 54; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -28; x <= 28; ++x)
                {
                    for (int z = -2; z <= 54; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }

        //Lv4
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.DiamondB.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -35; x <= 35; ++x)
                    {
                        for (int z = -2; z <= 68; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -35; x <= 35; ++x)
                {
                    for (int z = -2; z <= 68; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }

        //Lv5
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.Kowarenai8.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -36; x <= 36; ++x)
                    {
                        for (int z = -3; z <= 69; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -36; x <= 36; ++x)
                {
                    for (int z = -3; z <= 69; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }

        //LvA
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.netherrackB.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -42; x <= 42; ++x)
                    {
                        for (int z = -3; z <= 84; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -41; x <= 41; ++x)
                {
                    for (int z = -3; z <= 80; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }

        //石
        if (par1World.getBlockId(par2 + 1, par3, par4) == DqmItemList.Kowarenai1.blockID)
        {
            if (ep.isSneaking())
            {
                {
                    for (int x = -29; x <= 29; ++x)
                    {
                        for (int z = -2; z <= 56; ++z)
                        {
                            for (int y = -70; y <= 15; ++y)
                            {
                                if (getBlockId(par1World, par2 + x, par3 + y, par4 + z))
                                {
                                    par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }

                for (int x = -29; x <= 29; ++x)
                {
                    for (int z = -2; z <= 56; ++z)
                    {
                        for (int y = -70; y <= 15; ++y)
                        {
                            if (!(getBlockId(par1World, par2 + x, par3 + y, par4 + z)) && !(par1World.getBlockId(par2 + x, par3 + y, par4 + z) == 0) && par1World.getBlockId(par2 + x, par3 + y + 1, par4 + z) == 0)
                            {
                                par1World.setBlock(par2 + x, par3 + y + 1, par4 + z, DqmItemList.Shoumetu.blockID, 0, 2);
                            }
                        }
                    }
                }
            }
        }
		*/
        return true;
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity instanceof EntityPlayer)
        {
            EntityPlayer ep = (EntityPlayer)par5Entity;
            //par5Entity.attackEntityFrom(DamageSource.cactus, 1);
            //ep.jumpMovementFactor = ep.jumpMovementFactor+10*10;
            DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 20 * 60, 0));

            /*
            if (!ep.worldObj.isRemote)
            {
                ep.bosswaki1 = 0;
                ep.bosswaki2 = 0;
                ep.bosswaki3 = 0;
                ep.bosswaki4 = 0;
                ep.bosswaki5 = 0;
                a(ep, null);
            }
			*/
            /* {
             	for (int x = -35; x <= 35; ++x)
             	{
                 	for (int z = -1; z <= 70; ++z)
                 	{
                 		for (int y = -70; y <= 15; ++y)
                 		{
                 			if(getBlockId(par1World,par2+x, par3+y, par4+z))
                 			{
                 				par1World.setBlock(par2+x, par3+y, par4+z, 0, 0, 2);
                 			}
                 		}
                 	}
             	}
             }

             	for (int x = -35; x <= 35; ++x)
             	{
                 	for (int z = -1; z <= 70; ++z)
                 	{
                 		for (int y = -70; y <= 15; ++y)
                 		{
                 			if(!(getBlockId(par1World,par2+x, par3+y, par4+z))&&!(par1World.getBlockId(par2+x, par3+y, par4+z)==0)&&par1World.getBlockId(par2+x, par3+y+1, par4+z)==0)
                 			{
                 				par1World.setBlock(par2+x, par3+y+1, par4+z, DqmItemList.Shoumetu.blockID, 0, 2);
                 			}
                 		}
                 	}
             	}*/
            /*
            par1World.setBlock(par2 + 1, par3 + 3, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2, par3 + 3, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2 - 1, par3 + 3, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2 + 1, par3 + 2, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2, par3 + 2, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2 - 1, par3 + 2, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2 + 1, par3 + 1, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2, par3 + 1, par4 - 1, 0, 0, 2);
            par1World.setBlock(par2 - 1, par3 + 1, par4 - 1, 0, 0, 2);
            */
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
