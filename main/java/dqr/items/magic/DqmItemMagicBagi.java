package dqr.items.magic;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicBagi extends DqmItemMagicBase{
	//protected float efficiencyOnProperMaterial = 4.0F;
    //private float field_150934_a;
    //private final Item.ToolMaterial field_150933_b;
    private static final String __OBFID = "CL_00000072";
    //private float maxAttackDam;
    //private EnumDqmMagic enumMagic;
    //private int magicDam;

    private int mode;
    //private static final Set hammerTable = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
    //private static final Set axeTable = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    //private static final Set clawTable = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public DqmItemMagicBagi(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

        //this.field_150933_b = p_i45356_1_;
        //this.maxStackSize = 1;
        //this.setMaxDamage(maxDamage);
        //this.efficiencyOnProperMaterial = p_i45356_1_.getEfficiencyOnProperMaterial();
        //this.field_150934_a = attackDam;
        //this.maxAttackDam = attackDam;
        //this.mode = 0;
        //this.magicDam = magicDam;

    }

    /*
    public DqmItemMagicBagi setEfficiencyOnProper(float par1)
    {
    	efficiencyOnProperMaterial = par1;
    	return this;
    }

    public float func_150931_i()
    {
        //return this.field_150933_b.getDamageVsEntity();
    	return this.field_150934_a;
    }
    */

    /*
    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {

    	if(var1.getItemDamage() < 0)
    	{

    	}else if(var1.getItemDamage() > 0)
    	{
    		var1.setItemDamage(var1.getItemDamage() - 2);
    	}
    }
    */

    /*
    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	Material material = p_150893_2_.getMaterial();


        return 1.0F;

        //return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
    }
    */

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    /*
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {

        return true;
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {

        return true;
    }
    */

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    /*
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
    */
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		PotionEffect pe;
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}
		//pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && par3EntityPlayer.worldObj.isRemote)
		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

    	if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
    	{
    		//int[] magicParam = DQR.magicTable.getMagicParam(this);
    		MagicEntityBagi[] magic = null;

        	/*
        	int minusMP = 0;
        	int minusDam = 0;
        	int needLvS = 0;
        	int needLvK = 100;
        	int hitCnt = 0;
			*/
    		if(par1ItemStack.getItem() == DQMagics.itemBagi)
    		{
    			magic = new MagicEntityBagi[3];
    			//for(int cnt = 0;cnt < 1; cnt++)
    			//{
    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			//}
    			/*
    	   		minusMP = 3;
    	   		minusDam = 100;
    	   		needLvS = 11;
    	   		//needLvK = 8;
    	   		 */

    		}else if(par1ItemStack.getItem() == DQMagics.itemBagima)
    		{
    			magic = new MagicEntityBagi[3];
    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			/*
    	   		minusMP = 6;
    	   		minusDam = 150;
    	   		needLvS = 22;
    	   		//needLvK = 18;
				*/
    		}else if(par1ItemStack.getItem() == DQMagics.itemBagikurosu)
    		{
    			magic = new MagicEntityBagi[5];
    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[3] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
    			magic[4] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
    			for(int cnt = 0;cnt < 5; cnt++)
    			{
    				magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}

    			/*
    	   		minusMP = 12;
    	   		minusDam = 200;
    	   		needLvS = 38;
    	   		//needLvK = 31;
				*/
    		}else if(par1ItemStack.getItem() == DQMagics.itemBagimutyo)
    		{
    			magic = new MagicEntityBagi[5];
    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			magic[3] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
    			magic[4] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
    			for(int cnt = 0;cnt < 5; cnt++)
    			{
    				magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			/*
    	   		minusMP = 21;
    	   		minusDam = 300;
    	   		needLvS = 63;
    	   		*/
    	   		//needLvK = 58;

    		}



    		if(magic != null)
    		{
    			int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();
    			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
    			{
    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    			}else
    			{
	    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
	    			{
	    				//int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
	    				//		        / par1ItemStack.getMaxDamage() *  this.getEnumMagic().getAttack() / 100;
	    				int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
	    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
						        / par1ItemStack.getMaxDamage() *  matk / 100;

	    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
	    				if(this.getEnumMagic().getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
	    				{
	    					par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
	    				}else
	    				{
	    					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
	    				}

	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
    	        		for(int cnt = 0; cnt < magic.length; cnt++)
    	        		{
		    				magic[cnt].setDamage(attackDam);
		    	        	if (!par2World.isRemote)
		    	        	{

		    	        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
		    	        		par2World.spawnEntityInWorld(magic[cnt]);

		    	        	}
    	        		}
	    			}else
	    			{
	    				magic = null;
	    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
    			}
    		}
    	}else
    	{
    		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	}


        return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.bagi.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}
    }

    /*
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


    public int getItemEnchantability()
    {
        return this.field_150933_b.getEnchantability();
    }


    public String getToolMaterialName()
    {
        return this.field_150933_b.toString();
    }

    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
    	return false;
    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
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

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.attackdamage", new Object[]{dam}));
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, World par2World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        return true;
    }
    */
}
