package dqr.items.base;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.enums.EnumDqmJob;

public class DqmItemEmblemDamaBase extends Item{

	private EnumDqmJob itemJob;
	private IIcon[] iconItemSample;

	public DqmItemEmblemDamaBase(EnumDqmJob par1)
	{
		this.itemJob = par1;
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		//this.setCreativeTab(DQR.tabs.DqmTabMisc);
	}

	public EnumDqmJob getJobEnum()
	{
		return this.itemJob;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return iconItemSample[par1 % iconItemSample.length];
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		//名前の登録
		return par1ItemStack.getItemDamage() == 0 ? this.getUnlocalizedName() : this.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		//メタデータでアイテムを追加する
		//par3List.add(new ItemStack(this, 1, <メタデータ>));
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
            //テクスチャのパス指定。
            //メタデータは0から2でつまり3未満
            //src/minecraft/assets/samplemod/items/itemsample_(メタデータ).png
	    this.iconItemSample = new IIcon[2];

	    this.iconItemSample[0] = par1IconRegister.registerIcon(this.getIconString());
	    this.iconItemSample[1] = par1IconRegister.registerIcon("dqr:Dama_no");

    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {

    	int[] needLvTable = DQR.jobChangeTable.getJobChangeTable(this);
    	String needLv = "";

    	if(needLvTable != null)
    	{
    		for(int cnt = 0; cnt < needLvTable.length; cnt++)
    		{
    			if(needLvTable[cnt] > 0)
    			{
    				String jobName = I18n.format("gui.job." +cnt);

    				if(needLvTable[cnt] < 100)
    				{
    					if(needLv != "")
    					{
    						needLv = needLv + "& ";
    					}
    					needLv = needLv + jobName + "(Lv." + needLvTable[cnt] + ") ";
    				}
    			}
    		}

    		if(needLv == "")
    		{
    			String noLv = I18n.format("dqm.magicinfo.needNo", new Object[]{});
    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{noLv}));
    		}else
    		{
    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{needLv}));
    		}
    	}

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
    }
}