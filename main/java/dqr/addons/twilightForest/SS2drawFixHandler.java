package dqr.addons.twilightForest;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import shift.sextiarysector.SSBlocks;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class SS2drawFixHandler {

	public static final String regName = "TwilightForest:";

	@SubscribeEvent(priority=EventPriority.HIGHEST)
	public void onEntityItemPickupEvent(EntityItemPickupEvent event)
	{
		//System.out.println("SS2TasogreFix_1");
		if(event.item != null &&
		   event.item.getEntityItem() != null &&
		   event.item.getEntityItem().getItem() != null &&
		   event.item.getEntityItem().getItem() == Item.getItemFromBlock(SSBlocks.figure))
		{
			try
			{
				if(event.item == null || event.item.getEntityItem() == null)
				{
					return;
				}

				ItemStack stack = event.item.getEntityItem();
				NBTTagCompound nbt = stack.getTagCompound();
				//System.out.println("SS2TasogreFix_2");
				if(nbt != null && nbt.hasKey("figure"))
				{
					//System.out.println("SS2TasogreFix_3");
					ItemStack fItem = new ItemStack(Blocks.dirt);
					fItem.readFromNBT(nbt.getCompoundTag("figure"));



					RegistryNamespaced rni = Item.itemRegistry;
					RegistryNamespaced rnb = Block.blockRegistry;
					//System.out.println("TasogareFix log: " + rni.getNameForObject(fItem.getItem()));
					//System.out.println("TasogareFix log: " + rnb.getNameForObject(fItem.getItem()));

					if((rni.getNameForObject(fItem.getItem()) != null && rni.getNameForObject(fItem.getItem()).toUpperCase().indexOf(regName.toUpperCase()) >= 0) ||
						(rnb.getNameForObject(fItem.getItem()) != null && rnb.getNameForObject(fItem.getItem()).toUpperCase().indexOf(regName.toUpperCase()) >= 0))
					{
						//System.out.println("SS2TasogreFix_5");
						/*
						ItemStack newItem= new ItemStack(Items.book);
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						newItem.writeToNBT(nbttagcompound1);
				        nbt.setTag("figure", nbttagcompound1);
				        */
						ItemStack newItem = new ItemStack(DQR.addons.itemTwilightFigureDummy, 1);

						NBTTagCompound newNbt = newItem.getTagCompound();
						if(newNbt == null)
						{
							newNbt = new NBTTagCompound();
						}

						newNbt.setString("dummy_name", fItem.getDisplayName());
						newNbt.setString("dummy_edition", "Achivement");
						newNbt.setInteger("dummy_itemId", Item.getIdFromItem(fItem.getItem()));

						newItem.setTagCompound(newNbt);

						event.item.setEntityItemStack(newItem);
					}

					/*
					if(DQR.debug > 0)
					{
						if(fItem != null)
						{
							ItemStack newItem = new ItemStack(DQR.addons.itemTwilightFigureDummy, 1);

							NBTTagCompound newNbt = newItem.getTagCompound();
							if(newNbt == null)
							{
								newNbt = new NBTTagCompound();
							}

							newNbt.setString("dummy_name", fItem.getDisplayName());
							newNbt.setString("dummy_edition", "Achivement");
							newNbt.setInteger("dummy_itemId", Item.getIdFromItem(fItem.getItem()));

							newItem.setTagCompound(newNbt);

							event.item.setEntityItemStack(newItem);
						}

					}
					*/

					/*
					if(DQR.debug > 0)
					{
						ItemStack newItem= new ItemStack(Items.book);
						NBTTagCompound nbttagcompound1 = fItem.getTagCompound();


						//if(nbttagcompound1 == null)
						//{
						//	nbttagcompound1 = new NBTTagCompound();
						//}

						//newItem.writeToNBT(nbttagcompound1);

						String dispName = fItem.getDisplayName();
						//NBTTagCompound nbttagcompound2 = new NBTTagCompound();
						//nbttagcompound2.setString("Name", dispName);
						//nbttagcompound1.setTag("display", nbttagcompound2);

						System.out.println("SS2TasogreFix_A : " + dispName);
						//System.out.println("SS2TasogreFix_B : " + dispName);
						//newItem.getDisplayName()
				        nbt.setTag("figure", nbttagcompound1);

				        stack.setTagCompound(nbt);
				        stack.setStackDisplayName(dispName);
				        System.out.println("SS2TasogreFix_4");
				        //event.item.getEntityItem() = stack;
				        //event.item
					}
					*/

				}
			}catch (Exception e)
			{

			}
		}
	}


}
