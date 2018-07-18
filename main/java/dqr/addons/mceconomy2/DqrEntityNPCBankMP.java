package dqr.addons.mceconomy2;

import java.text.NumberFormat;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import shift.mceconomy2.api.MCEconomyAPI;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqrEntityNPCBankMP extends DqmNPCBase
{
    private int HP = 9999; //********

    private int PW = 100; //********
    private int DF = 100; //********
    private float SP = 0.0F; //********
    private String Name = "スティーブ";//********
    private String NameE = "SteveMP";//********
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

        /*
        if (this.worldObj.getBlockId(var1, var2 - 1, var3) == DqmItemList.Shoumetu.blockID)
        {
            this.setDead();
        }
		*/
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
        		/*
            this.worldObj.getBlockId(var1, var2 - 1, var3) == 1 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 2 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 3 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 12 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 18 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 31 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 78 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 87 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 98  && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 110 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 112 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 121 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0;
            */
        // || this.isValidLightLevel() && super.getCanSpawnHere();
        //   return super.getCanSpawnHere() && isValidLightLevel();
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

        return true;
    }

    public DqrEntityNPCBankMP(World par1World)
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

    /*
    public void Nedan(ICommandSender var1, String[] var2)
    {
        EntityPlayer ep = (EntityPlayer)var1;
        String var13;
        String var14;
        var13 = "そうだな、そいつの修理なら " + ep.SyuuriGold + " Gになるがどうする？";
        var1.sendChatToPlayer(var13);
        var14 = "修理するならスニーク状態で、もう一度その武具で話しかけるんだな。";
        var1.sendChatToPlayer(var14);
    }
    public void Syuuri(ICommandSender var1, String[] var2)
    {
        EntityPlayer ep = (EntityPlayer)var1;
        String var13;
        String var14;
        var13 = ep.SyuuriGold + " G支払った。またきな！";
        var1.sendChatToPlayer(var13);
    }
    public void Taranai(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "金が足らないようだな。";
        var1.sendChatToPlayer(var13);
    }
    public void No(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "悪いが、そいつは修理できねぇな。";
        var1.sendChatToPlayer(var13);
    }
    public void Event(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "よう！修理したい武具があれば直してやるぞ！";
        var1.sendChatToPlayer(var13);
    }
    public void Nakama(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "いつも助かるぜ！これからはお前専属の修理屋となろう！どこへでも着いていくぜ！";
        var1.sendChatToPlayer(var13);
    }
    */
    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;

    /*
    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (rand.nextInt(1) == 0)
        {
            this.dropItem(DqmItemList.Se.itemID, 1);   //1
        }
    }
    */

    @Override	public int getTotalArmorValue()
    {
        return DF;
    }
    /*
    @Override	public int getAttackStrength(Entity par1Entity)
    {
        return PW;
    }
    */
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

    		int flg = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.BANKMP.getId());
    		int epMoney = ExtendedPlayerProperties.get(ep).getGold();
    		int rate = DQR.addons.rateMP;
    		NumberFormat nfNum = NumberFormat.getNumberInstance();

    		//System.out.println("DEBUG_LINE : " + flg);
    		if(flg > 9)
    		{
    			if(ep.isSneaking())
    			{

    					if(flg == 10 || flg == 1000000)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.1000.txt",new Object[]{nfNum.format(rate)}));
    						DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.1000.txt",new Object[]{nfNum.format(rate)}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), 1000);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 1000)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.10000.txt",new Object[]{nfNum.format(rate * 10)}));
    						DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.10000.txt",new Object[]{nfNum.format(rate * 10)}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), 10000);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 10000)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.100000.txt",new Object[] {nfNum.format(rate * 100)}));
    						DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.100000.txt",new Object[] {nfNum.format(rate * 100)}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), 100000);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}else if(flg == 100000)
    					{
    		    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.1000000.txt",new Object[] {nfNum.format(rate * 1000)}));
    						DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.1000000.txt",new Object[] {nfNum.format(rate * 1000)}));
    		    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), 1000000);
    		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}

    					return true;
    			}
    		}



    		ItemStack epIts = null;

			if(ep.inventory.getCurrentItem() != null)
			{
				epIts = ep.inventory.getCurrentItem();
				int cashGold = -1;

				//System.out.println("TEST;" + rate);
				if(epIts.getItem() == DQMiscs.itemOkane)
				{
					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.1000.txt",new Object[] {}));
					cashGold = rate;
					//System.out.println("TEST1;" + cashGold);
				}else if(epIts.getItem() == DQMiscs.itemOkane10000)
				{
					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.10000.txt",new Object[] {}));
					cashGold = rate * 10;
					//System.out.println("TEST2;" + cashGold);
				}else if(epIts.getItem() == DQMiscs.itemOkane100000)
				{
					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.100000.txt",new Object[] {}));
					cashGold = rate * 100;
					//System.out.println("TEST3;" + cashGold);
				}else if(epIts.getItem() == DQMiscs.itemOkane1000000)
				{
					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.1000000.txt",new Object[] {}));
					cashGold = rate * 1000;
					//System.out.println("TEST4;" + cashGold);
				}

				if(cashGold > 0)
				{
					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.100.txt",new Object[] {nfNum.format(cashGold)}));
					DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.100.txt",new Object[] {nfNum.format(cashGold)}));
    				ep.inventory.getCurrentItem().stackSize = ep.inventory.getCurrentItem().stackSize - 1;
    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages." + (10 + flg) + ".txt",new Object[] {}));
    				//ExtendedPlayerProperties.get(ep).setGold(epMoney + cashGold);
    				MCEconomyAPI.addPlayerMP(ep, cashGold, false);
    				//ep.worldObj.playSoundAtEntity(ep, "dqr:player.okane", 1.0F, 1.0F);
    				ep.worldObj.playSoundAtEntity(ep, "mceconomy2:coin", 0.6f, 0.8f);

    				return true;
				}
			}



    		if(flg < 9)
    		{
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages." + flg + ".txt",new Object[] {}));
    			DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages." + flg + ".txt",new Object[] {}));
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			if(flg + 1 <= 9)
    			{
    				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), flg + 1);
    			}
    		}else if(flg == 9 || flg == 10)
    		{
    			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.9.txt",new Object[] {}));
    			DQR.func.doAddChatMessageFix(ep,new ChatComponentTranslation("msg.BankMP.messages.9.txt",new Object[] {}));
    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BANKMP.getId(), 10);
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    		}else
    		{

        			ItemStack itsOkane = null;
        			int mpValue = 0;
        			switch(flg)
        			{
        				case 1000:mpValue = rate; itsOkane = new ItemStack(DQMiscs.itemOkane, 1, 1); break;
        				case 10000:mpValue = rate * 10; itsOkane = new ItemStack(DQMiscs.itemOkane10000, 1, 1); break;
        				case 100000:mpValue = rate * 100; itsOkane = new ItemStack(DQMiscs.itemOkane100000, 1, 1); break;
        				case 1000000:mpValue = rate * 1000; itsOkane = new ItemStack(DQMiscs.itemOkane1000000, 1, 1); break;
        			}

        			if(MCEconomyAPI.getPlayerMP(ep) >= mpValue)
        			{
        				if(ep.inventory.addItemStackToInventory(itsOkane))
        				{
    	    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.101.txt",new Object[] {nfNum.format(flg)}));
        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.101.txt",new Object[] {nfNum.format(flg)}));
    	    				MCEconomyAPI.reducePlayerMP(ep, mpValue, false);
    	    				//ExtendedPlayerProperties.get(ep).setGold(epMoney - rate);

    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.okane", 1.0F, 1.0F);
        				}else
        				{
        					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
        					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.25.txt",new Object[] {}));
        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bank.messages.25.txt",new Object[] {}));
        				}
        			}else
        			{
        				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
        				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.24.txt",new Object[] {}));
        				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.BankMP.messages.24.txt",new Object[] {}));
        			}
    			}
    			//1000G袋 : 10
    			//10,000G袋 : 11
    			//100,000G袋 : 12
    			//1,000,000G袋 : 13

    			//int rate = 0;

    	}

    		/*

    		else if(flg == 1)
    		{
    			ItemStack its = ep.inventory.getCurrentItem();
    			int syuuriPrice = DQR.syuuriPrice.Gold(its);
    			if(syuuriPrice >= 0)
    			{
    				if(!ep.isSneaking())
    				{
	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.1.txt",new Object[] {syuuriPrice}));
	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.2.txt",new Object[] {}));
	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    				}else
    				{
    					int epGold = ExtendedPlayerProperties.get(ep).getGold();
    					if(epGold >= syuuriPrice)
    					{
    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.3.txt",new Object[] {syuuriPrice}));
    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

    	    				ep.inventory.getCurrentItem().setItemDamage(0);
    	    				//ExtendedPlayerProperties.get(ep).setGold(epGold - syuuriPrice);
    					}else
    					{
    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.4.txt",new Object[] {}));
    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    					}
    				}
    			}else
    			{
    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.5.txt",new Object[] {}));
    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			}
    			ExtendedPlayerProperties.get(ep).setNpcTalk(0, 1);
    		}
    	}
    	*/
    	/*
        int ran = rand.nextInt(20) + 1;
        int ran2 = rand.nextInt(8) + 1;
        int boss = rand.nextInt(4);
        ItemStack var2 = ep.inventory.getCurrentItem();

        //魔法の筒******************************************************************************************************
        if (var2 != null && var2.itemID == DqmItemList2.ItemMahounoTutu03ID)
        {
            if (!this.worldObj.isRemote)
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

            if (!this.worldObj.isRemote)
            {
                int setDamage = 0;
                if(this.isTamed())
                {
                    setDamage = setDamage + 1000000000;
                }
                ep.sendChatToPlayer("イルイル！！");
                this.worldObj.playSoundAtEntity(this, "DQM_Sound.Fire", 0.8F, 1.0F);
                this.entityDropItem(new ItemStack(DqmItemList2.ItemTutuEventSyuuriID, 1, setDamage), 0.0F);
                this.setDead();
            }

            return true;
        }

        if (!(var2 != null) && this.isTamed())
        {
        	this.
            this.setOwner(ep.getCommandSenderName());
            this.aiSit.setSitting(!this.isSitting());
            this.isJumping = false;
            this.worldObj.playSoundAtEntity(this, "DQM_Sound.Pi", 1.0F, 1.0F);
            return true;
        }

        if (ep.SyuuriLV >= 50000 && this.getHealth() >= 1 && !(this.isTamed()))
        {
            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(1) == 0)
                {
                    this.setTamed(true);
                    this.setAttackTarget((EntityLiving)null);
                    this.aiSit.setSitting(true);
                    this.worldObj.playSoundAtEntity(this, "DQM_Sound.Pet", 1.0F, 1.0F);
                    this.setOwner(ep.username);
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                    Nakama(ep, null);
                    ep.SyuuriLV = 0;
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        if (!this.worldObj.isRemote)
        {
            if (flag2 == 0)
            {
                Event(ep, null);
                flag2 = 1;
                return true;
            }

            if (var2 != null && var2.itemID == DqmEventSyuuriGold.Gold(var2, ep) && ID == DqmEventSyuuriGold.Gold(var2, ep) && flag10 == 1 && !(ep.isSneaking()))
            {
            	//ver1.50
	            //Nedan(ep, null);
	            //return true;
            	if (ep.SyuuriGold == 99999999)
            	{
            		No(ep, null);
	                return true;
            	}else
            	{
	                Nedan(ep, null);
	                return true;
            	}
            }

            if (var2 != null && var2.itemID == DqmEventSyuuriGold.Gold(var2, ep) && ID == DqmEventSyuuriGold.Gold(var2, ep) && flag10 == 1 && ep.isSneaking())
            {
                if (ep.SyuuriGold == 99999999)
                {
                    No(ep, null);
                    flag10 = 0;
                    return true;
                }

                if (ep.Gold >= ep.SyuuriGold)
                {
                    if (var2 != null && var2.itemID == DqmEventSyuuriGold.Gold(var2, ep))
                    {
                        if (!this.worldObj.isRemote)
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

                        if (!this.worldObj.isRemote)
                        {
                            if (this.rand.nextInt(1) == 0)
                            {
                                this.worldObj.playSoundAtEntity(this, "DQM_Sound.Pi", 1.0F, 1.0F);
                                Syuuri(ep, null);
                                ep.Gold = ep.Gold - ep.SyuuriGold;
                                ep.dropItem(DqmEventSyuuriGold.Gold(var2, ep), 1);

                                if (!(this.isTamed()))
                                {
                                    ep.SyuuriLV = ep.SyuuriLV + ep.SyuuriGold;
                                }
                            }
                        }
                    }

                    return true;
                }

                if (ep.Gold < ep.SyuuriGold)
                {
                    Taranai(ep, null);
                    flag10 = 0;
                    return true;
                }

                return true;
            }

            ep.SyuuriGold = 99999999;

            if (var2 != null && var2.itemID == DqmEventSyuuriGold.Gold(var2, ep) && flag10 == 0)
            {
                if (ep.SyuuriGold != 99999999)
                {
	                Nedan(ep, null);
	                flag10 = 1;
	                ID = DqmEventSyuuriGold.Gold(var2, ep);
	                Nedan = ep.SyuuriGold;
	                return true;
                }else
                {
                    No(ep, null);
                    flag10 = 0;
                    return true;
                }
            }

            flag10 = 0;
            return true;
        }

        return true;
        */
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
