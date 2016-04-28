package dqr.entity.npcEntity.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.entity.npcEntity.npc.DqmEntityNPCMedalking;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan2;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan3;

@SideOnly(Side.CLIENT)
public class DqmRenderNPCBiped extends RenderLiving
{
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/npc/SteveB.png");
	private static final ResourceLocation DqmMobTextureSinkan = new ResourceLocation("dqr:textures/entity/npc/Sinkan.png");
	private static final ResourceLocation DqmMobTextureSinkan2 = new ResourceLocation("dqr:textures/entity/npc/Sinkan2.png");
	private static final ResourceLocation DqmMobTextureSinkan3 = new ResourceLocation("dqr:textures/entity/npc/Sinkan3.png");
	private static final ResourceLocation DqmMobTextureMedalking = new ResourceLocation("dqr:textures/entity/npc/Medalking.png");
	private float scale = 1.0F;

	public DqmRenderNPCBiped()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new ModelBiped(), 0.5F);
		//GL11.glScalef(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1EntityLiving) {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		if(par1EntityLiving instanceof DqmEntityNPCSinkan)
		{
			return this.DqmMobTextureSinkan;
		}else if(par1EntityLiving instanceof DqmEntityNPCSinkan2)
		{
			return this.DqmMobTextureSinkan2;
		}else if(par1EntityLiving instanceof DqmEntityNPCSinkan3)
		{
			return this.DqmMobTextureSinkan3;
		}else if(par1EntityLiving instanceof DqmEntityNPCMedalking)
		{
			return this.DqmMobTextureMedalking;
		}

		return this.DqmMobTexture;
	}


    protected void preRenderScale(EntityLivingBase par1Entity, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2)
    {
        this.preRenderScale(par1EntityLiving, par2);
    }

}
