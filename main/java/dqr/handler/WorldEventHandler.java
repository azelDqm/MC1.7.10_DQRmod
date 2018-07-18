package dqr.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.Items.DQWeapons;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;

public class WorldEventHandler {


	/*
	@SubscribeEvent
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof DqmPetBase)
		{
			System.out.println("TESTTESTTESTTESTTESTTESTTESTTEST");
		}
	}
	*/
	/*
	@SubscribeEvent
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityItem)
		{
			Entity item = event.entity;

			if(item != null && item instanceof EntityItem)
			{
				ItemStack stack = ((EntityItem)item).getEntityItem();

				if(stack != null && stack.getItem() instanceof DqmItemWeaponBase)
				{

					//ObfuscationReflectionHelper.setPrivateValue(item.getClass().getSuperclass(), event.entity, true, "invulnerable");
					event.entity.fireResistance = 10000;

	    			try {

	    				Class cl = item.getClass().getSuperclass();
	    				Field[] test = cl.getDeclaredFields();
	    				//Boolean CONVERTING = ObfuscationReflectionHelper.getPrivateValue(Entity.class, event.entity, "CONVERTING", "invulnerable");

	    				for(int cnt = 0; cnt < test.length; cnt++)
	    				{
	    					//System.out.println("TEST : " + test[cnt].getName());
	    					if(test[cnt].getName().equalsIgnoreCase("invulnerable"))
	    					{

	    						test[cnt].setAccessible(true);
	    						test[cnt].set(item, Boolean.valueOf(true));
	    					}

	    					if(test[cnt].getName().equalsIgnoreCase("isImmuneToFire"))
	    					{

	    						test[cnt].setAccessible(true);
	    						test[cnt].set(item, Boolean.valueOf(true));
	    					}
	    				}

					} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}


				}
			}
		}
	}
	*/


	/*ボツ(ItemEntityUnbreakだと、Entityの状態が保存されない。)
	@SubscribeEvent
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
	{

		//System.out.println("CASE1 : " + event.world.isRemote);
		if(event.entity instanceof EntityItem)
		{
			EntityItem item = (EntityItem)event.entity;

			if(item != null)
			{
				//Entity ent = (Entity)((((Class)item).getSuperclass()).getClass());

				//ItemStack stack = item.getDataWatcher().getWatchableObjectItemStack(10);
				ItemStack stack = item.getEntityItem();

				if(stack != null && stack.getItem() instanceof DqmItemWeaponBase && !(event.entity instanceof ItemEntityUnbreak))
				{
					System.out.println("CASE2 : " + event.world.isRemote);
					ItemEntityUnbreak newItem = new ItemEntityUnbreak(event.world, item.posX, item.posY, item.posZ, new ItemStack(DQWeapons.itemRotonoturugi, 1));
					newItem.delayBeforeCanPickup = item.delayBeforeCanPickup;
					newItem.fireResistance = 1000;
					newItem.motionX = item.motionX;
					newItem.motionY = item.motionY;
					newItem.motionZ = item.motionZ;
					event.world.spawnEntityInWorld(newItem);
					event.entity.setDead();

				}
			}
		}
	}
	*/

	@SubscribeEvent
	public void onInitNoiseGensEvent(BlockEvent.BreakEvent event)
	{
		/*
		if(DQR.debug != 0)
		{
			System.out.println("TEST R1 : " + event.block.getMaterial().blocksMovement());
			System.out.println("TEST R2 : " + event.block.getMaterial().toString());
			System.out.println("TEST R1 : " + event.block.getMaterial().getCanBlockGrass());
			System.out.println("TEST R1 : " + (event.block.getMaterial() == event.block.getMaterial().air));
		}
		*/

		//System.out.println("TEST");
		if(event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() instanceof DqmItemWeaponBase)
		{
			//System.out.println("TEST" + event.block.getUnlocalizedName() + "/" + event.blockMetadata);
			//System.out.println(event.x + "/" +event.y + "/" + event.z );
			DqmItemWeaponBase weapon = (DqmItemWeaponBase)event.getPlayer().getHeldItem().getItem();

			if(weapon.getMaterial() == DQR.dqmMaterial.DqmAxe || weapon == DQWeapons.itemHaruberuto)
			{
				int itemMode = ExtendedPlayerProperties.get(event.getPlayer()).getWeaponMode(1);
				RegistryNamespaced rn = Block.blockRegistry;

				int addDam = 0;
				if(itemMode > 0)
				{

					if(DQR.cuttingWood.cuttingWoodBlockId.containsKey(event.block))
					{
						//System.out.println("TESDT!!!" + event.block.getUnlocalizedName());
						Block touchBlock = event.block;
						int touchMeta = event.blockMetadata;
						Map<Item, int[]> dropItemSet = new HashMap<>();
						boolean soundFlg = false;
						World wld = event.world;
						//原木チェック
						for(int cntY = 0 - DQR.conf.CuttingWoodUnder; cntY <= DQR.conf.CuttingWoodHeight; cntY++)
						{
							for(int cntX = DQR.conf.CuttingWoodRadius * -1; cntX <= DQR.conf.CuttingWoodRadius; cntX++)
							{
								for(int cntZ = DQR.conf.CuttingWoodRadius * -1; cntZ <= DQR.conf.CuttingWoodRadius; cntZ++)
								{
									if(wld.getBlock(event.x + cntX, event.y + cntY, event.z +cntZ) == touchBlock &&
									   wld.getBlockMetadata(event.x + cntX, event.y + cntY, event.z +cntZ) == touchMeta)
									{
										addDam = addDam + 2;
										if(DQR.conf.CuttingSmoothBreak != 0)
										{
											int targetMeta = wld.getBlockMetadata(event.x + cntX, event.y + cntY, event.z +cntZ);
											Block targetBlock = wld.getBlock(event.x + cntX, event.y + cntY, event.z +cntZ);
											if(!event.world.isRemote)
											{
												wld.setBlockToAir(event.x + cntX, event.y + cntY, event.z +cntZ);
											}

											//System.out.println("METADATA値1？？？？？？？？？" + targetMeta);
											Random rand = new Random();

	        								if(!soundFlg)
	        								{
	        									event.getPlayer().worldObj.playSoundAtEntity(event.getPlayer(), "dig.wood", 1.0F, 1.0F);
	        									soundFlg = true;
	        								}
	        								Item blockKey = targetBlock.getItemDropped(targetMeta, rand, 0);
	        								if(dropItemSet.containsKey(blockKey))
	        								{
	        									if(targetBlock.damageDropped(targetMeta) > 15)
	        									{
	        	    								ItemStack drop = new ItemStack(blockKey, targetBlock.quantityDropped(targetMeta, 0, rand), targetBlock.damageDropped(targetMeta));
	        	    								EntityItem itemR = new EntityItem(wld, event.x, event.y, event.z, drop);
	    											if(!event.world.isRemote)
	    											{
	    												wld.spawnEntityInWorld(itemR);
	    											}
	        									}else
	        									{
	        										//int itemVal = dropItemSet.get(blockKey);
	        										int[] valInt = dropItemSet.get(blockKey);
	        										valInt[targetBlock.damageDropped(targetMeta)] = valInt[targetBlock.damageDropped(targetMeta)] + targetBlock.quantityDropped(targetMeta, 0, rand);
	        										dropItemSet.put(blockKey, valInt);
	        									}

	        									//dropItemSet.put(blockKey, itemVal + targetBlock.quantityDropped(targetMeta, 0, rand));
	        								}else
	        								{
	        									if(targetBlock.damageDropped(targetMeta) > 15)
	        									{
	        	    								ItemStack drop = new ItemStack(blockKey, targetBlock.quantityDropped(targetMeta, 0, rand), targetBlock.damageDropped(targetMeta));
	        	    								EntityItem itemR = new EntityItem(wld, event.x, event.y, event.z, drop);
	    											if(!event.world.isRemote)
	    											{
	    												wld.spawnEntityInWorld(itemR);
	    											}
	        									}else
	        									{
	        										//System.out.println(" new key!!!!!!!!!!!!!!!!!!!!!");
	        										int[] valInt = new int[16];
	        										valInt[targetBlock.damageDropped(targetMeta)] = targetBlock.quantityDropped(targetMeta, 0, rand);
	        										dropItemSet.put(blockKey, valInt);
	        									}

	        									//System.out.println("METADATA値3？？？？？？？？？" + targetMeta);
	        									//Block.getIdFromBlock(p_149682_0_)
	        								}
										}else
										{
											if(!event.world.isRemote)
											{
												wld.func_147480_a(event.x + cntX, event.y + cntY, event.z +cntZ, true);
											}
										}
									}
								}
							}
						}


						if(itemMode > 1)
						{
							//葉チェック
							soundFlg = false;
							for(int cntY = 0 - DQR.conf.CuttingLeaveUnder; cntY <= DQR.conf.CuttingLeaveHeight; cntY++)
							{
								for(int cntX = DQR.conf.CuttingLeaveRadius * -1; cntX <= DQR.conf.CuttingLeaveRadius; cntX++)
								{
									for(int cntZ = DQR.conf.CuttingLeaveRadius * -1; cntZ <= DQR.conf.CuttingLeaveRadius; cntZ++)
									{

										//対象葉か検証
										Block targetBlock = wld.getBlock(event.x + cntX, event.y + cntY, event.z +cntZ);
										int targetMeta = wld.getBlockMetadata(event.x + cntX, event.y + cntY, event.z +cntZ);

										//System.out.println("METADATA値2？？？？？？？？？" + targetMeta);
										Random rand = new Random();


										if(!wld.isAirBlock(event.x + cntX, event.y + cntY, event.z +cntZ) && DQR.cuttingWood.isCuttingLeave(targetBlock))
										{
											addDam = addDam + 1;
											//System.out.println("targetBlock:" + targetBlock.getUnlocalizedName());
											//System.out.println(" new key2!!!!!");
											if(DQR.conf.CuttingSmoothBreak != 0)
											{
												//System.out.println(" new key3!!!!!");
												if(!event.world.isRemote)
												{
													wld.setBlockToAir(event.x + cntX, event.y + cntY, event.z +cntZ);
												}

		        								if(!soundFlg)
		        								{
		        									event.getPlayer().worldObj.playSoundAtEntity(event.getPlayer(), "dig.grass", 1.0F, 1.0F);
		        									soundFlg = true;
		        								}
		        								Item blockKey = targetBlock.getItemDropped(targetMeta, rand, 0);
	        									if((targetBlock == Blocks.leaves || targetBlock == Blocks.leaves2) )
	        									{
	        										if(Blocks.sapling == Block.getBlockFromItem(blockKey))
	        										{
	        											if(targetMeta > 7)
	        											{
	        												targetMeta = targetMeta - 8;
	        											}

	        											if(targetBlock == Blocks.leaves2)
	        											{
	        												targetMeta = targetMeta + 4;
	        											}
	        										}

	        									}

		        								if(dropItemSet.containsKey(blockKey))
		        								{

		        									if(targetBlock.damageDropped(targetMeta) > 15)
		        									{
		        	    								ItemStack drop = new ItemStack(blockKey, targetBlock.quantityDropped(targetMeta, 0, rand), targetBlock.damageDropped(targetMeta));
		        	    								EntityItem itemR = new EntityItem(wld, event.x, event.y, event.z, drop);
		    											if(!event.world.isRemote)
		    											{
		    												wld.spawnEntityInWorld(itemR);
		    											}
		        									}else
		        									{
		        										//int itemVal = dropItemSet.get(blockKey);
		        										int[] valInt = dropItemSet.get(blockKey);
		        										valInt[targetBlock.damageDropped(targetMeta)] = valInt[targetBlock.damageDropped(targetMeta)] + targetBlock.quantityDropped(targetMeta, 0, rand);
		        										dropItemSet.put(blockKey, valInt);
		        									}
		        									//System.out.println("METADATA値1？？？？？？？？？" + targetMeta);
		        									//dropItemSet.put(blockKey, itemVal + targetBlock.quantityDropped(targetMeta, 0, rand));
		        								}else
		        								{
		        									if(targetBlock.damageDropped(targetMeta) > 15)
		        									{
		        	    								ItemStack drop = new ItemStack(blockKey, targetBlock.quantityDropped(targetMeta, 0, rand), targetBlock.damageDropped(targetMeta));
		        	    								EntityItem itemR = new EntityItem(wld, event.x, event.y, event.z, drop);
		    											if(!event.world.isRemote)
		    											{
		    												wld.spawnEntityInWorld(itemR);
		    											}
		        									}else
		        									{
		        										//System.out.println(" new key!!!!!!!!!!!!!!!!!!!!!");
		        										int[] valInt = new int[16];
		        										valInt[targetBlock.damageDropped(targetMeta)] = targetBlock.quantityDropped(targetMeta, 0, rand);
		        										dropItemSet.put(blockKey, valInt);
		        										//System.out.println("METADATA値2？？？？？？？？？" + targetMeta);
		        										//Block.getIdFromBlock(p_149682_0_)
		        									}
		        								}
											}else
											{
												if(!event.world.isRemote)
												{
													wld.func_147480_a(event.x + cntX, event.y + cntY, event.z +cntZ, true);
												}
											}
										}

									}
								}
							}
						}


						if(addDam > 0)
						{
							event.getPlayer().getHeldItem().damageItem(addDam, event.getPlayer());
						}

						if(!wld.isRemote)
						{
			        		//スムース破壊の場合のアイテムドロップ
			    			for (Item key : dropItemSet.keySet())
			    			{
			    			    //System.out.println(key + " => " + dropItemSet.get(key));
			    				int[] valInt = dropItemSet.get(key);

			    				for(int cnt = 0; cnt < valInt.length; cnt++)
			    				{
			    					if(valInt[cnt] > 0)
			    					{
			    						for(int cntR = 0; cntR <= valInt[cnt] / 64; cntR++)
			    						{
			    							ItemStack dropStack = null;
			    							if(valInt[cnt] - 64 * cntR > 64)
			    							{
			    								dropStack = new ItemStack(key, 64, cnt);
			    							}else
			    							{
			    								dropStack = new ItemStack(key, valInt[cnt] - 64 * cntR, cnt);
			    							}

			    							//System.out.println("METADATA値？？？？？？？？？" + cnt);
											EntityItem itemX = new EntityItem(wld, event.x, event.y, event.z, dropStack);
											if(!event.world.isRemote)
											{
												wld.spawnEntityInWorld(itemX);
											}
			    						}
			    					}
			    				}
			    			}
						}
					}
				}
			}
		}
	}

}
