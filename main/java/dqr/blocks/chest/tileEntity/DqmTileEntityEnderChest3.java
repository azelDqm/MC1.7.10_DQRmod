package dqr.blocks.chest.tileEntity;

import dqr.api.Blocks.DQChests;

public class DqmTileEntityEnderChest3 extends DqmTileEntityEnderChest{

	@Override
    public void updateEntity()
    {
        super.updateEntity();

        if (++this.field_145974_k % 20 * 4 == 0)
        {
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, DQChests.DqmEnderChest3, 1, this.field_145973_j);
        }

        this.field_145975_i = this.field_145972_a;
        float f = 0.1F;
        double d1;

        if (this.field_145973_j > 0 && this.field_145972_a == 0.0F)
        {
            double d0 = (double)this.xCoord + 0.5D;
            d1 = (double)this.zCoord + 0.5D;
            this.worldObj.playSoundEffect(d0, (double)this.yCoord + 0.5D, d1, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.field_145973_j == 0 && this.field_145972_a > 0.0F || this.field_145973_j > 0 && this.field_145972_a < 1.0F)
        {
            float f2 = this.field_145972_a;

            if (this.field_145973_j > 0)
            {
                this.field_145972_a += f;
            }
            else
            {
                this.field_145972_a -= f;
            }

            if (this.field_145972_a > 1.0F)
            {
                this.field_145972_a = 1.0F;
            }

            float f1 = 0.5F;

            if (this.field_145972_a < f1 && f2 >= f1)
            {
                d1 = (double)this.xCoord + 0.5D;
                double d2 = (double)this.zCoord + 0.5D;
                this.worldObj.playSoundEffect(d1, (double)this.yCoord + 0.5D, d2, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.field_145972_a < 0.0F)
            {
                this.field_145972_a = 0.0F;
            }
        }
    }

	@Override
    public void func_145969_a()
    {
        ++this.field_145973_j;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, DQChests.DqmEnderChest3, 1, this.field_145973_j);
    }

	@Override
    public void func_145970_b()
    {
        --this.field_145973_j;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, DQChests.DqmEnderChest3, 1, this.field_145973_j);
    }
}
