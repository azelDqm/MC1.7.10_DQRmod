package dqr.gui.playerHUD;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties4;

public class GuiParty extends Gui
{
  private Minecraft mc;

  public GuiParty(Minecraft mc)
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
	  int effectCnt = 0;
	  int padW = 102;
	  int padH = 2;
      int y0 = 0;
      int y1 = 0;
      int y2 = 0;
      int y3 = 0;
      int y4 = 0;
      int y5 = 0;
      int y6 = 0;
      /*
      int y7 = 0;
      int y8 = 0;
      int y9 = 0;
      */

      int yA = 0;
      int yB = 0;

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

      NBTTagCompound partyData = ExtendedPlayerProperties4.get(ep).getPartyMemberData();
      //DQR.func.debugString("PT_TEST");

      if(!partyData.hasKey(ep.getUniqueID().toString()))
      {
    	  ExtendedPlayerProperties4.get(ep).setPartyMemberData(null);
    	  return;
      }
      //DQR.func.debugString("PT_TEST2");

      if (DQR.conf.CLGuiPartyVis == 1)
      {
          //DQR.func.debugString("PT_TEST3");

          y0 = 0;
          y1 = 0;
          y2 = 0;
          y3 = 0;
          y4 = 0;
          y5 = 0;
          y6 = 0;
          //y7 = 0;

          yA = 0;
          yB = 0;

          switch (DQR.conf.CLGuiPartyPos)
          {
              case 1:
                  x = padW;
                  y0 = 2;
                  break;

              case 2:
                  x = padW;
                  y0 = h / 4 - 34;
                  break;

              case 3:
                  x = padW;
                  y0 = h / 2 - 34;
                  break;

              case 4:
                  x = padW;
                  y0 = h / 4 * 3 - 34;
                  break;

              case 5:
                  x = padW;
                  y0 = h - 67;
                  break;

              case 6:
                  x = w - 85;
                  y0 = 2 ;
                  break;

              case 7:
                  x = w - 85;
                  y0 = h / 4 - 34;
                  break;

              case 8:
                  x = w - 85;
                  y0 = h / 2 - 34;
                  break;

              case 9:
                  x = w - 85;
                  y0 = h / 4 * 3 - 34;
                  break;

              case 10:
                  x = w - 85;
                  y0 = h - 67;
                  break;

              case 11:
                  x = w / 2 - 43;
                  y0 = 2 ;
                  break;

              case 12:
                  x = w / 2 - 43;
                  y0 = h / 4 - 34;
                  break;

              case 13:
                  x = w / 2 - 43;
                  y0 = h / 2 - 34;
                  break;

              case 14:
                  x = w / 2 - 43;
                  y0 = h / 4 * 3 - 34;
                  break;

              case 15:
                  x = w / 2 - 43;
                  y0 = h - 67;
                  break;

              default:
                  x = padW;
                  y0 = 2;
                  break;
          }

          x = x + DQR.conf.CLGuiPartyPosX;
          y0 =y0 + DQR.conf.CLGuiPartyPosY;


          y1 = y0 + 3;
          y2 = y0 + 15;
          y3 = y0 + 24;

          yA = y0 + 19;

          y4 = y0 + 34;
          y5 = y0 + 43;

          yB = y0 + 38;

          y6 = y0 + 54;


          /*
          y7 = y0 + 56;
          y8 = y0 + 65;
          y9 = y0 + 74;
          */


          Set dataMap = partyData.func_150296_c();
          TreeMap<String, Integer> dataTree = new TreeMap();

          Iterator iterator = dataMap.iterator();
          int dataNum = 1;

          while (iterator.hasNext())
          {
              String s = (String)iterator.next();

              //System.out.println("TEST2" + s);
              if(s.equalsIgnoreCase(ep.getUniqueID().toString()))
              {
            	  dataTree.put(s, 0);
              }else
              {
            	  dataTree.put(s, dataNum);
            	  dataNum++;
              }
          }

          Iterator<String> it = dataTree.keySet().iterator();

          //System.out.println("TEST2");
          dataNum = 0;
          while (it.hasNext())
          {
        	  //System.out.println("TEST3");
              String key = it.next();
              //System.out.println("TEST3" + key);
              //if(DQR.debug == 0 && !ep.getCommandSenderName().equalsIgnoreCase(key))
              if(true)
              {

	              NBTTagCompound dataNBT = partyData.getCompoundTag(key);

	              effectCnt = dataTree.get(key);
	              String name = dataNBT.getString("sName");
	              int sHP = dataNBT.getInteger("sHP");
	              int sMaxHP = dataNBT.getInteger("sMaxHP");
	              int stringColor = 0xffffffff;
            	  //System.out.println("TEST4");
		          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		          ResourceLocation reLoc;// = new ResourceLocation("dqm","textures/gui/mpStatus3.png");
		    	  if(DQR.conf.guiPositionTarget == 7 && DQR.conf.guiPositionMode == 1)
		    	  {
		    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus5_Edit.png");
		    	  }else
		    	  {
		    		  if((sHP * 100) / sMaxHP < DQR.conf.CLGuiCrisis)
		    		  {
		    			  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus5_p.png");
		    			  stringColor = 0xFFCC6600;
		    		  }else
		    		  {
		    			  reLoc = new ResourceLocation("dqr","textures/gui/mpStatus5.png");
		    			  stringColor = 0xffffffff;
		    		  }
		    	  }

		    	  String mesHP = I18n.format("gui.party.hp", new Object[0]);
		    	  String mesMP = I18n.format("gui.party.mp", new Object[0]);
		    	  int fix = 5;

		          mc.renderEngine.bindTexture(reLoc);
	              int posXfix = (dataTree.get(key) % DQR.conf.CLGuiPartyReturnLine * 69 + 5);
		          this.drawTexturedModalRect(x + posXfix, y0 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3) , 0, 0, 69, 67);



	              int sMP = dataNBT.getInteger("sMP");
	              int sMaxMP = dataNBT.getInteger("sMaxMP");
	              int sJob  = dataNBT.getInteger("sJob");
	              int sLv  = dataNBT.getInteger("sLv");
	              String sJob2 = I18n.format("gui.job." + sJob) + " " + I18n.format("gui.status.LV") + sLv;



		          mc.fontRenderer.drawStringWithShadow(name, x + 5 + posXfix , y1 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);

		          mc.fontRenderer.drawStringWithShadow(mesHP, x + 5 + fix +posXfix , yA + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);
		          mc.fontRenderer.drawStringWithShadow(mesMP, x + 5 + fix + posXfix, yB + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);

		          mc.fontRenderer.drawStringWithShadow("" + sHP, x + 25 + fix + posXfix, y2 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);
		          mc.fontRenderer.drawStringWithShadow("" + sMaxHP, x + 25 + fix + posXfix, y3 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);

		          mc.fontRenderer.drawStringWithShadow("" + sMP, x + 25 + fix + posXfix, y4 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);
		          mc.fontRenderer.drawStringWithShadow("" + sMaxMP, x + 25 + fix + posXfix, y5 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);

		          //mc.fontRenderer.drawStringWithShadow(sJob2, x + 5 + (dataTree.get(key) * 69 + 5), y6 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);
		          mc.fontRenderer.drawStringWithShadow(sJob2, x + fix + posXfix, y6 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), stringColor);

		          dataNum++;
            	  effectCnt++;
              }

          }
          /*
          mc.fontRenderer.drawStringWithShadow(sJukuren1, x + 5 , y1, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sJukuren2, x + 5 , y2, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sKougeki, x + 5, y3, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMamori, x + 5, y4, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sMaryoku, x + 5, y5, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow("", x + 5, y6, 0xffffffff);
          mc.fontRenderer.drawStringWithShadow(sGold, x + 5, y7, 0xffffffff);
          */

      }

      if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 7)
      {

      	//System.out.println("DEBUG+" + effectCnt);
	      for (int cnt = 0 + effectCnt; cnt < 15; cnt++)
	      {
	          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	          ResourceLocation reLoc;// = new ResourceLocation("dqm","textures/gui/mpStatus3.png");
	          reLoc = new ResourceLocation("dqr","textures/gui/mpStatus5_Edit.png");
	          mc.renderEngine.bindTexture(reLoc);
	          int posXfix = (effectCnt % DQR.conf.CLGuiPartyReturnLine * 69 + 5);
	          this.drawTexturedModalRect(x + posXfix, y0 + ((effectCnt / DQR.conf.CLGuiPartyReturnLine) * 67 + 3), 0, 0, 85, 67);
	          effectCnt++;
	      }
      }
  }
}
