package dqr.blocks.sekizou;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Blocks.DQSekizous;
import dqr.blocks.mobObj.tileEntity.DqmTileEntityObjSura;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizou;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouDarkRamia;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouDesupisaro1;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouEsterk;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouMasterdoragon;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouRyuuou;
import dqr.blocks.sekizou.tileEntity.DqmTileEntitySekizouZoma;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterBoss.DqmEntityDesupisaro1;
import dqr.entity.mobEntity.monsterBoss.DqmEntityEsterk;
import dqr.entity.mobEntity.monsterBoss.DqmEntityMasterdoragon;
import dqr.entity.mobEntity.monsterBoss.DqmEntityRyuuou;
import dqr.entity.mobEntity.monsterBoss.DqmEntityZoma;
import dqr.entity.mobEntity.monsterSP.DqmEntityDarkRamia;

public class DqmBlockSekizou extends BlockContainer
{
    public static String setmodel;
    private String model;
    private float rotationYaw;
    public int power = 0;
    public String mobName = null;

    public DqmBlockSekizou(Material var2, int pow, String name)
    {
        super(var2);
        this.power = pow;
        this.mobName = name;
        this.setBlockBounds(0.0f, 0.0F, 0.0f, 1.0f, 3.0f, 1.0f);
        //this.setTickRandomly(true);
        //光源
        //this.setLightValue(3.0F);
        //キューブサイズ
        //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    //1で光を通す 0で通さない
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    //trueで地面が透ける
    public boolean isOpaqueCube()
    {
        return false;
    }
    //trueでサイズ変更時もキューブサイズを維持する(炎が置ける) falseでサイズに合わせる
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    //フラワー系ののようにアイコンをレンダー -1は透明 10で階段
    public int getRenderType()
    {
        return -1;
    }
    //アイコン
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:BukiyaB");
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	DqmTileEntitySekizou tile = (DqmTileEntitySekizou) par1World.getTileEntity(par2, par3, par4);


    	if (tile != null && this.power == 1 && !par1World.isRemote)
        {

    		Block check1 = par1World.getBlock(tile.xCoord + 2, tile.yCoord, tile.zCoord + 2);
    		Block check2 = par1World.getBlock(tile.xCoord - 2, tile.yCoord, tile.zCoord + 2);
    		Block check3 = par1World.getBlock(tile.xCoord + 2, tile.yCoord, tile.zCoord - 2);
    		Block check4 = par1World.getBlock(tile.xCoord - 2, tile.yCoord, tile.zCoord - 2);

    		if(check1 == DQDecorates.DqmBlockKagaribidai &&
		   	   check1 == check2 && check2 == check3 && check3 == check4)
		    {

	    		int talkFlg = tile.getTalkFlg();
	    		int bossFlg = 0;

	    		talkFlg = talkFlg + 1;

	    		tile.setTalkFlg(talkFlg);
	    		if(this == DQSekizous.BlockSekizouZoma || this == DQSekizous.BlockSekizouRyuuou)
	    		{
	    			if(talkFlg > 6)
	    			{
	    				bossFlg = 1;
	    			}
	    		}else
	    		{
	    			if(talkFlg > 7)
	    			{
	    				bossFlg = 1;
	    			}
	    		}

	    		if(bossFlg == 1)
	    		{
	    			DqmMobBase mob = null;
	        		Item item = null;
	        		if(this == DQSekizous.BlockSekizouZoma)
	            	{
	        			mob = new DqmEntityZoma(par1World);
	        			item = Item.getItemFromBlock(DQSekizous.BlockSekizouZomaNo);
	            	}else if(this == DQSekizous.BlockSekizouDesupisaro1)
	            	{
	            		mob = new DqmEntityDesupisaro1(par1World);
	            		item = Item.getItemFromBlock(DQSekizous.BlockSekizouDesupisaro1No);
	            	}else if(this == DQSekizous.BlockSekizouEsterk)
	            	{
	            		mob = new DqmEntityEsterk(par1World);
	            		item = Item.getItemFromBlock(DQSekizous.BlockSekizouEsterkNo);
	            	}else if(this == DQSekizous.BlockSekizouMasterdoragon)
	            	{
	            		mob = new DqmEntityMasterdoragon(par1World);
	            		item = Item.getItemFromBlock(DQSekizous.BlockSekizouMasterdoragonNo);
	            	}else if(this == DQSekizous.BlockSekizouRyuuou)
	            	{
	            		mob = new DqmEntityRyuuou(par1World);
	            		item = Item.getItemFromBlock(DQSekizous.BlockSekizouRyuuouNo);
	            	}else if(this == DQSekizous.BlockSekizouDarkRamia)
	            	{
	            		mob = new DqmEntityDarkRamia(par1World);
	            		item = Item.getItemFromBlock(DQSekizous.BlockSekizouDarkRamiaNo);
	            	}

	    			EntityLightningBolt lb1 = new EntityLightningBolt(par1World, tile.xCoord + 2, tile.yCoord + 1, tile.zCoord + 2);
	    			EntityLightningBolt lb2 = new EntityLightningBolt(par1World, tile.xCoord - 2, tile.yCoord + 1, tile.zCoord + 2);
	    			EntityLightningBolt lb3 = new EntityLightningBolt(par1World, tile.xCoord + 2, tile.yCoord + 1, tile.zCoord - 2);
	    			EntityLightningBolt lb4 = new EntityLightningBolt(par1World, tile.xCoord - 2, tile.yCoord + 1, tile.zCoord - 2);

	        		par1World.addWeatherEffect(lb1);
	        		par1World.spawnEntityInWorld(lb1);
	        		par1World.addWeatherEffect(lb2);
	        		par1World.spawnEntityInWorld(lb2);
	        		par1World.addWeatherEffect(lb3);
	        		par1World.spawnEntityInWorld(lb3);
	        		par1World.addWeatherEffect(lb4);
	        		par1World.spawnEntityInWorld(lb4);

	        		mob.setLocationAndAngles((double)tile.xCoord + 0.5D, (double)tile.yCoord + 1.5D, (double)tile.zCoord + 0.5D, 0.0F, 0.0F);
	        		par1World.setBlockToAir(tile.xCoord, tile.yCoord, tile.zCoord);
	        		if(mob != null)
	        		{
	        			par1World.spawnEntityInWorld(mob);
	        		}
	        		if(item != null)
	        		{
	        			//mob.dropItem(item, 1);
	        			EntityItem eItem = new EntityItem(par1World, par5EntityPlayer.posX, par5EntityPlayer.posY + 1, par5EntityPlayer.posZ, new ItemStack(item, 1));
	        			par1World.spawnEntityInWorld(eItem);
	        		}
	    		}else
	    		{
		            AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)tile.xCoord, (double)tile.yCoord, (double)tile.zCoord, (double)(tile.xCoord + 1), (double)(tile.yCoord + 1), (double)(tile.zCoord + 1)).expand(10, 5, 10);
		            axisalignedbb.maxY = (double)par1World.getHeight();
		            List list = par1World.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
		            Iterator iterator = list.iterator();
		            EntityPlayer entityplayer;

		            while (iterator.hasNext())
		            {
		                entityplayer = (EntityPlayer)iterator.next();
		                DQR.func.doAddChatMessageFix(entityplayer, new ChatComponentTranslation("msg.sekizou." + this.mobName + ".talk." + talkFlg + ".txt",new Object[] {}));
		                entityplayer.worldObj.playSoundAtEntity(entityplayer, "dqr:player.pi", 1.0F, 1.0F);
		                //entityplayer.addPotionEffect(new PotionEffect(this.primaryEffect, 180, b0, true));
		            }
	    		}
		    }
        }

    	return true;
    }
    //TileEntityの指定
    public TileEntity createNewTileEntity(World var1, int par2)
    {
        //if(model == "000000000"){return new DqmTileEntity000000000();}
        //return new DqmTileEntityBukiya();
    	if(this == DQSekizous.BlockSekizouZoma)
    	{
    		return new DqmTileEntitySekizouZoma();
    	}else if(this == DQSekizous.BlockSekizouDesupisaro1)
    	{
    		return new DqmTileEntitySekizouDesupisaro1();
    	}else if(this == DQSekizous.BlockSekizouEsterk)
    	{
    		return new DqmTileEntitySekizouEsterk();
    	}else if(this == DQSekizous.BlockSekizouMasterdoragon)
    	{
    		return new DqmTileEntitySekizouMasterdoragon();
    	}else if(this == DQSekizous.BlockSekizouRyuuou)
    	{
    		return new DqmTileEntitySekizouRyuuou();
    	}else if(this == DQSekizous.BlockSekizouZomaNo)
    	{
    		return new DqmTileEntitySekizouZoma();
    	}else if(this == DQSekizous.BlockSekizouDesupisaro1No)
    	{
    		return new DqmTileEntitySekizouDesupisaro1();
    	}else if(this == DQSekizous.BlockSekizouEsterkNo)
    	{
    		return new DqmTileEntitySekizouEsterk();
    	}else if(this == DQSekizous.BlockSekizouMasterdoragonNo)
    	{
    		return new DqmTileEntitySekizouMasterdoragon();
    	}else if(this == DQSekizous.BlockSekizouRyuuouNo)
    	{
    		return new DqmTileEntitySekizouRyuuou();
    	}else if(this == DQSekizous.BlockSekizouDarkRamiaNo)
    	{
    		return new DqmTileEntitySekizouDarkRamia();
    	}else if(this == DQSekizous.BlockSekizouDarkRamia)
    	{
    		return new DqmTileEntitySekizouDarkRamia();
    	}

    	return new DqmTileEntityObjSura();
    }
    //ランダム
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //方角で角度を変更
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        //int l = par1World.getBlockMetadata(par2, par3, par4);
        if (l == 0)//南
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)//東
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)//北
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)//西
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	//System.out.println("TEST : " + this.getUnlocalizedName());
    }
    //方角でサイズを変更
    /*
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
        float f = 0.15F;

        if (l == 0)//南
        {
            this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
        }
        else if (l == 1)//東
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
        }
        else if (l == 2)//北
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
        }
        else if (l == 3)//西
        {
            this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        }

        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }
    */

}
