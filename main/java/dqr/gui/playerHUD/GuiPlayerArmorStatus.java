package dqr.gui.playerHUD;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class GuiPlayerArmorStatus extends Gui
{
  private Minecraft mc;
	//private final Minecraft mc = Minecraft.getMinecraft();

  public GuiPlayerArmorStatus(Minecraft mc)
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


      if (DQR.conf.CLGuiArmorVis == 1)
      {
          y0 = 0;
          y1 = 0;
          y2 = 0;
          y3 = 0;
          y4 = 0;
          y5 = 0;
          y6 = 0;
          y7 = 0;

          //switch (DQR.conf.CLGuiPos2)
          switch (DQR.conf.CLGuiArmorPos)
          {
              case 1:
                  x = padW;
                  y0 = 2;
                  break;

              case 2:
                  x = padW;
                  y0 = h / 4 - 45;
                  break;

              case 3:
                  x = padW;
                  y0 = h / 2 - 45;
                  break;

              case 4:
                  x = padW;
                  y0 = h / 4 * 3 - 45;
                  break;

              case 5:
                  x = padW;
                  y0 = h - 90;
                  break;

              case 6:
                  x = w - 94;
                  y0 = 2 ;
                  break;

              case 7:
                  x = w - 94;
                  y0 = h / 4 - 45 ;
                  break;

              case 8:
                  x = w - 94;
                  y0 = h / 2 - 45;
                  break;

              case 9:
                  x = w - 94;
                  y0 = h / 4 * 3 - 45;
                  break;

              case 10:
                  x = w - 94;
                  y0 = h - 90;
                  break;

              case 11:
                  x = w / 2 - 47;
                  y0 = 2 ;
                  break;

              case 12:
                  x = w / 2 - 47;
                  y0 = h / 4 - 45 ;
                  break;

              case 13:
                  x = w / 2 - 47;
                  y0 = h / 2 - 45;
                  break;

              case 14:
                  x = w / 2 - 47;
                  y0 = h / 4 * 3 - 45;
                  break;

              case 15:
                  x = w / 2 - 47;
                  y0 = h - 90;
                  break;

              default:
                  x = padW;
                  y0 = 2;
                  break;
          }

          x = x + DQR.conf.CLGuiArmorPosX;
          y0 =y0 + DQR.conf.CLGuiArmorPosY;

          int maxDamage;
          int nowDamage;
          String damageStr[] = new String[5];

          //int test = ep.inventory.armorInventory.length;
          for(int cnt = 0; cnt < 4; cnt++)
          {
        	  if(ep.inventory.armorInventory[cnt] != null)
        	  {
        		  nowDamage = ep.inventory.armorInventory[cnt].getItemDamage();
        		  maxDamage = ep.inventory.armorInventory[cnt].getMaxDamage();
        		  damageStr[cnt] = String.format("%1$6d / %2$6d", new Object[]{(maxDamage - nowDamage),maxDamage});
        	  }
          }

          if(ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getMaxDamage() > 0)
          {
    		  nowDamage = ep.inventory.getCurrentItem().getItemDamage();
    		  maxDamage = ep.inventory.getCurrentItem().getMaxDamage();
    		  damageStr[4] = String.format("%1$6d / %2$6d", new Object[]{(maxDamage - nowDamage),maxDamage});
          }

/*
          String weaponName = I18n.format("gui.weapon." + Weapon);
          String sJukuren1 = I18n.format("gui.status.skill", new Object[]{weaponName, Jukuren});
          String sJukuren2;
          String sKougeki = I18n.format("gui.status.attack", new Object[]{ATK, STR});
          String sMamori = I18n.format("gui.status.gurd", new Object[]{DEF, AGI});
          String sMaryoku = I18n.format("gui.status.magic", new Object[]{bMAG, INT});
          String sGold = I18n.format("gui.status.gold", new Object[]{GOLD});

          if(Jukuren == 10)
          {
        	  sJukuren2 = I18n.format("gui.status.abilityMax");
          }else
          {
        	  sJukuren2 = I18n.format("gui.status.ability", new Object[]{JukurenEXP, DQR.exp.getJukurenNextExp(Jukuren)});
          }
*/
          y1 = y0 + 3;
          y2 = y0 + 20;
          y3 = y0 + 37;
          y4 = y0 + 54;
          y5 = y0 + 71;
          //RenderHelper.enableGUIStandardItemLighting();
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          ResourceLocation reLoc;// = new ResourceLocation("dqr","textures/gui/mpStatusArmor.png");
    	  if(DQR.conf.guiPositionTarget ==3 && DQR.conf.guiPositionMode == 1)
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatusArmor_Edit.png");
    	  }else
    	  {
    		  reLoc = new ResourceLocation("dqr","textures/gui/mpStatusArmor.png");
    	  }
          mc.renderEngine.bindTexture(reLoc);

          this.drawTexturedModalRect(x, y0, 0, 0, 94, 90);

        	  //System.out.println("通過");
        	  //this.drawTexturedModelRectFromIcon(x, y0, itemIcon[1], 16, 16);
    	  RenderItem itemRenderer = new RenderItem();
    	  if(damageStr[4] != null) mc.fontRenderer.drawStringWithShadow(damageStr[4], x + 20, y1 + 4, 0xffffffff);
    	  if(damageStr[3] != null) mc.fontRenderer.drawStringWithShadow(damageStr[3], x + 20, y2 + 4, 0xffffffff);
    	  if(damageStr[2] != null) mc.fontRenderer.drawStringWithShadow(damageStr[2], x + 20, y3 + 4, 0xffffffff);
    	  if(damageStr[1] != null) mc.fontRenderer.drawStringWithShadow(damageStr[1], x + 20, y4 + 4, 0xffffffff);
    	  if(damageStr[0] != null) mc.fontRenderer.drawStringWithShadow(damageStr[0], x + 20, y5 + 4, 0xffffffff);

    	  //RenderHelper.enableGUIStandardItemLighting();
    	  RenderHelper.enableGUIStandardItemLighting();
    	  if(damageStr[4] != null)
    	  {
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.getCurrentItem(), x+4, y1);
    		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.getCurrentItem(), x+4, y1);
    	  }
    	  if(damageStr[3] != null)
    	  {
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[3], x+4, y2);
    		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[3], x+4, y2);

   		  }
    	  if(damageStr[2] != null)
    	  {
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[2], x+4, y3);
    		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[2], x+4, y3);
    	  }
    	  if(damageStr[1] != null)
    	  {
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[1], x+4, y4);
    		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[1], x+4, y4);
    	  }
    	  if(damageStr[0] != null){
    		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[0], x+4, y5);
    		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), ep.inventory.armorInventory[0], x+4, y5);
    	  }
    	  RenderHelper.disableStandardItemLighting();

    	  //RenderHelper.disableStandardItemLighting();
    	  /*
    	  GL11.glDisable(GL12.GL_RESCALE_NORMAL);
          OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
          GL11.glDisable(GL11.GL_TEXTURE_2D);
          OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
		  */

    	  //RenderHelper.disableStandardItemLighting();
    	  //RenderHelper.enableStandardItemLighting();

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
