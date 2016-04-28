package dqr.playerData;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessagePlayerProperties2 implements IMessage {

    public NBTTagCompound data;

    public MessagePlayerProperties2(){}

    public MessagePlayerProperties2(EntityPlayer entityPlayer) {
        this.data = new NBTTagCompound();
        //EntityPlayerからIExtendedEntityPropertiesを取得。
        ExtendedPlayerProperties2.get(entityPlayer).saveNBTData(data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, data);
    }
}
