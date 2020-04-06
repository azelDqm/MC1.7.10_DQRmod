package dqr.playerData;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessagePlayerProperties5 implements IMessage {

    public NBTTagCompound data;

    public MessagePlayerProperties5(){}

    public MessagePlayerProperties5(EntityPlayer entityPlayer) {
        this.data = new NBTTagCompound();
        //EntityPlayerからIExtendedEntityPropertiesを取得。
        ExtendedPlayerProperties5.get(entityPlayer).saveNBTData(data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	try
    	{
    		data = ByteBufUtils.readTag(buf);
    	}catch(Exception e)
    	{

    	}
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	try
    	{
    		ByteBufUtils.writeTag(buf, data);
    	}catch(Exception e)
    	{

    	}
    }



}
