package dqr.gui.playerHUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class GuiPositionMode extends Gui
{
  private Minecraft mc;

  public GuiPositionMode(Minecraft mc)
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

		OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
	  //ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	  //int w = sr.getScaledWidth();
	  int padW = 2;
	  int padH = 2;
      int y0 = 0;
      int y1 = 0;
      int y2 = 0;
      int y3 = 0;
      int nextY = 0;

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


      if (DQR.conf.guiPositionMode == 1)
      {
          y0 = 0;
          y1 = 0;
          y2 = 0;
          y3 = 0;
          //y4 = 0;
          //y5 = 0;
          //y6 = 0;
          //y7 = 0;

          x = w / 2 - 85;
          y0 = h / 2 - 45;



          String title = I18n.format("gui.position.name");
          String targetGUI =  I18n.format("gui.position.guiname." + DQR.conf.guiPositionTarget);
          String line1 = I18n.format("gui.position.line.1", new Object[]{targetGUI});
          String line2 = I18n.format("gui.position.line.2", new Object[]{DQR.conf.guiPositionSpeed});


          y1 = y0 + 3;
          y2 = y0 + 21;
          y3 = y0 + 32;

          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          ResourceLocation reLoc;// = new ResourceLocation("dqm","textures/gui/mpStatus3.png");
          reLoc = new ResourceLocation("dqr","textures/gui/guiEditMode.png");
          mc.renderEngine.bindTexture(reLoc);
          this.drawTexturedModalRect(x, y0, 0, 0, 170, 101);
          mc.fontRenderer.drawStringWithShadow(title, x + 5 , y1, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(line1, x + 5 , y2, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(line2, x + 5, y3, 0xffffffff);
          nextY = y3;
          if(DQR.conf.guiPositionTarget == 7)
          {
        	  String addLine = I18n.format("gui.position.line.3", new Object[]{DQR.conf.CLGuiPartyReturnLine});
        	  mc.fontRenderer.drawStringWithShadow(addLine, x + 5, y3 + 11, 0xffffffff);
        	  nextY = y3 + 11;
          }
          //定型移動用
          int modeKeyCode = -1;
          switch (DQR.conf.guiPositionTarget)
	      {
          		case 1: modeKeyCode = DQR.CLKeyBind.keyGuiPlayerData.getKeyCode(); break;
          		case 2: modeKeyCode = DQR.CLKeyBind.keyGuiPlayerStatus.getKeyCode(); break;
          		case 3: modeKeyCode = DQR.CLKeyBind.keyGuiArmorStatus.getKeyCode(); break;
          		case 4: modeKeyCode = DQR.CLKeyBind.keyGuiLog.getKeyCode(); break;
          		case 5: modeKeyCode = DQR.CLKeyBind.keyGuiSubpoints.getKeyCode(); break;
          		case 6: modeKeyCode = DQR.CLKeyBind.keyGuiBuffBar.getKeyCode(); break;
          		case 7: modeKeyCode = DQR.CLKeyBind.keyGuiParty.getKeyCode(); break;
          		case 8: modeKeyCode = DQR.CLKeyBind.keyGuiBuffBar2.getKeyCode(); break;
          		default :
	      }
          //操作方法
          if(DQR.conf.guiPositionTarget != 0)
          {
	          mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.4", new Object[]{DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionSpeed.getKeyCode())}),
	        		  x + 5, nextY + 15, 0xffffffff);
	          mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.5", new Object[]{DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionUP.getKeyCode()),
	        		  																			   DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionDOWN.getKeyCode()),
	        		  																			   DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionLEFT.getKeyCode()),
	        		  																			   DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionRIGHT.getKeyCode())}),
	        		  x + 5, nextY + 26, 0xffffffff);
	          mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.6", new Object[]{DQR.func.getKeyDisplayString(modeKeyCode)}),
	        		  x + 5, nextY + 37, 0xffffffff);
          }
          if(DQR.conf.guiPositionTarget == 7)
          {
        	  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.9", new Object[]{DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPartyPlus.getKeyCode()),
        			  																			   DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPartyMinus.getKeyCode())}),
            		  x + 5, nextY + 48, 0xffffffff);
          }

          if(DQR.conf.guiPositionTarget == 4)
          {
        	  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.7", new Object[]{}),
            		  x + 5, nextY + 48, 0xffffffff);
        	  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.8", new Object[]{DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyLogDel.getKeyCode())}),
            		  x + 5, nextY + 59, 0xffffffff);
          }

          if(DQR.conf.guiPositionTarget == 6)
          {
        	  if(DQR.conf.CLGuiBuffBarMode == 1)
        	  {
        		  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.10.1", new Object[]{}),
        				  x + 5, nextY + 48, 0xffffffff);
        	  }else
        	  {
        		  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.10.0", new Object[]{}),
        				  x + 5, nextY + 48, 0xffffffff);
        	  }
        	  mc.fontRenderer.drawStringWithShadow(I18n.format("gui.position.line.11", new Object[]{DQR.conf.CLGuiBuffBarDispAreaHeight}),
            		  x + 5, nextY + 59, 0xffffffff);
          }
          //String addLine = DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyGuiPositionDOWN.getKeyCode());
          //mc.fontRenderer.drawStringWithShadow(addLine, x + 5, y3 + 12, 0xffffffff);


      }
  }
}
