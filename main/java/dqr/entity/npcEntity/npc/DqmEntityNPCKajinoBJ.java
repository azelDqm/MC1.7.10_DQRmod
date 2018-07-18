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
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmEntityNPCKajinoBJ extends DqmNPCBase
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
    	/*
        if (this.isTamed())
        {
            return false;
        }

        if(this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Blocks.brick_block)
        {
        	return false;
        }

        if (this.worldObj.getBlockId((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Block.brick.blockID || this.worldObj.getBlockId((int)this.posX, (int)this.posY - 1, (int)this.posZ) == DqmItemList.Kowarenai8.blockID)
        {
            return false;
        }


        return true;
        */
    	return false;
    }

    public DqmEntityNPCKajinoBJ(World par1World)
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

    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;


    @Override	public int getTotalArmorValue()
    {
        return DF;
    }
    /*
    @Override	public int getAttackStrength(Entity par1Entity)
    {
        return PW;
    }
    */
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

			int talkNo = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.CASINOBJ.getId());

			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("" + talkNo));
			if(talkNo == 0)
			{
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.casino.dealer.blackjack.0.txt" ,new Object[] {}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.CASINOBJ.getId(), 1);
			}else
			{
				ep.openGui(DQR.instance, DQR.conf.GuiID_CSBlackJack, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
			}
			//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Dama2.messages.-1.txt" ,new Object[] {}));
			//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
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
