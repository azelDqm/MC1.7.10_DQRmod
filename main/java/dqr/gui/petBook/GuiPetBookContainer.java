package dqr.gui.petBook;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.api.Items.DQMonsters;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiPetBookContainer extends Container
{
    private InventoryPetBook inventory;
    private EntityPlayer ep;
    private int pageNo = 0;

    public GuiPetBookContainer(EntityPlayer player)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	//inventory = new InventoryPetBook();
    	inventory = new InventoryPetBook(player, 0);
        inventory.openInventory();

        this.ep = player;

        int i = 2 * 18 + 1;

        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotPetBook(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        this.addSlotToContainer(new SlotPetBook(inventory, 54, 8 + 1 * 18, 22 + 6 * 18));
        this.addSlotToContainer(new SlotPetBook(inventory, 55, 8 + 7 * 18, 22 + 6 * 18));
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
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        //PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)p_75134_1_), (EntityPlayerMP)p_75134_1_);
        this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {
    	boolean flg = false;
    	int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_PetSuisyou.getId());
    	//System.out.println("TEST");
    	//System.out.println("TEST_Line1 : " + ep.worldObj.isRemote);
    	if(par1 >= 0 && par1 < 54)
    	{
    		//System.out.println("TEST2");
	    	Slot slot = (Slot)this.inventorySlots.get(par1);

	    	if(slot != null && slot.getStack() != null)
	    	{

	    		//System.out.println(slot.getStack().getDisplayName());
	    		NBTTagCompound nbt = slot.getStack().getTagCompound();

	    		int locX = nbt.getInteger("posX");
				int locY = nbt.getInteger("posY");
				int locZ = nbt.getInteger("posZ");
				int locDim = nbt.getInteger("dimension");

				//System.out.println("TEST_Line1 : " + ep.worldObj.isRemote);

				if((locX == 0 && locY == 0 && locZ == 0 && locDim == 0) || itemMode == EnumDqmMGToolMode.PETSUISYOU_VIEWDEL.getId())
				{
					//ExtendedPlayerProperties3.get(ep).minusPetCount(1);
					//System.out.println("TESTTEST : " + ep.worldObj.isRemote);
		        	DQR.petFunc.removePetdata(ep, nbt.getString("uuid"));


		        	flg = true;
				}
	    		//System.out.println("TEST" + nbt.getString("uuid"));


	    	}
    	}
    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	/*
    	if(par1 >= 0 && par1 < inventorySlots.size())
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	   			//System.out.println("1:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());
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



	    	}
    	}
    	*/

    	//this.inventory.setInventorySlotContents(0, null);

    	NBTTagCompound playerPet = ExtendedPlayerProperties3.get(this.ep).getNBTPlayerPetList();
    	Set tags = playerPet.func_150296_c();



    	//System.out.println("TEST:" + this.pageNo + "/" + par1);
    	//ページボタンクリック時処理
    	if(par1 == 54 && this.pageNo > 0)
    	{
    		//System.out.println("TEST2");
    		this.pageNo = this.pageNo - 1;
    		flg = true;
    	}else if(par1 == 55)
    	{
    		if(tags.size() > (this.pageNo + 1) * 54)
    		{
        		this.pageNo = this.pageNo + 1;
        		flg = true;
    		}

    	}

//System.out.println("TEST" + this.pageNo + "/" + tags.size());

    	//if(tags.size() > 54 * (this.pageNo + 1))

    	if(flg)
    	{
    		//System.out.println("TEST3");
    		ep.worldObj.playSoundAtEntity(ep, "random.click", 1.0F, 1.0F);

	    	Object[] tagArray = tags.toArray();
	    	int countMax = tags.size() > 54 * (this.pageNo + 1) ? 54 * (this.pageNo + 1) : tags.size();
	    	//System.out.println("test2 : " + tags.size());


	        for(int cnt = 0; cnt < 54; cnt++)
	        {
	        	//System.out.println("TEST_R:" + cnt + " ! " + (cnt + (54 * this.pageNo))  + " ! " + countMax + " ? " + this.pageNo);
	        	if(cnt + (54 * this.pageNo) < countMax)
	        	{
	        		ItemStack items = null;
		        	//items = new ItemStack(DQMonsters.itemMonsterSuraimu, 1);

		        	NBTTagCompound petData = playerPet.getCompoundTag((String)tagArray[cnt + (54 * this.pageNo)]);
		        	items = new ItemStack(getMobTypeItem(petData.getString("petRoot")), 1);

		        	items.setTagCompound(petData);
		        	items.setStackDisplayName(petData.getString("PetName"));

		        	this.inventory.setInventorySlotContents(cnt, items);
		        	//System.out.println("TEST_R [" + ep.worldObj.isRemote + "] : " + petData.getString("PetName") + " / " + cnt + " ! " + (cnt + (54 * this.pageNo))  + " ! " + countMax + " ? " + this.pageNo);
	        	}else
	        	{

	        		this.inventory.setInventorySlotContents(cnt, null);
	        	}

	        	//items[cnt].
	        }
    	}

    	return null;
    }

    public Item getMobTypeItem(String par1)
    {

    	if(par1.equalsIgnoreCase("AKUMA"))
    	{
    		return DQMonsters.itemMonsterAkuma;
    	}else if(par1.equalsIgnoreCase("BEAST"))
    	{
    		return DQMonsters.itemMonsterBeast;
    	}else if(par1.equalsIgnoreCase("BUSSITU"))
    	{
    		return DQMonsters.itemMonsterBussitu;
    	}else if(par1.equalsIgnoreCase("DRAGON"))
    	{
    		return DQMonsters.itemMonsterDragon;
    	}else if(par1.equalsIgnoreCase("METARU"))
    	{
    		return DQMonsters.itemMonsterMetaru;
    	}else if(par1.equalsIgnoreCase("SIZEN"))
    	{
    		return DQMonsters.itemMonsterSizen;
    	}else if(par1.equalsIgnoreCase("SURAIMU"))
    	{
    		return DQMonsters.itemMonsterSuraimu;
    	}else if(par1.equalsIgnoreCase("TOKUSYU"))
    	{
    		return DQMonsters.itemMonsterTokusyu;
    	}else if(par1.equalsIgnoreCase("UNDEAD"))
    	{
    		return DQMonsters.itemMonsterUndead;
    	}else if(par1.equalsIgnoreCase("UNKNOWN"))
    	{
    		return DQMonsters.itemMonsterUnknown;
    	}

    	return DQMonsters.itemMonsterSuraimu;
    }



}
