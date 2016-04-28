package dqr.handler.client;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.event.DqmEntityRenderEvent;
import dqr.items.base.DqmItemBowBase;
import dqr.playerData.ExtendedPlayerProperties;

public class RenderEntityHandler {

	private Minecraft mc;

	public RenderEntityHandler(Minecraft mc) {
		// super();

		// We need this to invoke the render engine.
		this.mc = mc;
	}

	@SubscribeEvent
	public void onRenderPlayerEvent(DqmEntityRenderEvent event) {

		ItemStack its = this.mc.thePlayer.getCurrentEquippedItem();

		if(this.mc.thePlayer.getItemInUse() != null && this.mc.thePlayer.getItemInUseCount() > 0)
		{
			its = this.mc.thePlayer.getItemInUse();

			if (its.getItem() instanceof DqmItemBowBase)
			{


				float f10 = its.getMaxItemUseDuration()
						- (this.mc.thePlayer.getItemInUseCount()
								- event.renderPartialTicks + 1.0F);
				float f11 = f10 / 20.0F;
				f11 = (f11 * f11 + f11 * 2.0F) / 3.0F;
				if (f11 > 1.0F) {
					f11 = 1.0F;
				}
				if (f11 > 0.1F) {
					GL11.glTranslatef(0.0F,
							MathHelper.sin((f10 - 0.1F) * 1.3F) * 0.01F
									* (f11 - 0.1F), 0.0F);
				}

				f11 = f11 * -1;
				GL11.glTranslatef(0.0F, 0.0F, f11 * -0.1F);
				GL11.glTranslatef(0.0F, 0.5F, 0.0F);

				float f12 = 1.0F + f11 * 0.2F;

				GL11.glScalef(1.0F, 1.0F, f12);
				GL11.glTranslatef(0.0F, -0.5F, 0.0F);

			}

		}else
		{

			if (its != null && its.getItem() instanceof DqmItemBowBase && ExtendedPlayerProperties.get(this.mc.thePlayer).getMaxItemUserCnt() >= 0)
			{
				//System.out.println("TEST2:" + its.getMaxItemUseDuration() + "/" + ExtendedPlayerProperties.get(this.mc.thePlayer).getMaxItemUserCnt());
				//float f10 = its.getMaxItemUseDuration() - (ExtendedPlayerProperties.get(this.mc.thePlayer).getMaxItemUserCnt() - event.renderPartialTicks + 1.0F);
				float f10 = ExtendedPlayerProperties.get(this.mc.thePlayer).getMaxItemUserCnt();
				float f11 = f10 / 20.0F;
				f11 = (f11 * f11 + f11 * 2.0F) / 3.0F;
				if (f11 > 1.0F) {
					f11 = 1.0F;
				}

				if (f11 > 0.1F) {
					GL11.glTranslatef(0.0F,MathHelper.sin((f10 - 0.1F) * 1.3F) * 0.01F * (f11 - 0.1F), 0.0F);
				}

				//f11 = 1.0F - f11;

				 f11 = f11 * -1;
				GL11.glTranslatef(0.0F, 0.0F, f11 * -0.1F);
				GL11.glTranslatef(0.0F, 0.5F, 0.0F);

				float f12 = 1.0F + f11 * 0.2F;

				GL11.glScalef(1.0F, 1.0F, f12);
				GL11.glTranslatef(0.0F, -0.5F, 0.0F);


				ExtendedPlayerProperties.get(this.mc.thePlayer).setMaxItemUserCnt(ExtendedPlayerProperties.get(this.mc.thePlayer).getMaxItemUserCnt() - 2);

			}


		}

		// System.out.println(this.mc.thePlayer.getItemInUseCount());
		// float var4 = this.mc.thePlayer.prevTimeInPortal +
		// (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal)
		// * event.renderPartialTicks;

		/*
		 * if(this.mc.thePlayer.isPotionActive(DQPotionMinus.debuffMedapani)) {
		 * float var4 = (float)this.mc.thePlayer.ticksExisted;
		 *
		 * //Potion medap =
		 * this.mc.thePlayer.getActivePotionEffect(DQPotionMinus
		 * .debuffMedapani); //medap.
		 *
		 * //System.out.println("======================="); byte var5 = 20;
		 *
		 * var5 = 7;
		 *
		 * float var6 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F; var6 *=
		 * var6; GL11.glRotatef(((float)this.mc.thePlayer.ticksExisted +
		 * event.renderPartialTicks) * (float)var5, 0.0F, 1.0F, 1.0F);
		 * GL11.glScalef(1.0F / var6, 1.0F, 1.0F); }
		 */

	}
}
