package dqr.gui.playerHUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class GuiLogger extends Gui
{
  //private Minecraft mc;
	private final Minecraft mc;

  public GuiLogger(Minecraft mc)
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


      if (DQR.conf.CLGuiLogVis == 1)
      {
          y0 = 0;
          y1 = 0;
          y2 = 0;
          y3 = 0;
          y4 = 0;
          y5 = 0;
          y6 = 0;
          y7 = 0;
          y8 = 0;

          //switch (DQR.conf.CLGuiPos2)
          switch (DQR.conf.CLGuiLogPos)
          {
	          case 1:
	              x = padW;
	              y0 = 2;
	              break;

	          case 2:
	              x = padW;
	              y0 = h / 4 - 40;
	              break;

	          case 3:
	              x = padW;
	              y0 = h / 2 - 40;
	              break;

	          case 4:
	              x = padW;
	              y0 = h / 4 * 3 - 40 ;
	              break;

	          case 5:
	              x = padW;
	              y0 = h - 80;
	              break;

	          case 6:
	              x = w - 258;
	              y0 = 2 ;
	              break;

	          case 7:
	              x = w - 258;
	              y0 = h / 4 - 40 ;
	              break;

	          case 8:
	              x = w - 258;
	              y0 = h / 2 - 40 ;
	              break;

	          case 9:
	              x = w - 258;
	              y0 = h / 4 * 3 - 40;
	              break;

	          case 10:
	              x = w - 258;
	              y0 = h - 80;
	              break;

	          case 11:
	              x = w / 2 - 129;
	              y0 = 2 ;
	              break;

	          case 12:
	              x = w / 2 - 129;
	              y0 = h / 4 - 40;
	              break;

	          case 13:
	              x = w / 2 - 129;
	              y0 = h / 2 - 40;
	              break;

	          case 14:
	              x = w / 2 - 129;
	              y0 = h / 4 * 3 - 40;
	              break;

	          case 15:
	              x = w / 2 - 129;
	              y0 = h - 80;
	              break;

	          default:
	              x = padW;
	              y0 = 2;
	              break;
          }

          x = x + DQR.conf.CLGuiLogPosX;
          y0 =y0 + DQR.conf.CLGuiLogPosY;

          y1 = y0 + 2;
          y2 = y0 + 11;
          y3 = y0 + 20;
          y4 = y0 + 29;
          y5 = y0 + 38;
          y6 = y0 + 47;
          y7 = y0 + 56;
          y8 = y0 + 65;

          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          ResourceLocation reLoc;// = new ResourceLocation("dqr","textures/gui/mpLog.png");
    	  if(DQR.conf.guiPositionTarget ==4 && DQR.conf.guiPositionMode == 1)
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpLog_Edit.png");
    	  }else
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpLog.png");
    	  }
          mc.renderEngine.bindTexture(reLoc);
          this.drawTexturedModalRect(x, y0, 0, 0, 256, 80);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[0], x + 3 , y1, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[1], x + 3, y2, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[2], x + 3, y3, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[3], x + 3, y4, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[4], x + 3, y5, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[5], x + 3, y6, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[6], x + 3, y7, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(DQR.dqmLog[7], x + 3, y8, 0xffffffff);

    	  /*
    	  if(damageStr[2] != null)
    	  {
    		  mc.fontRenderer.drawStringWithShadow(damageStr[1], x + 16, y2 + 4, 0xffffffff);
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[2], x, y2);
    	  }

    	  if(damageStr[1] != null)
    	  {
    		  mc.fontRenderer.drawStringWithShadow(damageStr[1], x + 16, y3 + 4, 0xffffffff);
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[1], x, y3);
    	  }

    	  if(damageStr[0] != null)
    	  {
    		  mc.fontRenderer.drawStringWithShadow(damageStr[0], x + 16, y4 + 4, 0xffffffff);
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[0], x, y4);
    	  }
    	  */
        	  //itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), ep.inventory.armorInventory[1], x, y0);
        	  //mc.fontRenderer.drawStringWithShadow(itemIcon[1].getIconName(), x + 5 , y2, 0xffffffff);

          //mc.fontRenderer.drawStringWithShadow(test + "", x + 5 , y1, 0xffffffff);


          /*
          mc.fontRenderer.drawStringWithShadow(sKougeki, x + 5, y3, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMamori, x + 5, y4, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMaryoku, x + 5, y5, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow("", x + 5, y6, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sGold, x + 5, y7, 0xffffffff);
          */

      }
  }
}
