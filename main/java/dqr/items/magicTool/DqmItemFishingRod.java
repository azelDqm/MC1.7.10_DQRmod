package dqr.items.magicTool;

import io.netty.buffer.Unpooled;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.PacketHandler;
import dqr.entity.throwingEntity.throwing.ThrowingEntityFishHook;
import dqr.network.PacketHandlerClient;
import dqr.network.SToCMessage;

public class DqmItemFishingRod extends ItemFishingRod {

	public IIcon[] castIcons = new IIcon[1];
	public int maxStrain = 300;
	public double strength = 0.1;
	//public String repairOreDictName = "plankWood";
	public int enchantability = 1;

	public DqmItemFishingRod() {
		super();
		this.maxStrain = 80;
		this.strength = 0.08;
		this.enchantability = 5;
		//this.repairOreDictName = "plankWood";
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString() + "_uncast");
        castIcons[0] = p_94581_1_.registerIcon(this.getIconString() + "_cast");

        /*
        castIcons[0] = p_94581_1_.registerIcon(this.getIconString() + "_cast_1");
        castIcons[1] = p_94581_1_.registerIcon(this.getIconString() + "_cast_2");
        castIcons[2] = p_94581_1_.registerIcon(this.getIconString() + "_cast_3");
        castIcons[3] = p_94581_1_.registerIcon(this.getIconString() + "_cast_4");
        castIcons[4] = p_94581_1_.registerIcon(this.getIconString() + "_cast_5");
        */
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return enchantability;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (player.fishEntity instanceof ThrowingEntityFishHook)
        {
            int i = player.fishEntity.func_146034_e();

            if(player.fishEntity != null) {
            	//world.playSoundAtEntity(player, "jaff:rod.reel", 0.5F, 1.0F);

            	int strain = ((ThrowingEntityFishHook)player.fishEntity).strain;

            	if(strain >  maxStrain) {
            		//If on the server, do the actual breaking and send the info over to the client.
            		if(!player.worldObj.isRemote) {
            			world.playSoundAtEntity(player, "random.break", 1.0F, 1.0F);
            			player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            			/*
            			givePlayerBrokenScraps(player);

	            		if(player instanceof EntityPlayerMP){
	            			PacketBuffer out = new PacketBuffer(Unpooled.buffer());

	        				out.writeInt(PacketHandlerClient.BREAK_FISHING_ROD);
	        				out.writeInt(Item.getIdFromItem(this));

	        				SToCMessage packet = new SToCMessage(out);
	        				PacketHandler.INSTANCE.sendTo(packet, (EntityPlayerMP) player);
	            		}
	            		*/
            		}
            	}
            }
            else {
	            stack.damageItem(i, player);
            }
        }
        else
        {
        	//System.out.println("buzzbuzz1");
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
            	ThrowingEntityFishHook hook = new ThrowingEntityFishHook(world, player);

            	hook.setRodType(this);
                world.spawnEntityInWorld(hook);

                PacketBuffer out = new PacketBuffer(Unpooled.buffer());

				out.writeInt(PacketHandlerClient.SPAWN_HOOK);
				out.writeInt(player.getEntityId());
				out.writeInt(hook.getEntityId());

				SToCMessage packet = new SToCMessage(out);
				PacketHandler.INSTANCE.sendToDimension(packet, player.dimension);
            }

        }

        player.swingItem();

        return stack;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    /*
    public boolean getIsRepairable(ItemStack thisStack, ItemStack repairStack)
    {
        return repairStack != null && OreDictionary.getOres(repairOreDictName).contains(repairStack);
    }
    */

    /*
    public DqmItemFishingRod setRepairItem(String repairOreDictName) {
    	this.repairOreDictName = repairOreDictName;
    	return this;
    }
    */

    public DqmItemFishingRod setStrength(double strength) {
    	this.strength = strength;
    	return this;
    }

    public DqmItemFishingRod setMaxStrain(int strain) {
    	this.maxStrain = strain;
    	return this;
    }

    public DqmItemFishingRod setEnchantability(int enchant) {
    	this.enchantability = enchant;
    	return this;
    }

    /*
    protected ItemStack getBreakItem() {
    	return OreDictionary.getOres(repairOreDictName).get(0);
    }
    */

    /*
    public void givePlayerBrokenScraps(EntityPlayer player) {
    	ItemStack repairItem = getBreakItem().copy();
    	repairItem.stackSize = 2;

    	if(repairItem.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
    		//If any metadata, set the metadata to 0
    		repairItem.setItemDamage(0);
    	}

    	ItemStack hook = new ItemStack(Items.stick, 1);

    	if (!player.inventory.addItemStackToInventory(repairItem))
        {
            player.dropPlayerItemWithRandomChoice(repairItem, false);
        }

    	if (!player.inventory.addItemStackToInventory(hook))
        {
            player.dropPlayerItemWithRandomChoice(hook, false);
        }
    }
    */



    /**
     * Player, Render pass, and item usage sensitive version of getIconIndex.
     *
     * @param stack The item stack to get the icon for. (Usually this, and usingItem will be the same if usingItem is not null)
     * @param renderPass The pass to get the icon for, 0 is default.
     * @param player The player holding the item
     * @param usingItem The item the player is actively using. Can be null if not using anything.
     * @param useRemaining The ticks remaining for the active item.
     * @return The icon index
     */
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {



    	if (player != null && player.fishEntity instanceof ThrowingEntityFishHook) {

    		int strain = ((ThrowingEntityFishHook)player.fishEntity).strain;

    		//Calculate how much "strain" this fishing rod has
            int index = MathHelper.floor_float((float)(strain <= 0 ? -1 : strain)/(float)this.maxStrain * 5f) + 1;

            index = MathHelper.clamp_int(index, 0, 4);
            //System.out.println("TEST : " + index);


            if(index >= 0)
            {
            	return castIcons[0];
            }else
            {
            	 return this.itemIcon;
            }
            //return this.castIcons[index];
        }

    	return this.itemIcon;
    	//return this.itemIcon;
    	//return castIcons[0];
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
    	if(stack == null || !stack.hasTagCompound()) {
    		return;
    	}

    	/*
    	NBTTagList baitList = stack.getTagCompound().getTagList("Bait", 10);

    	//Add a line for each bait entry
    	for(int i = 0; i < baitList.tagCount(); i++) {
    		NBTTagCompound currentTag = baitList.getCompoundTagAt(i);
    		String type = (currentTag.getString("Type"));

    		if(BaitType.baitTypes.get(type) != null) {
    			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("rod.info.bait") + currentTag.getInteger("Count") + StatCollector.translateToLocal("rod.info.of") + BaitType.baitTypes.get(type).getDisplayName());
    		}
    	}
    	*/
    }

    //Add a certain type of bait to the rod itemstack
    public void addBaitToRod(ItemStack rodStack, String bait, int amount) {
    	if(rodStack == null || rodStack.getItem() == null) {
    		return;
    	}

    	if(!rodStack.hasTagCompound()) {
    		rodStack.setTagCompound(new NBTTagCompound());
    	}

    	NBTTagList baitList = rodStack.getTagCompound().getTagList("Bait", 10);
    	int baitAmount = 0;

    	//First try to add the bait to an existing tag
    	for(int i = 0; i < baitList.tagCount(); i++) {
    		NBTTagCompound currentTag = baitList.getCompoundTagAt(i);

    		//Compatibility with the first version
    		if(currentTag.hasKey("id") && Item.itemRegistry.getObject(currentTag.getString("id")) == Items.wheat_seeds) {
    			currentTag.setString("Type", "seeds");
    			currentTag.removeTag("id");
    		}

    		if(currentTag.getString("Type").equals(bait)) {
    				currentTag.setInteger("Count", currentTag.getInteger("Count") + amount);
    				return;
    		}
    	}

    	//Then if that fails, create a new tag
    	NBTTagCompound newBaitTag = new NBTTagCompound();

    	newBaitTag.setString("Type", bait);
    	newBaitTag.setInteger("Count", amount);

    	baitList.appendTag(newBaitTag);

    	rodStack.getTagCompound().setTag("Bait", baitList);
    }

}
