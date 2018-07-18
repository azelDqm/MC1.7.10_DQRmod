package dqr.items.magicTool;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.items.base.DqmItemMagicToolBase;
import dqr.packetMessage.MessageClientCleatSlotItem;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.thread.ThreadMGFarmHarvest;
import dqr.thread.ThreadMGFarmHoe;
import dqr.thread.ThreadMGFarmPlant;

public class DqmItemMGTSet extends DqmItemMagicToolBase{

	public IIcon itemIcon2;

	public IIcon itemIcon3;


    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon2 = p_94581_1_.registerIcon("DQR:MagicToolSet2");
        this.itemIcon3 = p_94581_1_.registerIcon("DQR:MagicToolSet");
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());

        //itemIcon3 = p_94581_1_.registerIcon("DQR:Mahoizun");
        //itemIcon4 = p_94581_1_.registerIcon("DQR:MahounomiI");
        //itemIcon5 = p_94581_1_.registerIcon("DQR:MasterdoragonA");

    }


    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack p_77650_1_)
    {
        return this.itemIcon2;
    }




    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int p_77617_1_)
    {
        return this.itemIcon3;
    }


    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        return this.itemIcon3;
    }


	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int par4, int par5, int par6, int face, float par8, float par9, float par10)
    {

		if(DQR.conf.MGSet_enable != 0 && !par3World.isRemote)
		{

			int mode = ExtendedPlayerProperties2.get(ep).getBlockSetMode();
			int area = ExtendedPlayerProperties2.get(ep).getBlockSetArea();



			if(mode == EnumDqmMGToolMode.MGSET_STORE.getId())
			{
				int haveFlg = 0;
				NBTTagCompound setBlockSets = ExtendedPlayerProperties2.get(ep).getToolSetInBlocks();

				for(int cnt = 0; ep.inventory.getSizeInventory() > cnt ; cnt++)
				{
					ItemStack iStack;
					if(ep.inventory.getStackInSlot(cnt) != null)
					{
						iStack = ep.inventory.getStackInSlot(cnt);

						Block tagBlock = Block.getBlockFromItem(iStack.getItem());

						//if(tagBlock != Blocks.air && tagBlock.hasTileEntity(iStack.getItemDamage()))
						if(tagBlock != Blocks.air)
						{
							RegistryNamespaced rn = Block.blockRegistry;
							int meta = iStack.getItemDamage();

							//RegistryNamespaced rn = Item.itemRegistry;
							String blockName = rn.getNameForObject(tagBlock);

							NBTTagCompound inBlockNbt;
							int[] storeValue = new int[16];

							if(setBlockSets.hasKey(blockName))
							{
								inBlockNbt = setBlockSets.getCompoundTag(blockName);
								storeValue = inBlockNbt.getIntArray("storeValue");
							}else
							{
								inBlockNbt = new NBTTagCompound();
							}

							storeValue[meta] = storeValue[meta] + iStack.stackSize;

							inBlockNbt.setIntArray("storeValue", storeValue);
							setBlockSets.setTag(blockName, inBlockNbt);

							if(!ep.worldObj.isRemote)
							{
								PacketHandler.INSTANCE.sendTo(new MessageClientCleatSlotItem(cnt), (EntityPlayerMP)ep);
							}

							iStack.stackSize = 0;
							ep.inventory.setInventorySlotContents(cnt, null);
							haveFlg = 1;

						}
					}
				}

				//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				//ExtendedPlayerProperties2.get(ep).setToolSetInBlocks(setBlockSets);



				if(!ep.worldObj.isRemote)
				{
					if(haveFlg > 0)
					{
						//System.out.println("TEST" + ep.inventory.mainInventory.length);
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.blockInAct.0.txt"));

					}else
					{
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.blockInAct.2.txt"));
					}
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				}

			}else
			{
				//ブロック選択チェック

				//System.out.println("LINE1");
				int areaX = DQR.conf.MGSet_Area_X[area];
				int areaY = DQR.conf.MGSet_Area_Y[area];
				int areaZ = DQR.conf.MGSet_Area_Z[area];
				int fixPos = 0;
				int l = MathHelper.floor_double((double)(ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

				RegistryNamespaced rn = Block.blockRegistry;
				String selectingBlock = ExtendedPlayerProperties2.get(ep).getSelectSetBlock();

				if(selectingBlock != null && !selectingBlock.equalsIgnoreCase(""))
				{

					int selectingBlockMeta = ExtendedPlayerProperties2.get(ep).getSelectSetBlockMeta();
					NBTTagCompound blocksNBT = ExtendedPlayerProperties2.get(ep).getToolSetInBlocks();
					NBTTagCompound blockNBT = (NBTTagCompound)blocksNBT.getTag(selectingBlock);
					int[] blockValues = new int[16];
					if(blockNBT != null)
					{
						blockValues = blockNBT.getIntArray("storeValue");
						//System.out.println("LINE2");
					}

					ItemStack setBlockX = new ItemStack((Block)rn.getObject(selectingBlock), blockValues[selectingBlockMeta], selectingBlockMeta);

					if(blockValues[selectingBlockMeta] > 0)
					{
						//System.out.println("LINE3");
						Block selectBlock = (Block)rn.getObject(selectingBlock);
			            if(l == 1)//南
			            {
			            	//System.out.println("LINE4");
			            	for(int cntY =0; cntY < areaY && blockValues[selectingBlockMeta] > 0; cntY++)
			            	{
			            		for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX && blockValues[selectingBlockMeta] > 0; cntX++)
			            		{
			            			for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ && blockValues[selectingBlockMeta] > 0; cntZ--)
			            			{
			            				if(par3World.getBlock(par4 + cntZ, par5+ cntY, par6 + cntX) instanceof BlockLiquid ||
			            				   par3World.isAirBlock(par4 + cntZ, par5+ cntY, par6 + cntX))
			            				{
			            					par3World.setBlock(par4 + cntZ, par5+ cntY, par6 + cntX, selectBlock, selectingBlockMeta, 2);
			            					blockValues[selectingBlockMeta]--;
			            				}
			            				/*
			            				setBlock.getItem().onItemUse(setBlock, ep, par3World,
			            						par4 + cntZ, par5+ cntY, par6 + cntX, 1,
												par8 + cntZ, par9 + cntY, par10 + cntX);

			            				setBlock.stackSize--;
			            				if(setBlock.stackSize <= 0) break;
			            				*/
			            			}
			            		}
			            	}
			            }else if(l == 2)
			            {
	        				//System.out.println("LINE5");
		        			for(int cntY =0; cntY < areaY && blockValues[selectingBlockMeta] > 0; cntY++)
		        			{
		        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX && blockValues[selectingBlockMeta] > 0; cntX++)
		        				{
		        					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ && blockValues[selectingBlockMeta] > 0; cntZ--)
		        					{
			            				if(par3World.getBlock(par4 + cntX, par5+ cntY, par6 + cntZ) instanceof BlockLiquid ||
					            		   par3World.isAirBlock(par4 + cntX, par5+ cntY, par6 + cntZ))
					            		{
			            					par3World.setBlock(par4 + cntX, par5+ cntY, par6 + cntZ, selectBlock, selectingBlockMeta, 2);
			            					blockValues[selectingBlockMeta]--;
					            		}
		        						/*
			            				setBlock.getItem().onItemUse(setBlock, ep, par3World,
												  par4 + cntX, par5+ cntY, par6 + cntZ, 1,
												  par8 + cntX, par9 + cntY, par10 + cntZ);

		        						setBlock.stackSize--;
		    	        				if(setBlock.stackSize <= 0) break;
		    	        				*/
		        					}
		        				}
		        			}
			            }else if(l == 3)
			            {
			            	//System.out.println("LINE6");
			            	for(int cntY =0; cntY < areaY && blockValues[selectingBlockMeta] > 0; cntY++)
		        			{
		        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX && blockValues[selectingBlockMeta] > 0; cntX++)
		        				{
		        					for(int cntZ = 0; (areaZ - 1) >= cntZ && blockValues[selectingBlockMeta] > 0; cntZ++)
		        					{
			            				if(par3World.getBlock(par4 + cntZ, par5+ cntY, par6 + cntX) instanceof BlockLiquid ||
					            		   par3World.isAirBlock(par4 + cntZ, par5+ cntY, par6 + cntX))
					            		{
			            					par3World.setBlock(par4 + cntZ, par5+ cntY, par6 + cntX, selectBlock, selectingBlockMeta, 2);
			            					blockValues[selectingBlockMeta]--;
					            		}
		        						/*
			            				setBlock.getItem().onItemUse(setBlock, ep, par3World,
												  par4 + cntZ, par5+ cntY, par6 + cntX, 1,
												  par8 + cntZ, par9 + cntY, par10 + cntX);

		        						setBlock.stackSize--;
		        						if(setBlock.stackSize <= 0) break;
		        						*/
		        					}
		        				}
		        			}
			            }else
			            {
			            	//System.out.println("LINE7");
		        			for(int cntY =0; cntY < areaY && blockValues[selectingBlockMeta] > 0; cntY++)
		        			{
		        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX && blockValues[selectingBlockMeta] > 0; cntX++)
		        				{
		        					for(int cntZ = 0; (areaZ - 1) >= cntZ && blockValues[selectingBlockMeta] > 0; cntZ++)
		        					{
			            				if(par3World.getBlock(par4 + cntX, par5+ cntY, par6 + cntZ) instanceof BlockLiquid ||
							               par3World.isAirBlock(par4 + cntX, par5+ cntY, par6 + cntZ))
			            				{
			            					par3World.setBlock(par4 + cntX, par5+ cntY, par6 + cntZ, selectBlock, selectingBlockMeta, 2);
			            					blockValues[selectingBlockMeta]--;
			            				}
		        						/*
			            				setBlock.getItem().onItemUse(setBlock, ep, par3World,
												  par4 + cntX, par5+ cntY, par6 + cntZ, 1,
												  par8 + cntX, par9 + cntY, par10 + cntZ);

		        						setBlock.stackSize--;
		        						if(setBlock.stackSize <= 0) break;
		        						*/
		        					}
		        				}
		        			}
			            }
					}
					blockNBT.setIntArray("storeValue", blockValues);
					blocksNBT.setTag(selectingBlock, blockNBT);
					ExtendedPlayerProperties2.get(ep).setToolSetInBlocks(blocksNBT);

					//ここで残り個数メッセージ
					if(!ep.worldObj.isRemote)
					{
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.selectBlock.1.txt", new Object[] {setBlockX.getDisplayName(), blockValues[selectingBlockMeta]}));
					}
				}else
				{
					//ブロックがない場合
					if(!ep.worldObj.isRemote)
					{
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.selectBlock.0.txt"));
					}
				}
			}
		}

		return true;
    }

	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer ep)
    {
		if(DQR.conf.MGSet_enable != 0)
		{

			//System.out.println("DEBUG" + p_77648_7_);

			//System.out.println("DEBUGXXX");
			//ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);

			if(ep.isSneaking())
			{
				int area = ExtendedPlayerProperties2.get(ep).getBlockSetArea();

				if(area + 1 < DQR.conf.MGSet_Area_X.length)
				{
					area = area + 1;
				}else
				{
					area = 0;
				}

				int areaX = DQR.conf.MGSet_Area_X[area];
				int areaY = DQR.conf.MGSet_Area_Y[area];
				int areaZ = DQR.conf.MGSet_Area_Z[area];

				int itemDam = areaX * areaY * areaZ * 1;

				ExtendedPlayerProperties2.get(ep).setBlockSetArea(area);

				if(!par2World.isRemote)
				{
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.areaset.txt", new Object[] {areaX, areaY, areaZ, itemDam}));
		    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				}
			}else
			{
				RegistryNamespaced rn = Block.blockRegistry;

				NBTTagCompound setBlockSets = ExtendedPlayerProperties2.get(ep).getToolSetInBlocks();
				String selectingBlock = ExtendedPlayerProperties2.get(ep).getSelectSetBlock();
				int selectingBlockMeta = ExtendedPlayerProperties2.get(ep).getSelectSetBlockMeta();

				Set inBlockKey = setBlockSets.func_150296_c();
				TreeMap<String, int[]> trm = new TreeMap<String, int[]>();

		        Iterator it = inBlockKey.iterator();
		        while (it.hasNext()) {

		        	String key = (String)it.next();
		        	NBTTagCompound blockNBT = (NBTTagCompound)setBlockSets.getTag(key);
		        	trm.put(key, blockNBT.getIntArray("storeValue"));

		        	//System.out.println("TEST E : " + key);
		        }

		        boolean hitFlg = false;
		        boolean allRun = true;
		        for (String key : trm.keySet())
		        {
		        	//System.out.println("XXXXXXXXXXX+" + key);
		        	if(hitFlg || selectingBlock.equalsIgnoreCase(""))
		        	{
		        		//System.out.println("PPPP" + key);
		        		for(int cnt = 0; cnt < 16; cnt++)
		        		{
		        			ItemStack its2 = new ItemStack((Block)rn.getObject(key), 1, cnt);
		        			//System.out.println("TEST1:" + its2.getDisplayName() + "/" + trm.get(key)[cnt]);
		        			if(trm.get(key)[cnt] > 0)
		        			{
		        				selectingBlock = key;
		        				selectingBlockMeta = cnt;
		        				allRun = false;
		        				break;
		        			}
		        		}
		        		/*
		        		selectingBlock = key;
		        		allRun = false;
		        		break;
		        		*/
		        	}

		        	if(key.equalsIgnoreCase(selectingBlock))
		        	{
		        		//System.out.println("QQQQQ" + key);
		        		hitFlg = true;

		        		for(int cnt = selectingBlockMeta + 1; cnt < 16; cnt++)
		        		{
		        			ItemStack its2 = new ItemStack((Block)rn.getObject(key), 1, cnt);
		        			//System.out.println("TEST2:" + its2.getDisplayName() + "/" + trm.get(key)[cnt]);
		        			if(trm.get(key)[cnt] > 0)
		        			{
		        				selectingBlock = key;
		        				selectingBlockMeta = cnt;
		        				allRun = false;
		        				break;
		        			}
		        		}

		        		if(!allRun)
		        		{
		        			break;
		        		}
		        	}
		        }


		        if(allRun)
		        {
		        	selectingBlock = "";
		        	selectingBlockMeta = 0;
		        	//System.out.println("MISS");
		        	if(!ep.worldObj.isRemote)
					{
		        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.settingBlock.1.txt"));
		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}
		        }else
		        {
		        	ItemStack its = new ItemStack((Block)rn.getObject(selectingBlock), 1, selectingBlockMeta);

		        	//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.blockInAct.0.txt"));

		        	if(!ep.worldObj.isRemote)
					{
				        if(selectingBlock.equalsIgnoreCase("")){
				        	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.settingBlock.1.txt"));
				        }else
				        {
				        	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.set.settingBlock.2.txt", new Object[] {its.getDisplayName(), trm.get(selectingBlock)[selectingBlockMeta]}));
				        }
				        ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		//System.out.println("TEST:" + its.getDisplayName() + "/" + trm.get(selectingBlock)[selectingBlockMeta]);
					}
		        }

	        	ExtendedPlayerProperties2.get(ep).setSelectSetBlock(selectingBlock);
	        	ExtendedPlayerProperties2.get(ep).setSelectSetBlockMeta(selectingBlockMeta);

			}
		}

		return par1ItemStack;
    }


	//@Override
    public boolean onItemUse2(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(DQR.conf.MGFarm_enable != 0)
		{

			//System.out.println("DEBUG" + p_77648_7_);

			//System.out.println("DEBUGXXX");
			ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);

			int mode = ExtendedPlayerProperties2.get(ep).getTool1mode();
			int area = ExtendedPlayerProperties2.get(ep).getToolArea();

			int areaX = DQR.conf.MGFarm_Area_X[area];
			int areaY = DQR.conf.MGFarm_Area_Y[area];
			int areaZ = DQR.conf.MGFarm_Area_Z[area];

			int itemDam = areaX * areaY * areaZ * 10;

			//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
			//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);
			if(mode == EnumDqmMGToolMode.MGFARM1_HOE.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
				if(!par3World.isRemote)
				{
					ThreadMGFarmHoe hoeThread = new ThreadMGFarmHoe(par1ItemStack, ep, par3World,
							p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
							p_77648_8_, p_77648_9_, p_77648_10_);
					hoeThread.start();
	        	}
				//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
				/*
				Item hoe = Items.diamond_hoe;
				for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
				{
					//System.out.println("test2:" + areaX + "/" + areaY + "/" + areaZ);
					for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
					{
						//System.out.println("test2:");
						for(int cntZ = (areaZ - 1) / 2 * -1; (areaZ - 1) / 2 >= cntZ; cntZ++)
						{
							//System.out.println("test2:");
							hoe.onItemUse(new ItemStack(Items.diamond_hoe, 1), ep, par3World,
										  p_77648_4_ + cntX, p_77648_5_+ cntY, p_77648_6_ + cntZ, p_77648_7_,
										  p_77648_8_ + cntX, p_77648_9_ + cntY, p_77648_10_ + cntZ);

							//System.out.println("test:" + (p_77648_4_ + cntX) + "/" +  (p_77648_5_+ cntY) + "/" + (p_77648_6_ + cntZ) + "/" + p_77648_7_ + "/" +
									  (p_77648_8_ + cntX) + "/" + (p_77648_9_ + cntY) + "/" + (p_77648_10_ + cntZ));
							//par3World.
						}
					}
				}
				*/
			}else if(mode == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
			{
				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed();
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
			}else if(mode == EnumDqmMGToolMode.MGFARM1_HARVEST.getId())
			{
				//System.out.println("test" + p_77648_7_);

				ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
	        	if(!par3World.isRemote)
	        	{
	        		String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed();
	        		int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);
	        		ThreadMGFarmHarvest harvestThread = new ThreadMGFarmHarvest(par1ItemStack, ep, par3World,
	        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
	        														p_77648_8_, p_77648_9_, p_77648_10_);
	        		harvestThread.start();

	        	}

			}else if(mode == EnumDqmMGToolMode.MGFARM1_STORE.getId())
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
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedIn." + ExtendedPlayerProperties2.get(ep).getSeedSetMode() + ".txt", new Object[] {}));
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
									//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedInAct.1.txt", new Object[] {iStack.getDisplayName(), seedVal + iStack.stackSize}));
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
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedInAct.0.txt"));

						}else
						{
							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedInAct.2.txt"));
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

	//@Override
    public ItemStack onItemRightClick2(ItemStack par1ItemStack, World par2World, EntityPlayer ep)
    {

		//System.out.println("DEBUGYYY:");

		if(DQR.conf.MGFarm_enable != 0)
		{
			int useFlg = ExtendedPlayerProperties2.get(ep).getItemUseFlg();
			//System.out.println("DEBUGYYY:" + useFlg);

			if(useFlg == 0)
			{
				//System.out.println("DEBUGYYY");
				int mode = ExtendedPlayerProperties2.get(ep).getTool1mode();
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
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.areaset.txt", new Object[] {areaX, areaY, areaZ, itemDam}));
			    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}

				}else
				{
					if(mode == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
					{
						String selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed();
						String firstSeed = "";
						int foundFlg = 0;
						Map<String, Integer> seedTable = DQR.MGSeedTable.MGSeedALL;

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

						ExtendedPlayerProperties2.get(ep).setSelectSeed(selectSeed);

						if(!par2World.isRemote)
						{
							RegistryNamespaced rn = Item.itemRegistry;

							ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
							int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);

							DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.0.txt", new Object[] {iStack.getDisplayName(), val}));
				    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						}
//Block.getBlockFromName(p_149684_0_)
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
    	//super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    	//String bookBlock = (new ItemStack(DQDecorates.DqmBlockFarmBookShelf, 1)).getDisplayName();
    	/*
    	String bookName = I18n.format("msg.magictool.farm.info.1.title", new Object[]{});


    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.0.txt", new Object[]{bookBlock}));
    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.1.txt", new Object[]{bookName}));
    	p_77624_3_.add(I18n.format("msg.magictool.farm.info.zero.2.txt", new Object[]{}));
    	*/

    }

}
