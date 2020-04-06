package dqr.playerData;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessagePlayerProperties6 implements IMessage {

    public NBTTagCompound data;

    public MessagePlayerProperties6(){}

    public MessagePlayerProperties6(EntityPlayer entityPlayer) {
        this.data = new NBTTagCompound();
        //EntityPlayerからIExtendedEntityPropertiesを取得。
        ExtendedPlayerProperties6.get(entityPlayer).saveNBTData(data);
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
