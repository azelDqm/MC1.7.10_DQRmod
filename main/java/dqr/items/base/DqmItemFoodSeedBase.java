package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import scala.util.Random;
import dqr.api.Items.DQSeeds;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;

public class DqmItemFoodSeedBase extends ItemFood{

	private float minHP = -1;
	private int maxHP = -1;
	private int minMP = -1;
	private int maxMP = -1;
	public DqmItemFoodSeedBase(int par1, float par2, boolean par3) {
		super(par1, par2, par3);
		this.setAlwaysEdible();
	}

	public DqmItemFoodSeedBase setHealPoint(float par1, int par2, int par3, int par4)
	{
		this.minHP = par1;
		this.maxHP = par2;
		this.minMP = par3;
		this.maxMP = par4;
		return this;
	}
	@Override
    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer ep)
    {

		Random rand = new Random();
		float healHP = 0.0F;
		if(!p_77849_2_.isRemote)
		{
			if(this.minHP > -1 || this.maxHP > -1)
			{
				healHP = this.minHP + rand.nextInt(this.maxHP + 1);
			}

			if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemBannouyaku.getUnlocalizedName()))
			{
				//ep.setHealth(30.0F + (float)rand.nextInt(10));
				ep.removePotionEffect(DQPotionMinus.potionPoison.id);
				ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemJouyakusou.getUnlocalizedName()))
			{
				//healHP = 40.0F + (float)rand.nextInt(10);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTokuyakusou.getUnlocalizedName()))
			{
				//healHP = 70.0F + (float)rand.nextInt(20);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou.getUnlocalizedName()))
			{
				//healHP = 8.0F + (float)rand.nextInt(5);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou2.getUnlocalizedName()))
			{
				//healHP = 35.0F + (float)rand.nextInt(20);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou3.getUnlocalizedName()))
			{
				//healHP = 60.0F + (float)rand.nextInt(40);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou.getUnlocalizedName()))
			{
				//healHP = (float)rand.nextInt(5);
				ep.removePotionEffect(DQPotionMinus.potionPoison.id);
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 200, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou2.getUnlocalizedName()))
			{
				//healHP = 10.0F + (float)rand.nextInt(10);
				ep.removePotionEffect(DQPotionMinus.potionPoison.id);
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 300, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou3.getUnlocalizedName()))
			{
				ep.removePotionEffect(DQPotionMinus.potionPoison.id);
				ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 400, 1));
				//healHP = 20.0F + (float)rand.nextInt(10);
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane.getUnlocalizedName()))
			{
				//System.out.println("DEBUGLINE:" + this.getUnlocalizedName());
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 0));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon2.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1200, 1));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon3.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1800, 2));
			}else if(this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon4.getUnlocalizedName()))
			{
				ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 3));
			}


			if(healHP + ep.getHealth() > ep.getMaxHealth())
			{
				ep.setHealth(ep.getMaxHealth());
			}else
			{
				ep.setHealth(ep.getHealth() + healHP);
			}
		}

    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		 p_77624_3_.add(I18n.format("dqm.iteminfo.caneat"));

		 int dispMinHP = (int)this.minHP;
		 int dispMaxHP = (int)this.minHP + this.maxHP;
		 int dispAveHP = dispMaxHP / 2;

		 int dispMinMP = this.minMP;
		 int dispMaxMP = this.minMP + this.maxMP;
		 int dispAveMP = dispMaxMP / 2;

		 if(this.minHP >= 0 || this.maxHP >= 0)
		 {
			 p_77624_3_.add(I18n.format("dqm.iteminfo.hpheal", new Object[]{dispMinHP, dispMaxHP, dispAveHP}));
		 }
		 if(this.minMP >= 0 || this.maxMP >= 0)
		 {
			 p_77624_3_.add(I18n.format("dqm.iteminfo.mpheal", new Object[]{dispMinMP, dispMaxMP, dispAveMP}));
		 }

	    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
	    	if(nbt != null)
	    	{
	    		NumberFormat nfNum = NumberFormat.getNumberInstance();
	    		int medalVal = nbt.getInteger("medalking");
	    		//System.out.println("TEST:" + medalVal);
	    		if(medalVal > 0)
	    		{

	        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

	    			p_77624_3_.add(medalValue);
	    		}

	    		int coinVal = nbt.getInteger("casinocoin");
	    		//System.out.println("TEST:" + medalVal);
	    		if(coinVal > 0)
	    		{

	        		String medalValue = I18n.format("msg.casinocoin.item.txt", new Object[]{nfNum.format(coinVal)});

	    			p_77624_3_.add(medalValue);
	    		}
	    	}


	 }

	 public float getMinHP()
	 {
		 return this.minHP;
	 }

	 public int getMaxHP()
	 {
		 return this.maxHP;
	 }

	 public float getMinMP()
	 {
		 return this.minMP;
	 }

	 public int getMaxMP()
	 {
		 return this.maxMP;
	 }
}
