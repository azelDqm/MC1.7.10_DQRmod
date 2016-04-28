package dqr.blocks.mobObj.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.mobObj.tileEntity.DqmTileEntityObjBurizado;
import dqr.entity.mobEntity.model2.DqmModelFureimu;

@SideOnly(Side.CLIENT)
public class DqmTileEntityRenderObjBurizado extends TileEntitySpecialRenderer
{
    //モデル
    private DqmModelFureimu model = new DqmModelFureimu();

    private float fixA = 0;
    private float fixB = 1.5F;
    private float fixC = 0;
    private float fixD = 1.5F;
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Burizado.png");

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        //エンティティ
        DqmTileEntityObjBurizado var9 = (DqmTileEntityObjBurizado)var1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + (1.5F * fixB) + fixA, (float)var6 + 0.5F);
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

        //テクスチャー
        this.bindTexture(DqmMobTexture);

        GL11.glPushMatrix();
        this.model.modelRender((0.0625F * fixD) + fixC);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
