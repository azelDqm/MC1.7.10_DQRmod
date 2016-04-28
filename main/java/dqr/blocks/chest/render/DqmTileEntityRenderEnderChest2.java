package dqr.blocks.chest.render;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest2;
import dqr.entity.mobEntity.model.DqmModelKirapan;

@SideOnly(Side.CLIENT)
public class DqmTileEntityRenderEnderChest2 extends TileEntitySpecialRenderer
{
    //モデル
    private ModelChest model = new ModelChest();
    private DqmModelKirapan model2 = new DqmModelKirapan();



    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        //エンティティ
        {
            DqmTileEntityEnderChest var9 = (DqmTileEntityEnderChest)var1;
            int i = 0;

            if (var9.hasWorldObj())
            {
                i = var9.getBlockMetadata();
            }

            this.bindTexture(new ResourceLocation("textures/entity/chest/ender.png"));
            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)var2, (float)var4 + 1.0F, (float)var6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = var9.field_145975_i + (var9.field_145972_a - var9.field_145975_i) * var8;
            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            this.model.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            this.model.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        {
            //エンティティ
            DqmTileEntityEnderChest2 var9 = (DqmTileEntityEnderChest2)var1;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F + 0.2F, (float)var6 + 0.5F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);//S

            /*
            if (var9.getBlockMetadata() == 2)//W
            {
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var9.getBlockMetadata() == 0)//N
            {
                GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var9.getBlockMetadata() == 1)//E
            {
                GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
            }
            */
            int i = 0;
            short short1 = 0;

            if (var9.hasWorldObj())
            {
                i = var9.getBlockMetadata();
            }

            if (i == 2)
            {
                short1 = 0;
            }

            if (i == 3)
            {
                short1 = 180;
            }

            if (i == 4)
            {
                short1 = -90;
            }

            if (i == 5)
            {
                short1 = 90;
            }

            //GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);

            //テクスチャー
            this.bindTexture(new ResourceLocation("dqr:textures/entity/mob/Kirapan.png"));
            GL11.glPushMatrix();

            /*
            float f1 = var9.field_145975_i + (var9.field_145972_a - var9.field_145975_i) * var8;
            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            this.model2.doutai1.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            this.model2.doutai2.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            */

            this.model2.modelRender(0.0625F / 2);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }
}
