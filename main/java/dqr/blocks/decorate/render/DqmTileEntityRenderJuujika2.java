package dqr.blocks.decorate.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.decorate.model.DqmModelJuujika;
import dqr.blocks.decorate.tileEntity.DqmTileEntityJuujika2;

@SideOnly(Side.CLIENT)
public class DqmTileEntityRenderJuujika2 extends TileEntitySpecialRenderer
{
    private DqmModelJuujika model = new DqmModelJuujika();

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        DqmTileEntityJuujika2 var9 = (DqmTileEntityJuujika2)var1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

        if (var9.getBlockMetadata() == 1)
        {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var9.getBlockMetadata() == 2)
        {
            GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var9.getBlockMetadata() == 3)
        {
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
        }

        this.bindTexture(new ResourceLocation("dqr:textures/model/Juujika2.png"));
        GL11.glPushMatrix();
        this.model.modelRender(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
