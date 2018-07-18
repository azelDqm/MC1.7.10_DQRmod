package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.DqrWorldData;
import dqr.PacketHandler;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.event.DqrRuraEvent;
import dqr.items.base.DqmItemMiscBase;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemKimera extends DqmItemMiscBase{

	public DqmItemKimera(EnumDqmMagic par1)
	{
		super(par1);
	}

	@Override
   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(DQR.conf.enableKimera == 0)
		{
			return par1ItemStack;
		}

		if(par3EntityPlayer.isSneaking())
    	{
			if(!par2World.isRemote)
			{
				boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(par3EntityPlayer.getGameProfile());
				if(DQR.conf.Kimera_CordSet == 2 || (DQR.conf.Kimera_CordSet == 1 && flg))
				{
	    			DqrWorldData wd = (DqrWorldData)par2World.loadItemData(DqrWorldData.class, DQR.modID);

	    	        if (wd == null)
	    	        {
	    	        	wd = new DqrWorldData(DQR.modID);
	    	        }

	    	        wd.setKimera(this.getEnumMagic().getType(), par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, par3EntityPlayer.dimension, 1);
	    	        DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("dqm.iteminfo.kimeraLoc.2.txt",new Object[] {par3EntityPlayer.dimension,
	    	        		Math.floor(par3EntityPlayer.posX),
	    	        		Math.floor(par3EntityPlayer.posY),
	    	        		Math.floor(par3EntityPlayer.posZ)}));

	    	        wd.markDirty();
	    	        par2World.setItemData(DQR.modID, wd);
				}else
				{
    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.ruraNoPerm.txt",new Object[] {}));
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				}
			}

	        par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mira", 0.9F, 0.9F);
    	}else
    	{

			if(!par2World.isRemote)
			{

				DqrWorldData wd = (DqrWorldData)par2World.loadItemData(DqrWorldData.class, DQR.modID);

    	        if (wd == null)
    	        {
    	        	wd = new DqrWorldData(DQR.modID);
    	        }

    	        if(wd.getKimeraEnable(this.getEnumMagic().getType()) == 0)
    	        {
    	        	if(!par2World.isRemote)
    	        	{
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rurabNoPos0.txt",new Object[] {}));
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.ruraNoPos1.txt",new Object[] {}));
    	        	}
    	        	par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    				return par1ItemStack;
    	        }else if(wd.getKimeraDim(this.getEnumMagic().getType()) != par3EntityPlayer.dimension)
    	        {
    	        	if(!par2World.isRemote)
    	        	{
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.ruraNoDim.txt",new Object[] {}));
    	        	}
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	        	return par1ItemStack;
    	        }

    	        /*
    	        double setX = Math.floor(wd.getRuraX(this.getEnumMagic().getType()) - par3EntityPlayer.posX);
    	        double setY = Math.floor(wd.getRuraY(this.getEnumMagic().getType()) - par3EntityPlayer.posY);
    	        double setZ = Math.floor(wd.getRuraZ(this.getEnumMagic().getType()) - par3EntityPlayer.posZ);;
    	        */
    	        double setX = Math.floor(wd.getKimeraX(this.getEnumMagic().getType()));
    	        double setY = Math.floor(wd.getKimeraY(this.getEnumMagic().getType()));
    	        double setZ = Math.floor(wd.getKimeraZ(this.getEnumMagic().getType()));

    	        int ruraMode = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_KIMERA.getId());
	        	//par3EntityPlayer.setPosition(Math.floor(wd.getRuraX(this.getEnumMagic().getType())), Math.floor(wd.getRuraY(this.getEnumMagic().getType())), Math.floor(wd.getRuraZ(this.getEnumMagic().getType())));
    	        //par3EntityPlayer.moveEntity(0, 2, 0);
    	        //System.out.println(setX + "/" + setY + "/" + setZ);
    	        //par3EntityPlayer.moveEntity(setX, setY, setZ);


    	        if(ruraMode != EnumDqmMGToolMode.RURAMODE0.getId())
    	        {
    	        //まずはペットを飛ばす(キメラの翼の場合は飛ばさない)
	                List list = par3EntityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
	                		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

	                if (list != null && !list.isEmpty())
	                {
	                	for (int n = 0 ; n < list.size() ; n++)
	                	{
	                		Entity target = (Entity)list.get(n);

	                		if (target != null)
	                		{
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

	        	par1ItemStack.stackSize--;
			}
    	}

        return par1ItemStack;
    }


    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.SyncWKimera));

    	if(ExtendedPlayerProperties3.get(p_77624_2_).getW_KimeraEnable(this.getEnumMagic().getType()) != 0)
    	{
	    	int setDim = (int)ExtendedPlayerProperties3.get(p_77624_2_).getW_KimeraDim(this.getEnumMagic().getType());
	        double setX = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_KimeraX(this.getEnumMagic().getType()));
	        double setY = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_KimeraY(this.getEnumMagic().getType()));
	        double setZ = Math.floor(ExtendedPlayerProperties3.get(p_77624_2_).getW_KimeraZ(this.getEnumMagic().getType()));
	    	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.kimeraLoc.1.txt", new Object[]{setDim, setX, setY, setZ}));
    	}

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.iteminfo.kimera.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}

    	p_77624_3_.add("");

    	message = I18n.format("dqm.magicinfo.rura_all.txt", new Object[]{});
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);

    }
}
