package dqr.entity.npcEntity.npc;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmEntityNPCBank extends DqmNPCBase
{
    private int HP = 9999; //********

    private int PW = 100; //********
    private int DF = 100; //********
    private float SP = 0.0F; //********
    private String Name = "スティーブ";//********
    private String NameE = "SteveS";//********
    private boolean Fire = true;//******** true false
    protected void fall(float par1) {} //********
    @Override
    public void setDead()
    {
        super.setDead();
    }
    @Override
    public void onLivingUpdate()
    {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);

        super.onLivingUpdate();
    }
    @Override
    public boolean getCanSpawnHere()
    {
        int i;
        int j;
        int k;
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return super.getCanSpawnHere() && !(isValidLightLevel());
    }
    protected boolean isValidLightLevel()
    {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, var1, var2, var3) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int var4 = this.worldObj.getBlockLightValue(var1, var2, var3);

            if (this.worldObj.isThundering())
            {
                int var5 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 2;
                var4 = this.worldObj.getBlockLightValue(var1, var2, var3);
                this.worldObj.skylightSubtracted = var5;
            }

            return var4 <= this.rand.nextInt(8);
        }
    }

    @Override
    protected boolean canDespawn()
    {
        if (this.isTamed())
        {
            return false;
        }

        if(this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Blocks.brick_block)
        {
        	return false;
        }
        /*
        if (this.worldObj.getBlockId((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Block.brick.blockID || this.worldObj.getBlockId((int)this.posX, (int)this.posY - 1, (int)this.posZ) == DqmItemList.Kowarenai8.blockID)
        {
            return false;
        }
        */

        if(this.getTameMode() != 0)
        {
        	return false;
        }

        return true;
    }

    public DqmEntityNPCBank(World par1World)
    {
        super(par1World);
        setSize(0.8F, 1.5F);
        moveSpeed = SP;
        experienceValue = 0;
        isImmuneToFire = Fire;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        //this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        //this.tasks.addTask(4, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, this.moveSpeed, 3.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, this.moveSpeed));
        //	this.tasks.addTask(7, new EntityAIWander(this, this.moveSpeed));
        //this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;


    @Override	public int getTotalArmorValue()
    {
        return DF;
    }


    @Override	public boolean isAIEnabled()
    {
        return true;
    }
    @Override	public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    @Override
    public boolean interact(EntityPlayer ep)
    {
    	if(!ep.worldObj.isRemote)
    	{
    		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("testTESTtest"));

    		ItemStack its = ep.inventory.getCurrentItem();
    		if(its != null && its.getItem() == DQBuilders.itemBuilderKaikosyo && ep.isSneaking())
    		{
    			int confVal = DQR.conf.permBuilder5;
    			if(confVal != 0)
    			{
	    			//  && this.tameMode != 0
	    			boolean opFlg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());

	    			if((confVal == 3) ||
	    			   (confVal == 1 && opFlg) ||
	    			   (confVal == 2 && (opFlg || ep.getUniqueID().toString().equalsIgnoreCase(this.getOwnerUUID2()))))
	    			{
		    			ep.worldObj.playSoundAtEntity(ep, "dqr:mob.petmob", 1.0F, 0.5F);
		    			this.setDead();
		    			return true;
	    			}
    			}
    		}


    		int flg = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.BANK.getId());
    		int epMoney = ExtendedPlayerProperties.get(ep).getGold();

    		//System.out.println("DEBUG_LINE : " + flg);
    		if(flg > 7)
    		{
    			if(ep.isSneaking())
    			{
    					if(flg == 8 || flg == 14)
    					{
    						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.10.txt",new Object[] {}));
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.10.txt",new Object[] {}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 10);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 10)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.11.txt",new Object[] {}));
    						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.11.txt",new Object[] {}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 11);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 11)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.12.txt",new Object[] {}));
    						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.12.txt",new Object[] {}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 12);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 12)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.13.txt",new Object[] {}));
    						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.13.txt",new Object[] {}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 13);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 13)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.14.txt",new Object[] {}));
    						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.14.txt",new Object[] {}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 14);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}

    					return true;
    			}
    		}

    		if(flg < 7)
    		{
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages." + flg + ".txt",new Object[] {}));
    			DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages." + flg + ".txt",new Object[] {}));
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			if(flg + 1 <= 7)
    			{
    				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), flg + 1);
    			}
    		}else if(flg == 7 || flg == 8)
    		{
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.7.txt",new Object[] {}));
    			DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.7.txt",new Object[] {}));
    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANK.getId(), 8);
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    		}else if(flg == 14)
    		{
    			//換金
    			ItemStack epIts = null;
				int cashGold = -1;
    			if(ep.inventory.getCurrentItem() != null)
    			{
    				epIts = ep.inventory.getCurrentItem();

    				if(epIts.getItem() == DQMiscs.itemOkane)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.30.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.30.txt",new Object[] {}));
    					cashGold = 1000;
    				}else if(epIts.getItem() == DQMiscs.itemOkane10000)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.31.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.31.txt",new Object[] {}));
    					cashGold = 10000;
    				}else if(epIts.getItem() == DQMiscs.itemOkane100000)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.32.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.32.txt",new Object[] {}));
    					cashGold = 100000;
    				}else if(epIts.getItem() == DQMiscs.itemOkane1000000)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.33.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.33.txt",new Object[] {}));
    					cashGold = 1000000;
    				}else if(epIts.getItem() == DQMiscs.itemDouka)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.34.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.34.txt",new Object[] {}));
    					cashGold = 500;
    				}else if(epIts.getItem() == DQMiscs.itemGinka)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.35.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.35.txt",new Object[] {}));
    					cashGold = 3000;
    				}else if(epIts.getItem() == DQMiscs.itemKinka)
    				{
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.36.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.36.txt",new Object[] {}));
    					cashGold = 10000;
    				}

    				if(cashGold > 0)
    				{
	    				ep.inventory.getCurrentItem().stackSize = ep.inventory.getCurrentItem().stackSize - 1;
	    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages." + (10 + flg) + ".txt",new Object[] {}));
	    				ExtendedPlayerProperties.get(ep).setGold(epMoney + cashGold);

	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.okane", 1.0F, 1.0F);
    				}else
    				{
            			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.38.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.38.txt",new Object[] {}));
            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    				}
    			}else
    			{
        			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.37.txt",new Object[] {}));
    				DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.37.txt",new Object[] {}));
        			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			}
    		}else
    		{
    			//1000G袋 : 10
    			//10,000G袋 : 11
    			//100,000G袋 : 12
    			//1,000,000G袋 : 13

    			int rate = 0;
    			ItemStack itsOkane = null;
    			switch(flg)
    			{
    				case 10:rate = 1000; itsOkane = new ItemStack(DQMiscs.itemOkane, 1, 1); break;
    				case 11:rate = 10000; itsOkane = new ItemStack(DQMiscs.itemOkane10000, 1, 1); break;
    				case 12:rate = 100000; itsOkane = new ItemStack(DQMiscs.itemOkane100000, 1, 1); break;
    				case 13:rate = 1000000; itsOkane = new ItemStack(DQMiscs.itemOkane1000000, 1, 1); break;
    			}

    			if(epMoney >= rate)
    			{
    				if(ep.inventory.addItemStackToInventory(itsOkane))
    				{
	    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages." + (10 + flg) + ".txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages." + (10 + flg) + ".txt",new Object[] {}));
	    				ExtendedPlayerProperties.get(ep).setGold(epMoney - rate);

	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.okane", 1.0F, 1.0F);
    				}else
    				{
    					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.25.txt",new Object[] {}));
    					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.25.txt",new Object[] {}));
    				}
    			}else
    			{
    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.24.txt",new Object[] {}));
    				DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.Bank.messages.24.txt",new Object[] {}));
    			}
    		}
    	}

    	return true;
    }
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    public boolean canDespawn_CB()
    {
        return false;
    }
}
