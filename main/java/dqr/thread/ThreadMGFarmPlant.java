package dqr.thread;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties2;

public class ThreadMGFarmPlant extends Thread{

	private ItemStack par1;
	private EntityPlayer ep;
	private World par3;
	private int par4;
	private int par5;
	private int par6;

	private int par7;

	private float par8;
	private float par9;
	private float par10;
	private String itemName;
	private int maxVal;

	public ThreadMGFarmPlant(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_, String itemName, int maxVal)
	{

		this.par1 = par1ItemStack;
		this.ep = ep;
		this.par3 = par3World;
		this.par4 = p_77648_4_;
		this.par5 = p_77648_5_;
		this.par6 = p_77648_6_;
		this.par7 = p_77648_7_;
		this.par8 = p_77648_8_;
		this.par9 = p_77648_9_;
		this.par10 = p_77648_10_;
		this.itemName = itemName;
		this.maxVal = maxVal;
	}

	public void run()
	{

		int mode = ExtendedPlayerProperties2.get(this.ep).getTool1mode();
		int area = ExtendedPlayerProperties2.get(this.ep).getToolArea();

		int areaX = DQR.conf.MGFarm_Area_X[area];
		int areaY = DQR.conf.MGFarm_Area_Y[area];
		int areaZ = DQR.conf.MGFarm_Area_Z[area];

		int itemDam = areaX * areaY * areaZ * 10;

		int plantCnt = 0;
		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);

		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		RegistryNamespaced rn = Item.itemRegistry;
		Item seed = (Item)rn.getObject(itemName);
		ItemStack dummy = new ItemStack(seed, 1);
		//Item seed = seed;

		int l = MathHelper.floor_double((double)(ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		//System.out.println("DEBUG" + l);
		int val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
		boolean plantFlg = false;

		if(val <= 0)
		{
			return;
		}

		if(l == 1)
		{
			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
					{
						plantFlg = seed.onItemUse(new ItemStack(seed, 1024), ep, this.par3,
									  this.par4 + cntZ, this.par5+ cntY, this.par6 + cntX, 1,
									  this.par8 + cntZ, this.par9 + cntY, this.par10 + cntX);

						if(plantFlg == true)
						{
							val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
							if(val - 1 <= 0)
							{
								 ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , 0);

								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.1.txt",new Object[] {dummy.getDisplayName(), 0}));

								 return;
							}else
							{
								val = val - 1;
								ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , val);
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
						plantFlg = seed.onItemUse(new ItemStack(seed, 1024), ep, this.par3,
									  this.par4 + cntX, this.par5+ cntY, this.par6 + cntZ, 1,
									  this.par8 + cntX, this.par9 + cntY, this.par10 + cntZ);

						if(plantFlg)
						{
							val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
							if(val - 1 <= 0)
							{
								 ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , 0);

								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.1.txt",new Object[] {dummy.getDisplayName(), 0}));


								 return;
							}else
							{
								val = val - 1;
								ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , val);
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
						plantFlg = seed.onItemUse(new ItemStack(seed, 1024), ep, this.par3,
									  this.par4 + cntZ, this.par5+ cntY, this.par6 + cntX, 1,
									  this.par8 + cntZ, this.par9 + cntY, this.par10 + cntX);

						if(plantFlg)
						{
							val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
							if(val - 1 <= 0)
							{
								 ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , 0);

								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.1.txt",new Object[] {dummy.getDisplayName(), 0}));


								 return;
							}else
							{
								val = val - 1;
								ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , val);
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
						plantFlg = seed.onItemUse(new ItemStack(seed, 1024), ep, this.par3,
									  this.par4 + cntX, this.par5+ cntY, this.par6 + cntZ, 1,
									  this.par8 + cntX, this.par9 + cntY, this.par10 + cntZ);

						if(plantFlg)
						{
							val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
							if(val - 1 <= 0)
							{
								 ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , 0);

								DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.1.txt",new Object[] {dummy.getDisplayName(), 0}));


								 return;
							}else
							{
								val = val - 1;
								ExtendedPlayerProperties2.get(ep).setSeedVal(itemName , val);
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
					hoe.onItemUse(new ItemStack(seed, 1024), ep, this.par3,
								  this.par4 + cntX, this.par5+ cntY, this.par6 + cntZ, this.par7,
								  this.par8 + cntX, this.par9 + cntY, this.par10 + cntZ);
				}
			}
		}
		*/
		val = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magictool.farm.seedPlant.1.txt",new Object[] {dummy.getDisplayName(), val}));

	}

}
