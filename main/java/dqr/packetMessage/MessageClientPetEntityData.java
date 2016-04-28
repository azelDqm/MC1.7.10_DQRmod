package dqr.packetMessage;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageClientPetEntityData  implements IMessage{

	private NBTTagCompound data;

	public MessageClientPetEntityData(){

	}

	public MessageClientPetEntityData(NBTTagCompound id) {

		//System.out.println("DATASEND");
		//NBTTagCompound nbt = new NBTTagCompound();
		this.setData(id);

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        setData(ByteBufUtils.readTag(buf));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, getData());
    }

	public NBTTagCompound getData() {
		return data;
	}

	public void setData(NBTTagCompound data) {
		this.data = data;
	}

}
