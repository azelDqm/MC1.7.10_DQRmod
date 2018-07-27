package dqr.gui.dama;

import java.util.TreeMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.DQR;
import dqr.api.Items.DQSkills;
import dqr.api.enums.EnumDqmSkillW;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class InventorySkillWeapon implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    //private ItemStack currentItem;
    private ItemStack[] items;

    public InventorySkillWeapon(EntityPlayer ep)
    {
        //inventoryPlayer = inventory;
        //currentItem = inventoryPlayer.getCurrentItem();

    	int weaponID = ExtendedPlayerProperties.get(ep).getWeapon();

    	/*
    	if(DQR.debug != 0)
    	{
    		weaponID = 13;
    	}
    	*/

    	TreeMap<Integer, EnumDqmSkillW> skills = DQR.enumGetter.getSkillW(weaponID);



        //InventorySize
        items = new ItemStack[10];
        /*
        items[0] = new ItemStack(DQEmblems.itemDamaCivilian, 1);
        items[1] = new ItemStack(DQEmblems.itemDamaWarrior, 1);
        items[2] = new ItemStack(DQEmblems.itemDamaFighter, 1);
        items[3] = new ItemStack(DQEmblems.itemDamaMagician, 1);
        items[4] = new ItemStack(DQEmblems.itemDamaPriest, 1);
        items[5] = new ItemStack(DQEmblems.itemDamaMerchant, 1);
        items[6] = new ItemStack(DQEmblems.itemDamaThief, 1);
        items[7] = new ItemStack(DQEmblems.itemDamaThief, 1);
        items[8] = new ItemStack(DQEmblems.itemDamaThief, 1);
        items[9] = new ItemStack(DQEmblems.itemDamaThief, 1);
        */


        for (int key : skills.keySet()) {
        	EnumDqmSkillW skillEnum = (EnumDqmSkillW)skills.get(key);

        	int wPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weaponID, key);
        	int wSetSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(weaponID);
        	Item skillItem = null;

        	if(skillEnum.getNeedLv() <= ExtendedPlayerProperties.get(ep).getJukurenLv(weaponID) || DQR.debug != 0)
        	{
	        	if(wPerm == 0)
	        	{
	        		skillItem = skillEnum.getSkillItem0();
	        	}else
	        	{
	        		skillItem = skillEnum.getSkillItem1();
	        	}

	        	if(skillItem != null)
	        	{
	        		items[key] = new ItemStack(skillItem, 1);

	            	NBTTagCompound nbt = items[key].getTagCompound();
	            	if(nbt == null)
	            	{
	            		nbt = new NBTTagCompound();
	            	}

	            	nbt.setInteger("weaponId", skillEnum.getWeaponId());
	            	nbt.setInteger("CategCode", skillEnum.getCategCode());

	            	nbt.setString("skill_name", skillEnum.getName());
	            	//nbt.setInteger("skill_name", 0);
	            	nbt.setInteger("skill_func", skillEnum.getFunc());
	            	if(wPerm == 0)
	            	{
	            		nbt.setInteger("skill_point", skillEnum.getPOINT());
	            		nbt.setInteger("skill_Equip", 0);
	            	}else
	            	{
	            		nbt.setInteger("skill_point", 0);
	            		if(key == wSetSkill)
	            		{
	            			nbt.setInteger("skill_Equip", 1);
	            		}
	            	}

	            	nbt.setInteger("skill_hpup", skillEnum.getHPUP());
	            	nbt.setInteger("skill_mpup", skillEnum.getMPUP());
	            	nbt.setInteger("skill_atkup", skillEnum.getATKUP());
	            	nbt.setInteger("skill_defup", skillEnum.getDEFUP());
	            	nbt.setInteger("skill_magup", skillEnum.getMAGUP());
	            	nbt.setInteger("skill_strup", skillEnum.getSTRUP());
	            	nbt.setInteger("skill_agiup", skillEnum.getAGIUP());
	            	nbt.setInteger("skill_intup", skillEnum.getINTUP());
	            	nbt.setInteger("skill_critup", skillEnum.getCRITUP());
	            	nbt.setInteger("skill_missup", skillEnum.getMISSUP());

	            	items[key].setTagCompound(nbt);

	            	//String skillName = StatCollector.translateToLocal("dqm.skill." + skillEnum.getName() + ".name");
	            	//items[key].setStackDisplayName(skillName);
	            	items[key].setStackDisplayName("dqm.skill." + skillEnum.getName() + ".name");
	        	}
        	}
        	//items[key] = new ItemStack(skills.get(key), 1);

        }
    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return items[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.items[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.items[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.items[p_70298_1_];
                this.items[p_70298_1_] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.items[p_70298_1_].splitStack(p_70298_2_);

                if (this.items[p_70298_1_].stackSize == 0)
                {
                    this.items[p_70298_1_] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.items[p_70304_1_] != null)
        {
            ItemStack itemstack = this.items[p_70304_1_];
            this.items[p_70304_1_] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.items[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return "InventoryItem";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return true;
    }

    /*
        Containerが開かれたタイミングでItemStackの持っているNBTからアイテムを読み込んでいる
     */
    @Override
    public void openInventory()
    {
    	/*
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");

        for(int i = 0; i < tags.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
            int slot = tagCompound.getByte("Slot");
            if(slot >= 0 && slot < items.length)
            {
                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        */
    }

    /*
        Containerを閉じるときに保存
     */
    @Override
    public void closeInventory()
    {
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte)i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }
        //ItemStack result = new ItemStack(currentItem.getItem(), 1);
        //result.setTagCompound(new NBTTagCompound());
        //result.getTagCompound().setTag("Items", tagList);

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

    public Item getSkillItemFromWeaponId(int par1)
    {
    	switch(par1)
    	{
    		case 2: return DQSkills.itemSkillW_20;
    		case 3: return DQSkills.itemSkillW_30;
    		case 4: return DQSkills.itemSkillW_40;
    		case 5: return DQSkills.itemSkillW_50;
    		case 6: return DQSkills.itemSkillW_60;
    		case 7: return DQSkills.itemSkillW_70;
    		case 8: return DQSkills.itemSkillW_80;
    		case 9: return DQSkills.itemSkillW_90;
    		case 10: return DQSkills.itemSkillW_100;
    		case 11: return DQSkills.itemSkillW_110;
    		case 12: return DQSkills.itemSkillW_120;
    		case 13: return DQSkills.itemSkillW_130;
    		case 24: return DQSkills.itemSkillW_240;
    		case 25: return DQSkills.itemSkillW_250;

    	}

    	return null;
    }
}
