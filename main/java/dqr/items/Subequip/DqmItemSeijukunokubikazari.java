package dqr.items.Subequip;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.items.base.DqmItemAccessoryBase;

public class DqmItemSeijukunokubikazari extends DqmItemAccessoryBase{

	public DqmItemSeijukunokubikazari(EnumDqmSubEquipType equipment)
	{
		super(equipment);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

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
            			if(rand.nextInt(100) < 30)
            			{
	            			EntityLivingBase elb = (EntityLivingBase)target;
	            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
	            			{
	            				par3EntityPlayer.addPotionEffect(new PotionEffect(DQPotionMinus.debuffMahoton.id, 300, 0));
	            				elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
	            				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.down", 1.0F, 1.0F);
	            			}else
	            			{
	            				elb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffMahoton.id, 300, 0));
	            				elb.worldObj.playSoundAtEntity(elb, "dqr:player.down", 1.0F, 1.0F);
	            			}
            			}
        			}
        		}
        	}
        }

        par1ItemStack.damageItem(this.getMaxDamage() / 20, par3EntityPlayer);


        return par1ItemStack;
    }
}
