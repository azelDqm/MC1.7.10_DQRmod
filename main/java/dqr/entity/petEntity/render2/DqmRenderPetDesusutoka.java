package dqr.entity.petEntity.render2;

import net.minecraft.client.renderer.entity.RenderLiving;
import dqr.entity.petEntity.DqmPetBase;
import net.minecraft.entity.Entity;
import dqr.entity.petEntity.DqmPetBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.entity.mobEntity.model2.DqmModelKandata;

public class DqmRenderPetDesusutoka extends RenderLiving
{
	private float scale = 0.35F;
	/*
	 * テクスチャへのResourceLocationを設定する.
	 */
	//private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Gorotuki.png");
	//private static final ResourceLocation DqmMobSleepTexture = new ResourceLocation("dqr:textures/entity/mobSleep/GorotukiPetzzz.png");
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Desusutoka.png");
	private static final ResourceLocation DqmMobSleepTexture = new ResourceLocation("dqr:textures/entity/mobSleep/DesusutokaPetzzz.png");

	public DqmRenderPetDesusutoka()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new DqmModelKandata(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1EntityLiving) {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		if(par1EntityLiving instanceof DqmPetBase)
		{
			DqmPetBase pet = (DqmPetBase)par1EntityLiving;

			if(pet.isSitting())
			{
				return this.DqmMobSleepTexture;
			}
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
