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
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemMagicBase;
import dqr.items.interfaceBase.ISubEquip;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmEntityNPCSyuuri extends DqmNPCBase
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

        if(this.getTameMode() != 0)
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

    public DqmEntityNPCSyuuri(World par1World)
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

    		int flg = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.SYURIYA.getId());

    		if(flg == 0 || ep.inventory.getCurrentItem() == null)
    		{
    			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.0.txt",new Object[] {}));
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SYURIYA.getId(), 1);
    		}else if(flg == 1)
    		{
    			//ItemStack its = ep.inventory.getCurrentItem();

    			if(its != null && its.getItem() == DQAccessories.itemAccCanceler)
    			{
        			int syuuriPrice = 0;

    		    	InventorySubEquip equipment = new InventorySubEquip(ep);
    		        equipment.openInventory();

    		        int syuuriMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_ACCCanceler.getId());

    		        if(syuuriMode == EnumDqmMGToolMode.ACCCANCELER_ACCONLY.getId() || syuuriMode == EnumDqmMGToolMode.ACCCANCELER_BOTH.getId())
    		        {

	    		        for(int cnt = 0; cnt < 12; cnt++)
	    		        {
	    		        	if(equipment.getStackInSlot(cnt) != null && (equipment.getStackInSlot(cnt).getItem() instanceof ISubEquip) && ((ISubEquip)equipment.getStackInSlot(cnt).getItem()).isDamageable2())
	    		        	{
	    		        		//EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(equipment.getStackInSlot(cnt).getItem());
	    		        		ItemStack stack = equipment.getStackInSlot(cnt);

	    		        		syuuriPrice = syuuriPrice + DQR.calcPlayerStatus.calcShoninGold(DQR.syuuriPrice.Gold(stack), ep);
	    		        	}
	    		        }
    		        }

    		        if(syuuriMode == EnumDqmMGToolMode.ACCCANCELER_ARMORONLY.getId() || syuuriMode == EnumDqmMGToolMode.ACCCANCELER_BOTH.getId())
    		        {
    		        	ItemStack[] armorList = ep.inventory.armorInventory;
    		        	for(int cnt = 0; cnt < armorList.length; cnt++)
    		        	{
    		        		if(armorList[cnt] != null)
    		        		{
    		        			int valPrice = DQR.calcPlayerStatus.calcShoninGold(DQR.syuuriPrice.Gold(armorList[cnt]), ep);
    		        			if(valPrice > 0)
    		        			{
    		        				syuuriPrice = syuuriPrice + valPrice;
    		        			}
    		        		}
    		        	}
    		        }

	    			if(syuuriPrice > 0)
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

	    	    				if(syuuriMode == EnumDqmMGToolMode.ACCCANCELER_ACCONLY.getId() || syuuriMode == EnumDqmMGToolMode.ACCCANCELER_BOTH.getId())
	    	    		        {
		    	    		        for(int cnt = 0; cnt < 12; cnt++)
		    	    		        {
		    	    		        	if(equipment.getStackInSlot(cnt) != null && (equipment.getStackInSlot(cnt).getItem() instanceof ISubEquip) && ((ISubEquip)equipment.getStackInSlot(cnt).getItem()).isDamageable2())
		    	    		        	{
		    	    		        		//EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(equipment.getStackInSlot(cnt).getItem());
		    	    		        		ItemStack stack = equipment.getStackInSlot(cnt);
		    	    		        		stack.setItemDamage(0);

		    	    		        		equipment.setInventorySlotContents(cnt, stack);
		    	    		        		equipment.markDirty();
		    	    		        		//syuuriPrice = syuuriPrice + DQR.syuuriPrice.Gold(stack);
		    	    		        	}
		    	    		        }
	    	    		        }

	    	    		        if(syuuriMode == EnumDqmMGToolMode.ACCCANCELER_ARMORONLY.getId() || syuuriMode == EnumDqmMGToolMode.ACCCANCELER_BOTH.getId())
	    	    		        {
	    	    		        	ItemStack[] armorList = ep.inventory.armorInventory;
	    	    		        	for(int cnt = 0; cnt < armorList.length; cnt++)
	    	    		        	{
	    	    		        		if(armorList[cnt] != null)
	    	    		        		{
	    	    		        			int valPrice = DQR.calcPlayerStatus.calcShoninGold(DQR.syuuriPrice.Gold(armorList[cnt]), ep);
	    	    		        			if(valPrice > 0)
	    	    		        			{
	    	    		        				armorList[cnt].setItemDamage(0);
	    	    		        				ep.inventory.markDirty();
	    	    		        			}
	    	    		        		}
	    	    		        	}
	    	    		        }

	    	    				ep.inventory.getCurrentItem().setItemDamage(0);
	    	    				ExtendedPlayerProperties.get(ep).setGold(epGold - syuuriPrice);
	    					}else
	    					{
	    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.4.txt",new Object[] {}));
	    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    					}
	    				}
	    			}else
	    			{
        				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.6.txt",new Object[] {}));
        				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    			}

    		        equipment.closeInventory();
    			}else
    			{
	    			int syuuriPrice = DQR.syuuriPrice.Gold(its);

	    			syuuriPrice = DQR.calcPlayerStatus.calcShoninGold(syuuriPrice, ep);
	    			if(syuuriPrice > 0)
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
	    	    				ExtendedPlayerProperties.get(ep).setGold(epGold - syuuriPrice);
	    					}else
	    					{
	    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.4.txt",new Object[] {}));
	    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    					}
	    				}
	    			}else
	    			{
	    				if(its.getMaxDamage() > 20 && !(its.getItem() instanceof DqmItemMagicBase))
	    				{
		    				if(!ep.isSneaking())
		    				{
			    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.1.txt",new Object[] {(its.getMaxDamage() * 10)}));
			    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.2.txt",new Object[] {}));
			    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		    				}else
		    				{
		    					int fixPrice = (its.getMaxDamage() * 10);
		    					fixPrice = DQR.calcPlayerStatus.calcShoninGold(fixPrice, ep);

		    					int epGold = ExtendedPlayerProperties.get(ep).getGold();
		    					if(epGold >= fixPrice)
		    					{
		    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.3.txt",new Object[] {fixPrice}));
		    	    				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

		    	    				ep.inventory.getCurrentItem().setItemDamage(0);
		    	    				ExtendedPlayerProperties.get(ep).setGold(epGold - fixPrice);
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
	    				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shopSyuriya.messages.5.txt",new Object[] {}));
	    				//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    			}
    			}
    			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SYURIYA.getId(), 1);
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
