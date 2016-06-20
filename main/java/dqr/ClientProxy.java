package dqr;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import tconstruct.client.tabs.InventoryTabVanilla;
import tconstruct.client.tabs.TabRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.IGuiHandler;
import dqr.addons.mceconomy2.DqrEntityNPCBankMP;
import dqr.addons.mceconomy2.DqrRenderNPCBankMP;
import dqr.api.Items.DQWeapons;
import dqr.blocks.BlockRenderingRegister;
import dqr.entity.magicEntity.MagicRegister;
import dqr.entity.magicEntity.MagicRenderingRegister;
import dqr.entity.mobEntity.MobRegister;
import dqr.entity.mobEntity.MobRenderingRegister;
import dqr.entity.mobEntity.MobSpawnRegister;
import dqr.entity.npcEntity.NPCRenderingRegister;
import dqr.entity.petEntity.PetRegister;
import dqr.entity.petEntity.PetRenderingRegister;
import dqr.entity.throwingEntity.ThrowingRegister;
import dqr.entity.throwingEntity.ThrowingRenderingRegister;
import dqr.entity.villagerEntity.DqmVillagerSkinRegister;
import dqr.functions.FuncEntityRenderExtension;
import dqr.gui.farmBook.GuiFarmBookGuiContainer;
import dqr.gui.medalKing.tab.MedalKingTabs;
import dqr.gui.petStatus.tab.PetStatusTabs;
import dqr.gui.playerHUD.GuiBuffBar;
import dqr.gui.playerHUD.GuiLogger;
import dqr.gui.playerHUD.GuiPlayerArmorStatus;
import dqr.gui.playerHUD.GuiPlayerData;
import dqr.gui.playerHUD.GuiPlayerStatus;
import dqr.gui.playerHUD.GuiPlayerSubpoint;
import dqr.gui.playerHUD.GuiPositionMode;
import dqr.gui.subEquip.TabPlayerSubEquip;
import dqr.handler.ChatReceivedEventHandler;
import dqr.handler.RenderGameOverlayHandler;
import dqr.handler.client.RenderEntityHandler;
import dqr.handler.client.RenderPlayerHandler;
import dqr.items.render.ItemRenderBow;
import dqr.keyHandler.ClientKeyBindCore;


public class ClientProxy extends CommonProxy implements IGuiHandler
{
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == DQR.conf.GuiID_FarmBook) {
            return new GuiFarmBookGuiContainer(x, y, z);
        }
        return null;
    }

	@Override
	public File getDir()
	{
		return Minecraft.getMinecraft().mcDataDir;
	}

	public Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}

	@Override
    public void registerClientInfo() {
    }

    public void registers(){
    	new MobRegister();
    	new MobSpawnRegister();
    	new MobRenderingRegister();
    	new BlockRenderingRegister();
    	new DqmVillagerSkinRegister();
    	new NPCRenderingRegister();
    	new MagicRegister();
    	new MagicRenderingRegister();
    	new ThrowingRegister();
    	new ThrowingRenderingRegister();

    	new PetRegister();
    	new PetRenderingRegister();


		DQR.entityRenderHook = new FuncEntityRenderExtension(Minecraft.getMinecraft());
		MinecraftForge.EVENT_BUS.register(new RenderEntityHandler(Minecraft.getMinecraft()));
    }

    @Override
    public EntityPlayer getEntityPlayerInstance() {
    	return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void registerGUI()
    {
    	//FMLCommonHandler.instance().bus().register(new PlayerStatusGui());

    	MedalKingTabs.initRecipes();
    	PetStatusTabs.initRecipes();

    	MinecraftForge.EVENT_BUS.register(new GuiBuffBar(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiLogger(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiPlayerData(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiPlayerStatus(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiPlayerSubpoint(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiPositionMode(Minecraft.getMinecraft()));
    	MinecraftForge.EVENT_BUS.register(new GuiPlayerArmorStatus(Minecraft.getMinecraft()));

    	MinecraftForge.EVENT_BUS.register(new RenderGameOverlayHandler());

    	MinecraftForge.EVENT_BUS.register(new ChatReceivedEventHandler());
    	DQR.CLKeyBind = new ClientKeyBindCore();

    	MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler(Minecraft.getMinecraft()));

    	//DQR.playerRenderHook = new FuncRenderPlayerHook();
    	//MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler2());

    	registerInventoryTabs();
    	MinecraftForge.EVENT_BUS.register(new TabRegistry());
    }

	public int getNewRenderType()
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
    public void registersItemRender(){
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");



		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemSyotobou, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemKaryuudonoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemKazekirinoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemYuuwakunoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemKeironnoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemMugennoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemJigokunoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemBigbougan, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemOdinbou, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemDaitensinoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemSefiramunoyumi, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(DQWeapons.itemSefiramunoyumi2, new ItemRenderBow());

		//MinecraftForgeClient.registerItemRenderer(DQMagicTools.itemMagicToolSet, new ItemRenderMGToolSet());

		//MinecraftForgeClient.registerItemRenderer(DQWeapons.itemSinken, new ItemRenderBow());
    }

	public void registerMCEconomy2Addon()
	{
		RenderingRegistry.registerEntityRenderingHandler(DqrEntityNPCBankMP.class, new DqrRenderNPCBankMP());
	}


    public static void registerInventoryTabs()
    {
        if (!Loader.isModLoaded("TConstruct") && TabRegistry.getTabList().size() < 1)
        {
            TabRegistry.registerTab(new InventoryTabVanilla());
        }

        TabRegistry.registerTab(new TabPlayerSubEquip());
    }
}
