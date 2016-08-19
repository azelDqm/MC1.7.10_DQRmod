package dqr.keyHandler;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientKeyBindCore {
	public static final KeyBinding keyGuiPositionMode = new KeyBinding("key.setting.ModeChange", Keyboard.KEY_BACKSLASH, "DQMIIImod");
	public static final KeyBinding keyGuiPositionSpeed = new KeyBinding("key.setting.ChangeSpeed", Keyboard.KEY_APOSTROPHE, "DQMIIImod");
	public static final KeyBinding keyGuiPositionUP = new KeyBinding("key.setting.GuiUP", Keyboard.KEY_UP, "DQMIIImod");
	public static final KeyBinding keyGuiPositionDOWN = new KeyBinding("key.setting.GuiDOWN", Keyboard.KEY_DOWN, "DQMIIImod");
	public static final KeyBinding keyGuiPositionLEFT = new KeyBinding("key.setting.GuiLEFT", Keyboard.KEY_LEFT, "DQMIIImod");
	public static final KeyBinding keyGuiPositionRIGHT = new KeyBinding("key.setting.GuiRIGHT", Keyboard.KEY_RIGHT, "DQMIIImod");

	public static final KeyBinding keyGuiPlayerData = new KeyBinding("key.setting.GuiPlayerDataVis", Keyboard.KEY_Y, "DQMIIImod");
	public static final KeyBinding keyGuiPlayerStatus = new KeyBinding("key.setting.GuiPlayerStatusVis", Keyboard.KEY_U, "DQMIIImod");
	public static final KeyBinding keyGuiLog = new KeyBinding("key.setting.GuiLogVis", Keyboard.KEY_H, "DQMIIImod");
	public static final KeyBinding keyGuiArmorStatus = new KeyBinding("key.setting.GuiArmorStatusVis", Keyboard.KEY_J, "DQMIIImod");
	public static final KeyBinding keyGuiSubpoints = new KeyBinding("key.setting.GuiSubpointsVis", Keyboard.KEY_I, "DQMIIImod");
	public static final KeyBinding keyGuiBuffBar = new KeyBinding("key.setting.GuiBuffBar", Keyboard.KEY_K, "DQMIIImod");

	public static final KeyBinding keyMagicToolMode = new KeyBinding("key.setting.magictoolMode", Keyboard.KEY_R, "DQMIIImod");
	public static final KeyBinding keyOokinaFukuro = new KeyBinding("key.setting.ookinaFukuroOpen", Keyboard.KEY_L, "DQMIIImod");

	public static final KeyBinding keyShieldUse = new KeyBinding("key.setting.shieldUse", Keyboard.KEY_Z, "DQMIIImod");
	public static final KeyBinding keyGuiParty = new KeyBinding("key.setting.GuiPartyVis", Keyboard.KEY_O, "DQMIIImod");

	public static final KeyBinding keyGuiPartyPlus = new KeyBinding("key.setting.GuiPartyLinePlus", Keyboard.KEY_ADD, "DQMIIImod");
	public static final KeyBinding keyGuiPartyMinus = new KeyBinding("key.setting.GuiPartyLineMinus", Keyboard.KEY_SUBTRACT, "DQMIIImod");

	public ClientKeyBindCore()
	{
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		FMLCommonHandler.instance().bus().register(new KeyInputHandler2());

		ClientRegistry.registerKeyBinding(keyGuiPositionMode);
		ClientRegistry.registerKeyBinding(keyGuiPositionSpeed);
		ClientRegistry.registerKeyBinding(keyGuiPositionUP);
		ClientRegistry.registerKeyBinding(keyGuiPositionDOWN);
		ClientRegistry.registerKeyBinding(keyGuiPositionLEFT);
		ClientRegistry.registerKeyBinding(keyGuiPositionRIGHT);

		ClientRegistry.registerKeyBinding(keyGuiPlayerData);
		ClientRegistry.registerKeyBinding(keyGuiPlayerStatus);
		ClientRegistry.registerKeyBinding(keyGuiLog);
		ClientRegistry.registerKeyBinding(keyGuiArmorStatus);
		ClientRegistry.registerKeyBinding(keyGuiSubpoints);
		ClientRegistry.registerKeyBinding(keyGuiBuffBar);

		ClientRegistry.registerKeyBinding(keyMagicToolMode);
		ClientRegistry.registerKeyBinding(keyOokinaFukuro);

		ClientRegistry.registerKeyBinding(keyShieldUse);
		ClientRegistry.registerKeyBinding(keyGuiParty);

		ClientRegistry.registerKeyBinding(keyGuiPartyPlus);
		ClientRegistry.registerKeyBinding(keyGuiPartyMinus);
	}
}
