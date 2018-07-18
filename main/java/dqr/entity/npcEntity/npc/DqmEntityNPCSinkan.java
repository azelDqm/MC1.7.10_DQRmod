package dqr.entity.npcEntity.npc;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.items.base.DqmItemEmblemBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmEntityNPCSinkan extends DqmNPCBase
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

    public DqmEntityNPCSinkan(World par1World)
    {
        super(par1World);
        setSize(0.8F, 1.5F);
        moveSpeed = SP;
        experienceValue = 0;
        isImmuneToFire = Fire;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        //this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        //this.tasks.addTask(4, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, this.moveSpeed, 3.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, this.moveSpeed));
        //	this.tasks.addTask(7, new EntityAIWander(this, this.moveSpeed));
        //this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

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
    	//ep.openGui(DQR.instance, DQR.conf.GuiID_JobChange, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
		if(!ep.worldObj.isRemote)
		{
    		ItemStack its = ep.inventory.getCurrentItem();
    		if(its != null && its.getItem() == DQBuilders.itemBuilderKaikosyo && ep.isSneaking())
    		{
    			int confVal = DQR.conf.permBuilder5;
    			if(confVal != 0)
    			{
	    			//  && this.tameMode != 0
	    			boolean opFlg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());

	    			if((confVal == 3) ||
	    			   (confVal == 1 && opFlg) ||
	    			   (confVal == 2 && (opFlg || ep.getUniqueID().toString().equalsIgnoreCase(this.getOwnerUUID2()))))
	    			{
		    			ep.worldObj.playSoundAtEntity(ep, "dqr:mob.petmob", 1.0F, 0.5F);
		    			this.setDead();
		    			return true;
	    			}
    			}
    		}

			int tabidachi = ExtendedPlayerProperties.get(ep).getTabidachiFlg();
			if(tabidachi >= 100)
			{
				int jobNo = -1;
				switch(tabidachi)
				{
					case 100: jobNo = EnumDqmJob.Asobinin.getId(); break;
					case 101: jobNo = EnumDqmJob.Senshi.getId(); break;
					case 102: jobNo = EnumDqmJob.Budouka.getId(); break;
					case 103: jobNo = EnumDqmJob.Souryo.getId(); break;
					case 104: jobNo = EnumDqmJob.Mahoutukai.getId(); break;
					case 105: jobNo = EnumDqmJob.Syounin.getId(); break;
					case 106: jobNo = EnumDqmJob.Touzoku.getId(); break;
				}

				if(jobNo > -1)
				{
					ExtendedPlayerProperties3.get(ep).setJobPermission(jobNo, 1);
				}
			}

	    	//if(!ep.worldObj.isRemote)
	    	//{
			int talkNo = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.SINKAN.getId());

			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("" + talkNo));
			if(talkNo < 10)
			{
				if(!ep.worldObj.isRemote)
				{
					DQR.func.debugString("Line1",this.getClass());
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama1.messages." + talkNo + ".txt" ,new Object[] {}));
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				}

				if(talkNo < 4)
				{
					ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), talkNo + 1);
				}else
				{
					ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 30);
				}

				return true;
			}

			if(ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() instanceof DqmItemEmblemBase)
			{
				DqmItemEmblemBase handEmblem = (DqmItemEmblemBase)ep.inventory.getCurrentItem().getItem();

				int jobPerm = ExtendedPlayerProperties3.get(ep).getJobPermission(handEmblem.getJobEnum().getId());
				if(!ep.worldObj.isRemote)
				{
					DqmItemEmblemBase embItem = (DqmItemEmblemBase)ep.inventory.getCurrentItem().getItem();
					DQR.func.debugString("Line5 : ",this.getClass());
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama1.messages.11.txt" ,new Object[] {EnumDqmMessageConv.JobName.getStartS() + embItem.getJobEnum().getId() + EnumDqmMessageConv.JobName.getEndS()}));
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				}

				if(jobPerm == 0)
				{
					ExtendedPlayerProperties3.get(ep).setJobPermission(handEmblem.getJobEnum().getId() , 1);
					ep.inventory.getCurrentItem().stackSize--;

					if(!ep.worldObj.isRemote)
					{
						DQR.func.debugString("Line6 : ",this.getClass());
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama1.messages.12.txt" ,new Object[] {EnumDqmMessageConv.JobName.getStartS() + handEmblem.getJobEnum().getId() + EnumDqmMessageConv.JobName.getEndS()}));
					}
				}else
				{
					if(!ep.worldObj.isRemote)
					{
						DQR.func.debugString("Line7 : ",this.getClass());
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama1.messages.13.txt" ,new Object[] {}));
					}
				}

				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 20);

			}else if(talkNo >= 20 && talkNo < 30)
			{
				if(!ep.worldObj.isRemote)
				{
					DQR.func.debugString("Line2",this.getClass());
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama1.messages." + talkNo + ".txt" ,new Object[] {}));
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				}
				if(talkNo < 21)
				{
					DQR.func.debugString("Line3",this.getClass());
					ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), talkNo + 1);
				}else
				{
					DQR.func.debugString("Line4",this.getClass());
					ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 30);
				}

				return true;
			}else
			{

				ep.openGui(DQR.instance, DQR.conf.GuiID_JobChange, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
				if(ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 20);
				return false;
			}

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
