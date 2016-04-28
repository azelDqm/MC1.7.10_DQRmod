package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntity;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityBakudanisi;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityNiku;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySeisui;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySinkanohiseki;

public class DqmItemThrowBase extends Item  {
    private EnumDqmMagic enumMagic;

    public DqmItemThrowBase()
    {
    	super();
        this.enumMagic = null;
    }

    public DqmItemThrowBase(EnumDqmMagic par4)
    {
    	super();
        this.enumMagic = par4;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {


        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        ThrowItemEntity throwEntity = null;
        boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(p_77659_3_.getGameProfile());

        if(this == DQIngots.itemBakudanisi)
        {

        	if(DQR.conf.permUseBakudanisi == 2 || (DQR.conf.permUseBakudanisi == 1 && flg))
        	{
        		throwEntity = new ThrowItemEntityBakudanisi(p_77659_2_, p_77659_3_);
        	}
        }else if(this == DQMiscs.itemSeisui)
        {
        	throwEntity = new ThrowItemEntitySeisui(p_77659_2_, p_77659_3_);
        }else if(this == DQMiscs.itemNiku1)
        {
        	throwEntity = new ThrowItemEntityNiku(p_77659_2_, p_77659_3_, 1);
        }else if(this == DQMiscs.itemNiku2)
        {
        	throwEntity = new ThrowItemEntityNiku(p_77659_2_, p_77659_3_, 2);
        }else if(this == DQMiscs.itemNiku3)
        {
        	throwEntity = new ThrowItemEntityNiku(p_77659_2_, p_77659_3_, 3);
        }else if(this == DQMiscs.itemNiku4)
        {
        	throwEntity = new ThrowItemEntityNiku(p_77659_2_, p_77659_3_, 4);
        }else if(this == DQMiscs.itemSinkanohiseki)
        {
        	if(DQR.conf.permUseShinkanoHiseki == 2 || (DQR.conf.permUseShinkanoHiseki == 1 && flg))
        	{
        		throwEntity = new ThrowItemEntitySinkanohiseki(p_77659_2_, p_77659_3_);
        	}
        }

        if (!p_77659_3_.capabilities.isCreativeMode && throwEntity != null)
        {
            --p_77659_1_.stackSize;
        }

        if (!p_77659_2_.isRemote && throwEntity != null)
        {
            p_77659_2_.spawnEntityInWorld(throwEntity);
        }

        return p_77659_1_;
    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

		 p_77624_3_.add("");

        if(this == DQIngots.itemBakudanisi)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw2.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Bakudanisi.txt", new Object[]{}));

        }else if(this == DQMiscs.itemSeisui)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw2.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Seisui.1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Seisui.2.txt", new Object[]{}));

        }else if(this == DQMiscs.itemNiku1)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku1.txt", new Object[]{}));

        }else if(this == DQMiscs.itemNiku2)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku2.txt", new Object[]{}));

        }else if(this == DQMiscs.itemNiku3)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku3.txt", new Object[]{}));

        }else if(this == DQMiscs.itemNiku4)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Niku4.txt", new Object[]{}));

        }else if(this == DQMiscs.itemSinkanohiseki)
        {
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw1.txt", new Object[]{}));
        	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.throw.Sinkanohiseki.txt", new Object[]{}));

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
