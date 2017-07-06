package dqr.gui.playerHUD;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiPlayerSubpoint extends Gui
{
  private Minecraft mc;

  public GuiPlayerSubpoint(Minecraft mc)
  {
    super();

    // We need this to invoke the render engine.
    this.mc = mc;
  }



  //
  // This event is called by GuiIngameForge during each frame by
  // GuiIngameForge.pre() and GuiIngameForce.post().
  //
  @SubscribeEvent
  public void onRenderPlayerStatus(RenderGameOverlayEvent event)
  {
		if(event.isCancelable() || (event.type != ElementType.EXPERIENCE && event.type != ElementType.JUMPBAR))
		{
		  return;
		}

	  //ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	  //int w = sr.getScaledWidth();
	  int padW = 2;
	  int padH = 2;
      int y0 = 0;
      int y1 = 0;
      int y2 = 0;

      ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
      int w = sr.getScaledWidth(), h = sr.getScaledHeight();
      int x = 0; //= contains(pos, 1, 2)? w - padW - mc.fontRenderer.getStringWidth("Lv10 EXP 100000/10000000 SP50"): padW;
      int y = 0; // = contains(pos, 0, 1)? h - padH - 10: padH;
      /*
      x = padW;
      y0 = h - 22 ;
      y1 = h - 20;
      y2 = h - 12  ;
      y3 = 20;
      y4 = 28;
      ResourceLocation reLoc = new ResourceLocation("dqm","textures/gui/mpStatus.png");
      mc.renderEngine.bindTexture(reLoc);
      this.drawTexturedModalRect(x, y0, 0, 0, 150, 50);
      mc.fontRenderer.drawStringWithShadow("遊人 Lv99 SP 100", x + 5 , y1, 0xffffffff);
      mc.fontRenderer.drawStringWithShadow("HP2000/2000", x + 5, y2, 0xffffffff);
	*/

      EntityPlayer ep = DQR.proxy.getEntityPlayerInstance();

      if(ep == null)
      {
    	  return;
      }


      if (DQR.conf.CLGuiSubpointsVis == 1)
      {
          y0 = 0;
          y1 = 0;
          y2 = 0;


          switch (DQR.conf.CLGuiSubpointsPos)
          {
              case 1:
                  x = padW;
                  y0 = 2;
                  break;

              case 2:
                  x = padW;
                  y0 = h / 4 - 14;
                  break;

              case 3:
                  x = padW;
                  y0 = h / 2 - 14;
                  break;

              case 4:
                  x = padW;
                  y0 = h / 4 * 3 - 14;
                  break;

              case 5:
                  x = padW;
                  y0 = h - 28;
                  break;

              case 6:
                  x = w - 105;
                  y0 = 2 ;
                  break;

              case 7:
                  x = w - 105;
                  y0 = h / 4 - 14;
                  break;

              case 8:
                  x = w - 105;
                  y0 = h / 2 - 14;
                  break;

              case 9:
                  x = w - 105;
                  y0 = h / 4 * 3 - 14;
                  break;

              case 10:
                  x = w - 105;
                  y0 = h - 28;
                  break;

              case 11:
                  x = w / 2 - 60;
                  y0 = 2 ;
                  break;

              case 12:
                  x = w / 2 - 60;
                  y0 = h / 4 - 14;
                  break;

              case 13:
                  x = w / 2 - 60;
                  y0 = h / 2 - 14;
                  break;

              case 14:
                  x = w / 2 - 60;
                  y0 = h / 4 * 3 - 14;
                  break;

              case 15:
                  x = w / 2 - 60;
                  y0 = h - 28;
                  break;

              default:
                  x = padW;
                  y0 = 2;
                  break;
          }

          x = x + DQR.conf.CLGuiSubpointsPosX;
          y0 =y0 + DQR.conf.CLGuiSubpointsPosY;

          int MEDAL = ExtendedPlayerProperties.get(ep).getMedal();
          int COIN = ExtendedPlayerProperties3.get(ep).getCoin();

          String sMedal = I18n.format("gui.status.medal", new Object[]{MEDAL});
          String sCoin = I18n.format("gui.status.coin", new Object[]{COIN});

          y1 = y0 + 4;
          y2 = y0 + 13;

          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          ResourceLocation reLoc;// = new ResourceLocation("dqm","textures/gui/mpStatus3.png");
    	  if(DQR.conf.guiPositionTarget ==5 && DQR.conf.guiPositionMode == 1)
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus4_Edit.png");
    	  }else
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus4.png");
    	  }

          mc.renderEngine.bindTexture(reLoc);
          this.drawTexturedModalRect(x, y0, 0, 0, 150, 27);

          mc.fontRenderer.drawStringWithShadow(sMedal, x + 5, y1, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sCoin, x + 5, y2, 0xffffffff);

      }
  }
}
