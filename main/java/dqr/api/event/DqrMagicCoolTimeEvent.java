package dqr.api.event;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import dqr.api.enums.EnumDqmMagic;


public class DqrMagicCoolTimeEvent extends Event{

	public ItemStack itemStack;
	public World world;
	public Entity entity;
	public int slotIndex;
	public boolean isCurrentSlot;
	public EnumDqmMagic enumMagic;

	public DqrMagicCoolTimeEvent(ItemStack var1, World var2, Entity var3, int par4, boolean par5, EnumDqmMagic enumMagic)
	{
		this.itemStack = var1;
		this.world = var2;
		this.entity = var3;
		this.slotIndex = par4;
		this.isCurrentSlot = par5;
		this.enumMagic = enumMagic;

	}

	@Cancelable
	public static class preCoolTimeDecrease extends DqrMagicCoolTimeEvent
	{
		public preCoolTimeDecrease(ItemStack var1, World var2, Entity var3, int par4, boolean par5, EnumDqmMagic enumMagic)
		{
			super(var1, var2, var3, par4, par5, enumMagic);
		}
	}

	public static class calcCoolTimeDecrease extends DqrMagicCoolTimeEvent
	{
		public int fixDamage = 0;
		public calcCoolTimeDecrease(ItemStack var1, World var2, Entity var3, int par4, boolean par5, EnumDqmMagic enumMagic, int fixDamage)
		{
			super(var1, var2, var3, par4, par5, enumMagic);
			this.fixDamage = fixDamage;
		}

		public int getFixDamage()
		{
			return fixDamage;
		}

		public void setFixDamage(int par1)
		{
			fixDamage = par1;
		}
	}

	public static class postCoolTimeDecrease extends DqrMagicCoolTimeEvent
	{
		public int fixDamage = 0;
		public int lastDamage = 0;
		public postCoolTimeDecrease(ItemStack var1, World var2, Entity var3, int par4, boolean par5, EnumDqmMagic enumMagic, int fixDamage, int lastDamage)
		{
			super(var1, var2, var3, par4, par5, enumMagic);
			this.fixDamage = fixDamage;
			this.lastDamage = lastDamage;

		}
	}
}
