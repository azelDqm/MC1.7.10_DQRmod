package dqr.entity.npcEntity.npc;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.api.enums.EnumDqmShopPrice;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.gui.dqrShop.InventoryDqrShop;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmEntityNPCBukiya extends DqmNPCBase
{
    //private int HP = 9999; //********

    //private int PW = 100; //********
    private int DF = 100; //********
    //private int isDay = 0;
    private int itemRandom = -1;
    private float SP = 0.0F; //********
    private String Name = "スティーブ";//********
    private String NameE = "SteveS";//********
    private boolean Fire = true;//******** true false
    protected void fall(float par1) {} //********

    public int shopGrade = 0; //0:地上 3:ネザー 4:エンド 5:伝説 6:ALL
    public ItemStack sampleItemStack = new ItemStack(Items.wooden_sword, 1);
    public long sireTime = 0;
    public DqmEntityNPCBukiya(World par1World, int par1)
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

        this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
        this.sampleItemStack.setTagCompound(new NBTTagCompound());
        this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());
        this.setShopGrade(par1);
        this.doItemSiire();
    }

    public DqmEntityNPCBukiya(World par1World)
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

        this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
        this.sampleItemStack.setTagCompound(new NBTTagCompound());
        this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());
        this.doItemSiire();

    }

    @Override
    public void setDead()
    {
        super.setDead();
    }
    @Override
    public void onLivingUpdate()
    {
    	Random rand = new Random();

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
        if (this.isTamed())
        {
            return false;
        }

        if(this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Blocks.brick_block)
        {
        	return false;
        }


        if(this.getTameMode() != 0)
        {
        	return false;
        }

        return true;
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

		this.doItemSiire();
		//DEBUG



		/*
		 InventoryDqrShop inventory = new InventoryDqrShop(this);
		 inventory.openInventory();
		 System.out.println("TEST0 : " + this.sireTime);
        for(int cnt = 0; cnt < inventory.getSizeInventory(); cnt++)
        {
        	ItemStack stack1 = inventory.getStackInSlot(cnt);

        	if(stack1 != null)
        	{
        		System.out.println("TEST : "  + this.worldObj.isRemote + " / " + stack1.getItem().getUnlocalizedName());
        	}

        }
		inventory.closeInventory();
		*/

		//DEBU
    	ExtendedPlayerProperties3.get(ep).setGuiNPCBukiya(this);
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

			int flg = ExtendedPlayerProperties.get(ep).getNpcTalk(EnumDqmNpcTalk.BUKIYA.getId());

			if(flg == 0)
			{
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bukiya.messages.0.txt",new Object[] {}));
				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 1);
				//PacketHandler.INSTANCE.sendTo(new MessageClientCleatSlotItem(cnt), (EntityPlayerMP)ep);
    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
			}else
			{
				//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(ep), (EntityPlayerMP)ep);
				ExtendedPlayerProperties.get(ep).setShopTalkingGrade(this.shopGrade);
				ep.openGui(DQR.instance, DQR.conf.GuiID_ItemShop, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
				if(ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
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

    public ItemStack getChestItem()
    {
    	return this.sampleItemStack;
    }

    public void setChestItem(ItemStack par1)
    {
    	this.sampleItemStack = par1;
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);

    	NBTTagCompound itemNBT = new NBTTagCompound();
    	if(this.sampleItemStack == null)
    	{
            this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
            this.sampleItemStack.setTagCompound(new NBTTagCompound());
            this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());
    	}
    	this.sampleItemStack.writeToNBT(itemNBT);

    	p_70014_1_.setTag("sampleItemStack", itemNBT);
    	p_70014_1_.setLong("sireTime", this.sireTime);

    	p_70014_1_.setInteger("shopGrade", this.shopGrade);
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.sampleItemStack = ItemStack.loadItemStackFromNBT(p_70037_1_.getCompoundTag("sampleItemStack"));
        this.sireTime = p_70037_1_.getLong("sireTime");
        this.shopGrade = p_70037_1_.getInteger("shopGrade");
    }

    public void doItemSiire()
    {
    	if(this.worldObj.isRemote) return;

        InventoryDqrShop inventory = new InventoryDqrShop(this);
        int checkGrade = 0;
        if(shopGrade == 0)
        {
        	//地上の場合 時間を見て 夜か昼か判断
        	long thisTime =  this.worldObj.getWorldTime() % 24000;
        	if(thisTime < 12000)
        	{
        		checkGrade = 1;
        	}else
        	{
        		checkGrade = 2;
        	}
        }else
        {
        	checkGrade = shopGrade;
        }

        //System.out.println("ShopTest1");
        EnumDqmShopPrice setEnum = null;
        ItemStack setItemStack = null;
        if(this.sireTime == 0 || this.worldObj.getWorldTime() - this.sireTime <= 0)
        {
        	//System.out.println("ShopTest2");
        	this.sireTime = this.worldObj.getWorldTime();
        	setEnum = DQR.enumGetter.getEnumDqmShopPriceRandom(checkGrade);
        	setItemStack = new ItemStack(setEnum.getItem(), 1);

        	NBTTagCompound nbt = setItemStack.getTagCompound();
        	if(nbt == null)
        	{
        		nbt = new NBTTagCompound();
        	}

        	nbt.setLong("SiireTime", this.worldObj.getWorldTime());
        	nbt.setInteger("ItemPrice", setEnum.getPrice());
        	setItemStack.setTagCompound(nbt);

        	inventory.openInventory();
        	inventory.setInventorySlotContents(0, setItemStack);
        	inventory.closeInventory();

        	//やること
        	//値段の書き込み
        	//登録時刻の書き込み < アイテム仕入で置き換え時の目安用
        	//いきなりつっこまずに、一度ItemStackを作って NBTをセットする

        	//System.out.println("ShopTest3 : " + setEnum.getItem().getUnlocalizedName());
        }else
        {
        	//System.out.println("ShopTest4");
        	int maxCounter = (int)(this.worldObj.getWorldTime() - this.sireTime) / 12000;

        	if(maxCounter > 8) maxCounter = 8;

	        inventory.openInventory();

	        for(int loop1 = 0; loop1 < maxCounter; loop1++)
	        {
	        	Long checkSiireTime = 0L;
	        	int checkSiireTSlot = -1;

	        	//System.out.println("ShopTest5 : " + loop1);
		        for(int cnt = 0; cnt < inventory.getSizeInventory(); cnt++)
		        {
		        	ItemStack stack1 = inventory.getStackInSlot(cnt);
		        	//System.out.println("ShopTest8 : " + loop1 + " / " + cnt);
		        	if(stack1 == null)
		        	{
		        		checkSiireTSlot = cnt;
		        		break;
		        		//inventory.setInventorySlotContents(0, new ItemStack(DQR.enumGetter.getEnumDqmShopPriceRandom(checkGrade).getItem(), 1));
		        	}else
		        	{
			        	NBTTagCompound nbt = stack1.getTagCompound();

		        		if(nbt != null && (checkSiireTime == 0L || nbt.getLong("SiireTime") < checkSiireTime))
		        		{
		        			checkSiireTime = nbt.getLong("SiireTime");
		        			checkSiireTSlot = cnt;
		        		}else if(nbt == null)
		        		{
		        			checkSiireTSlot = cnt;
		        			break;
		        		}
		        		//NBTTagCompound =
		        	}

		        }
		        //System.out.println("ShopTest6 : " + loop1);
	        	if(checkGrade == 1)
	        	{
	        		checkGrade = 2;
	        	}else if(checkGrade == 2)
	        	{
	        		checkGrade = 1;
	        	}

            	this.sireTime = this.worldObj.getWorldTime();
            	setEnum = DQR.enumGetter.getEnumDqmShopPriceRandom(checkGrade);
            	setItemStack = new ItemStack(setEnum.getItem(), 1);

            	NBTTagCompound nbt = setItemStack.getTagCompound();
            	if(nbt == null)
            	{
            		nbt = new NBTTagCompound();
            	}

            	nbt.setLong("SiireTime", this.worldObj.getWorldTime());
            	nbt.setInteger("ItemPrice", setEnum.getPrice());
            	setItemStack.setTagCompound(nbt);

            	inventory.setInventorySlotContents(checkSiireTSlot, setItemStack);
            	//System.out.println("ShopTest7 : " + loop1);
	        }

	        inventory.closeInventory();

        }
    }

    public void setShopGrade(int par1)
    {
    	this.shopGrade = par1;
    }

    public int getShopGrade()
    {
    	return this.shopGrade;
    }
}
