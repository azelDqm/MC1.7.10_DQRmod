package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import dqr.api.enums.EnumDqmFuncPacketCode;

public class MessageServerFunction implements IMessage {

    public int data;
    public int data2;

    public MessageServerFunction(){}

    public MessageServerFunction(EnumDqmFuncPacketCode par1, int value) {
        this.data= par1.getId();
        this.data2= value;
    }

    public MessageServerFunction(EnumDqmFuncPacketCode par1) {
        //this.data= par1.getId();
    	this(par1, -1);
    }

	@Override//IMessageのメソッド。ByteBufからデータを読み取る。
    public void fromBytes(ByteBuf buf){
        this.data= buf.readInt();
        this.data2= buf.readInt();
    }

    @Override//IMessageのメソッド。ByteBufにデータを書き込む。
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.data);
        buf.writeInt(this.data2);
    }
}
