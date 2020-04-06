package dqr.gui.petBook;

import java.util.Set;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties6;

public class GuiPetBookGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/petBook.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr","textures/gui/petBookD.png");
    private static final ResourceLocation texture3 = new ResourceLocation("dqr","textures/gui/petBookC.png");
    private EntityPlayer ep;
    private int page = 0;

    public GuiPetBookGuiContainer(EntityPlayer player)
    {

        super(new GuiPetBookContainer(player));
        this.ep = player;
    	NBTTagCompound playerPet = ExtendedPlayerProperties6.get(player).getNBTPlayerPetList();
    	Set tags = playerPet.func_150296_c();
    	//System.out.println("TEST_LOAD : " + tags.size() + " / " + player.worldObj.isRemote);

        this.ySize = 155;
        this.xSize = 176;

    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);

		String message = I18n.format("gui.container.TamingPets.title", new Object[]{});

		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_PetSuisyou.getId());
		int color = 4210752;
		if(itemMode == EnumDqmMGToolMode.PETSUISYOU_VIEWDEL.getId())
		{
			message = I18n.format("gui.container.TamingPets2.title", new Object[]{});
			color = 0xffffffff;

			String message2 = I18n.format("gui.container.TamingPets3.title", new Object[]{});
			this.fontRendererObj.drawString(message2, (this.xSize / 2) - (mc.fontRenderer.getStringWidth(message2) / 2) , 134, color);
		}else if(itemMode == EnumDqmMGToolMode.PETSUISYOU_CALL.getId())
		{
			message = I18n.format("gui.container.TamingPets4.title", new Object[]{});
			color = 0xffffffff;

			String message2 = I18n.format("gui.container.TamingPets5.title", new Object[]{});
			this.fontRendererObj.drawString(message2, (this.xSize / 2) - (mc.fontRenderer.getStringWidth(message2) / 2) , 134, color);
		}
		//System.out.println("SIZE : " +  mc.fontRenderer.getStringWidth(message) + " / " + this.width + " / " + this.xSize);

	    //this.fontRendererObj.drawString(message, 8, 6, 4210752);
		this.fontRendererObj.drawString(message, (this.xSize / 2) - (mc.fontRenderer.getStringWidth(message) / 2) , 6, color);
		/*
    	this.buttonList.clear();

    	this.buttonList.add(new GuiOptionButton(1, x2 + 25, y + 129, 18, 20, "<"));
    	this.buttonList.add(new GuiOptionButton(2, x2 + 134, y + 129, 18, 20, ">"));
    	*/

        //描画する文字, X, Y, 色
        //this.fontRendererObj.drawString("Item Container", 8, 6, 4210752);
        //this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    public void initGui()
    {
        super.initGui();
    }

    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_PetSuisyou.getId());
        if(itemMode == EnumDqmMGToolMode.PETSUISYOU_VIEWDEL.getId())
        {
        	this.mc.getTextureManager().bindTexture(texture2);
        }else if(itemMode == EnumDqmMGToolMode.PETSUISYOU_CALL.getId())
        {
        	this.mc.getTextureManager().bindTexture(texture3);
        }else
        {
        	this.mc.getTextureManager().bindTexture(texture);
        }


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
