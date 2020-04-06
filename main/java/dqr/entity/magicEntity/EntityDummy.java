package dqr.entity.magicEntity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;

public class EntityDummy extends EntityLiving{

	public int lifeTime = 0;
	public int experienceValue = 0;
	public EntityDummy(World p_i1582_1_) {
		super(p_i1582_1_);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		DQR.func.debugString("生きてる！");
		if(lifeTime < 200)
		{
			lifeTime++;
		}else
		{
			this.kill();
		}
	}

	@Override
	public ItemStack getHeldItem() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setDead()
	{
		DQR.func.debugString("消える！");
		super.setDead();
	}

	@Override
	public ItemStack getEquipmentInSlot(int p_71124_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public ItemStack[] getLastActiveItems() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.lifeTime = p_70037_1_.getInteger("LifeTime");
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
    	super.writeEntityToNBT(p_70014_1_);
    	p_70014_1_.setInteger("LifeTime", this.lifeTime);
    }
}
