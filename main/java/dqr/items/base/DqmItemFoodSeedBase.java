package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQSeeds;

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


		if(!p_77849_2_.isRemote)
		{
			DQR.func.doFoodEaten(ep, this);

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

		 if(dispMinMP > 0 || dispMinHP > 0 ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi.getUnlocalizedName()) ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi2.getUnlocalizedName()) ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi3.getUnlocalizedName()) ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI.getUnlocalizedName()) ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI2.getUnlocalizedName()) ||
				 this.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI3.getUnlocalizedName()))
		 {
			 p_77624_3_.add(I18n.format("dqm.iteminfo.canpet", new Object[]{}));
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
