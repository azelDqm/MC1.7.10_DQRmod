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

public class GuiPlayerData extends Gui
{
  private Minecraft mc;

  public GuiPlayerData(Minecraft mc)
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

      //System.out.println(ExtendedPlayerProperties.get(ep).getPlayerName());
      //System.out.println(ep.getCommandSenderName());
      if(!ep.getCommandSenderName().equalsIgnoreCase(ExtendedPlayerProperties.get(ep).getPlayerName()))
      {
    	  return;
      }

      if (DQR.conf.CLGuiVis1 == 1)
      {
          //int test = 0;

          //switch (test)
          switch (DQR.conf.CLGuiPos1)
          {
              case 0:
               /*
              	x = setX(w, DQR.smpPosSetCX0, DQR.smpPosSetCX);
              	y0 =setY(h ,0, DQR.smpPosSetCY0, DQR.smpPosSetCY);
              	y1 =setY(h ,1, DQR.smpPosSetCY0, DQR.smpPosSetCY);
              	y2 =setY(h ,2, DQR.smpPosSetCY0, DQR.smpPosSetCY);
              	y3 = setY(h ,3, DQR.smpPosSetCY0, DQR.smpPosSetCY);
              	y4 = setY(h ,4 ,DQR.smpPosSetCY0, DQR.smpPosSetCY);
              	*/
              	break;
              case 1:
                  x = padW;
                  y0 = 2;
                  break;

              case 2:
                  x = padW;
                  y0 = h / 4 - 20;
                  break;

              case 3:
                  x = padW;
                  y0 = h / 2 - 20;
                  break;

              case 4:
                  x = padW;
                  y0 = h / 4 * 3 - 20;
                  break;

              case 5:
                  x = padW;
                  y0 = h - 40;
                  break;

              case 6:
                  x = w - 105;
                  y0 = 2 ;
                  break;

              case 7:
                  x = w - 105;
                  y0 = h / 4 - 20;
                  break;

              case 8:
                  x = w - 105;
                  y0 = h / 2 - 20;
                  break;

              case 9:
                  x = w - 105;
                  y0 = h / 4 * 3 - 20;
                  break;

              case 10:
                  x = w - 105;
                  y0 = h - 40;
                  break;

              case 11:
                  x = w / 2 - 60;
                  y0 = 2 ;
                  break;

              case 12:
                  x = w / 2 - 60;
                  y0 = h / 4 - 20;
                  break;

              case 13:
                  x = w / 2 - 60;
                  y0 = h / 2 - 20;
                  break;

              case 14:
                  x = w / 2 - 60;
                  y0 = h / 4 * 3 - 20;
                  break;

              case 15:
                  x = w / 2 - 60;
                  y0 = h - 40;
                  break;

              default:
                  x = padW;
                  y0 = 2;
                  break;
          }

          x = x + DQR.conf.CLGuiPos1X;
          y0 =y0 + DQR.conf.CLGuiPos1Y;

          y1 = y0 + 2;
          y2 = y0 + 10;
          y3 = y0 + 18;
          y4 = y0 + 26;
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

          //strAry2[0]:Lv strAry2[1]:EXP strAry2[2]:HP strAry2[3]:MP strAry[1]:SP
          /*
                  			strAry = strEdit.split(":");
                  			strAry2 = strAry[0].split("：");
                  			hinsiFlg = checkHinsi(strAry2[2]);
          */
          //String ExpString = this.getExpString(strAry2[1]);
          //strAry_2

          //System.out.println("HP" + ExtendedPlayerProperties.get(ep).getHP());
          //System.out.println("MaxHP" + ExtendedPlayerProperties.get(ep).getMaxHP());

          int JOB = ExtendedPlayerProperties.get(ep).getJob();
          int HP = (int)ExtendedPlayerProperties.get(ep).getHP();
          int MaxHP = (int)ExtendedPlayerProperties.get(ep).getMaxHP();
          int Lv =  ExtendedPlayerProperties.get(ep).getJobLv(JOB);
          int MP = ExtendedPlayerProperties.get(ep).getMP();
          int MaxMP = ExtendedPlayerProperties.get(ep).getMaxMP();
          int SP = ExtendedPlayerProperties.get(ep).getJobSp(JOB);
          int EXP = ExtendedPlayerProperties.get(ep).getJobExp(JOB);

          String sJob = I18n.format("gui.job." + JOB) + " " + I18n.format("gui.status.LV") + Lv + " (" + I18n.format("gui.status.SP") + SP + ")";
         // String sHP =  I18n.format("gui.status.HP") + " " + HP + "/" + MaxHP;
          String sHP = I18n.format("gui.status.HP",new Object[]{HP, MaxHP});
          String sMP = I18n.format("gui.status.MP",new Object[]{MP, MaxMP});
          String sEXP = I18n.format("gui.status.EXP",new Object[]{EXP, DQR.exp.getNextExp(Lv)});

          ResourceLocation reLoc;
          if (MaxHP != 0 && (HP * 100) / MaxHP < DQR.conf.CLGuiCrisis)
          {
        	  if(DQR.conf.guiPositionTarget ==1 && DQR.conf.guiPositionMode == 1)
        	  {
        		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus_Edit.png");
        	  }else
        	  {
        		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus_p.png");
        	  }
              mc.renderEngine.bindTexture(reLoc);
              this.drawTexturedModalRect(x, y0, 0, 0, 150, 40);
              mc.fontRenderer.drawStringWithShadow(sJob, x + 5 , y1, 0xFFCC6600);
              mc.fontRenderer.drawStringWithShadow(sHP, x + 5, y2, 0xFFCC6600);
              mc.fontRenderer.drawStringWithShadow(sMP, x + 5, y3, 0xFFCC6600);
              mc.fontRenderer.drawStringWithShadow(sEXP, x + 5, y4, 0xFFCC6600);
          }
          else
          {
        	  if(DQR.conf.guiPositionTarget ==1 && DQR.conf.guiPositionMode == 1)
        	  {
        		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus_Edit.png");
        	  }else
        	  {
        		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus.png");
        	  }
              mc.renderEngine.bindTexture(reLoc);
              this.drawTexturedModalRect(x, y0, 0, 0, 150, 40);
              mc.fontRenderer.drawStringWithShadow(sJob, x + 5 , y1, 0xffffffff);
              mc.fontRenderer.drawStringWithShadow(sHP, x + 5, y2, 0xffffffff);
              mc.fontRenderer.drawStringWithShadow(sMP, x + 5, y3, 0xffffffff);
              mc.fontRenderer.drawStringWithShadow(sEXP, x + 5, y4, 0xffffffff);
          }
      }
  }
}
