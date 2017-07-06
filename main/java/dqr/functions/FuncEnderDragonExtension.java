package dqr.functions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import dqr.api.event.DqrEntityDragonEvent;

public class FuncEnderDragonExtension {

	public boolean hookDestroyBlocksInAABB(AxisAlignedBB p_70972_1_, EntityDragon dragon)
	{
		//System.out.println("ENDORA_TEST2");
		//return false;
		Random rand = new Random();
        int var2 = MathHelper.floor_double(p_70972_1_.minX);
        int var3 = MathHelper.floor_double(p_70972_1_.minY);
        int var4 = MathHelper.floor_double(p_70972_1_.minZ);
        int var5 = MathHelper.floor_double(p_70972_1_.maxX);
        int var6 = MathHelper.floor_double(p_70972_1_.maxY);
        int var7 = MathHelper.floor_double(p_70972_1_.maxZ);
        boolean var8 = false;
        boolean var9 = false;

        for (int var10 = var2; var10 <= var5; ++var10)
        {
            for (int var11 = var3; var11 <= var6; ++var11)
            {
                for (int var12 = var4; var12 <= var7; ++var12)
                {
                    Block var13 = dragon.worldObj.getBlock(var10, var11, var12);


                    if (var13.getMaterial() != Material.air)
                    {
                        DqrEntityDragonEvent event = new DqrEntityDragonEvent.BlockDestroyEvent(dragon, var13);
                		event.setCanceled(false);
                		MinecraftForge.EVENT_BUS.post(event);
                		if (!event.isCanceled())
                		{
	                        if (var13 != Blocks.obsidian && var13 != Blocks.end_stone && var13 != Blocks.bedrock && dragon.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
	                        {
	                            var9 = dragon.worldObj.setBlockToAir(var10, var11, var12) || var9;
	                        }
	                        else
	                        {
	                            var8 = true;
	                        }
                		}else
                		{
                			var8 = true;
                		}
                    }

                }
            }
        }

        if (var9)
        {
            double var16 = p_70972_1_.minX + (p_70972_1_.maxX - p_70972_1_.minX) * (double)rand.nextFloat();
            double var17 = p_70972_1_.minY + (p_70972_1_.maxY - p_70972_1_.minY) * (double)rand.nextFloat();
            double var14 = p_70972_1_.minZ + (p_70972_1_.maxZ - p_70972_1_.minZ) * (double)rand.nextFloat();
            dragon.worldObj.spawnParticle("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
        }

        return var8;
	}

	public boolean hookCreateEnderPortal(EntityDragon dragon, int p_70975_1_, int p_70975_2_)
	{
		//System.out.println("ENDORA_TEST1");
        DqrEntityDragonEvent.CreateEnderPortalEvent event = new DqrEntityDragonEvent.CreateEnderPortalEvent(dragon, p_70975_1_, p_70975_2_);
		MinecraftForge.EVENT_BUS.post(event);
		return event.getCreateResult();
	}
}
