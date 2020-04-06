package dqr.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties6;


public class DqrComDebug2 extends CommandBase {
	@Override
	public String getCommandName() {
		return "dqr3";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		//System.out.println("test" + var1.getCommandSenderName());

		//World hoge = var1.getEntityWorld();
		//hoge.getWorldInfo().setSpawnPosition(p_76081_1_, p_76081_2_, p_76081_3_);

		EntityPlayer ep = (EntityPlayer)var1;

        if("debug".equalsIgnoreCase(var2[0]))
        {
        	if(var2.length == 1)
        	{
	        	System.out.println(var1.getEntityWorld().getBlock(Integer.parseInt(var2[1]), Integer.parseInt(var2[2]), Integer.parseInt(var2[3])).getUnlocalizedName());

	        	System.out.println("DIMNAME" + var1.getEntityWorld().provider.getDimensionName());
	        	System.out.println("DIMID" + var1.getEntityWorld().provider.dimensionId);
	        	System.out.println("DIMSAVE" + var1.getEntityWorld().provider.getSaveFolder());
        	}else if(var2.length > 1)
        	{
        		if("mode".equalsIgnoreCase(var2[1]))
        		{
        			DQR.debug = Integer.parseInt(var2[2]);
        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("debug mode change to " + var2[2], new Object[] {}));
        		}
        	}
        	/*
        	RegistryNamespaced rnB = Item.itemRegistry;
        	RegistryNamespaced rnX = Block.blockRegistry;


        	//System.out.println(rnB.getNameForObject(ep.inventory.mainInventory[0].getItem()));

        	if(Block.getBlockFromItem(ep.inventory.mainInventory[0].getItem()) == null)
        	{
        		//System.out.println("NULL");
        	}else
        	{
        		//System.out.println( rnX.getNameForObject(        							(Block.getBlockFromItem(ep.inventory.mainInventory[0].getItem()))        							));
        	}
        	*/
        }else if("debug2".equalsIgnoreCase(var2[0]))
        {
        	if(var2.length >= 1)
        	{
        		if("kbres".equalsIgnoreCase(var2[1]))
        		{
        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("Knockback resist " + ep.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue(), new Object[] {}));
        		}

        		if("kbset".equalsIgnoreCase(var2[1]))
        		{
        			ep.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((double)Integer.parseInt(var2[2]));
        		}

        		if("petlist".equalsIgnoreCase(var2[1]))
        		{
        			NBTTagCompound playerPet = ExtendedPlayerProperties6.get(ep).getNBTPlayerPetList();
        			Object[] keys = playerPet.func_150296_c().toArray();
        			for(int cnt = 0; cnt < keys.length; cnt++)
        			{
        				DQR.func.debugString("TEST_Pet 1 : " + (String)keys[cnt]);
        			}

        			//ep.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((double)Integer.parseInt(var2[2]));
        		}

        		if("kbdo".equalsIgnoreCase(var2[1]))
        		{
        			//ep.addVelocity((double)(-MathHelper.sin(ep.rotationYaw * (float)Math.PI / 180.0F) * (float)Integer.parseInt(var2[2]) * 0.5F), 0.1D, (double)(MathHelper.cos(ep.rotationYaw * (float)Math.PI / 180.0F) * (float)Integer.parseInt(var2[2]) * 0.5F));

                    ep.isAirBorne = true;
                    float f1 = MathHelper.sqrt_double(Double.parseDouble(var2[2]) * Double.parseDouble(var2[2]) + Double.parseDouble(var2[3]) * Double.parseDouble(var2[3]));
                    float f2 = 0.4F;
                    ep.motionX /= 2.0D;
                    ep.motionY /= 2.0D;
                    ep.motionZ /= 2.0D;
                    ep.motionX -= Double.parseDouble(var2[2]) / (double)f1 * (double)f2;
                    ep.motionY += (double)f2;
                    ep.motionZ -= Double.parseDouble(var2[3]) / (double)f1 * (double)f2;

                    if (ep.motionY > 0.4000000059604645D)
                    {
                    	ep.motionY = 0.4000000059604645D;
                    }
        		}

        		if("kbdo2".equalsIgnoreCase(var2[1]))
        		{
        			ep.addVelocity((double)(-MathHelper.sin(Float.parseFloat(var2[2]) * (float)Math.PI / 180.0F) * Float.parseFloat(var2[3]) * 0.5F),
        							0.1D,
        							(double)(MathHelper.cos(Float.parseFloat(var2[2]) * (float)Math.PI / 180.0F) * Float.parseFloat(var2[3]) * 0.5F));
        		}



        		if("motion".equalsIgnoreCase(var2[1]))
        		{
        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("motionX : " + ep.motionX + " / motionZ : " + ep.motionZ + " / " + ep.rotationYaw, new Object[] {}));
        		}
        	}
        	/*
        	ItemStack stack = ep.getHeldItem();

        	if(stack != null)
        	{
        		NBTTagCompound nbt = stack.getTagCompound();

        		if(nbt != null)
        		{
        			Set set = nbt.func_150296_c();

        			for (Iterator itr = set.iterator(); itr.hasNext();) {
        			    //System.out.println(itr.next().getClass().getName());
        				System.out.println((String)itr.next());
        			}
        		}
        	}
        	*/
        }
		/*
		if(var2.length < 1)
		{
			throw new WrongUsageException("mpg.commands.mpg.usage", new Object[0]);

		}

		if(!"List".equalsIgnoreCase(var2[0]) && var2.length < 3)
		{
			throw new WrongUsageException("mpg.commands.mpg.usage", new Object[0]);

		}

		//System.out.println("test" + var1.getCommandSenderName());
		EntityPlayerMP sender = getCommandSenderAsPlayer(var1);
        boolean senderOp = MinecraftServer.getServer().getConfigurationManager().func_152596_g(sender.getGameProfile());

        if("send".equalsIgnoreCase(var2[0]))
        {
        	if(MPGuardMain.conf.cfgComPerm_SEND.getInt() == 0)
        	{
        		throw new WrongUsageException("mpg.commands.notActive", new Object[0]);
        	}else if(MPGuardMain.conf.cfgComPerm_SEND.getInt() == 2 && !senderOp)
        	{
        		throw new WrongUsageException("mpg.commands.noPermission", new Object[0]);
        	}
        }else if("add".equalsIgnoreCase(var2[0]))
        {
        	if(MPGuardMain.conf.cfgComPerm_ADD.getInt() == 0)
        	{
        		throw new WrongUsageException("mpg.commands.notActive", new Object[0]);
        	}else if(MPGuardMain.conf.cfgComPerm_ADD.getInt() == 2 && !senderOp)
        	{
        		throw new WrongUsageException("mpg.commands.noPermission", new Object[0]);
        	}
        }else if("remove".equalsIgnoreCase(var2[0]))
        {
        	if(MPGuardMain.conf.cfgComPerm_REMOVE.getInt() == 0)
        	{
        		throw new WrongUsageException("mpg.commands.notActive", new Object[0]);
        	}else if(MPGuardMain.conf.cfgComPerm_REMOVE.getInt() == 2 && !senderOp)
        	{
        		throw new WrongUsageException("mpg.commands.noPermission", new Object[0]);
        	}
        }else if("set".equalsIgnoreCase(var2[0]))
        {
        	if(MPGuardMain.conf.cfgComPerm_SET.getInt() == 0)
        	{
        		throw new WrongUsageException("mpg.commands.notActive", new Object[0]);
        	}else if(MPGuardMain.conf.cfgComPerm_SET.getInt() == 2 && !senderOp)
        	{
        		throw new WrongUsageException("mpg.commands.noPermission", new Object[0]);
        	}
        }else if("list".equalsIgnoreCase(var2[0]))
        {
        	if(MPGuardMain.conf.cfgComPerm_LIST.getInt() == 0)
        	{
        		throw new WrongUsageException("mpg.commands.notActive", new Object[0]);
        	}else if(MPGuardMain.conf.cfgComPerm_LIST.getInt() == 2 && !senderOp)
        	{
        		throw new WrongUsageException("mpg.commands.noPermission", new Object[0]);
        	}
        }


		EntityPlayerMP entityplayermp;

        if("list".equalsIgnoreCase(var2[0]))
        {
        	if(var2.length >= 2)
        	{
                entityplayermp = getPlayer(var1, var2[1]);

    	        if (entityplayermp == null)
    	        {
    	            throw new PlayerNotFoundException();
    	        }

    	        int mpValue = MCEconomyAPI.getPlayerMP(entityplayermp);
    	        sender.addChatMessage(new ChatComponentTranslation("mpg.commands.result.list",new Object[] {entityplayermp.getDisplayName(), mpValue}));
        	}else
        	{
        		String[] players = MinecraftServer.getServer().getAllUsernames();

        		for(int cnt = 0; cnt < players.length; cnt++)
        		{
        			entityplayermp = getPlayer(var1, players[cnt]);
        			if(entityplayermp != null)
        			{
            	        int mpValue = MCEconomyAPI.getPlayerMP(entityplayermp);
            	        sender.addChatMessage(new ChatComponentTranslation("mpg.commands.result.list",new Object[] {entityplayermp.getDisplayName(), mpValue}));
        			}
        		}
        	}
        }else
        {
            entityplayermp = getPlayer(var1, var2[1]);

	        if (entityplayermp == null)
	        {
	            throw new PlayerNotFoundException();
	        }

	        int mpValue = 0;

	        if(NumberUtils.isNumber(var2[2]))
	        {
	        	mpValue = Integer.parseInt(var2[2]);
	        }else
	        {
	        	throw new WrongUsageException("mpg.commands.missInteger", new Object[0]);
	        }

	        if("send".equalsIgnoreCase(var2[0]))
	        {
	        	//他プレーヤーへMPを渡す
	        	if(MCEconomyAPI.getPlayerMP(sender) >= mpValue)
	        	{
	        		MCEconomyAPI.reducePlayerMP(sender, mpValue, false);
	            	MCEconomyAPI.addPlayerMP(entityplayermp, mpValue, false);
	            	sender.addChatMessage(new ChatComponentTranslation("mpg.commands.result.sendMP",new Object[] {entityplayermp.getDisplayName(), mpValue}));
	            	entityplayermp.addChatMessage(new ChatComponentTranslation("mpg.commands.result.getMP",new Object[] {entityplayermp.getDisplayName(), mpValue}));
	        	}else
	        	{
	        		throw new WrongUsageException("mpg.commands.lowmp", new Object[0]);
	        	}
	        }else if("add".equalsIgnoreCase(var2[0]))
	        {
	        	MCEconomyAPI.addPlayerMP(entityplayermp, mpValue, false);
	        	entityplayermp.addChatMessage(new ChatComponentTranslation("mpg.commands.result.addMP",new Object[] {mpValue}));
	        }else if("remove".equalsIgnoreCase(var2[0]))
	        {
	        	MCEconomyAPI.reducePlayerMP(entityplayermp, mpValue, false);
	        	entityplayermp.addChatMessage(new ChatComponentTranslation("mpg.commands.result.reduceMP",new Object[] {mpValue}));
	        }else if("set".equalsIgnoreCase(var2[0]))
	        {
	        	MCEconomyAPI.setPlayerMP(entityplayermp, mpValue);
	        	entityplayermp.addChatMessage(new ChatComponentTranslation("mpg.commands.result.setMP",new Object[] {mpValue}));
	        }
        }
        */
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return "mpg.commands.mpg.usage";
	}

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
    	//System.out.println("test2" + p_71516_2_.length);
    	if(p_71516_2_.length == 1)
    	{
    		 return getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"send", "add", "remove", "set", "list"});
    	}else if(p_71516_2_.length == 2)
    	{
    		return getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer.getServer().getAllUsernames());
    	}

    	return null;
    }
}
