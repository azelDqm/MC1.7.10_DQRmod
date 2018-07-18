package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageServerDataSend implements IMessage {

    public NBTTagCompound data;
    public int flg;

    public MessageServerDataSend(){}

    public MessageServerDataSend(NBTTagCompound par1, int par2) {
        //this.data= par1;
    	this.setData(par1);
        this.flg = par2;
    }

    @Override//IMessageのメソッド。ByteBufからデータを読み取る。
    public void fromBytes(ByteBuf buf){
        //this.data= buf.readInt();
    	setData(ByteBufUtils.readTag(buf));
    	this.flg= buf.readInt();
    }

    @Override//IMessageのメソッド。ByteBufにデータを書き込む。
    public void toBytes(ByteBuf buf) {
    	ByteBufUtils.writeTag(buf, getData());
    	buf.writeInt(this.flg);
    }

	public NBTTagCompound getData() {
		return data;
	}

	public void setData(NBTTagCompound data) {
		this.data = data;
	}
}
