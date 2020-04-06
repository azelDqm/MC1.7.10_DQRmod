package dqr.gui.dama;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmSkillW;
import dqr.packetMessage.MessageServerDataSend;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiSkillWeaponContainer extends Container
{
    private InventorySkillWeapon inventory;
    private EntityPlayer ep;

    public GuiSkillWeaponContainer(EntityPlayer ep)
    {
    	DQR.func.debugString("TEST!!! A1 : " + ep.worldObj.isRemote ,this.getClass());
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	this.ep = ep;
    	inventory = new InventorySkillWeapon(ep);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        //for (int j = 0; j < 3; ++j)
        //{
        for (int k = 0; k < 10; ++k)
        {
            this.addSlotToContainer(new SlotSkillWeapon(inventory, k + 0 * 9, 8 + k * 18, 18 + 0 * 18));
        }
        //}

        /*
        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotJobChange(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotJobChange(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }
        */

    }

    /*
        Containerが開いてられるか
     */
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public void refreshInventory()
    {
    	DQR.func.debugString("TEST!!! A2 : " + ep.worldObj.isRemote ,this.getClass());
    	/*
    	if(!ep.worldObj.isRemote)
		{
			PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
		}
		*/
    	this.inventorySlots = new ArrayList();
    	//inventory.closeInventory();
    	inventory = new InventorySkillWeapon(ep);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        //for (int j = 0; j < 3; ++j)
        //{
        for (int k = 0; k < 10; ++k)
        {
            this.addSlotToContainer(new SlotSkillWeapon(inventory, k + 0 * 9, 8 + k * 18, 18 + 0 * 18));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < this.inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            /*
            //シフトクリック時に、このアイテムだったら動かさない。
            else if(slot.getStack() != null && slot.getStack().getItem() == DQR.instance.InventoryItemJobChange)
            {
                return null;
            }
            */
            else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /*
        Containerを閉じるときに呼ばれる
     */
    /*
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.inventory.closeInventory();
    }
    */
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
		if(p_75134_1_.worldObj.isRemote)
    	{
			NBTTagCompound data = new NBTTagCompound();
			ExtendedPlayerProperties3.get(p_75134_1_).saveNBTData(data);
    		PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 3));
    	}

		//FuncJobSkillData.calcPlayerStatus(p_75134_1_);
		//FuncJobSkillData.calcPlayerStatus2(p_75134_1_);

        this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {
    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	if(par1 >= 0 && par1 < inventorySlots.size())
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	    		NBTTagCompound nbt = slot.getStack().getTagCompound();
	    		if(nbt != null)
	    		{
	    			int skillPoint = nbt.getInteger("skill_point");
	    			int skillFunc = nbt.getInteger("skill_func");

	    			//System.out.println("TEST?" + skillPoint);
	    			if(skillPoint > 0)
	    			{
	    				DQR.func.debugString("TEST!!! 1" ,this.getClass());
	    				EnumDqmSkillW skillW =  DQR.enumGetter.getSkillW(nbt.getInteger("weaponId"), nbt.getInteger("CategCode"));

	    				int needWP = skillW.getPOINT();
	    	        	int nowWP = ExtendedPlayerProperties.get(ep).getJukurenWP(nbt.getInteger("weaponId"));
	    	        	int needLv = skillW.getNeedLv();
	    	        	int nowLv = ExtendedPlayerProperties.get(ep).getJukurenLv(nbt.getInteger("weaponId"));

	    	        	//System.out.println("？？？？:" + needWP + "/" + nowWP );
	    	        	int perm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(nbt.getInteger("weaponId"), nbt.getInteger("CategCode"));
	    	        	if(perm == 0 || DQR.debug == 1)
	    	        	{
	    	        		DQR.func.debugString("TEST!!! 2" ,this.getClass());
	    		        	if(needLv <= nowLv || DQR.debug == 1)
	    		        	{
	    			        	if(needWP <= nowWP || DQR.debug == 1)
	    			        	{
	    			        		String skillName = StatCollector.translateToLocal("dqm.skill." + skillW.getName() + ".name");
	    			        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama3.messages.20.txt" ,new Object[] {skillName}));
	    			        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 0.9F);
	    			        		ExtendedPlayerProperties.get(ep).setJukurenWP(nbt.getInteger("weaponId"), nowWP - needWP);
	    			        		ExtendedPlayerProperties3.get(ep).setWeaponSkillPermission(nbt.getInteger("weaponId"), nbt.getInteger("CategCode"), 1);
	    			        		//((ExtendedPlayerProperties)(ep.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);
	    			        		//((ExtendedPlayerProperties3)(ep.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);
	    			        		//DQR.func.debugString("TESTTEST : " + ep.worldObj.isRemote);
	    			        		//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(ep), (EntityPlayerMP)ep);
	    			        	}else
	    			        	{
	    			        		if(!ep.worldObj.isRemote)
	    			        		{
	    			        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama3.messages.40.txt" ,new Object[] {}));
	    			        		}
	    			        	}
	    		        	}else
	    		        	{
	    		        		if(!ep.worldObj.isRemote)
	    		        		{
	    		        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama3.messages.42.txt" ,new Object[] {}));
	    		        		}
	    		        	}
	    	        	}
	    				/*
	    				PacketHandler.INSTANCE.sendToServer(new MessageServerSkillWeapon(nbt.getInteger("weaponId"),
	    																			 	 nbt.getInteger("CategCode"),
	    																			 	 0));
	    				 */

	    			}else
	    			{
	    				DQR.func.debugString("TEST!!! 3" ,this.getClass());
	    				if(skillFunc == 1)
	    				{
	    					DQR.func.debugString("TEST!!! 4" ,this.getClass());
		            		int perm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(nbt.getInteger("weaponId"), nbt.getInteger("CategCode"));
		            		//if(perm == 1 && ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(nbt.getInteger("weaponId")) != nbt.getInteger("CategCode"))
		            		if(perm == 1)
		            		{
		            			//int setSkill =  ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(pat);
		            			int wSetSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(nbt.getInteger("weaponId"));

		            			//DQR.func.debugString("TESTTEST : " + wSetSkill + " / " + nbt.getInteger("CategCode"));
		            			if(nbt.getInteger("CategCode") == wSetSkill)
		            			{
		            				ExtendedPlayerProperties3.get(ep).setWeaponSkillSet(nbt.getInteger("weaponId"), -1);
		            				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		            			}else
		            			{
		            				ExtendedPlayerProperties3.get(ep).setWeaponSkillSet(nbt.getInteger("weaponId"), nbt.getInteger("CategCode"));
		            				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		            			}
		            		}
	    					/*
	    					PacketHandler.INSTANCE.sendToServer(new MessageServerSkillWeapon(nbt.getInteger("weaponId"),
	    														nbt.getInteger("CategCode"),
	    														1));
	    														*/
	    				}
	    			}
	    		}

	    		/*
	    		if(ep.worldObj.isRemote)
	    		{
	    			Minecraft.getMinecraft().thePlayer.closeScreen();
	    			Minecraft.getMinecraft().setIngameFocus();
	    		}
	    		*/



	   			//System.out.println("1:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());
	    		/*
	    		if(slot.getStack().getItem() instanceof DqmItemEmblemBase)
	    		{
	    			//System.out.println("2:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());

	        		DqmItemEmblemBase emb = (DqmItemEmblemBase)slot.getStack().getItem();
	    			PacketHandler.INSTANCE.sendToServer(new MessageServerJobChange(emb.getJobEnum().getId()));
	        		//ExtendedPlayerProperties.get(ep).setJob(emb.getJobEnum().getId());
	        		//ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
	    		}

	    		//System.out.println(slot.getStack().getDisplayName());
	    		if(ep.worldObj.isRemote)
	    		{
	    			Minecraft.getMinecraft().thePlayer.closeScreen();
	    			Minecraft.getMinecraft().setIngameFocus();
	    		}
	    		*/



	    	}
    	}

    	this.refreshInventory();
    	return null;
    }
}
