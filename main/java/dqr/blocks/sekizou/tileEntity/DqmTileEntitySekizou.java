package dqr.blocks.sekizou.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class DqmTileEntitySekizou extends TileEntity
{
	private int talkFlg = 0;

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

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.talkFlg = par1NBTTagCompound.getInteger("talkFlg");
    }

    /*
     * こちらはNBTを書き込むメソッド。
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("talkFlg", this.talkFlg);
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


    public void updateEntity()
    {
    	//System.out.println("TESTA " + this.worldObj.isRemote);

    	/*
    	if(!this.worldObj.isRemote)
    	{
	    	Block check0 = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
	    	//System.out.println("TEST : " + check0.getUnlocalizedName());

	    	if(check0 instanceof DqmBlockSekizou && ((DqmBlockSekizou)check0).power == 1)
	    	{
		    	if(this.worldObj.getWorldTime() %100 == 0)
		    	{
		    		//System.out.println("TEST : " + blockType.getUnlocalizedName());
		    		Block check1 = this.worldObj.getBlock(this.xCoord + 2, this.yCoord, this.zCoord + 2);
		    		Block check2 = this.worldObj.getBlock(this.xCoord - 2, this.yCoord, this.zCoord + 2);
		    		Block check3 = this.worldObj.getBlock(this.xCoord + 2, this.yCoord, this.zCoord - 2);
		    		Block check4 = this.worldObj.getBlock(this.xCoord - 2, this.yCoord, this.zCoord - 2);

		    		if(check1 == DQDecorates.DqmBlockKagaribidai &&
		    		   check1 == check2 && check2 == check3 && check3 == check4)
		    		{
		    			check1 = this.worldObj.getBlock(this.xCoord + 2, this.yCoord + 1, this.zCoord + 2);
			    		check2 = this.worldObj.getBlock(this.xCoord - 2, this.yCoord + 1, this.zCoord + 2);
			    		check3 = this.worldObj.getBlock(this.xCoord + 2, this.yCoord + 1, this.zCoord - 2);
			    		check4 = this.worldObj.getBlock(this.xCoord - 2, this.yCoord + 1, this.zCoord - 2);
			    		if(check1 == Blocks.fire &&
					       check1 == check2 && check2 == check3 && check3 == check4)
					    {
			    			EntityLightningBolt lb = null;
                    		lb = new EntityLightningBolt(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                    		this.worldObj.addWeatherEffect(lb);
                    		this.worldObj.spawnEntityInWorld(lb);

                    		DqmMobBase mob = null;
                    		Item item = null;
                    		if(check0 == DQSekizous.BlockSekizouZoma)
                        	{
                    			mob = new DqmEntityZoma(this.worldObj);
                    			item = Item.getItemFromBlock(DQSekizous.BlockSekizouZomaNo);
                        	}else if(check0 == DQSekizous.BlockSekizouDesupisaro1)
                        	{
                        		mob = new DqmEntityDesupisaro1(this.worldObj);
                        		item = Item.getItemFromBlock(DQSekizous.BlockSekizouDesupisaro1No);
                        	}else if(check0 == DQSekizous.BlockSekizouEsterk)
                        	{
                        		mob = new DqmEntityEsterk(this.worldObj);
                        		item = Item.getItemFromBlock(DQSekizous.BlockSekizouEsterkNo);
                        	}else if(check0 == DQSekizous.BlockSekizouMasterdoragon)
                        	{
                        		mob = new DqmEntityMasterdoragon(this.worldObj);
                        		item = Item.getItemFromBlock(DQSekizous.BlockSekizouMasterdoragonNo);
                        	}else if(check0 == DQSekizous.BlockSekizouRyuuou)
                        	{
                        		mob = new DqmEntityRyuuou(this.worldObj);
                        		item = Item.getItemFromBlock(DQSekizous.BlockSekizouRyuuouNo);
                        	}else if(check0 == DQSekizous.BlockSekizouDarkRamia)
                        	{
                        		mob = new DqmEntityDarkRamia(this.worldObj);
                        		item = Item.getItemFromBlock(DQSekizous.BlockSekizouDarkRamiaNo);
                        	}

                    		mob.setLocationAndAngles((double)this.xCoord + 0.5D, (double)this.yCoord + 1.5D, (double)this.zCoord + 0.5D, 0.0F, 0.0F);
                    		this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
                    		if(mob != null)
                    		{
                    			this.worldObj.spawnEntityInWorld(mob);
                    		}
                    		if(item != null)
                    		{
                    			mob.dropItem(item, 1);
                    		}
					    }
		    		}
		    	}
	    	}

    	}
    	*/

    }

    public void setTalkFlg(int par1)
    {
    	this.talkFlg = par1;
    }

    public int getTalkFlg()
    {
    	return this.talkFlg;
    }
}
