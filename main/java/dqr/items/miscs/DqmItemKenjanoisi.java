package dqr.items.miscs;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.enums.EnumColor;
import dqr.entity.petEntity.DqmPetBase;
import dqr.items.base.DqmItemMiscBase;

public class DqmItemKenjanoisi extends DqmItemMiscBase{


	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{

		Random rand = new Random();

		int attackDamBase = 70;
		int attackDam = attackDamBase + rand.nextInt(20);

    	if(par3EntityPlayer.getHealth() + attackDam > par3EntityPlayer.getMaxHealth())
    	{
    		par3EntityPlayer.setHealth(par3EntityPlayer.getMaxHealth());
    	}else
    	{
    		par3EntityPlayer.heal((float)attackDam);
    	}
		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.hoimi", 1.0F, 1.0F);


        List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
        		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

        if (list != null && !list.isEmpty())
        {
        	for (int n = 0 ; n < list.size() ; n++)
        	{
        		Entity target = (Entity)list.get(n);

        		if (target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse)
        		{
        			attackDam = attackDamBase + rand.nextInt(20);

    				EntityLivingBase elb = (EntityLivingBase)target;

        			if(elb instanceof DqmPetBase && elb.getHealth() <= 0.1F)
        			{
        				;
        			}else
        			{

                    	if(elb.getHealth() + attackDam > elb.getMaxHealth())
                    	{
                    		elb.setHealth(elb.getMaxHealth());
                    	}else
                    	{
                    		elb.heal((float)attackDam);
                    	}
                    	elb.worldObj.playSoundAtEntity(elb, "dqr:player.hoimi", 1.0F, 1.0F);
        			}
        		}
        	}

		}


		if(rand.nextInt(10) == 0)
		{
			par1ItemStack.stackSize--;
		}

		return  par1ItemStack;
	}

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");

    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.hpheal", new Object[]{70, 90}));
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.randombreak", new Object[]{}));

    }
}
