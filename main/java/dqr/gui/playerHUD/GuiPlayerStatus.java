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

public class GuiPlayerStatus extends Gui
{
  private Minecraft mc;

  public GuiPlayerStatus(Minecraft mc)
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
      int y3 = 0;
      int y4 = 0;
      int y5 = 0;
      int y6 = 0;
      int y7 = 0;
      int y8 = 0;
      int y9 = 0;
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


      if (DQR.conf.CLGuiVis2 == 1)
      {
          y0 = 0;
          y1 = 0;
          y2 = 0;
          y3 = 0;
          y4 = 0;
          y5 = 0;
          y6 = 0;
          y7 = 0;

          switch (DQR.conf.CLGuiPos2)
          {
              case 1:
                  x = padW;
                  y0 = 2;
                  break;

              case 2:
                  x = padW;
                  y0 = h / 4 - 36;
                  break;

              case 3:
                  x = padW;
                  y0 = h / 2 - 36;
                  break;

              case 4:
                  x = padW;
                  y0 = h / 4 * 3 - 36;
                  break;

              case 5:
                  x = padW;
                  y0 = h - 72;
                  break;

              case 6:
                  x = w - 105;
                  y0 = 2 ;
                  break;

              case 7:
                  x = w - 105;
                  y0 = h / 4 - 36;
                  break;

              case 8:
                  x = w - 105;
                  y0 = h / 2 - 36;
                  break;

              case 9:
                  x = w - 105;
                  y0 = h / 4 * 3 - 36;
                  break;

              case 10:
                  x = w - 105;
                  y0 = h - 72;
                  break;

              case 11:
                  x = w / 2 - 60;
                  y0 = 2 ;
                  break;

              case 12:
                  x = w / 2 - 60;
                  y0 = h / 4 - 36;
                  break;

              case 13:
                  x = w / 2 - 60;
                  y0 = h / 2 - 36;
                  break;

              case 14:
                  x = w / 2 - 60;
                  y0 = h / 4 * 3 - 36;
                  break;

              case 15:
                  x = w / 2 - 60;
                  y0 = h - 72;
                  break;

              default:
                  x = padW;
                  y0 = 2;
                  break;
          }

          x = x + DQR.conf.CLGuiPos2X;
          y0 =y0 + DQR.conf.CLGuiPos2Y;

          int Weapon = ExtendedPlayerProperties.get(ep).getWeapon();
          int ATK = ExtendedPlayerProperties.get(ep).getKougeki();
          int DEF = (int)ExtendedPlayerProperties.get(ep).getBougyo();
          int MAG =  (int)ExtendedPlayerProperties.get(ep).getMaryoku();
          int STR =  ExtendedPlayerProperties.get(ep).getTikara();
          int AGI = ExtendedPlayerProperties.get(ep).getMikawasi();
          int INT = ExtendedPlayerProperties.get(ep).getKasikosa();
          int GOLD = ExtendedPlayerProperties.get(ep).getGold();
          int MEDAL = ExtendedPlayerProperties.get(ep).getMedal();
          int COIN = ExtendedPlayerProperties.get(ep).getCoin();
          int Jukuren = ExtendedPlayerProperties.get(ep).getJukurenLv(Weapon);
          int JukurenEXP = ExtendedPlayerProperties.get(ep).getJukurenExp(Weapon);
          int JukurenWP = ExtendedPlayerProperties.get(ep).getJukurenWP(Weapon);

          String weaponName = I18n.format("gui.weapon." + Weapon);
          String sJukuren1 = I18n.format("gui.status.skill", new Object[]{weaponName, Jukuren, JukurenWP});
          String sJukuren2;
          String sKougeki = I18n.format("gui.status.attack", new Object[]{ATK, STR});
          String sMamori = I18n.format("gui.status.gurd", new Object[]{DEF, AGI});
          String sMaryoku = I18n.format("gui.status.magic", new Object[]{MAG, INT});
          String sGold = I18n.format("gui.status.gold", new Object[]{GOLD});


          if(Jukuren == 10)
          {
        	  sJukuren2 = I18n.format("gui.status.abilityMax");
          }else
          {
        	  sJukuren2 = I18n.format("gui.status.ability", new Object[]{JukurenEXP, DQR.exp.getJukurenNextExp(Jukuren)});
          }

          y1 = y0 + 3;
          y2 = y0 + 12;
          y3 = y0 + 25;
          y4 = y0 + 34;
          y5 = y0 + 43;
          y6 = y0 + 43;
          y7 = y0 + 56;
          y8 = y0 + 65;
          y9 = y0 + 74;

          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          ResourceLocation reLoc;// = new ResourceLocation("dqm","textures/gui/mpStatus3.png");
    	  if(DQR.conf.guiPositionTarget ==2 && DQR.conf.guiPositionMode == 1)
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus3_Edit.png");
    	  }else
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus3.png");
    	  }

          mc.renderEngine.bindTexture(reLoc);
          this.drawTexturedModalRect(x, y0, 0, 0, 150, 90);
          mc.fontRenderer.drawStringWithShadow(sJukuren1, x + 5 , y1, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sJukuren2, x + 5 , y2, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sKougeki, x + 5, y3, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMamori, x + 5, y4, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMaryoku, x + 5, y5, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow("", x + 5, y6, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sGold, x + 5, y7, 0xffffffff);

      }
  }
}
