package dqr.entity.npcEntity.npc;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmEntityNPCSinkan3 extends DqmNPCBase
{
    private int HP = 9999; //********

    private int PW = 100; //********
    private int DF = 100; //********
    private float SP = 0.0F; //********
    private String Name = "スティーブ";//********
    private String NameE = "Sinkan";//********
    private boolean Fire = true;//******** true false
    protected void fall(float par1) {} //********
    @Override
    public void setDead()
    {
        super.setDead();
    }
    @Override
    public void onLivingUpdate()
    {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);

        /*
        if (this.worldObj.getBlockId(var1, var2 - 1, var3) == DqmItemList.Shoumetu.blockID)
        {
            this.setDead();
        }
		*/
        super.onLivingUpdate();
    }
    @Override
    public boolean getCanSpawnHere()
    {
        int i;
        int j;
        int k;
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return super.getCanSpawnHere() && !(isValidLightLevel());

    }
    protected boolean isValidLightLevel()
    {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, var1, var2, var3) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int var4 = this.worldObj.getBlockLightValue(var1, var2, var3);

            if (this.worldObj.isThundering())
            {
                int var5 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 2;
                var4 = this.worldObj.getBlockLightValue(var1, var2, var3);
                this.worldObj.skylightSubtracted = var5;
            }

            return var4 <= this.rand.nextInt(8);
        }
    }

    @Override
    protected boolean canDespawn()
    {

    	return false;
    }

    public DqmEntityNPCSinkan3(World par1World)
    {
        super(par1World);
        setSize(0.8F, 1.5F);
        moveSpeed = SP;
        experienceValue = 0;
        isImmuneToFire = Fire;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);

        this.tasks.addTask(5, new EntityAIFollowOwner(this, this.moveSpeed, 3.0F, 2.0F));

        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;



    @Override	public int getTotalArmorValue()
    {
        return DF;
    }

    @Override	public boolean isAIEnabled()
    {
        return true;
    }
    @Override	public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    @Override
    public boolean interact(EntityPlayer ep)
    {


		int talkNo = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.SINKAN3.getId());

		//ep.addChatMessage(new ChatComponentTranslation("" + talkNo));
		if(talkNo < 10)
		{
			if(!ep.worldObj.isRemote)
			{
				ep.addChatMessage(new ChatComponentTranslation("msg.Dama3.messages." + talkNo + ".txt" ,new Object[] {}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
			}

			if(talkNo < 8)
			{
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN3.getId(), talkNo + 1);
			}else
			{
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN3.getId(), 30);
			}

			return true;
		}else if(talkNo < 30)
		{
			if(!ep.worldObj.isRemote)
			{
				ep.addChatMessage(new ChatComponentTranslation("msg.Dama3.messages." + talkNo + ".txt" ,new Object[] {}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
			}

			if(talkNo < 11)
			{
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN3.getId(), talkNo + 1);
			}else
			{
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN3.getId(), 30);
			}

			return true;
		}

		if(ep.inventory.getCurrentItem() != null && (ep.inventory.getCurrentItem().getItem() instanceof DqmItemWeaponBase ||
													 ep.inventory.getCurrentItem().getItem() instanceof DqmItemBowBase))
		{

			ep.openGui(DQR.instance, DQR.conf.GuiID_SkillWeapon, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
			if(ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
			ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN3.getId(), 10);
		}


    	return true;
    }
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    public boolean canDespawn_CB()
    {
        return false;
    }
}
