package dqr.gui.farmBook;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties2;

public class GuiFarmBookGuiContainer extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("dqr", "textures/gui/guiFarmBook.png");
    private int page = 0;
    //private GuiButton button1;

    public GuiFarmBookGuiContainer(int x, int y, int z) {
        super(new GuiFarmBookContainer(x, y, z));

		this.xSize = 154;
		this.ySize = 166;

		//this.buttonList.add

    }

    public void initGui()
    {
		int x = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

    	this.buttonList.clear();
    	/*
    	this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 15, this.height / 2 + 100, 18, 18, "<"));
    	this.buttonList.add(new GuiOptionButton(2, this.width / 2 + 118, this.height / 2 + 100, 18, 18, ">"));
    	*/
    	this.buttonList.add(new GuiOptionButton(1, x + 15, y + 99, 18, 20, "<"));
    	this.buttonList.add(new GuiOptionButton(2, x + 118, y + 99, 18, 20, ">"));
    }
    /*GUIの文字等の描画処理*/
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseZ) {
    	super.drawGuiContainerForegroundLayer(mouseX, mouseZ);

		int x = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		mc.fontRenderer.drawString(I18n.format("msg.FarmBook.seedPat.txt"), x + 15, y + 4, 4210752);
		mc.fontRenderer.drawString(I18n.format("msg.FarmBook.plantPat.txt"), x + 82, y + 4, 4210752);
    }

    /*GUIの背景の描画処理*/
	@Override
	protected void drawGuiContainerBackgroundLayer(float renderPartialTicks, int xMouse, int yMouse)
	{
    	//this.fontRendererObj.drawString(I18n.format("msg.FarmBook.seedPat.txt", new Object[0]), 15, 4, 4210752);
    	//this.fontRendererObj.drawString(I18n.format("msg.FarmBook.plantPat.txt", new Object[0]), 82, 4, 4210752);

		//System.out.println("DEBUG" + xMouse + "/" + yMouse);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		ItemStack[] seeds = new ItemStack[9];
		ItemStack[] farmBlock = new ItemStack[9];
		Item resultCrop;

		if (page > 0)
		{
			seeds = (ItemStack[])DQR.mutationTable.mutationSeeds.get(page - 1);
		}else
		{
			for(int cnt = 0; cnt < 9; cnt++ )
			{
				seeds[cnt] = null;
			}
		}

		if(page > 0)
		{
			Block[] blocks =(Block[])DQR.mutationTable.mutationBlocks.get(page - 1);
			int[] meta = (int[])DQR.mutationTable.mutationBlockMetas.get(page - 1);
			for(int cnt = 0; cnt < 9; cnt++)
			{

				if(blocks[cnt] != null)
				{
					farmBlock[cnt] = new ItemStack(blocks[cnt], 1, meta[cnt]);
				}else
				{
					farmBlock[cnt] = null;
				}
			}
		}else
		{
			for(int cnt = 0; cnt < 9; cnt++)
			{
				farmBlock[cnt] = null;
			}
		}

		if(page > 0)
		{
			resultCrop = (Item)DQR.mutationTable.mutationResults.get(page - 1);
		}else
		{
			resultCrop = null;
		}
		/*
		 * 読み込んだResourceLocationをbindTextureに渡す.
		 */
		this.mc.getTextureManager().bindTexture(TEXTURE);

		/*
		 * マイクラの画面サイズ(width, height)と, GUIサイズ(xSize, ySize)からGUIの左上座標を計算し, そこから描画する.
		 */
		int x = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

		/*
		 * bindされたテクスチャを四角形で描画する.
		 * (x, y)を左上始点として, リソース内の(0, 0) ~ (xSize, ySize)までを描画する.
		 */
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

		RenderItem itemRenderer = new RenderItem();

		for(int cnt = 0; cnt < 9; cnt ++)
		{
			if(seeds[cnt] != null)
			{
	  		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), seeds[cnt], x + 16 + (18 * (cnt % 3))  , y + 16 + (18 * (cnt / 3)));
	  		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), seeds[cnt], x + 16 + (18 * (cnt % 3)), y + 16 + (18 * (cnt / 3)));
			}
		}

		for(int cnt = 0; cnt < 9; cnt ++)
		{
			if(farmBlock[cnt] != null)
			{
	  		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), farmBlock[cnt], x + 83 + (18 * (cnt % 3))  , y + 16 + (18 * (cnt / 3)));
	  		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), farmBlock[cnt], x + 83 + (18 * (cnt % 3)), y + 16 + (18 * (cnt / 3)));
			}
		}

		if(resultCrop != null)
		{
  		  itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(resultCrop, 1, 0), x + 67  , y + 101);
  		  itemRenderer.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(resultCrop, 1, 0), x + 67, y + 101);
		}

		//種名表示
		if(seeds[0] != null && x + 32 > xMouse && xMouse > x + 16 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(seeds[0].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[1] != null && x + 50 > xMouse && xMouse > x + 34 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(seeds[1].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[2] != null && x + 68 > xMouse && xMouse > x + 52 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(seeds[2].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}

		if(seeds[3] != null && x + 32 > xMouse && xMouse > x + 16 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(seeds[3].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[4] != null && x + 50 > xMouse && xMouse > x + 34 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(seeds[4].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[5] != null && x + 68 > xMouse && xMouse > x + 52 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(seeds[5].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}

		if(seeds[6] != null && x + 32 > xMouse && xMouse > x + 16 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(seeds[6].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[7] != null && x + 50 > xMouse && xMouse > x + 34 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(seeds[7].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}
		if(seeds[8] != null && x + 68 > xMouse && xMouse > x + 52 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(seeds[8].getDisplayName(), x + 14, y + 72, 0xffffffff);
		}


		//ブロック名表示
		if(farmBlock[0] != null && x + 99 > xMouse && xMouse > x + 83 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(farmBlock[0].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[1] != null && x + 117 > xMouse && xMouse > x + 101 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(farmBlock[1].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[2] != null && x + 135 > xMouse && xMouse > x + 119 && y + 32 > yMouse && yMouse > y + 16)
		{
			mc.fontRenderer.drawString(farmBlock[2].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}

		if(farmBlock[3] != null && x + 99 > xMouse && xMouse > x + 83 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(farmBlock[3].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[4] != null && x + 117 > xMouse && xMouse > x + 101 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(farmBlock[4].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[5] != null && x + 135 > xMouse && xMouse > x + 119 && y + 50 > yMouse && yMouse > y + 34)
		{
			mc.fontRenderer.drawString(farmBlock[5].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}

		if(farmBlock[6] != null && x + 99 > xMouse && xMouse > x + 83 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(farmBlock[6].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[7] != null && x + 117 > xMouse && xMouse > x + 101 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(farmBlock[7].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}
		if(farmBlock[8] != null && x + 135 > xMouse && xMouse > x + 119 && y + 68 > yMouse && yMouse > y + 52)
		{
			mc.fontRenderer.drawString(farmBlock[8].getDisplayName(), x + 82, y + 72, 0xffffffff);
		}

		if(resultCrop != null && x + 83 > xMouse && xMouse > x + 63 && y + 117 > yMouse && yMouse > y + 101)
		{
			mc.fontRenderer.drawString(new ItemStack(resultCrop,1, 0).getDisplayName(), x + 50, y + 120, 0xffffffff);
		}
	}

    /*GUIが開いている時にゲームの処理を止めるかどうか。*/
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {

        if (p_146284_1_.id == 1)
        {

        	for(int cnt = this.page - 1; cnt >= this.page - DQR.mutationTable.mutationSeeds.size(); cnt--)
        	{
        		int checkPage = cnt - 1;
        		if(checkPage < -1)
    			{
        			checkPage = checkPage + DQR.mutationTable.mutationSeeds.size() + 1;
    			}

        		if(checkPage == -1)
        		{
        			this.page = 0;
        			return;
        		}

        		//System.out.println("DEBUG_" + cnt + "/" + checkPage);
        		if(ExtendedPlayerProperties2.get(this.mc.thePlayer).getFarmRecipe(checkPage) == 1 ||
        		   ExtendedPlayerProperties2.get(this.mc.thePlayer).getFarmRecipe(checkPage) >= 12)
        		{
        			this.page = checkPage + 1;
        			return;
        		}

	        	/*
	        	if(this.page == 0)
	        	{
	        		this.page = DQR.mutationTable.mutationSeeds.size();
	        	}else
	        	{
	        		this.page = this.page - 1;
	        	}
	        	*/


        	}
        }

        if (p_146284_1_.id == 2)
        {

        	for(int cnt = this.page + 1; cnt <= this.page + DQR.mutationTable.mutationSeeds.size(); cnt++)
        	{
        		int checkPage = cnt - 1;
        		if(checkPage >= DQR.mutationTable.mutationSeeds.size())
    			{
        			checkPage = checkPage - DQR.mutationTable.mutationSeeds.size() - 1;
    			}

        		if(checkPage == -1)
        		{
        			this.page = 0;
        			return;
        		}

        		if(ExtendedPlayerProperties2.get(this.mc.thePlayer).getFarmRecipe(checkPage) == 1 ||
        		   ExtendedPlayerProperties2.get(this.mc.thePlayer).getFarmRecipe(checkPage) >= 12)
        		{
        			this.page = checkPage + 1;
        			return;
        		}

        	}


        	/*
        	if(this.page == DQR.mutationTable.mutationSeeds.size())
        	{
        		this.page = 0;
        	}else
        	{
        		this.page = this.page + 1;
        	}
        	*/
        }
    }
}
