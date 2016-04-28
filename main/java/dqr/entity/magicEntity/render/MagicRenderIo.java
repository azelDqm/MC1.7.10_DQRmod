package dqr.entity.magicEntity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.model.MagicEntityModel1;

@SideOnly(Side.CLIENT)
public class MagicRenderIo extends Render
{
    private static final ResourceLocation textureLocation = new ResourceLocation("dqr:textures/entity/magic/io.png");

    protected ModelBase modelBullet;

    public MagicRenderIo(ModelBase par1ModelBase) {
		super();
		this.modelBullet = par1ModelBase;
		this.shadowSize = 0.0F;
	}

	public void renderArrow(MagicEntityIo par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        MagicEntityModel1 model = (MagicEntityModel1) this.modelBullet;

		this.bindEntityTexture(par1Entity);
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
        GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6);
        GL11.glRotatef(par1Entity.prevRotationYaw + (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par9, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(par1Entity.prevRotationPitch + (par1Entity.rotationPitch - par1Entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getArrowTextures(MagicEntityIo par1EntityArrow)
    {
        return textureLocation;
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getArrowTextures((MagicEntityIo)par1Entity);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderArrow((MagicEntityIo)par1Entity, par2, par4, par6, par8, par9);
    }
}
