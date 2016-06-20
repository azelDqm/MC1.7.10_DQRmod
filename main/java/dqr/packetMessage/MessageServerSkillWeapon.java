package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageServerSkillWeapon implements IMessage {

    public int data;
    public int data2;
    public int data3;

    public MessageServerSkillWeapon(){}

    public MessageServerSkillWeapon(int par1, int par2, int par3) {
        this.data= par1;
        this.data2 = par2;
        this.data3 = par3;
    }

    @Override//IMessageのメソッド。ByteBufからデータを読み取る。
    public void fromBytes(ByteBuf buf){
        this.data= buf.readInt();
        this.data2= buf.readInt();
        this.data3= buf.readInt();
    }

    @Override//IMessageのメソッド。ByteBufにデータを書き込む。
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.data);
        buf.writeInt(this.data2);
        buf.writeInt(this.data3);
    }
}
