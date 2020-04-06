package dqr.gui.skillBook;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.DQR;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.playerData.ExtendedPlayerProperties5;

public class InventorySkillbook implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    //private ItemStack currentItem;
    private ItemStack[] items;
    private int maxSkillSetCount = 0;

    public InventorySkillbook(EntityPlayer ep, ItemStack book)
    {
    	int activeSkillCount = 0;
    	EnumDqmSkillJ[] skillSet = EnumDqmSkillJ.values();
    	maxSkillSetCount = 0;
    	for(int cnt = 0; cnt < skillSet.length; cnt++)
    	{
    		//items[activeSkillCount + 5] = new ItemStack(Items.apple, 1);
    		EnumDqmSkillJ skill = skillSet[cnt];
    		if(cnt == 0)
    		{
    			DQR.func.debugString("TEST1");
    			//items = new ItemStack[skill.getActiveSkillCount() + 5 + 2];
    			items = new ItemStack[skill.getActiveSkillCount() + 5 + 2];

    			/*
    			for(int cnt2 = 0; cnt2 < 5; cnt2++)
    			{
    				items[cnt2] = new ItemStack(Items.apple);
    			}
    			*/


    			NBTTagCompound nbt2 = book.getTagCompound();

    			if(nbt2 == null)
    			{
    				nbt2 = new NBTTagCompound();
    			}
    			for(int bookCnt = 0; bookCnt < 5; bookCnt++)
    			{
    				if(nbt2.hasKey("skill" + bookCnt + "_job") && nbt2.hasKey("skill" + bookCnt + "_idx") &&
    						nbt2.getInteger("skill" + bookCnt + "_job") > -1 && nbt2.getInteger("skill" + bookCnt + "_idx") > -1)
    				{
    					EnumDqmSkillJ skill2 = DQR.enumGetter.getSkillJ(nbt2.getInteger("skill" + bookCnt + "_job"), nbt2.getInteger("skill" + bookCnt + "_idx"));

    					if(skill2 != null)
    					{
    						DQR.func.debugString("TEST6");
		    				ItemStack skillItem = new ItemStack(DQR.func.getJobSPSkillItemFromJobId(nbt2.getInteger("skill" + bookCnt + "_job")), 1);

		    				NBTTagCompound nbt = skillItem.getTagCompound();
			            	if(nbt == null)
			            	{
			            		nbt = new NBTTagCompound();
			            	}

			            	nbt.setInteger("isJobSkill", 1);
			            	nbt.setInteger("jobId", skill2.getJob());
			            	nbt.setInteger("skillIdx", skill2.getIdx());
			            	nbt.setInteger("skillId", skill2.getId());
			            	//nbt.setS("jskillinfo", "dqm.skill.JSkill_" + skill.getJob() + "_" + skill.getIdx() + ".info");

			            	skillItem.setTagCompound(nbt);
			            	skillItem.setStackDisplayName("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".name");

		    				items[bookCnt] = skillItem;
    					}

    				}else
    				{
    					nbt2.setInteger("skill" + bookCnt + "_job",-1);
    					nbt2.setInteger("skill" + bookCnt + "_idx",-1);
    				}
    			}
    			//book.setTagCompound(nbt2);


    		}


    		if(skill.getActiveskill() == 1)
    		{
    			int skillPerm = ExtendedPlayerProperties5.get(ep).getJobSPSkillSet(skill.getJob(), skill.getIdx());
    			if(skillPerm != 0)
    			{

    				if(DQR.func.getJobSPSkillItemFromJobId(skill.getJob()) != null)
    				{
	    				ItemStack skillItem = new ItemStack(DQR.func.getJobSPSkillItemFromJobId(skill.getJob()), 1);

	    				NBTTagCompound nbt = skillItem.getTagCompound();
		            	if(nbt == null)
		            	{
		            		nbt = new NBTTagCompound();
		            	}

		            	nbt.setInteger("isJobSkill", 1);
		            	nbt.setInteger("jobId", skill.getJob());
		            	nbt.setInteger("skillIdx", skill.getIdx());
		            	nbt.setInteger("skillId", skill.getId());
		            	//nbt.setS("jskillinfo", "dqm.skill.JSkill_" + skill.getJob() + "_" + skill.getIdx() + ".info");

		            	skillItem.setTagCompound(nbt);
		            	skillItem.setStackDisplayName("dqm.skill.JSkill_" + skill.getJob() + "_" + skill.getIdx() + ".name");

	    				items[activeSkillCount + 5] = skillItem;
	    				maxSkillSetCount = maxSkillSetCount + 1;
    				}
    			}

    			activeSkillCount = activeSkillCount + 1;
    		}


    	}
        //inventoryPlayer = inventory;
        //currentItem = inventoryPlayer.getCurrentItem();

    	//int weaponID = ExtendedPlayerProperties.get(ep).getWeapon();

    	/*
    	if(DQR.debug != 0)
    	{
    		weaponID = 13;
    	}
    	*/

    	//TreeMap<Integer, EnumDqmSkillW> skills = DQR.enumGetter.getSkillW(weaponID);



        //InventorySize
        //items = new ItemStack[10];
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


        /*
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
        */
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
    	if(p_70299_1_ >= 0 && p_70299_1_ < this.items.length )
    	{
	        this.items[p_70299_1_] = p_70299_2_;

	        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
	        {
	            p_70299_2_.stackSize = this.getInventoryStackLimit();
	        }
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

    /*
    public Item getJobSPSkillItemFromJobId(int par1)
    {
    	switch(par1)
    	{
    	case 0: return DQEmblems.itemEmbCivilian;
    	case 1: return DQEmblems.itemEmbWarrior;
    	case 2: return DQEmblems.itemEmbFighter;
    	case 3: return DQEmblems.itemEmbBattleMaster;
    	case 4: return DQEmblems.itemEmbMagician;
    	case 5: return DQEmblems.itemEmbPriest;
    	case 6: return DQEmblems.itemEmbSage;
    	case 7: return DQEmblems.itemEmbHero;
    	case 8: return DQEmblems.itemEmbPaladin;
    	case 9: return DQEmblems.itemEmbMagickKnight;
    	case 10: return DQEmblems.itemEmbRanger;
    	case 11: return DQEmblems.itemEmbMonsterTamer;
    	case 12: return DQEmblems.itemEmbSuperStar;
    	case 13: return DQEmblems.itemEmbHaguremetal;
    	case 14: return DQEmblems.itemEmbMerchant;
    	case 15: return DQEmblems.itemEmbThief;
    	case 16: return DQEmblems.itemEmbGodHnad;
    	case 17: return DQEmblems.itemEmbDragon;
    	case 18: return DQEmblems.itemEmbLegend;
    	case 19: return DQEmblems.itemEmbDancer;
    	case 20: return DQEmblems.itemEmbPirate;
    	case 21: return DQEmblems.itemEmbMasterDragon;
    	case 22: return DQEmblems.itemEmbHituzikai;
    	case 23: return DQEmblems.itemEmbFunanori;
    	case 24: return DQEmblems.itemEmbDougutukai;
    	case 25: return DQEmblems.itemEmbTentiraimeishi;
    	default : return null;
    	}
    }
    */
}
