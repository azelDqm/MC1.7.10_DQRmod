package dqr.gui.dama;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiJobChangeGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/guiJobChange.png");
    private int page = 0;
    private int MaxPage = 0;
    private EntityPlayer ep;
    private ArrayList jobs = new ArrayList ();

    public GuiJobChangeGuiContainer(InventoryPlayer inventoryPlayer)
    {
        super(new GuiJobChangeContainer(inventoryPlayer));
        this.ySize = 166;
        ep = inventoryPlayer.player;

        int[] jobLv = ExtendedPlayerProperties.get(ep).getJobLvA();
        for(int cnt = 0; cnt < jobLv.length; cnt++)
        {
        	if(jobLv[cnt] != 0)
        	{
        		//int lv = ExtendedPlayerProperties.get(ep).getJobLv(cnt);
        		jobs.add(cnt);
        	}
        }

        int[] perm = ExtendedPlayerProperties3.get(ep).getJobPermissionA();
        for(int cnt = 0; cnt < perm.length; cnt++)
        {
        	if(perm[cnt] != 0 && !jobs.contains(cnt))
        	{
        		//int lv = ExtendedPlayerProperties.get(ep).getJobLv(cnt);
        		jobs.add(cnt);
        	}
        }
        this.MaxPage = jobs.size() / 5;
    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
        //描画する文字, X, Y, 色
    	String message = I18n.format("gui.container.dama.title", new Object[]{});
        this.fontRendererObj.drawString(message, 8, 6, 4210752);
        //this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    public void initGui()
    {
    	super.initGui();
    	buttonList = new ArrayList();
		int x = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

    	//this.buttonList.clear();
    	/*
    	this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 15, this.height / 2 + 100, 18, 18, "<"));
    	this.buttonList.add(new GuiOptionButton(2, this.width / 2 + 118, this.height / 2 + 100, 18, 18, ">"));
    	*/
    	this.buttonList.add(new GuiOptionButton(1, x + 7, y + 117, 10, 20, "<"));
    	this.buttonList.add(new GuiOptionButton(2, x + 159, y + 117, 10, 20, ">"));
    }
    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int x2 = (this.width - this.xSize) / 2;
        int y2 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x2, y2, 0, 0, this.xSize, this.ySize);
        String pageNo = I18n.format("gui.container.dama.page", new Object[]{(page + 1), (MaxPage + 1)});
        this.fontRendererObj.drawString(pageNo, 112 + x2, 85 + y2, 4210752);

        if(jobs.size() > 0)
        {
        	int cnt2 = 0;
        	for(int cnt = page * 5; cnt < jobs.size(); cnt++)
        	{
        		int lv = ExtendedPlayerProperties.get(ep).getJobLv((int)jobs.get(cnt));
        		String jobName = I18n.format("main.job." + ((int)jobs.get(cnt)), new Object[]{});

                this.fontRendererObj.drawStringWithShadow(jobName, 22 + x2, 84 + y2 + (13 * cnt2) + 13, 0xffffffff);
                this.fontRendererObj.drawStringWithShadow("Lv." + lv, 132 + x2, 84 + y2 + (13 * cnt2) + 13, 0xffffffff);

        		cnt2++;
        		if(cnt2 >= 5)
        		{
        			break;
        		}
        	}
        }

        /*
        this.fontRendererObj.drawStringWithShadow("遊び人   Lv.25", 22 + x2, 84 + y2, 0xffffffff);
        this.fontRendererObj.drawStringWithShadow("遊び人   Lv.25", 132 + x2, 84 + y2, 0xffffffff);
        */
        //this.fontRendererObj.drawStringWithShadow("マスタードラゴン   Lv.86", 22 + x2, 96 + y2, 0xffffffff);
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {

        if (p_146284_1_.id == 1)
        {

        	if(page > 0)
        	{
        		page = page - 1;
        	}
        }

        if (p_146284_1_.id == 2)
        {
        	if(MaxPage > page)
        	{
        		page = page + 1;
        	}
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
