package dqr.handler;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.PacketHandler;
import dqr.api.Blocks.DQPlants;
import dqr.items.magicTool.DqmItemMGTBreak1;
import dqr.items.magicTool.DqmItemMGTBreak2;
import dqr.packetMessage.MessageServerBookWrite;

public class CraftingEventHandler  {

	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event)
	{
		//ここにクラフティングされた時の処理を記載
		/*
		if(event.craftMatrix.getStackInSlot(0) != null)
		{
			//System.out.println(event.craftMatrix.getStackInSlot(0).getDisplayName());
			//System.out.println(event.craftMatrix.getStackInSlot(0).stackSize);
		}

		if(event.crafting != null)
		{
			//System.out.println(event.crafting.getDisplayName());
		}
		*/

		if(event.crafting.getItem() == new ItemStack(DQPlants.BlockHoujyouDirt, 1).getItem())
		{
			for(int cnt = 0; cnt < 9; cnt++)
			{
				if(event.craftMatrix.getStackInSlot(cnt) != null && event.craftMatrix.getStackInSlot(cnt).getItem() instanceof ItemHoe)
				{
					ItemStack hoe = event.craftMatrix.getStackInSlot(cnt);
					if(hoe.getItemDamage() + 1 < hoe.getMaxDamage())
					{
						hoe.setItemDamage(hoe.getItemDamage() + 1);
						hoe.stackSize++;
						event.craftMatrix.setInventorySlotContents(cnt, hoe);
						if(!event.player.worldObj.isRemote) event.player.worldObj.playSoundAtEntity(event.player, Blocks.farmland.stepSound.getStepResourcePath(), (Blocks.farmland.stepSound.getVolume() + 1.0F) / 2.0F, Blocks.farmland.stepSound.getPitch() * 0.8F);
					}else
					{
						if(!event.player.worldObj.isRemote)event.player.worldObj.playSoundAtEntity(event.player, "random.break", 1.0F, 1.0F);
					}
				}
			}
		}
		if(event.crafting.getItem() == new ItemStack(Blocks.wool, 1).getItem())
		{
			for(int cnt = 0; cnt < 9; cnt++)
			{
				if(event.craftMatrix.getStackInSlot(cnt) != null && event.craftMatrix.getStackInSlot(cnt).getItem() instanceof ItemShears)
				{
					ItemStack shears = event.craftMatrix.getStackInSlot(cnt);
					if(shears.getItemDamage() + 1 < shears.getMaxDamage())
					{
						shears.setItemDamage(shears.getItemDamage() + 1);
						shears.stackSize++;
						event.craftMatrix.setInventorySlotContents(cnt, shears);
						if(!event.player.worldObj.isRemote)event.player.worldObj.playSoundAtEntity(event.player, "mob.sheep.shear", 1.0F, 1.0F);
					}else
					{
						if(!event.player.worldObj.isRemote)event.player.worldObj.playSoundAtEntity(event.player, "random.break", 1.0F, 1.0F);
					}
				}
			}
		}
		if(event.crafting.getItem() == Items.string)
		{
			for(int cnt = 0; cnt < 9; cnt++)
			{
				if(event.craftMatrix.getStackInSlot(cnt) != null && event.craftMatrix.getStackInSlot(cnt).getItem() instanceof ItemShears)
				{
					ItemStack shears = event.craftMatrix.getStackInSlot(cnt);
					if(shears.getItemDamage() + 1 < shears.getMaxDamage())
					{
						shears.setItemDamage(shears.getItemDamage() + 1);
						shears.stackSize++;
						event.craftMatrix.setInventorySlotContents(cnt, shears);
						if(!event.player.worldObj.isRemote)event.player.worldObj.playSoundAtEntity(event.player, "mob.sheep.shear", 1.0F, 1.0F);
					}else
					{
						if(!event.player.worldObj.isRemote)event.player.worldObj.playSoundAtEntity(event.player, "random.break", 1.0F, 1.0F);
					}
				}
			}
		}

		if(event.crafting.getItem() instanceof DqmItemMGTBreak1 || event.crafting.getItem() instanceof DqmItemMGTBreak2)
		{
			if(event.player.worldObj.isRemote)
			{
				makeBookBreak1(event.player, event.crafting.getItem());
			}
		}
		/*
		if(event.player.worldObj.isRemote && event.craftMatrix.getStackInSlotOnClosing(0) != null)
		{
			//System.out.println(event.craftMatrix.getStackInSlotOnClosing(0));
		}
		*/

    }


	   @SideOnly(Side.CLIENT)
	    public void makeBookBreak1(EntityPlayer ep, Item tagItem)
	    {

	    	ItemStack book = new ItemStack(Items.written_book, 1, 0);

			NBTTagList bookPages;
			int bookTotalPages = 6;

	        bookPages = new NBTTagList();
	        //bookPages.appendTag(new NBTTagString(""));
	        //bookTotalPages = ;


	        bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.break.info.base.0.txt", new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.base.1.txt", new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.base.2.txt", new Object[]{}) + "\n" + "\n" +
												 I18n.format("msg.magictool.break.info.base.3.txt", new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.base.4.txt", new Object[]{}) + "\n" + "\n" +
												 I18n.format("msg.magictool.break.info.base.5.txt", new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.base.6.txt", new Object[]{})));

	        String key1 = "";
	        String key2 = "";
	        String key3 = "";
	        if(tagItem instanceof DqmItemMGTBreak1)
	        {
	        	key1 = "msg.magictool.break.info.mode.2.txt";
	        	key2 = "msg.magictool.break.info.mode.4.txt";
	        	key3 = "msg.magictool.break.info.mode.5.txt";
	        }else
	        {
	        	key1 = "msg.magictool.break.info.mode.2A.txt";
	        	key2 = "msg.magictool.break.info.mode.4A.txt";
	        	key3 = "msg.magictool.break.info.mode.5A.txt";
	        }

	        bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.break.info.mode.0.txt", new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.mode.1.txt", new Object[]{}) + "\n" +
												 I18n.format(key1, new Object[]{}) + "\n" + "\n" +
												 I18n.format("msg.magictool.break.info.mode.3.txt", new Object[]{}) + "\n" +
												 I18n.format(key2, new Object[]{}) + "\n" + "\n" +
												 I18n.format(key3, new Object[]{}) + "\n" +
												 I18n.format("msg.magictool.break.info.mode.6.txt", new Object[]{})));


	        String s;

	        while (bookPages.tagCount() > 1)
	        {
	            s = bookPages.getStringTagAt(bookPages.tagCount() - 1);

	            if (s.length() != 0)
	            {
	                break;
	            }

	            bookPages.removeTag(bookPages.tagCount() - 1);
	        }

	        if (book.hasTagCompound())
	        {
	            NBTTagCompound nbttagcompound = book.getTagCompound();
	            nbttagcompound.setTag("pages", bookPages);
	        }
	        else
	        {
	        	book.setTagInfo("pages", bookPages);
	        }

	        s = "MC|BEdit";

	        book.setTagInfo("author", new NBTTagString(I18n.format("msg.magictool.farm.info.author", new Object[]{})));
	        if(tagItem instanceof DqmItemMGTBreak1)
	        {
	        	book.setTagInfo("title", new NBTTagString(I18n.format("msg.magictool.break.info.1.title", new Object[]{})));
	        }else
	        {
	        	book.setTagInfo("title", new NBTTagString(I18n.format("msg.magictool.break.info.2.title", new Object[]{})));
	        }
	        book.func_150996_a(Items.written_book);

	        PacketHandler.INSTANCE.sendToServer(new MessageServerBookWrite(book));
	        /*
	        ByteBuf bytebuf = Unpooled.buffer();

	        try
	        {
	            (new PacketBuffer(bytebuf)).writeItemStackToBuffer(book);
	            Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C17PacketCustomPayload(s, bytebuf));
	        }
	        catch (Exception exception)
	        {
	            //System.out.println("Couldn\'t send book info" + exception.getMessage());
	        }
	        finally
	        {
	            bytebuf.release();
	        }

	        return book;
	        */
	    }

}
