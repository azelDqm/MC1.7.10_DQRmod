package dqr.entity.petEntity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import dqr.entity.petEntity.DqmPetBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import dqr.entity.mobEntity.model.DqmModelMadohando;

public class DqmRenderPetMadohando extends RenderLiving
{
	/*
	 * テクスチャへのResourceLocationを設定する.
	 */
	private static final ResourceLocation DqmMobTexture = new ResourceLocation("dqr:textures/entity/mob/Madohando.png");
	private static final ResourceLocation DqmMobSleepTexture = new ResourceLocation("dqr:textures/entity/mobSleep/MadohandoPetzzz.png");

	public DqmRenderPetMadohando()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new DqmModelMadohando(), 0.5F);
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
}