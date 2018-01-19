package dqr.items.builder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmBuilder;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.entity.npcEntity.npc.DqmEntityNPCKajinoBJ;
import dqr.entity.npcEntity.npc.DqmEntityNPCKajinoCCR;
import dqr.entity.npcEntity.npc.DqmEntityNPCKajinoCoin;
import dqr.entity.npcEntity.npc.DqmEntityNPCKajinoEXC;
import dqr.entity.npcEntity.npc.DqmEntityNPCKajinoPK;
import dqr.items.base.DqmItemBuilderBase;

public class DqmItemBuilderCasino extends DqmItemBuilderBase{

	public DqmItemBuilderCasino(EnumDqmBuilder par1)
	{
		super(par1);
	}

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {

		if(!par3World.isRemote)
		{
			DqmNPCBase newEntity = null;

			if(this == DQBuilders.itemBuilderCasino1)
			{
				newEntity = new DqmEntityNPCKajinoBJ(par3World);
			}else if(this == DQBuilders.itemBuilderCasino2)
			{
				newEntity = new DqmEntityNPCKajinoCoin(par3World);
			}else if(this == DQBuilders.itemBuilderCasino3)
			{
				newEntity = new DqmEntityNPCKajinoPK(par3World);
			}else if(this == DQBuilders.itemBuilderCasino4)
			{
				newEntity = new DqmEntityNPCKajinoEXC(par3World);
			}else if(this == DQBuilders.itemBuilderCasino5)
			{
				newEntity = new DqmEntityNPCKajinoCCR(par3World);
			}

			if(newEntity != null)
			{
				newEntity.setTameMode(1);
				newEntity.setOwnerName2(par2EntityPlayer.getCommandSenderName());
				newEntity.setOwnerUUID2(par2EntityPlayer.getUniqueID().toString());
				newEntity.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.5D, (double)par6 + 0.5D, 0.0F, 0.0F);
	        	par3World.spawnEntityInWorld(newEntity);
	        	par1ItemStack.stackSize--;
			}
    	}

    	return true;
    }
}
