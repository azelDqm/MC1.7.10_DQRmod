package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.event.DqrRuraEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.petEntity.DqmPetBase;
import dqr.items.base.DqmItemMagicBase;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemMagicRuraSinC extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicRuraSinC(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

    }


    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(DQR.conf.enableRuraSinC == 0)
		{
			return par1ItemStack;
		}

		PotionEffect pe;
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

    		if(par3EntityPlayer.isSneaking())
	    	{
    			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
    			{
    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    			}else
    			{
	    			if(!par2World.isRemote)
	    			{
	    				boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(par3EntityPlayer.getGameProfile());
	    				int select = ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinSelectX(this);
	    				if(select == 9)
	    				{
	    					par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraMissSlot.txt",new Object[] {}));
	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    				}else
	    				{
		    				if(DQR.conf.RuraSinC_IGF == 2 || (DQR.conf.RuraSinC_IGF == 1 && flg))
		    				{
		    					DQR.conf.setRuraSinCoordinates(select, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ, par3EntityPlayer.dimension);
		    	    	        par3EntityPlayer.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.kimeraLoc.2.txt",new Object[] {par3EntityPlayer.dimension,
		    	    	        		Math.floor(par3EntityPlayer.posX),
		    	    	        		Math.floor(par3EntityPlayer.posY),
		    	    	        		Math.floor(par3EntityPlayer.posZ)}));
		    					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mira", 0.9F, 0.9F);
		    				}else
		    				{
		        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPerm.txt",new Object[] {}));
		        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
		    				}
	    				}
	    			}

    			}
	    	}else
	    	{
	        	if(par1ItemStack.getItemDamage() == 0 || DQR.debug > 0)
	        	{
	    			if(!par2World.isRemote)
	    			{
	        			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
	        			{
	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	        			}else
	        			{
	        				int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();
	        				int ruraMode = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_RURASINMODE.getId());
	        				int select = ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinSelectX(this);

			    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
			    			{
			    				int setX = 0;
			    				int setY = 0;
			    				int setZ = 0;
			    				int setDim = 0;
			    				int setEnable = 0;

			    				if(select != 9)
			    				{
				    				setX = DQR.conf.RuraSinC_X[select];
				    				setY = DQR.conf.RuraSinC_Y[select];
				    				setZ = DQR.conf.RuraSinC_Z[select];
				    				setDim = DQR.conf.RuraSinC_Dim[select];
				    				setEnable = (setX != 0 || setY != 0 || setZ != 0|| setDim != 0) ? 1 : 0;
				    				System.out.println("TEST : " + DQR.conf.RuraSinC_X[select] + " / " + DQR.conf.RuraSinC_Z[select]);
			    				}else
			    				{
	        		    	        setX = (int)Math.floor(ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinX(9));
	        		    	        setY = (int)Math.floor(ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinY(9));
	        		    	        setZ = (int)Math.floor(ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinZ(9));
	        		    	        setDim = ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinDim(9);
	        		    	        setEnable = ExtendedPlayerProperties.get(par3EntityPlayer).getRuraSinEnable(9);
			    				}

			    				Random rand_jukuren = new Random();
								if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
								{

									int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
									ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
								}

	    		    	        if(setEnable == 0)
	    		    	        {
	    	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos0.txt",new Object[] {}));
	    	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos1.txt",new Object[] {}));
	    	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    	        				return par1ItemStack;
	    		    	        }else if(setDim != par3EntityPlayer.dimension)
	    		    	        {
	    	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoDim.txt",new Object[] {}));
	    	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    	        				return par1ItemStack;
	    		    	        }

	    		    	        ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
	    						//最後にルーラした場所登録
	    						ExtendedPlayerProperties.get(par3EntityPlayer).setRuraSin(9, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, par3EntityPlayer.dimension, 1);

	    		    	        if(ruraMode != EnumDqmMGToolMode.RURAMODE0.getId())
	    		    	        {
		    		    	        //まずはペットを飛ばす
		    		                List list = par3EntityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
		    		                		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

		    		                if (list != null && !list.isEmpty())
		    		                {
		    		                	for (int n = 0 ; n < list.size() ; n++)
		    		                	{
		    		                		Entity target = (Entity)list.get(n);

		    		                		if (target != null)
		    		                		{
		    		                			//boolean petFlg = false;
		    		                			String epUuid = par3EntityPlayer.getUniqueID().toString();

		    		                			if(target instanceof EntityHorse)
		    		                			{
		    		                				EntityHorse horse = (EntityHorse)target;

		    		                				if(epUuid.equalsIgnoreCase(horse.func_152119_ch()))
		    		                				{
		    		                					horse.setPositionAndUpdate(setX, setY + 0.5D, setZ);
		    		                					//petFlg = true;
		    		                				}

		    		                			}else if(target instanceof EntityTameable)
			                					{
		    		                				EntityTameable tame = (EntityTameable)target;
		    		                				EntityLivingBase tameE = tame.getOwner();

		    		                				if(tameE != null)
		    		                				{
		    		                					String tameUuid = tameE.getUniqueID().toString();

			    		                				if(epUuid.equalsIgnoreCase(tameUuid))
			    		                				{
			    		                					tame.setPositionAndUpdate(setX, setY + 0.5D, setZ);
			    		                					//petFlg = true;
			    		                				}
		    		                				}

			                					}else if(target instanceof DqmPetBase)
			                					{
			                						DqmPetBase petMob = (DqmPetBase)target;
		    		                				EntityLivingBase petMobE = petMob.getOwner();

		    		                				if(petMobE != null)
		    		                				{
		    		                					String tameUuid = petMobE.getUniqueID().toString();

			    		                				if(epUuid.equalsIgnoreCase(tameUuid))
			    		                				{
			    		                					petMob.setPositionAndUpdate(setX, setY + 0.5D, setZ);
			    		                					//petFlg = true;
			    		                				}
		    		                				}
			                					}

					    						//外部からの干渉用
			    		                		DqrRuraEvent event = new DqrRuraEvent(par3EntityPlayer,
					    															  target,
			    		                											  par1ItemStack,
					    															  setX, setY, setZ);
			    		                		MinecraftForge.EVENT_BUS.post(event);
		    		                		}
		    		                	}
		    		                }
	    		    	        }

	    		    	        par3EntityPlayer.setPositionAndUpdate(setX, setY + 0.5D, setZ);
    		    	        	par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.rura", 1.0F, 1.0F);


			    			}else
			    			{
			    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
			    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
			    			}
	        			}

	    			}
	        	}else
	        	{
	        		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
	        		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	        	}
	    	}

        return par1ItemStack;
    }


    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	GameSettings settings = Minecraft.getMinecraft().gameSettings;
    	if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg == false && settings.isKeyDown(settings.keyBindSneak))
    	{
    		ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg = true;
    	}else if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg == true && !settings.isKeyDown(settings.keyBindSneak))
    	{
    		ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg = false;
    		ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortRuraSin = !ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortRuraSin;
    	}

    	PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.SyncCRuraSin));
    	int select = ExtendedPlayerProperties.get(p_77624_2_).getRuraSinSelectX(this);

    	String sneakKey = GameSettings.getKeyDisplayString(settings.keyBindSneak.getKeyCode());

    	if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortRuraSin)
    	{
    		p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLocHid.txt", new Object[]{sneakKey}));
    		//p_77624_3_.add("できたよ！！！");
    	}else
    	{
    		for(int cnt = 0;cnt < 9; cnt++)
    		{
    	    	int setDim = (int)ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraSinDim(cnt);
    	        double setX = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraSinX(cnt));
    	        double setY = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraSinY(cnt));
    	        double setZ = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraSinZ(cnt));
    	        String posName = ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraSinName(cnt);

	        	if(setDim != 0 || setX != 0 || setY != 0 || setZ != 0)
	        	{
	        		p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLoc2.txt", new Object[]{posName, setDim, setX, setY, setZ}));
	        	}else
	        	{
	        		p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinNoLoc.txt", new Object[]{posName}));
	        	}
    		}


    		/*
        	if(ExtendedPlayerProperties3.get(p_77624_2_).getW_RuraSinEnable(9) != 0)
        	{
    	    	int setDim = (int)ExtendedPlayerProperties3.get(p_77624_2_).getW_RuraSinDim(9);
    	        double setX = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_RuraSinX(9));
    	        double setY = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_RuraSinY(9));
    	        double setZ = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_RuraSinZ(9));
    	    	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLastLoc.txt", new Object[]{setDim, setX, setY, setZ}));
        	}else
        	{
        		p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLastNoLoc.txt", new Object[]{}));
        	}
        	*/

    		if(ExtendedPlayerProperties.get(p_77624_2_).getRuraSinEnable(9) != 0)
        	{
    	    	int setDim = (int)ExtendedPlayerProperties.get(p_77624_2_).getRuraSinDim(9);
    	        double setX = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getRuraSinX(9));
    	        double setY = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getRuraSinY(9));
    	        double setZ = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getRuraSinZ(9));
    	    	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLastLoc.txt", new Object[]{setDim, setX, setY, setZ}));
        	}else
        	{
        		p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLastNoLoc.txt", new Object[]{}));
        	}

        	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.RurasinLocVis.txt", new Object[]{sneakKey}));
    	}
    	/*
    	int setDim = (int)ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraDim(xxxxx.getType());
        double setX = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraX(xxxxx.getType()));
        double setY = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraY(xxxxx.getType()));
        double setZ = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraZ(xxxxx.getType()));

        if(setDim != 0 || setX != 0 || setY != 0 || setZ != 0)
        {
        	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.kimeraLoc.1.txt", new Object[]{setDim, setX, setY, setZ}));
        }
        */

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.ruraC.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}

    	message = I18n.format("dqm.magicinfo.rura_all.txt", new Object[]{});
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);

    	message = I18n.format("dqm.magicinfo.rura_sin.txt", new Object[]{});
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);
    }
}
