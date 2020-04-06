package dqr.gui.dama;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.dataTable.FuncJobSkillData;
import dqr.packetMessage.MessageServerDataSend;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties5;

public class GuiSkillJobGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/guiSkillJob.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr","textures/gui/guiSkillJobP3.png");
    private static final ResourceLocation texture3 = new ResourceLocation("dqr","textures/gui/widgets2.png");
    private int pageLeftSize = 93;
    private int pageRightSize = 177;
	GuiDamaOptionButton[] button = new GuiDamaOptionButton[8];

	public int[] jobLevelTable = new int[]{};
	public int maxPage = 0;
	public int page = 0;
	public int selectJob = -1;
	public EntityPlayer player;
	public boolean systemEnable = true;

	public GuiSkillJobContainer mainContainer;
	private int playerJob = -1;

    public GuiSkillJobGuiContainer(EntityPlayer ep)
    {
        super(new GuiSkillJobContainer(ep));
        this.ySize = 222;
        this.xSize = pageLeftSize + pageRightSize;

        this.player = ep;
        int[] jobLv = ExtendedPlayerProperties.get(ep).getJobLvA();
        playerJob = ExtendedPlayerProperties.get(ep).getJob();
        int jobCounter = 0;


        DQR.func.debugString("GuiDebug : 1", this.getClass(), 4);

        for(int cnt = 0; cnt < jobLv.length; cnt++)
        {
        	//JobLv10以上の場合のみ表示
        	if(jobLv[cnt] >= 10)
        	{
        		jobCounter++;
        	}
        }
        DQR.func.debugString("GuiDebug : 2", this.getClass(), 4);
        if(jobCounter > 0)
        {
        	jobLevelTable = new int[jobCounter];
        	int addCounter = 0;
            for(int cnt = 0; cnt < jobLv.length; cnt++)
            {
            	//JobLv10以上の場合のみ表示
            	if(jobLv[cnt] >= 10)
            	{
            		jobLevelTable[addCounter] = cnt;
            		addCounter++;
            	}
            }

            maxPage = (int)((float)addCounter / 8.0f + 0.9f);
        }
        DQR.func.debugString("GuiDebug : 3 / " + maxPage, this.getClass(), 4);
        //System.out.println("JobGUItest : constructor");
    }

    public void createButton()
    {
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;


    	this.button = new GuiDamaOptionButton[8];

    	ArrayList<GuiDamaOptionButton> delList = new ArrayList();
    	Iterator it = buttonList.iterator();
    	while(it.hasNext())
    	{
    		Object obj = it.next();
    		if(obj instanceof GuiDamaOptionButton)
    		{
    			GuiDamaOptionButton but = (GuiDamaOptionButton)obj;
    			if(but.id >= 0 && but.id < 8)
    			{
    				delList.add(but);
    			}
    		}
    	}

    	Iterator it2 = delList.iterator();
    	while(it2.hasNext())
    	{
    		buttonList.remove(it2.next());
    	}

    	if(jobLevelTable != null && jobLevelTable.length > 0)
    	{
	    	DQR.func.debugString("GuiDebug : 4 / " + jobLevelTable.length, this.getClass(), 4);
	    	for(int cnt = 0; cnt < jobLevelTable.length - (8 * page); cnt++)
	    	{
	    		DQR.func.debugString("GuiDebug : 6_" + cnt, this.getClass(), 4);
	    		this.button[cnt]  = new GuiDamaOptionButton(cnt, mainX + 11, mainY + 13 + (cnt * 21), 70, 20, I18n.format("gui.job." + jobLevelTable[(8 * page) + cnt], new Object[]{}));
	    		this.button[cnt].jobNo = jobLevelTable[(8 * page) + cnt];
	    		if(this.button[cnt].jobNo == this.selectJob)
	    		{
	    			this.button[cnt].selectFlg = true;
	    		}

	    		this.buttonList.add(this.button[cnt]);

	    		if(cnt >= 7)
	    		{
	    			break;
	    		}
	    	}
	    	DQR.func.debugString("GuiDebug : 5", this.getClass(), 4);
    	}
    }

    public void initGui()
    {
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;

    	super.initGui();
    	buttonList = new ArrayList();
    	this.createButton();
    	//System.out.println("JobGUItest : init");
    	if(maxPage > 1)
    	{
    		this.buttonList.add(new GuiDamaOptionButton(100, mainX + 9, mainY + 186, 15, 20, "<"));
    		this.buttonList.add(new GuiDamaOptionButton(101, mainX + 69, mainY + 186, 15, 20, ">"));
    	}

    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
        //描画する文字, X, Y, 色
        //this.fontRendererObj.drawString("Item Container", 8, 6, 4210752);
        //this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;
    	int reCnt = 0;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.pageLeftSize, this.ySize);
        this.mc.getTextureManager().bindTexture(texture2);
        this.drawTexturedModalRect(k + pageLeftSize, l, 0, 0, this.pageRightSize, this.ySize);


        if(this.selectJob != -1)
        {
        	int jobLv = ExtendedPlayerProperties.get(player).getJobLv(selectJob);
        	int jobSP = ExtendedPlayerProperties5.get(player).getJobSp(selectJob);

        	this.fontRendererObj.drawStringWithShadow(I18n.format("main.job." + this.selectJob, new Object[]{}) + I18n.format("gui.container.dama.SP", new Object[]{FuncJobSkillData.getMaxSP(jobLv) - jobSP, FuncJobSkillData.getMaxSP(jobLv)}), mainX + pageLeftSize + 12, mainY + 13, 0xffffffff);
            this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillOnlyJob", new Object[]{I18n.format("main.job." + this.selectJob, new Object[]{})}), mainX + pageLeftSize + 7, mainY + 41 - 11, 4210752);
            this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillAllJob", new Object[]{}), mainX + pageLeftSize + 7, mainY + 73 - 11, 4210752);



            //if(systemEnable)
            if(selectJob == EnumDqmJob.Asobinin.getId())
            {
	            this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillSpOnlyJob", new Object[]{I18n.format("main.job." + this.selectJob, new Object[]{})}), mainX + pageLeftSize + 7, mainY + 107 - 11, 4210752);
	            for(int cnt = 0; cnt < DQR.enumGetter.getJobSPSkillCounterJ2(selectJob); cnt++)
	            {
	    			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    	        GL11.glEnable(GL11.GL_BLEND);
	    	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	    	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	                this.mc.getTextureManager().bindTexture(texture2);
	                this.drawTexturedModalRect(k + 7 + pageLeftSize + ((cnt % 9) * 18), 107 + l + ((cnt / 9) * 18), 0, 232, 18, 18);
	                reCnt = cnt;
	            }

	            this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillSpAllJob", new Object[]{I18n.format("main.job." + this.selectJob, new Object[]{})}), mainX + pageLeftSize + 7, 139 + ((reCnt / 9) * 18) + l - 11, 4210752);
	            for(int cnt = 0; cnt < DQR.enumGetter.getJobSPSkillCounterAllJ(selectJob); cnt++)
	            {
	    			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    	        GL11.glEnable(GL11.GL_BLEND);
	    	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	    	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	                this.mc.getTextureManager().bindTexture(texture2);
	                this.drawTexturedModalRect(k + 7 + pageLeftSize + ((cnt % 9) * 18), 139 + ((reCnt / 9) * 18) + l + ((cnt / 9) * 18), 0, 232, 18, 18);
	            }
            }
        }

        //this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillSP", new Object[]{}), mainX + pageLeftSize + 7, mainY + 124 - 11, 4210752);

        if(selectJob > -1)
        {
        	int[] skillSet = ExtendedPlayerProperties5.get(player).getJobSkillSetA2(selectJob);
        	for(int cnt = 0;cnt < skillSet.length; cnt++)
        	{
        		if(skillSet[cnt] == 1)
        		{
        			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	        GL11.glEnable(GL11.GL_BLEND);
        	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        			this.mc.getTextureManager().bindTexture(texture3);
        			this.drawTexturedModalRect(k + pageLeftSize + 8 + (cnt * 18), 42 + l, 0, 146, 16, 16);
        		}
        	}

        	int[] skillSet2 = ExtendedPlayerProperties5.get(player).getJobSkillSet2A2(selectJob);
        	for(int cnt = 0;cnt < skillSet2.length; cnt++)
        	{
        		if(skillSet2[cnt] == 1)
        		{
        			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	        GL11.glEnable(GL11.GL_BLEND);
        	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        			this.mc.getTextureManager().bindTexture(texture3);
        			this.drawTexturedModalRect(k + pageLeftSize + 8 + (cnt * 18), 74 + l, 0, 146, 16, 16);
        		}
        	}

        	//if(systemEnable)
        	if(selectJob == EnumDqmJob.Asobinin.getId())
            {
	        	int[] skillSetSP = ExtendedPlayerProperties5.get(player).getJobSPSkillSetA2(selectJob);
	        	for(int cnt = 0;cnt < skillSetSP.length; cnt++)
	        	{
	        		if(skillSetSP[cnt] == 1)
	        		{
	        			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        	        GL11.glEnable(GL11.GL_BLEND);
	        	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	        	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        			this.mc.getTextureManager().bindTexture(texture3);
	        			//this.drawTexturedModalRect(k + pageLeftSize + 8 + (cnt * 18), 74 + l, 0, 146, 16, 16);
	        			this.drawTexturedModalRect(k + 8 + pageLeftSize + ((cnt % 9) * 18), 108 + l + ((cnt / 9) * 18), 0, 146, 16, 16);
	        		}

	        	}

	           // this.fontRendererObj.drawString(I18n.format("gui.container.dama.SkillSpAllJob", new Object[]{I18n.format("main.job." + this.selectJob, new Object[]{})}), mainX + pageLeftSize + 7, 139 + ((reCnt / 9) * 18) + l - 11, 4210752);
	        	EnumDqmSkillJ[] skills = DQR.enumGetter.getSkillAllJfromJob(selectJob);
	            for(int cnt = 0; cnt < skills.length; cnt++)
	            {
	            	//DQR.func.debugString("TESTTEST : " + ExtendedPlayerProperties3.get(player).getJobSPSkillSet(selectJob, skills[cnt].getIdx()) + " / " + cnt + " / " + skills[cnt].getIdx());
	            	if(ExtendedPlayerProperties5.get(player).getJobSPSkillSet(selectJob, skills[cnt].getIdx()) == 2)
	            	{
	            		//DQR.func.debugString("TEST _ " + cnt);
		    			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		    	        GL11.glEnable(GL11.GL_BLEND);
		    	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		    	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		                this.mc.getTextureManager().bindTexture(texture3);
		                this.drawTexturedModalRect(k + 8 + pageLeftSize + ((cnt % 9) * 18), 140 + ((reCnt / 9) * 18) + l + ((cnt / 9) * 18), 0, 146, 16, 16);
	            	}
	            }
            }
        }
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {
    	super.actionPerformed(p_146284_1_);
    	if(p_146284_1_.id >= 0 && p_146284_1_.id <= 7)
    	{
			if(player.worldObj.isRemote)
	    	{
				NBTTagCompound data = new NBTTagCompound();
				ExtendedPlayerProperties5.get(player).setPlayerName(player.getCommandSenderName());
				ExtendedPlayerProperties5.get(player).setPlayerUUID(player.getUniqueID().toString());
				ExtendedPlayerProperties5.get(player).saveNBTData(data);
	    		PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 5));
	    	}

			//FuncJobSkillData.calcPlayerStatus(player);
			//FuncJobSkillData.calcPlayerStatus2(player);

    		for(int cnt = 0; cnt < button.length; cnt++)
    		{
    			if(button[cnt] != null)
    			{
    				if(cnt == p_146284_1_.id)
    				{
    					button[cnt].selectFlg = true;
    					this.selectJob = button[cnt].jobNo;

    					GuiSkillJobContainer cont = (GuiSkillJobContainer)this.inventorySlots;

    					if(p_146284_1_ instanceof GuiDamaOptionButton)
    		    		{
    						GuiDamaOptionButton btn = (GuiDamaOptionButton)p_146284_1_;
    						cont.refreshInventory(btn.jobNo);
    		    		}
    					//cont.refreshInventory(p_146284_1_.id);
    				}else
    				{
    					button[cnt].selectFlg = false;
    				}

    			}
    		}
    	}else if(p_146284_1_.id == 100)
    	{
    		if(page == 0)
    		{
    			this.page = this.maxPage - 1;
    		}else
    		{
    			this.page = this.page - 1;
    		}
    		this.createButton();
    	}else if(p_146284_1_.id == 101)
    	{
    		if(page == this.maxPage - 1)
    		{
    			this.page = 0;
    		}else
    		{
    			this.page = this.page + 1;
    		}
    		this.createButton();
    	}

    	DQR.func.debugString("GuiDebug : 7 / " + this.buttonList.size() + " / " + this.page + " / " + this.maxPage, this.getClass(), 4);
    }


}
