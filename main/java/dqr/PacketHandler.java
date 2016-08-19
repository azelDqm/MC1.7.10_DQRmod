package dqr;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import dqr.packetMessage.MessageClientCleatSlotItem;
import dqr.packetMessage.MessageClientCleatSlotItemHandler;
import dqr.packetMessage.MessageClientPetEntityData;
import dqr.packetMessage.MessageClientPetEntityDataHandler;
import dqr.packetMessage.MessageClientSound;
import dqr.packetMessage.MessageClientSoundHandler;
import dqr.packetMessage.MessageServerBookWrite;
import dqr.packetMessage.MessageServerBookWriteHandler;
import dqr.packetMessage.MessageServerGuiId;
import dqr.packetMessage.MessageServerGuiIdHandler;
import dqr.packetMessage.MessageServerJobChange;
import dqr.packetMessage.MessageServerJobChangeHandler;
import dqr.packetMessage.MessageServerMGToolMode;
import dqr.packetMessage.MessageServerMGToolModeHandler;
import dqr.packetMessage.MessageServerSkillWeapon;
import dqr.packetMessage.MessageServerSkillWeaponHandler;
import dqr.playerData.MessagePlayerProperties;
import dqr.playerData.MessagePlayerProperties2;
import dqr.playerData.MessagePlayerProperties3;
import dqr.playerData.MessagePlayerPropertiesHandler;
import dqr.playerData.MessagePlayerPropertiesHandler2;
import dqr.playerData.MessagePlayerPropertiesHandler3;

public class PacketHandler {
    /*MOD固有のSimpleNetworkWrapperを取得。
    * 文字列は他のMODと被らないようにMOD_IDを指定しておくと良い*/
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("dqm_playerdata");

    public static void init() {
        /*Messageクラスの登録。
        * 第一引数：IMessageHandlerクラス
        * 第二引数：送るMessageクラス
        * 第三引数：登録番号。255個まで
        * 第四引数：ClientとServerのどちらに送るか。送り先*/
        INSTANCE.registerMessage(MessagePlayerPropertiesHandler.class, MessagePlayerProperties.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientSoundHandler.class, MessageClientSound.class, 1, Side.CLIENT);
        INSTANCE.registerMessage(MessagePlayerPropertiesHandler2.class, MessagePlayerProperties2.class, 2, Side.CLIENT);
        INSTANCE.registerMessage(MessagePlayerPropertiesHandler3.class, MessagePlayerProperties3.class, 3, Side.CLIENT);
        INSTANCE.registerMessage(MessageServerJobChangeHandler.class, MessageServerJobChange.class, 4, Side.SERVER);

        INSTANCE.registerMessage(MessageServerGuiIdHandler.class, MessageServerGuiId.class, 5, Side.SERVER);
        INSTANCE.registerMessage(MessageServerMGToolModeHandler.class, MessageServerMGToolMode.class, 6, Side.SERVER);
        INSTANCE.registerMessage(MessageClientCleatSlotItemHandler.class, MessageClientCleatSlotItem.class, 7, Side.CLIENT);
        INSTANCE.registerMessage(MessageServerBookWriteHandler.class, MessageServerBookWrite.class, 8, Side.SERVER);

        INSTANCE.registerMessage(MessageServerSkillWeaponHandler.class, MessageServerSkillWeapon.class, 9, Side.SERVER);
        INSTANCE.registerMessage(MessageClientPetEntityDataHandler.class, MessageClientPetEntityData.class, 10, Side.CLIENT);

    }
}
