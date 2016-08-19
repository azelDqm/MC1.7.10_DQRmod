package dqr.items.base;

import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmElement;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemBowBase extends ItemBow{

	private IIcon[] iconArray;
	private float field_150934_a;
	private final Item.ToolMaterial field_150933_b;
	private float maxAttackDam;
	private String model;

	public DqmItemBowBase(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage)
	{
		super();
		this.field_150933_b = p_i45356_1_;
        this.field_150934_a = attackDam;
        this.maxAttackDam = attackDam;
		this.setMaxDamage(maxDamage);
	}

	@Override
    public boolean onLeftClickEntity(ItemStack p_77659_1_, EntityPlayer p_77659_2_, Entity p_77659_3_)
    {
    	//System.out.println("TESTTEST");
    	return super.onLeftClickEntity(p_77659_1_, p_77659_2_, p_77659_3_);

    }

    public EnumDqmElement getElement()
    {
    	if(this == DQWeapons.itemKazekirinoyumi)
    	{
    		return EnumDqmElement.KAZE;
    	}

    	return null;
    }
	/*
		if(var3 instanceof EntityPlayer)
		{

			EntityPlayer ep = (EntityPlayer)var3;


			if(ep.isUsingItem() && ep.inventory.getCurrentItem() == var1)
			{
				int indu = ep.getItemInUseDuration();
				int induDam = var1.getItemDamage();
				if(indu > 18 && (induDam % 4) == 2)
				{
					//var1.setItemDamage(var1.getItemDamage() + 1);
					var1.damageItem(1, ep);
					return;
				}else if(indu > 13 && (induDam % 4) == 1)
				{
					//var1.setItemDamage(var1.getItemDamage() + 1);
					var1.damageItem(1, ep);
					return;
				}else if(indu > 0 && (induDam % 4) == 0)
				{
					//var1.setItemDamage(var1.getItemDamage() + 1);
					var1.damageItem(1, ep);

				}
			}
		}
		*/
			/*
			if(!ep.isUsingItem())
			{
				int damReq = var1.getItemDamage() % 4;
				if(damReq != 0)
				{
					var1.setItemDamage(var1.getItemDamage() + (4 - damReq));
				}
			}
			*/

		/*
    	if(!var2.isRemote)
    	{

	    	int maxDam = var1.getMaxDamage();
	    	int calDam = maxDam - var1.getItemDamage();
	    	int perDam = calDam * 1000 / maxDam;

	    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);


	    	field_150934_a = maxAttackDam *  (perDam + 100) / 1000;


	    	if(perDam <= 100)
	    	{
	    		var1.setItemDamage(var1.getItemDamage() - 1);
	    	}
	    	//System.out.println("DEBUGLINE:");
	    	//field_150934_a = maxAttackDam;
    	}
    	*/
    //}

    public float func_150931_i()
    {
        //return this.field_150933_b.getDamageVsEntity();
    	return this.field_150934_a;
    }

	@Override
	 public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if (flag || p_77615_3_.inventory.hasItem(Items.arrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            if(p_77615_2_.isRemote)
            {
	            if(p_77615_1_.getMaxItemUseDuration() - p_77615_3_.getItemInUseCount() > 20)
	            {
	            	ExtendedPlayerProperties.get(p_77615_3_).setMaxItemUserCnt(20);
	            }else
	            {
	            	ExtendedPlayerProperties.get(p_77615_3_).setMaxItemUserCnt(p_77615_1_.getMaxItemUseDuration() - p_77615_3_.getItemInUseCount());
	            }
            }else
            {
            	//ExtendedPlayerProperties.get(p_77615_3_).setMaxItemUserCnt(p_77615_1_.getMaxItemUseDuration() - p_77615_3_.getItemInUseCount());
            }
            //System.out.println("TEST1:" + p_77615_3_.getItemInUseCount());
            EntityArrow entityarrow = new EntityArrow(p_77615_2_, p_77615_3_, f * 2.0F);
            if(p_77615_3_ != null)
            {
            	entityarrow.setDamage(ExtendedPlayerProperties.get(p_77615_3_).getKougeki() * 2);
            }
            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 1.0D + 1.0D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
            {
                entityarrow.setFire(100);
            }

        	int maxDam = p_77615_1_.getMaxDamage();
        	int dam = p_77615_1_.getItemDamage();


        	if(maxDam * 9 / 10 > dam)
        	{
        		p_77615_1_.damageItem(4 - (dam % 4), p_77615_3_);
        	}else
        	{
        			p_77615_1_.setItemDamage((maxDam * 9 / 10) - 4);
        			dam = p_77615_1_.getItemDamage();

        			p_77615_1_.damageItem(4 - (dam % 4), p_77615_3_);
        	}

            //p_77615_1_.damageItem(1, p_77615_3_);
            if(!p_77615_2_.isRemote)p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                p_77615_3_.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        //super.registerIcons(p_94581_1_);
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
        	this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
        	/*
        	if(this == DQWeapons.itemKaryuudonoyumi ||
        	   this == DQWeapons.itemKazekirinoyumi ||
        	   this == DQWeapons.itemKeironnoyumi ||
        	   this == DQWeapons.itemJigokunoyumi ||
        	   this == DQWeapons.itemBigbougan)
        	{
        		this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
        	}else
        	{
	            //this.iconArray[i] = par1IconRegister.registerIcon(bowPullIconNameArray[i]);
	        	//this.iconArray[i] = p_94581_1_.registerIcon(bowPullIconNameArray[i]);
	        	this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString());
        	}
        	*/
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
    	//System.out.println("DEBUGLINE:" + this.iconArray[p_94599_1_].getIconName());
        return this.iconArray[p_94599_1_];
    }


    public DqmItemBowBase setmodel(String m){

        model = m;
        return this;
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {
    	int maxDam = p_77644_1_.getMaxDamage();
    	int dam = p_77644_1_.getItemDamage();

    	if(maxDam * 9 / 10 > dam)
    	{
    		p_77644_1_.damageItem(1, p_77644_3_);
    	}
        return true;
    }


    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	int dam = (int)maxAttackDam;

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.attackdamage", new Object[]{dam}));

    	if(this.getElement() != null)
    	{
    		EnumDqmElement element = this.getElement();
    		p_77624_3_.add(element.getColor() + I18n.format("dqm.iteminfo.weapon.element." + element.getKey() + ".txt", new Object[]{}));
    	}
    	/*
    	p_77624_3_.add(I18n.format("dqm.iteminfo.caneat"));


		 if(this.minHP >= 0 || this.maxHP >= 0)
		 {
			 p_77624_3_.add(I18n.format("dqm.iteminfo.hpheal", new Object[]{dispMinHP, dispMaxHP, dispAveHP}));
		 }
		 if(this.minMP >= 0 || this.maxMP >= 0)
		 {
			 p_77624_3_.add(I18n.format("dqm.iteminfo.mpheal", new Object[]{dispMinMP, dispMaxMP, dispAveMP}));
		 }
		 */

    	int[] apptitudeTable = DQR.aptitudeTable.getWAptitudeTable(this);
    	String[] usefulJob = new String[32];
    	String[] usefulJob2 = new String[32];
    	int usefulCnt = 0;
    	int usefulLine = 0;

    	int usefulCnt2 = 0;
    	int usefulLine2 = 0;

    	if(apptitudeTable != null)
    	{
    		for(int cnt = 0; cnt < apptitudeTable.length; cnt++)
    		{
    			//System.out.println("" + cnt + "/" + apptitudeTable[cnt]);
    			if(apptitudeTable[cnt] > -1)
    			{
    				String jobName = I18n.format("gui.job." +cnt);

    				if(apptitudeTable[cnt] > 1)
    				{
	    				if(usefulCnt > 3)
	    				{
	    					usefulLine++;
	    					usefulCnt = 1;
	    					usefulJob[usefulLine] = jobName + " ";
	    				}else
	    				{
	    					usefulJob[usefulLine] = usefulJob[usefulLine] != null?usefulJob[usefulLine] + jobName + " ":jobName + " ";
	    					usefulCnt++;
	    				}
    				}else
    				{
	    				if(usefulCnt2 > 3)
	    				{
	    					usefulLine2++;
	    					usefulCnt2 = 1;
	    					usefulJob2[usefulLine2] = jobName + " ";
	    				}else
	    				{
	    					usefulJob2[usefulLine2] = usefulJob2[usefulLine2] != null?usefulJob2[usefulLine2] + jobName + " ":jobName + " ";
	    					usefulCnt2++;
	    				}
    				}
    			}
    		}

    		if(usefulJob[0] != null && !usefulJob[0].equalsIgnoreCase(""))
    		{
	        	p_77624_3_.add(I18n.format("dqm.iteminfo.weaponappti", new Object[]{usefulJob[0]}));
	        	if(usefulLine > 0)
	        	{
	        		for(int lCnt = 0; lCnt < usefulLine; lCnt++)
	        		{
	        			p_77624_3_.add(I18n.format("dqm.iteminfo.weaponapptiSPC", new Object[]{usefulJob[lCnt + 1]}));
	        		}
	        	}
    		}

    		if(usefulJob2[0] != null && !usefulJob2[0].equalsIgnoreCase(""))
    		{
	        	p_77624_3_.add(I18n.format("dqm.iteminfo.weaponappti2", new Object[]{usefulJob2[0]}));
	        	if(usefulLine2 > 0)
	        	{
	        		for(int lCnt = 0; lCnt < usefulLine2; lCnt++)
	        		{
	        			p_77624_3_.add(I18n.format("dqm.iteminfo.weaponappti2SPC", new Object[]{usefulJob2[lCnt + 1]}));
	        		}
	        	}
    		}
        	p_77624_3_.add("");
    	}


    	if(DQR.spUseItems.specialUseItems.containsKey(this))
    	{
    		String key = this.getUnlocalizedName().replace("item.dqm.", "");

    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.weapon2." + key + ".txt", new Object[]{}));
    		p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.weapon2.base.txt", new Object[]{}));
    		p_77624_3_.add("");
    	}

		Map<Integer, Float> retMap = DQR.weaponBooster.getBooster(this);
		if(retMap.containsKey(DQR.weaponBooster.DRAGON)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.dragon.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.WATER)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.water.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.UNDEAD)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.undead.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.MACHINE)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.machine.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.ELEMENT)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.element.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.SLIME)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.slime.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.BUSSHITU)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.busshitu.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.PLANT)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.plant.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.BIRD)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.bird.txt", new Object[]{}));}
		if(retMap.containsKey(DQR.weaponBooster.AKUMA)){p_77624_3_.add(EnumColor.Blue.getChatColor() + I18n.format("dqm.iteminfo.weapon.booster.akuma.txt", new Object[]{}));}


    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		int medalVal = nbt.getInteger("medalking");
    		//System.out.println("TEST:" + medalVal);
    		if(medalVal > 0)
    		{

        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

    			p_77624_3_.add(medalValue);
    		}
    	}

    	NBTTagList tag = p_77624_1_.getEnchantmentTagList();
		if(tag != null)
		{
			p_77624_3_.add("");
		}
	 }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int p_77617_1_)
    {
    	//System.out.println("DEBUGLINE:" + p_77617_1_);
    	if(p_77617_1_ % 4 > 0)
    	{
    		if( p_77617_1_ % 4 >= 3){
    			return this.iconArray[2];
    		}else
    		{
    			return this.iconArray[p_77617_1_ % 4];
    		}

    	}else
    	{
    		return this.itemIcon;
    	}
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {

        int j = stack.getMaxItemUseDuration() - useRemaining;

        if (j >= 18)
        {
            return this.iconArray[2];
        }

        if (j > 13)
        {
            return this.iconArray[1];
        }

        if (j > 0)
        {
            return this.iconArray[0];
        }

        return getIcon(stack, renderPass);

    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.bow;
    }
}
