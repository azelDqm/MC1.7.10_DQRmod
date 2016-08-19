package dqr.items.magicTool;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Blocks.DQDecorates;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.items.base.DqmItemMagicToolBase;
import dqr.packetMessage.MessageClientCleatSlotItem;
import dqr.packetMessage.MessageServerBookWrite;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.thread.ThreadMGFarmHarvest2;
import dqr.thread.ThreadMGFarmHoe;
import dqr.thread.ThreadMGFarmPlant;

public class DqmItemMGTFarm2 extends DqmItemMagicToolBase{

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(DQR.conf.MGFarm_enable != 0)
		{
			//System.out.println("DEBUG" + p_77648_7_);

			//System.out.println("DEBUGXXX");
			if(par3World.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == DQDecorates.DqmBlockFarmBookShelf)
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);
				if(par3World.isRemote && ep.isSneaking())
				{
					makeBook(ep);
				}
				return true;
			}

			ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);

			int mode = ExtendedPlayerProperties2.get(ep).getTool2mode();
			int area = ExtendedPlayerProperties2.get(ep).getToolArea();

			int areaX = DQR.conf.MGFarm_Area_X[area];
			int areaY = DQR.conf.MGFarm_Area_Y[area];
			int areaZ = DQR.conf.MGFarm_Area_Z[area];

			int itemDam = areaX * areaY * areaZ * 10;

			//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
			//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);
			if(mode == EnumDqmMGToolMode.MGFARM2_HOE.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		ThreadMGFarmHoe hoeThread = new ThreadMGFarmHoe(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_);
	        		hoeThread.start();
	        	}

			}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed1();
	        		if(seedName == null || seedName.equalsIgnoreCase(""))
	        		{
	        			seedName = "DQMIIINext:ItemYakusouSeed";
	        		}

	        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
	        		ThreadMGFarmPlant plantThread = new ThreadMGFarmPlant(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_,
	        														seedName, seedVal);
	        		plantThread.start();

	        	}
			}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);

	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed2();
	        		if(seedName == null || seedName.equalsIgnoreCase(""))
	        		{
	        			seedName = "DQMIIINext:ItemYakusouSeed2";
	        		}
	        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
	        		ThreadMGFarmPlant plantThread = new ThreadMGFarmPlant(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_,
	        														seedName, seedVal);
	        		plantThread.start();

	        	}
			}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed3();
	        		if(seedName == null || seedName.equalsIgnoreCase(""))
	        		{
	        			seedName = "DQMIIINext:ItemYakusouSeed3";
	        		}
	        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
	        		ThreadMGFarmPlant plantThread = new ThreadMGFarmPlant(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_,
	        														seedName, seedVal);
	        		plantThread.start();

	        	}
			}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT4.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed4();
	        		if(seedName == null || seedName.equalsIgnoreCase(""))
	        		{
	        			seedName = "minecraft:wheat_seeds";
	        		}
	        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
	        		ThreadMGFarmPlant plantThread = new ThreadMGFarmPlant(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_,
	        														seedName, seedVal);
	        		plantThread.start();

	        	}
			}else if(mode == EnumDqmMGToolMode.MGFARM2_HARVEST.getId())
			{
				//System.out.println("test" + p_77648_7_);

				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);

        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed();
        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
        		if(DQR.conf.cfg_NoThreadUseHervest == 1)
        		{
        			this.doHarvest2(par1ItemStack, ep, par3World,
									p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
									p_77648_8_, p_77648_9_, p_77648_10_);
        		}else
        		{
    	        	if(!par3World.isRemote)
    	        	{
		        		ThreadMGFarmHarvest2 harvestThread = new ThreadMGFarmHarvest2(par1ItemStack, ep, par3World,
		        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
		        														p_77648_8_, p_77648_9_, p_77648_10_);
		        		harvestThread.start();
    	        	}
        		}


			}else if(mode == EnumDqmMGToolMode.MGFARM2_STORE.getId())
			{
				if(ep.isSneaking())
				{
					if(ExtendedPlayerProperties2.get(ep).getSeedSetMode() == 0)
					{
						ExtendedPlayerProperties2.get(ep).setSeedSetMode(1);
					}else
					{
						ExtendedPlayerProperties2.get(ep).setSeedSetMode(0);
					}

					if(!par3World.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedIn." + ExtendedPlayerProperties2.get(ep).getSeedSetMode() + ".txt", new Object[] {}));
			    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}

				}else
				{
					int haveFlg = 0;
					for(int cnt = 0; ep.inventory.getSizeInventory() > cnt ; cnt++)
					{
						ItemStack iStack;
						if(ep.inventory.getStackInSlot(cnt) != null)
						{
							iStack = ep.inventory.getStackInSlot(cnt);

							RegistryNamespaced rn = Item.itemRegistry;
							String itemName = rn.getNameForObject(iStack.getItem());

							if(DQR.MGSeedTable.containsKey(itemName))
							{
								if(!ep.worldObj.isRemote)
								{
									int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
									ExtendedPlayerProperties2.get(ep).setSeedVal(itemName, seedVal + iStack.stackSize);
									PacketHandler.INSTANCE.sendTo(new MessageClientCleatSlotItem(cnt), (EntityPlayerMP)ep);
									//ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedInAct.1.txt", new Object[] {iStack.getDisplayName(), seedVal + iStack.stackSize}));
								}
								//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
								iStack.stackSize = 0;
								ep.inventory.setInventorySlotContents(cnt, null);
								haveFlg = 1;

							}
						}
					}


					if(!ep.worldObj.isRemote)
					{
						if(haveFlg > 0)
						{
							//System.out.println("TEST" + ep.inventory.mainInventory.length);
							ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedInAct.0.txt"));

						}else
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedInAct.2.txt"));
						}
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}

					//ep.inventory.;


					return true;
				}
			}
		}

        return false;
    }

	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer ep)
    {

		if(DQR.conf.MGFarm_enable != 0)
		{
			int useFlg = ExtendedPlayerProperties2.get(ep).getItemUseFlg();
			//System.out.println("DEBUGYYY:" + useFlg);

			if(useFlg == 0)
			{
				//System.out.println("DEBUGYYY");
				int mode = ExtendedPlayerProperties2.get(ep).getTool2mode();
				int area = ExtendedPlayerProperties2.get(ep).getToolArea();

				if(ep.isSneaking())
				{
					if(area + 1 < DQR.conf.MGFarm_Area_X.length)
					{
						area = area + 1;
					}else
					{
						area = 0;
					}

					int areaX = DQR.conf.MGFarm_Area_X[area];
					int areaY = DQR.conf.MGFarm_Area_Y[area];
					int areaZ = DQR.conf.MGFarm_Area_Z[area];

					int itemDam = areaX * areaY * areaZ * 10;

					ExtendedPlayerProperties2.get(ep).setToolArea(area);

					if(!par2World.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.areaset.txt", new Object[] {areaX, areaY, areaZ, itemDam}));
			    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}

				}else
				{
					if(mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId() ||
					   mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId() ||
					   mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId() ||
					   mode == EnumDqmMGToolMode.MGFARM2_PLANT4.getId())
					{
						String selectSeed;// = ExtendedPlayerProperties2.get(ep).getSelectSeed();
						String firstSeed = "";
						int foundFlg = 0;
						Map<String, Integer> seedTable = null; //DQR.MGSeedTable.MGSeedALL;
						if(mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId())
						{
							seedTable = DQR.MGSeedTable.MGSeedLv1;
							selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed1();
						}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId())
						{
							seedTable = DQR.MGSeedTable.MGSeedLv2;
							selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed2();
						}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId())
						{
							seedTable = DQR.MGSeedTable.MGSeedLv3;
							selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed3();
						}else
						{
							seedTable = DQR.MGSeedTable.MGSeedLvETC;
							selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed4();
						}

						for (Iterator it = seedTable.entrySet().iterator(); it.hasNext();) {
						    Map.Entry entry = (Map.Entry)it.next();
						    String key = (String)entry.getKey();

						    if(foundFlg == 0)
						    {
						    	firstSeed = key;
						    	foundFlg = 1;
						    }

						    if(selectSeed.equalsIgnoreCase("") || foundFlg ==2)
						    {
						    	selectSeed = key;
						    	foundFlg = 3;
						    	break;
						    }

						    if(selectSeed.equalsIgnoreCase(key))
						    {
						    	foundFlg = 2;
						    }
						}

						if(foundFlg < 3)
						{
							selectSeed = firstSeed;
						}

						//ExtendedPlayerProperties2.get(ep).setSelectSeed(selectSeed);

						if(mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId())
						{
							ExtendedPlayerProperties2.get(ep).setSelectSeed1(selectSeed);
						}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId())
						{
							ExtendedPlayerProperties2.get(ep).setSelectSeed2(selectSeed);
						}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId())
						{
							ExtendedPlayerProperties2.get(ep).setSelectSeed3(selectSeed);
						}else
						{
							ExtendedPlayerProperties2.get(ep).setSelectSeed4(selectSeed);
						}

						if(!par2World.isRemote)
						{
							RegistryNamespaced rn = Item.itemRegistry;

							ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
							int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);

							ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.0.txt", new Object[] {iStack.getDisplayName(), val}));
				    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						}

						//System.out.println(selectSeed);
					}
				}

			}

			if(ExtendedPlayerProperties2.get(ep).getItemUseFlg() > 0)
			{
				par1ItemStack.damageItem(ExtendedPlayerProperties2.get(ep).getItemUseFlg(), ep);
			}

			ExtendedPlayerProperties2.get(ep).setItemUseFlg(0);
		}
        return par1ItemStack;
    }



    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    	String bookBlock = (new ItemStack(DQDecorates.DqmBlockFarmBookShelf, 1)).getDisplayName();
    	String bookName = I18n.format("msg.magictool.farm.info.2.title", new Object[]{});


    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.0.txt", new Object[]{bookBlock}));
    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.1.txt", new Object[]{bookName}));
    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.2.txt", new Object[]{}));

    }


    @SideOnly(Side.CLIENT)
    public void makeBook(EntityPlayer ep)
    {
		ItemStack book = new ItemStack(Items.written_book, 1, 0);

		NBTTagList bookPages;
		int bookTotalPages = 6;

        bookPages = new NBTTagList();
        //bookPages.appendTag(new NBTTagString(""));
        //bookTotalPages = ;


        bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.base.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.magictool.farm.info.base.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.magictool.farm.info.base.3.txt", new Object[]{}) + "\n" + "\n" +
				 I18n.format("msg.magictool.farm.info.base.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.magictool.farm.info.base.5.txt", new Object[]{})));

		bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.hoe.0.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.hoe.1.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.hoe.2.txt", new Object[]{})));

		bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.plant.0.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.plant.1.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.plant.2.txt", new Object[]{}) + "\n" +"\n" +
						 I18n.format("msg.magictool.farm.info.plant.3.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.plant.4.txt", new Object[]{})));

		bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.harvest.0.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.harvest.1.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.harvest.2.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.harvest.3.txt", new Object[]{})));


		bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.store.0.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.store.1.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.store.2.txt", new Object[]{}) + "\n" +"\n" +
						 I18n.format("msg.magictool.farm.info.store.3.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.store.4.txt", new Object[]{})));

		bookPages.appendTag(new NBTTagString(I18n.format("msg.magictool.farm.info.store.6.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.store.7.txt", new Object[]{}) + "\n" +
						 I18n.format("msg.magictool.farm.info.store.8.txt", new Object[]{})));


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
        book.setTagInfo("title", new NBTTagString(I18n.format("msg.magictool.farm.info.2.title", new Object[]{})));
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
        */


		ep.inventory.addItemStackToInventory(book);
    }


	public void doHarvest2(ItemStack par1, EntityPlayer ep, World par3, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{

		int mode = ExtendedPlayerProperties2.get(ep).getTool1mode();
		int area = ExtendedPlayerProperties2.get(ep).getToolArea();

		int areaX = DQR.conf.MGFarm_Area_X[area];
		int areaY = DQR.conf.MGFarm_Area_Y[area];
		int areaZ = DQR.conf.MGFarm_Area_Z[area];

		int itemDam = areaX * areaY * areaZ * 10;

		int fixY = par7 == 1? 1 : 0;
		if(par7 == 1 &&
			(par3.isAirBlock(par4 + 1, par5 + fixY, par6) &&
			 par3.isAirBlock(par4 - 1, par5 + fixY, par6) &&
			 par3.isAirBlock(par4, par5 + fixY, par6 + 1) &&
			 par3.isAirBlock(par4, par5 + fixY, par6 - 1)))
		{
			fixY = 0;
		}
		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);

		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		Item hoe = Items.diamond_hoe;

		int l = MathHelper.floor_double((double)(ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		//System.out.println("DEBUG" + l);

		RegistryNamespaced rn = Block.blockRegistry;

		if(l == 1)
		{
			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
					{
						Block targetBlock = par3.getBlock(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							String targetName = rn.getNameForObject(targetBlock);
							int maxMeta = DQR.MGSeedTable.getPlantMaxMeta(targetName);

							if(par3.getBlockMetadata(par4 + cntZ, par5+ cntY + fixY, par6 + cntX) >= maxMeta)
							{
								par3.func_147480_a(par4 + cntZ, par5+ cntY + fixY, par6 + cntX, true);
							}
						}
					}
				}
			}
		}else if(l == 2)
		{
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
					{
						Block targetBlock = par3.getBlock(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							String targetName = rn.getNameForObject(targetBlock);
							int maxMeta = DQR.MGSeedTable.getPlantMaxMeta(targetName);

							if(par3.getBlockMetadata(par4 + cntX, par5+ cntY + fixY, par6 + cntZ) >= maxMeta)
							{
								par3.func_147480_a(par4 + cntX, par5+ cntY + fixY, par6 + cntZ, true);
							}
						}
					}
				}
			}
		}else if(l == 3)
		{
			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
					{
						Block targetBlock = par3.getBlock(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							String targetName = rn.getNameForObject(targetBlock);
							int maxMeta = DQR.MGSeedTable.getPlantMaxMeta(targetName);

							if(par3.getBlockMetadata(par4 + cntZ, par5+ cntY + fixY, par6 + cntX) >= maxMeta)
							{
								par3.func_147480_a(par4 + cntZ, par5+ cntY + fixY, par6 + cntX, true);
							}
						}
					}
				}
			}
		}else
		{
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
					{
						Block targetBlock = par3.getBlock(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							String targetName = rn.getNameForObject(targetBlock);
							int maxMeta = DQR.MGSeedTable.getPlantMaxMeta(targetName);

							if(par3.getBlockMetadata(par4 + cntX, par5+ cntY + fixY, par6 + cntZ) >= maxMeta)
							{
								par3.func_147480_a(par4 + cntX, par5+ cntY + fixY, par6 + cntZ, true);
							}
						}
					}
				}
			}
		}


		/*
		for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
		{
			for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
			{
				for(int cntZ = (areaZ - 1) / 2 * -1; (areaZ - 1) / 2 >= cntZ; cntZ++)
				{
					hoe.onItemUse(new ItemStack(Items.diamond_hoe, 1), ep, par3,
								  par4 + cntX, par5+ cntY + fixY, par6 + cntZ, par7,
								  par8 + cntX, par9 + cntY, par10 + cntZ);
				}
			}
		}
		*/

	}

}
