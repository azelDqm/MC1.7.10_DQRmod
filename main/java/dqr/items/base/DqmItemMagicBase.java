package dqr.items.base;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMagicCateg;
import dqr.entity.magicEntity.magic.MagicEntity;

public class DqmItemMagicBase extends Item{
	protected float efficiencyOnProperMaterial = 4.0F;
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;
    private static final String __OBFID = "CL_00000072";
    private float maxAttackDam;
    private EnumDqmMagic enumMagic;

    private int mode;
    //private static final Set hammerTable = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
    //private static final Set axeTable = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    //private static final Set clawTable = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public DqmItemMagicBase(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
        this.field_150933_b = p_i45356_1_;
        this.maxStackSize = 1;
        this.setMaxDamage(maxDamage);
        this.efficiencyOnProperMaterial = p_i45356_1_.getEfficiencyOnProperMaterial();
        //this.setCreativeTab(CreativeTabs.tabCombat);
        this.field_150934_a = attackDam;
        this.maxAttackDam = attackDam;
        this.mode = 0;
        this.enumMagic = par4;
    }

    public DqmItemMagicBase setEfficiencyOnProper(float par1)
    {
    	efficiencyOnProperMaterial = par1;
    	return this;
    }

    public float func_150931_i()
    {
        //return this.field_150933_b.getDamageVsEntity();
    	return this.field_150934_a;
    }

    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {

    	if(var1.getItemDamage() < 0)
    	{

    	}else if(var1.getItemDamage() > 0)
    	{
    		var1.setItemDamage(var1.getItemDamage() - 10);
    	}

    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	Material material = p_150893_2_.getMaterial();

    	/*
        if (p_150893_2_ == Blocks.web)
        {
            return 15.0F;
        }
        else
        {
        	if(this.field_150933_b == DQR.dqmMaterial.DqmAxe && mode == 0)
        	{
        		//DQ斧の場合の処理
        		if(p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine)
        			{
        				return super.func_150893_a(p_150893_1_, p_150893_2_);
        			}else if(this.axeTable.contains(p_150893_2_))
        			{
        				return this.efficiencyOnProperMaterial;
        			}else
        			{
        				return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? (material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F) : this.efficiencyOnProperMaterial;
        			}
        	}else if(mode == 0 && (this.field_150933_b == DQR.dqmMaterial.DqmHammer0 || this.field_150933_b == DQR.dqmMaterial.DqmHammer1 || this.field_150933_b == DQR.dqmMaterial.DqmHammer2 || this.field_150933_b == DQR.dqmMaterial.DqmHammer3))
        	{
        		//DQツルハシの場合の処理
        		if(p_150893_2_ == Blocks.obsidian && this.field_150933_b == DQR.dqmMaterial.DqmHammer3)
        		{
        			 return this.efficiencyOnProperMaterial;
        		}else if(this.hammerTable.contains(p_150893_2_) && p_150893_2_ != Blocks.obsidian)
        		{
        			return this.efficiencyOnProperMaterial;
        		}else if(p_150893_2_ instanceof DqmBlockOreBase)
        		{
        			return this.efficiencyOnProperMaterial;
        		}else
        		{
        			return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
        		}
        	}else if(this.field_150933_b == DQR.dqmMaterial.DqmClaw && mode == 0)
        	{
        		//DQ爪の場合の処理
        		if(this.clawTable.contains(p_150893_2_))
        		{
        			 return this.efficiencyOnProperMaterial;
        		}else
        		{
        			if(p_150893_2_.getMaterial() == Material.grass || p_150893_2_.getMaterial() == Material.clay || p_150893_2_.getMaterial() == Material.sand || p_150893_2_.getMaterial() == Material.snow)
        			{
        				return this.efficiencyOnProperMaterial;
        			}
        		}
        	}
        }
        */
        return 1.0F;

        //return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {
    	/*
    	int maxDam = p_77644_1_.getMaxDamage();
    	int dam = p_77644_1_.getItemDamage();

    	if(maxDam * 9 / 10 > dam)
    	{
    		p_77644_1_.damageItem(1, p_77644_3_);
    	}
    	*/
        return true;
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {

    	/*
        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {
            p_150894_1_.damageItem(2, p_150894_7_);
        }
        */

        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	//par4は右クリックの押下時間。

	    //まず、クリエイティブであるか＆このアイテムにInfinityエンチャントが付いているかを確かめる。いずれかを満たすとtrue。
	    //boolean flag = par3EntityPlayer.capabilities.isCreativeMode ||
	    //EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        //if (!flag)//アイテムにダメージを与える。
        //{

        //}

    	if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
    	{

    		MagicEntity bullet = new MagicEntity(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
    		MagicEntity bullet2 = new MagicEntity(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.7F, 0.0F, 0.0F);
    		MagicEntity bullet3 = new MagicEntity(par2World, par3EntityPlayer, 1.5F, 1.0F, -0.7F, 0.0F, 0.0F);

        	bullet.setDamage(0);

        	par1ItemStack.damageItem(100, par3EntityPlayer);
        //if (f == 1.0F)
        //{
        //	bullet.setIsCritical(true);
        //}

        //par2World.playSoundAtEntity(par3EntityPlayer, "mob.villager.idle", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
        	if(!par3EntityPlayer.worldObj.isRemote) par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

        	if (!par2World.isRemote)
        	{
        		par2World.spawnEntityInWorld(bullet);
        		par2World.spawnEntityInWorld(bullet2);
        		par2World.spawnEntityInWorld(bullet3);
        	}
    	}

        //return true;
        //p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return par1ItemStack;
    }

    public boolean func_150897_b(Block p_150897_1_)
    {
        if(p_150897_1_ == Blocks.web)
        {
        	return true;
        }else if(this.field_150933_b == DQR.dqmMaterial.DqmHammer0 || this.field_150933_b == DQR.dqmMaterial.DqmHammer1 || this.field_150933_b == DQR.dqmMaterial.DqmHammer2 || this.field_150933_b == DQR.dqmMaterial.DqmHammer3)
        {
        	return p_150897_1_ == Blocks.obsidian ? this.field_150933_b.getHarvestLevel() == 3 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.field_150933_b.getHarvestLevel() >= 2) : this.field_150933_b.getHarvestLevel() >= 1) : this.field_150933_b.getHarvestLevel() >= 1) : this.field_150933_b.getHarvestLevel() >= 2) : this.field_150933_b.getHarvestLevel() >= 2) : this.field_150933_b.getHarvestLevel() >= 2);
        }else if(this.field_150933_b == DQR.dqmMaterial.DqmClaw)
        {
        	return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
        }else
        {
        	return false;
        }
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.field_150933_b.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.field_150933_b.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
    	return false;
        //return this.field_150933_b.func_150995_f() == p_82789_2_.getItem() ? true : super.getIsRepairable(p_82789_1_, p_82789_2_);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a, 0));
        return multimap;
    }

    public Item.ToolMaterial getMaterial()
    {
    	return this.field_150933_b;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, block, meta);
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	int dam = (int)maxAttackDam;


    	String categ = I18n.format(this.enumMagic.getCateg().getLang());
    	categ = I18n.format("dqm.magicinfo.categ", new Object[]{categ});

    	if(this.enumMagic.getCateg() == EnumDqmMagicCateg.Attack)
    	{
    		categ = categ + I18n.format("dqm.magicinfo.categAttack", new Object[]{this.enumMagic.getAttack()});
    	}else if(this.enumMagic.getCateg() == EnumDqmMagicCateg.HPheal)
    	{
    		categ = categ + I18n.format("dqm.magicinfo.categHPheal", new Object[]{this.enumMagic.getAttack()});
    	}

    	p_77624_3_.add(I18n.format(categ));

    	String needLv = "";
    	String[] usefulJob = new String[32];
    	int usefulCnt = 0;
    	int usefulLine = 0;

    	int[] needLvTable = DQR.magicTable.getMagicLvTable(this);

    	if(needLvTable != null)
    	{
    		for(int cnt = 0; cnt < needLvTable.length; cnt++)
    		{
    			if(needLvTable[cnt] > 0)
    			{
    				String jobName = I18n.format("gui.job." +cnt);
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

    				if(needLvTable[cnt] < 100)
    				{
    					needLv = needLv + jobName + "(Lv." + needLvTable[cnt] + ") ";
    				}
    			}
    		}
    	}

    	p_77624_3_.add(I18n.format("dqm.magicinfo.mp", new Object[]{this.enumMagic.getMP()}));
    	p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{needLv}));
    	p_77624_3_.add(I18n.format("dqm.magicinfo.usefulJob", new Object[]{usefulJob[0]}));
    	if(usefulLine > 0)
    	{
    		for(int lCnt = 0; lCnt < usefulLine; lCnt++)
    		{
    			p_77624_3_.add(I18n.format("dqm.magicinfo.usefulJobSPC", new Object[]{usefulJob[lCnt + 1]}));
    		}
    	}

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.attackdamage", new Object[]{dam}));

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

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, World par2World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        return true;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }
}
