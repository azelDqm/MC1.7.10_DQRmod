package dqr.entity.npcEntity.npc;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import dqr.DQR;
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
        		/*
            this.worldObj.getBlockId(var1, var2 - 1, var3) == 1 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 2 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 3 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 12 && !(isValidLightLevel()) && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 18 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 31 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 78 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 87 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 98  && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 110 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 112 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0
            || this.worldObj.getBlockId(var1, var2 - 1, var3) == 121 && this.worldObj.getBlockId(var1, var2, var3) == 0 && this.worldObj.getBlockId(var1, var2 + 1, var3) == 0;
            */
        // || this.isValidLightLevel() && super.getCanSpawnHere();
        //   return super.getCanSpawnHere() && isValidLightLevel();
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

    /*
    public void Nedan(ICommandSender var1, String[] var2)
    {
        EntityPlayer ep = (EntityPlayer)var1;
        String var13;
        String var14;
        var13 = "そうだな、そいつの修理なら " + ep.SyuuriGold + " Gになるがどうする？";
        var1.sendChatToPlayer(var13);
        var14 = "修理するならスニーク状態で、もう一度その武具で話しかけるんだな。";
        var1.sendChatToPlayer(var14);
    }
    public void Syuuri(ICommandSender var1, String[] var2)
    {
        EntityPlayer ep = (EntityPlayer)var1;
        String var13;
        String var14;
        var13 = ep.SyuuriGold + " G支払った。またきな！";
        var1.sendChatToPlayer(var13);
    }
    public void Taranai(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "金が足らないようだな。";
        var1.sendChatToPlayer(var13);
    }
    public void No(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "悪いが、そいつは修理できねぇな。";
        var1.sendChatToPlayer(var13);
    }
    public void Event(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "よう！修理したい武具があれば直してやるぞ！";
        var1.sendChatToPlayer(var13);
    }
    public void Nakama(ICommandSender var1, String[] var2)
    {
        String var13;
        var13 = "いつも助かるぜ！これからはお前専属の修理屋となろう！どこへでも着いていくぜ！";
        var1.sendChatToPlayer(var13);
    }
    */
    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;

    /*
    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (rand.nextInt(1) == 0)
        {
            this.dropItem(DqmItemList.Se.itemID, 1);   //1
        }
    }
    */

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

			int talkNo = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.CASINOBJ.getId());

			//ep.addChatMessage(new ChatComponentTranslation("" + talkNo));
			if(talkNo == 0)
			{
				ep.addChatMessage(new ChatComponentTranslation("msg.casino.dealer.blackjack.0.txt" ,new Object[] {}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.CASINOBJ.getId(), 1);
			}else
			{
				ep.openGui(DQR.instance, DQR.conf.GuiID_CSBlackJack, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
			}
			//ep.addChatMessage(new ChatComponentTranslation("msg.Dama2.messages.-1.txt" ,new Object[] {}));
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
