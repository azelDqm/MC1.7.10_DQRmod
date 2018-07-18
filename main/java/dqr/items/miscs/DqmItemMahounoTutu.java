package dqr.items.miscs;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumColor;
import dqr.entity.petEntity.DqmPetBase;
import dqr.items.base.DqmItemMiscBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemMahounoTutu extends DqmItemMiscBase{

    public DqmItemMahounoTutu()
    {
        this.setMaxStackSize(1);
    }


    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return false;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    /*
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new EntityEgg(p_77659_2_, p_77659_3_));
        }

        return p_77659_1_;
    }
    */

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(par3World.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) &&
		   par3World.isAirBlock(p_77648_4_, p_77648_5_ + 2, p_77648_6_))
		{

        	int petCount = ExtendedPlayerProperties3.get(ep).getPetCount();

        	boolean flg = false;
        	if(!par3World.isRemote)
        	{
        		flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());
        	}

        	if(DQR.conf.petLimitPlayer == 0 || petCount < DQR.conf.petLimit || (flg && DQR.conf.petLimitPlayer == 1))
        	{
				Random rand = new Random();
				--par1ItemStack.stackSize;
				if(rand.nextInt(4) == 0)
				{
					ep.inventory.mainInventory[ep.inventory.currentItem] = new ItemStack(DQMiscs.ItemMahounoTutu01B, 1);
				}else
				{
					ep.inventory.mainInventory[ep.inventory.currentItem] = new ItemStack(DQMiscs.ItemMahounoTutu01, 1);
				}
				//ep.inventory.currentItem

				par3World.playSoundAtEntity(ep, "dqr:mob.inoti", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

				NBTTagCompound nbt = par1ItemStack.getTagCompound();

				if(nbt != null)
				{
					String mobBaseName = nbt.getString("PetBaseName");
					nbt.setString("OwnerUUID", ep.getUniqueID().toString());

					DqmPetBase entityPet = (DqmPetBase)EntityList.createEntityByName(mobBaseName, par3World);

					//entityPet.writeToNBT(nbt);
					entityPet = setNBT(nbt, entityPet, ep);

					entityPet.setTamed(true);
					entityPet.ownerName = ep.getCommandSenderName();

	                String s = null;

	                if(!ep.worldObj.isRemote)
	                {
	                	s = PreYggdrasilConverter.func_152719_a(ep.getCommandSenderName());
			            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
			            {
			            	entityPet.ownerUUID = s;
			            }
	                }

	                if(!ep.worldObj.isRemote)
	                {
	                	entityPet.setLocationAndAngles((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 1.5D, (double)p_77648_6_ + 0.5D, 0.0F, 0.0F);
	                	par3World.spawnEntityInWorld(entityPet);

	                    ExtendedPlayerProperties3.get(ep).plusPetCount(1);
	                    DQR.petFunc.setNewPetdata(entityPet);
	                }

				}
        	}else
        	{
        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.petTame.maxnumber.txt",new Object[] {}));
        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
        	}

			return true;

		}else
		{

		}

		return false;
    }


	   public DqmPetBase setNBT(NBTTagCompound p_70037_1_, DqmPetBase pet, EntityPlayer ep)
	    {
	        //super.readEntityFromNBT(p_70037_1_);

		    pet.setJob(p_70037_1_.getInteger("Job"));
	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobLv(cnt, p_70037_1_.getInteger("JobLv_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobExp(cnt, p_70037_1_.getInteger("JobExp_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobSp(cnt, p_70037_1_.getInteger("JobSp_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobHP(cnt, p_70037_1_.getInteger("JobHP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobMP(cnt, p_70037_1_.getInteger("JobMP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobTikara(cnt, p_70037_1_.getInteger("JobTikara_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobKasikosa(cnt, p_70037_1_.getInteger("JobKasikosa_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayHP(cnt, p_70037_1_.getInteger("arrayHP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMP(cnt, p_70037_1_.getInteger("arrayMP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayATK(cnt, p_70037_1_.getInteger("arrayATK_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMAG(cnt, p_70037_1_.getInteger("arrayMAG_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayDEF(cnt, p_70037_1_.getInteger("arrayDEF_" + cnt));
	        }



	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayTikara(cnt, p_70037_1_.getInteger("arrayTikara_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMamori(cnt, p_70037_1_.getInteger("arrayMamori_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArraySubayasa(cnt, p_70037_1_.getInteger("arraySubayasa_" + cnt));
	        	//arraySubayasa[cnt] = p_70037_1_.getInteger("arraySubayasa_" + cnt);
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayKasikosa(cnt, p_70037_1_.getInteger("arrayKasikosa_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setJukurenLv(cnt, p_70037_1_.getInteger("JukurenLv_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setJukurenExp(cnt, p_70037_1_.getInteger("JukurenExp_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setArrayAILimit(cnt, p_70037_1_.getInteger("arrayAILimit_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setArrayAIMaster(cnt, p_70037_1_.getInteger("arrayAIMaster_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setArrayAISets(cnt, p_70037_1_.getInteger("arrayAISets_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setArrayAIRate(cnt, p_70037_1_.getInteger("arrayAIRate_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setArrayAIRateDef(cnt, p_70037_1_.getInteger("arrayAIRateDef_" + cnt));
	        }

	        pet.setFlgAIextended(p_70037_1_.getInteger("flgAIextended"));
	        pet.setFlgAIuse(p_70037_1_.getInteger("flgAIuse"));

	        pet.setTamingTime(p_70037_1_.getLong("tamingTime"));

	        pet.setKougeki(p_70037_1_.getInteger("Kougeki"));
	        pet.setBougyo(p_70037_1_.getInteger("Bougyo"));
	        pet.setMaryoku(p_70037_1_.getInteger("Maryoku"));

	        pet.setTikara(p_70037_1_.getInteger("Tikara"));
	        pet.setMikawasi(p_70037_1_.getInteger("Mikawasi"));
	        pet.setKasikosa(p_70037_1_.getInteger("Kasikosa"));

	        pet.setKaisinritu(p_70037_1_.getInteger("Kaisinritu"));
	        pet.setKaisinMin(p_70037_1_.getInteger("KaisinMin"));
	        pet.setKaisinMax(p_70037_1_.getInteger("KaisinMax"));

	        pet.setGold(p_70037_1_.getInteger("Gold"));
	        pet.setMedal(p_70037_1_.getInteger("Medal"));
	        pet.setCoin(p_70037_1_.getInteger("Coin"));
	        pet.setKillCount(p_70037_1_.getInteger("KillCount"));
	        pet.setDeathCount(p_70037_1_.getInteger("DeathCount"));

	        pet.setHP(p_70037_1_.getFloat("HP"));
	        pet.setHealth(p_70037_1_.getFloat("HP"));
	        pet.setMaxHP(p_70037_1_.getFloat("MaxHP"));
	        pet.setMP(p_70037_1_.getInteger("MP"));
	        pet.setMaxMP(p_70037_1_.getInteger("MaxMP"));
	        pet.setWeapon(p_70037_1_.getInteger("weapon"));

	        for(int cnt = 0; cnt < 4; cnt++)
	        {
	        	//pet.setRarihoLoc(cnt, p_70037_1_.getDouble("rarihoLoc_" + cnt));
	        }

	        //super.readEntityFromNBT(p_70037_1_);
	        pet.ownerName = p_70037_1_.getString("OwnerName");

	        String s = "";

	        if (p_70037_1_.hasKey("OwnerUUID", 8))
	        {
	            s = p_70037_1_.getString("OwnerUUID");
	        }
	        else
	        {
	            //String s1 = p_70037_1_.getString("OwnerUUID");
	        	String s1 = null;

	        	s1 = p_70037_1_.getString("Owner");
	        	if(s1 != null)
	        	{
		            s = PreYggdrasilConverter.func_152719_a(s1);

		            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
		            {
		            	s1 = p_70037_1_.getString("OwnerName");
		            	s = PreYggdrasilConverter.func_152719_a(s1);
		            }
	        	}
	        }

	        pet.ownerUUID = s;

	        /*
	        if (s.length() > 0)
	        {
	            this.func_152115_b(s);
	            this.setTamed(true);
	        }
	        */

	        //if(pet.chestOn)
	        //{
	        	if(p_70037_1_.hasKey("sampleItemStack"))
	        	{
	        		pet.setChestItem(ItemStack.loadItemStackFromNBT(p_70037_1_.getCompoundTag("sampleItemStack")));
	        		pet.chestOn = true;
	        	}else
	        	{
	        		pet.setChestItem(null);
	        		pet.chestOn = false;
	        	}
	        //}
	        /*
	        if(pet.chestOn)
	        {
	        	NBTTagCompound itemNBT = new NBTTagCompound();
	        	if(pet.sampleItemStack == null)
	        	{
	                this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
	                this.sampleItemStack.setTagCompound(new NBTTagCompound());
	                this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());

	        	}
	        	this.sampleItemStack.writeToNBT(itemNBT);
	        	p_70014_1_.setTag("sampleItemStack", itemNBT);
	        }
	        */
	        pet.setSit(p_70037_1_.getBoolean("Sitting"));
	        //this.setSitting(p_70037_1_.getBoolean("Sitting"));
	        //this.setTamed(p_70037_1_.getBoolean("isTamed"));


	        pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.getMaxHP());
	        pet.setPathToEntity((PathEntity)null);
	        pet.setAttackTarget((EntityLivingBase)null);
	        //pet.aiSit.setSitting(true);
            pet.func_152115_b(ep.getUniqueID().toString());
            ep.worldObj.setEntityState(pet, (byte)7);
            //ExtendedPlayerProperties3.get(ep).plusPetCount(1);
            //DQR.petFunc.setNewPetdata(pet);
            pet.setTamingTime(pet.worldObj.getWorldTime());
            pet.setCustomNameTag(p_70037_1_.getString("PetCustomName"));
            pet.func_110163_bv();

	        return pet;
	    }


		 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

			 p_77624_3_.add("");
			 p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.mahounoTutuA.1.txt", new Object[]{}));
			 p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.mahounoTutuA.2.txt", new Object[]{}));

			NBTTagCompound nbt = p_77624_1_.getTagCompound();
			if(nbt != null)
			{
				int medalVal = nbt.getInteger("medalking");
				//System.out.println("TEST:" + medalVal);
				if(medalVal > 0)
				{

		    		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

					p_77624_3_.add(medalValue);
				}
			}
		 }
}
