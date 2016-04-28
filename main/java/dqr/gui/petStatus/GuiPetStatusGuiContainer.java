package dqr.gui.petStatus;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.entity.petEntity.DqmPetBase;
import dqr.gui.petStatus.tab.PetStatusTabs;
import dqr.gui.petStatus.tab.TabManager;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiPetStatusGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/petStatus.png");
    private int page = 0;
    private EntityPlayer ep;
    //private DqmPetBase pet;

    public GuiPetStatusGuiContainer(EntityPlayer player)
    {

        super(new GuiPetStatusContainer(player));
        this.ep = player;
        //pet = (DqmPetBase)ExtendedPlayerProperties3.get(player).getStatusPet();

        this.ySize = 166;

    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
    	//System.out.println("TEST2");
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;


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
        this.buttonList.clear();

        super.initGui();

        int cornerX = this.guiLeft;

        int cornerY = this.guiTop;

        //DqmPetBase pet = ExtendedPlayerProperties3.get(this.mc.thePlayer).getStatusPet();
        NBTTagCompound petData = ExtendedPlayerProperties3.get(this.mc.thePlayer).getPetStatudData();

        if(petData != null)
        {
        	//System.out.println("TEST1:" + this.mc.thePlayer.getUniqueID().toString());
        	//System.out.println("TEST2:" + petData.getString("OwnerUUID"));
            if(petData.getString("OwnerUUID").equalsIgnoreCase(this.mc.thePlayer.getUniqueID().toString()) ||
               petData.getBoolean("opflg"))
            {
            	TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PetStatusTabs.tabPetStatus,false);
            }
        	/*
            System.out.println("TEST1:" + this.ep.getUniqueID().toString());
            System.out.println("TEST2:" + petData.getString("OwnerUUID"));
            //System.out.println("TEST2:" + pet.ownerUUID);
            System.out.println("TEST3:" + this.mc.thePlayer.getUniqueID().toString());
        	System.out.println(petData.getString("OwnerName"));
        	*/
        }

        /*
        System.out.println("TEST1:" + this.ep.getUniqueID().toString());
        System.out.println("TEST2:" + petData.getString("OwnerUUID"));
        //System.out.println("TEST2:" + pet.ownerUUID);
        System.out.println("TEST3:" + this.mc.thePlayer.getUniqueID().toString());
        */
        //TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PlayerTabs.ss,false);
        /*
        System.out.println("TEST4:" + pet.getOwner().getUniqueID());
        */
        /*
        if(pet.ownerUUID == this.mc.thePlayer.getUniqueID().toString())
        {
        	TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PetStatusTabs.tabPetStatus,false);
        }
        */

    }


    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

    	//System.out.println("TEST");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderHelper.enableGUIStandardItemLighting();
        //RenderHelper.enableStandardItemLighting();
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);


        NBTTagCompound petData = ExtendedPlayerProperties3.get(this.mc.thePlayer).getPetStatudData();
        DqmPetBase pet = ExtendedPlayerProperties3.get(this.mc.thePlayer).getStatusPet();


        if(pet != null && petData != null)
        {
        	String petName = "";

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

        	int petJob = petData.getInteger("Job");
        	int petJobLv = petData.getInteger("JobLv_" + petJob);
        	int petJobExp = petData.getInteger("JobExp_" + petJob);
        	int petMP = petData.getInteger("MP");
        	int petMaxMP = petData.getInteger("MaxMP");
        	int petKougeki = petData.getInteger("Kougeki");
        	int petTikara = petData.getInteger("Tikara");
        	int petBougyo = petData.getInteger("Bougyo");
        	int petMikawasi = petData.getInteger("Mikawasi");
        	int petMaryoku = petData.getInteger("Maryoku");
        	int petKasikosa = petData.getInteger("Kasikosa");
        	String OwnerName = petData.getString("OwnerName");

            String sName = I18n.format("gui.pet.status.name", new Object[]{petName});
            String ownerName = I18n.format("gui.pet.status.owner", new Object[]{OwnerName});
            String sEXP = I18n.format("gui.pet.status.EXP", new Object[]{petJobLv, petJobExp,DQR.exp.getNextExpPet2(petJobLv, pet)});
            String sHP = I18n.format("gui.pet.status.HP", new Object[]{(int)(pet.getHealth()), (int)(pet.getMaxHealth())});
            String sMP = I18n.format("gui.pet.status.MP", new Object[]{petMP, petMaxMP});
            String sAttack = I18n.format("gui.pet.status.attack", new Object[]{petKougeki, petTikara});
            String sGurd = I18n.format("gui.pet.status.gurd", new Object[]{petBougyo, petMikawasi});
            String sMagic = I18n.format("gui.pet.status.magic", new Object[]{petMaryoku, petKasikosa});
            String PetTypeName = I18n.format("entity.DQMIIINext." + pet.type.getPetname() + ".name", new Object[]{});
            String PetType = I18n.format("gui.pet.status.type", new Object[]{PetTypeName});

        	this.fontRendererObj.drawString(sName, x2 + 10, y + 6, 4210752);
        	this.fontRendererObj.drawStringWithShadow(sEXP, x2 + 10, y + 17, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(PetType, x2 + 10, y + 26, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(ownerName, x2 + 10, y + 35, 0xffffffff);

        	this.fontRendererObj.drawStringWithShadow(sHP, x2 + 10, y + 47, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(sMP, x2 + 10, y + 56, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(sAttack, x2 + 84, y + 47, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(sGurd, x2 + 84, y + 56, 0xffffffff);
        	this.fontRendererObj.drawStringWithShadow(sMagic, x2 + 84, y + 65, 0xffffffff);

        	//func_147046_a(k + 51, l + 86, 30, (float)(k + 51) - this.xSize, (float)(l + 75 - 50) - this.ySize, pet);
        	//this.fontRendererObj.drawString(pet.getCommandSenderName(), x2 + 63, y + 9, 0xffffffff);
        	//this.fontRendererObj.drawStringWithShadow("TEST2TEST2", x2 + 63 , y + 18, 0xffffffff);
        	//this.fontRendererObj.drawString(pet.getOwner().getCommandSenderName(), x2 + 63, y + 27, 0xffffffff);
        }else
        {
        	this.fontRendererObj.drawString("対象未指定", x2 + 10, y + 17, 0xffffffff);


        }

    }


    public static void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_)
    {
    	/*
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
        GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        EntityLiving elv = (EntityLiving) p_147046_5_;
        float f2 = elv.renderYawOffset;
        float f3 = elv.rotationYaw;
        float f4 = elv.rotationPitch;
        float f5 = elv.prevRotationYawHead;
        float f6 = elv.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        elv.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
        elv.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
        elv.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
        elv.rotationYawHead = elv.rotationYaw;
        elv.prevRotationYawHead = elv.rotationYaw;
        GL11.glTranslatef(0.0F, elv.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(elv, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        elv.renderYawOffset = f2;
        elv.rotationYaw = f3;
        elv.rotationPitch = f4;
        elv.prevRotationYawHead = f5;
        elv.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
		*/
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
