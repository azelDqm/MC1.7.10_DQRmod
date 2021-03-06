package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageServerMGToolMode implements IMessage {

    public int data;

    public MessageServerMGToolMode(){}

    public MessageServerMGToolMode(int par1) {
        this.data= par1;
    }

    @Override//IMessageのメソッド。ByteBufからデータを読み取る。
    public void fromBytes(ByteBuf buf){
        this.data= buf.readInt();
    }

    @Override//IMessageのメソッド。ByteBufにデータを書き込む。
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.data);
    }
}
