package dqr.items.magicTool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.items.base.DqmItemMagicToolBase;
import dqr.playerData.ExtendedPlayerProperties2;

public class DqmItemMGTBreak2 extends DqmItemMagicToolBase{

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int par4, int par5, int par6, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {

		if(DQR.conf.MGBreak2_enable != 0)
		{
			/*
			if(par3World.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == DQDecorates.DqmBlockFarmBookShelf)
			{

				ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);
				if(par3World.isRemote && ep.isSneaking())
				{
					makeBook(ep);
				}

				//ep.inventory.addItemStackToInventory(book);
				return true;
			}
			*/
			//System.out.println("DEBUG" + p_77648_7_);

			//System.out.println("DEBUGXXX");
			ExtendedPlayerProperties2.get(ep).setItemUseFlg(-1);

    		if(DQR.conf.MGBreak2_enable == 1)
    		{
    			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_BREAK.getId());
    		}else if(DQR.conf.MGBreak2_enable == 2)
    		{
    			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_DELETE.getId());
    		}

			int mode = ExtendedPlayerProperties2.get(ep).getToolBreak2mode();
			int area = ExtendedPlayerProperties2.get(ep).getToolBreak2Area();

			int areaX = DQR.conf.MGBreak2_Area_X[area];
			int areaY = DQR.conf.MGBreak2_Area_Y[area];
			int areaZ = DQR.conf.MGBreak2_Area_Z[area];

			int itemDam = areaX * areaY * areaZ * 10;

			//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
			//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);
			ExtendedPlayerProperties2.get(ep).setItemUseFlg(itemDam);
        	if(!par3World.isRemote)
        	{
        		//String seedName = ExtendedPlayerProperties2.get(ep).getSelectSeed();
        		//int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(seedName);

        		/*
        		ThreadMGBreak1 harvestThread = new ThreadMGBreak1(par1ItemStack, ep, par3World,
        														p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_,
        														p_77648_8_, p_77648_9_, p_77648_10_);
        		harvestThread.start();
        		*/

        		//int mode = ExtendedPlayerProperties2.get(ep).getToolBreak1mode();
        		//int area = ExtendedPlayerProperties2.get(ep).getToolBreak1Area();

        		/*
        		int areaX = DQR.conf.MGBreak1_Area_X[area];
        		int areaY = DQR.conf.MGBreak1_Area_Y[area];
        		int areaZ = DQR.conf.MGBreak1_Area_Z[area];

        		int itemDam = areaX * areaY * areaZ * 1;
				*/
        		int fixY = 0;
        		/*
        		int fixY = par7 == 1? 1 : 0;
        		if(par7 == 1 &&
        				(par3.isAirBlock(this.par4 + 1, this.par5 + fixY, this.par6) &&
        				 par3.isAirBlock(this.par4 - 1, this.par5 + fixY, this.par6) &&
        				 par3.isAirBlock(this.par4, this.par5 + fixY, this.par6 + 1) &&
        				 par3.isAirBlock(this.par4, this.par5 + fixY, this.par6 - 1)))
        			{
        				fixY = 0;
        			}
        			*/
        		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
        		//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);

        		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
        		//Item hoe = Items.diamond_hoe;

        		//Block touchBlock = par3World.getBlock(par4, par5, par6);

        		int l = MathHelper.floor_double((double)(ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        		//System.out.println("DEBUG" + l);

        		int loopCnt = 0;

        		if(l == 1)
        		{
        			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
        			for(int cntY =0; cntY < areaY; cntY++)
        			{
        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
        				{
        					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
        					{

        						Block targetBlock = par3World.getBlock(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
        						float blockHardness = targetBlock == null ? -1.0F : targetBlock.getBlockHardness(par3World, par4 + cntZ, par5+ cntY + fixY, par6 + cntX);

        						if(blockHardness >= 0.0F && targetBlock != null && targetBlock != Blocks.air)
        						{
	    							if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	    							{
	    								par3World.func_147480_a(par4 + cntZ, par5+ cntY + fixY, par6 + cntX, true);
	    							}else
	    							{
	    								par3World.setBlockToAir(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
	    							}
	    							par3World.markBlockForUpdate(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
        						}
        					}
        				}
        			}

        			//par3World.markBlockRangeForRenderUpdate(par4, par5, par6 + ((areaX - 1) / 2 * -1), par4 + ((areaZ - 1) * -1), par5 + areaY, par6 + ((areaX - 1) / 2));
        		}else if(l == 2)
        		{
        			for(int cntY =0; cntY < areaY; cntY++)
        			{
        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
        				{
        					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
        					{
        						Block targetBlock = par3World.getBlock(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
        						float blockHardness = targetBlock == null ? -1.0F : targetBlock.getBlockHardness(par3World, par4 + cntX, par5+ cntY + fixY, par6 + cntZ);

        						if(blockHardness >= 0.0F && targetBlock != null && targetBlock != Blocks.air)
        						{
	    							if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	    							{
	    								par3World.func_147480_a(par4 + cntX, par5+ cntY + fixY, par6 + cntZ, true);
	    							}else
	    							{
	    								par3World.setBlockToAir(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
	    							}
	    							par3World.markBlockForUpdate(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
        						}
        					}
        				}
        			}
        			//par3World.markBlockRangeForRenderUpdate(par4 + ((areaX - 1) / 2 * -1), par5, par6, par4 + ((areaX - 1) / 2), par5 + areaY, par6 + ((areaZ - 1) * -1));
        		}else if(l == 3)
        		{
        			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
        			for(int cntY =0; cntY < areaY; cntY++)
        			{
        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
        				{
        					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
        					{
        						Block targetBlock = par3World.getBlock(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
        						float blockHardness = targetBlock == null ? -1.0F : targetBlock.getBlockHardness(par3World, par4 + cntZ, par5+ cntY + fixY, par6 + cntX);

        						if(blockHardness >= 0.0F && targetBlock != null && targetBlock != Blocks.air)
        						{
	    							if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	    							{
	    								par3World.func_147480_a(par4 + cntZ, par5+ cntY + fixY, par6 + cntX, true);
	    							}else
	    							{
	    								par3World.setBlockToAir(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
	    							}
        						}
    							par3World.markBlockForUpdate(par4 + cntZ, par5+ cntY + fixY, par6 + cntX);
        					}
        				}
        			}

        			//par3World.markBlockRangeForRenderUpdate(par4, par5, par6 + ((areaX - 1) / 2 * -1), par4 + ((areaZ - 1)), par5 + areaY, par6 + ((areaX - 1) / 2));
        		}else
        		{
        			for(int cntY =0; cntY < areaY; cntY++)
        			{
        				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
        				{
        					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
        					{
        						Block targetBlock = par3World.getBlock(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
        						float blockHardness = targetBlock == null ? -1.0F : targetBlock.getBlockHardness(par3World, par4 + cntX, par5+ cntY + fixY, par6 + cntZ);

        						if(blockHardness >= 0.0F && targetBlock != null && targetBlock != Blocks.air)
        						{
	    							if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	    							{
	    								par3World.func_147480_a(par4 + cntX, par5+ cntY + fixY, par6 + cntZ, true);
	    							}else
	    							{
	    								par3World.setBlockToAir(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
	    							}
	    							par3World.markBlockForUpdate(par4 + cntX, par5+ cntY + fixY, par6 + cntZ);
        						}
        					}
        				}
        			}
        			//par3World.markBlockRangeForRenderUpdate(par4 + ((areaX - 1) / 2 * -1), par5, par6, par4 + ((areaX - 1) / 2), par5 + areaY, par6 + ((areaZ - 1)));
        		}

        	}
			/*
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
				/
				//////////////////////////////////コメントアウト
				Item hoe = Items.diamond_hoe;
				for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
				{
					//System.out.println("test2:" + areaX + "/" + areaY + "/" + areaZ);
					for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
					{
						//System.out.println("test2:");
						for(int cntZ = (areaZ - 1) / 2 * -1; (areaZ - 1) / 2 >= cntZ; cntZ++)
						{
							System.out.println("test2:");
							hoe.onItemUse(new ItemStack(Items.diamond_hoe, 1), ep, par3World,
										  p_77648_4_ + cntX, p_77648_5_+ cntY, p_77648_6_ + cntZ, p_77648_7_,
										  p_77648_8_ + cntX, p_77648_9_ + cntY, p_77648_10_ + cntZ);

							System.out.println("test:" + (p_77648_4_ + cntX) + "/" +  (p_77648_5_+ cntY) + "/" + (p_77648_6_ + cntZ) + "/" + p_77648_7_ + "/" +
									  (p_77648_8_ + cntX) + "/" + (p_77648_9_ + cntY) + "/" + (p_77648_10_ + cntZ));
							//par3World.
						}
					}
				}
				///////////////////////////////////////ここまで
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

			}
			else if(mode == EnumDqmMGToolMode.MGFARM1_STORE.getId())
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
			*/
		}

        return false;
    }






	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer ep)
    {

		if(DQR.conf.MGBreak2_enable != 0)
		{
			int useFlg = ExtendedPlayerProperties2.get(ep).getItemUseFlg();
			//System.out.println("DEBUGYYY:" + useFlg);

			if(useFlg == 0)
			{
				//System.out.println("DEBUGYYY");
				int mode = ExtendedPlayerProperties2.get(ep).getToolBreak2mode();
				int area = ExtendedPlayerProperties2.get(ep).getToolBreak2Area();

				if(ep.isSneaking())
				{
					if(area + 1 < DQR.conf.MGBreak2_Area_X.length)
					{
						area = area + 1;
					}else
					{
						area = 0;
					}

					int areaX = DQR.conf.MGBreak2_Area_X[area];
					int areaY = DQR.conf.MGBreak2_Area_Y[area];
					int areaZ = DQR.conf.MGBreak2_Area_Z[area];

					int itemDam = areaX * areaY * areaZ * 1;

					ExtendedPlayerProperties2.get(ep).setToolBreak2Area(area);

					if(!par2World.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.areaset.txt", new Object[] {areaX, areaY, areaZ, itemDam}));
			    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					}

				}else
				{
					/*
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

							ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.0.txt", new Object[] {iStack.getDisplayName(), val}));
				    		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						}

						//System.out.println(selectSeed);
					}
					*/
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

}
