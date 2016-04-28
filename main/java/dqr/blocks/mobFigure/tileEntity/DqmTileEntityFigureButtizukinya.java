package dqr.blocks.mobFigure.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class DqmTileEntityFigureButtizukinya extends TileEntity
{
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
}
