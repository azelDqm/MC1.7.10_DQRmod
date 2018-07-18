package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageClientDataSend  implements IMessage{

	private NBTTagCompound data;
	public int flg;

	public MessageClientDataSend(){

	}

	public MessageClientDataSend(NBTTagCompound id, int par2) {

		this.setData(id);
		this.flg = par2;

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        setData(ByteBufUtils.readTag(buf));
        this.flg= buf.readInt();
    }

    @Override
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
