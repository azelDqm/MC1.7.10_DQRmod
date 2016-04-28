package dqr.items.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderBow implements IItemRenderer
{
	private static final ResourceLocation ENCHANTED_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    //private ModelBase modeling;
    public ItemRenderBow()
    {
        //modeling = new ModelBase();
    }
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        switch(type)
        {
            case EQUIPPED :
                return true;
            default:
                return false;
        }
    }
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return false;
    }
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.6F, -0.6F, -0.25F);
        GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(-128.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-10.0F, 1.0F, 0.0F, 1.0F);
        render((EntityLivingBase)data[1], item, 0);
        GL11.glPopMatrix();
    	/*
        switch(type)
        {
            case EQUIPPED :
            {

        		//ItemRenderer itemRenderer = new ItemRenderer(mc);


        		ItemStack itemstack1 = new ItemStack(DQWeapons.itemBigbougan, 1);


        		if (itemstack1 != null && itemstack1.getItem() instanceof DqmItemBowBase)
                {

                    GL11.glPushMatrix();
                    //event.renderer.modelArmor.bipedRightArm.postRender(0.0625F);
                    GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);


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
                            //itemRenderer.renderItem(ep, itemstack1, k);
                        }
                    }
                    else
                    {
                        k = itemstack1.getItem().getColorFromItemStack(itemstack1, 0);
                        float f11 = (float)(k >> 16 & 255) / 255.0F;
                        f12 = (float)(k >> 8 & 255) / 255.0F;
                        f3 = (float)(k & 255) / 255.0F;
                        GL11.glColor4f(f11, f12, f3, 1.0F);
                        //itemRenderer.renderItem(ep, itemstack1, 0);
                    }

                    GL11.glPopMatrix();

                }

                //GL11.glPushMatrix();


                float scala = 2.5F;

                GL11.glScalef(scala, scala, scala);

                GL11.glRotatef(0F, -10.0F, 0.0F, 0.0F);
                GL11.glRotatef(8F, 0.0F, -10.0F, 0.0F);
                GL11.glRotatef(125F, 0.0F, 0.0F, -10.0F);

                GL11.glTranslatef(-0.304800F, -0.500F, -0.09F);

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CustomModelTools.domain, "textures/model/" + CustomModelTools.texture + ".png"));

                modeling.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                //GL11.glPopMatrix();
            }
            default:
                break;
         }
         */
    }


    private void render(EntityLivingBase entityLivingBase, ItemStack itemStack, int renderPass)
    {
      GL11.glPushMatrix();
      //TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
      TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
      IIcon icon = entityLivingBase.getItemIcon(itemStack, renderPass);
      if (icon == null)
      {
        GL11.glPopMatrix();
        return;
      }
      //texturemanager.func_110577_a(texturemanager.func_130087_a(itemStack.func_94608_d()));
      texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
      Tessellator tessellator = Tessellator.instance;;
      //float f = icon.func_94209_e();
      float f = icon.getMinU();
      //float f1 = icon.func_94212_f();
      float f1 = icon.getMaxU();
      //float f2 = icon.func_94206_g();
      float f2 = icon.getMinV();
      //float f3 = icon.func_94210_h();
      float f3 = icon.getMaxV();
      float f4 = 0.0F;
      float f5 = 0.3F;
      GL11.glEnable(32826);
      GL11.glTranslatef(-f4, -f5, 0.0F);
      float f6 = 1.5F;
      GL11.glScalef(f6, f6, f6);
      GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
      //ItemRenderer.func_78439_a(tessellator, f1, f2, f, f3, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
      ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
      if (itemStack.hasEffect(renderPass))
      {
        GL11.glDepthFunc(514);
        GL11.glDisable(2896);
        texturemanager.bindTexture(ENCHANTED_ITEM_GLINT);
        GL11.glEnable(3042);
        GL11.glBlendFunc(768, 1);
        float f7 = 0.76F;
        GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
        GL11.glMatrixMode(5890);
        GL11.glPushMatrix();
        float f8 = 0.125F;
        GL11.glScalef(f8, f8, f8);
        float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
        GL11.glTranslatef(f9, 0.0F, 0.0F);
        GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
        ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(f8, f8, f8);
        f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
        GL11.glTranslatef(-f9, 0.0F, 0.0F);
        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
        ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glDepthFunc(515);
      }
      GL11.glDisable(32826);
      GL11.glPopMatrix();
    }

}