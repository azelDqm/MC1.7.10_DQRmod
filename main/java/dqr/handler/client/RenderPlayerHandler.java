package dqr.handler.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.Items.DQWeapons;

public class RenderPlayerHandler {

	  private Minecraft mc;

	  private ModelBase mainModel;
	  private ModelBiped modelArmorChestplate;
	  private ModelBiped modelArmor;
	  private RendererLivingEntity render;

	  public RenderPlayerHandler(Minecraft mc)
	  {
	    //super();

	    // We need this to invoke the render engine.
	    this.mc = mc;
	  }

	  //@SubscribeEvent
	  public void onRenderPlayerEvent(RenderLivingEvent.Pre event)
	  {
		  if(event.renderer instanceof RenderPlayer)
		  {
			  RenderPlayer renderP = (RenderPlayer) event.renderer;

			  ItemStack its = event.entity.getHeldItem();
			  if(its != null && (its.getItem() == DQWeapons.itemSinken|| its.getItem() == DQWeapons.itemWohanma))
			  {
				  renderP.modelArmorChestplate.heldItemRight = renderP.modelArmor.heldItemRight = renderP.modelBipedMain.heldItemRight = 8;
				  //renderP.modelArmorChestplate.heldItemRight = renderP.modelArmor.heldItemRight = renderP.modelBipedMain.heldItemRight = 8;
			  }
		  }
	  }

	  @SubscribeEvent
	  public void onRenderPlayerEvent(GuiScreenEvent.DrawScreenEvent.Pre event)
	  {

		  /*
		  Random rand = new Random();
		  //func_130015_b
		  //float par1 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * event.renderPartialTicks;
		  float par1 = rand.nextFloat() * 5;
		  ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		  int k = scaledresolution.getScaledWidth();
		  int l = scaledresolution.getScaledHeight();

		  GL11.glDisable(3008);
		  GL11.glDisable(2929);
		  GL11.glDepthMask(false);
		  OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, par1);
		  IIcon iicon = Blocks.portal.getBlockTextureFromSide(1);
		  this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
		  float f1 = iicon.getMinU();
		  float f2 = iicon.getMinV();
		  float f3 = iicon.getMaxU();
		  float f4 = iicon.getMaxV();
		  Tessellator tessellator = Tessellator.instance;
		  tessellator.startDrawingQuads();
		  tessellator.addVertexWithUV(0.0D, l, -90.0D, f1, f4);
		  tessellator.addVertexWithUV(k, l, -90.0D, f3, f4);
		  tessellator.addVertexWithUV(k, 0.0D, -90.0D, f3, f2);
		  tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, f1, f2);
		  tessellator.draw();
		  GL11.glDepthMask(true);
		  GL11.glEnable(2929);
		  GL11.glEnable(3008);
		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		*/
	  }



	  //@SubscribeEvent
	  public void onRenderPlayerEvent(RenderPlayerEvent.Post event)
	  {
		  /*
			EntityPlayer ep = (EntityPlayer)event.entity;
			ItemStack itemstack1 = ep.inventory.getCurrentItem();

			if (itemstack1 != null && itemstack1.getItem() == DQWeapons.itemSinken)
			{
				this.mainModel  = event.renderer.modelBipedMain;
				this.modelArmorChestplate = event.renderer.modelArmorChestplate;
				this.modelArmor = event.renderer.modelArmor;
				this.render = event.renderer;
				//this.renderManager = event.

				event.renderer.modelArmorChestplate.heldItemRight = 8;
				event.renderer.modelBipedMain.heldItemRight = 8;
				event.renderer.modelArmor.heldItemRight = 8;
				//float test = ep.

		        double d0 = ep.lastTickPosX + (ep.posX - ep.lastTickPosX) * (double)1.0F;
		        double d1 = ep.lastTickPosY + (ep.posY - ep.lastTickPosY) * (double)1.0F;
		        double d2 = ep.lastTickPosZ + (ep.posZ - ep.lastTickPosZ) * (double)1.0F;
		        float f1 = ep.prevRotationYaw + (ep.rotationYaw - ep.prevRotationYaw) * 1.0F;

				this.doRender((EntityLivingBase)ep, d0 - RenderManager.instance.renderPosX, d1 - RenderManager.instance.renderPosY, d2 - RenderManager.instance.renderPosZ, f1, 1.0F);
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????");
				//event.setCanceled(true);
			}
			*/
	  }

	  /*
		@SubscribeEvent
		public void onRenderPlayerEvent(RenderPlayerEvent.Post event) {


			EntityPlayer ep = event.entityPlayer;
			ItemStack itemstack1 = ep.inventory.getCurrentItem();

			if (itemstack1 == null || itemstack1.getItem() != DQWeapons.itemSinken)
	        {
				//event.renderer.modelArmorChestplate.heldItemRight = (event.renderer.modelArmor.heldItemRight = event.renderer.modelBipedMain.heldItemRight = 0);
				event.renderer.modelBipedMain.heldItemLeft = 0;
	        }
		}
		*/

		/*
		@SubscribeEvent
		public void onRenderPlayerEvent(RenderLivingEvent.Pre event) {
			if(event.entity instanceof EntityPlayer)
			{
				EntityPlayer ep = (EntityPlayer)event.entity;
				ItemStack itemstack1 = ep.inventory.getCurrentItem();
				//RendererLivingEntity test = event.renderer.modelBipedMain.;

				if (itemstack1 != null && itemstack1.getItem() == DQWeapons.itemSinken)
		        {
			        this.modelBipedMain = (ModelBiped)event.;
			        this.modelArmorChestplate = new ModelBiped(1.0F).;
			        this.modelArmor = new ModelBiped(0.5F);

					mainModel
					//event.renderer.modelArmorChestplate.heldItemRight = (event.renderer.modelArmor.heldItemRight = event.renderer.modelBipedMain.heldItemRight = 7);

					event.renderer.modelArmorChestplate.heldItemRight = 8;
					event.renderer.modelBipedMain.heldItemRight = 8;
					event.renderer.modelArmor.heldItemRight = 8;



					event.renderer.modelArmorChestplate.heldItemLeft = 8;
					event.renderer.modelBipedMain.heldItemLeft = 8;
					event.renderer.modelArmor.heldItemLeft = 8;


					event.renderer.doRender((EntityLivingBase)ep, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_)
					//event.renderer.modelBipedMain.bipedLeftArm.rotateAngleY = 30.0F;
					//event.renderer.modelBipedMain.bipedLeftArm.offsetY = 30.0F;
					//event.renderer.modelBipedMain.bipedLeftArm.rotationPointY = 30.0F;
					//event.renderer.modelBipedMain.bipedLeftArm.postRender(1.0f);
					//event.renderer.modelBipedMain.bipedLeftArm.render(1.0F);
					//event.renderer.modelBipedMain.bipedLeftArm.postRender(1.0F);
					//event.renderer.modelBipedMain.bipedLeftArm.renderWithRotation(1.0F);

					event.setCanceled(true);
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????");
					//event.renderer.modelBipedMain.bipedLeftArm. = 0.5F;
		        }

				EntityPlayer ep = event.entityPlayer;
				ItemStack itemstack1 = ep.inventory.getCurrentItem();

				if (itemstack1 != null && itemstack1.getItem() instanceof DqmItemBowBase)
		        {
					if(ep.getItemInUseCount() > 0)
					{
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????");
						//event.renderer.modelArmorChestplate.aimedBow = true;
						event.renderer.modelArmorChestplate.aimedBow = true;
						event.renderer.modelArmor.aimedBow = true;
						event.renderer.modelBipedMain.aimedBow = true;
					}
		        }

			}
		}
	*/


	//@SubscribeEvent
	public void onRenderPlayerEvent(RenderPlayerEvent.Specials.Pre event) {

		//ItemRenderer itemRenderer = new ItemRenderer(mc);
		EntityPlayer ep = event.entityPlayer;
		ItemStack itemstack1 = ep.inventory.getCurrentItem();

		if (itemstack1 != null && itemstack1.getItem() == DQWeapons.itemSinken)
        {

			/*
            GL11.glPushMatrix();
            event.renderer.modelArmor.bipedRightArm.postRender(0.5625F);
            event.renderer.modelArmor.bipedRightArm.
            */

            //GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????");

            /*
            EnumAction enumaction = null;

            if (ep.getItemInUseCount() > 0)
            {
                enumaction = EnumAction.bow;
            }

			//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????");
            float f2 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f2, -f2, f2);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);


            float f3;
            int k;
            float f12;

            if (itemstack1.getItem().requiresMultipleRenderPasses())
            {
                for (k = 0; k < itemstack1.getItem().getRenderPasses(itemstack1.getItemDamage()); ++k)
                {
                    int i = itemstack1.getItem().getColorFromItemStack(itemstack1, k);
                    f12 = (float)(i >> 16 & 255) / 255.0F;
                    f3 = (float)(i >> 8 & 255) / 255.0F;
                    float f4 = (float)(i & 255) / 255.0F;
                    GL11.glColor4f(f12, f3, f4, 1.0F);
                    itemRenderer.renderItem(ep, itemstack1, k);
                }
            }
            else
            {
                k = itemstack1.getItem().getColorFromItemStack(itemstack1, 0);
                float f11 = (float)(k >> 16 & 255) / 255.0F;
                f12 = (float)(k >> 8 & 255) / 255.0F;
                f3 = (float)(k & 255) / 255.0F;
                GL11.glColor4f(f11, f12, f3, 1.0F);
                itemRenderer.renderItem(ep, itemstack1, 0);
            }
			*/
            //GL11.glPopMatrix();

        }

	}
















	   public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	    {
	        if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Pre(p_76986_1_, this.render, p_76986_2_, p_76986_4_, p_76986_6_))) return;
	        GL11.glPushMatrix();
	        GL11.glDisable(GL11.GL_CULL_FACE);
	        this.mainModel.onGround = this.renderSwingProgress(p_76986_1_, p_76986_9_);

	        /*
	        if (this.renderPassModel != null)
	        {
	            this.renderPassModel.onGround = this.mainModel.onGround;
	        }

	        this.mainModel.isRiding = p_76986_1_.isRiding();

	        if (this.renderPassModel != null)
	        {
	            this.renderPassModel.isRiding = this.mainModel.isRiding;
	        }

	        this.mainModel.isChild = p_76986_1_.isChild();

	        if (this.renderPassModel != null)
	        {
	            this.renderPassModel.isChild = this.mainModel.isChild;
	        }
	        */

	        try
	        {
	            float f2 = this.interpolateRotation(p_76986_1_.prevRenderYawOffset, p_76986_1_.renderYawOffset, p_76986_9_);
	            float f3 = this.interpolateRotation(p_76986_1_.prevRotationYawHead, p_76986_1_.rotationYawHead, p_76986_9_);
	            float f4;

	            if (p_76986_1_.isRiding() && p_76986_1_.ridingEntity instanceof EntityLivingBase)
	            {
	                EntityLivingBase entitylivingbase1 = (EntityLivingBase)p_76986_1_.ridingEntity;
	                f2 = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset, p_76986_9_);
	                f4 = MathHelper.wrapAngleTo180_float(f3 - f2);

	                if (f4 < -85.0F)
	                {
	                    f4 = -85.0F;
	                }

	                if (f4 >= 85.0F)
	                {
	                    f4 = 85.0F;
	                }

	                f2 = f3 - f4;

	                if (f4 * f4 > 2500.0F)
	                {
	                    f2 += f4 * 0.2F;
	                }
	            }

	            float f13 = p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_;
	            this.renderLivingAt(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
	            f4 = this.handleRotationFloat(p_76986_1_, p_76986_9_);
	            this.rotateCorpse(p_76986_1_, f4, f2, p_76986_9_);
	            float f5 = 0.0625F;
	            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	            GL11.glScalef(-1.0F, -1.0F, 1.0F);
	            this.preRenderCallback((AbstractClientPlayer)p_76986_1_, p_76986_9_);
	            GL11.glTranslatef(0.0F, -24.0F * f5 - 0.0078125F, 0.0F);
	            float f6 = p_76986_1_.prevLimbSwingAmount + (p_76986_1_.limbSwingAmount - p_76986_1_.prevLimbSwingAmount) * p_76986_9_;
	            float f7 = p_76986_1_.limbSwing - p_76986_1_.limbSwingAmount * (1.0F - p_76986_9_);

	            if (p_76986_1_.isChild())
	            {
	                f7 *= 3.0F;
	            }

	            if (f6 > 1.0F)
	            {
	                f6 = 1.0F;
	            }

	            GL11.glEnable(GL11.GL_ALPHA_TEST);
	            this.mainModel.setLivingAnimations(p_76986_1_, f7, f6, p_76986_9_);
	            this.renderModel(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);
	            int j;
	            float f8;
	            float f9;
	            float f10;

	            for (int i = 0; i < 4; ++i)
	            {
	            	/*
	                j = this.shouldRenderPass(p_76986_1_, i, p_76986_9_);

	                if (j > 0)
	                {
	                    this.renderPassModel.setLivingAnimations(p_76986_1_, f7, f6, p_76986_9_);
	                    this.renderPassModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);

	                    if ((j & 240) == 16)
	                    {
	                        this.func_82408_c(p_76986_1_, i, p_76986_9_);
	                        this.renderPassModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);
	                    }

	                    if ((j & 15) == 15)
	                    {
	                        f8 = (float)p_76986_1_.ticksExisted + p_76986_9_;
	                        this.bindTexture(RES_ITEM_GLINT);
	                        GL11.glEnable(GL11.GL_BLEND);
	                        f9 = 0.5F;
	                        GL11.glColor4f(f9, f9, f9, 1.0F);
	                        GL11.glDepthFunc(GL11.GL_EQUAL);
	                        GL11.glDepthMask(false);

	                        for (int k = 0; k < 2; ++k)
	                        {
	                            GL11.glDisable(GL11.GL_LIGHTING);
	                            f10 = 0.76F;
	                            GL11.glColor4f(0.5F * f10, 0.25F * f10, 0.8F * f10, 1.0F);
	                            GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
	                            GL11.glMatrixMode(GL11.GL_TEXTURE);
	                            GL11.glLoadIdentity();
	                            float f11 = f8 * (0.001F + (float)k * 0.003F) * 20.0F;
	                            float f12 = 0.33333334F;
	                            GL11.glScalef(f12, f12, f12);
	                            GL11.glRotatef(30.0F - (float)k * 60.0F, 0.0F, 0.0F, 1.0F);
	                            GL11.glTranslatef(0.0F, f11, 0.0F);
	                            GL11.glMatrixMode(GL11.GL_MODELVIEW);
	                            this.renderPassModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);
	                        }

	                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	                        GL11.glMatrixMode(GL11.GL_TEXTURE);
	                        GL11.glDepthMask(true);
	                        GL11.glLoadIdentity();
	                        GL11.glMatrixMode(GL11.GL_MODELVIEW);
	                        GL11.glEnable(GL11.GL_LIGHTING);
	                        GL11.glDisable(GL11.GL_BLEND);
	                        GL11.glDepthFunc(GL11.GL_LEQUAL);
	                    }

	                    GL11.glDisable(GL11.GL_BLEND);
	                    GL11.glEnable(GL11.GL_ALPHA_TEST);
	                }
	                */
	            }

	            GL11.glDepthMask(true);
	            //this.renderEquippedItems(p_76986_1_, p_76986_9_);
	            float f14 = p_76986_1_.getBrightness(p_76986_9_);
	            j = this.getColorMultiplier(p_76986_1_, f14, p_76986_9_);
	            OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);

	            if ((j >> 24 & 255) > 0 || p_76986_1_.hurtTime > 0 || p_76986_1_.deathTime > 0)
	            {
	                GL11.glDisable(GL11.GL_TEXTURE_2D);
	                GL11.glDisable(GL11.GL_ALPHA_TEST);
	                GL11.glEnable(GL11.GL_BLEND);
	                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	                GL11.glDepthFunc(GL11.GL_EQUAL);

	                if (p_76986_1_.hurtTime > 0 || p_76986_1_.deathTime > 0)
	                {
	                    GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
	                    this.mainModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);

	                    for (int l = 0; l < 4; ++l)
	                    {
	                    	/*
	                        if (this.inheritRenderPass(p_76986_1_, l, p_76986_9_) >= 0)
	                        {
	                            GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
	                            this.renderPassModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);
	                        }
	                        */
	                    }
	                }

	                if ((j >> 24 & 255) > 0)
	                {
	                    f8 = (float)(j >> 16 & 255) / 255.0F;
	                    f9 = (float)(j >> 8 & 255) / 255.0F;
	                    float f15 = (float)(j & 255) / 255.0F;
	                    f10 = (float)(j >> 24 & 255) / 255.0F;
	                    GL11.glColor4f(f8, f9, f15, f10);
	                    this.mainModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);

	                    /*
	                    for (int i1 = 0; i1 < 4; ++i1)
	                    {
	                        if (this.inheritRenderPass(p_76986_1_, i1, p_76986_9_) >= 0)
	                        {
	                            GL11.glColor4f(f8, f9, f15, f10);
	                            this.renderPassModel.render(p_76986_1_, f7, f6, f4, f3 - f2, f13, f5);
	                        }
	                    }
	                    */
	                }

	                GL11.glDepthFunc(GL11.GL_LEQUAL);
	                GL11.glDisable(GL11.GL_BLEND);
	                GL11.glEnable(GL11.GL_ALPHA_TEST);
	                GL11.glEnable(GL11.GL_TEXTURE_2D);
	            }

	            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        }
	        catch (Exception exception)
	        {
	            //logger.error("Couldn\'t render entity", exception);
	        }

	        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	        GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glPopMatrix();
	        //this.passSpecialRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
	        //MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(p_76986_1_, this, p_76986_2_, p_76986_4_, p_76986_6_));
	    }

	    protected float renderSwingProgress(EntityLivingBase p_77040_1_, float p_77040_2_)
	    {
	        return p_77040_1_.getSwingProgress(p_77040_2_);
	    }

	    private float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_)
	    {
	        float f3;

	        for (f3 = p_77034_2_ - p_77034_1_; f3 < -180.0F; f3 += 360.0F)
	        {
	            ;
	        }

	        while (f3 >= 180.0F)
	        {
	            f3 -= 360.0F;
	        }

	        return p_77034_1_ + p_77034_3_ * f3;
	    }

	    protected void renderLivingAt(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_)
	    {
	        GL11.glTranslatef((float)p_77039_2_, (float)p_77039_4_, (float)p_77039_6_);
	    }

	    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
	    {
	        return (float)p_77044_1_.ticksExisted + p_77044_2_;
	    }


	    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
	    {
	        GL11.glRotatef(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);

	        if (p_77043_1_.deathTime > 0)
	        {
	            float f3 = ((float)p_77043_1_.deathTime + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
	            f3 = MathHelper.sqrt_float(f3);

	            if (f3 > 1.0F)
	            {
	                f3 = 1.0F;
	            }

	            GL11.glRotatef(f3 * this.getDeathMaxRotation(p_77043_1_), 0.0F, 0.0F, 1.0F);
	        }
	        else
	        {
	            String s = EnumChatFormatting.getTextWithoutFormattingCodes(p_77043_1_.getCommandSenderName());

	            if ((s.equals("Dinnerbone") || s.equals("Grumm")) && (!(p_77043_1_ instanceof EntityPlayer) || !((EntityPlayer)p_77043_1_).getHideCape()))
	            {
	                GL11.glTranslatef(0.0F, p_77043_1_.height + 0.1F, 0.0F);
	                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            }
	        }
	    }

	    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_)
	    {
	        return 90.0F;
	    }

	    protected void renderModel(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_)
	    {
	        this.bindEntityTexture(p_77036_1_);

	        if (!p_77036_1_.isInvisible())
	        {
	            this.mainModel.render(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	        }
	        else if (!p_77036_1_.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer))
	        {
	            GL11.glPushMatrix();
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
	            GL11.glDepthMask(false);
	            GL11.glEnable(GL11.GL_BLEND);
	            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	            GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
	            this.mainModel.render(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	            GL11.glDisable(GL11.GL_BLEND);
	            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	            GL11.glPopMatrix();
	            GL11.glDepthMask(true);
	        }
	        else
	        {
	            this.mainModel.setRotationAngles(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, p_77036_1_);
	        }
	    }

	    protected void bindEntityTexture(Entity p_110777_1_)
	    {
	        this.bindTexture(this.getEntityTexture((AbstractClientPlayer)p_110777_1_));
	    }

	    protected void bindTexture(ResourceLocation p_110776_1_)
	    {
	    	RenderManager.instance.renderEngine.bindTexture(p_110776_1_);
	    }

	    protected ResourceLocation getEntityTexture(AbstractClientPlayer p_110775_1_)
	    {
	      return p_110775_1_.getLocationSkin();
	    }

	    protected void preRenderCallback(AbstractClientPlayer p_77041_1_, float p_77041_2_)
	    {
	      float f1 = 0.9375F;
	      GL11.glScalef(f1, f1, f1);
	    }

	    protected int getColorMultiplier(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_)
	    {
	        return 0;
	    }

	    /*
	    protected int shouldRenderPass(AbstractClientPlayer p_77032_1_, int p_77032_2_, float p_77032_3_)
	    {
	      ItemStack itemstack = p_77032_1_.inventory.armorItemInSlot(3 - p_77032_2_);

	      RenderPlayerEvent.SetArmorModel event = new RenderPlayerEvent.SetArmorModel(p_77032_1_, this, 3 - p_77032_2_, p_77032_3_, itemstack);
	      MinecraftForge.EVENT_BUS.post(event);
	      if (event.result != -1) {
	        return event.result;
	      }
	      if (itemstack != null)
	      {
	        Item item = itemstack.getItem();
	        if ((item instanceof ItemArmor))
	        {
	          ItemArmor itemarmor = (ItemArmor)item;
	          bindTexture(RenderBiped.getArmorResource(p_77032_1_, itemstack, p_77032_2_, null));
	          ModelBiped modelbiped = p_77032_2_ == 2 ? this.modelArmor : this.modelArmorChestplate;
	          modelbiped.bipedHead.showModel = (p_77032_2_ == 0);
	          modelbiped.bipedHeadwear.showModel = (p_77032_2_ == 0);
	          modelbiped.bipedBody.showModel = ((p_77032_2_ == 1) || (p_77032_2_ == 2));
	          modelbiped.bipedRightArm.showModel = (p_77032_2_ == 1);
	          modelbiped.bipedLeftArm.showModel = (p_77032_2_ == 1);
	          modelbiped.bipedRightLeg.showModel = ((p_77032_2_ == 2) || (p_77032_2_ == 3));
	          modelbiped.bipedLeftLeg.showModel = ((p_77032_2_ == 2) || (p_77032_2_ == 3));
	          modelbiped = ForgeHooksClient.getArmorModel(p_77032_1_, itemstack, p_77032_2_, modelbiped);
	          setRenderPassModel(modelbiped);
	          modelbiped.onGround = this.mainModel.onGround;
	          modelbiped.isRiding = this.mainModel.isRiding;
	          modelbiped.isChild = this.mainModel.isChild;


	          int j = itemarmor.getColor(itemstack);
	          if (j != -1)
	          {
	            float f1 = (j >> 16 & 0xFF) / 255.0F;
	            float f2 = (j >> 8 & 0xFF) / 255.0F;
	            float f3 = (j & 0xFF) / 255.0F;
	            GL11.glColor3f(f1, f2, f3);
	            if (itemstack.isItemEnchanted()) {
	              return 31;
	            }
	            return 16;
	          }
	          GL11.glColor3f(1.0F, 1.0F, 1.0F);
	          if (itemstack.isItemEnchanted()) {
	            return 15;
	          }
	          return 1;
	        }
	      }
	      return -1;
	    }
	    */

}
