package dqr.gui.dqrEnderChest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiDqrEnderChestGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");

    public GuiDqrEnderChestGuiContainer(EntityPlayer ep)
    {
        super(new GuiDqrEnderChestContainer(ep));
        //System.out.println("isRemote:" + ep.worldObj.isRemote);
        this.ySize = 222;
        this.xSize = 352;
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

    public void initGui()
    {
        this.buttonList.clear();

        super.initGui();

        int cornerX = this.guiLeft;

        int cornerY = this.guiTop;

        //TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PlayerTabs.ss,false);
        //TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PetStatusTabs.tabPetInventory,false);

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

        k = ((this.width - (this.xSize)) / 2) + (this.xSize / 2);
        l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, (this.xSize / 2), this.ySize);



        k = ((this.width - (this.xSize)) / 2) + (this.xSize / 2);
        l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l + 107 , 0, 35, 176,  90);
        /*
    	String petName = "";
    	DqmPetBase pet = ExtendedPlayerProperties3.get(this.mc.thePlayer).getStatusPet();

    	//System.out.println("NAME?" + pet.getCommandSenderName() + "/" + pet.getCustomNameTag() + "/test" );
    	//System.out.println("NAME????" + pet.getCustomNameTag().length());
    	if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase("") && pet.getCustomNameTag().length() > 0)
    	{
    		//カスタム無しならnullになる
    		petName = pet.getCustomNameTag();
    	}else
    	{
    		petName = pet.getCommandSenderName();
    	}

        String sName = I18n.format("gui.pet.status.name", new Object[]{petName});

    	this.fontRendererObj.drawString(sName, k + 10, l + 6, 4210752);
    	*/
    }
}