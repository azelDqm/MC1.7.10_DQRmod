package dqr.potion;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.enums.EnumStat;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmPotionBase extends Potion {

	public int icon_x;
	public int icon_y;
	public int statusIconIndex = -1;
	private double effectiveness;

	public DqmPotionBase(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
		super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon()
    {

        return this.statusIconIndex >= 0;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex()
    {
        return this.statusIconIndex;
    }


	@Override
    protected DqmPotionBase setIconIndex(int p_76399_1_, int p_76399_2_)
    {
        this.statusIconIndex = p_76399_1_ + p_76399_2_ * 8;
        return this;
    }


	@Override
    public DqmPotionBase setEffectiveness(double p_76404_1_)
    {
        this.effectiveness = p_76404_1_;
        return this;
    }

    public double getEffectiveness()
    {
        return this.effectiveness;
    }

	public DqmPotionBase setIconIndex2(int par1, int par2)
	{
		icon_x = par1 * 18;
		icon_y = par2 * 18;

		return this;
	}


    public void performEffect2(EntityLivingBase p_76394_1_, int p_76394_2_)
    {
		//System.out.println("TESPotionTEST");
		//DQR.func.debugString("PotionTest0");
		if(p_76394_1_.isDead) return;
		//DQR.func.debugString("PotionTest4");
		if(this.id == DQPotionPlus.potionDokukesisou.getId())
		{

			p_76394_1_.removePotionEffect(DQPotionMinus.potionPoison.id);
			p_76394_1_.removePotionEffect(Potion.poison.id);

			if(p_76394_2_ >= 1)p_76394_1_.removePotionEffect(Potion.wither.id);
			if(p_76394_2_ >= 2)p_76394_1_.removePotionEffect(DQPotionMinus.potionPoisonX.id);

		}else if(this.id == DQPotionPlus.potionMahounomi.getId() || this.getId() == DQPotionPlus.buffMPRegeneration.getId())
		{
			if(p_76394_1_ instanceof EntityPlayer)
			{
				EntityPlayer ep = (EntityPlayer)p_76394_1_;
				int mp = ExtendedPlayerProperties.get(ep).getMP();
				//DQR.func.debugString("PotionTest1");
				if(ExtendedPlayerProperties.get(ep).getMaxMP() < mp + (1 + (p_76394_2_ * 2)))
				{
					//DQR.func.debugString("PotionTest2");
    				ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
				}else
				{
					//DQR.func.debugString("PotionTest3");
					ExtendedPlayerProperties.get(ep).setMP(mp + (1 + (p_76394_2_ * 2)));
    			}
			}else if(p_76394_1_ instanceof DqmPetBase)
			{
				DqmPetBase pet = (DqmPetBase)p_76394_1_;
				int mp = pet.getMP();
				if(pet.getMaxMP() < mp + (1 + (p_76394_2_ * 2)))
				{
					pet.setMP(pet.getMaxMP());;
				}else
				{
					pet.setMP(mp + (1 + (p_76394_2_ * 2)));
				}
			}else if(p_76394_1_ instanceof DqmMobBase)
			{
				DqmMobBase pet = (DqmMobBase)p_76394_1_;
				int mp = pet.DqmMobMP;
				if(pet.DqmMobMaxMP < mp + (1 + (p_76394_2_ * 2)))
				{
					pet.DqmMobMP = pet.DqmMobMaxMP;
				}else
				{
					pet.DqmMobMP = mp + (1 + (p_76394_2_ * 2));
				}
			}else
			{

			}
		}else if(this.id == DQPotionMinus.potionPoison.getId())
		{
			if((p_76394_1_.getHealth() - ((p_76394_2_ + 1) * 2)) > 1)
			{
				p_76394_1_.attackEntityFrom(DQR.damageSource.DqmPoison, ((p_76394_2_ + 1) * 2));
			}
			/*else if(p_76394_1_.getHealth() != 1)
			{
				p_76394_1_.attackEntityFrom(DQR.damageSource.DqmPoison, (p_76394_1_.getHealth() - 1));
			}
			*/
		}else if(this.id == DQPotionMinus.potionPoisonX.getId())
		{
			if((p_76394_1_.getHealth() - ((p_76394_2_ + 1) * 2)) > 1)
			{
				p_76394_1_.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((p_76394_2_ + 1) * 2));
			}
		}else if(this.id == DQPotionPlus.potionIyasinomi.getId() || this.id == DQPotionPlus.buffHPRegeneration.getId())
		{
			if(p_76394_1_.getMaxHealth() < p_76394_1_.getHealth() + 1.0F + (p_76394_2_ * 2))
			{
				p_76394_1_.setHealth(p_76394_1_.getMaxHealth());
			}else
			{
				//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
				p_76394_1_.heal(1.0F + (p_76394_2_ * 2));
			}
		}else if(this.id == DQPotionPlus.potionOugonnomi.getId() && p_76394_2_ >= 3)
		{
			if(p_76394_1_.getMaxHealth() < p_76394_1_.getHealth() + 1.0F + (p_76394_2_ * 10))
			{
				p_76394_1_.setHealth(p_76394_1_.getMaxHealth());
			}else
			{
				//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
				p_76394_1_.heal(1.0F + (p_76394_2_ * 10));
			}

			Random rand = new Random();
			if(rand.nextInt(2)== 0)
			{
				if(p_76394_1_ instanceof EntityPlayer)
				{
					EntityPlayer ep = (EntityPlayer)p_76394_1_;
					int mp = ExtendedPlayerProperties.get(ep).getMP();
					if(ExtendedPlayerProperties.get(ep).getMaxMP() < mp + (1 + (p_76394_2_ * 5)))
					{
	    				ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
					}else
					{
						ExtendedPlayerProperties.get(ep).setMP(mp + (1 + (p_76394_2_ * 5)));
	    			}
				}else if(p_76394_1_ instanceof DqmPetBase)
				{
					DqmPetBase pet = (DqmPetBase)p_76394_1_;
					int mp = pet.getMP();
					if(pet.getMaxMP() < mp + (1 + (p_76394_2_ * 2)))
					{
						pet.setMP(pet.getMaxMP());;
					}else
					{
						pet.setMP(mp + (1 + (p_76394_2_ * 2)));
					}
				}else if(p_76394_1_ instanceof DqmMobBase)
				{
					DqmMobBase pet = (DqmMobBase)p_76394_1_;
					int mp = pet.DqmMobMP;
					if(pet.DqmMobMaxMP < mp + (1 + (p_76394_2_ * 2)))
					{
						pet.DqmMobMP = pet.DqmMobMaxMP;
					}else
					{
						pet.DqmMobMP = mp + (1 + (p_76394_2_ * 2));
					}
				}
			}

		}
    }

	@Override
    public boolean isReady(int p_76397_1_, int p_76397_2_)
    {

		/*
		if(DQR.debugSwitch == 0){

		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		System.out.print("StackTrace : \n");
		for (StackTraceElement stackTraceElement : stackTraceElements)
		{
		    System.out.print(" " + stackTraceElement.toString() + "\n");
		}
		}
		*/

    	boolean ret = p_76397_1_ % 20 == 0;

    	//DQR.func.debugString("PotionTest5");
    	if(this.id == DQPotionMinus.potionPoisonX.getId())
    	{
    		ret = p_76397_1_ % 10 == 0;
    	}else if(this.id == DQPotionPlus.potionIyasinomi.getId() || this.id == DQPotionPlus.buffHPRegeneration.getId())
    	{
    		ret = p_76397_1_ % 10 == 0;
    	}else if(this.id == DQPotionPlus.potionMahounomi.getId() || this.id == DQPotionPlus.buffMPRegeneration.getId())
    	{
    		ret = p_76397_1_ % 20 == 0;
    		//ret = true;
    	}else if(this.id == DQPotionPlus.potionOugonnomi.getId())
    	{
    		ret = p_76397_1_ % 10 == 0;
    	}

    	//DQR.func.debugString("PotionTest6 : " + ret);
		return ret;
    }

	@Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase p_111187_1_, BaseAttributeMap p_111187_2_, int amplifier)
    {
		//ポーション効果が消える時の処理


        Iterator iterator = this.func_111186_k().entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            IAttributeInstance iattributeinstance = p_111187_2_.getAttributeInstance((IAttribute)entry.getKey());

            if (iattributeinstance != null)
            {
                iattributeinstance.removeModifier((AttributeModifier)entry.getValue());
            }
        }

        //System.out.println("TEST OFF : " + this.getId() + " / " + this.getName());
        if(p_111187_1_ instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)p_111187_1_;
	        if(this.id == DQPotionPlus.potionMamorinotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.seed.getId(), 0);
	        }else if(this.id == DQPotionPlus.potionTikaranotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionSubayasanotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.buffPiora.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.buffPiora.getId(), 0);
	        }
	        if(this.id == DQPotionMinus.debuffBomie.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.debuffBomie.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionMaryokunotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionOugonnomi.getId())
	        {
				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.ougon.getId(), 0);
				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), 0);
				ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.ougon.getId(), 0);
	        }
        }else if(p_111187_1_ instanceof DqmPetBase)
        {
        	DqmPetBase pet = (DqmPetBase)p_111187_1_;
	        if(this.id == DQPotionPlus.potionMamorinotane.getId())
	        {
	        	pet.setArrayMamori(EnumStat.seed.getId(), 0);
	        }else if(this.id == DQPotionPlus.potionTikaranotane.getId())
	        {
	        	pet.setArrayTikara(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionSubayasanotane.getId())
	        {
	        	pet.setArraySubayasa(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.buffPiora.getId())
	        {
	        	pet.setArraySubayasa(EnumStat.buffPiora.getId(), 0);
	        }
	        if(this.id == DQPotionMinus.debuffBomie.getId())
	        {
	        	pet.setArrayMamori(EnumStat.debuffBomie.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionMaryokunotane.getId())
	        {
	        	pet.setArrayKasikosa(EnumStat.seed.getId(), 0);
	        }
	        if(this.id == DQPotionPlus.potionOugonnomi.getId())
	        {
				pet.setArrayMamori(EnumStat.ougon.getId(), 0);
				pet.setArrayTikara(EnumStat.ougon.getId(), 0);
				pet.setArrayKasikosa(EnumStat.ougon.getId(), 0);
	        }
        }
    }

	@Override
    public void applyAttributesModifiersToEntity(EntityLivingBase p_111185_1_, BaseAttributeMap p_111185_2_, int amplifier)
    {
        Iterator iterator = this.func_111186_k().entrySet().iterator();
        //System.out.println("TEST ON : " + this.getId() + " / " + this.getName());
        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            IAttributeInstance iattributeinstance = p_111185_2_.getAttributeInstance((IAttribute)entry.getKey());

            if (iattributeinstance != null)
            {
                AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
                iattributeinstance.removeModifier(attributemodifier);
                iattributeinstance.applyModifier(new AttributeModifier(attributemodifier.getID(), this.getName() + " " + amplifier, this.func_111183_a(amplifier, attributemodifier), attributemodifier.getOperation()));
            }
        }
      //ポーションを使用した時の処理
        if(p_111185_1_ instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)p_111185_1_;
	        if(this.id == DQPotionPlus.potionMamorinotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }else if(this.id == DQPotionPlus.potionTikaranotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }
	        if(this.id == DQPotionPlus.potionSubayasanotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.seed.getId(), (amplifier + 1) * 10);
	        }
	        if(this.id == DQPotionPlus.buffPiora.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.buffPiora.getId(), (amplifier + 1) * 15);
	        }
	        if(this.id == DQPotionMinus.debuffBomie.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.debuffBomie.getId(), ((amplifier + 1) * 15) * -1);
	        }
	        if(this.id == DQPotionPlus.potionMaryokunotane.getId())
	        {
	        	ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }
	        if(this.id == DQPotionPlus.potionOugonnomi.getId())
	        {
				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.ougon.getId(), (amplifier + 1) * 3);
				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), (amplifier + 1) * 3);
				ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.ougon.getId(), (amplifier + 1) * 3);
	        }
        }else if(p_111185_1_ instanceof DqmPetBase)
        {
        	DqmPetBase pet = (DqmPetBase)p_111185_1_;
	        if(this.id == DQPotionPlus.potionMamorinotane.getId())
	        {
	        	pet.setArrayMamori(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }else if(this.id == DQPotionPlus.potionTikaranotane.getId())
	        {
	        	pet.setArrayTikara(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }
	        if(this.id == DQPotionPlus.potionSubayasanotane.getId())
	        {
	        	pet.setArraySubayasa(EnumStat.seed.getId(), (amplifier + 1) * 10);
	        }
	        if(this.id == DQPotionPlus.buffPiora.getId())
	        {
	        	pet.setArraySubayasa(EnumStat.buffPiora.getId(), (amplifier + 1) * 15);
	        }
	        if(this.id == DQPotionMinus.debuffBomie.getId())
	        {
	        	pet.setArrayMamori(EnumStat.debuffBomie.getId(), ((amplifier + 1) * 15) * -1);
	        }
	        if(this.id == DQPotionPlus.potionMaryokunotane.getId())
	        {
	        	pet.setArrayKasikosa(EnumStat.seed.getId(), (amplifier + 1) * 5);
	        }
	        if(this.id == DQPotionPlus.potionOugonnomi.getId())
	        {
				pet.setArrayMamori(EnumStat.ougon.getId(), (amplifier + 1) * 3);
				pet.setArrayTikara(EnumStat.ougon.getId(), (amplifier + 1) * 3);
				pet.setArrayKasikosa(EnumStat.ougon.getId(), (amplifier + 1) * 3);
	        }
        }
    }
	/*
	@Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) {

        mc.getTextureManager().bindTexture(field_147001_a);
        mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, (iconID % 14) * 18, (iconID / 14) * 18, 18, 18);

    }
    */
}
