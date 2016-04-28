package dqr.blocks.decorate.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.decorate.model.DqmModelMinidama;
import dqr.blocks.decorate.tileEntity.DqmTileEntityMinidama;

@SideOnly(Side.CLIENT)
public class DqmTileEntityRenderMinidama extends TileEntitySpecialRenderer
{
    private DqmModelMinidama model = new DqmModelMinidama();

    public void doRenderModel(DqmTileEntityMinidama var1, double var2, double var4, double var6, float var8)
    {
    	//DqmTileEntityMinidama var9 = (DqmTileEntityMinidama)var1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
        //GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(0.0F, 0.0F, -16.0F, 1.0F);

        if (var1.getBlockMetadata() == 1)
        {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var1.getBlockMetadata() == 2)
        {
            GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var1.getBlockMetadata() == 3)
        {
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
        }

        this.bindTexture(new ResourceLocation("dqr:textures/model/miniDama3.png"));
        GL11.glPushMatrix();
        this.model.modelRender(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		if(par1TileEntity !=null)
			this.doRenderModel((DqmTileEntityMinidama) par1TileEntity, par2, par4, par6, par8);
	}
}
