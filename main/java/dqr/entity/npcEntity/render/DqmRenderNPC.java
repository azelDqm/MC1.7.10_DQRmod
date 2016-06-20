package dqr.entity.npcEntity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.entity.npcEntity.model.DqmModelNPC;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.npcEntity.npc.DqmEntityNPCGuntai2;
import dqr.entity.npcEntity.npc.DqmEntityNPCKaitoriya;
import dqr.entity.npcEntity.npc.DqmEntityNPCSyuuri;

@SideOnly(Side.CLIENT)
public class DqmRenderNPC extends RenderLiving
{
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/npc/SteveB.png");
	//private static final ResourceLocation DqmMobTextureBank = new ResourceLocation("dqr:textures/entity/npc/SteveG.png");
	private static final ResourceLocation DqmMobTextureBank = new ResourceLocation("dqr:textures/entity/npc/SteveG.png");
	private static final ResourceLocation DqmMobTextureBukiya = new ResourceLocation("dqr:textures/entity/npc/SteveB.png");
	private static final ResourceLocation DqmMobTextureKaitori = new ResourceLocation("dqr:textures/entity/npc/SteveK.png");
	private static final ResourceLocation DqmMobTextureSyuri = new ResourceLocation("dqr:textures/entity/npc/SteveS.png");

	private float scale = 1.0F;

	public DqmRenderNPC()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new DqmModelNPC(), 1.0F);
		//GL11.glScalef(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1EntityLiving) {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		if(par1EntityLiving instanceof DqmEntityNPCBank)
		{
			return this.DqmMobTextureBank;
		}else if(par1EntityLiving instanceof DqmEntityNPCBukiya)
		{
			return this.DqmMobTextureBukiya;
		}else if(par1EntityLiving instanceof DqmEntityNPCSyuuri)
		{
			return this.DqmMobTextureSyuri;
		}else if(par1EntityLiving instanceof DqmEntityNPCKaitoriya)
		{
			return this.DqmMobTextureKaitori;
		}else if(par1EntityLiving instanceof DqmEntityNPCGuntai2)
		{
			return this.DqmMobTextureBukiya;
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
