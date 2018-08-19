package dqr.blocks.decorate.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class DqmTileEntityTaruMob extends TileEntity
{
	private int flgInpasu = 0;
	
    public Block getBlockType()
    {
        if (this.blockType == null)
        {
            this.blockType = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
        }

        return this.blockType;
    }

    /**
     * Returns block data at the location of this entity (client-only).
     */
    public int getBlockMetadata()
    {
        return this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
    }
    
    /**
     * NBTの読み取り。
     *
     * このメソッドでは、NBTを介してString（文字列）を読み込んでいます。
     * 文字列以外に、変数やboolean、ItemStackなども扱えます。
     *
     * NBTを使えば一時的には記録されますが、
     * チャンク再生成や再ログイン時にデータが消えてしまいます。
     * また、このクラスで行われた処理・サーバ側で行われた処理をクライアント側に反映させるためには、
     * 別途パケット処理も必要です。
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.flgInpasu = par1NBTTagCompound.getInteger("flgInpasu");
    }

    /*
     * こちらはNBTを書き込むメソッド。
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("flgInpasu", this.flgInpasu);
    }

    /*
     * パケットの送信・受信処理。
     * カスタムパケットは使わず、バニラのパケット送受信処理を使用。
     */
    @Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}

	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

	/*
     * プレイヤー名文字列のゲッターとセッター。
     */
    public int getFlgInpasu()
    {
        return this.flgInpasu;
    }

    public void setFlgInpasu(int par1)
    {
    	this.flgInpasu = par1;
    }
}
