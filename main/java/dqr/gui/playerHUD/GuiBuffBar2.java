package dqr.gui.playerHUD;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.items.base.DqmItemSkillBookBase;
import dqr.playerData.ExtendedPlayerProperties5;

//
// GuiBuffBar implements a simple status bar at the top of the screen which
// shows the current buffs/debuffs applied to the character.
//
public class GuiBuffBar2 extends Gui
{
  private Minecraft mc;

  public GuiBuffBar2(Minecraft mc)
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
	  ItemStack handItem = null;

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

    EntityPlayer ep = DQR.proxy.getEntityPlayerInstance();

    if(ep == null)
    {
  	  return;
    }


    if(ep.getHeldItem() == null || (ep.getHeldItem() != null && !(ep.getHeldItem().getItem() instanceof DqmItemSkillBookBase)))
    {
    	if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 8)
        {

        }else
    	{
        	return;
    	}
    }else
    {
    	handItem = ep.getHeldItem();
    }


    OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
    int var1 = w - 124;
    int var2 = 0;
    int h = sr.getScaledHeight();
    //boolean var3 = true;
    //Collection var4 = this.mc.thePlayer.getActivePotionEffects();

    switch (DQR.conf.CLGuiBuffBar2Pos)
    {
        case 1:
            var1 = 0;
            var2 = 2;
            break;

        case 2:
            var1 = 0;
            var2 = h / 4 - 52;
            break;

        case 3:
            var1 = 0;
            var2 = h / 2 - 52;
            break;

        case 4:
            var1 = 0;
            var2 = h / 4 * 3 - 52;
            break;

        case 5:
            var1 = 0;
            var2 = h - 104;
            break;

        case 6:
            var1 = w - 120;
            var2 = 2 ;
            break;

        case 7:
            var1 = w - 120;
            var2 = h / 4 - 52 ;
            break;

        case 8:
            var1 = w - 120;
            var2 = h / 2 - 52;
            break;

        case 9:
            var1 = w - 120;
            var2 = h / 4 * 3 - 52;
            break;

        case 10:
            var1 = w - 120;
            var2 = h - 104;
            break;

        case 11:
            var1 = w / 2 - 60;
            var2 = 2 ;
            break;

        case 12:
            var1 = w / 2 - 60;
            var2 = h / 4 - 52 ;
            break;

        case 13:
            var1 = w / 2 - 60;
            var2 = h / 2 - 52;
            break;

        case 14:
            var1 = w / 2 - 60;
            var2 = h / 4 * 3 - 52;
            break;

        case 15:
            var1 = w / 2 - 60;
            var2 = h - 104;
            break;

        default:
            var1 = 0;
            var2 = 0;
            break;
    }

    var1 = var1 + DQR.conf.CLGuiBuffBar2PosX;
    var2 = var2 + DQR.conf.CLGuiBuffBar2PosY;

    /*
    if(DQR.conf.CLGuiBuffBarVis == 0)
    {
    	return;
    }
    */

    int effectCnt = 0;
    NBTTagCompound nbt = null;

    if(handItem != null)
    {
    	 nbt = handItem.getTagCompound();
    }

    /*
    if(nbt != null)
    {
	    Object[] keys = nbt.func_150296_c().toArray();
	    DQR.func.debugString("TEST_NBT0 : " + keys.length);
	    for(int cnt = 0; cnt < keys.length; cnt++)
	    {
	    	if(keys[cnt] instanceof String)
	    	{
	    		DQR.func.debugString("TEST_NBT : " + keys[cnt]);
	    	}
	    }
    }
    */

    if (nbt != null || (DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 8))
    {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int var5 = 25;


        //if (var4.size() > 5)
        //{
        //    var5 = 132 / (var4.size() - 1);
        //}
        //
        /*
        int v = DQR.conf.CLGuiBuffBarDispAreaHeight;


        if (var4.size() > v / var5)
        {
            var5 = DQR.conf.CLGuiBuffBarDispAreaHeight / (var4.size() - 1);
        }

        if(DQR.conf.CLGuiBuffBarMode == 1)
        {
        	var5 = var5 * -1;
        }
        */

        int drawCounter = 0;

	    ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/buffBar2_1.png");

	    if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 8)
	    {
	    	reLoc = new ResourceLocation("dqr","textures/gui/buffBar2_2.png");
	    }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //this.mc.renderEngine.bindTexture(reLoc);

	    this.mc.renderEngine.bindTexture(reLoc);
	    this.drawTexturedModalRect(var1, var2 - 2, 0, 0, 120, 2);

	    //DQR.func.debugString("Par : " + ep.worldObj.getWorldTime());

    	for(int selectedNo = 0; selectedNo < 5; selectedNo++)
    	{
    		//DQR.func.debugString("Par : " + nbt.getInteger("skill" + selectedNo + "_job") + " / " + nbt.getInteger("skill" + selectedNo + "_idx"));
    		if(nbt != null && nbt.hasKey("skill" + selectedNo + "_job") && nbt.hasKey("skill" + selectedNo + "_idx") &&
					nbt.getInteger("skill" + selectedNo + "_job") > -1 && nbt.getInteger("skill" + selectedNo + "_idx") > -1)
    		{
    			EnumDqmSkillJ skill2 = DQR.enumGetter.getSkillJ(nbt.getInteger("skill" + selectedNo + "_job"), nbt.getInteger("skill" + selectedNo + "_idx"));
    			long coolTime = ExtendedPlayerProperties5.get(ep).getJobSPSkillCT(nbt.getInteger("skill" + selectedNo + "_job"), nbt.getInteger("skill" + selectedNo + "_idx"));
    			//System.out.println("CoolTime??? : " + nbt.getInteger("skill" + selectedNo + "_job") + " : " + nbt.getInteger("skill" + selectedNo + "_idx"));
    			//System.out.println("CoolTime : " + coolTime + " / " + ep.worldObj.getWorldTime());
    			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    			this.mc.renderEngine.bindTexture(reLoc);
	            if(drawCounter == 0)
	            {
	            	this.drawTexturedModalRect(var1, var2 + (20 * drawCounter), 0, 2, 119, 20);
	            }else
	            {
	            	this.drawTexturedModalRect(var1, var2 + (20 * drawCounter), 122, 0, 119, 20);
	            }

	            String skillName = I18n.format("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".name");

	        	if(coolTime < ep.worldObj.getWorldTime())
	        	{
	        		mc.fontRenderer.drawStringWithShadow(skillName, var1 + 4, var2 + (20 * drawCounter) + 2, 0xffffffff);
	        		mc.fontRenderer.drawStringWithShadow(I18n.format("dqm.iteminfo.skillbookCT.1") , var1 + 8, var2 + (20 * drawCounter) + 10, 0xffffffff);
	        	}else
	        	{
	        		int ctMain = (int)(coolTime - ep.worldObj.getWorldTime()) / 20;
	        		int ctMin = ctMain / 60;
	        		int ctSec = ctMain - (ctMin * 60) + 1;

	        		mc.fontRenderer.drawStringWithShadow(skillName, var1 + 4, var2 + (20 * drawCounter) + 2, 0xCCCCCCCC);
	        		if(ctSec < 10)
	        		{
	        			mc.fontRenderer.drawStringWithShadow(ctMin + ":0" + ctSec + I18n.format("dqm.iteminfo.skillbookCT.2") , var1 + 8, var2 + (20 * drawCounter) + 11, 0xCCCCCCCC);
	        		}else
	        		{
	        			mc.fontRenderer.drawStringWithShadow(ctMin + ":" + ctSec + I18n.format("dqm.iteminfo.skillbookCT.2") , var1 + 8, var2 + (20 * drawCounter) + 11, 0xCCCCCCCC);
	        		}
	        	}

	        	drawCounter = drawCounter + 1;
    		}
    	}

    	if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 8)
    	{
    		for(int cnt = drawCounter; cnt < 5; cnt++)
    		{
    			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    			this.mc.renderEngine.bindTexture(reLoc);
    			if(drawCounter == 0)
	            {
	            	this.drawTexturedModalRect(var1, var2 + (20 * drawCounter), 0, 2, 119, 20);
	            }else
	            {
	            	this.drawTexturedModalRect(var1, var2 + (20 * drawCounter), 122, 0, 119, 20);
	            }

    			drawCounter = drawCounter + 1;
    		}
    	}

        this.mc.renderEngine.bindTexture(reLoc);
        this.drawTexturedModalRect(var1, var2 + (drawCounter * 20), 0, 22, 125, 2);


    	//System.out.println("DEBUG+" + effectCnt);
        /*
    	int drawCounter = 0;
    	if(effectCnt < 6)
    	{
    	    ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/buffBar2.png");
    	    this.mc.renderEngine.bindTexture(reLoc);
    	    this.drawTexturedModalRect(var1, var2 - 2, 0, 0, 125, 2);

            for (int cnt = 0; cnt < 5; cnt++)
            {

            	//System.out.println("TEST _ TEST");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(reLoc);
                //this.drawTexturedModalRect(var1, var2, 0, 166, 140, 25);

                if(cnt == 0)
                {
                	this.drawTexturedModalRect(var1, var2 + (20 * cnt), 0, 2, 125, 20);
                }else
                {
                	this.drawTexturedModalRect(var1, var2 + (20 * cnt), 0, 25, 125, 20);
                }
            	mc.fontRenderer.drawStringWithShadow("あいうえおかきくけこさし", var1 + 4, var2 + (20 * cnt) + 2, 0xffffffff);
            	mc.fontRenderer.drawStringWithShadow(cnt + ":12" + " (準備中)" , var1 + 8, var2 + (20 * cnt) + 10, 0xffffffff);
            	drawCounter = drawCounter + 1;
            }

            this.mc.renderEngine.bindTexture(reLoc);
            this.drawTexturedModalRect(var1, var2 + (drawCounter * 20), 0, 22, 125, 2);

    	}
    	*/
    }

/*
    if(DQR.conf.guiPositionMode == 1 && DQR.conf.guiPositionTarget == 6)
    {
    	//System.out.println("DEBUG+" + effectCnt);
    	int drawCounter = 0;
    	if(effectCnt < 6)
    	{
    	    ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/buffBar2.png");
    	    this.mc.renderEngine.bindTexture(reLoc);
    	    this.drawTexturedModalRect(var1, var2 - 2, 0, 0, 125, 2);

            for (int cnt = 0; cnt < 5; cnt++)
            {

            	//System.out.println("TEST _ TEST");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(reLoc);
                //this.drawTexturedModalRect(var1, var2, 0, 166, 140, 25);

                //if(DQR.conf.guiPositionTarget ==6)
                //{
                //	mc.fontRenderer.drawStringWithShadow(var11, var1 + 10 + 18, var2 + 5, 0xffffffff);
                //	this.drawTexturedModalRect(var1, var2 + (25 * cnt), 0, 141, 125, 25);
                //}else
                //{
                //	this.drawTexturedModalRect(var1, var2 + (25 * cnt), 0, 166, 125, 25);
                //}

                if(cnt == 0)
                {
                	this.drawTexturedModalRect(var1, var2 + (20 * cnt), 0, 2, 125, 20);
                }else
                {
                	this.drawTexturedModalRect(var1, var2 + (20 * cnt), 0, 25, 125, 20);
                }
            	mc.fontRenderer.drawStringWithShadow("あいうえおかきくけこさし", var1 + 4, var2 + (20 * cnt) + 2, 0xffffffff);
            	mc.fontRenderer.drawStringWithShadow(cnt + ":12" + " (準備中)" , var1 + 8, var2 + (20 * cnt) + 10, 0xffffffff);
            	drawCounter = drawCounter + 1;
            }

            this.mc.renderEngine.bindTexture(reLoc);
            this.drawTexturedModalRect(var1, var2 + (drawCounter * 20), 0, 22, 125, 2);

    	}
    }
    */

    mc.fontRenderer.drawStringWithShadow("", 0,0, 0xffffffff);

  }
}
