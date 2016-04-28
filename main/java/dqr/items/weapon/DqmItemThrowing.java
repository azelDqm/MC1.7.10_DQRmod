package dqr.items.weapon;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.Items.DQWeapons;
import dqr.entity.throwingEntity.throwing.ThrowingEntity;
import dqr.entity.throwingEntity.throwing.ThrowingEntityBumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHaipanova;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHaipanova2;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHonoonobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityIgurufeza;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKazenobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKoorinobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKuresentoejji;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKurosubumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityMeteoejji;
import dqr.entity.throwingEntity.throwing.ThrowingEntityYaibanobumeran;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemThrowing extends DqmItemWeaponBase{

	public DqmItemThrowing(ToolMaterial p_i45356_1_, float attackDam,
			int maxDamage) {
		super(p_i45356_1_, attackDam, maxDamage);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

    	if(par1ItemStack.getMaxDamage() / 10 * 9 > par1ItemStack.getItemDamage())
	    {
	    	ThrowingEntity bumeran = null;
	    	if(this == DQWeapons.itemBumeran)
	    	{
	    		bumeran = new ThrowingEntityBumeran(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(3);
	    	}else if(this == DQWeapons.itemYaibanobumeran)
	    	{
	    		bumeran = new ThrowingEntityYaibanobumeran(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(4);
	    	}else if(this == DQWeapons.itemKurosubumeran)
	    	{
	    		bumeran = new ThrowingEntityKurosubumeran(par2World, par3EntityPlayer, 1.0F, .0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(4);
	    	}else if(this == DQWeapons.itemIgurufeza)
	    	{
	    		bumeran = new ThrowingEntityIgurufeza(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(5);
	    	}else if(this == DQWeapons.itemKazenobumeran)
	    	{
	    		bumeran = new ThrowingEntityKazenobumeran(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(5);
	    	}else if(this == DQWeapons.itemHonoonobumeran)
	    	{
	    		bumeran = new ThrowingEntityHonoonobumeran(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(6);
	    	}else if(this == DQWeapons.itemKoorinobumeran)
	    	{
	    		bumeran = new ThrowingEntityKoorinobumeran(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(6);
	    	}else if(this == DQWeapons.itemKuresentoejji)
	    	{
	    		bumeran = new ThrowingEntityKuresentoejji(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(7);
	    	}else if(this == DQWeapons.itemMeteoejji)
	    	{
	    		bumeran = new ThrowingEntityMeteoejji(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(7);
	    	}else if(this == DQWeapons.itemHaipanova)
	    	{
	    		bumeran = new ThrowingEntityHaipanova(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(8);
	    	}else if(this == DQWeapons.itemHaipanova2)
	    	{
	    		bumeran = new ThrowingEntityHaipanova2(par2World, par3EntityPlayer, 1.0F, 1.0F, 0.0F, 0.0F, -0.5F);
	    		bumeran.setMaxTicksRange(9);
	    	}

			if(bumeran != null)
			{
				par1ItemStack.damageItem(1, par3EntityPlayer);
				bumeran.setDamage(ExtendedPlayerProperties.get(par3EntityPlayer).getKougeki());
				//bumeran.setDamage(500);
				bumeran.setShootingPlayer(par3EntityPlayer);
				bumeran.setThisItem(ItemStack.copyItemStack(par1ItemStack));

	        	if (!par2World.isRemote)
	        	{
	        		par2World.spawnEntityInWorld(bumeran);

	        	}

	        	par1ItemStack.stackSize--;
			}
	    	}

		return par1ItemStack;
    	//return new ItemStack(Blocks.air, 1);
    }

    @Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    	 p_77624_3_.add(I18n.format("dqm.iteminfo.throw", new Object[]{}));
    }
}
