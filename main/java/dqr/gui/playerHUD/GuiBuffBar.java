package dqr.gui.playerHUD;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.potion.DQPotionEtc;
import dqr.playerData.ExtendedPlayerProperties5;
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

    if(DQR.conf.CLGuiBuffBarVis == 0)
    {
    	return;
    }

    OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
    int var1 = w - 124;
    int var2 = 0;
    int h = sr.getScaledHeight();
    //int skillBuffCount = 0;
    boolean var3 = true;
    Collection var4 = this.mc.thePlayer.getActivePotionEffects();
    NBTTagCompound dqrEffectSets = new NBTTagCompound();

    long wTime = this.mc.thePlayer.worldObj.getWorldTime();

    NBTTagCompound nbtSet = ExtendedPlayerProperties5.get(this.mc.thePlayer).getDqrPotionEffectsSet();

    Set nbtKeys = nbtSet.func_150296_c();
    Iterator it = nbtKeys.iterator();
    while(it.hasNext())
    {
		Object obj = it.next();
		if(obj instanceof String)
		{
			NBTTagCompound dqrEffect = (NBTTagCompound)nbtSet.getTag((String)obj);
			if(dqrEffect != null && dqrEffect.hasKey("duration"))
			{
				if(dqrEffect.getLong("duration") > wTime)
				{
					dqrEffectSets.setTag((String)obj, dqrEffect);
				}
			}
			/*
			if(nbtSet.getLong((String)obj) > wTime)
			{
				skillBuffCount = skillBuffCount + 1;
			}
			*/
		}
    }

    switch (DQR.conf.CLGuiBuffBarPos)
    {
        case 1:
            var1 = 0;
            var2 = 2;
            break;

        case 2:
            var1 = 0;
            var2 = h / 4 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 3:
            var1 = 0;
            var2 = h / 2 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 4:
            var1 = 0;
            var2 = h / 4 * 3 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 5:
            var1 = 0;
            var2 = h - DQR.conf.CLGuiBuffBarDispAreaHeight;
            break;

        case 6:
            var1 = w - 120;
            var2 = 2 ;
            break;

        case 7:
            var1 = w - 120;
            var2 = h / 4 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 8:
            var1 = w - 120;
            var2 = h / 2 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 9:
            var1 = w - 120;
            var2 = h / 4 * 3 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 10:
            var1 = w - 120;
            var2 = h - DQR.conf.CLGuiBuffBarDispAreaHeight;
            break;

        case 11:
            var1 = w / 2 - 60;
            var2 = 2 ;
            break;

        case 12:
            var1 = w / 2 - 60;
            var2 = h / 4 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 13:
            var1 = w / 2 - 60;
            var2 = h / 2 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 14:
            var1 = w / 2 - 60;
            var2 = h / 4 * 3 - (DQR.conf.CLGuiBuffBarDispAreaHeight / 2);
            break;

        case 15:
            var1 = w / 2 - 60;
            var2 = h - DQR.conf.CLGuiBuffBarDispAreaHeight;
            break;

        default:
            var1 = 0;
            var2 = 0;
            break;
    }

    var1 = var1 + DQR.conf.CLGuiBuffBarPosX;
    var2 = var2 + DQR.conf.CLGuiBuffBarPosY;


    int effectCnt = 0;
    Set dqrPotionEffectsKeys = dqrEffectSets.func_150296_c();

    if (!var4.isEmpty() || (!dqrPotionEffectsKeys.isEmpty() && dqrPotionEffectsKeys.size() > 0))
    {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int var5 = 25;

        /*
        if (var4.size() > 5)
        {
            var5 = 132 / (var4.size() - 1);
        }
        */
        int v = DQR.conf.CLGuiBuffBarDispAreaHeight;

        if (var4.size() + dqrPotionEffectsKeys.size() > v / var5)
        {
            var5 = DQR.conf.CLGuiBuffBarDispAreaHeight / (var4.size() + dqrPotionEffectsKeys.size() - 1);
        }

        if(DQR.conf.CLGuiBuffBarMode == 1)
        {
        	var5 = var5 * -1;
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


        //Iterator it2 = nbtKeys.iterator();
        Iterator it2 = dqrPotionEffectsKeys.iterator();
        while(it2.hasNext())
        {
        	Object obj = it2.next();
    		if(obj instanceof String)
    		{
    			NBTTagCompound dqeEffect = dqrEffectSets.getCompoundTag((String)obj);
    			//if(nbtSet.getLong((String)obj) > wTime)
    			if(dqeEffect != null && dqeEffect.hasKey("duration"))
    			{

    				if(dqeEffect.getLong("duration") > wTime)
    				{
	                    ResourceLocation reLoc = new ResourceLocation("dqr","textures/gui/potionEffect2.png");
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


	                    //System.out.println("HUD TEST 1" + dqeEffect.hasKey("iconX") + " : " + dqeEffect.hasKey("iconY") + " : " + dqeEffect.hasKey("iconPath") + " : " +
	                    //		dqeEffect.getInteger("iconX") + " : " +  dqeEffect.getInteger("iconY") + " : " +  dqeEffect.getString("iconPath") != null);
	                    String effectName;
	                    if(dqeEffect.hasKey("iconX") && dqeEffect.hasKey("iconY") && dqeEffect.hasKey("iconPath") &&
	                    		dqeEffect.getInteger("iconX") > -1 && dqeEffect.getInteger("iconY") > -1 && !dqeEffect.getString("iconPath").equalsIgnoreCase(""))
	                    {
	                    	//System.out.println("TESTBB1");
	                    	//System.out.println("HUD TEST 3" + " : " +
		                    //		dqeEffect.getInteger("iconX") + " : " +  dqeEffect.getInteger("iconY") + " : " +  dqeEffect.getString("iconPath"));
	                    	reLoc = new ResourceLocation("dqr",dqeEffect.getString("iconPath"));
	                    	this.drawTexturedModalRect(var1 + 6, var2 + 4, dqeEffect.getInteger("iconX"), dqeEffect.getInteger("iconY"), 18,18);
	                    	//reLoc = new ResourceLocation("dqr","textures/gui/potionEffect2.png");
		                    this.mc.renderEngine.bindTexture(reLoc);
	                    	this.drawTexturedModalRect(var1 + 6, var2 + 4, 18, 0, 18, 18);
	                    	effectName = I18n.format((String)obj, new Object[0]);
	                    }else
	                    {
	                    	//System.out.println("TESTBB2");
	                    	this.drawTexturedModalRect(var1 + 6, var2 + 4, 0, 0, 18, 18);
	                    	effectName = I18n.format("dqm.dqpotion." + (String)obj + ".name", new Object[0]);
	                    }

	                    //System.out.println(("dqm.dqpotion." + (String)obj + ".name"));
                    	//String effectName = I18n.format("dqm.dqpotion." + (String)obj + ".name", new Object[0]);
                    	mc.fontRenderer.drawStringWithShadow(effectName, var1 + 10 + 18, var2 + 5, 0xffffffff);
	                    /*
	                    String[] splitStr = ((String)obj).split("_");
	                    if(splitStr.length >= 3)
	                    {
	                        //String skillName = I18n.format("dqm.skill.JSkill_" + splitStr[1] + "_" + splitStr[2] + ".name", new Object[0]);
	                    	String effectName = I18n.format("dqm.skill.JSkill_" + splitStr[1] + "_" + splitStr[2] + ".name", new Object[0]);
	                    	mc.fontRenderer.drawStringWithShadow(effectName, var1 + 10 + 18, var2 + 5, 0xffffffff);
	                    }
	                    */
	    	            //String var10 = Potion.getDurationString(var7);

	    	            mc.fontRenderer.drawStringWithShadow(ticksToElapsedTime((int)(dqeEffect.getLong("duration") - wTime - 20)), var1 + 10 + 18, var2 + 5 + 9, 0xffffffff);

	    				var2 += var5;
    				}
    			}
    		}
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

    mc.fontRenderer.drawStringWithShadow("", 0,0, 0xffffffff);

  }

  public static String ticksToElapsedTime(int p_76337_0_)
  {
      int j = p_76337_0_ / 20;
      int k = j / 60;
      j %= 60;
      return j < 10 ? k + ":0" + j : k + ":" + j;
  }
}
