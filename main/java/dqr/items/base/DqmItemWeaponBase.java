package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmElement;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMobRoot;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.potion.DQPotionMinus;
import dqr.blocks.base.DqmBlockOreBase;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterDay.DqmMobBaseDay;
import dqr.entity.mobEntity.monsterEnd.DqmMobBaseEnd;
import dqr.entity.mobEntity.monsterHell.DqmMobBaseHell;
import dqr.entity.mobEntity.monsterNight.DqmMobBaseNight;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemWeaponBase extends Item{
	protected float efficiencyOnProperMaterial = 4.0F;
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;
    private static final String __OBFID = "CL_00000072";
    private float maxAttackDam;

    private int mode;
    private static final Set hammerTable = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
    private static final Set axeTable = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    private static final Set clawTable = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public DqmItemWeaponBase(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage)
    {
        this.field_150933_b = p_i45356_1_;
        this.maxStackSize = 1;
        this.setMaxDamage(maxDamage);
        this.efficiencyOnProperMaterial = p_i45356_1_.getEfficiencyOnProperMaterial();
        //this.setCreativeTab(CreativeTabs.tabCombat);
        this.field_150934_a = attackDam;
        this.maxAttackDam = attackDam;
        this.mode = 0;
    }

    public DqmItemWeaponBase setEfficiencyOnProper(float par1)
    {
    	efficiencyOnProperMaterial = par1;
    	return this;
    }

    public float func_150931_i()
    {
        //return this.field_150933_b.getDamageVsEntity();
    	return this.field_150934_a;
    }

    public EnumDqmElement getElement()
    {
    	if(this == DQWeapons.itemInazumanoyari)
    	{
    		return EnumDqmElement.KAMINARI;
    	}else if(this == DQWeapons.itemSaramanda)
    	{
    		return EnumDqmElement.HONOO;
    	}else if(this == DQWeapons.itemReiniroddo)
    	{
    		return EnumDqmElement.KOORI;
    	}else if(this == DQWeapons.itemDaitinokanaduti)
    	{
    		return EnumDqmElement.DAITI;
    	}else if(this == DQWeapons.itemFubukinoono)
    	{
    		return EnumDqmElement.KOORI;
    	}else if(this == DQWeapons.itemKamenoougi)
    	{
    		return EnumDqmElement.DAITI;
    	}else if(this == DQWeapons.itemTorinoougi)
    	{
    		return EnumDqmElement.HONOO;
    	}else if(this == DQWeapons.itemNekonoougi)
    	{
    		return EnumDqmElement.KOORI;
    	}else if(this == DQWeapons.itemHebinoougi)
    	{
    		return EnumDqmElement.KAMINARI;
    	}else if(this == DQWeapons.itemKoorinobumeran)
    	{
    		return EnumDqmElement.KOORI;
    	}else if(this == DQWeapons.itemMeteoejji)
    	{
    		return EnumDqmElement.KAMINARI;
    	}

    	return null;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

    	//System.out.println("TEST:" + this.getUnlocalizedName());
    	int itemMode2 = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_ITEMUSE.getId());
    	float pitch = 1.2F;
		if(DQR.spUseItems.specialUseItems.containsKey(par1ItemStack.getItem()) && itemMode2 == 1)
		{

			//System.out.println("TEST2");
			boolean flg = false;
			if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
			{
		  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
	    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

				return par1ItemStack;
			}

			if(!DQR.spUseItems.specialUseItems.containsKey(par1ItemStack.getItem()))
			{
				return par1ItemStack;
			}

			EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(this.getMaterial().name());

			if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(par3EntityPlayer).getJob(),
											  enumWeapon.getId(),
											  par3EntityPlayer) < 1 && DQR.debug == 0)
			{
				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.weaponNoAppti.txt",new Object[] {}));
	    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return par1ItemStack;
			}


			if(par1ItemStack.getItemDamage() >= par1ItemStack.getMaxDamage() / 5 * 4 + 1)
			{
				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.weaponNoEnergy.txt",new Object[] {}));
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return par1ItemStack;
			}

			if(!par2World.isRemote)
			{
				//System.out.println("TEST3");
				EnumDqmMagic enumMagic = null;
				if(par1ItemStack.getItem() == DQWeapons.itemOujanoturugi)
				{
					//王者の剣：バギクロス
					flg = true;
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Bagikurosu;
					//バギクロス
					MagicEntityBagi[] magic = null;
					magic = new MagicEntityBagi[5];
					magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
					magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
					magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
					magic[3] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
					magic[4] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
					for(int cnt = 0;cnt < 5; cnt++)
					{
						magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
					}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

					//attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

					/*
					if(enumMagic.getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
					{
						par1ItemStack.damageItem(enumMagic.getDamage(), par3EntityPlayer);
					}else
					{
						par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
					}
					*/

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{

			        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemTenkuunoturugi)
				{
					flg = true;
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);
					//System.out.println("TEST3");
					par3EntityPlayer.clearActivePotions();
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.itetuku", 1.0F, 1.0F);

					//天空の剣：いてつく波動
					 List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
			            		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

		            if (list != null && !list.isEmpty())
		            {
		            	for (int n = 0 ; n < list.size() ; n++)
		            	{
		            		Entity target = (Entity)list.get(n);

		            		if(target instanceof EntityLivingBase)
		            		{
		            			((EntityLivingBase)target).clearActivePotions();
		            			target.worldObj.playSoundAtEntity(target, "dqr:player.itetuku", 1.0F, 1.0F);
		            		}
		            	}
		            }
				}else if(par1ItemStack.getItem() == DQWeapons.itemKoorinoyaiba)
				{
					//氷の刃：ヒャダルコ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Hyadaruko;

					MagicEntityHyado[] magic = new MagicEntityHyado[3];
	    			for(int cnt = 0;cnt < 3; cnt++)
	    			{
	    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
	    				magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
	    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(1);
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

					//attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{
			        		//magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemHajanoturugi)
				{
					//破邪のつるぎ：ギラ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Gira;

					MagicEntity[] magic = new MagicEntity[3];
	    			for(int cnt = 0;cnt < 3; cnt++)
	    			{
	    				magic[cnt] = new MagicEntityMera(par2World, par3EntityPlayer, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

					//attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{
			        		//magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemInferunosword)
				{
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Io;
					//インフェルノソード：イオ
					MagicEntityIo[] magic = new MagicEntityIo[8];
	    			for(int cnt = 0;cnt < 8; cnt++)
	    			{
	    				magic[cnt] = new MagicEntityIo(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-135.0F + (45.0F * cnt)), 0.0F);
	    				magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

	        		for(int cnt = 0; cnt < magic.length; cnt++)
	        		{
	    				magic[cnt].setDamage(attackDam);
	    	        	if (!par2World.isRemote)
	    	        	{
	    	        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
	    	        		par2World.spawnEntityInWorld(magic[cnt]);

	    	        	}
	        		}

				}else if(par1ItemStack.getItem() == DQWeapons.itemMinagorosinoken)
				{
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Rukanan;
					Potion pot = DQPotionMinus.debuffRukani;

					//みなごろしの剣：ルカナン
					List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
		            		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

		            if (list != null && !list.isEmpty())
		            {
		            	for (int n = 0 ; n < list.size() ; n++)
		            	{
		            		Entity target = (Entity)list.get(n);

		            		if (!(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
		            		{
		            			Random rand = new Random();
		            			if(target instanceof EntityLivingBase)
		            			{
			            			if(rand.nextInt(100) < enumMagic.getRate())
			            			{
				            			EntityLivingBase elb = (EntityLivingBase)target;
			            				elb.addPotionEffect(new PotionEffect(pot.id, enumMagic.getAttack(), 0));
			            				elb.worldObj.playSoundAtEntity(elb, "dqr:player.down", 1.0F, 1.0F);
			            			}
		            			}
		            		}
		            	}
		            }
				}else if(par1ItemStack.getItem() == DQWeapons.itemHonoonotume)
				{
					//ほのおの爪：ベギラマ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Begirama;

					MagicEntity[] magic = new MagicEntity[5];
	    			for(int cnt = 0;cnt < 5; cnt++)
	    			{
	    				magic[cnt] = new MagicEntityMera(par2World, par3EntityPlayer, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

					//attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{
			        		//magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemKoorinotume)
				{
					//氷の爪：ヒャダルコ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Hyadaruko;

					MagicEntityHyado[] magic = new MagicEntityHyado[3];
	    			for(int cnt = 0;cnt < 3; cnt++)
	    			{
	    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
	    				magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
	    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(1);
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

					//attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{
			        		//magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemGureitoakusu)
				{
					//グレートアックス：バギマ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Bagima;

					MagicEntityBagi[] magic = null;
					magic = new MagicEntityBagi[3];
	    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			for(int cnt = 0;cnt < 3; cnt++)
	    			{
	    				magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = 50;

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{

			        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}else if(par1ItemStack.getItem() == DQWeapons.itemSeiginosoroban)
				{
					//正義の算盤：ニフラム
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					//enumMagic = EnumDqmMagic.Rukanan;
					//Potion pot = DQPotionMinus.debuffRukani;

					List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
		            		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(6.0D, 5.0D, 6.0D));

		            if (list != null && !list.isEmpty())
		            {
		            	for (int n = 0 ; n < list.size() ; n++)
		            	{
		            		Entity target = (Entity)list.get(n);

		            		if (!(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
		            		{
		            			Random rand = new Random();
		            			if(target instanceof EntityLivingBase)
		            			{
		            				if(target instanceof DqmMobBase)
		            				{
		            					DqmMobBase mob = (DqmMobBase)target;
		            					if(mob instanceof DqmMobBaseDay ||
		            					   mob instanceof DqmMobBaseNight ||
		            					   mob instanceof DqmMobBaseHell ||
		            					   mob instanceof DqmMobBaseEnd)
		            					{
			            					if(mob.MobRoot.getId() == EnumDqmMobRoot.UNDEAD.getId())
			            					{
			            						if(rand.nextInt(2) == 0)
						            			{
							            			EntityLivingBase elb = (EntityLivingBase)target;
							            			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.causeNihuramu.txt",new Object[] {elb.getCommandSenderName()}));
							            			//elb.playSound("dqr:player.kenja", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
							            			elb.worldObj.playSoundAtEntity(elb, "dqr:player.kenja", 1.0F, 1.0F);
						            				elb.setDead();
						            			}
			            					}else
			            					{
			            						if(rand.nextInt(100) < 5)
						            			{
							            			EntityLivingBase elb = (EntityLivingBase)target;
							            			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.causeNihuramu.txt",new Object[] {elb.getCommandSenderName()}));
							            			//elb.playSound("dqr:player.kenja", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
							            			elb.worldObj.playSoundAtEntity(elb, "dqr:player.kenja", 1.0F, 1.0F);
						            				elb.setDead();
						            			}
			            					}
		            					}
		            				}else if(target instanceof EntityZombie || target instanceof EntitySkeleton)
		            				{
	            						if(rand.nextInt(2) == 0)
				            			{
					            			EntityLivingBase elb = (EntityLivingBase)target;
					            			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.causeNihuramu.txt",new Object[] {elb.getCommandSenderName()}));
					            			//elb.playSound("dqr:player.kenja", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
					            			elb.worldObj.playSoundAtEntity(elb, "dqr:player.kenja", 1.0F, 1.0F);
				            				elb.setDead();
				            			}
		            				}else
		            				{
				            			if(rand.nextInt(100) < 5)
				            			{
					            			EntityLivingBase elb = (EntityLivingBase)target;
					            			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.causeNihuramu.txt",new Object[] {elb.getCommandSenderName()}));
					            			//elb.playSound("dqr:player.kenja", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
					            			elb.worldObj.playSoundAtEntity(elb, "dqr:player.kenja", 1.0F, 1.0F);
				            				elb.setDead();
				            			}
		            				}
		            			}
		            		}
		            	}
		            }


				}else if(par1ItemStack.getItem() == DQWeapons.itemMahounosoroban)
				{
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					//魔法のそろばん：所持金表示
					int gold = ExtendedPlayerProperties.get(par3EntityPlayer).getGold();
					DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.weapon.specialEffect.mahounosoroban.txt",new Object[] {gold}));

				}else if(par1ItemStack.getItem() == DQWeapons.itemReppuunoougi)
				{
					//烈風の扇：バギ
					flg = true;
					//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 2.0F);
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, pitch);

					enumMagic = EnumDqmMagic.Bagikurosu;

					MagicEntityBagi[] magic = null;
					magic = new MagicEntityBagi[3];
	    			magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    			for(int cnt = 0;cnt < 3; cnt++)
	    			{
	    				magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
	    			}

					int matk = enumMagic.getAttack();
					int attackDam = matk;

		    		for(int cnt = 0; cnt < magic.length; cnt++)
		    		{
						magic[cnt].setDamage(attackDam);
			        	if (!par2World.isRemote)
			        	{

			        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
			        		par2World.spawnEntityInWorld(magic[cnt]);

			        	}
		    		}
				}

				if(flg)
				{
					par1ItemStack.damageItem(par1ItemStack.getItem().getMaxDamage() / 20, par3EntityPlayer);

					if(par1ItemStack.getItemDamage() >= par1ItemStack.getMaxDamage())
					{
						par1ItemStack.stackSize--;
					}
				}
			}

		}else
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}

    	return par1ItemStack;
    }
/*

	public ItemStack onItemSpecialUse(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		boolean flg = false;
		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(!DQR.spUseItems.specialUseItems.containsKey(par1ItemStack.getItem()))
		{
			return par1ItemStack;
		}

		EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(this.getMaterial().name());

		if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(par3EntityPlayer).getJob(),
										  enumWeapon.getId(),
										  par3EntityPlayer) < 1 && DQR.debug == 0)
		{
			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.weaponNoAppti.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
			return par1ItemStack;
		}

		if(!par2World.isRemote)
		{
			EnumDqmMagic enumMagic = null;
			if(par1ItemStack.getItem() == DQWeapons.itemOujanoturugi)
			{
				flg = true;

				enumMagic = EnumDqmMagic.Bagikurosu;
				//バギクロス
				MagicEntityBagi[] magic = null;
				magic = new MagicEntityBagi[5];
				magic[0] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
				magic[1] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
				magic[2] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
				magic[3] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
				magic[4] = new MagicEntityBagi(par2World, par3EntityPlayer, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
				for(int cnt = 0;cnt < 5; cnt++)
				{
					magic[cnt].setMaxTicksRange(enumMagic.getTickRange());
				}

				int matk = enumMagic.getAttack();
				int attackDam = matk;

				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);


				if(enumMagic.getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
				{
					par1ItemStack.damageItem(enumMagic.getDamage(), par3EntityPlayer);
				}else
				{
					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
				}


	    		for(int cnt = 0; cnt < magic.length; cnt++)
	    		{
					magic[cnt].setDamage(attackDam);
		        	if (!par2World.isRemote)
		        	{

		        		magic[cnt].setWorldFlg(par3EntityPlayer.isSneaking());
		        		par2World.spawnEntityInWorld(magic[cnt]);

		        	}
	    		}
			}
		}

		if(flg)
		{
			par1ItemStack.damageItem(par1ItemStack.getItem().getMaxDamage() / 20, par3EntityPlayer);

			//System.out.println("TEST2;" + par1ItemStack.getItem().getMaxDamage() / 20);
			if(par1ItemStack.getItemDamage() >= par1ItemStack.getMaxDamage())
			{
				par1ItemStack.stackSize--;
			}
		}
		return par1ItemStack;
    }
*/
    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {
    	//if(!var2.isRemote)
    	//{
    		if(var3 instanceof EntityPlayer)
    		{
    			EntityPlayer ep = (EntityPlayer)var3;
    			int idx = 0;
    			if(this.field_150933_b == DQR.dqmMaterial.DqmAxe)
    			{
    				idx = 1;
    			}else if(this.field_150933_b == DQR.dqmMaterial.DqmHammer0 || this.field_150933_b == DQR.dqmMaterial.DqmHammer1 || this.field_150933_b == DQR.dqmMaterial.DqmHammer2 || this.field_150933_b == DQR.dqmMaterial.DqmHammer3)
    			{
    				idx = 2;
    			}else if(this.field_150933_b == DQR.dqmMaterial.DqmClaw)
    			{
    				idx = 3;
    			}

    			int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(idx);

    			if(idx > 0)
    			{
    				NBTTagCompound nbt = var1.getTagCompound();
    				if(nbt == null)
    				{
    					nbt = new NBTTagCompound();
    				}

					nbt.setInteger("itemMode", itemMode);
					var1.setTagCompound(nbt);
					//System.out.println("test:" + itemMode);
    			}

    		}
    		/*
	    	int maxDam = var1.getMaxDamage();
	    	int calDam = maxDam - var1.getItemDamage();
	    	int perDam = calDam * 1000 / maxDam;

	    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);

	    	if(perDam < 800 && this.getMaterial() != DQR.dqmMaterial.DqmFist)
	    	{
	    		field_150934_a = maxAttackDam *  (perDam + 100) / 1000;
	    	}else
	    	{
	    		field_150934_a = maxAttackDam;
	    	}
			*/
	    	//System.out.println("DEBUGLINE:");
	    	//field_150934_a = maxAttackDam;
    	//}
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
    	Material material = p_150893_2_.getMaterial();

        if (p_150893_2_ == Blocks.web)
        {
            return 15.0F;
        }
        else
        {
        	int itemMode = -1;
        	//System.out.println("test3:" + itemMode);
        	NBTTagCompound nbt = p_150893_1_.getTagCompound();

        	if(nbt != null)
        	{
        		itemMode = nbt.getInteger("itemMode");
				//System.out.println("test2:" + itemMode);
        	}

        	if((this.field_150933_b == DQR.dqmMaterial.DqmAxe || this == DQWeapons.itemHaruberuto) && itemMode > -1)
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
        	}else if(itemMode > -1 && (this.field_150933_b == DQR.dqmMaterial.DqmHammer0 || this.field_150933_b == DQR.dqmMaterial.DqmHammer1 || this.field_150933_b == DQR.dqmMaterial.DqmHammer2 || this.field_150933_b == DQR.dqmMaterial.DqmHammer3))
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
        	}else if(this.field_150933_b == DQR.dqmMaterial.DqmClaw && itemMode > -1)
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

        return 1.0F;
        //return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
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

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {

        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {
            p_150894_1_.damageItem(2, p_150894_7_);
        }

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
    	//return EnumAction.none;
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
    /*
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
    */

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
    @Override
    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {

        return this.field_150933_b.func_150995_f() == p_82789_2_.getItem() ? true : super.getIsRepairable(p_82789_1_, p_82789_2_);
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

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.attackdamage", new Object[]{dam}));

    	if(this.getElement() != null)
    	{
    		EnumDqmElement element = this.getElement();
    		p_77624_3_.add(element.getColor() + I18n.format("dqm.iteminfo.weapon.element." + element.getKey() + ".txt", new Object[]{}));
    	}


    	int[] apptitudeTable = DQR.aptitudeTable.getWAptitudeTable(this);
    	String[] usefulJob = new String[32];
    	String[] usefulJob2 = new String[32];
    	int usefulCnt = 0;
    	int usefulLine = 0;

    	int usefulCnt2 = 0;
    	int usefulLine2 = 0;

    	if(this == DQWeapons.itemBsword1 || this == DQWeapons.itemBsword2 || this == DQWeapons.itemBsword3 ||
    	   this == DQWeapons.itemBsword4 || this == DQWeapons.itemBsword5)
    	{
    		p_77624_3_.add(I18n.format("dqm.iteminfo.weaponappti3", new Object[]{}));
    	}else
    	{
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
    	}

    	if(DQR.spUseItems.specialUseItems.containsKey(this))
    	{
    		String key = this.getUnlocalizedName().replace("item.dqm.", "");

    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.weapon." + key + ".txt", new Object[]{}));
    		p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.weapon.base.txt", new Object[]{}));
    		p_77624_3_.add("");
    	}


    	if(this.field_150933_b == DQR.dqmMaterial.DqmAxe || this == DQWeapons.itemHaruberuto)
    	{
    		p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.iteminfo.weapon.toolmode.axe.txt", new Object[]{}));
    		p_77624_3_.add("");
    	}
    	if(this.field_150933_b == DQR.dqmMaterial.DqmHammer0 || this.field_150933_b == DQR.dqmMaterial.DqmHammer1 ||
    	   this.field_150933_b == DQR.dqmMaterial.DqmHammer2 || this.field_150933_b == DQR.dqmMaterial.DqmHammer3)
    	{
    		p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.iteminfo.weapon.toolmode.pickaxe.txt", new Object[]{}));
    		p_77624_3_.add("");
    	}
    	if(this.field_150933_b == DQR.dqmMaterial.DqmClaw)
    	{
    		p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.iteminfo.weapon.toolmode.shovel.txt", new Object[]{}));
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

    		int itemPrice = nbt.getInteger("ItemPrice");
    		itemPrice = DQR.calcPlayerStatus.calcShoninGold(itemPrice, p_77624_2_);
    		//System.out.println("TEST:" + medalVal);
    		if(itemPrice > 0)
    		{

        		String itmPrice = I18n.format("msg.itemprice.item.txt", new Object[]{nfNum.format(itemPrice)});

    			p_77624_3_.add(itmPrice);
    		}
    	}

    	NBTTagList tag = p_77624_1_.getEnchantmentTagList();
		if(tag != null)
		{
			p_77624_3_.add("");
		}
    }
}
