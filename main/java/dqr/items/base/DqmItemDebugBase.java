package dqr.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DqmItemDebugBase extends Item{

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		//System.out.println("TEST-1 : " + p_77648_4_ + "/" + p_77648_5_ + "/" + p_77648_6_ + "/" + p_77648_7_);
		//System.out.println("TEST-2 : " + p_77648_8_ + "/" + p_77648_9_ + "/" + p_77648_10_);

		System.out.println("TEST-2 : " + par3World.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).getUnlocalizedName());
		System.out.println("TEST-3 : " + par3World.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_));
		/*
		if (p_77648_7_ != 0 && par3World.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
		{

		}
		*/
		return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {

		EntityPlayer ep = player;

		//System.out.println("TEST1 : " + ep.serverPosX + " / " + ep.serverPosZ + " : " + ep.worldObj);
    	/*
    	if(!world.isRemote)
    	{
    		if(!player.isSneaking())
    		{
    			List ls = world.getLoadedEntityList();
    			for(int i = 0; i < ls.size(); i++)
    			{
    				if(ls.get(i) instanceof DqmPetBase)
    				{
    					DqmPetBase pet = (DqmPetBase)ls.get(i);
    					//System.out.println("TEST" + pet.getUniqueID());
    				}
    			}
    		}



    	}
    	*/

    	/*
    	RegistryNamespaced rnb = Block.blockRegistry;
    	RegistryNamespaced rni = Item.itemRegistry;

    	System.out.println("TEST1 : " + rnb.getNameForObject(this));
    	System.out.println("TEST2 : " + rni.getNameForObject(this));
		*/

    	if(!world.isRemote)
    	{
    		//player.curePotionEffects(new ItemStack(Items.milk_bucket, 1));
	    	//System.out.println("TEST");
	    	//DqmGansekiBlock bl = new DqmGansekiBlock();
	    	//bl.pEP = player;
	    	//bl.damage = 80.0F;

    		/*
	    	world.setBlock((int)player.posX + 1, (int)player.posY + 8, (int)player.posZ, DQBlocks.DqmBlockGanseki, 1, 2);
    		//System.out.println("TEST");
	    	if(world.getBlock((int)player.posX + 1, (int)player.posY + 8, (int)player.posZ) instanceof DqmGansekiBlock)
	    	{
	    		//System.out.println("TEST2");
	    		DqmGansekiBlock vlock = (DqmGansekiBlock)world.getBlock((int)player.posX + 1, (int)player.posY + 8, (int)player.posZ);
	    		vlock.pEP = player;
	    		vlock.damage = 80.0F;
	    		//world.markBlockForUpdate((int)player.posX + 1, (int)player.posY + 8, (int)player.posZ);
	    		//world.setBlockMetadataWithNotify((int)player.posX + 1, (int)player.posY + 8, (int)player.posZ, 0, 2);
	    		//world.scheduleBlockUpdate((int)player.posX + 1,(int)player.posY + 8, (int)player.posZ, vlock, vlock.tickRate(world));
	    		//vlock.updateTick(world, (int)player.posX + 1,(int)player.posY + 8, (int)player.posZ, new Random());
	    		//System.out.println("TEST3");
	    	}
	    	*/




    	}

    	/*
        List list = world.getEntitiesWithinAABBExcludingEntity(player,
        		player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(10.0D, 5.0D, 10.0D));

        if (list != null && !list.isEmpty())
        {
        	for (int n = 0 ; n < list.size() ; n++)
        	{
        		Entity target = (Entity)list.get(n);
        		if(target instanceof EntityLivingBase)
        		{
    				EntityLivingBase elv = (EntityLivingBase)target;
    				if(player.isWet())
    				{
	        			if(player.isSneaking())
	        			{

	        				//System.out.println("TET4 : " + elv.getCommandSenderName());
	        				//elv.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRariho.id, 100, 0));
	        				//elv.addPotionEffect(new PotionEffect( .id, 100, 1));

	        			}else
	        			{

	        				System.out.println("TET3 : " + elv.getCommandSenderName());
	        				//elv.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRariho.id, 100, 0));
	        				elv.addPotionEffect(new PotionEffect(DQPotionMinus.debuffMahoton.id, 100, 1));
	        			}
    				}else
    				{
	        			if(player.isSneaking())
	        			{
	        				System.out.println("TET2 : " + elv.getCommandSenderName());
	        				elv.clearActivePotions();
	        			}else
	        			{

	        				System.out.println("TET : " + elv.getCommandSenderName());
	        				//elv.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRariho.id, 100, 0));
	        				elv.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRariho.id, 100, 1));
	        			}
    				}
        		}
        	}
        }
        */
    	/*
    	if(player.isSneaking())
    	{
    		player.openGui(DQR.instance, 999, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    	}else
    	{
    		//player.openGui(DQR.instance, DQR.conf.GuiID_CSSlot, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    		//player.openGui(DQR.instance, DQR.conf.GuiID_CEWeapon, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    		player.openGui(DQR.instance, DQR.conf.GuiID_CSCCR, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
    	}
    	*/



        /*
            GUIを開く。インスタンス, GUIのID, World, X, Y, Z
         */
    	//player.addChatMessage(new ChatComponentTranslation("TEST"));
    	//System.out.println("" + player.worldObj.isRemote);

/*
    	if(!world.isRemote)
    	{
    		//System.out.println("TEST");
    		ThrowItemEntityIshitubute et = new ThrowItemEntityIshitubute(world, player, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    		et.setMaxTicksRange(2);
    		//et.setPosition(player.posX, player.posY, player.posZ);
    		world.spawnEntityInWorld(et);

    		//et.getUniqueID();

    	}
    	*/




        //player.openGui(DQR.instance, DQR.conf.GuiID_PetBook, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    	//player.openGui(DQR.instance, DQR.conf.GuiID_PetStatus, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    	//System.out.println("TEST" + System.currentTimeMillis());

    	//StringTranslate test = new StringTranslate();
    	//System.out.println(test.translateKey("main.job.17"));
    	//System.out.println(StatCollector.translateToLocal("main.job.17"));
    	//StatCollector.translateToLocal(p_74838_0_)

    	//itemStack.setStackDisplayName("main.job.17");

    	/*
    	RegistryNamespaced rn = Item.itemRegistry;

    	if(player.isSneaking())
    	{
    		player.inventory.addItemStackToInventory(new ItemStack((Item)rn.getObject("DQMIIINext:blockYakusouSeed2"), 64));
    	}else
    	{

    		if((Item)rn.getObject("DQMIIINext:hogehoge") != null)
    		{
    			player.inventory.addItemStackToInventory(new ItemStack((Item)rn.getObject("DQMIIINext:hogehoge"), 1));
    		}else
    		{
    			//System.out.println("TESTTEST");
    		}

    	}
    	*/


    	/*
    	int job = ExtendedPlayerProperties.get(player).getJob();

    	if(job == EnumDqmJob.MASTERDRAGON.getId())
    	{
    		ExtendedPlayerProperties.get(player).setJob(0);
    	}else
    	{
    		ExtendedPlayerProperties.get(player).setJob(job + 1);
    	}
    	*/

    	//int job = ExtendedPlayerProperties.get(player).getJob();
    	//int exp = ExtendedPlayerProperties.get(player).getJobExp(job);

    	//ExtendedPlayerProperties.get(player).setJobExp(job, exp + 11708704);



    	/*
    	if(!world.isRemote)
    	{
    		Entity et = new DqmEntityYouganmajin(world);
    		et.setPosition(player.posX, player.posY, player.posZ);
    		world.spawnEntityInWorld(et);

    		et.getUniqueID();

    	}
*/

/*
    	if(player.isSneaking())
    	{

    		//player.openGui(DQR.instance, 3, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        	int job = ExtendedPlayerProperties.get(player).getJob();
        	int exp = ExtendedPlayerProperties.get(player).getJobExp(job);

        	ExtendedPlayerProperties.get(player).setJobExp(job, exp + 930921);
    	}else
    	{
    		Map<String, String> cfg_generateOre = new HashMap<>();

    		cfg_generateOre.put("test", "CAU");
    		cfg_generateOre.put(null, "CAU2");

    		player.addChatComponentMessage(new ChatComponentTranslation("Dim:" + cfg_generateOre.containsKey("test") + "/" + cfg_generateOre.containsKey(null)));
    		//player.addChatComponentMessage(new ChatComponentTranslation("DimensionID" + world.provider.dimensionId));
    		//player.addChatComponentMessage(new ChatComponentTranslation("DimensionID" + world.getWorldInfo().getWorldName()));
    		//player.addChatComponentMessage(new ChatComponentTranslation("Dim:" + world.provider.getDimensionName() +
    		//		world.provider.getSaveFolder()));
    	}
*/



        return itemStack;


    }

}
