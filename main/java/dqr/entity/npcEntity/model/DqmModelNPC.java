package dqr.entity.npcEntity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DqmModelNPC extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer k1;
    ModelRenderer k2;
    ModelRenderer k3;
    ModelRenderer ma1;
    ModelRenderer ma3;
    ModelRenderer ma4;
    ModelRenderer ma5;
    ModelRenderer ma6;
    ModelRenderer ma7;
    ModelRenderer manto;

    public DqmModelNPC()
    {
        textureWidth = 128;
        textureHeight = 64;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(128, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(128, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(128, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(128, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        k1 = new ModelRenderer(this, 0, 39);
        k1.addBox(0F, -2F, -1F, 1, 4, 1);
        k1.setRotationPoint(-5F, 11F, -3F);
        k1.setTextureSize(128, 64);
        k1.mirror = true;
        setRotation(k1, -0.4363323F, 0F, 0F);
        k2 = new ModelRenderer(this, 0, 45);
        k2.addBox(0F, -1.5F, 0F, 1, 3, 16);
        k2.setRotationPoint(-5F, 11F, -3F);
        k2.setTextureSize(128, 64);
        k2.mirror = true;
        setRotation(k2, -0.4363323F, 0F, 0F);
        k3 = new ModelRenderer(this, 0, 34);
        k3.addBox(0F, -0.5F, -4F, 1, 1, 3);
        k3.setRotationPoint(-5F, 11F, -3F);
        k3.setTextureSize(128, 64);
        k3.mirror = true;
        setRotation(k3, -0.4363323F, 0F, 0F);
        ma1 = new ModelRenderer(this, 37, 57);
        ma1.addBox(-2.5F, -1F, -4.5F, 5, 1, 5);
        ma1.setRotationPoint(0F, 3F, 2F);
        ma1.setTextureSize(128, 64);
        ma1.mirror = true;
        setRotation(ma1, 0F, 0F, 0F);
        ma3 = new ModelRenderer(this, 37, 57);
        ma3.addBox(1.5F, -1F, -5F, 3, 1, 6);
        ma3.setRotationPoint(0F, 1F, 2F);
        ma3.setTextureSize(128, 64);
        ma3.mirror = true;
        setRotation(ma3, 0F, 0F, 0F);
        ma4 = new ModelRenderer(this, 37, 57);
        ma4.addBox(2F, -1.5F, -5F, 3, 1, 6);
        ma4.setRotationPoint(0F, 1F, 2F);
        ma4.setTextureSize(128, 64);
        ma4.mirror = true;
        setRotation(ma4, 0F, 0F, 0F);
        ma5 = new ModelRenderer(this, 37, 57);
        ma5.addBox(-3.5F, -1F, -4.5F, 7, 1, 5);
        ma5.setRotationPoint(0F, 2F, 2F);
        ma5.setTextureSize(128, 64);
        ma5.mirror = true;
        setRotation(ma5, 0F, 0F, 0F);
        ma6 = new ModelRenderer(this, 37, 57);
        ma6.addBox(-4.5F, -1F, -5F, 3, 1, 6);
        ma6.setRotationPoint(0F, 1F, 2F);
        ma6.setTextureSize(128, 64);
        ma6.mirror = true;
        setRotation(ma6, 0F, 0F, 0F);
        ma7 = new ModelRenderer(this, 37, 57);
        ma7.addBox(-5F, -1.5F, -5F, 3, 1, 6);
        ma7.setRotationPoint(0F, 1F, 2F);
        ma7.setTextureSize(128, 64);
        ma7.mirror = true;
        setRotation(ma7, 0F, 0F, 0F);
        manto = new ModelRenderer(this, 37, 45);
        manto.addBox(-5F, -0.5F, 0F, 10, 18, 1);
        manto.setRotationPoint(0F, 1F, 2F);
        manto.setTextureSize(128, 64);
        manto.mirror = true;
        setRotation(manto, 0.2974289F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        k1.render(f5);
        k2.render(f5);
        k3.render(f5);
        ma1.render(f5);
        ma3.render(f5);
        ma4.render(f5);
        ma5.render(f5);
        ma6.render(f5);
        ma7.render(f5);
        manto.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        head.rotateAngleY = par4 / (180F / (float)Math.PI);
        head.rotateAngleX = par5 / (180F / (float)Math.PI);
        rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        manto.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.3F * par2 * 0.5F + 0.2974289F;
    }
}
