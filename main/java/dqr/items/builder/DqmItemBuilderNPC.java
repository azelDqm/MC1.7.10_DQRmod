package dqr.items.builder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.addons.mceconomy2.DqrEntityNPCBankMP;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmBuilder;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.npcEntity.npc.DqmEntityNPCKaitoriya;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan2;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan3;
import dqr.entity.npcEntity.npc.DqmEntityNPCSyuuri;
import dqr.items.base.DqmItemBuilderBase;

public class DqmItemBuilderNPC extends DqmItemBuilderBase{

	public DqmItemBuilderNPC(EnumDqmBuilder par1)
	{
		super(par1);
	}

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {

		if(!par3World.isRemote)
		{
			DqmNPCBase newEntity = null;
			//int weaponShopFlg = 0;
			if(this == DQBuilders.itemBuilderShopBukiyaW)
			{
				newEntity = new DqmEntityNPCBukiya(par3World);
			}else if(this == DQBuilders.itemBuilderShopBankW)
			{
				newEntity = new DqmEntityNPCBank(par3World);
			}else if(this == DQBuilders.itemBuilderShopKaitoriyaW)
			{
				newEntity = new DqmEntityNPCKaitoriya(par3World);
			}else if(this == DQBuilders.itemBuilderShopSyuuriyaW)
			{
				newEntity = new DqmEntityNPCSyuuri(par3World);
			}else if(this == DQBuilders.itemBuilderDamaTW)
			{
				newEntity = new DqmEntityNPCSinkan(par3World);
			}else if(this == DQBuilders.itemBuilderDamaSW)
			{
				newEntity = new DqmEntityNPCSinkan2(par3World);
			}else if(this == DQBuilders.itemBuilderDamaWW)
			{
				newEntity = new DqmEntityNPCSinkan3(par3World);
			}else if(this == DQBuilders.itemBuilderShopBukiyaW3)
			{
				newEntity = new DqmEntityNPCBukiya(par3World);
				newEntity = new DqmEntityNPCBukiya(par3World, 3);
				//weaponShopFlg = 3;
			}else if(this == DQBuilders.itemBuilderShopBukiyaW4)
			{
				newEntity = new DqmEntityNPCBukiya(par3World);
				newEntity = new DqmEntityNPCBukiya(par3World, 4);
				//weaponShopFlg = 4;
			}else if(this == DQBuilders.itemBuilderShopBukiyaW5)
			{
				newEntity = new DqmEntityNPCBukiya(par3World);
				newEntity = new DqmEntityNPCBukiya(par3World, 5);
				//weaponShopFlg = 5;
			}else if(this == DQBuilders.itemBuilderShopBukiyaW6)
			{
				newEntity = new DqmEntityNPCBukiya(par3World);
				newEntity = new DqmEntityNPCBukiya(par3World, 6);
				//weaponShopFlg = 6;
			}else if(DQR.addons.mce2IsEnable == 1)
			{
				if(this == DQR.addons.itemBuilderShopBankMPW)
				{
					newEntity = new DqrEntityNPCBankMP(par3World);
				}
			}


			if(newEntity != null)
			{
				newEntity.setTameMode(1);
				newEntity.setOwnerName2(par2EntityPlayer.getCommandSenderName());
				newEntity.setOwnerUUID2(par2EntityPlayer.getUniqueID().toString());
				newEntity.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.5D, (double)par6 + 0.5D, 0.0F, 0.0F);
				/*
				if(weaponShopFlg != 0)
				{
					((DqmEntityNPCBukiya)newEntity).setShopGrade(weaponShopFlg);
				}
				*/
	        	par3World.spawnEntityInWorld(newEntity);
	        	par1ItemStack.stackSize--;
			}
    	}

    	return true;
    }
}
