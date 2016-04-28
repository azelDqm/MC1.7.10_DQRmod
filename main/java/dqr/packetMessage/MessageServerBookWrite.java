package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageServerBookWrite implements IMessage {

    public ItemStack data1;


    public MessageServerBookWrite(){}

    public MessageServerBookWrite(ItemStack par1) {
        //this.data1 = new NBTTagCompound();
        //EntityPlayerからIExtendedEntityPropertiesを取得。
        //ExtendedPlayerProperties.get(entityPlayer).saveNBTData(data);
    	this.data1 = par1;


    }

    @Override
    public void fromBytes(ByteBuf buf) {
        data1 = ByteBufUtils.readItemStack(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeItemStack(buf, data1);
    }
}
