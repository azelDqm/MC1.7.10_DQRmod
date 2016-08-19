package dqr.gui.playerHUD;


import java.util.Collection;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.potion.DQPotionEtc;
import dqr.potion.DqmPotionBase;

//
// GuiBuffBar implements a simple status bar at the top of the screen which
// shows the current buffs/debuffs applied to the character.
//
public class GuiBuffBar extends Gui
{
  private Minecraft mc;

  public GuiBuffBar(Minecraft mc)
  {
    super();

    // We need this to invoke the render engine.
    this.mc = mc;
  }

  private static final int BUFF_ICON_SIZE = 18;
  private static final int BUFF_ICON_SPACING = BUFF_ICON_SIZE + 2; // 2 pixels between buff icons
  private static final int BUFF_ICON_BASE_U_OFFSET = 0;
  private static final int BUFF_ICON_BASE_V_OFFSET = 198;
  private static final int BUFF_ICONS_PER_ROW = 8;


  //
  // This event is called by GuiIngameForge during each frame by
  // GuiIngameForge.pre() and GuiIngameForce.post().
  //
  @SubscribeEvent
  public void onRenderExperienceBar(RenderGameOverlayEvent event)
  {
	  ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	  int w = sr.getScaledWidth();


    //
    // We draw after the ExperienceBar has drawn.  The event raised by GuiIngameForge.pre()
    // will return true from isCancelable.  If you call event.setCanceled(true) in
    // that case, the portion of rendering which this event represents will be canceled.
    // We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
    // false and that the eventType represents the ExperienceBar event.
    if(event.isCancelable() ||(event.type != ElementType.EXPERIENCE && event.type != ElementType.JUMPBAR))
    {
      return;
    }

    int var1 = w - 124;
    int var2 = 0;
    int h = sr.getScaledHeight();
    boolean var3 = true;
    Collection var4 = this.mc.thePlayer.getActivePotionEffects();

    switch (DQR.conf.CLGuiBuffBarPos)
    {
        case 1:
            var1 = 0;
            var2 = 2;
            break;

        case 2:
            var1 = 0;
            var2 = h / 4 - 75;
            break;

        case 3:
            var1 = 0;
            var2 = h / 2 - 75;
            break;

        case 4:
            var1 = 0;
            var2 = h / 4 * 3 - 75;
            break;

        case 5:
            var1 = 0;
            var2 = h - 150;
            break;

        case 6:
            var1 = w - 120;
            var2 = 2 ;
            break;

        case 7:
            var1 = w - 120;
            var2 = h / 4 - 75 ;
            break;

        case 8:
            var1 = w - 120;
            var2 = h / 2 - 75;
            break;

        case 9:
            var1 = w - 120;
            var2 = h / 4 * 3 - 75;
            break;

        case 10:
            var1 = w - 120;
            var2 = h - 150;
            break;

        case 11:
            var1 = w / 2 - 60;
            var2 = 2 ;
            break;

        case 12:
            var1 = w / 2 - 60;
            var2 = h / 4 - 75 ;
            break;

        case 13:
            var1 = w / 2 - 60;
            var2 = h / 2 - 75;
            break;

        case 14:
            var1 = w / 2 - 60;
            var2 = h / 4 * 3 - 75;
            break;

        case 15:
            var1 = w / 2 - 60;
            var2 = h - 150;
            break;

        default:
            var1 = 0;
            var2 = 0;
            break;
    }

    var1 = var1 + DQR.conf.CLGuiBuffBarPosX;
    var2 = var2 + DQR.conf.CLGuiBuffBarPosY;

    if(DQR.conf.CLGuiBuffBarVis == 0)
    {
    	return;
    }

    int effectCnt = 0;

    if (!var4.isEmpty())
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int var5 = 25;

        if (var4.size() > 5)
        {
            var5 = 132 / (var4.size() - 1);
        }

        for (Iterator var6 = this.mc.thePlayer.getActivePotionEffects().iterator(); var6.hasNext(); var2 += var5)
        {
        	effectCnt++;

            PotionEffect var7 = (PotionEffect)var6.next();
            Potion var8 = Potion.potionTypes[var7.getPotionID()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            //this.mc.getTextureManager().bindTexture(field_147001_a);
            //ResourceLocation reLoc = new ResourceLocation("dqm","textures/gui/inventory.png");
            //this.mc.renderEngine.bindTexture(reLoc);
            //this.drawTexturedModalRect(var1, var2, 0, 166, 140, 25);

            if(var8 instanceof DqmPotionBase)
            {
                ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/potionEffect.png");
                this.mc.renderEngine.bindTexture(reLoc);
                //this.drawTexturedModalRect(var1, var2, 0, 166, 140, 25);
                if(DQR.conf.guiPositionTarget ==6 && DQR.conf.guiPositionMode == 1)
                {
                	//this.drawTexturedModalRect(var1, var2, 0, 141, 125, 25);
                	this.drawTexturedModalRect(var1, var2, 0, 141, 125, 25);
                }else
                {
                	//this.drawTexturedModalRect(var1, var2, 0, 166, 125, 25);
                	this.drawTexturedModalRect(var1, var2, 0, 166, 125, 25);
                }

                DqmPotionBase var21 = (DqmPotionBase)var8;

                int var22 = var21.icon_x;
                int var23 = var21.icon_y;
                //System.out.println("DEBUG: x= " + var22 + "/ y= " + var23);
                if(var8.id == DQPotionEtc.buffMahouken.id)
                {
                	 this.drawTexturedModalRect(var1 + 6, var2 + 4, 90, 90, 18, 18);
                }
                this.drawTexturedModalRect(var1 + 6, var2 + 4, var22, var23, 18, 18);
            }else
            {
                ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/inventory.png");
                this.mc.renderEngine.bindTexture(reLoc);
                if(DQR.conf.guiPositionTarget ==6 && DQR.conf.guiPositionMode == 1)
                {
                	//this.drawTexturedModalRect(var1, var2, 130, 166, 125, 25);
                	this.drawTexturedModalRect(var1, var2, 130, 166, 125, 25);
                }else
                {
                	//this.drawTexturedModalRect(var1, var2, 0, 166, 125, 25);
                	this.drawTexturedModalRect(var1, var2, 0, 166, 125, 25);
                }

	            if (var8.hasStatusIcon())
	            {
	                int var9 = var8.getStatusIconIndex();
	                this.drawTexturedModalRect(var1 + 6, var2 + 4, 0 + var9 % 8 * 18, 198 + var9 / 8 * 18, 18, 18);
	            }
            }

            String var11 = I18n.format(var8.getName(), new Object[0]);

            //var11 = var11 + " " + I18n.format("dqr:amplider.level." + (var7.getAmplifier() + 1), new Object[0]);
            if(var8.id == DQPotionEtc.buffMahouken.id)
            {
            	var11 = var11 + " " + I18n.format("mahouken.name." + var7.getAmplifier(), new Object[0]);
            }else
            {
	            if (var7.getAmplifier() < 15)
	            {
	            	var11 = var11 + " " + I18n.format("amplider.level." + (var7.getAmplifier() + 1), new Object[0]);
	            }else
	            {
	            	var11 = var11 + " " + (var7.getAmplifier() + 1);
	            }
            }

            mc.fontRenderer.drawStringWithShadow(var11, var1 + 10 + 18, var2 + 5, 0xffffffff);
            String var10 = Potion.getDurationString(var7);
            mc.fontRenderer.drawStringWithShadow(var10, var1 + 10 + 18, var2 + 5 + 9, 0xffffffff);
        }
    }

    if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 6)
    {
    	//System.out.println("DEBUG+" + effectCnt);
    	if(effectCnt < 6)
    	{
            for (int cnt = 0 + effectCnt; cnt < 6; cnt++)
            {

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/potionEffect.png");
                this.mc.renderEngine.bindTexture(reLoc);
                //this.drawTexturedModalRect(var1, var2, 0, 166, 140, 25);
                if(DQR.conf.guiPositionTarget ==6)
                {
                	this.drawTexturedModalRect(var1, var2 + (25 * cnt), 0, 141, 125, 25);
                }else
                {
                	this.drawTexturedModalRect(var1, var2 + (25 * cnt), 0, 166, 125, 25);
                }
            }
    	}
    }

  }
}
