package dqr.gui.petBook;

import java.util.Set;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.playerData.ExtendedPlayerProperties3;

public class GuiPetBookGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/petBook.png");
    private int page = 0;

    public GuiPetBookGuiContainer(EntityPlayer player)
    {

        super(new GuiPetBookContainer(player));

    	NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	Set tags = playerPet.func_150296_c();

        this.ySize = 155;


    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

		String message = I18n.format("gui.container.TamingPets.title", new Object[]{});
	    this.fontRendererObj.drawString(message, 8, 6, 4210752);

		/*
    	this.buttonList.clear();

    	this.buttonList.add(new GuiOptionButton(1, x2 + 25, y + 129, 18, 20, "<"));
    	this.buttonList.add(new GuiOptionButton(2, x2 + 134, y + 129, 18, 20, ">"));
    	*/

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
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {

    	/*
        if (p_146284_1_.id == 1)
        {

        	if(this.page <= 0)
        	{

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



        	if(this.page == DQR.mutationTable.mutationSeeds.size())
        	{
        		this.page = 0;
        	}else
        	{
        		this.page = this.page + 1;
        	}

        }
    */
    }
}
