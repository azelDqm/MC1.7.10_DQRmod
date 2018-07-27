package dqr.items.builder;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import dqr.DQR;
import dqr.api.enums.EnumDqmBuilder;
import dqr.items.base.DqmItemBuilderBase;
import dqr.thread.ThreadBuilderFrame;
import dqr.thread.ThreadBuilderSekizou;

public class DqmItemBuilderSekizou extends DqmItemBuilderBase{

	public Block sekizouType = null;

	public DqmItemBuilderSekizou(EnumDqmBuilder par1)
	{
		super(par1);
	}

	public DqmItemBuilderSekizou(EnumDqmBuilder par1, Block par2)
	{
		super(par1);
		this.sekizouType = par2;

	}

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {

		if(!par3World.isRemote)
		{

			boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(par2EntityPlayer.getGameProfile());
			if(DQR.conf.permBuilder6 == 2 || (DQR.conf.permBuilder6 == 1 && flg))
			{
				;
			}else
			{
				DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.perm.txt",new Object[] {}));
				par2EntityPlayer.worldObj.playSoundAtEntity(par2EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return false;
			}

	        if(DQR.conf.permBossAlter == 2 || (DQR.conf.permBossAlter == 1 && par3World.provider.dimensionId == 0))
	        {
	        	;
	        }else
	        {
				DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.notDim.txt",new Object[] {}));
				par2EntityPlayer.worldObj.playSoundAtEntity(par2EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return false;
	        }
		}

        if (par7 == 0)
        {
            --par5;
        }

        if (par7 == 1)
        {
            ++par5;
        }

        if (par7 == 2)
        {
            --par6;
        }

        if (par7 == 3)
        {
            ++par6;
        }

        if (par7 == 4)
        {
            --par4;
        }

        if (par7 == 5)
        {
            ++par4;
        }

        //DQR.func.debugString("Root2");

   		int l = MathHelper.floor_double((double)(par2EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		int mSize = this.buildEnum.getSize();
		int mHeight = this.buildEnum.getHeight();
		int mUnder = this.buildEnum.getUnder();
		IChunkProvider iChunk = par3World.getChunkProvider();


    	if(!par2EntityPlayer.isSneaking())
    	{
    		//DQR.func.debugString("Root3");
    		NBTTagCompound nbt = par1ItemStack.getTagCompound();

    		//フレーム設置処理クラスをここでCALL
    		/*
    		if(nbt != null && nbt.getInteger("buildReady") == -1)
    		{
    			DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.0.txt",new Object[] {}));
    			return false;
    		}else
    		{
	        	if(nbt == null || nbt.getInteger("settingY") == -1 )
	        	{
	        		DQR.func.debugString("Root4");

	            	nbt = new NBTTagCompound();
	            	nbt.setInteger("settingX", par4);
	            	nbt.setInteger("settingY", par5);
	            	nbt.setInteger("settingZ", par6);
	            	//nbt.setInteger("buildReady", -1);
	            	par1ItemStack.setTagCompound(nbt);

	            	//DqmWorldGenBuildFrame obj = new DqmWorldGenBuildFrame(l, par5, mSize, mHeight, mUnder);
	            	//obj.generate(new Random(), par4, par6, par3World, iChunk, iChunk);

	            	DQR.func.debugString("Root5");
	                ThreadBuilderFrame builderThread = new ThreadBuilderFrame(par3World, l, mSize, mHeight, mUnder, par1ItemStack, 0);
	                builderThread.start();

	        		if(!par3World.isRemote)
	        		{
	        			DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.1.txt",new Object[] {}));
	        			DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.2.txt",new Object[] {}));
	        		}
	        	}else
	        	{
	                ThreadBuilderFrame builderThread = new ThreadBuilderFrame(par3World, l, mSize, mHeight, mUnder, par1ItemStack, 1);
	                builderThread.start();
	        	}
    		}
    		*/
        	if(nbt == null || nbt.getInteger("buildReady") == -1 )
        	{
        		DQR.func.debugString("Root4");

            	nbt = new NBTTagCompound();
            	nbt.setInteger("settingX", par4);
            	nbt.setInteger("settingY", par5);
            	nbt.setInteger("settingZ", par6);
            	nbt.setInteger("settingFace", l);
            	nbt.setInteger("buildReady", 1);
            	par1ItemStack.setTagCompound(nbt);

            	//DqmWorldGenBuildFrame obj = new DqmWorldGenBuildFrame(l, par5, mSize, mHeight, mUnder);
            	//obj.generate(new Random(), par4, par6, par3World, iChunk, iChunk);

            	//DQR.func.debugString("Root5");
                ThreadBuilderFrame builderThread = new ThreadBuilderFrame(par3World, mSize, mHeight, mUnder, par1ItemStack, 0);
                builderThread.start();

        		if(!par3World.isRemote)
        		{
        			DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.1.txt",new Object[] {}));
        			DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.2.txt",new Object[] {}));
        		}
        	}else
        	{
            	if(!par3World.isRemote)
            	{
	                ThreadBuilderFrame builderThread = new ThreadBuilderFrame(par3World, mSize, mHeight, mUnder, par1ItemStack, 1);
	                builderThread.start();
            	}
            	nbt.setInteger("buildReady", -1);
            	par1ItemStack.setTagCompound(nbt);
        	}


    	}else
    	{
    		NBTTagCompound nbt = par1ItemStack.getTagCompound();
        	if(nbt == null || nbt.getInteger("buildReady") == -1)
        	{
        		if(DQR.conf.needBuilderFrame1 == 1)
        		{
        			if(!par3World.isRemote)
        			{
        				DQR.func.doAddChatMessageFix(par2EntityPlayer, new ChatComponentTranslation("msg.Builder.messages.need.txt",new Object[] {}));
        				par2EntityPlayer.worldObj.playSoundAtEntity(par2EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
        			}
        			return false;
        		}else
        		{
		        		nbt = new NBTTagCompound();
			        	nbt.setInteger("settingX", par4);
			        	nbt.setInteger("settingY", par5);
			        	nbt.setInteger("settingZ", par6);
			        	nbt.setInteger("settingFace", l);
			        	nbt.setInteger("buildReady", 1);
			        	par1ItemStack.setTagCompound(nbt);
        		}
        	}

        	if(!par3World.isRemote)
        	{
        		ThreadBuilderSekizou builderThread = new ThreadBuilderSekizou(par3World, mSize + 1, mHeight, mUnder, par1ItemStack, this.sekizouType);
        		builderThread.start();
        	}

        	par1ItemStack.stackSize--;
    	}

    	return true;
    }
}
