package dqr.items.base;

import java.text.NumberFormat;
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
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmJob;

public class DqmItemEmblemBase extends Item{

	private EnumDqmJob itemJob;
	private IIcon[] iconItemSample;

	public DqmItemEmblemBase(EnumDqmJob par1)
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
		//par3List.add(new ItemStack(this, 1, 1));
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
    	int isJobSkill = 0;
    	String needLv = "";
    	if(p_77624_1_.getDisplayName().indexOf("dqm.skill.JSkill_") > -1)
    	{
    		p_77624_1_.setStackDisplayName(I18n.format(p_77624_1_.getDisplayName()));
    	}

    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		isJobSkill = nbt.getInteger("isJobSkill");
    	}

    	if(needLvTable != null && isJobSkill == 0)
    	{
    		int jobCnt = 0;

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

    		if(needLv.split("& ").length > 3)
    		{
    			String[] splitWord = needLv.split("& ");
    			int loopCnt = 0;
    			for(int reCnt = 0; reCnt < splitWord.length; reCnt++)
    			{
    				if(loopCnt == 0)
    				{
    					p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{splitWord[reCnt] + " & " + splitWord[reCnt + 1]}));
    				}else
    				{
    					if(reCnt + 1 < splitWord.length)
    					{
    						p_77624_3_.add(I18n.format("dqm.magicinfo.needLv2", new Object[]{splitWord[reCnt] + " & " + splitWord[reCnt + 1]}));
    					}else
    					{
    						p_77624_3_.add(I18n.format("dqm.magicinfo.needLv2", new Object[]{splitWord[reCnt]}));
    					}
    				}

    				reCnt = reCnt + 1;
    				loopCnt = loopCnt + 1;
    			}
    		}else
    		{

	    		if(needLv == "")
	    		{
	    			String noLv = I18n.format("dqm.magicinfo.needNo", new Object[]{});
	    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{noLv}));
	    		}else
	    		{
	    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{needLv}));
	    		}
    		}
    	}

    	//NBTTagCompound nbt = p_77624_1_.getTagCompound();
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

    		if(nbt.getInteger("isJobSkill") > 0)
    		{
    			p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.skill.JSkill.needSP", new Object[]{nbt.getInteger("needSP")}));

    			if(nbt.getInteger("isJobSkill") == 2)
    			{
    				p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.skill.JSkill.allFlg", new Object[]{}));
    			}

    			if(nbt.getInteger("activeSkill") == 1)
    			{
    				p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.skill.info.func.1", new Object[]{}));
    			}else
    			{
    				p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.skill.info.func.2", new Object[]{}));
    			}

    			String skillInfo = I18n.format("dqm.skill.JSkill_" + nbt.getInteger("jobId") + "_" + nbt.getInteger("skillIdx") + ".info", new Object[]{});
    			p_77624_3_.add(EnumColor.White.getChatColor() +  skillInfo);
    		}
    	}
    }
}
