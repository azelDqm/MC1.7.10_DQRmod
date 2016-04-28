package dqr.blocks.mobSpawner.tileEntity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class DqmTileEntityMobSpawner extends TileEntityMobSpawner
{
    private final DqmMobSpawnerBaseLogic field_145882_a = new DqmMobSpawnerBaseLogic()
    {
        private static final String __OBFID = "CL_00000361";
        public void func_98267_a(int p_98267_1_)
        {
            DqmTileEntityMobSpawner.this.worldObj.addBlockEvent(DqmTileEntityMobSpawner.this.xCoord, DqmTileEntityMobSpawner.this.yCoord, DqmTileEntityMobSpawner.this.zCoord, Blocks.mob_spawner, p_98267_1_, 0);
        }
        public World getSpawnerWorld()
        {
            return DqmTileEntityMobSpawner.this.worldObj;
        }
        public int getSpawnerX()
        {
            return DqmTileEntityMobSpawner.this.xCoord;
        }
        public int getSpawnerY()
        {
            return DqmTileEntityMobSpawner.this.yCoord;
        }
        public int getSpawnerZ()
        {
            return DqmTileEntityMobSpawner.this.zCoord;
        }
        public void setRandomEntity(DqmMobSpawnerBaseLogic.WeightedRandomMinecart p_98277_1_)
        {
            super.setRandomEntity(p_98277_1_);

            if (this.getSpawnerWorld() != null)
            {
                this.getSpawnerWorld().markBlockForUpdate(DqmTileEntityMobSpawner.this.xCoord, DqmTileEntityMobSpawner.this.yCoord, DqmTileEntityMobSpawner.this.zCoord);
            }
        }
    };
    private static final String __OBFID = "CL_00000360";

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        this.field_145882_a.readFromNBT(p_145839_1_);
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        this.field_145882_a.writeToNBT(p_145841_1_);
    }

    public void updateEntity()
    {
        this.field_145882_a.updateSpawner();
        super.updateEntity();
    }

    /**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        nbttagcompound.removeTag("SpawnPotentials");
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
    }

    /**
     * Called when a client event is received with the event number and argument, see World.sendClientEvent
     */
    public boolean receiveClientEvent(int p_145842_1_, int p_145842_2_)
    {
        return this.field_145882_a.setDelayToMin(p_145842_1_) ? true : super.receiveClientEvent(p_145842_1_, p_145842_2_);
    }

    public DqmMobSpawnerBaseLogic func_145881_a()
    {
        return this.field_145882_a;
    }

}
