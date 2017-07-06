package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
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

public class DqmItemMagicRuraC extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicRuraC(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

    }


    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

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
	    				if(DQR.conf.RuraC_IGF == 2 || (DQR.conf.RuraC_IGF == 1 && flg))
	    				{
	    					DQR.conf.setRuraCoordinates(this.getEnumMagic(), (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ, par3EntityPlayer.dimension);
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
	        				int ruraMode = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_RURA.getId());

			    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
			    			{
			    				int setX = DQR.conf.RuraC_X[this.getEnumMagic().getType()];
			    				int setY = DQR.conf.RuraC_Y[this.getEnumMagic().getType()];
			    				int setZ = DQR.conf.RuraC_Z[this.getEnumMagic().getType()];
			    				int setDim = DQR.conf.RuraC_Dim[this.getEnumMagic().getType()];

			    				Random rand_jukuren = new Random();
								if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
								{

									int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
									ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
								}

	    		    	        if(setX == 0 && setY == 0 && setZ == 0 && setDim == 0)
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

    	PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.SyncCRura));

    	int setDim = (int)ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraDim(this.getEnumMagic().getType());
        double setX = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraX(this.getEnumMagic().getType()));
        double setY = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraY(this.getEnumMagic().getType()));
        double setZ = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getC_RuraZ(this.getEnumMagic().getType()));

        if(setDim != 0 || setX != 0 || setY != 0 || setZ != 0)
        {
        	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.kimeraLoc.1.txt", new Object[]{setDim, setX, setY, setZ}));
        }

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.ruraC.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}

    	message = I18n.format("dqm.magicinfo.rura_all.txt", new Object[]{});
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);
    }
}
