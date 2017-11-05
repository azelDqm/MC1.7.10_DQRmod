package dqr.entity.npcEntity;

import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public abstract class DqmNPCBase extends EntityTameable
{

	//public static DqmKey dk;
    public static EntityPlayer ep;
    public int attackStrength;
    protected int experienceValue;
    private float field_25048_b;
    private float field_25054_c;
    private boolean field_25052_g;
    private float field_70926_e;
    private float field_70924_f;
    private boolean isShaking;
    private boolean field_70928_h;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    private int de1;
    public int xxxx;

    /*TameMode 0:標準 1:雇用書*/
    public int tameMode = 0;

    public float moveSpeed;

    public DqmNPCBase(World p_i1604_1_) {
		super(p_i1604_1_);
		// TODO 自動生成されたコンストラクター・スタブ
		WorldProvider test = WorldProvider.getProviderForDimension(0);


	}

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("TameMode", tameMode);
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
    	super.readEntityFromNBT(p_70037_1_);
    	tameMode = p_70037_1_.getInteger("TameMode");
    }

    public void setTameMode(int par1)
    {
    	this.tameMode = par1;
    }

    public int getTameMode()
    {
    	return this.tameMode;
    }
}
