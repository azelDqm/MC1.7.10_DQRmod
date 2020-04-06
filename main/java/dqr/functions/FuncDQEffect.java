package dqr.functions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import dqr.PacketHandler;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.playerData.MessagePlayerProperties5;

public class FuncDQEffect {

    public void setDQPotionEffect(EntityLivingBase elv, String key, int id, int idx, int type, long duration, int isDebuff, int amplifier)
    {
    	this.setDQPotionEffect(elv, key, id, idx, type, duration, isDebuff, amplifier, -1, -1, "");
    }
    public void setDQPotionEffect(EntityLivingBase elv, String key, int id, int idx, int type, long duration, int isDebuff, int amplifier, int iconX, int iconY, String iconPath)
    {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", id);
    	nbt.setInteger("idx", idx);
    	nbt.setInteger("type", type);
    	nbt.setLong("duration", elv.worldObj.getWorldTime() + duration);
    	nbt.setInteger("isDebuff", isDebuff);
    	nbt.setInteger("amplifier", amplifier);
    	nbt.setInteger("iconX", iconX);
    	nbt.setInteger("iconY", iconY);
    	if(iconPath == null)
    	{
    		nbt.setString("iconPath", "");
    	}else
    	{
    		nbt.setString("iconPath", iconPath);
    	}

    	//ExtendedPlayerProperties5.get(entityplayermp).refreshDqrPotionEffects(ep.worldObj.getWorldTime());
        //PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5((EntityPlayer)entityplayermp), (EntityPlayerMP)entityplayermp);
    	if(elv instanceof EntityPlayer)
    	{
    		EntityPlayer target = (EntityPlayer)elv;
    		ExtendedPlayerProperties5.get(target).setDqrPotionEffects(key, nbt);
    		ExtendedPlayerProperties5.get(target).refreshDqrPotionEffects(target.worldObj.getWorldTime());
    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5(target), (EntityPlayerMP)elv);
    	}else if(elv instanceof DqmPetBase)
    	{
    		DqmPetBase target = (DqmPetBase)elv;
    		target.setDqrPotionEffects(key, nbt);
    		target.refreshDqrPotionEffects(target.worldObj.getWorldTime());
    	}else if(elv instanceof DqmMobBase)
    	{
    		DqmMobBase target = (DqmMobBase)elv;
    		target.setDqrPotionEffects(key, nbt);
    		target.refreshDqrPotionEffects(target.worldObj.getWorldTime());
    	}
    }

    public boolean isEnableEffect(EntityLivingBase elv, String key)
    {
    	boolean ret = false;
    	long worldTime = elv.worldObj.getWorldTime();
    	NBTTagCompound nbt = new NBTTagCompound();

    	if(elv instanceof EntityPlayer)
    	{
    		EntityPlayer target = (EntityPlayer)elv;
    		nbt = ExtendedPlayerProperties5.get(target).getDqrPotionEffects(key);
    	}else if(elv instanceof DqmPetBase)
    	{
    		DqmPetBase target = (DqmPetBase)elv;
    		nbt = target.getDqrPotionEffects(key);
    	}else if(elv instanceof DqmMobBase)
    	{
    		DqmMobBase target = (DqmMobBase)elv;
    		nbt = target.getDqrPotionEffects(key);
    	}

    	if(nbt != null && (nbt.hasKey("duration")))
    	{
    		long effectTime = nbt.getLong("duration");
    		ret = worldTime < effectTime;
    	}

    	return ret;
    }

    public void clearAllEffect(EntityLivingBase elv)
    {
    	EntityPlayer target = (EntityPlayer)elv;
    	ExtendedPlayerProperties5.get(target).setDqrPotionEffectsSet(new NBTTagCompound());
    }

    public void clearEffect(EntityLivingBase elv)
    {
    	//EntityPlayer target = (EntityPlayer)elv;
    	//ExtendedPlayerProperties5.get(target).setDqrPotionEffectsSet(new NBTTagCompound());
    }
}
