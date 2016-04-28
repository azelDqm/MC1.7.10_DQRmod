package dqr.entity.petEntity.render;

import net.minecraft.client.renderer.entity.RenderBiped;
import dqr.entity.petEntity.DqmPetBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import dqr.entity.mobEntity.model.ModelMeleeSkeleton;

public class RenderMeleeSkeleton extends RenderBiped
{
	/*
	 * テクスチャへのResourceLocationを設定する.
	 */
	private static final ResourceLocation skeletonTextures = new ResourceLocation("dqr:textures/entity/mob/red_skeleton.png");

	public RenderMeleeSkeleton()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new ModelMeleeSkeleton(), 0.5F);
	}

	/*
	 * このRenderが利用するテクスチャのResourceLocationを返す.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving)
	{
		return this.skeletonTextures;
	}
}
