package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageClientCleatSlotItem implements IMessage {

    public int data;

    public MessageClientCleatSlotItem(){}

    public MessageClientCleatSlotItem(int par1) {

    	this.data= par1;
    }

    @Override//IMessageのメソッド。ByteBufからデータを読み取る。
    public void fromBytes(ByteBuf buf) {
        this.data= buf.readByte();
    }

    @Override//IMessageのメソッド。ByteBufにデータを書き込む。
    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.data);
    }
}
